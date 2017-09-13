package com.github.novr.coiney.exchange.api;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ts-nobuhisa.komiya on 2017/09/12.
 */

@Singleton
public class RequestInterceptor implements Interceptor {

    final ConnectivityManager connectivityManager;

    final Context context;

    @Inject
    public RequestInterceptor(Context context, ConnectivityManager connectivityManager) {
        this.context = context;
        this.connectivityManager = connectivityManager;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder r = chain.request().newBuilder();

        if (isConnected()) {
            int maxAge = 2 * 60;
            r.addHeader("cache-control", "public, max-age=" + maxAge);
        } else {
            int maxStale = 30 * 24 * 60 * 60; // 30 days
            r.addHeader("cache-control", "public, only-if-cached, max-stale=" + maxStale);
        }

        return chain.proceed(r.build());
    }

    protected boolean isConnected() {
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }
}
