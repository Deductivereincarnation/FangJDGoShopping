package clas.model;

import clas.utils.SYUrl;
import okhttp3.OkHttpClient;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import utils.RetrofitManager;

/**
 * Create by ren on 2017/12/13 10:50
 */

public class SYDataModel implements ISYDataModel {
    //首页
    @Override
    public void getSYData(Observer observer) {
        OkHttpClient client=new OkHttpClient.Builder().build();
        RetrofitManager.getInstance("http://apiv3.yangkeduo.com/",client)
                .setCreate(SYUrl.class)
                .getSy()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
}
