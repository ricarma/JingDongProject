package test.bwie.apple.jingdongproject.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import test.bwie.apple.jingdongproject.R;
import test.bwie.apple.jingdongproject.adapter.CarAdapter;
import test.bwie.apple.jingdongproject.bean.CarBean;
import test.bwie.apple.jingdongproject.bean.DeleteBean;
import test.bwie.apple.jingdongproject.event.MessageEvent;
import test.bwie.apple.jingdongproject.event.PriceAndCountEvent;
import test.bwie.apple.jingdongproject.presenter.CarPresenter;
import test.bwie.apple.jingdongproject.presenter.DeletePresenter;
import test.bwie.apple.jingdongproject.view.IView.CarView;
import test.bwie.apple.jingdongproject.view.IView.DeleteView;
import test.bwie.apple.jingdongproject.view.JieSuanActivity;

/**
 * Created by Apple on 2017/12/12.
 */

public class CarFragment extends Fragment implements CarView{
    private CarPresenter carPresenter;
    private ExpandableListView mElv;
    private CheckBox mCheckbox2;
    private TextView mTvPrice;
    private TextView mTvNum;
    private TextView tv_num;
    private CarAdapter carAdapter;
    private DeletePresenter deletePresenter;
    private String uid,pid,token;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_car,container,false);
        //接收uid和token
        Intent intent = getActivity().getIntent();
        uid = intent.getStringExtra("uid");
        token = intent.getStringExtra("token");
        pid = intent.getStringExtra("pid");
        carPresenter = new CarPresenter(this);
        carPresenter.docp(uid,token);
        //deletePresenter = new DeletePresenter(this);
        //购物车
        mElv =  view.findViewById(R.id.elv);
        mCheckbox2 =  view.findViewById(R.id.checkbox2);
        mTvPrice =  view.findViewById(R.id.tv_price);
        mTvNum =  view.findViewById(R.id.tv_num);
        tv_num = view.findViewById(R.id.tv_num);
        final String pp = mTvPrice.toString();
        tv_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), JieSuanActivity.class);
                it.putExtra("iprice", pp);
                startActivity(it);
            }
        });

        EventBus.getDefault().register(this);
        mCheckbox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carAdapter.changeAllListCbState(mCheckbox2.isChecked());
            }
        });

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    /**
     * 展示购物车
     * @param grouplist
     * @param childlist
     */
    @Override
    public void showcar(List<CarBean.DataBean> grouplist, List<List<CarBean.DataBean.ListBean>> childlist) {
        carAdapter = new CarAdapter(getContext(),grouplist,childlist);
        mElv.setAdapter(carAdapter);
        mElv.setGroupIndicator(null);
        for (int i=0;i<grouplist.size();i++){
            mElv.expandGroup(i);
        }
    }

    @Subscribe
    public void onMessageEvent(MessageEvent event){
        mCheckbox2.setChecked(event.isChecked());
    }
    @Subscribe
    public void onMessageEvent(PriceAndCountEvent event){
        mTvNum.setText("结算(" + event.getCount() + ")");
        mTvPrice.setText(event.getPrice() + "");
    }

//    @Override
//    public void showdelete(DeleteBean deleteBean) {
//        deletePresenter.dodp(uid,pid,token);
//    }
}
