package com.example.hasee.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {
    private OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "这是Debug级别的日志Hello Word");
    }

    /**
     * 使用openList打开一个RecyclerViw页面
     *
     * @ param View
     */
    public void openList(View view) {
        Intent List = new Intent(MainActivity.this, ListActivity.class);
        startActivity(List);
    }


    public void getNetworkData(View view) {
//        然后创建一个线程，应为我们这学习的同步请求
//        应为Android不允许在主线程中请求网络
//        同样可以在AsyncTask这样的异步任务里面同步调用
        Log.d("GET", "进入getNetworkData方法内");
        new Thread() {
            @Override
            public void run() {
                super.run();
//                创建一个Request，他里面包括的你要请求网址等信息
                Request request = new Request.Builder().url("http://www.ixuea.com/").build();

                try {
//                  然后调用newCall方法，传入刚刚创建的Request对象
//                  然后调用execute方法来执行请求
                    Response response = client.newCall(request).execute();

//                  通过调用response的body上的string方法可以得到流字符串
                    String result = response.body().string();


//                   返回的字符串打印到日志上
//                  这里不能直接把数据设置在页面上
//                  因为子线程中不能操作页面（android）上规定的
                    Log.d("GET", result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
