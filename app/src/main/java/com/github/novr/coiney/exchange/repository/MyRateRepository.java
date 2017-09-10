package com.github.novr.coiney.exchange.repository;

import com.github.novr.coiney.exchange.model.Rate;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

/**
 * Created by komiya on 2017/09/10.
 */
@Singleton
public class MyRateRepository implements MyRateDataSource {

    private final MyRateDataSource myRateDataSource;

    @Inject
    public MyRateRepository(MyRateDataSource myRateDataSource) {
        this.myRateDataSource = myRateDataSource;
    }

    @Override
    public Maybe<String> getSelected() {
        return myRateDataSource.getSelected();
    }

    @Override
    public Completable updateSelected(String name) {
        return myRateDataSource.updateSelected(name);
    }
}
