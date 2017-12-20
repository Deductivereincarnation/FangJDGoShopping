package utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Create by ren on 2017/12/13 10:20
 */

public class RetrofitManager {
    private Retrofit mRetrofit;
    private String baseUrl;
    OkHttpClient client;//有关拦截器
    private static RetrofitManager mRetrofitManager;
    private RetrofitManager(){}
    private RetrofitManager(String baseUrl, OkHttpClient client){
        this.baseUrl=baseUrl;
        this.client=client;//有关拦截器
        initRetrofit();
    }

    //分类
    public static synchronized RetrofitManager getInstance(String baseUrl,OkHttpClient client){//有关拦截器
        if (mRetrofitManager == null){
            mRetrofitManager = new RetrofitManager(baseUrl,client);
        }
        return mRetrofitManager;
    }

    private void initRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)//有关拦截器
                .build();
    }

    public <T> T setCreate(Class<T> reqServer){
        return mRetrofit.create(reqServer);
    }

}
