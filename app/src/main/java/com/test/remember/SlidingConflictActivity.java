package com.test.remember;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ScrollView;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 滑动冲突
 * <p>
 * 知识点:
 * 1.事件分发
 * 2.事件处理
 * <p>
 * 注意点:
 * 1.另外如果不消耗ACTION_DOWN事件，那么down,move,up事件都与该View无关，交由父类处理(父类的onTouchEvent方法)（dispatchTouchEvent）
 * 2.而且这一个事件序列（当前和其它事件）都只能由该ViewGroup处理，并且不会再调用该onInterceptTouchEvent方法去询问是否拦截。（onInterceptTouchEvent return true）
 * <p>
 *
 * @see <a href="http://www.10tiao.com/html/169/201702/2650822067/1.html">Android View的事件分发机制和滑动冲突解决方案</a>
 */
public class SlidingConflictActivity extends AppCompatActivity {
    @BindView(R.id.scrollview_parent)
    ExternalScrollView mScrollViewParent;

    @BindView(R.id.scrollview_child)
    ScrollView mScrollViewChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_conflict);
        ButterKnife.bind(this);

        mScrollViewParent.setScrollViewChild(mScrollViewChild);

    }
}
