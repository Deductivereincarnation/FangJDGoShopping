package com.bwie.zhangren.fangjdgoshopping;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //三秒进入主页面
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //启动MainActivity主页面，这段代码是在主线程执行
                Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(intent);
                //关闭当前页面（结束WelcomeActivity）
                finish();
            }
        },3000);

    }
}
