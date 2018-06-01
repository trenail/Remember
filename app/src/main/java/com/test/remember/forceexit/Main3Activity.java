package com.test.remember.forceexit;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.test.remember.MyApplication;
import com.test.remember.R;



public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("RememberLog", "Main3Activity->onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView tv = findViewById(R.id.tv_hello);

        tv.setText(MyApplication.GlobleValue + Main2Activity.GlobleValue);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        Log.d("RememberLog", "Main3Activity->onSaveInstanceState(Bundle,PersistableBundle)");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.d("RememberLog", "Main3Activity->onSaveInstanceState(Bundle)");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        Log.d("RememberLog", "Main3Activity->onNewIntent()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.d("RememberLog", "Main3Activity->onRestoreInstanceState()");
    }
}
