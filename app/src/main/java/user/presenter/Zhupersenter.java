package user.presenter;


import user.bean.Zhu;
import user.model.ZhuMyodel;
import user.view.Zview;

public class Zhupersenter {
    private final Zview zview;
    private final ZhuMyodel zhuMyodel;

    public Zhupersenter(Zview zview) {
        this.zview = zview;
        this.zhuMyodel=new ZhuMyodel();
    }
    public void zhustart(String url,String mobile,String password){
        zhuMyodel.zhuLog(url,mobile,password);
        zhuMyodel.setChangce(new ZhuMyodel.setOverzhu() {
            @Override
            public void zhuOver(Zhu zhu) {
                if (zhu.getCode().equals("0")){
                    zview.zhusucess();
                }else{
                    zview.zhufarile();
                }
            }
        });
    }
}
