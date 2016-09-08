package nus.me.common.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import nus.me.common.R;
import nus.me.common.view.ListView.ListViewActivity;
import nus.me.common.view.hongyang.HYActivity;
import nus.me.common.view.toutiao.ChannelActivity;
import nus.me.common.view.widget.LeftListView;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        ButterKnife.bind(this);





    }

    @OnClick(R.id.btn_toutiao)
    public void onToutiaoCLick(View view){
        startActivity(new Intent(this, ChannelActivity.class));

    }

    @OnClick(R.id.btn_lv)
    public void onLeftCLick(View view){
        startActivity(new Intent(this, ListViewActivity.class));

    }
    @OnClick(R.id.btn_hongyang)
    public void onHYCLick(View view){
        startActivity(new Intent(this, HYActivity.class));
    }




}
