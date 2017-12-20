package test.bwie.apple.jingdongproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import test.bwie.apple.jingdongproject.R;
import test.bwie.apple.jingdongproject.bean.DiffBean;

/**
 * Created by Apple on 2017/12/13.
 */

public class LVAdapter extends BaseAdapter{
    private List<DiffBean.DataBean> list;
    private Context context;
    private LayoutInflater inflater;

    public LVAdapter(List<DiffBean.DataBean> list, Context context) {
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
            v = View.inflate(context, R.layout.item_diff_listview,null);
            holder.tv = v.findViewById(R.id.lv_tv);
            v.setTag(holder);
        }else {
            v = view;
            holder = (ViewHolder) v.getTag();
        }
        holder.tv.setText(list.get(i).getName());
        return v;
    }
    class ViewHolder{
        TextView tv;
    }
}
