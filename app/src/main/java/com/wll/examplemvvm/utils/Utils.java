package com.wll.examplemvvm.utils;

import android.content.Context;

import com.wll.examplemvvm.application.MyApplication;


/**
 * Created by leo
 * on 2019/11/13.
 */
public class Utils {
    private Utils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Context getApp() {
        return MyApplication.getContext();
    }
}
