package com.github.novr.coiney.exchange.di;

import com.github.novr.coiney.exchange.di.scope.ActivityScope;
import com.github.novr.coiney.exchange.view.activity.BaseActivity;

import dagger.Subcomponent;

/**
 * Created by ts-nobuhisa.komiya on 2017/09/12.
 */

@ActivityScope
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(BaseActivity activity);

    FragmentComponent plus(FragmentModule module);
}
