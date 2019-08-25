package jask.smarttraffic.com.api;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class RetrofitHelper {
    private static String language = "ja";
        private ApiService apiService;
    private static RetrofitHelper retrofitHelper = null;

    public static RetrofitHelper getInstance() {
        if (retrofitHelper == null) {
            retrofitHelper = new RetrofitHelper();
        }
        return retrofitHelper;

    }

    private final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request().newBuilder()
                            .addHeader("Accept-Language", language).build();
                    return chain.proceed(request);
                }
            })
            .readTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(1, TimeUnit.MINUTES)
            .build();

    public ApiService getAuthService() {
        if (apiService == null) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.137.210:8000/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
            apiService = retrofit.create(ApiService.class);
        }
        return apiService;
    }


}
