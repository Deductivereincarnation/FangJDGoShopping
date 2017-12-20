package shouye.presenter;

import android.content.Context;
import android.util.Log;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import shouye.bean.OneBean;
import shouye.bean.Two_Lv_LeftBean;
import shouye.model.IOneModel;
import shouye.model.OneModel;
import shouye.view.IOneView;

/**
 * Create by ren on 2017/12/14 11:32
 */

public class OnePresenter implements IPresenter<IOneView> {

    SoftReference<IOneView> reference;
    IOneModel model;
    Context context;
    List<OneBean.DataBean> list=new ArrayList<>();
    List<OneBean.MiaoshaBean.ListBeanX> listms=new ArrayList<>();
    List<OneBean.TuijianBean.ListBean> listtj=new ArrayList<>();
    List<Two_Lv_LeftBean.DataBean> listvp=new ArrayList<>();
    public OnePresenter(IOneView view, Context context) {
        this.context=context;
        model=new OneModel();
        attch(view);
    }

    public void showoneBanner(){
        model.setOneData().getoneapi().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Observer<OneBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(OneBean oneBean) {
                for (int i = 0; i < oneBean.getData().size(); i++) {
                    list.add(oneBean.getData().get(i));
                }
                for (int i = 0; i < oneBean.getMiaosha().getList().size(); i++) {
                    listms.add(oneBean.getMiaosha().getList().get(i));
                }
                for (int i = 0; i < oneBean.getTuijian().getList().size(); i++) {
                    listtj.add(oneBean.getTuijian().getList().get(i));
                }

                reference.get().setonebean(list);
                reference.get().setonemsbean(listms);
                reference.get().setonetjbean(listtj);
            }
        });

    }
    public void showoneGV(){
        model.setOnevpData().getone_vp().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Observer<Two_Lv_LeftBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {
                Log.i("---one-onError-------", "onNext: "+throwable.getMessage());
            }

            @Override
            public void onNext(Two_Lv_LeftBean two_lv_leftBean) {
                for (int i = 0; i < two_lv_leftBean.getData().size(); i++) {
                    listvp.add(two_lv_leftBean.getData().get(i));
                }
                Log.i("---one-list-------", "onNext: "+two_lv_leftBean);
                reference.get().getVpData(listvp);
            }
        });
    }

    @Override
    public void attch(IOneView view) {
        reference=new SoftReference<IOneView>(view);
    }

    @Override
    public void dettch() {
        reference.clear();
    }
}
