package test.bwie.apple.jingdongproject.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import test.bwie.apple.jingdongproject.R;

public class JieSuanActivity extends AppCompatActivity {
    private Button bt,bt2;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jie_suan);
        bt = findViewById(R.id.button);
        bt2 = findViewById(R.id.button2);
        imageView = findViewById(R.id.imageView2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(JieSuanActivity.this,AddressActivity.class);
                startActivity(it);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        Intent intent = getIntent();
        String price = intent.getStringExtra("iprice");
        Toast.makeText(JieSuanActivity.this,"订单已产生",Toast.LENGTH_SHORT).show();
    }
}
