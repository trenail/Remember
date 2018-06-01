package com.test.remember;

import android.app.Application;
import android.util.Log;

/**
 * Created by home on 2018/5/31.
 */

public class MyApplication extends Application {

    public static String GlobleValue;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("RememberLog", "MyApplication->onCreate()");

        GlobleValue = "GlobleValue init on app onCreate()";
    }


    @Override
    public void onTerminate() {
        Log.d("RememberLog", "MyApplication->onTerminate()");
        super.onTerminate();
    }
}
