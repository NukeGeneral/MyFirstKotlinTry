package net.xanir.kariyerassignment.orders

import androidx.annotation.IntegerRes
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.xanir.kariyerassignment.R
import net.xanir.kariyerassignment.restApi.APIClient
import net.xanir.kariyerassignment.restApi.responses.MainResponse
import java.util.*
import kotlin.collections.ArrayList




class OrdersViewModel : ViewModel(){

    var productList = MutableLiveData<ArrayList<MainResponse>>()

    fun loadData(){
        viewModelScope.launch {
            val response = APIClient.getServices().productList()
            if(response.isSuccessful){
                productList.value = response.body()
            }
        }
    }

    //Get name of month from given month number string
    fun findMonthFromInt(number : String) : String{
        val calendar = Calendar.getInstance()
        val value = Integer.valueOf(number)
        if (value <= 0 || value > 12){
            return ""
        }
        calendar.set(Calendar.MONTH,Integer.valueOf(number) - 1)
        return String.format(Locale("tr"),"%tb",calendar)
    }

    //Determine text color of order status
    fun determineColor(string: String) : Int {
        when(string){
            "Hazırlanıyor" -> return R.color.squareYellow
            "Yolda" -> return R.color.squareGreen
            "Onay Bekliyor" -> return R.color.colorAccent
            else -> return R.color.colorAccent
        }
    }

    //Determine drawable which is left side of order status
    fun determineDrawable(string: String) : Int{
        when(string){
            "Hazırlanıyor" -> return R.drawable.square_yellow
            "Yolda" -> return R.drawable.square_green
            "Onay Bekliyor" -> return R.drawable.square_red
            else -> return R.drawable.square_red
        }
    }
}
