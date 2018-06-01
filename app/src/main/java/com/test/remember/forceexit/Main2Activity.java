package com.test.remember.forceexit;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.test.remember.MyApplication;
import com.test.remember.R;

/**
 * 模拟app被后台kill,重新进入时
 * 1.打开app
 * 2.使用home键返回
 * 3.使用ddms关闭app进程
 *
 *
 *
 * @see <a href="https://juejin.im/entry/582180a3bf22ec0068e2285d">解决 android 应用被强杀或应用被回收导致的空指针问题</a>
 * @see <a href="https://blog.csdn.net/litefish/article/details/51685232">android进程重启及activity恢复</a>
 */
public class Main2Activity extends AppCompatActivity {

    public static String GlobleValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("RememberLog", "Main2Activity->onCreate()");
        super.onCreate(savedInstanceState);

        GlobleValue = "GlobleValue init on Main2Activity";

        setContentView(R.layout.activity_main2);

        TextView tv = findViewById(R.id.tv_hello);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this, Main3Activity.class));
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        Log.d("RememberLog", "Main2Activity->onSaveInstanceState()");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        Log.d("RememberLog", "Main2Activity->onNewIntent()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.d("RememberLog", "Main2Activity->onRestoreInstanceState()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.d("RememberLog", "Main3Activity->onSaveInstanceState(Bundle)");
    }

}
