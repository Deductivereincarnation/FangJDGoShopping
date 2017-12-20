package clas.model;

import rx.Observer;

/**
 * Create by ren on 2017/12/13 10:52
 */

public interface IBNDataModel {
    //详情页
    public void getBNData(String goods_id, Observer observer);
}
