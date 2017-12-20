package cart.view;

import java.util.List;

import cart.bean.ShopBean;

/**
 * Create by ren on 2017/12/12 21:23
 */

public interface IView {

    public void showList(List<ShopBean.DataBean> groupList, List<List<ShopBean.DataBean.ListBean>> childList);
}
