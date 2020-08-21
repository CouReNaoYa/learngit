package com.example.myapplication.ui.persent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.bean.Movie;
import com.example.myapplication.ui.listener.OnGetMovieListener;
import com.example.myapplication.ui.listener.base.OnGetDataListener;

//public class MovieDetailPersent extends Activity{
//    public void getMovieDeatil(final OnGetDataListener listener){
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent= getIntent();
//                Bundle data=intent.getExtras();
//                Movie movie=data.getParcelable("movie");
//
//                listener.getSuccess(movie);
//
//            }
//        }).start();
//    }
//}
