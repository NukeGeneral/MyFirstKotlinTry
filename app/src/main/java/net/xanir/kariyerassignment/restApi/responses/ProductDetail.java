package net.xanir.kariyerassignment.restApi.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Umur Kaya on 18-Sep-19.
 */
public class ProductDetail {

    @SerializedName("orderDetail")
    @Expose
    private String orderDetail;
    @SerializedName("summaryPrice")
    @Expose
    private Float summaryPrice;

    public String getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Float getSummaryPrice() {
        return summaryPrice;
    }

    public void setSummaryPrice(Float summaryPrice) {
        this.summaryPrice = summaryPrice;
    }
}
