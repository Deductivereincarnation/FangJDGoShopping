package shouye.presenter;

/**
 * Create by ren on 2017/12/14 11:32
 */

public interface IPresenter<T> {
    void attch(T view);
    void dettch();
}