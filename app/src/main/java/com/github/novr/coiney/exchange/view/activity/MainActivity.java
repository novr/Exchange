package com.github.novr.coiney.exchange.view.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.github.novr.coiney.exchange.R;
import com.github.novr.coiney.exchange.databinding.ActivityMainBinding;
import com.github.novr.coiney.exchange.view.fragment.ExchangeRatesFragment;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;

    private Fragment ratesFragment;

    public static Intent createIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        getComponent().inject(this);
        initFragments(savedInstanceState);
    }

    private void initFragments(Bundle savedInstanceState) {
        final FragmentManager manager = getSupportFragmentManager();
        ratesFragment = manager.findFragmentByTag(ExchangeRatesFragment.TAG);

        if (ratesFragment == null) {
            ratesFragment = ExchangeRatesFragment.newInstance();
        }

        replaceFragment(ratesFragment, R.id.content_view);
    }

    private boolean switchFragment(@NonNull Fragment fragment, @NonNull String tag) {
        if (fragment.isAdded()) {
            return false;
        }

        final FragmentManager manager = getSupportFragmentManager();
        final FragmentTransaction ft = manager.beginTransaction();

        final Fragment currentFragment = manager.findFragmentById(R.id.content_view);
        if (currentFragment != null) {
            ft.detach(currentFragment);
        }
        if (fragment.isDetached()) {
            ft.attach(fragment);
        } else {
            ft.add(R.id.content_view, fragment, tag);
        }
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();

        // NOTE: When this method is called by user's continuous hitting at the same time,
        // transactions are queued, so necessary to reflect commit instantly before next transaction starts.
        manager.executePendingTransactions();

        return true;
    }

}
