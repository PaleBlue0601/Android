package com.example.kanmeitu.Activity;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.kanmeitu.Adapter.ImageAdapter;
import com.example.kanmeitu.R;
import com.example.kanmeitu.api.Api;
import com.example.kanmeitu.domain.Image;
import com.example.kanmeitu.domain.response.ListRespose;
import com.example.kanmeitu.util.Constants;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

    private RecyclerView rv;
    private ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);

//        设置图片俩列显示
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        rv.setLayoutManager(layoutManager);
//        创建测试数据
//        List<Image> datas = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            datas.add(new Image(String.format("http://dev-courses-quick.oss-cn-beijing.aliyuncs.com/%d.jpg", i)));
//        }

        adapter = new ImageAdapter(this);
        rv.setAdapter(adapter);
//      请求网络数据
        fetchData();
//        adapter.setData(datas);
//        给列表绑定点击事件
        adapter.setOnItemClickListener(new ImageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Image data = adapter.getDate(position);

                Intent intent = new Intent(MainActivity.this, ImageDatailActivity.class);
                intent.putExtra(Constants.ID, data.getUrl());
                startActivity(intent);
            }
        });
    }

    private void fetchData(){
        Api
                .getInstance()
                .images()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ListRespose<Image>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ListRespose<Image> imageListRespose) {
//                        当数据请求完毕后，他会解析成对象,并返回
                        adapter.setData(imageListRespose.getData());
                    }

                    @Override
                    public void onError(Throwable e) {
//                      当数据请求失败将错误信息，提示给用户
//                        同时写到日志中
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    /**
     * 退出
     * @param view
     */
    public void onLogoutClick(View view) {
        sp.setLogin(false);
//        退出到登录界面
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
