package user.presenter;


import user.bean.Logs;
import user.model.Mymodel;
import user.view.IView;

public class Uerpersent {
    private final IView iview;
    private final Mymodel mymodel;

    public Uerpersent(IView iview) {
        this.iview = iview;
        this.mymodel=new Mymodel();
    }
    public void start(String url,String mobile,String password){
         mymodel.MymodelOver(url, mobile, password);
        mymodel.setOnchanges(new Mymodel.ovderModel() {
            @Override
            public void setOnchang(Logs s) {
                if (s.getCode().equals("1")){
                    iview.overfairl();
                }else{
                    iview.overAdapter(s.getData().getMobile());
                }

            }
        });
    }
}
