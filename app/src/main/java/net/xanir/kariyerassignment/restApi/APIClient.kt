package net.xanir.kariyerassignment.restApi

import com.google.gson.Gson

import net.xanir.kariyerassignment.BuildConfig

import java.util.concurrent.TimeUnit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Umur Kaya on 18-Sep-19.
 */
object APIClient {

    private const val SERVER_BASE_URL = "http://kariyertechchallenge.mockable.io"
    private var retrofit: Retrofit? = null
    private var gson: Gson? = null
    private var services: APIServices? = null

    fun getGson(): Gson {
        if (gson == null) {
            gson = Gson()
        }
        return gson!!
    }

    @Synchronized
    fun getServices(): APIServices {
        if (retrofit == null) {
            val httpBuilder = OkHttpClient.Builder()
            httpBuilder.readTimeout(10, TimeUnit.SECONDS)
            httpBuilder.writeTimeout(30, TimeUnit.SECONDS)
            httpBuilder.addInterceptor { chain ->
                val requestBuilder = chain.request().newBuilder()
                requestBuilder.addHeader("Platform-Information", "Android")
                requestBuilder.addHeader("Application-Version", BuildConfig.VERSION_NAME)
                chain.proceed(requestBuilder.build())
            }
            retrofit = Retrofit.Builder()
                    .baseUrl(SERVER_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(getGson()))
                    .client(httpBuilder.build())
                    .build()
        }
        if (services == null) {
            services = retrofit!!.create(APIServices::class.java)
        }
        return services!!
    }
}
