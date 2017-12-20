package clas.presenter;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import clas.bean.Sy_bean;
import clas.model.SYDataModel;
import clas.view.ISYDataView;
import rx.Observer;

/**
 * Create by ren on 2017/12/13 10:54
 */

public class SYPresenter {
    //首页
    SYDataModel model;
    ISYDataView view;
    List<Sy_bean.GoodsListBean> sylist=new ArrayList<>();

    public SYPresenter(ISYDataView view) {
        this.view = view;
        model=new SYDataModel();
    }
    public void spData(){
        model.getSYData(new Observer<Sy_bean>(){

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

                Log.i("111111p","onError");
            }

            @Override
            public void onNext(Sy_bean sy_bean) {
                sylist.addAll(sy_bean.getGoods_list());
                view.showSYData(sylist);
            }
        });
    }
}
