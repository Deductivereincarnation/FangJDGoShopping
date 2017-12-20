package user.model;

import java.util.HashMap;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import user.bean.Zhu;
import utils.ApiServer;

public class ZhuMyodel implements Zhumodel {
    @Override
    public void zhuLog(String url, String mobile, String password) {
        HashMap<String ,String> map=new HashMap<>();
        map.put("mobile",mobile);
        map.put("password",password);
        Retrofit retrofit=new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        Observable<Zhu> reg = apiServer.getZhu("reg", map);
        reg.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Zhu>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Zhu zhu) {
                        sets.zhuOver(zhu);
                    }
                });
    }
    public interface setOverzhu{
        void zhuOver(Zhu zhu);
    }
    private setOverzhu  sets;
    public void setChangce(setOverzhu  sets){
        this.sets=sets;
    }
}
