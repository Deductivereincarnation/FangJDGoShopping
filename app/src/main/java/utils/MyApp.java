package utils;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class MyApp extends Application {

    private static Context context;
    private static OkHttpClient okHttpClient;
    public static MyApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        //frseco
        Fresco.initialize(this);
        //imageLoader
        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(configuration);

        mInstance = this;
        okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();
    }

    public static MyApp getInstance() {
        return mInstance;
    }

    public static OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    public static void setOkHttpClient(OkHttpClient okHttpClient) {
        MyApp.okHttpClient = okHttpClient;
    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        MyApp.context = context;
    }

}