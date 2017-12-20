package clas.presenter;

import clas.bean.Yean;
import clas.bean.Zean;
import clas.model.FenModel;
import clas.model.FenModel.ScuMod;
import clas.view.IFenView;

/**
 * Create by ren on 2017/12/9 07:58
 */

public class FenPresenter implements ScuMod {
    IFenView view;
    FenModel model;

    public FenPresenter(IFenView view) {
        this.view = view;
        model = new FenModel();
        model.setScuMod(this);
    }

    @Override
    public void Zc(Zean bean) {
        view.onZuo(bean);
    }

    @Override
    public void Yc(Yean yean) {
        view.onYou(yean);
    }

    //左侧调用
    public void  ShowPer(){
        model.ZuoChen();
    }
    // 右侧调用
    public void FlShowYou(int cont){
        model.YuoChen(cont);
    }
}
