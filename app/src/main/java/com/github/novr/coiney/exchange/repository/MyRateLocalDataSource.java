package com.github.novr.coiney.exchange.repository;

import com.github.novr.coiney.exchange.pref.MyPreferencesClient;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by komiya on 2017/09/10.
 */

public class MyRateLocalDataSource implements MyRateDataSource {

    private final MyPreferencesClient client;

    @Inject
    public MyRateLocalDataSource(MyPreferencesClient client) {
        this.client = client;
    }

    @Override
    public Single<String> getSelected() {
        return client.getSelected();
    }

    @Override
    public Completable updateSelected(String name) {
        return client.updateSelected(name);
    }
}
