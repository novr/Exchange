package com.github.novr.coiney.exchange.viewmodel;

import com.github.novr.coiney.exchange.repository.MyRateRepository;
import com.github.novr.coiney.exchange.repository.RatesRepository;

import javax.inject.Inject;

/**
 * Created by komiya on 2017/09/10.
 */

public class RatesViewModel {
    private final RatesRepository ratesRepository;
    private final MyRateRepository myRateRepository;

    @Inject
    public RatesViewModel(RatesRepository ratesRepository,MyRateRepository myRateRepository) {
        this.ratesRepository =ratesRepository;
        this.myRateRepository = myRateRepository;
    }

}
