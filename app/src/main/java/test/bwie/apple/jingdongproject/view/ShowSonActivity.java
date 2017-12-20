package test.bwie.apple.jingdongproject.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import test.bwie.apple.jingdongproject.R;
import test.bwie.apple.jingdongproject.adapter.ShowSonAdapter;
import test.bwie.apple.jingdongproject.bean.JoinBean;
import test.bwie.apple.jingdongproject.bean.ShowSonBean;
import test.bwie.apple.jingdongproject.bean.SonBean;
import test.bwie.apple.jingdongproject.presenter.JoinPresenter;
import test.bwie.apple.jingdongproject.presenter.ShowSonPresenter;
import test.bwie.apple.jingdongproject.view.IView.JoinView;
import test.bwie.apple.jingdongproject.view.IView.ShowSonView;
import test.bwie.apple.jingdongproject.view.IView.SonView;

public class ShowSonActivity extends AppCompatActivity implements ShowSonView{

    private ShowSonPresenter showSonPresenter;
    private ShowSonAdapter showSonAdapter;
    private RecyclerView rv;
    private ImageView iv;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_son);
        rv = findViewById(R.id.rv);
        iv = findViewById(R.id.back);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Intent intent = getIntent();
        String pscid = intent.getStringExtra("pscid");
        showSonPresenter = new ShowSonPresenter(this);
        showSonPresenter.doss(pscid);
        sharedPreferences = getSharedPreferences("uesrs",MODE_PRIVATE);

    }

    /**
     * 展示子类详情
     * @param showSonBean
     */
    @Override
    public void showshowson(ShowSonBean showSonBean) {
        List<ShowSonBean.DataBean> list = showSonBean.getData();
        showSonAdapter = new ShowSonAdapter(list,this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(showSonAdapter);
        showSonAdapter.setOnItemClickListener(new ShowSonAdapter.OnItemClickListener() {
            @Override
            public void onItemClieck(String str) {
                Intent it = new Intent(ShowSonActivity.this, XiangQingActivity.class);
                it.putExtra("pid",str);
                String uid = sharedPreferences.getString("uid2","");
                String token = sharedPreferences.getString("token2","");
                it.putExtra("uid",uid);
                it.putExtra("token",token);
                startActivity(it);
            }
        });
    }
}
