package com.nookdev.testmobox.model.network;

import com.nookdev.testmobox.model.network.api.CurrencyApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {
    public static final String ENDPOINT = "https://api.privatbank.ua/";
    private static ApiManager sInstance = new ApiManager();
    private Retrofit mRetrofit;

    private ApiManager(){
        initRetrofit();
    }

    private void initRetrofit(){
        if(mRetrofit!=null)
            return;

        mRetrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static CurrencyApi getCurrencyRatesCall(){
        return sInstance.mRetrofit.create(CurrencyApi.class);
    }
}
