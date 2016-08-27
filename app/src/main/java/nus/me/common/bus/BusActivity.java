package nus.me.common.bus;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import nus.me.common.R;

public class BusActivity extends AppCompatActivity {

    private Button btn_send;
    private TextView tv_get;

    @Subscribe
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);


        EventBus.getDefault().register(this);
        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BusFragment busFragment = new BusFragment();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fl,busFragment);
                transaction.commit();

            }
        });

        btn_send = (Button) findViewById(R.id.btn_send);
        tv_get = (TextView) findViewById(R.id.tv_get);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            MyEvent myEvent = new MyEvent();
                myEvent.setType("0");
                myEvent.setContent("content");
            EventBus.getDefault().post(myEvent);


            }
        });

    }




    @Subscribe(threadMode = ThreadMode.MAIN) //在ui线程执行
    public void onUserEvent(MyEvent event) {
        if (event.getType().equals("0")){
            tv_get.setText(""+event.getContent());
        }
    }


//
//    @Subscribe(threadMode = ThreadMode.BACKGROUND) //在后台线程执行
//    public void onUserEvent(MyEvent event) {
//
//    }
//
//    @Subscribe(threadMode = ThreadMode.ASYNC) //强制在后台执行
//    public void onUserEvent(MyEvent event) {
//
//    }
//
//    @Subscribe(threadMode = ThreadMode.POSTING) //默认方式, 在发送线程执行
//    public void onUserEvent(MyEvent event) {
//
//    }





    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
