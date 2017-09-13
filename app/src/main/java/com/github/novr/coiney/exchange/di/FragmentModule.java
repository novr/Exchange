package com.github.novr.coiney.exchange.di;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ts-nobuhisa.komiya on 2017/09/12.
 */

@Module
public class FragmentModule {
    final Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    public FragmentManager provideFragmentManager() {
        return fragment.getFragmentManager();
    }
}
