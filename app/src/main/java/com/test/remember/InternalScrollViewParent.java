package com.test.remember;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by home on 2018/5/29.
 * <p>
 * 内部处理
 */

public class InternalScrollViewParent extends ScrollView {

    public InternalScrollViewParent(Context context) {
        super(context);
    }

    public InternalScrollViewParent(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InternalScrollViewParent(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



}
