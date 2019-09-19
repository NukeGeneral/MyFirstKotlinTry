package net.xanir.kariyerassignment.restApi.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Umur Kaya on 18-Sep-19.
 */
class ProductDetail {

    @SerializedName("orderDetail")
    @Expose
    var orderDetail: String? = null
    @SerializedName("summaryPrice")
    @Expose
    var summaryPrice: Float? = null
}
