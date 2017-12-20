package clas.model;

import clas.utils.PJUrl;
import okhttp3.OkHttpClient;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import utils.RetrofitManager;

/**
 * Create by ren on 2017/12/13 10:53
 */

public class PJDataModel implements IPJDataModel {
    //评价页面
    @Override
    public void getPJData(String id,Observer observer) {
        OkHttpClient client=new OkHttpClient.Builder().build();
        RetrofitManager.getInstance("http://apiv4.yangkeduo.com/",client)
                .setCreate(PJUrl.class)
                .getPj(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
}
