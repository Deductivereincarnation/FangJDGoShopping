package clas.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.bwie.zhangren.fangjdgoshopping.R;

import clas.adapter.ErAdapter;
import clas.adapter.ZuoAdapter;
import clas.bean.Yean;
import clas.bean.Zean;
import clas.presenter.FenPresenter;

public class Fragment_clas extends Fragment implements IFenView{

    public ExpandableListView yev;
    public RecyclerView zrv;
    public FenPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = View.inflate(getContext(), R.layout.fragment_clas,null);
        //拿到P层
        presenter = new FenPresenter(this);
        presenter.ShowPer();
        //默认展示第一条
        presenter.FlShowYou(1);
        //找控件
        zrv = inflate.findViewById(R.id.zrv);
        yev = inflate.findViewById(R.id.yev);
        return inflate;
    }


    @Override
    public void onZuo(final Zean zean) {
        //线性布局
        zrv.setLayoutManager(new LinearLayoutManager(getActivity()));
        //拿到适配器
        ZuoAdapter adapter= new ZuoAdapter(getActivity(),zean);
        zrv.setAdapter(adapter);
        //调用点击事件
        adapter.setOnItemClickListener(new ZuoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                int id = zean.getData().get(position).getCid();
                presenter.FlShowYou(id);
            }
        });
    }

    @Override
    public void onYou(Yean yean) {
        //拿到适配器
        ErAdapter adapter = new ErAdapter(getActivity(),yean);
        yev.setAdapter(adapter);
        //父级列表默认全部展开
        int groupCount = yev.getCount();
        for (int i=0; i<groupCount; i++)
        {
            yev.expandGroup(i);
        }
    }

}
