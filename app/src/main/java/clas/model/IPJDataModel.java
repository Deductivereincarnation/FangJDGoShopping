package clas.model;

import rx.Observer;

/**
 * Create by ren on 2017/12/13 10:53
 */

public interface IPJDataModel {
    //评价
    public void getPJData(String id, Observer observer);
}
