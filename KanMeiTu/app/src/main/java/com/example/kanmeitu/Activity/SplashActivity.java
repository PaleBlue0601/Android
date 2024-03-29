package com.example.kanmeitu.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;

import com.example.kanmeitu.R;

public class SplashActivity extends BaseActivity {
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            next();
        }
    };
    private void next() {
        Intent intent = null;
        if(sp.isLogin()){
//            已经登录，跳转页面
            intent = new Intent(this, MainActivity.class);
        } else {
            intent = new Intent(this, LoginActivity.class);
        }
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        去除状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                3秒后调用这里
//                这里是子线程，不能直接操作UI，需要用handler切换到主线程
//                用多个线程的目的解决，如果有耗时任务，那么就会卡界面
//                而用了多线程后， 讲耗时任务放到子线程，这样主线程（UI线程）就不会卡住
                handler.sendEmptyMessage(0);
            }
        }, 3000);
    }
}
