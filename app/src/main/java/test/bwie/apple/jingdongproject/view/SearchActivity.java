package test.bwie.apple.jingdongproject.view;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import test.bwie.apple.jingdongproject.R;
import test.bwie.apple.jingdongproject.net.FlowGroupView;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView mBack;
    private EditText mEdName;
    /**
     * 搜索
     */
    private TextView mSousuo;
    private ListView mLv;
    /**
     * 清空历史记录
     */
    private Button btn;
    private LinearLayout mLsjl;
    private FlowGroupView flowGroupView;
    private ArrayList<String> strings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
        addData();
        back();
        listener();
        SouSuoClick();

    }
    //返回
    private void back() {
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent oo = new Intent(SearchActivity.this,ShowActivity.class);
                startActivity(oo);
            }
        });
    }
    //提示搜索内容
    private void listener() {
        mBack.setOnClickListener(this);
    }
    private void addData() {
        strings = new ArrayList<>();
        strings.add("电脑");
        strings.add("相机");
        strings.add("手机");
        strings.add("玩具");
        strings.add("零食");
        strings.add("蛋糕");
        strings.add("服装");
        strings.add("进口饮料/零食/蛋糕");
        strings.add("高档服侍/鞋类/包类");
        strings.add("婴儿用具/衣服/童鞋");
        //为布局添加内容
        for (int i = 0; i < strings.size(); i++) {
            addTextView(strings.get(i));
        }
    }

    private void addTextView(String s) {
        TextView child = new TextView(this);
        ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT);
        params.setMargins(5, 5, 5, 5);
        child.setLayoutParams(params);
        child.setBackgroundResource(R.drawable.flag);
        child.setText(s);
        child.setTextColor(Color.parseColor("#ffffff"));
        //监听
        flowGroupView.addView(child);
    }
    //点击搜索按钮跳转搜索列表
    private void SouSuoClick() {
        mSousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mEdName.getText().toString().trim();
                if (TextUtils.isEmpty(name)){
                    Toast.makeText(SearchActivity.this,"输入为空噢",Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(SearchActivity.this, SearchListActivity.class);
                    intent.putExtra("name", name);
                    startActivity(intent);
                }
            }
        });
    }
    private void initView() {
        btn = findViewById(R.id.btn);
        mBack =  findViewById(R.id.back);
        mEdName =  findViewById(R.id.ed_name);
        mSousuo =  findViewById(R.id.sousuo);
        mLv = (ListView) findViewById(R.id.lv);
        btn.setOnClickListener(this);
        mBack.setOnClickListener(this);
        mLsjl = (LinearLayout) findViewById(R.id.lsjl);
        flowGroupView = (FlowGroupView) findViewById(R.id.flowGroupView);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn:
                break;
            case R.id.back:
                finish();
                break;
        }
    }
}
