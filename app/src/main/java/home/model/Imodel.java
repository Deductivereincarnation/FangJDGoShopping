package home.model;

import home.bean.HomeBean;

public interface Imodel {

    void getData(HomeSet homeSet);

    public interface HomeSet{
        void Set(HomeBean homeBean);
    }

}
