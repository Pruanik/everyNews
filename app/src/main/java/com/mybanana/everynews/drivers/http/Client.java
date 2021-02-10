package com.mybanana.everynews.drivers.http;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class Client {
    private static Retrofit restClient;
    private static String apiKey = "9af25dbbf46c4615b6c53fbdcf226425";

    public static Retrofit getClient(){
        if(restClient==null){
            OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        HttpUrl originalHttpUrl = original.url();

                        HttpUrl url = originalHttpUrl.newBuilder()
                                .addQueryParameter("apiKey", apiKey)
                                .build();

                        Request.Builder requestBuilder = original.newBuilder().url(url);

                        Request request = requestBuilder.build();
                        return chain.proceed(request);
                    }
                }).build();

            restClient = new Retrofit.Builder()
                    .baseUrl("https://newsapi.org/v2/")
                    .client(httpClient)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();
        }

        return restClient;
    }
}
