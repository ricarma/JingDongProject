package test.bwie.apple.jingdongproject.view;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.hjm.bottomtabbar.BottomTabBar;

import java.util.ArrayList;
import java.util.List;

import test.bwie.apple.jingdongproject.R;
import test.bwie.apple.jingdongproject.fragment.CarFragment;
import test.bwie.apple.jingdongproject.fragment.DiffFragment;
import test.bwie.apple.jingdongproject.fragment.FindFragment;
import test.bwie.apple.jingdongproject.fragment.IndexFragment;
import test.bwie.apple.jingdongproject.fragment.MineFragment;

public class ShowActivity extends AppCompatActivity {
    //五个fragment页面
    private BottomTabBar bottomTabBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        bottomTabBar = (BottomTabBar) findViewById(R.id.bottomTabBar);
        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(100,100)
                .setFontSize(0)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.BLACK)
                .addTabItem("首页",R.drawable.ac0,IndexFragment.class)
                .addTabItem("发现",R.drawable.abw, DiffFragment.class)
                .addTabItem("分类",R.drawable.aby, FindFragment.class)
                .addTabItem("购物车",R.drawable.abu, CarFragment.class)
                .addTabItem("我的",R.drawable.ac2, MineFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
    }
}
