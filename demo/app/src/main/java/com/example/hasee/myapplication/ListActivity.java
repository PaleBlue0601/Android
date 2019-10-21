package com.example.hasee.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.example.hasee.myapplication.adapter.ListAdapter;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    private RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        rv = (RecyclerView) findViewById(R.id.rv);

//       在你的RecyclerView高度在使用期间发生变化的时候使用此设置会提高性能
        rv.setHasFixedSize(true);

//        设置一个布局管理器设置布局，LinearLayoutManager默认为垂直布局
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);


//        创建一个ArrayList
//        添加测试数据
        ArrayList<String> strings = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            strings.add("数据："+i);
        }
//        设置适配器，传入数据
//        数量和显示形式
        ListAdapter listAdapter = new ListAdapter(this, strings);
        rv.setAdapter(listAdapter);
    }
}
