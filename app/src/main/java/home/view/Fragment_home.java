package home.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bwie.zhangren.fangjdgoshopping.R;
import com.bwie.zhangren.fangjdgoshopping.TabActivity;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import home.adapter.HomeAdapter;
import home.bean.HomeBean;
import home.presenter.Ipresenter;

public class Fragment_home extends Fragment implements Iview{

    Unbinder unbinder;
    @BindView(R.id.editText)
    EditText editText;
    Unbinder unbinder1;
    @BindView(R.id.zxing)
    ImageView zxing;
    @BindView(R.id.duanxin)
    ImageView duanxin;
    @BindView(R.id.xrecycler)
    XRecyclerView xrecycler;
    private int REQUEST_CODE = 1;
    private Ipresenter ipresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = View.inflate(getContext(), R.layout.fragment_home, null);
        unbinder1 = ButterKnife.bind(this, inflate);
        ipresenter = new Ipresenter(this);
        ipresenter.HomeData();
        return inflate;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder1.unbind();
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
    public void setData(HomeBean homeBean) {
        Toast.makeText(getActivity(), ""+homeBean.getData().getAd1().get(0).getTitle(), Toast.LENGTH_SHORT).show();
        HomeAdapter homeAdapter = new HomeAdapter(homeBean.getData(),getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrecycler.setLayoutManager(linearLayoutManager);
        xrecycler.setAdapter(homeAdapter);
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
