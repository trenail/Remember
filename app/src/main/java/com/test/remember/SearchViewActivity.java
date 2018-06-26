package com.test.remember;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ScrollView;

import com.whimaggot.MySearchView;
import com.whimaggot.SearchView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchViewActivity extends AppCompatActivity {


   // @BindView(R.id.searchview)
    MySearchView mySearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);
       // ButterKnife.bind(this);
        mySearchView = findViewById(R.id.searchview);
        mySearchView.mETInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
