package test.bwie.apple.jingdongproject.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import test.bwie.apple.jingdongproject.R;

public class MainActivity extends AppCompatActivity {
    //展示三秒后跳转
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent it = new Intent(MainActivity.this,ShowActivity.class);
                startActivity(it);
                finish();
            }
        },3000);
    }
}
