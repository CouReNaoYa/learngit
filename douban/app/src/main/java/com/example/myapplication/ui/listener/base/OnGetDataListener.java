package com.example.myapplication.ui.listener.base;

public interface OnGetDataListener<T> {
    void getSuccess(T t);
    void getFailed(Throwable throwable);
}
