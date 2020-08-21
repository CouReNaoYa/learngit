package com.example.myapplication.ui.persent;

import android.os.Looper;

import com.example.myapplication.bean.Movie;
import com.example.myapplication.bean.base.MovieResult;
import com.example.myapplication.ui.listener.OnGetMovieListener;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import Bean.Bean1;

/***
 * 电影逻辑
 */
public class MoviePersent {
    public static final int GET_NETWORK_TIME_OUT = 50000;

    public static final String GET_DOUBAN_MOVIE = "http://api.douban.com/v2/movie/in_theaters?apikey=0df993c66c0c636e29ecbb5344252a4a&start=0&count=10\n";
    //public String totle;
    //public String title;
    public MovieResult movieResult;
    /**
     * @param start 开始的数目
     * @param count 请求的个数
     * @param listener 监听器，回调
     * @author 宋婷婷
     */
    public void getMovieList(final int start, final int count, final OnGetMovieListener listener) {
        //开启线程，发送请求

        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    URL url = new URL(GET_DOUBAN_MOVIE);
                    connection = (HttpURLConnection) url.openConnection();
                    //设置请求方法
                    connection.setRequestMethod("GET");
                    //设置连接超时时间（毫秒）
                    connection.setConnectTimeout(GET_NETWORK_TIME_OUT);
                    //设置读取超时时间（毫秒）
                    connection.setReadTimeout(GET_NETWORK_TIME_OUT);

                    //返回输入流
                    InputStream in = connection.getInputStream();

                    //读取输入流
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder a = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        a.append(line);
                    }
                    String result = a.toString();
                    System.out.println(result);

                    if (result == null) {
                        Looper.prepare();

                        //       Toast.makeText(getContext(),"网络连接错误！",Toast.LENGTH_SHORT).show();
                        Looper.loop();
                    } else {
                        movieResult = new MovieResult();
                        Gson gson = new Gson();
                        movieResult = gson.fromJson(result, movieResult.getClass());
                        //获取list
                        List<Movie> movieLists=new ArrayList<>();
                        JsonParser parser = new JsonParser();
                        JsonObject jsonObject = parser.parse(result).getAsJsonObject();
                        //将data节点下的内容转为JsonArray
                        JsonArray jsonArray = jsonObject.getAsJsonArray("subjects");
                        for (int i = 0; i < jsonArray.size(); i++) {
                            //获取第i个数组元素
                            JsonElement el = jsonArray.get(i);
                            //映射为类实例
                            movieLists.add(gson.fromJson(el, Movie.class));
                            //  Bean1.SubjectsBean subject = gson.fromJson(el, Bean1.SubjectsBean.class);
                        }

                        movieResult.setDatas(movieLists);
                        listener.getSuccess(movieResult);

                    }
                    //  show(result.toString());
                } catch (Exception e) {
                    listener.getFailed(e);
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection != null) {//关闭连接
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

}
