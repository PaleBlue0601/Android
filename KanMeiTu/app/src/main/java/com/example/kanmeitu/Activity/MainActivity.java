package com.example.kanmeitu.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.kanmeitu.R;
import com.example.kanmeitu.util.SharedPreferencesUtil;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
