package cart.model;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.google.gson.Gson;
import java.io.IOException;
import cart.bean.ShopBean;
import cart.view.OnNetListenter;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import utils.Api;
import utils.HttpUtils;

/**
 * Create by ren on 2017/12/12 21:17
 */

public class ShopModel implements IShopModel {

    private Handler handler=new Handler(Looper.getMainLooper());
    @Override
    public void getShop(final OnNetListenter<ShopBean> onNetListenter) {
        HttpUtils.getHttpUtils().doGet(Api.url, new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListenter.onFailure(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string=response.body().string();
                final ShopBean shopBean=new Gson().fromJson(string,ShopBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListenter.onSuccess(shopBean);
                    }
                });
            }
        });
    }
}