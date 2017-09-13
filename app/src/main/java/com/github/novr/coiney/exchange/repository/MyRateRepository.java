package com.github.novr.coiney.exchange.repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by komiya on 2017/09/10.
 */
@Singleton
public class MyRateRepository {

    private final MyRateLocalDataSource myRateDataSource;

    @Inject
    public MyRateRepository(MyRateLocalDataSource myRateDataSource) {
        this.myRateDataSource = myRateDataSource;
    }

    public Single<String> getSelected() {
        return myRateDataSource.getSelected();
    }

    public Completable updateSelected(String name) {
        return myRateDataSource.updateSelected(name);
    }
}
