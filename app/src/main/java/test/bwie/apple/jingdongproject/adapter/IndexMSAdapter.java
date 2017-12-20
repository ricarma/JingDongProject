package test.bwie.apple.jingdongproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import test.bwie.apple.jingdongproject.R;
import test.bwie.apple.jingdongproject.bean.IndexBean;

/**
 * Created by Apple on 2017/12/14.
 */

public class IndexMSAdapter extends BaseAdapter {
    private List<IndexBean.MiaoshaBean.ListBeanX> list;
    private Context context;
    private LayoutInflater inflater;

    public IndexMSAdapter(List<IndexBean.MiaoshaBean.ListBeanX> list, Context context) {
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
            v = View.inflate(context, R.layout.item_ms,null);
            holder.sdv = v.findViewById(R.id.sdv);
            holder.tv = v.findViewById(R.id.sdv_tv);
            v.setTag(holder);
        }else {
            v = view;
            holder = (ViewHolder) v.getTag();
        }
        IndexBean.MiaoshaBean.ListBeanX listBeanX = list.get(i);
        holder.sdv.setImageURI(listBeanX.getImages());
        holder.tv.setText(listBeanX.getPrice()+"");
        return v;
    }
    class ViewHolder{
        TextView tv;
        SimpleDraweeView sdv;
    }
}
