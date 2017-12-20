package home.model;

import home.bean.HomeBean;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import utils.Api;
import utils.RetroFactory;

public class Umodel implements Imodel {

    @Override
    public void getData(final HomeSet homeSet) {
        Observable<HomeBean> home = RetroFactory
                .build(Api.HOME)
                .getHome();
        home.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(HomeBean homeBean) {
                        homeSet.Set(homeBean);
                    }
                });

    }
}
