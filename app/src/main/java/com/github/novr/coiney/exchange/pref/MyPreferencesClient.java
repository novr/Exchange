package com.github.novr.coiney.exchange.pref;

import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by komiya on 2017/09/10.
 */
@Singleton
public class MyPreferencesClient {
    private enum Key {selected}

    private final SharedPreferences sharedPreferences;

    @Inject
    public MyPreferencesClient(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public Single<String> getSelected() {
        return Single.create(e -> {
            e.onSuccess(sharedPreferences.getString(Key.selected.name(), null));
        });
    }

    public Completable updateSelected(String name) {
        return Completable.create(e -> {
            sharedPreferences.edit().putString(Key.selected.name(), name).apply();
            e.onComplete();
        });
    }
}
