package com.github.novr.coiney.exchange.repository;

import com.github.novr.coiney.exchange.api.ExchangeRatesClient;
import com.github.novr.coiney.exchange.model.Rate;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by komiya on 2017/09/10.
 */

public class RatesRemoteDataSource implements RatesDataSource {

    private final ExchangeRatesClient client;

    @Inject
    public RatesRemoteDataSource(ExchangeRatesClient client) {
        this.client =client;
    }

    public Single<Map<String, List<Rate>>> getRates() {
        return client.getRates();
    }
}
