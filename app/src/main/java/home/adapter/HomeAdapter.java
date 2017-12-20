package home.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.zhangren.fangjdgoshopping.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import home.bean.HomeBean;

public class HomeAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {

    private List<String> list;
    private int TYPE_1 = 0;
    private int TYPE_2 = 1;
    private int TYPE_3 = 2;
    private int TYPE_4 = 3;
    private HomeBean.DataBean bean;
    private Context context;

    public HomeAdapter(HomeBean.DataBean bean,Context context){
        this.bean = bean;
        this.context = context;
    }

    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch(viewType){
            case 0:
                View inflate1 = LayoutInflater.from(context).inflate(R.layout.item_home1,parent,false);
                MyViewHolder1 myViewHolder1 = new MyViewHolder1(inflate1);
                return myViewHolder1;
            case 1:
                View inflate2 = LayoutInflater.from(context).inflate(R.layout.item_home2, parent, false);
                MyViewHolder2 myViewHolder2=new MyViewHolder2(inflate2);
                return myViewHolder2;
            case 2:
                View inflate3 = LayoutInflater.from(context).inflate(R.layout.item_home3, parent, false);
                MyViewHolder3 myViewHolder3=new MyViewHolder3(inflate3);
                return myViewHolder3;
            case 3:
                View inflate4 = LayoutInflater.from(context).inflate(R.layout.item_home4, parent, false);
                MyViewHolder4 myViewHolder4=new MyViewHolder4(inflate4);
                return myViewHolder4;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(XRecyclerView.ViewHolder holder, int position) {

        if(holder instanceof MyViewHolder1){
            MyViewHolder1 viewholder = (MyViewHolder1) holder;
            List<String> bannerList = new ArrayList<>();
            for (int i = 0; i < bean.getAd1().size(); i++) {
                bannerList.add(bean.getAd1().get(i).getImage());
            }
            viewholder.banner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(context).load(path).into(imageView);
                }
            });
            viewholder.banner.setImages(bannerList);
            viewholder.banner.setDelayTime(3000);
            viewholder.banner.setBannerAnimation(Transformer.DepthPage).isAutoPlay(true);
            viewholder.banner.start();

        }else if(holder instanceof MyViewHolder2){
            ((MyViewHolder2) holder).text1.setText(bean.getAd5().get(0).getTitle());
            Uri uri1 = Uri.parse(bean.getAd5().get(0).getImage());
            ((MyViewHolder2) holder).imageView1.setImageURI(uri1);

            ((MyViewHolder2) holder).text2.setText(bean.getAd5().get(1).getTitle());
            Uri uri2 = Uri.parse(bean.getAd5().get(1).getImage());
            ((MyViewHolder2) holder).imageView2.setImageURI(uri2);

            ((MyViewHolder2) holder).text3.setText(bean.getAd5().get(2).getTitle());
            Uri uri3 = Uri.parse(bean.getAd5().get(2).getImage());
            ((MyViewHolder2) holder).imageView3.setImageURI(uri3);

            ((MyViewHolder2) holder).text4.setText(bean.getAd5().get(3).getTitle());
            Uri uri4 = Uri.parse(bean.getAd5().get(3).getImage());
            ((MyViewHolder2) holder).imageView4.setImageURI(uri4);

        }else if(holder instanceof MyViewHolder3){

            ((MyViewHolder3) holder).text1.setText(bean.getDefaultGoodsList().get(0).getGoods_name());
            Uri uri1 = Uri.parse(bean.getDefaultGoodsList().get(0).getGoods_img());
            ((MyViewHolder3) holder).imageView1.setImageURI(uri1);

            ((MyViewHolder3) holder).text2.setText(bean.getDefaultGoodsList().get(1).getGoods_name());
            Uri uri2 = Uri.parse(bean.getDefaultGoodsList().get(1).getGoods_img());
            ((MyViewHolder3) holder).imageView2.setImageURI(uri2);

            ((MyViewHolder3) holder).text3.setText(bean.getDefaultGoodsList().get(2).getGoods_name());
            Uri uri3 = Uri.parse(bean.getDefaultGoodsList().get(2).getGoods_img());
            ((MyViewHolder3) holder).imageView3.setImageURI(uri3);

            ((MyViewHolder3) holder).text4.setText(bean.getDefaultGoodsList().get(3).getGoods_name());
            Uri uri4 = Uri.parse(bean.getDefaultGoodsList().get(3).getGoods_img());
            ((MyViewHolder3) holder).imageView4.setImageURI(uri4);

        }else if(holder instanceof MyViewHolder4){

            ((MyViewHolder4) holder).text1.setText(bean.getAd8().get(0).getTitle());
            Uri uri1 = Uri.parse(bean.getAd8().get(0).getImage());
            ((MyViewHolder4) holder).imageView1.setImageURI(uri1);

            ((MyViewHolder4) holder).text2.setText(bean.getAd8().get(1).getTitle());
            Uri uri2 = Uri.parse(bean.getAd8().get(1).getImage());
            ((MyViewHolder4) holder).imageView2.setImageURI(uri2);

        }

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return TYPE_1;
        }else if(position == 1){
            return TYPE_2;
        }else if(position == 2){
            return TYPE_3;
        }else if(position == 3){
            return TYPE_4;
        }else {
            return -1;
        }
    }

        class MyViewHolder1 extends RecyclerView.ViewHolder {

            private Banner banner;

            public MyViewHolder1(View view) {
                super(view);
                banner = view.findViewById(R.id.banner);
            }
        }

            class MyViewHolder2 extends XRecyclerView.ViewHolder {

                SimpleDraweeView imageView1,imageView2,imageView3,imageView4;
                TextView text1,text2,text3,text4;

                public MyViewHolder2(View view) {
                    super(view);
                    imageView1= (SimpleDraweeView) view.findViewById(R.id.image1);
                    text1= (TextView) view.findViewById(R.id.text1);
                    imageView2= (SimpleDraweeView) view.findViewById(R.id.image2);
                    text2= (TextView) view.findViewById(R.id.text2);
                    imageView3= (SimpleDraweeView) view.findViewById(R.id.image3);
                    text3= (TextView) view.findViewById(R.id.text3);
                    imageView4= (SimpleDraweeView) view.findViewById(R.id.image4);
                    text4= (TextView) view.findViewById(R.id.text4);
                }
            }

            class MyViewHolder3 extends XRecyclerView.ViewHolder {

                SimpleDraweeView imageView1,imageView2,imageView3,imageView4;
                TextView text1,text2,text3,text4;
                public MyViewHolder3(View view)
                {
                    super(view);

                    imageView1= (SimpleDraweeView) view.findViewById(R.id.image1);
                    text1= (TextView) view.findViewById(R.id.text1);
                    imageView2= (SimpleDraweeView) view.findViewById(R.id.image2);
                    text2= (TextView) view.findViewById(R.id.text2);
                    imageView3= (SimpleDraweeView) view.findViewById(R.id.image3);
                    text3= (TextView) view.findViewById(R.id.text3);
                    imageView4= (SimpleDraweeView) view.findViewById(R.id.image4);
                    text4= (TextView) view.findViewById(R.id.text4);
                }
            }

            class MyViewHolder4 extends XRecyclerView.ViewHolder {
                SimpleDraweeView imageView1,imageView2;
                TextView text1,text2;

                public MyViewHolder4(View view) {
                    super(view);
                    imageView1= (SimpleDraweeView) view.findViewById(R.id.image1);
                    text1= (TextView) view.findViewById(R.id.text1);
                    imageView2= (SimpleDraweeView) view.findViewById(R.id.image2);
                    text2= (TextView) view.findViewById(R.id.text2);
                }
            }

    }
