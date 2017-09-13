package com.github.novr.coiney.exchange.api.service;

import java.util.Map;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by komiya on 2017/09/10.
 */

public interface ExchangeRatesService {

    @GET("exchange_rates")
    Single<Map<String, Map<String, String>>> getRates();

}
