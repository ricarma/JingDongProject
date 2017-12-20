package test.bwie.apple.jingdongproject.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import test.bwie.apple.jingdongproject.R;
import test.bwie.apple.jingdongproject.bean.LoginBean;
import test.bwie.apple.jingdongproject.net.MyApp;
import test.bwie.apple.jingdongproject.presenter.LoginPresenter;
import test.bwie.apple.jingdongproject.view.IView.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView{
    private TextView tv_zhuce;
    private EditText et1,et2;
    private Button bt;
    private LoginPresenter loginPresenter;
    private String mobile,pass;
    private ImageView iv,qq,weixin;
    private SharedPreferences sharedPreferences;
    private static final String TAG = "MainActivity";
    private static final String APP_ID = "1105602574";//官方获取的APPID
    private Tencent mTencent;
    private BaseUiListener mIUiListener;
    private UserInfo mUserInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mTencent = Tencent.createInstance(APP_ID,LoginActivity.this.getApplicationContext());
        tv_zhuce = findViewById(R.id.tv_zhuce);
        iv = findViewById(R.id.iv_exit);
        qq = findViewById(R.id.qq);
        weixin = findViewById(R.id.weixin);
        //点击QQ登录
        qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIUiListener = new BaseUiListener();
                mTencent.login(LoginActivity.this,"all", mIUiListener);
            }
        });
        sharedPreferences = getSharedPreferences("users",MODE_PRIVATE);
        //点击返回
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //点击跳转注册界面
        tv_zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(LoginActivity.this,ZhuceActivity.class);
                startActivity(it);
            }
        });
        loginPresenter = new LoginPresenter(this);

        bt = findViewById(R.id.bt_login);

        //获取输入的手机号和密码
        et1 = findViewById(R.id.et_name);
        et2 = findViewById(R.id.et_password);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mobile = et1.getText().toString();
                pass = et2.getText().toString();
                loginPresenter.dolp(mobile,pass);
            }
        });
    }

    @Override
    public void showlogin(LoginBean loginBean) {
        String code = loginBean.getCode();
        String msg = loginBean.getMsg();
        if (code.equals("0")){
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
            int uid2 = loginBean.getData().getUid();
            String token2 = loginBean.getData().getToken();
            //存值
            MyApp.edit.putString("uid2",uid2+"");
            MyApp.edit.putString("token2",token2);
            MyApp.edit.commit();
            LoginBean.DataBean dataBean = loginBean.getData();

            final int uid = dataBean.getUid();
            String token = dataBean.getToken();
            Intent it = new Intent(LoginActivity.this,ShowActivity.class);
            it.putExtra("uid",uid+"");
            it.putExtra("token",token);
            Log.i("hhh",token);
            startActivity(it);
            finish();
        }else {
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
            et1.setText("");
            et2.setText("");
        }
    }

    //第三方QQ登录
    private class BaseUiListener implements IUiListener {
        @Override
        public void onComplete(Object response) {
            Toast.makeText(LoginActivity.this, "授权成功", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "response:" + response);
            JSONObject obj = (JSONObject) response;
            try {
                String openID = obj.getString("openid");
                String accessToken = obj.getString("access_token");
                String expires = obj.getString("expires_in");
                mTencent.setOpenId(openID);
                mTencent.setAccessToken(accessToken,expires);
                QQToken qqToken = mTencent.getQQToken();
                mUserInfo = new UserInfo(getApplicationContext(),qqToken);
                mUserInfo.getUserInfo(new IUiListener() {
                    @Override
                    public void onComplete(Object response) {
                        finish();
                        Log.e(TAG,"登录成功"+response.toString());

                    }

                    @Override
                    public void onError(UiError uiError) {
                        Log.e(TAG,"登录失败"+uiError.toString());
                    }

                    @Override
                    public void onCancel() {
                        Log.e(TAG,"登录取消");

                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onError(UiError uiError) {
            Toast.makeText(LoginActivity.this, "授权失败", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCancel() {
            Toast.makeText(LoginActivity.this, "授权取消", Toast.LENGTH_SHORT).show();

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == Constants.REQUEST_LOGIN){
            Tencent.onActivityResultData(requestCode,resultCode,data,mIUiListener);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
