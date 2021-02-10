package com.mybanana.everynews.di.modules;

import com.mybanana.everynews.api.NewsApi;
import com.squareup.moshi.Moshi;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
public class RemoteModule {
    @Provides
    @Singleton
    public Interceptor provideInterceptor(){
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                HttpUrl originalHttpUrl = original.url();

                HttpUrl url = originalHttpUrl.newBuilder()
                        .addQueryParameter("apiKey", "9af25dbbf46c4615b6c53fbdcf226425")
                        .build();

                Request.Builder requestBuilder = original.newBuilder().url(url);

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(Interceptor interceptor){
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor).build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient httpClient){
        return new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .client(httpClient)
                .addConverterFactory(MoshiConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public NewsApi provideNewsApi(Retrofit retrofit){
        return retrofit.create(NewsApi.class);
    }
}
