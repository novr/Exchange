package com.github.novr.coiney.exchange.di;

import com.github.novr.coiney.exchange.MainApplication;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ts-nobuhisa.komiya on 2017/09/12.
 */

@Singleton
@Component(modules = {AppModule.class, AndroidModule.class, HttpClientModule.class})
public interface AppComponent {
    void inject(MainApplication application);

    ActivityComponent plus(ActivityModule module);
}
