package com.nurgulmantarci.mvpdesignpattern.Data.network;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL="http://terminalcommands.herokuapp.com/api/";

    private static Retrofit retrofit=null;

    public static Retrofit getClient(){
        if(retrofit==null){
            final OkHttpClient okHttpClient=new OkHttpClient.Builder()
                    .readTimeout(0, TimeUnit.SECONDS)
                    .connectTimeout(30,TimeUnit.SECONDS)
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request request=chain.request().newBuilder().build();
                            return chain.proceed(request);
                        }
                    }).build();

            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
