package shouye.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bwie.zhangren.fangjdgoshopping.R;
import com.bwie.zhangren.fangjdgoshopping.TabActivity;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import shouye.adapter.MyOneGvAdapter1;
import shouye.adapter.MyOneGvAdapter2;
import shouye.adapter.MyOneVpAdapter;
import shouye.adapter.MyRecyMsAdapter;
import shouye.adapter.MyRecyTjAdapter;
import shouye.bean.OneBean;
import shouye.bean.Two_Lv_LeftBean;
import shouye.presenter.OnePresenter;
import utils.Imagebanner;

/**
 * Create by ren on 2017/12/14 13:39
 */

public class Fragment_shouye extends BaseFragment<OnePresenter> implements IOneView {

    @BindView(R.id.zxing)
    ImageView zxing;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.duanxin)
    ImageView duanxin;
    @BindView(R.id.one_bn)
    Banner oneBn;
    @BindView(R.id.one_sdv)
    SimpleDraweeView oneSdv;
    @BindView(R.id.one_vf)
    ViewFlipper oneVf;
    @BindView(R.id.one_vp)
    ViewPager oneVp;
    @BindView(R.id.one_tv_hour)
    TextView oneTvHour;
    @BindView(R.id.one_tv_minute)
    TextView oneTvMinute;
    @BindView(R.id.one_tv_second)
    TextView oneTvSecond;
    @BindView(R.id.one_xsqg)
    LinearLayout oneXsqg;
    @BindView(R.id.one_ms_recy)
    RecyclerView oneMsRecy;
    @BindView(R.id.one_tj_recy)
    RecyclerView oneTjRecy;
    Unbinder unbinder;
    private int REQUEST_CODE = 1;
    List<GridView> listgv;
    GridView gv1;
    GridView gv2;
    MyOneVpAdapter vpadapter;
    MyRecyMsAdapter msAdapter;
    MyRecyTjAdapter tjAdapter;
    List<OneBean.MiaoshaBean.ListBeanX> listms;
    List<OneBean.TuijianBean.ListBean> listtj;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = View.inflate(getActivity(), R.layout.fragment_shouye, null);
        unbinder = ButterKnife.bind(this, view);
        initData();
        initVP();
        initVF();
        initClick();

        DraweeController con = Fresco.newDraweeControllerBuilder()
                .setAutoPlayAnimations(true)//自动播放动画
                .setUri(Uri.parse("asset://com.gz01.baochen.testgif/gif.gif"))//路径
                .build();
        oneSdv.setController(con);


        return view;
    }

    private void initClick(){

    }

    private void initVF(){
        oneVf.addView(View.inflate(getActivity(),R.layout.fragment_one_vf_item,null));
        oneVf.addView(View.inflate(getActivity(),R.layout.fragment_one_vf_item1,null));
        oneVf.addView(View.inflate(getActivity(),R.layout.fragment_one_vf_item2,null));
    }

    private void initVP(){
        listgv = new ArrayList<>();
        gv1 = new GridView(getActivity());
        gv1.setNumColumns(5);
        gv2 = new GridView(getActivity());
        gv2.setNumColumns(5);
        listgv.add(gv1);
        listgv.add(gv2);
        vpadapter = new MyOneVpAdapter(listgv,getActivity());
        oneVp.setAdapter(vpadapter);
        /*oneVp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });*/
        presenter.showoneGV();
    }

    private void initData(){
        listms = new ArrayList<>();
        listtj = new ArrayList<>();
        presenter.showoneBanner();
        presenter.showoneGV();
    }

    @Override
    public void createPresenter() {
        presenter = new OnePresenter(this,getActivity());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void setonebean(List<OneBean.DataBean> list) {
        List<String> array = new ArrayList<>();
        for(int i = 0;i<list.size();i++){
            array.add(list.get(i).getIcon());
        }
        oneBn.setImageLoader(new Imagebanner());
        oneBn.setImages(array);
        oneBn.start();
    }

    @Override
    public void setonemsbean(List<OneBean.MiaoshaBean.ListBeanX> list) {
        listms = list;
        LinearLayoutManager mgr = new LinearLayoutManager(getActivity());
        mgr.setOrientation(LinearLayoutManager.HORIZONTAL);
        oneMsRecy.setLayoutManager(mgr);
        msAdapter = new MyRecyMsAdapter(list, getActivity());
        oneMsRecy.setAdapter(msAdapter);
        /*msAdapter.setOnMsItemClickListener(new MyRecyMsAdapter.OnMsItemClickListener() {
            @Override
            public void OnMsItemClick(int position) {
                Intent intent = new Intent(getActivity(), XiangqingActivity.class);
                intent.putExtra("id", listms.get(position).getPid());
                startActivity(intent);
            }
        });*/
    }

    @Override
    public void setonetjbean(List<OneBean.TuijianBean.ListBean> list) {
        listtj = list;
        GridLayoutManager mgr = new GridLayoutManager(getActivity(), 2);
        oneTjRecy.setLayoutManager(mgr);
        tjAdapter = new MyRecyTjAdapter(list, getActivity());
        oneTjRecy.setAdapter(tjAdapter);
        /*tjAdapter.setOnTjItemClickListener(new MyRecyTjAdapter.OnTjItemClickListener() {
            @Override
            public void OnTJItemClick(int position) {
                Intent intent = new Intent(getActivity(), XiangqingActivity.class);
                intent.putExtra("id", listtj.get(position).getPid());
                startActivity(intent);
            }
        });*/
    }

    @Override
    public void getVpData(List<Two_Lv_LeftBean.DataBean> bean) {
        MyOneGvAdapter1 adapter1 = new MyOneGvAdapter1(bean, getActivity());
        gv1.setAdapter(adapter1);
        MyOneGvAdapter2 adapter2 = new MyOneGvAdapter2(bean, getActivity());
        gv2.setAdapter(adapter2);
    }

    @OnClick({R.id.zxing, R.id.editText})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zxing:
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
            case R.id.editText:
                Intent intent1 = new Intent(getActivity(), TabActivity.class);
                startActivity(intent1);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /**
         * 处理二维码扫描结果
         */
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(getActivity(), "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(getActivity(), "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

}
