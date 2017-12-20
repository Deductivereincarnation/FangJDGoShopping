package shouye.model;

import okhttp3.OkHttpClient;
import shouye.utils.Base;
import shouye.utils.OneAPI;
import utils.RetrofitManager0;

/**
 * Create by ren on 2017/12/14 11:20
 */

public class OneModel implements IOneModel {
    @Override
    public OneAPI setOneData() {
        OkHttpClient client=new OkHttpClient.Builder().build();
        OneAPI setcreate = RetrofitManager0.getinstantce(Base.BASETWO_ONERL, client).setCreate(OneAPI.class);
        return setcreate;
    }

    @Override
    public OneAPI setOnevpData() {
        OkHttpClient client=new OkHttpClient.Builder()
//                .addNetworkInterceptor(new MyInterceptor())
                .build();
        OneAPI setcreate = RetrofitManager0.getinstantce(Base.BASETWO_LV_LEFTURL, client).setCreate(OneAPI.class);
        return setcreate;
    }
}
