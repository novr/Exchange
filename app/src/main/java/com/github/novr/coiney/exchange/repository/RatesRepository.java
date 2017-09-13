package com.github.novr.coiney.exchange.repository;

import android.support.annotation.NonNull;

import com.github.novr.coiney.exchange.model.ExchangeRate;
import com.github.novr.coiney.exchange.model.Rate;

import org.joda.time.DateTime;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created by komiya on 2017/09/10.
 */
@Singleton
public class RatesRepository {

    private final RatesRemoteDataSource ratesDataSource;

    private ExchangeRate cached;

    @Inject
    public RatesRepository(RatesRemoteDataSource ratesDataSource) {
        this.ratesDataSource = ratesDataSource;
    }

    public Single<ExchangeRate> getExchangeRate(boolean isForce) {
        if (isForce || !hasCacheRates()) {
            return getRatesFromRemote();
        }
        return getRatesFromCache();
    }

    private Single<ExchangeRate> getRatesFromCache() {
        return Single.just(cached);
    }

    private Single<ExchangeRate> getRatesFromRemote() {
        return ratesDataSource.getRates()
                .map(this::createExchangeRates)
                .doOnSuccess(this::refreshCache);
    }

    private ExchangeRate createExchangeRates(@NonNull Map<String, List<Rate>> rates) {
        ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.maps = rates;
        exchangeRate.lastUpdate = DateTime.now();
        return exchangeRate;
    }

    private void refreshCache(ExchangeRate exchangeRate) {
        cached = exchangeRate;
    }

    private boolean hasCacheRates() {
        return cached != null;
    }
}
