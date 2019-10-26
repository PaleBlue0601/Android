package com.example.kanmeitu.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kanmeitu.R;
import com.example.kanmeitu.util.Constants;
import com.example.kanmeitu.util.RegexUtil;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private EditText et_username,et_password;
    private Button bt_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_username = (EditText)findViewById(R.id.et_username);
        et_password = (EditText)findViewById(R.id.et_password);
        bt_login = (Button)findViewById(R.id.bt_login);
        bt_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_login:
                login();
                break;
        }
    }

    private void login() {
//        获取输入的邮箱
        String email = et_username.getText().toString().trim();
//        获取输入的密码
        String password = et_password.getText().toString().trim();
//      判断输入的邮箱是否为空
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, R.string.email_hint, Toast.LENGTH_SHORT).show();
            return;
        }
//      判断输入的邮箱舒服符合规范
        if(!RegexUtil.isEmail(email)){
            Toast.makeText(this, R.string.email_error, Toast.LENGTH_SHORT).show();
            return;
        }
//      判断输入的密码长度是否在（6-11位）之间
        if(password.length() < 6 || password.length() > 11){
            Toast.makeText(this, R.string.password_length_error, Toast.LENGTH_SHORT).show();
            return;
        }
//        判断输入的邮箱和密码是否正确
        if(Constants.EMAIL.equals(email) && Constants.PASSWORD.equals(password)){
            sp.setLogin(true);

            Intent intent = new Intent(this, MainActivity.class);
//            打开主页面
            startActivity(intent);

//           关闭login页面
            finish();
        } else {
            Toast.makeText(this, R.string.username_or_password_wrror, Toast.LENGTH_SHORT).show();
            return;
        }
    }
}
