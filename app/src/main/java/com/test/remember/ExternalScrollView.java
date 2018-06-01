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

public class ExternalScrollView extends ScrollView {
    public ExternalScrollView(Context context) {
        super(context);
    }

    public ExternalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExternalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private ScrollView mScrollViewChild;

    public ScrollView getScrollViewChild() {
        return mScrollViewChild;
    }

    public void setScrollViewChild(ScrollView mScrollViewChild) {
        this.mScrollViewChild = mScrollViewChild;
    }

    PointF point = new PointF();

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        Log.d("RememberLog", "ExternalScrollView->onInterceptTouchEvent()");


        boolean intercepted = false;

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("RememberLog", "ExternalScrollView->onInterceptTouchEvent():ACTION_DOWN");
                point.set(ev.getX(), ev.getY());

                intercepted = super.onInterceptTouchEvent(ev);
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("RememberLog", "ExternalScrollView->onInterceptTouchEvent():ACTION_MOVE");

                if (Math.abs(point.x - ev.getX()) - Math.abs(point.y - ev.getY()) < 0) {
                    Log.d("RememberLog", "ExternalScrollView->onInterceptTouchEvent():纵向滑动");
                    if (point.y - ev.getY() > 0) {
                        Log.d("RememberLog", "ExternalScrollView->onInterceptTouchEvent():向上滑动:getScrollViewChild().getScrollY():" + getScrollViewChild().getScrollY());

                        //如果向上滑动,并且子ScrollView 已滚动到底部,则拦截处理
                        View contentView = getScrollViewChild().getChildAt(0);
                        if (!getScrollViewChild().canScrollVertically(1)) {
                            Log.d("RememberLog", "ExternalScrollView->onInterceptTouchEvent():拦截处理");
                            intercepted = true;
                            onTouchEvent(ev);
                        }
                    } else {
                        Log.d("RememberLog", "ExternalScrollView->onInterceptTouchEvent():向下滑动:getScrollViewChild().getScrollY():" + getScrollViewChild().getScrollY());

                        //如果向下滑动,并且子scrollview已滚动到了顶部,则拦截处理
                        if (getScrollViewChild().getScrollY() == 0) {
                            intercepted = true;
                            onTouchEvent(ev);
                            Log.d("RememberLog", "ExternalScrollView->onInterceptTouchEvent():拦截处理");
                        }

                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                Log.d("RememberLog", "ExternalScrollView->onInterceptTouchEvent():ACTION_UP");
                break;
        }

        Log.d("RememberLog", "ExternalScrollView->onInterceptTouchEvent():result:" + intercepted);
        return intercepted;
    }
}
