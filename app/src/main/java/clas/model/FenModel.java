package clas.model;

import clas.bean.Yean;
import clas.bean.Zean;
import okhttp3.OkHttpClient;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import utils.ApiServer;
import utils.RetrofitUnitl;

/**
 * Create by ren on 2017/12/9 07:56
 */

public class FenModel {

    ScuMod scuMod;

    public void setScuMod(ScuMod scuMod) {
        this.scuMod = scuMod;
    }

    //左面请求
    public void ZuoChen(){
        //OkHttp里面可以添加拦截器
        OkHttpClient ok = new OkHttpClient.Builder()
                .build();
        //请求数据
        RetrofitUnitl.getInstance("https://www.zhaoapi.cn/",ok)
                .setCreate(ApiServer.class)
                .Zuo()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Zean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Zean bean) {
                        scuMod.Zc(bean);
                    }
                });
    }

    //右面请求
    public void YuoChen(int cont){
        //OkHttp里面可以添加拦截器
        OkHttpClient ok = new OkHttpClient.Builder()
                .build();
        //请求数据
        RetrofitUnitl.getInstance("https://www.zhaoapi.cn/",ok)
                .setCreate(ApiServer.class)
                .You(cont)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Yean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Yean bean) {
                        scuMod.Yc(bean);
                    }
                });
    }
    //定义一个接口
    public interface ScuMod{
        void Zc(Zean bean);
        void Yc(Yean yean);
    }
}
