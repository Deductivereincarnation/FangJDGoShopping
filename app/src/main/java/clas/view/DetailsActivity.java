package clas.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.zhangren.fangjdgoshopping.R;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import clas.adapter.PJAdapter;
import clas.bean.Bn_Bean;
import clas.bean.Pj_Bean;
import clas.presenter.BNPresenter;
import clas.presenter.PJPresenter;
import utils.BnImageLoader;

//轮播页面的Activity
public class DetailsActivity extends AppCompatActivity implements IPJDataView, IBNDataView {

    @BindView(R.id.qq)
    TextView qq;
    @BindView(R.id.buy)
    TextView buy;
    @BindView(R.id.add)
    TextView add;
    private Banner mbanner;
    private TextView mPriceName, more;
    private ListView d_pj_lv;
    PJPresenter pjPresenter;
    String name;
    List<Pj_Bean.DataBean> pjlist = new ArrayList<>();
    List<Bn_Bean.SkuBean> bnlist = new ArrayList<>();
    String pic;
    String price;
    String id;
    PJAdapter pjAdapter;
    BNPresenter bnPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        initView();
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        pic = intent.getStringExtra("pic");
        price = intent.getStringExtra("price");
        id = intent.getStringExtra("id");
        initData();
        pjPresenter = new PJPresenter(this);
        pjShowData(pjlist);
        pjPresenter.ppData();
        bnPresenter = new BNPresenter(this);
        bnShowData(bnlist);
        bnPresenter.ppData();
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(DetailsActivity.this, PingJiaActivity.class);
                intent2.putExtra("id", id);
                startActivity(intent2);
            }
        });
    }

    private void initData() {

        mPriceName.setText(price + "\r\n" + name);
    }

    private void initView() {
        mbanner = (Banner) findViewById(R.id.mbanner);
        mPriceName = (TextView) findViewById(R.id.price_name);
        d_pj_lv = (ListView) findViewById(R.id.d_pj_lv);
        more = findViewById(R.id.more);
    }

    @Override
    public void pjShowData(List<Pj_Bean.DataBean> pjlist) {
        pjAdapter = new PJAdapter(this, pjlist);
        d_pj_lv.setAdapter(pjAdapter);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void bnShowData(List<Bn_Bean.SkuBean> bnlist) {

        ArrayList<String> pic = new ArrayList<>();
        for (int i = 0; i < bnlist.size(); i++) {
            pic.add(bnlist.get(i).getThumb_url());
            Log.i("111111b", "" + bnlist.get(i).getThumb_url());
        }
        mbanner.setImageLoader(new BnImageLoader());
        mbanner.setImages(pic);
        mbanner.start();
    }

    @Override
    public String getBnId() {
        return id;
    }

    @OnClick({ R.id.qq, R.id.buy, R.id.add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.qq:
                Toast.makeText(DetailsActivity.this,"客服妹子未上线~！",Toast.LENGTH_SHORT).show();
                break;
            case R.id.buy:
                Toast.makeText(DetailsActivity.this,"钱就是另外一件事了~！",Toast.LENGTH_SHORT).show();
                break;
            case R.id.add:
                Toast.makeText(DetailsActivity.this,"宝贝已添加到购物车~！",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}