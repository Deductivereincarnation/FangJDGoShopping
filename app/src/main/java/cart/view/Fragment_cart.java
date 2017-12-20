package cart.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.bwie.zhangren.fangjdgoshopping.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import cart.adapter.MyAdapter;
import cart.bean.ShopBean;
import cart.eventbus.MessageEvent;
import cart.eventbus.PriceAndCountEvent;
import cart.presenter.ShopPresenter;

public class Fragment_cart extends Fragment implements IView {

    private ExpandableListView mElv;
    private CheckBox mCheckbox2;
    private TextView mPriceTv;
    private TextView mNumTv;
    private MyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = View.inflate(getContext(), R.layout.fragment_cart,null);
        //注册EventBus
        EventBus.getDefault().register(this);
        mElv = (ExpandableListView) inflate.findViewById(R.id.elv);
        mCheckbox2 = (CheckBox) inflate.findViewById(R.id.checkbox2);
        mPriceTv = (TextView) inflate.findViewById(R.id.tv_price);
        mNumTv = (TextView) inflate.findViewById(R.id.tv_num);

        new ShopPresenter(this).getShop();

        mCheckbox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.changeAllListCbState(mCheckbox2.isChecked());
            }
        });
        return inflate;
    }

    @Subscribe
    public void onMessageEvent(MessageEvent event){
        mCheckbox2.setChecked(event.isChecked());
    }

    @Subscribe
    public void onMessageEvent(PriceAndCountEvent event){
        mNumTv.setText("结算("+event.getCount()+")");
        mPriceTv.setText(event.getPrice() + "");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void showList(List<ShopBean.DataBean> groupList, List<List<ShopBean.DataBean.ListBean>> childList) {
        adapter=new MyAdapter(getActivity(),groupList,childList);
        mElv.setAdapter(adapter);
        mElv.setGroupIndicator(null);
        //默认让其全部展开
        for(int i=0;i<groupList.size();i++){
            mElv.expandGroup(i);
        }
    }
}
