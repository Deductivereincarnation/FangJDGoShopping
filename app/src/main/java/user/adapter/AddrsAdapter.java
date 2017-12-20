package user.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.zhangren.fangjdgoshopping.R;

import java.util.List;

import user.bean.Address;

public class AddrsAdapter extends RecyclerView.Adapter<AddrsAdapter.MyViewHolder> {

    private List<Address.DataBean> list;
    private Context context;

    public AddrsAdapter(List<Address.DataBean> list,Context context){
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_address,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.mobile.setText(list.get(position).getMobile());
        holder.addr.setText(list.get(position).getAddr());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,mobile,addr;
        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            mobile = view.findViewById(R.id.mobile);
            addr = view.findViewById(R.id.addr);

        }
    }

}
