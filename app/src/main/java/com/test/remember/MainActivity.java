package com.test.remember;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * 模板activity
 * 主要演示了CoordinatorLayout
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void hideHelloTextView() {
        findViewById(R.id.tv_hello).setVisibility(View.GONE);
    }
}
