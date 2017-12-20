package clas.view;

import java.util.List;

import clas.bean.Sy_bean;

/**
 * Create by ren on 2017/12/13 10:55
 */

public interface ISYDataView {
    //首页View层接口
    public void showSYData(List<Sy_bean.GoodsListBean> sylist);
}
