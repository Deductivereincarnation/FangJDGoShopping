package clas.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.bwie.zhangren.fangjdgoshopping.R;
import clas.view.XiangActivity;

import clas.bean.Yean;

/**
 * Create by ren on 2017/12/9 08:03
 */

public class ErAdapter extends BaseExpandableListAdapter {
    private Context context;
    private Yean yean;

    public ErAdapter(Context context, Yean yean) {
        this.context = context;
        this.yean = yean;
    }

    @Override
    public int getGroupCount() {
        return yean.getData().size();
    }

    @Override
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override
    public Object getGroup(int i) {
        return yean.getData().get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return yean.getData().get(i).getList().get(i);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        //父级
        View v = View.inflate(context, R.layout.item_right, null);
        TextView expand_tv = v.findViewById(R.id.you_you);
        expand_tv.setText(yean.getData().get(i).getName());
        return v;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        //嵌套RecyclerView的布局
        View v = View.inflate(context,R.layout.youhai_litem,null);
        RecyclerView expand_recycler =  v.findViewById(R.id.rvClass);
        //RecyclerView网格格式
        GridLayoutManager gridlayout = new GridLayoutManager(context,3);
        expand_recycler.setLayoutManager(gridlayout);
        //RecyclerView的适配器
        setchild_Aapterer chapter = new setchild_Aapterer(context,yean,i,i1);
        expand_recycler.setAdapter(chapter);
        chapter.setOnItemClickListener(new setchild_Aapterer.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(context,XiangActivity.class);
                context.startActivity(intent);
            }
        });
        return v;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
