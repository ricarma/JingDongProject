package test.bwie.apple.jingdongproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import test.bwie.apple.jingdongproject.R;
import test.bwie.apple.jingdongproject.bean.IndexBean;
import test.bwie.apple.jingdongproject.view.XiangQingActivity;

/**
 * Created by Apple on 2017/12/13.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder>{
    private Context context;
    private List<IndexBean.TuijianBean.ListBean> list;
    private LayoutInflater inflater;

    public RVAdapter(Context context, List<IndexBean.TuijianBean.ListBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_index_rv,null);
        return new MyViewHolder(view);
    }
    //设置一个变量
    public OnItemClickListener onItemClickListener;
    //3.定义一个方法
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
    //1.首先自定义一个接口
    public interface OnItemClickListener {
        public void onItemClieck(String str);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        IndexBean.TuijianBean.ListBean listBean = list.get(position);
        MyViewHolder myViewHolder = holder;
        String images = listBean.getImages();
        String[] sqite = images.split("\\|");
        holder.sdv.setImageURI(sqite[0]);
        holder.tv1.setText(listBean.getTitle());
        holder.tv2.setText(listBean.getPrice()+"");
        final int pid = listBean.getPid();
        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClieck(pid+"");
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView sdv;

        TextView tv1,tv2;
        LinearLayout ll;
        public MyViewHolder(View itemView) {
            super(itemView);
            ll = itemView.findViewById(R.id.ll);
            sdv = itemView.findViewById(R.id.rv_sdv);
            tv1 = itemView.findViewById(R.id.rv_tv);
            tv2 = itemView.findViewById(R.id.rv_price);
        }
    }
}
