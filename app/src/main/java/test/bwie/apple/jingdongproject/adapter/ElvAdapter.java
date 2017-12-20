package test.bwie.apple.jingdongproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

import test.bwie.apple.jingdongproject.R;
import test.bwie.apple.jingdongproject.bean.SonBean;
import test.bwie.apple.jingdongproject.view.SearchListActivity;
import test.bwie.apple.jingdongproject.view.ShowSonActivity;
import test.bwie.apple.jingdongproject.view.XiangQingActivity;

/**
 * Created by Apple on 2017/12/16.
 */

public class ElvAdapter extends BaseExpandableListAdapter{
    private Context context;
    private List<String> grouplist;
    private List<List<SonBean.DataBean.ListBean>> childlist;
    private LayoutInflater inflater;

    public ElvAdapter(Context context, List<String> grouplist, List<List<SonBean.DataBean.ListBean>> childlist) {
        this.context = context;
        this.grouplist = grouplist;
        this.childlist = childlist;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return grouplist.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override
    public Object getGroup(int i) {
        return grouplist.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return childlist.get(i).get(i1);
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
        View v;
        GroupHolder holder;
        if (view==null){
            holder = new GroupHolder();
            v = inflater.inflate(R.layout.item_diff1,null);
            holder.tv = v.findViewById(R.id.tv);
            v.setTag(holder);
        }else {
            v = view;
            holder = (GroupHolder) v.getTag();
        }
        String s = grouplist.get(i);
        holder.tv.setText(s);
        return v;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        View v;
        ChildHolder holder;
        if (view==null){
            holder = new ChildHolder();
            v = inflater.inflate(R.layout.item_diff2,null);
            holder.diffrv = v.findViewById(R.id.diffrv);
            v.setTag(holder);
        }else {
            v = view;
            holder = (ChildHolder) v.getTag();
        }
        final List<SonBean.DataBean.ListBean> listBeans = childlist.get(i);
        holder.diffrv.setLayoutManager(new GridLayoutManager(context,3));
        Diff_Right_Adapter adapter = new Diff_Right_Adapter(context,listBeans);
        holder.diffrv.setAdapter(adapter);
        adapter.setOnItemClickListener(new Diff_Right_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(SonBean.DataBean.ListBean listBean) {
                Intent intent = new Intent(context, ShowSonActivity.class);
                intent.putExtra("pscid",listBean.getPscid());
                context.startActivity(intent);
            }
        });
        return v;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
    class GroupHolder{
        TextView tv;
    }
    class ChildHolder{
        RecyclerView diffrv;
    }
}
