package com.github.novr.coiney.exchange.di;

import android.support.v7.app.AppCompatActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ts-nobuhisa.komiya on 2017/09/12.
 */

@Module
public class ActivityModule {

    final AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    public AppCompatActivity activity() {
        return activity;
    }
}
