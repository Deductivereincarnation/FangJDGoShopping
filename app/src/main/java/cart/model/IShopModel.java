package cart.model;

import cart.bean.ShopBean;
import cart.view.OnNetListenter;

/**
 * Create by ren on 2017/12/12 21:15
 */

public interface IShopModel {

    public void getShop(OnNetListenter<ShopBean> onNetListener);
}
