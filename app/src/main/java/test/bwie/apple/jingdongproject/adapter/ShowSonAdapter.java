package test.bwie.apple.jingdongproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import test.bwie.apple.jingdongproject.R;
import test.bwie.apple.jingdongproject.bean.SearchBean;
import test.bwie.apple.jingdongproject.bean.ShowSonBean;
import test.bwie.apple.jingdongproject.view.XiangQingActivity;

/**
 * Created by Apple on 2017/12/14.
 */

public class ShowSonAdapter extends RecyclerView.Adapter<ShowSonAdapter.SearchHolder>{
    private List<ShowSonBean.DataBean> list;
    private Context context;
    public LayoutInflater inflater;

    public ShowSonAdapter(List<ShowSonBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public SearchHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.fenye_item,null);
        return new SearchHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchHolder holder, int position) {
        SearchHolder searchHolder = holder;
        ShowSonBean.DataBean dataBean = list.get(position);
        String images = dataBean.getImages();
        String[] sqite = images.split("\\|");
        holder.sdv.setImageURI(sqite[0]);
        holder.price.setText(dataBean.getPrice()+"");
        holder.title.setText(dataBean.getTitle());
        final int pid = dataBean.getPid();
        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClieck(pid+"");
            }
        });
    }
    //设置一个变量
    public ShowSonAdapter.OnItemClickListener onItemClickListener;
    //3.定义一个方法
    public void setOnItemClickListener(ShowSonAdapter.OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
    //1.首先自定义一个接口
    public interface OnItemClickListener {
        public void onItemClieck(String str);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    class SearchHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView sdv;
        TextView price,title;
        LinearLayout ll;
        public SearchHolder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.fresco);
            price = itemView.findViewById(R.id.price);
            title = itemView.findViewById(R.id.title);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}
