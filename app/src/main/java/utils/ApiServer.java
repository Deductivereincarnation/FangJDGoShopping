package utils;

import java.util.Map;

import clas.bean.Yean;
import clas.bean.Zean;
import home.bean.HomeBean;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;
import user.bean.Address;
import user.bean.Logs;
import user.bean.Zhu;

/**
 * 作者：$ren on 2017/12/4 19:25
 *
 * http://result.eolinker.com/umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage
 * https://www.zhaoapi.cn/ad/getAd
 */

public interface ApiServer {
    //首页
    @GET("umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage")
    Observable<HomeBean> getHome();

    //收货地址
    @GET("getAddrs?uid=71")
    Observable<Address> getAddrs();

    //注册
    @POST
    Observable<Zhu> getZhu(@Url String url, @QueryMap Map<String,String> map);

    //登录
    @POST
    Observable<Logs> getLog(@Url String url, @QueryMap Map<String,String> map);

    /**
     * 左面接口
     */
    @GET("product/getCatagory")
    Observable<Zean> Zuo();
    /**
     * 右面接口
     */
    @GET("product/getProductCatagory")
    Observable<Yean> You(@Query("cid") int cid);

}
