package clas.model;

import clas.utils.BNUrl;
import okhttp3.OkHttpClient;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import utils.RetrofitManager;

/**
 * Create by ren on 2017/12/13 10:52
 */

public class BNDataModel implements IBNDataModel {
    //详情
    @Override
    public void getBNData(String goods_id,Observer observer) {
        OkHttpClient client=new OkHttpClient.Builder().build();
        RetrofitManager.getInstance("http://apiv4.yangkeduo.com/",client)
                .setCreate(BNUrl.class)
                .getPj(goods_id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
}
