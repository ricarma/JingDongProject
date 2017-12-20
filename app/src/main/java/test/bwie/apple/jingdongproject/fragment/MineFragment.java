package test.bwie.apple.jingdongproject.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import test.bwie.apple.jingdongproject.R;
import test.bwie.apple.jingdongproject.view.LoginActivity;

/**
 * Created by Apple on 2017/12/12.
 */

public class MineFragment extends Fragment{
    private TextView tv_name;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine,container,false);
        tv_name = view.findViewById(R.id.tv_name);
        //点击跳转到登录界面
        tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getActivity(), LoginActivity.class);
                startActivity(it);
            }
        });
        return view;
    }
}
