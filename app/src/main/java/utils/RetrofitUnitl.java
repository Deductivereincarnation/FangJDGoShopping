package utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Create by ren on 2017/12/8 10:20
 * Retrofit+Rxjava+OkHttp封装，单例
 */

public class RetrofitUnitl {

    private Retrofit mRetrofit;
    private String baseUrl;
    OkHttpClient client;
    private static RetrofitUnitl mRetrofitManager;
    private RetrofitUnitl(String baseUrl,OkHttpClient client){
        this.baseUrl=baseUrl;
        this.client=client;
        initRetrofit();
    }
    public static synchronized RetrofitUnitl getInstance(String baseUrl,OkHttpClient client){
        if (mRetrofitManager == null){
            mRetrofitManager = new RetrofitUnitl(baseUrl,client);
        }
        return mRetrofitManager;
    }
    private void initRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
    }
    public <T> T setCreate(Class<T> reqServer) {
        return mRetrofit.create(reqServer);
    }

}
