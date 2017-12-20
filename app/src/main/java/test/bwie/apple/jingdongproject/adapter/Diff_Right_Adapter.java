package test.bwie.apple.jingdongproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import test.bwie.apple.jingdongproject.R;
import test.bwie.apple.jingdongproject.bean.SonBean;

/**
 * Created by Apple on 2017/12/16.
 */

public class Diff_Right_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<SonBean.DataBean.ListBean> listBeans;

    public Diff_Right_Adapter(Context context, List<SonBean.DataBean.ListBean> listBeans) {
        this.context = context;
        this.listBeans = listBeans;
    }

    //2、定义一个属性
    private OnItemClickListener onItemClickListener;

    //1、接口回调第一步，先定义一个接口
    public interface OnItemClickListener {
        public void onItemClick(SonBean.DataBean.ListBean listBean);
    }

    //3、定义一个方法
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_diff_rv,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final SonBean.DataBean.ListBean listBean = listBeans.get(position);
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.tv.setText(listBean.getName());
        //String images = listBean.getIcon();
        //String[] sqite = images.split("\\|");
        myViewHolder.sdv.setImageURI(listBean.getIcon());
        myViewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(listBean);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView sdv;
        private TextView tv;
        private LinearLayout ll;
        public MyViewHolder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}
