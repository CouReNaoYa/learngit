package com.example.myapplication.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.myapplication.R;
import com.example.myapplication.bean.Movie;
import com.example.myapplication.ui.activity.base.BaseActivity;
import com.example.myapplication.ui.adapter.CastsListAdapter;
import com.example.myapplication.ui.listener.OnGetMovieDetailListener;
//import com.example.myapplication.ui.persent.MovieDetailPersent;

public class MovieDetailActivity extends BaseActivity {
   // private MovieDetailPersent movieDetailPersent;
    private int page = 0;
    private static int PAGE_COUNT = 10;

    private ImageView ivDetailPicture;
    private TextView tvDetailName;
    private TextView tvDetailNameEnglish;
    private TextView tvDetailReleaseTime;
    private TextView tvDetailRating;
    private TextView tvDetailClassification;
    private TextView tvDetailBroadcastTime;

    private ImageView ivDetailDirectorsPicture;
    private TextView tvDetailDirectorsName;
    private TextView tvDetailDirectorsNameEnglish;

    private RecyclerView reDetailCasts;

    public CastsListAdapter castsListAdapter;

    public Movie movie;



    @Override
    protected void loadData() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
       // movieDetailPersent = new MovieDetailPersent();
        Intent intent= getIntent();
        Bundle data=intent.getExtras();
        movie=data.getParcelable("movie");


        String detail_movie_picture=movie.getAlt();
        Glide.with(MovieDetailActivity.this).load(detail_movie_picture).into(ivDetailPicture);

        //Bitmap bitmap = ImageLoader.getInstance().loadImageSync(img_url));

        tvDetailName.setText(movie.getTitle());
        tvDetailNameEnglish.setText(movie.getOriginal_title());
        tvDetailReleaseTime.setText(movie.getMainland_pubdate());

        double rating=movie.getRating().getAverage();
        tvDetailRating.setText("评分为："+rating);


        tvDetailClassification.setText(" "+ movie.getGenres());

        tvDetailBroadcastTime.setText(movie.getYear());

        String directors=movie.getDirectors().get(0).getAlt();
        Glide.with(MovieDetailActivity.this).load(directors).into(ivDetailDirectorsPicture);
        tvDetailDirectorsName.setText(movie.getDirectors().get(0).getName());
        tvDetailDirectorsNameEnglish.setText(movie.getDirectors().get(0).getName_en());


    }

    @Override
    protected void initView() {
          ivDetailPicture=findViewById(R.id.detail_picture);
          tvDetailName=findViewById(R.id.detail_name);
        tvDetailNameEnglish=findViewById(R.id.detail_name_english);
        tvDetailReleaseTime=findViewById(R.id.detail_release_time);
        tvDetailRating=(TextView) findViewById(R.id.detail_rating);
        tvDetailClassification=findViewById(R.id.detail_classification);
        tvDetailBroadcastTime=findViewById(R.id.detail_broadcast_time);

        ivDetailDirectorsPicture=findViewById(R.id.detail_directors_picture);
        tvDetailDirectorsName=findViewById(R.id.detail_directors_name);
        tvDetailDirectorsNameEnglish=findViewById(R.id.detail_directors_name_english);

        reDetailCasts=findViewById(R.id.detail_casts);

        reDetailCasts.setLayoutManager (new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        castsListAdapter=new CastsListAdapter(MovieDetailActivity.this,movie.getCasts());
        reDetailCasts.setAdapter(castsListAdapter);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_movie_detail;
    }
}
