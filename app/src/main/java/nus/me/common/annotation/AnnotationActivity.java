package nus.me.common.annotation;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import nus.me.common.R;

public class AnnotationActivity extends AppCompatActivity {

    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.lv)
    ListView lv;

    List Datas = new ArrayList<TData>();;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotation);
        ButterKnife.bind(this);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AnnotationActivity.this,"btn2",Toast.LENGTH_SHORT).show();
            }
        });

        iniData();
        MyAdapter adapter = new MyAdapter(Datas,this);
        lv.setAdapter(adapter);



    }


    TData data ;
    private void iniData() {
        data = new TData();
        for (int i = 0; i < 30; i++) {
            data.setTitle("title"+i);
            data.setData("data"+i);
            Datas.add(data);
        }
    }


    @OnClick(R.id.btn1)
    public void onSelect1(View v){
        Toast.makeText(this,"btn1",Toast.LENGTH_SHORT).show();
    }
    @OnItemClick(R.id.lv)
    public void onItemClick(int position){
        Toast.makeText(this,"item"+position,Toast.LENGTH_SHORT).show();
    }
}
