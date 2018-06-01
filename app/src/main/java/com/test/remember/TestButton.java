package com.test.remember;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by home on 2018/5/30.
 */

public class TestButton extends android.support.v7.widget.AppCompatButton {
    public TestButton(Context context) {
        super(context);
    }

    public TestButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("RememberLog", "TestButton->onTouchEvent()" + event.getAction());
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d("RememberLog", "TestButton->onTouchEvent()" + event.getAction());
        return super.dispatchTouchEvent(event);
    }

}
