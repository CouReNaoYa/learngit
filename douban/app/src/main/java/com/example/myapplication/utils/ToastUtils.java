package com.example.myapplication.utils;

import android.content.Context;
import android.widget.Toast;

import com.example.myapplication.application.MyApplication;
import com.example.myapplication.ui.activity.MovieListsActivity;

public class ToastUtils {
    public static void showToast(Context context,String content){
        Toast.makeText(context,content,Toast.LENGTH_LONG).show();
    }
}
