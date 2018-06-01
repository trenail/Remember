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
 * <p>
 * 内部处理
 */

public class InternalScrollViewChild extends ScrollView {

    public InternalScrollViewChild(Context context) {
        super(context);
    }

    public InternalScrollViewChild(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InternalScrollViewChild(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    PointF point = new PointF();

    public ScrollView getParentScrollView() {
        return parentScrollView;
    }

    public void setParentScrollView(ScrollView parentScrollView) {
        this.parentScrollView = parentScrollView;
    }

    ScrollView parentScrollView ;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            Log.d("RememberLog", "InternalScrollViewChild->dispatchTouchEvent():MotionEvent.ACTION_DOWN");
            point.set(ev.getX(), ev.getY());
            getParentScrollView().requestDisallowInterceptTouchEvent(true);
        } else if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            Log.d("RememberLog", "InternalScrollViewChild->dispatchTouchEvent():MotionEvent.ACTION_MOVE");
            if (Math.abs(point.x - ev.getX()) - Math.abs(point.y - ev.getY()) < 0) {
                Log.d("RememberLog", "InternalScrollViewChild->dispatchTouchEvent():纵向滑动");
                if (point.y - ev.getY() > 0) {
                    Log.d("RememberLog", "InternalScrollViewChild->dispatchTouchEvent():向上滑动");
                    //如果向上滑动,当前控件没有滑动到底部,则自己处理,否则父控件处理
                    View contentView = getChildAt(0);
                    if (contentView.getMeasuredHeight() > getScrollY() + getHeight()) {

                        Log.d("RememberLog", "InternalScrollViewChild->dispatchTouchEvent():向上滑动,自己处理");
                        getParentScrollView().requestDisallowInterceptTouchEvent(true);
                    }else{
                        getParentScrollView().requestDisallowInterceptTouchEvent(false);
                    }

                } else {
                    Log.d("RememberLog", "InternalScrollViewChild->dispatchTouchEvent():向下滑动");
                    //如果向下滑动,当前控件没有滑动到顶部,则自己处理,否则父控件处理
                    if (getScrollY() > 0) {
                        Log.d("RememberLog", "InternalScrollViewChild->dispatchTouchEvent():向下滑动,自己处理");
                        getParentScrollView().requestDisallowInterceptTouchEvent(true);
                    }else{
                        getParentScrollView().requestDisallowInterceptTouchEvent(false);
                    }

                }
            }


        }

        return super.dispatchTouchEvent(ev);
    }
}
