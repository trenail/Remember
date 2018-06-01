package com.test.remember;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class SlidingConflictActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sliding_conflict4);
        findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("RememberLog", "TestButton->OnClickListener()");

            }
        });

//        findViewById(R.id.btn_test).setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.d("RememberLog", "TestButton->onTouch()");
//                return true;
//            }
//        });

        findViewById(R.id.root_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("RememberLog", "TestLayout->OnClickListener()");
            }
        });


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.d("RememberLog", "SlidingConflictActivity4->onTouchEvent() " + event.getAction());
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("RememberLog", "SlidingConflictActivity4->dispatchTouchEvent() " + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

}
