package net.xanir.kariyerassignment.restApi;

import net.xanir.kariyerassignment.restApi.responses.MainResponse;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;

/**
 * Created by Umur Kaya on 18-Sep-19.
 */
public interface APIServices {
    @GET()
    Single<Response<MainResponse>> getProductList();
}
