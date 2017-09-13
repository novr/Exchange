package com.github.novr.coiney.exchange;

import android.app.Application;
import android.support.annotation.NonNull;

import com.github.novr.coiney.exchange.di.AndroidModule;
import com.github.novr.coiney.exchange.di.AppComponent;
import com.github.novr.coiney.exchange.di.AppModule;
import com.github.novr.coiney.exchange.di.DaggerAppComponent;
import com.github.novr.coiney.exchange.log.CrashLogTree;

import net.danlew.android.joda.JodaTimeAndroid;

import timber.log.Timber;

/**
 * Created by ts-nobuhisa.komiya on 2017/09/12.
 */

public class MainApplication extends Application {
    AppComponent appComponent;

    @NonNull
    public AppComponent getComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .androidModule(new AndroidModule(this))
                .build();

        appComponent.inject(this);

        Timber.plant(new CrashLogTree());
        JodaTimeAndroid.init(this);
    }
}
