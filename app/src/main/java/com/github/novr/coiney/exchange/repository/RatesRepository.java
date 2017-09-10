package com.github.novr.coiney.exchange.repository;

import com.github.novr.coiney.exchange.model.Rate;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

/**
 * Created by komiya on 2017/09/10.
 */
@Singleton
public class RatesRepository implements RatesDataSource {

    private final RatesDataSource ratesDataSource;

    @Inject
    public RatesRepository(RatesDataSource ratesDataSource) {
        this.ratesDataSource =ratesDataSource;
    }

    @Override
    public Single<Map<String, List<Rate>>> getRates() {
        return ratesDataSource.getRates();
    }

}
