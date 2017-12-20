package user.model;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import user.bean.Logs;
import utils.ApiServer;

public class Mymodel implements IModel {
    @Override
    public void MymodelOver(String url, String mobile,String password) {
        Map<String,String> map=new HashMap<>();
        Log.d("mylog", "MymodelOver: 我规范和健康了" + url + mobile +"---"+password);
        map.put("mobile",mobile);
        map.put("password",password);
        Retrofit retrofit=new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        Observable<Logs> log = apiServer.getLog("login",map);
        log.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Logs>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Logs log) {
                     /*   Log.d("mylog", "onNext: " + log.getCode());
                        Log.d("mylog", "onNext: " + log.getMsg());*/
                        over.setOnchang(log);
                    }
                });
    }
    public  interface  ovderModel{
        void setOnchang(Logs log);
    }
    private ovderModel  over;
    public void setOnchanges(ovderModel  over){
        this.over=over;
    }
}
