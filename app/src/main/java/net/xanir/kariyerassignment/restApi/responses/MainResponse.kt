package net.xanir.kariyerassignment.restApi.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Umur Kaya on 18-Sep-19.
 */
class MainResponse {

    @SerializedName("date")
    @Expose
    var date: String? = null
    @SerializedName("month")
    @Expose
    var month: String? = null
    @SerializedName("marketName")
    @Expose
    var marketName: String? = null
    @SerializedName("orderName")
    @Expose
    var orderName: String? = null
    @SerializedName("productPrice")
    @Expose
    var productPrice: Float? = null
    @SerializedName("productState")
    @Expose
    var productState: String? = null
    @SerializedName("productDetail")
    @Expose
    var productDetail: ProductDetail? = null
}
