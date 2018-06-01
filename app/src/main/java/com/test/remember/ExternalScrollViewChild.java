package com.test.remember;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by home on 2018/5/29.
 */

public class ExternalScrollViewChild extends ScrollView {
    public ExternalScrollViewChild(Context context) {
        super(context);
    }

    public ExternalScrollViewChild(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExternalScrollViewChild(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    PointF point = new PointF();


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

//        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
//
//
//            point.set(ev.getX(), ev.getY());
//
//            return false;
//        } else if (ev.getAction() == MotionEvent.ACTION_MOVE) {
//
//
//            if (Math.abs(point.x - ev.getX()) - Math.abs(point.y - ev.getY()) < 0) {
//
//
//                if (point.y - ev.getY() > 0) {
//
//                    //如果向上滑动,当前控件没有滑动到底部,则自己处理,否则父控件处理
//
//                    if (!canScrollVertically(1)) {
//
//                        //return false;
//                    }
//                } else {
//                    //如果向下滑动,当前控件没有滑动到顶部,则自己处理,否则父控件处理
//                    if (getScrollY() == 0) {
//
//                      //  return false;
//                    }
//                }
//            }
//        }
        return super.dispatchTouchEvent(ev);

    }


}
