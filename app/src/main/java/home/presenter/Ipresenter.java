package home.presenter;

import home.bean.HomeBean;
import home.model.Imodel;
import home.model.Umodel;
import home.view.Iview;

public class Ipresenter {

    private final Iview iview;
    private final Umodel umodel;


    public Ipresenter(Iview iview) {
        this.iview = iview;
        this.umodel = new Umodel();
    }

    public void HomeData(){
        umodel.getData(new Imodel.HomeSet() {
            @Override
            public void Set(HomeBean homeBean) {
                iview.setData(homeBean);
            }
        });
    }

}
