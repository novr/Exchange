package com.github.novr.coiney.exchange.repository;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by komiya on 2017/09/10.
 */

public interface MyRateDataSource {
    Single<String> getSelected();
    Completable updateSelected(String name);
}
