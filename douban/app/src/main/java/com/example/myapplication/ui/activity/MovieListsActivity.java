package com.example.myapplication.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.bean.Movie;
import com.example.myapplication.bean.base.MovieResult;
import com.example.myapplication.ui.activity.base.BaseActivity;
import com.example.myapplication.ui.adapter.MovieListAdapter;
import com.example.myapplication.ui.listener.OnGetMovieListener;
import com.example.myapplication.ui.persent.MoviePersent;
import com.example.myapplication.utils.ToastUtils;

import java.io.Serializable;

public class MovieListsActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private MoviePersent persent;
    private int page = 0;
    private static int PAGE_COUNT = 10;

    private TextView tvTitle;
    private TextView tvTotal;
    private ImageView ivListTopBackground;
    public MovieListAdapter movieListAdapter;

    private RecyclerView reMovieList;
    @Override
    protected void loadData() {
        persent.getMovieList(PAGE_COUNT * page, PAGE_COUNT, new OnGetMovieListener() {
            @Override
            public void getSuccess(final MovieResult movieResult) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                      //  adapter.setList(movieResult.datas);
                      //  page++;
                        tvTitle.setText(movieResult.getTitle());
                        tvTotal.setText("总数："+movieResult.getTotal());
                        String a=movieResult.getDatas().get(0).getImages().getMedium();
                        Glide.with(MovieListsActivity.this).load(a).into(ivListTopBackground);
                        movieListAdapter.setList(movieResult.getDatas());

                    }
                });
            }

            @Override
            public void getFailed(Throwable throwable) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtils.showToast(MovieListsActivity.this,"请求失败l ");
                      //  showErrorView();
                    }
                });


            }
        });
    }


    @Override
    protected void initView() {
        reMovieList = findViewById(R.id.rv_movie_list);
        tvTitle=findViewById(R.id.tv_title);
        tvTotal=findViewById(R.id.tv_total);
        ivListTopBackground=findViewById(R.id.list_top_background);
       // ivListTopBackground.setColorFilter(Color.parseColor("#330000"), PorterDuff.Mode.LIGHTEN);
        ivListTopBackground.setAlpha(0.2f);




        reMovieList.setLayoutManager (new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        movieListAdapter=new MovieListAdapter(this);

        reMovieList.setAdapter(movieListAdapter);

    }

    @Override
    protected void setListener() {
        movieListAdapter.setOnItemClickListener(new MovieListAdapter.ItemCLickListener() {
            @Override
            public void onClick(int position) {
             //   Toast.makeText(MovieDetailActivity.this,"点击了登录",Toast.LENGTH_LONG).show();//点击后显示的弹窗
                Movie movie=movieListAdapter.getList().get(position);
                System.out.println(movie.getTitle());
                System.out.println(movie.getYear());
                final Bundle data=new Bundle();
                data.putParcelable("movie", movie);


                Intent intent = new Intent(MovieListsActivity.this,MovieDetailActivity.class);//这个为跳转activity
                intent.putExtras(data);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        persent = new MoviePersent();
    }


    @Override
    protected int getLayoutRes() {

        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }return R.layout.activity_movie_list;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
