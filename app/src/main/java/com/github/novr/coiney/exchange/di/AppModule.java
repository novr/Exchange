package com.github.novr.coiney.exchange.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.github.novr.coiney.exchange.BuildConfig;
import com.github.novr.coiney.exchange.api.RequestInterceptor;
import com.github.novr.coiney.exchange.api.service.ExchangeRatesService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ts-nobuhisa.komiya on 2017/09/12.
 */

@Module
public class AppModule {
    static final String SHARED_PREF_NAME = "preferences";

    private Context context;

    public AppModule(Application app) {
        context = app;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    public SharedPreferences provideSharedPreferences(Context context) {
        return context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    @Provides
    public CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    private static Gson createGson() {
        return new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
    }

    @Provides
    public Interceptor provideRequestInterceptor(RequestInterceptor interceptor) {
        return interceptor;
    }

    @Singleton
    @Provides
    public ExchangeRatesService provideExchangeRatesService(OkHttpClient client) {
        return new Retrofit.Builder().client(client)
                .baseUrl(BuildConfig.API_ROOT)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(createGson()))
                .build()
                .create(ExchangeRatesService.class);
    }
}