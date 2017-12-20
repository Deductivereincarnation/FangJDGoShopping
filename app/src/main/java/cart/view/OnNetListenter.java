package cart.view;

/**
 * Create by ren on 2017/12/12 21:15
 */

public interface OnNetListenter<T> {
    public void onSuccess(T t);
    public  void onFailure(Exception e);
}
