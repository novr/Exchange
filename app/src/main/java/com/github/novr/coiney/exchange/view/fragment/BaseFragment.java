package com.github.novr.coiney.exchange.view.fragment;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.github.novr.coiney.exchange.di.FragmentComponent;
import com.github.novr.coiney.exchange.di.FragmentModule;
import com.github.novr.coiney.exchange.view.activity.BaseActivity;

/**
 * Created by ts-nobuhisa.komiya on 2017/09/12.
 */

public abstract class BaseFragment extends Fragment {
    private FragmentComponent fragmentComponent;

    @NonNull
    public FragmentComponent getComponent() {
        if (fragmentComponent != null) {
            return fragmentComponent;
        }

        Activity activity = getActivity();
        if (activity instanceof BaseActivity) {
            fragmentComponent = ((BaseActivity) activity).getComponent().plus(new FragmentModule(this));
            return fragmentComponent;
        } else {
            throw new IllegalStateException(
                    "The activity of this fragment is not an instance of BaseActivity");
        }
    }
}
