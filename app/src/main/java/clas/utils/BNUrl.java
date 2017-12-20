package clas.utils;

import clas.bean.Bn_Bean;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Create by ren on 2017/12/13 10:49
 */

public interface BNUrl {
    //详情页
    @GET("v5/goods/{goods_id}?pdduid=3470667255")
    Observable<Bn_Bean> getPj(@Path("goods_id") String goods_id);
}
