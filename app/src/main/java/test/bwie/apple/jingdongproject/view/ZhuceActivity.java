package test.bwie.apple.jingdongproject.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import test.bwie.apple.jingdongproject.R;
import test.bwie.apple.jingdongproject.bean.RegBean;
import test.bwie.apple.jingdongproject.presenter.RegPrensenter;
import test.bwie.apple.jingdongproject.view.IView.RegView;

public class ZhuceActivity extends AppCompatActivity implements RegView{
    private RegPrensenter regPrensenter;
    private Button bt;
    private EditText et1,et2;
    private String mobile,pass;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        regPrensenter = new RegPrensenter(this);
        iv = findViewById(R.id.iv_exit);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent it = new Intent(ZhuceActivity.this,LoginActivity.class);
//                startActivity(it);
                finish();
            }
        });
        bt = findViewById(R.id.bt_zhuce);
        et1 = findViewById(R.id.et_name);

        et2 = findViewById(R.id.et_password);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mobile = et1.getText().toString();
                pass = et2.getText().toString();
                regPrensenter.dorp(mobile,pass);
            }
        });
    }

    @Override
    public void showreg(String data,String msg) {
        if (data.equals("0")){
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
            if (msg.equals("注册成功")){
                Intent it = new Intent(this,ShowActivity.class);
                startActivity(it);
                finish();
            }
        }else {
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
            et1.setText("");
            et2.setText("");
        }
    }
}
