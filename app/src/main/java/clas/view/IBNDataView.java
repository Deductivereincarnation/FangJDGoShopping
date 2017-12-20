package clas.view;

import java.util.List;

import clas.bean.Bn_Bean;

/**
 * Create by ren on 2017/12/13 10:56
 */

public interface IBNDataView {
    //详情View层接口
    public void bnShowData(List<Bn_Bean.SkuBean> bnlist);
    public String getBnId();
}
