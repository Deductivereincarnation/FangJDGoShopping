package user.model;

import user.bean.Address;

public interface Addrsmodel {

    void getData(AddrsSet addrsSet);

    public interface AddrsSet{
        void Set(Address address);
    }

}
