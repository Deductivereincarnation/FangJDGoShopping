package utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Create by ren on 2017/12/14 16:43
 */

public class RetrofitManager0 {

    private Retrofit mRetrofit;
    private String baseUrl;
    OkHttpClient client;//有关拦截器
    private static RetrofitManager0 mRetrofitManager;
    private RetrofitManager0(){}
    private RetrofitManager0(String baseUrl, OkHttpClient client){
        this.baseUrl=baseUrl;
        this.client=client;//有关拦截器
        initRetrofit();
    }

    //
    public static RetrofitManager0 getinstantce(String baseUrl, OkHttpClient client){
//        if(retrofitManager==null){
        mRetrofitManager=new RetrofitManager0(baseUrl,client);
//        }
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
