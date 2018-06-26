package com.test.remember;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.test.remember.forceexit.Main2Activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DispatchActivity extends AppCompatActivity {


//    @BindView(R.id.btn_scroll_conflict)
//    Button mBtnScrollConflict;
//
//    @BindView(R.id.btn_scroll_conflict2)
//    Button mBtnScrollConflict2;
//
//    @BindView(R.id.btn_scroll_conflict3)
//    Button mBtnScrollConflict3;
//
//    @BindView(R.id.btn_template_1)
//    Button btn_template_1;

    @BindView(R.id.list_view)
    ListView mListView;

    List<StartPageBean> startPageBeanList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatch);
        ButterKnife.bind(this);

//        mBtnScrollConflict.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(DispatchActivity.this, SlidingConflictActivity.class));
//            }
//        });
//        mBtnScrollConflict2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(DispatchActivity.this, SlidingConflictActivity2.class));
//            }
//        });
//        mBtnScrollConflict3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(DispatchActivity.this, SlidingConflictActivity3.class));
//            }
//        });
//        btn_template_1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(DispatchActivity.this, ScrollingActivity.class));
//            }
//        });

        startPageBeanList = Arrays.asList(
                new StartPageBean("Scroll Conflict(外部拦截)", SlidingConflictActivity.class),
                new StartPageBean("Scroll Conflict(内部处理)", SlidingConflictActivity2.class),
                new StartPageBean("croll Conflict(NestedScrollView)", SlidingConflictActivity3.class),
                new StartPageBean("ScrollingActivity(模板Activity)", ScrollingActivity.class),
                new StartPageBean("自定义toolbar", CustomScrollingActivity.class),
                new StartPageBean("滑动冲突测试", SlidingConflictActivity4.class),
                new StartPageBean("模拟应用被kill", Main2Activity.class),
                new StartPageBean("旋屏", RotatingActivity.class),
                new StartPageBean("自定义搜索框", SearchViewActivity.class)
        );

        mListView.setAdapter(new StartPageAdapter(DispatchActivity.this, startPageBeanList));

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(DispatchActivity.this, startPageBeanList.get(position).activity));
            }
        });
    }
}
