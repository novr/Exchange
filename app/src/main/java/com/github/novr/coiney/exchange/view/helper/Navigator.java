package com.github.novr.coiney.exchange.view.helper;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.github.novr.coiney.exchange.di.scope.ActivityScope;

import javax.inject.Inject;

/**
 * Created by ts-nobuhisa.komiya on 2017/09/13.
 */

@ActivityScope
public class Navigator {
    private final Activity activity;

    @Inject
    public Navigator(AppCompatActivity activity) {
        this.activity = activity;
    }
}
