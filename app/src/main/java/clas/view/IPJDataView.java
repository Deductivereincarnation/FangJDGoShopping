package clas.view;

import java.util.List;

import clas.bean.Pj_Bean;

/**
 * Create by ren on 2017/12/13 10:56
 */

public interface IPJDataView {
    //评价View层接口
    public void pjShowData(List<Pj_Bean.DataBean> pjlist);
    public String getId();
}
