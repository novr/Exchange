package com.github.novr.coiney.exchange.viewmodel;

import android.databinding.BaseObservable;

import com.annimon.stream.Stream;
import com.github.novr.coiney.exchange.model.ExchangeRate;
import com.github.novr.coiney.exchange.model.Rate;
import com.github.novr.coiney.exchange.repository.MyRateRepository;
import com.github.novr.coiney.exchange.repository.RatesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by komiya on 2017/09/10.
 */

public class ExchangeRatesViewModel extends BaseObservable implements ViewModel {
    private final RatesRepository ratesRepository;
    private final MyRateRepository myRateRepository;

    private ExchangeRate exchangeRate;

    private List<String> names;
    private String selectedName;

    private List<Rate> rates;
    private String selectedRate;

    @Inject
    public ExchangeRatesViewModel(RatesRepository ratesRepository, MyRateRepository myRateRepository) {
        this.ratesRepository = ratesRepository;
        this.myRateRepository = myRateRepository;
    }

    @Override
    public void destroy() {
        // Do nothing
    }

    public Single<ExchangeRateViewModel> getExchangeRate(boolean isForce) {
        return Single.zip(
                ratesRepository.getExchangeRate(isForce),
                myRateRepository.getSelected(),
                (exchangeRate, selected) -> {
                    this.exchangeRate = exchangeRate;

                    names = Stream.of(exchangeRate.maps.keySet()).toList();

                    int pos = names.indexOf(names);
                    this.selectedName = names.get(pos == -1 ? 0 : pos);
                    this.rates = Stream.of(exchangeRate.maps.get(selectedName)).toList();

                    return new ExchangeRateViewModel(exchangeRate, selected);
                });
    }

    private List<Rate> extractRates(ExchangeRate exchangeRate, String name, List<String> names) {
        int pos = names.indexOf(name);
        this.selectedName = names.get(pos == -1 ? 0 : pos);
        return Stream.of(exchangeRate.maps.get(selectedName)).toList();
    }
}
