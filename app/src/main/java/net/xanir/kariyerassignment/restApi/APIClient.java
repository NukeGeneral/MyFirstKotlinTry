package net.xanir.kariyerassignment.restApi;

import com.google.gson.Gson;

import net.xanir.kariyerassignment.BuildConfig;

import java.util.concurrent.TimeUnit;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Umur Kaya on 18-Sep-19.
 */
public class APIClient {

    private static final String SERVER_BASE_URL = "http://kariyertechchallenge.mockable.io/";
    private static Retrofit retrofit;
    private static Gson gson;
    private static APIServices services;

    public static Gson getGson() {
        if(gson == null){
            gson = new Gson();
        }
        return gson;
    }

    public synchronized static APIServices getServices(){
        if(retrofit == null){
            OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();
            httpBuilder.readTimeout(10, TimeUnit.SECONDS);
            httpBuilder.writeTimeout(30,TimeUnit.SECONDS);
            httpBuilder.addInterceptor(chain -> {
                Request.Builder requestBuilder = chain.request().newBuilder();
                requestBuilder.addHeader("Platform-Information", "android");
                requestBuilder.addHeader("Application-Version", BuildConfig.VERSION_NAME);
                return chain.proceed(requestBuilder.build());
            });
            retrofit = new Retrofit.Builder()
                    .baseUrl(SERVER_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(getGson()))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(httpBuilder.build())
                    .build();
        }
        if(services == null){
            services = retrofit.create(APIServices.class);
        }
        return services;
    }
}
