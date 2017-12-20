package clas.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bwie.zhangren.fangjdgoshopping.R;

import java.util.ArrayList;
import java.util.List;

import clas.adapter.SYAdapter;
import clas.bean.Sy_bean;
import clas.presenter.SYPresenter;

public class XiangActivity extends AppCompatActivity implements ISYDataView{

    SYAdapter syAdapter;
    private RecyclerView mRv;
    List<Sy_bean.GoodsListBean> sylist=new ArrayList<>();
    SYPresenter syPresenter;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang);
        initView();
        syPresenter=new SYPresenter(this);
        showSYData(sylist);
        syPresenter.spData();
    }

    private void initView() {
        mRv = (RecyclerView) findViewById(R.id.rv);
    }

    @Override
    public void showSYData(final List<Sy_bean.GoodsListBean> sylist) {
        GridLayoutManager manager=new GridLayoutManager(this,2);
        mRv.setLayoutManager(manager);
        syAdapter=new SYAdapter(this,sylist);
        mRv.setAdapter(syAdapter);
        syAdapter.setOnItemClick(new SYAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position, String name, String pic, String price) {
                id=sylist.get(position).getGoods_id()+"";
                Intent intent = new Intent(XiangActivity.this,DetailsActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("name",name);
                intent.putExtra("pic",pic);
                intent.putExtra("price",price);
                startActivity(intent);
            }
        });
    }
}
