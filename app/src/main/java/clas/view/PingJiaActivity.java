package clas.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.bwie.zhangren.fangjdgoshopping.R;

import java.util.ArrayList;
import java.util.List;

import clas.adapter.PJXAdapter;
import clas.bean.Pj_Bean;
import clas.presenter.PJPresenter;

//详情页面View层的Activity
public class PingJiaActivity extends AppCompatActivity implements IPJDataView{

    PJXAdapter pjxAdapter;
    PJPresenter pjPresenter;
    String id;
    List<Pj_Bean.DataBean> pjlist = new ArrayList<>();
    private ListView mPjLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ping_jia);
        initView();
        Intent intent=getIntent();
        id=intent.getStringExtra("id");
        pjPresenter=new PJPresenter(this);
        pjPresenter.ppData();
    }

    private void initView() {
        mPjLv = (ListView) findViewById(R.id.pj_lv);
    }

    @Override
    public void pjShowData(List<Pj_Bean.DataBean> pjlist) {
        pjxAdapter=new PJXAdapter(this,pjlist);
        mPjLv.setAdapter(pjxAdapter);
    }

    @Override
    public String getId() {
        return id;
    }
}
