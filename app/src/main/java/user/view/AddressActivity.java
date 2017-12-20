package user.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bwie.zhangren.fangjdgoshopping.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import user.adapter.AddrsAdapter;
import user.bean.Address;
import user.presenter.Addrspresenter;
import user.view.Addrsview;

public class AddressActivity extends AppCompatActivity implements Addrsview{

    @BindView(R.id.recycler)
    RecyclerView recycler;
    Addrspresenter addrspresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        ButterKnife.bind(this);
        addrspresenter = new Addrspresenter(this);
        addrspresenter.AddrsData();

    }

    @Override
    public void setData(Address address) {
        AddrsAdapter addrsAdapter = new AddrsAdapter(address.getData(),this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(linearLayoutManager);
        recycler.setAdapter(addrsAdapter);
    }
}
