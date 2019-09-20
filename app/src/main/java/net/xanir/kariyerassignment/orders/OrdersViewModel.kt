package net.xanir.kariyerassignment.orders

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.xanir.kariyerassignment.restApi.APIClient
import net.xanir.kariyerassignment.restApi.responses.MainResponse

class OrdersViewModel : ViewModel(){

    var productList = MutableLiveData<ArrayList<MainResponse>>()
    init {
        viewModelScope.launch {
            val response = APIClient.getServices().productList()
            if(response.isSuccessful){
                productList.value = response.body()
            }
        }
    }
}
