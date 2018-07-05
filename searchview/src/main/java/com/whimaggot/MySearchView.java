package com.whimaggot;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.whimaggot.searchview.searchview.R;

/**
 * Created by home on 2018/6/26.
 */

public class MySearchView extends RelativeLayout {

    public LinearLayout mLLHint;

    public EditText mETInput;

    public TextView mTVSearch;

    public ImageView mIVDelete;

    public MySearchView(Context context) {
        super(context);
        initView(context);
    }

    public MySearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MySearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView(context);


    }

    private float originalX = 0;

    private void initView(Context context) {
        //View.inflate(context, R.layout.layout_search_view, this);

        LayoutInflater.from(context).inflate(R.layout.layout_search_view, this, true);

        mLLHint = (LinearLayout) this.findViewById(R.id.ll_hint);
        mETInput = (EditText) this.findViewById(R.id.et_input);
        mTVSearch = (TextView) this.findViewById(R.id.tv_search);
        mIVDelete = (ImageView) this.findViewById(R.id.iv_delete);
        mETInput.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    if (TextUtils.isEmpty(mETInput.getText().toString())) {
                        originalX = mLLHint.getX();
                        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mLLHint, "TranslationX", 0, -originalX);
                        objectAnimator.setDuration(200);
                        objectAnimator.start();
                    }
                } else {
                    if (TextUtils.isEmpty(mETInput.getText().toString())) {
                        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mLLHint, "TranslationX", -originalX, 0);
                        objectAnimator.setDuration(200);
                        objectAnimator.start();
                    }
                }
            }
        });

        mETInput.addTextChangedListener(mTextWatcher);


        mIVDelete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mETInput.getText().clear();
            }
        });

        mETInput.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);//不检查语法错误
    }

    TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (TextUtils.isEmpty(s)) {
                mTVSearch.setVisibility(VISIBLE);

                mIVDelete.setVisibility(INVISIBLE);
            } else {
                mTVSearch.setVisibility(INVISIBLE);

                mIVDelete.setVisibility(VISIBLE);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}
