package utils;

/**
 * 作者：${ren} on 2017/12/4 19:24
 * 首页：（http://result.eolinker.com/umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage）
 * https://www.zhaoapi.cn/ad/getAd
 * 收货地址：http://120.27.23.105/user/getAddrs?uid=71
 */

public class Api {

    //首页
    public static final String HOME = "http://result.eolinker.com/";
    //二级购物车
    public static final String url = "http://120.27.23.105/product/getCarts?uid=100&&source=android";
    //收货地址
    public static final String Address = "http://120.27.23.105/user/";
    //注册
    public static final String Zhuce="http://120.27.23.105/user/";
    //登录
    public static final String Login="http://120.27.23.105/user/";

    // 分类左侧接口
    public static final String SORT_LEFT = "http://120.27.23.105/";
    public static final String SORT_LEFT_PATH = "product/getCatagory";

    // 分类右侧接口
    public static final String SORT_RIGHT = "http://120.27.23.105/";
    public static final String SORT_RIGHT_PATH = "product/getProductCatagory";


}
