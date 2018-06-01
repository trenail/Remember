package com.test.remember;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by home on 2018/5/30.
 */

public class TestLayout extends LinearLayout {
    public TestLayout(Context context) {
        super(context);
    }

    public TestLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TestLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d("RememberLog", "TestLayout->onInterceptTouchEvent()" + ev.getAction());
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("RememberLog", "TestLayout->onTouchEvent()" + event.getAction());
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("RememberLog", "TestLayout->dispatchTouchEvent()" + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }
}
