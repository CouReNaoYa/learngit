package com.example.myapplication.ui.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.bean.Movie;
import com.example.myapplication.ui.adapter.base.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

//import com.example.myapplication.MainActivity;

public class MovieListAdapter extends  RecyclerView.Adapter <MovieListAdapter.MyViewHolder>implements BaseAdapter<MovieListAdapter.MyViewHolder>,View.OnClickListener {
    Context context; //当前上下文对象'
    List<Movie> datas;

      public MovieListAdapter(Context context){
        this.context = context;
        this.datas = new ArrayList<>();
    }

    public void setList(List<Movie> datas){
        this.datas.clear();
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    public void addList(List<Movie> datas){
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    public List<Movie> getList(){
          return datas;
    }
    @NonNull
    @Override
    public MovieListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //实例化得到Item布局文件的View对象
        View v = View.inflate(context, R.layout.recycleview_item,null);//R后面的是item的ui
        //返回MyViewHolder的对象
        return new MovieListAdapter.MyViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull MovieListAdapter.MyViewHolder holder, int position) {
        holder.recycler_title_chinese.setText(datas.get(position).getTitle());    //前面的是myviewholder中的，后面的是类模板中的
        holder.recycler_title_english.setText(datas.get (position).getOriginal_title());

        holder.recycler_rating_average.setText(" "+datas.get (position).getRating().getAverage());
        int a=position+1;
        holder.recycler_number.setText(" "+a);
        String url=datas.get(position).getImages().getMedium();
        Glide.with(context).load(url).into(holder.recycler_picture_movie);

        String MovieIntroduction=datas.get(position).getYear()+" / "+datas.get(position).getGenres()+"/"+datas.get(position).getDirectors().get(0).getName();
        holder.recycler_movie_introduction.setText("               "+MovieIntroduction);


        double ratingbar=datas.get(position).getRating().getAverage();
        holder.recycler_ratingbar.setRating((float) ratingbar/2);


    }




    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public void onClick(View v) {

    }

    public interface ItemCLickListener{
        void onClick(int position);
    }
    private ItemCLickListener itemCLickListener;
    public void setOnItemClickListener(ItemCLickListener itemClickListener){
        this.itemCLickListener=itemClickListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView recycler_title_chinese;
        public  TextView recycler_title_english;
        public  TextView recycler_rating_average;
        public  TextView recycler_number;
        public  TextView recycler_movie_introduction;

        public ImageView recycler_picture_movie;               //图片当控件的时候是imageview，变量的时候是int

        public RatingBar recycler_ratingbar;

        public MyViewHolder(View itemView) {
            super(itemView);
            recycler_title_chinese = itemView.findViewById(R.id.recycler_title_chinese);
            recycler_title_english=itemView.findViewById(R.id.recycler_title_english);
            recycler_rating_average=itemView.findViewById(R.id.recycler_rating_average);
            recycler_picture_movie=itemView.findViewById(R.id.recycler_picture_movie);
            recycler_number=itemView.findViewById(R.id.recycler_number);
            TextPaint paint = recycler_title_chinese.getPaint();
            paint.setFakeBoldText(true);

            TextPaint paint1 = recycler_number.getPaint();
            paint.setFakeBoldText(true);

            recycler_movie_introduction=itemView.findViewById(R.id.recycler_movie_introduction);

            recycler_ratingbar=itemView.findViewById(R.id.recycler_ratingbar);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(itemCLickListener!=null){
                        itemCLickListener.onClick(getAdapterPosition());
                    }
                }
            });
        }
    }

}