package com.wll.examplemvvm.application;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.wll.examplemvvm.R;
import com.wll.examplemvvm.customview.x5webview.X5InitService;
import com.wll.examplemvvm.utils.PreferenceUtil;

/**
 * Created by leo
 * on 2019/10/15.
 */
public class MyApplication extends Application {

    //static 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout layout) {
                return new ClassicsHeader(context).setPrimaryColorId(R.color.white).setAccentColorId(R.color.status_background);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @NonNull
            @Override
            public RefreshFooter createRefreshFooter(@NonNull Context context, @NonNull RefreshLayout layout) {
                return new ClassicsFooter(context).setPrimaryColorId(R.color.white).setAccentColorId(R.color.status_background);
            }
        });

    }


    private static MyApplication context;
//    private static User loginUser;

    @Override
    public void onCreate() {
        super.onCreate();
        //捕获崩溃日志，位置在外部存储的LianSou
//        CrashHandler crashHandler = CrashHandler.getInstance();
//        crashHandler.init(getApplicationContext());
        context = this;
        initX5web();
    }

//    public static User getLoginUser() {
//        if (loginUser == null) {
//            loginUser = PreferenceUtil.getByClass("user", User.class);
//        }
//        return loginUser;
//    }
//
//    public static void updateUser(User user) {
//        PreferenceUtil.putByClass("user", user);
//        loginUser = user;
//    }
//
//    public static void logOut() {
//        loginUser = null;
//        PreferenceUtil.clearByClass(User.class);
//    }


    private void initX5web() {
        Intent intent = new Intent(this, X5InitService.class);
        startService(intent);
    }

    public static Context getContext() {
        return context;
    }
}
