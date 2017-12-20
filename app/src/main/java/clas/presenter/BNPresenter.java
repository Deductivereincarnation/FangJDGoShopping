package clas.presenter;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import clas.bean.Bn_Bean;
import clas.model.BNDataModel;
import clas.view.IBNDataView;
import rx.Observer;

/**
 * Create by ren on 2017/12/13 10:57
 */

public class BNPresenter {
//详情页面
    BNDataModel model;
    IBNDataView view;
    List<Bn_Bean.SkuBean> bnlist=new ArrayList<>();

    public BNPresenter(IBNDataView view) {
        this.view = view;
        model=new BNDataModel();
    }
    public void ppData(){
        String goods_id=view.getBnId();
        model.getBNData(goods_id,new Observer<Bn_Bean>(){

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i("111111banner","onError......");
            }

            @Override
            public void onNext(Bn_Bean bn_bean) {
                bnlist.addAll(bn_bean.getSku());
                view.bnShowData(bnlist);
                Log.i("111111banner","onNext"+bnlist);
            }
        });
    }
}
