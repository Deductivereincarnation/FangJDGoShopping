package shouye.utils;

import retrofit2.http.GET;
import rx.Observable;
import shouye.bean.OneBean;
import shouye.bean.Two_Lv_LeftBean;

public interface OneAPI {

    @GET("getAd")
    Observable<OneBean> getoneapi();
    @GET("getCatagory")
    Observable<Two_Lv_LeftBean> getone_vp();
}
