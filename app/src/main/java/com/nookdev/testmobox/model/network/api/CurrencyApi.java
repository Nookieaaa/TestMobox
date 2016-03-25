package com.nookdev.testmobox.model.network.api;


import com.nookdev.testmobox.model.pojo.ApiResponse;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface CurrencyApi {
    @GET("p24api/pubinfo?json&exchange&coursid=5")
    Observable<List<ApiResponse>> getRates();
}
