package user.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwie.zhangren.fangjdgoshopping.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import user.presenter.Zhupersenter;
import utils.Api;

public class ZhuceActivity extends AppCompatActivity implements Zview {

    @BindView(R.id.ed_user)
    EditText edUser;
    @BindView(R.id.ed_password)
    EditText edPassword;
    @BindView(R.id.zhuce)
    Button zhuce;
    Zhupersenter zhucepresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        ButterKnife.bind(this);
        zhucepresenter = new Zhupersenter(this);
    }

    @OnClick(R.id.zhuce)
    public void onViewClicked() {
        final String string = edUser.getText().toString();
        final String string1 = edPassword.getText().toString();
        if(string.equals("")||string1.equals("")){
            Toast.makeText(ZhuceActivity.this,"用户名和密码不能为空",Toast.LENGTH_SHORT).show();
        }
        zhucepresenter.zhustart(Api.Zhuce,string,string1);
    }

    @Override
    public void zhusucess() {
        Toast.makeText(ZhuceActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void zhufarile() {
        Toast.makeText(ZhuceActivity.this,"天呐用户已经存在",Toast.LENGTH_SHORT).show();
    }
}
