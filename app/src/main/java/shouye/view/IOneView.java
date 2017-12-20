package shouye.view;

import java.util.List;

import shouye.bean.OneBean;
import shouye.bean.Two_Lv_LeftBean;

/**
 * Create by ren on 2017/12/14 11:16
 */

public interface IOneView {
    void setonebean(List<OneBean.DataBean> list);
    void setonemsbean(List<OneBean.MiaoshaBean.ListBeanX> list);
    void setonetjbean(List<OneBean.TuijianBean.ListBean> list);
    void getVpData(List<Two_Lv_LeftBean.DataBean> bean);
}
