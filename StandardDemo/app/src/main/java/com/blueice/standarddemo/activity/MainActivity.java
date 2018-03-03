package com.blueice.standarddemo.activity;

import android.os.Bundle;
import com.blueice.androidlib.activity.BaseActivity;
import com.blueice.standarddemo.R;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void loadData() {

    }
}
