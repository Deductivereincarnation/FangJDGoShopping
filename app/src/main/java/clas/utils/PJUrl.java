package clas.utils;

import clas.bean.Pj_Bean;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Create by ren on 2017/12/13 10:49
 */

public interface PJUrl {
    //评价
    @GET("reviews/{id}?page=1&size=10&label=1&is_back=1&pdduid=3470667255")
    Observable<Pj_Bean> getPj(@Path("id") String id);
}
