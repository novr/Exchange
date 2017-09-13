package com.github.novr.coiney.exchange.viewmodel;

import android.databinding.BaseObservable;

import com.github.novr.coiney.exchange.model.ExchangeRate;

/**
 * Created by ts-nobuhisa.komiya on 2017/09/13.
 */

public class ExchangeRateViewModel extends BaseObservable implements ViewModel {

    @Override
    public void destroy() {
    }

    public ExchangeRateViewModel(ExchangeRate exchangeRate, String selected) {
    }
}
