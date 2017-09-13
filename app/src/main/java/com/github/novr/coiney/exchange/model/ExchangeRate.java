package com.github.novr.coiney.exchange.model;

import org.joda.time.DateTime;

import java.util.List;
import java.util.Map;

/**
 * Created by ts-nobuhisa.komiya on 2017/09/13.
 */

public class ExchangeRate {

    public DateTime lastUpdate;
    public Map<String, List<Rate>> maps;
}
