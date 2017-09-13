package com.github.novr.coiney.exchange.di;

import com.github.novr.coiney.exchange.di.scope.FragmentScope;
import com.github.novr.coiney.exchange.view.fragment.ExchangeRatesFragment;

import dagger.Subcomponent;

/**
 * Created by ts-nobuhisa.komiya on 2017/09/12.
 */

@FragmentScope
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {
    void inject(ExchangeRatesFragment fragment);
}
