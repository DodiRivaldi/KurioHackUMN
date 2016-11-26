package developerkampus.kuriohackumn.api.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dodi Rivaldi on 26/11/2016.
 */

public class ApiService {
    public static final String BASE_URL = "https://hack.kurio.co.id/v1";
    public static final int BASE_LIMIT = 10;
    public static final int SUCCESS_RESPONSE = 200;

    private ApiService() {
    }
    private static Retrofit retrofit;
    public static Retrofit getRetrofit() {
        return retrofit;
    }
    public static void setRetrofit(Retrofit retrofit) {
        ApiService.retrofit = retrofit;
    }
    public static <S> S createService(Class<S> serviceClass) {
        final OkHttpClient okHttpClient =new OkHttpClient
                .Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient.interceptors().add(interceptor);
        okHttpClient.networkInterceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder().addHeader("Accept", "application/json").build();
                return chain.proceed(request);
            }
        });

        Gson gson = new GsonBuilder()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(serviceClass);
    }
}
