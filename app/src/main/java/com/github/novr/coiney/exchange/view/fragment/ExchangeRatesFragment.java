package com.github.novr.coiney.exchange.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.novr.coiney.exchange.databinding.FragmentExchangeRateBinding;
import com.github.novr.coiney.exchange.viewmodel.ExchangeRatesViewModel;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class ExchangeRatesFragment extends BaseFragment {

    public static final String TAG = ExchangeRatesFragment.class.getSimpleName();

    @Inject
    ExchangeRatesViewModel viewModel;

    @Inject
    CompositeDisposable compositeDisposable;

    private FragmentExchangeRateBinding binding;

    public ExchangeRatesFragment() {
        // Required empty public constructor
    }

    public static ExchangeRatesFragment newInstance() {
        return new ExchangeRatesFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        getComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentExchangeRateBinding.inflate(inflater, container, false);
        binding.setViewModel(viewModel);

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        showRateNames();
    }

    @Override
    public void onStop() {
        super.onStop();
        compositeDisposable.clear();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        viewModel.destroy();
        compositeDisposable.dispose();
    }

    private void showRateNames() {
        Disposable disposable = null;
    }
}
