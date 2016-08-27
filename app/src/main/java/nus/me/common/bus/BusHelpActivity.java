package nus.me.common.bus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import nus.me.common.R;

public class BusHelpActivity extends AppCompatActivity {

    private TextView tv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_help);

        EventBus.getDefault().register(this);
        tv_content = (TextView) findViewById(R.id.tv_content);
    }

    @Subscribe(threadMode = ThreadMode.MAIN) //在ui线程执行
    public void onUserEvent(MyEvent event) {
        if (event.getType().equals("0")){
            tv_content.setText(""+event.getContent());
        }
    }
}
