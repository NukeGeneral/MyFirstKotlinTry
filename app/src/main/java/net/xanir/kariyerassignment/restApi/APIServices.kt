package net.xanir.kariyerassignment.restApi

import net.xanir.kariyerassignment.restApi.responses.MainResponse

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Umur Kaya on 18-Sep-19.
 */
interface APIServices {
    @GET("/")
    suspend fun productList(): Response<ArrayList<MainResponse>>
}
