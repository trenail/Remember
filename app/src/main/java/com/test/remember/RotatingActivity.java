package com.test.remember;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 打开acitivty 5秒内旋转屏幕,报错
 * activity 重新创建,之前线程持有的对象已不存在
 */
public class RotatingActivity extends AppCompatActivity {

    private static int COUNT = 0;

    @BindView(R.id.tv_hello)
    TextView textView;

    int value = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotating);

        ButterKnife.bind(this);

        if (COUNT == 0) {

            value = 1;

            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("new Thread(): wait...");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("value :" + value);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText("test text!");
                            System.out.println("new Thread():" + textView.hashCode());
                        }
                    });

                }
            }).start();
        } else {
            COUNT = 0;
        }

        COUNT = 1;

        System.out.println("Main Thread:" + textView.hashCode());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        textView = null;
    }
}
