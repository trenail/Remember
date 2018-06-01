package com.test.remember;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ScrollView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SlidingConflictActivity2 extends AppCompatActivity {

    @BindView(R.id.scrollview_parent)
    ScrollView mScrollViewParent;

    @BindView(R.id.scrollview_child)
    InternalScrollViewChild mScrollViewChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_conflict2);
        ButterKnife.bind(this);

        mScrollViewChild.setParentScrollView(mScrollViewParent);
    }
}
