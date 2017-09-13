package com.github.novr.coiney.exchange.repository;

import com.github.novr.coiney.exchange.model.Rate;

import java.util.List;
import java.util.Map;

import io.reactivex.Single;

/**
 * Created by komiya on 2017/09/10.
 */

public interface RatesDataSource {
    Single<Map<String,List<Rate>>> getRates();
}
