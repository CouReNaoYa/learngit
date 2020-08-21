//package com.example.myapplication;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Looper;
//import android.os.Message;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.bumptech.glide.Glide;
//import com.google.gson.Gson;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.json.JSONArray;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.lang.reflect.Type;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.ProtocolException;
//import java.net.URL;
//import java.util.List;
//import java.util.Map;
//
//
//import Bean.Bean1;
//
//public class MainActivity extends AppCompatActivity {
//
//    private TextView main_title;
//    private TextView main_totle;
//
//    private JsonArray arrayJson;
//
//    public List<Bean1.SubjectsBean> subjects;
//    private GeneralAdapter generalAdapter;
//    private Bean1 bean1;
//    private RecyclerView recyclerView;
//
//    String title;
//    String totle;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        recyclerView = findViewById(R.id.my_recycler_view);
//        main_totle=findViewById(R.id.main_totle);
//        main_title=findViewById(R.id.main_title);
//
//        recyclerView.setLayoutManager (new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
//        recyclerView.setAdapter(generalAdapter);
//
//        send(0,99);
//
//
//
//    }
//
//
//    private void send(final int start, final int count) {
//
//        //开启线程，发送请求
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                HttpURLConnection connection = null;
//                BufferedReader reader = null;
//                try {
//                    URL url = new URL("http://api.douban.com/v2/movie/in_theaters?apikey=0df993c66c0c636e29ecbb5344252a4a&start="+start+"&count="+count+"&qq-pf-to=pcqq.c2c");
//                    connection = (HttpURLConnection) url.openConnection();
//                    //设置请求方法
//                    connection.setRequestMethod("GET");
//                    //设置连接超时时间（毫秒）
//                    connection.setConnectTimeout(5000);
//                    //设置读取超时时间（毫秒）
//                    connection.setReadTimeout(5000);
//
//                    //返回输入流
//                    InputStream in = connection.getInputStream();
//
//                    //读取输入流
//                    reader = new BufferedReader(new InputStreamReader(in));
//                    StringBuilder a = new StringBuilder();
//                    String line;
//                    while ((line = reader.readLine()) != null) {
//                        a.append(line);
//                    }
//                    String result=a.toString();
//
//                    if(result==null)
//                    {
//                        Looper.prepare();
//                 //       Toast.makeText(getContext(),"网络连接错误！",Toast.LENGTH_SHORT).show();
//                        Looper.loop();
//                    }
//
//                    else {
//
//                        bean1=new Bean1();
//                        Gson gson = new Gson();
//                        bean1 = gson.fromJson(result, bean1.getClass());
//                        title = bean1.getTitle();
//                        int  totle1 = bean1.getTotal();
//                        totle=String.valueOf(totle1);
//
//                        JsonParser parser = new JsonParser();
//                        JsonObject jsonObject = parser.parse(result).getAsJsonObject();
//                        //将data节点下的内容转为JsonArray
//                        JsonArray jsonArray = jsonObject.getAsJsonArray("subjects");
//                        for (int i = 0; i < jsonArray.size(); i++) {
//                            //获取第i个数组元素
//                            JsonElement el = jsonArray.get(i);
//                            //映射为类实例
//                            bean1.subjects.add(gson.fromJson(el, Bean1.SubjectsBean.class));
//                          //  Bean1.SubjectsBean subject = gson.fromJson(el, Bean1.SubjectsBean.class);
//                        }
//
//                        show();
//                    }
//                    //  show(result.toString());
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                } catch (ProtocolException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                finally {
//                    if (reader != null) {
//                        try {
//                            reader.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    if (connection != null) {//关闭连接
//                        connection.disconnect();
//                    }
//                }
//            }
//        }).start();
//    }
//
//
//    private void show() {
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                //textView.setText(result);
//                main_title.setText(title);
//                main_totle.setText(totle);
//                generalAdapter=new GeneralAdapter(getBaseContext(),subjects);
//
//
//
//            }
//        });
//    }
//
//    public class GeneralAdapter extends RecyclerView.Adapter<GeneralAdapter.MyViewHolder>  {
//        Context context; //当前上下文对象'
//
//
//        public GeneralAdapter(Context context, List<Bean1.SubjectsBean> subjects){
//            this.context = context;
//            MainActivity.this.subjects = subjects;
//        }
//
//        @NonNull
//        @Override
//        public GeneralAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            //实例化得到Item布局文件的View对象
//            View v = View.inflate(context, R.layout.recycleview_item,null);//R后面的是item的ui
//            //返回MyViewHolder的对象
//            return new GeneralAdapter.MyViewHolder(v);
//        }
//
//
//        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//            holder.recycler_title_chinese.setText(subjects.get(position).getTitle());    //前面的是myviewholder中的，后面的是类模板中的
//            holder.recycler_title_english.setText(subjects.get (position).getOriginal_title());
//            holder.recycler_rating_average.setText((int) subjects.get (position).getRating().getAverage());
//
//            String url=subjects.get(position).getImages().getMedium();
//            Glide.with(context).load(url).into(holder.recycler_picture_movie);
//         //   holder.recycler_picture_movie.setImageResource(subjects.get (position).getImages());
//
//
//        }
//
//        @Override
//        public int getItemCount() {
//            return subjects.size();
//        }
//
////        public  class MyViewHolder extends RecyclerView.ViewHolder{
////            TextView recycler_title_chinese;
////            TextView recycler_title_english;
////            TextView recycler_rating_average;
////
////            ImageView recycler_picture_movie;               //图片当控件的时候是imageview，变量的时候是int
////
////            public MyViewHolder(View itemView) {
////                super(itemView);
////                recycler_title_chinese = itemView.findViewById(R.id.recycler_title_chinese);
////                recycler_title_english=itemView.findViewById(R.id.recycler_title_english);
////                recycler_rating_average=itemView.findViewById(R.id.recycler_rating_average);
////                recycler_picture_movie=itemView.findViewById(R.id.recycler_picture_movie);
////
////            }
////        }
//
//
//    }
//}
//
