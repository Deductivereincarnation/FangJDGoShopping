package user.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.zhangren.fangjdgoshopping.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import user.presenter.Uerpersent;
import utils.Api;
import utils.SharedPreferencesUtils;

public class LoginActivity extends AppCompatActivity implements IView {

    @BindView(R.id.head_image)
    ImageView headImage;
    @BindView(R.id.et_userName)
    EditText etUserName;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.zhuce)
    TextView zhuce;
    @BindView(R.id.btn_login)
    Button btnLogin;
    Uerpersent uerpersent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        uerpersent = new Uerpersent(this);
    }

    @OnClick({R.id.zhuce, R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zhuce:
                Intent intent = new Intent(LoginActivity.this,ZhuceActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_login:
                final String string = etUserName.getText().toString();
                String string1 = etPassword.getText().toString();
                if(string.equals("") || string1.equals("")){
                    Toast.makeText(LoginActivity.this,"用户名和密码不能为空", Toast.LENGTH_SHORT).show();
                }

                uerpersent.start(Api.Login,string,string1);
                break;
        }
    }

    @Override
    public void overAdapter(String logs) {
        Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
        SharedPreferencesUtils.setParam(LoginActivity.this,"bolean",true);
        SharedPreferencesUtils.setParam(LoginActivity.this,"name",logs);
        finish();
    }

    @Override
    public void overfairl() {
        Toast.makeText(LoginActivity.this,"天呐，用户不存在,请先注册",Toast.LENGTH_SHORT).show();
    }
}
