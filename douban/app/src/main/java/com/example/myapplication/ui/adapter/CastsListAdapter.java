package com.example.myapplication.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.bean.Casts;

import java.util.ArrayList;
import java.util.List;



public class CastsListAdapter extends RecyclerView.Adapter <CastsListAdapter.MyViewHolder> {

    List<Casts> castsList;
    Context context;

    public CastsListAdapter(Context context  ,  List<Casts> castsList){
        this.context = context;
        this.castsList =castsList;
    }
    @Override
    public CastsListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //实例化得到Item布局文件的View对象
        View v = View.inflate(context, R.layout.recycleview_casts,null);//R后面的是item的ui
        //返回MyViewHolder的对象
        return new MyViewHolder(v);    }




 //   @Override
    public void onBindViewHolder(@NonNull CastsListAdapter.MyViewHolder holder, int position) {
        holder.detail_casts_name.setText(castsList.get(position).getName());    //前面的是myviewholder中的，后面的是类模板中的
        holder.detail_casts_name_english.setText(castsList.get (position).getName_en());

        String url=castsList.get(position).getAlt();
        Glide.with(context).load(url).into(holder.detail_casts_picture);

    }

    @Override
    public int getItemCount() {
        return castsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView detail_casts_name;
        public  TextView detail_casts_name_english;

        public ImageView detail_casts_picture;               //图片当控件的时候是imageview，变量的时候是int


        public MyViewHolder(View itemView) {
            super(itemView);
            detail_casts_name = itemView.findViewById(R.id.detail_casts_name);
            detail_casts_name_english=itemView.findViewById(R.id.detail_casts_name_english);
            detail_casts_picture=itemView.findViewById(R.id.detail_casts_picture);

        }
    }

}
