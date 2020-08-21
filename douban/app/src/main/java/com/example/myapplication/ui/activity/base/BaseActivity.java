package com.example.myapplication.ui.activity.base;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        initView();
        initData(savedInstanceState);
        setListener();
        loadData();
    }

    protected abstract void loadData();

    protected abstract void setListener();

    protected abstract void initData(Bundle savedInstanceState);

    //设置view
    protected abstract void initView();
    //设置布局
    protected abstract int getLayoutRes();
}
