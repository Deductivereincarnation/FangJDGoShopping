package user.presenter;

import user.bean.Address;
import user.model.AddrsUmodel;
import user.model.Addrsmodel;
import user.view.Addrsview;

public class Addrspresenter {

    private final Addrsview addrsview;
    private final AddrsUmodel addrsUmodel;

    public Addrspresenter(Addrsview addrsview) {
        this.addrsview = addrsview;
        this.addrsUmodel = new AddrsUmodel();
    }

    public void AddrsData(){
        addrsUmodel.getData(new Addrsmodel.AddrsSet() {
            @Override
            public void Set(Address address) {
                addrsview.setData(address);
            }
        });
    }

}
