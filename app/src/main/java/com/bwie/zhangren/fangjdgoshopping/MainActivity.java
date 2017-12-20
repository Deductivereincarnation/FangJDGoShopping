package com.bwie.zhangren.fangjdgoshopping;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hjm.bottomtabbar.BottomTabBar;

import cart.view.Fragment_cart;
import clas.view.Fragment_clas;
import home.view.Fragment_home;
import shouye.view.Fragment_shouye;
import user.view.Fragment_user;

public class MainActivity extends AppCompatActivity {

    private BottomTabBar bottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomTabBar = (BottomTabBar) findViewById(R.id.bottomTabBar);

        //底部导航栏
        bottomTabBar.init(getSupportFragmentManager())
                .setChangeColor(Color.RED,Color.GRAY)
                .addTabItem("首页",R.mipmap.ac1,R.mipmap.ac0,Fragment_shouye.class)
                .addTabItem("分类",R.mipmap.abx,R.mipmap.abw, Fragment_clas.class)
                .addTabItem("发现",R.mipmap.abz,R.mipmap.aby,Fragment_home.class)
                .addTabItem("购物车", R.mipmap.abv, R.mipmap.abu, Fragment_cart.class)
                .addTabItem("我的", R.mipmap.ac3 , R.mipmap.ac2, Fragment_user.class)
                .isShowDivider(false);

    }
}
