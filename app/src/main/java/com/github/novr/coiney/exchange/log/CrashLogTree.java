package com.github.novr.coiney.exchange.log;

import android.util.Log;

import com.google.firebase.crash.FirebaseCrash;

import timber.log.Timber;

/**
 * Created by ts-nobuhisa.komiya on 2017/09/12.
 */

public class CrashLogTree extends Timber.Tree {
    @Override
    protected void log(int priority, String tag, String message, Throwable t) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            FirebaseCrash.log((priority == Log.DEBUG ? "[debug] " : "[verbose] ") + tag + ": " + message);
            return;
        }
        FirebaseCrash.logcat(priority, tag, message);
        if (t == null) {
            return;
        }
        if (priority == Log.ERROR || priority == Log.WARN) {
            FirebaseCrash.report(t);
        }
    }
}
