package clas.presenter;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import clas.bean.Pj_Bean;
import clas.model.PJDataModel;
import clas.view.IPJDataView;
import rx.Observer;

/**
 * Create by ren on 2017/12/13 10:58
 */

public class PJPresenter {
    //评价页面
    PJDataModel model;
    IPJDataView view;
    List<Pj_Bean.DataBean> pjlist=new ArrayList<>();

    public PJPresenter(IPJDataView view) {
        this.view = view;
        model=new PJDataModel();
    }
    public void ppData(){
        String id=view.getId();
        model.getPJData(id,new Observer<Pj_Bean>(){

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i("111111p","onError");
            }

            @Override
            public void onNext(Pj_Bean pj_bean) {
                pjlist.addAll(pj_bean.getData());
                view.pjShowData(pjlist);
            }
        });
    }
}
