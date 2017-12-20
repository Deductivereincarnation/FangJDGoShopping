package cart.presenter;

import java.util.ArrayList;
import java.util.List;

import cart.bean.ShopBean;
import cart.model.IShopModel;
import cart.model.ShopModel;
import cart.view.IView;
import cart.view.OnNetListenter;

/**
 * Create by ren on 2017/12/12 21:18
 */

public class ShopPresenter {
    private IShopModel iShopModel;
    private IView iView;
    public ShopPresenter(IView iView){
        iShopModel=new ShopModel();
        this.iView=iView;
    }
    public void getShop(){
        iShopModel.getShop(new OnNetListenter<ShopBean>() {
            @Override
            public void onSuccess(ShopBean shopBean) {
                List<ShopBean.DataBean> dataBean = shopBean.getData();
                List<List<ShopBean.DataBean.ListBean>> childList= new ArrayList<List<ShopBean.DataBean.ListBean>>();
                for(int i=0;i<dataBean.size();i++){
                    List<ShopBean.DataBean.ListBean> listBeen= dataBean.get(i).getList();
                    childList.add(listBeen);
                }
                iView.showList(dataBean,childList);
            }

            @Override
            public void onFailure(Exception e) {
                e.printStackTrace();
            }
        });
    }
}
