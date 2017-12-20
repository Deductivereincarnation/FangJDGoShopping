package clas.view;

import clas.bean.Yean;
import clas.bean.Zean;

/**
 * Create by ren on 2017/12/9 07:55
 */

public interface IFenView {

    void onZuo(Zean zean);//左侧请求成功
    void onYou(Yean yean);//右侧请求成功
}
