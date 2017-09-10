package com.github.novr.coiney.exchange.api.service;

import com.github.novr.coiney.exchange.model.Rate;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import retrofit2.Retrofit;

/**
 * Created by komiya on 2017/09/10.
 */
@Singleton
public class ExchangeRatesService {
    private ExchangeRatesApi api;

    @Inject
    public ExchangeRatesService(Retrofit retrofit) {
        api = retrofit.create(ExchangeRatesApi.class);
    }

    public Single<Map<String, List<Rate>>> getRates() {
        return api.getRates();
    }
}
