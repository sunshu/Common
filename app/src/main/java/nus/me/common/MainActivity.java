package nus.me.common;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Annotation;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import nus.me.common.annotation.AnnotationActivity;
import nus.me.common.bus.BusActivity;
import nus.me.common.game1.Game1Activity;
import nus.me.common.img.Img_Activity;
import nus.me.common.net.NetActivity;
import nus.me.common.property.PropertyActivity;
import nus.me.common.tween.TweenActivity;
import nus.me.common.ui.activity.ViewActivity;
import nus.me.common.update.UpdateActivity;
import nus.me.common.view.TopBar.TopBar;


public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private Button btn_net;
    private Button btn_view;
    private Button btn_bus;
    private Button btn_img;
    private Button btn_annotation;
    private Button btn_tween;
    private Button btn_property;
    private Button btn_game1;// 拼图
    private Button btn_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initTopBar();

        initView();

        intHandler();

    }

    private void intHandler() {

//      Loop 只能调用一次
//　     Looper.prepare();
        Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
            }
        };
        Message msg = new Message();
        Bundle bundle = new Bundle();
        msg.setData(bundle);
        handler.sendMessage(msg);


    }



    private void initView() {
        btn_net = (Button) findViewById(R.id.btn_net);
        btn_net.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,NetActivity.class));
            }
        });
        btn_img = (Button) findViewById(R.id.btn_img);
        btn_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Img_Activity.class));
            }
        });

        btn_bus = (Button) findViewById(R.id.btn_bus);
        btn_bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BusActivity.class));
            }
        });

        btn_annotation = (Button) findViewById(R.id.btn_annotation);
        btn_annotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AnnotationActivity.class));
            }
        });


        btn_tween = (Button) findViewById(R.id.btn_tween);
        btn_tween.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,TweenActivity.class));
            }
        });
        btn_property = (Button) findViewById(R.id.btn_property);
        btn_property.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,PropertyActivity.class));
            }
        });
        btn_game1 = (Button) findViewById(R.id.btn_game1);
        btn_game1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Game1Activity.class));
            }
        });

        btn_update = (Button) findViewById(R.id.btn_update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,UpdateActivity.class));
            }
        });

        btn_view = (Button) findViewById(R.id.btn_view);
        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ViewActivity.class));
            }
        });


    }

    private void initTopBar() {

        TopBar topbar = findV(R.id.topbar);
        topbar.setOnTopBarClickLListener(new TopBar.OnTopBarClickListener() {
            @Override
            public void onLeftButtonClick() {
                Log.e("Tag","TopBarLeft.onClick");
                Toast.makeText(MainActivity.this,"ToastLeft",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightButtonClick() {
                Log.e("Tag","TopBarRight.onClick");
                Toast.makeText(MainActivity.this,"ToastRight",Toast.LENGTH_SHORT).show();
            }
        });

        topbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("Tag","TopBar.onClick");
                Toast.makeText(MainActivity.this,"ToastTopBar",Toast.LENGTH_SHORT).show();

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String result ="";



        return super.onOptionsItemSelected(item);
    }

    public <T extends View> T findV(int resId){
        return (T) findViewById(resId);
    }


}
