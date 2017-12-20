package test.bwie.apple.jingdongproject.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import test.bwie.apple.jingdongproject.R;
import test.bwie.apple.jingdongproject.adapter.RVAdapter;
import test.bwie.apple.jingdongproject.bean.IndexBean;
import test.bwie.apple.jingdongproject.bean.JoinBean;
import test.bwie.apple.jingdongproject.bean.LoginBean;
import test.bwie.apple.jingdongproject.bean.XiangQingBean;
import test.bwie.apple.jingdongproject.net.ImageLoaderHelper;
import test.bwie.apple.jingdongproject.net.MyApp;
import test.bwie.apple.jingdongproject.presenter.JoinPresenter;
import test.bwie.apple.jingdongproject.presenter.XiangQingPresenter;
import test.bwie.apple.jingdongproject.view.IView.IndexView;
import test.bwie.apple.jingdongproject.view.IView.JoinView;
import test.bwie.apple.jingdongproject.view.IView.XiangQingView;

public class XiangQingActivity extends AppCompatActivity implements XiangQingView,JoinView{
    private XiangQingPresenter xiangQingPresenter;
    private JoinPresenter joinPresenter;
    private RVAdapter rvAdapter;
    //详情商品名和价钱
    private TextView tv1,tv2;
    private Banner banner;
    private List<String> list;
    private ImageView ivv;
    private Button bt_join;
    private String pid,uid,token;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("uesrs",MODE_PRIVATE);
        setContentView(R.layout.activity_xiang_qing);
        //点击返回
        ivv = findViewById(R.id.iv_edit);
        ivv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //加入购物车
        bt_join = findViewById(R.id.bt_join);
        //接收pid
        Intent intent = getIntent();
        pid = intent.getStringExtra("pid");
//        token = intent.getStringExtra("token");
//        uid = intent.getStringExtra("uid");

//        uid = sharedPreferences.getString("uid2",uid);
//        pid = sharedPreferences.getString("pid",pid);
//        token = sharedPreferences.getString("token2",token);
//        Toast.makeText(XiangQingActivity.this,uid+pid+token,Toast.LENGTH_SHORT).show();

        String uid2 = MyApp.sp.getString("uid2", "");
        String token2 = MyApp.sp.getString("token2", "");

        xiangQingPresenter = new XiangQingPresenter(this);
        xiangQingPresenter.doxq(pid);
        joinPresenter = new JoinPresenter(this);
        joinPresenter.dojp(uid2,pid,token2);
    }
    @Override
    public void showxiangqing(XiangQingBean xiangQingBean) {
        tv1 = findViewById(R.id.tv_goods_name);
        tv2 = findViewById(R.id.tv_goods_price);
        //详情banner
        banner = findViewById(R.id.banner_lun);
        banner.setImageLoader(new ImageLoaderHelper());
        String images = xiangQingBean.getData().getImages();
        String[] image = images.split("\\|");
        list = new ArrayList<>();
        for (int i=0;i<3;i++){
            list.add(image[i]);
        }
        banner.setImages(list);
        banner.setBannerAnimation(Transformer.CubeIn);
        banner.start();
        //详情p层
        tv1.setText(xiangQingBean.getData().getTitle());
        tv2.setText(xiangQingBean.getData().getPrice()+"");

    }

    @Override
    public void showjoin(JoinBean joinBean) {
        final String msg = joinBean.getMsg();
        bt_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(XiangQingActivity.this,msg,Toast.LENGTH_SHORT).show();

            }
        });
    }
}
