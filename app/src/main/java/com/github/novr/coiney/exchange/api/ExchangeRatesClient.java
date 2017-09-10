package com.github.novr.coiney.exchange.api;

import com.github.novr.coiney.exchange.api.service.ExchangeRatesApi;
import com.github.novr.coiney.exchange.model.Rate;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created by komiya on 2017/09/10.
 */

@Singleton
public class ExchangeRatesClient {
    private final ExchangeRatesApi exchangeRatesService;

    @Inject
    public ExchangeRatesClient(ExchangeRatesApi exchangeRatesService) {
        this.exchangeRatesService = exchangeRatesService;
    }

    public Single<Map<String,List<Rate>>> getRates() {
        return exchangeRatesService.getRates();
    }
}
