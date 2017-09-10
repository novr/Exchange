package com.github.novr.coiney.exchange.api.service;

import com.github.novr.coiney.exchange.model.Rate;

import java.util.List;
import java.util.Map;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by komiya on 2017/09/10.
 */

public interface ExchangeRatesApi {

    @GET("exchange_rates")
    Single<Map<String,List<Rate>>> getRates();

}
