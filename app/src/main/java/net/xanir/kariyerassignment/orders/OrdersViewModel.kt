package net.xanir.kariyerassignment.orders

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

    fun findMonthFromInt(number : String) : String{
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.MONTH,Integer.valueOf(number))
        return String.format(Locale("tr"),"%tb",calendar)
    }

    fun determineColor(string: String) : Int {
        when(string){
            "Hazırlanıyor" -> return R.color.squareYellow
            "Yolda" -> return R.color.squareGreen
            "Onay Bekliyor" -> return R.color.colorAccent
            else -> return R.color.colorAccent
        }
    }

    fun determineDrawable(string: String) : Int{
        when(string){
            "Hazırlanıyor" -> return R.drawable.square_yellow
            "Yolda" -> return R.drawable.square_green
            "Onay Bekliyor" -> return R.drawable.square_red
            else -> return R.drawable.square_red
        }
    }
}
