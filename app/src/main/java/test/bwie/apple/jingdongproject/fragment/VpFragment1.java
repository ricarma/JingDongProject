package test.bwie.apple.jingdongproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import test.bwie.apple.jingdongproject.R;
import test.bwie.apple.jingdongproject.adapter.GVAdapter;
import test.bwie.apple.jingdongproject.bean.DiffBean;
import test.bwie.apple.jingdongproject.presenter.DiffPresenter;
import test.bwie.apple.jingdongproject.view.IView.DiffView;

/**
 * Created by Apple on 2017/12/13.
 */

public class VpFragment1 extends Fragment implements DiffView{
    private GridView gv;
    private GVAdapter gvAdapter;
    private DiffPresenter diffPresenter;
    private List<DiffBean.DataBean> glist = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vp1,container,false);
        gv = view.findViewById(R.id.gridview);
        diffPresenter = new DiffPresenter(this);
        diffPresenter.dodo2();
        return view;
    }


    @Override
    public void showdiff(DiffBean diffBean) {
        List<DiffBean.DataBean> list = diffBean.getData();
        for (int i=0;i<10;i++){
            DiffBean.DataBean dataBean = list.get(i);
            glist.add(dataBean);
        }
        gvAdapter = new GVAdapter(glist,getContext());
        gv.setAdapter(gvAdapter);
    }
}
