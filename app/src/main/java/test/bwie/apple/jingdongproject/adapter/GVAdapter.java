package test.bwie.apple.jingdongproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import test.bwie.apple.jingdongproject.R;
import test.bwie.apple.jingdongproject.bean.DiffBean;
import test.bwie.apple.jingdongproject.view.ShowSonActivity;

/**
 * Created by Apple on 2017/12/13.
 */

public class GVAdapter extends BaseAdapter{
    private List<DiffBean.DataBean> list;
    private Context context;
    private LayoutInflater inflater;

    public GVAdapter(List<DiffBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v;
        ViewHolder holder;
        if (view==null){
            holder = new ViewHolder();
            v = View.inflate(context,R.layout.item_vp,null);
            holder.sdv = v.findViewById(R.id.sdv);
            holder.tv = v.findViewById(R.id.sdv_tv);
            holder.ll = v.findViewById(R.id.ll);
            v.setTag(holder);
        }else {
            v = view;
            holder = (ViewHolder) v.getTag();
        }
        String images = list.get(i).getIcon();
        String[] sqite = images.split("\\|");
        holder.sdv.setImageURI(sqite[0]);
        holder.tv.setText(list.get(i).getName());
        //final int cid = list.get(i).getCid();
        return v;
    }
    class ViewHolder{
        TextView tv;
        SimpleDraweeView sdv;
        LinearLayout ll;
    }
}
