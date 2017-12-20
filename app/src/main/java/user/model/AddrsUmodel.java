package user.model;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import user.bean.Address;
import utils.Api;
import utils.RetroFactory;

public class AddrsUmodel implements Addrsmodel{

    @Override
    public void getData(final AddrsSet addrsSet) {
        Observable<Address> addrs = RetroFactory.build(Api.Address).getAddrs();
        addrs.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Address>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Address address) {
                        addrsSet.Set(address);
                    }
                });
    }
}
