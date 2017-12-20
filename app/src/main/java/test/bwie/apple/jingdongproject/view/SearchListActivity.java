package test.bwie.apple.jingdongproject.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import test.bwie.apple.jingdongproject.R;
import test.bwie.apple.jingdongproject.adapter.SearchAdapter;
import test.bwie.apple.jingdongproject.bean.SearchBean;
import test.bwie.apple.jingdongproject.presenter.SearchPresenter;
import test.bwie.apple.jingdongproject.view.IView.SearchView;

public class SearchListActivity extends AppCompatActivity implements SearchView{
    public SearchPresenter searchPresenter;
    private ImageView mBack;
    private EditText mImg;
    private ImageView mQiehuan;
    private RecyclerView mRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list);
        initView();
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        Toast.makeText(SearchListActivity.this,name,Toast.LENGTH_SHORT).show();
        searchPresenter = new SearchPresenter(this);
        searchPresenter.dofind(name);
        mImg.setText(name);
        back();
    }

    private void back() {
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent uu = new Intent(SearchListActivity.this,SearchActivity.class);
//                startActivity(uu);
                finish();
            }
        });
    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.back);
        mImg = (EditText) findViewById(R.id.img);
        mQiehuan = (ImageView) findViewById(R.id.qiehuan);
        mRv = (RecyclerView) findViewById(R.id.rv);
    }
    //展示数据
    @Override
    public void showsearch(List<SearchBean.DataBean> list) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRv.setLayoutManager(linearLayoutManager);
        SearchAdapter mySearchAdapter = new SearchAdapter(list, this);
        mRv.setAdapter(mySearchAdapter);
        mySearchAdapter.setOnItemClickListener(new SearchAdapter.OnItemClickListener() {
            @Override
            public void onItemClieck(String str) {
                Intent it = new Intent(SearchListActivity.this,XiangQingActivity.class);
                it.putExtra("pid",str);
                startActivity(it);
            }
        });
    }
}
