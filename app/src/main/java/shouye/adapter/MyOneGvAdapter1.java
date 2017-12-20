package shouye.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwie.zhangren.fangjdgoshopping.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import shouye.bean.Two_Lv_LeftBean;


public class MyOneGvAdapter1 extends BaseAdapter {
    List<Two_Lv_LeftBean.DataBean> list;
    Context context;

    public MyOneGvAdapter1(List<Two_Lv_LeftBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list==null?0:(list.size() > 10 ? 10 : list.size());
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodler hodler;
        if(convertView==null){
            convertView=View.inflate(context, R.layout.fragment_two_lv_left,null);
            hodler=new ViewHodler();
            hodler.tv=convertView.findViewById(R.id.lv_left_tv);
            hodler.sdv=convertView.findViewById(R.id.lv_left_dwv);
            convertView.setTag(hodler);
        }else{
            hodler= (ViewHodler) convertView.getTag();
        }
        hodler.tv.setText(list.get(position).getName());
        Uri uri=Uri.parse(list.get(position).getIcon());
        DraweeController controller= Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .build();
        hodler.sdv.setController(controller);
        return convertView;
    }
    class ViewHodler{
        SimpleDraweeView sdv;
        TextView tv;
    }
}
