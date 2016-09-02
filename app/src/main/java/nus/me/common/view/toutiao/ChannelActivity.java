package nus.me.common.view.toutiao;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import nus.me.common.R;

public class ChannelActivity extends AppCompatActivity implements View.OnClickListener {

    Context context;
    private List<ChannelModel> myChannel = new ArrayList();
    private List<ChannelModel> allChannel = new ArrayList();
    private List<String> myStrs = new ArrayList<String>();
    private List<String> allStrs = new ArrayList<String>();


    @BindView(R.id.fbl_my)
    FlexboxLayout fbl_my;
    @BindView(R.id.fbl_all)
    FlexboxLayout fbl_all;
    @BindView(R.id.btn_MyChannel)
    Button btn_my;
    @BindView(R.id.btn_AllChannel)
    Button btn_all;
    private ViewGroup.LayoutParams btn_params;
    private Button btn_mytemp;
    private Button btn_alltemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);
        ButterKnife.bind(this);
        context = this;
        initData();
        initWidget();

        initEvent();


    }

    private void initEvent() {


    }

    private void initWidget() {

    }

    private void getBtnParams() {
        btn_params = btn_my.getLayoutParams();



    }

    private void initData() {

        myStrs.add("推荐");
        myStrs.add("新闻");
        myStrs.add("体育");
        myStrs.add("科技");

        allStrs.add("北京");
        allStrs.add("汽车");
        allStrs.add("热点");
        allStrs.add("直播");
        allStrs.add("房产");
        allStrs.add("健康");
        allStrs.add("财经");
        getBtnParams();
        for (int i = 0; i < myStrs.size(); i++) {
            Button button = new Button(context);
            button.setLayoutParams(btn_params);
            button.setText(myStrs.get(i));
            button.setTag(myStrs.get(i));
            button.setOnClickListener(this);
            fbl_my.addView(button);
        }
        for (int i = 0; i < allStrs.size(); i++) {
            Button button = new Button(context);
            button.setLayoutParams(btn_params);
            button.setText(allStrs.get(i));
            button.setTag(allStrs.get(i));
            button.setTag(allStrs.get(i));
            button.setOnClickListener(this);
            fbl_all.addView(button);
        }

        addTempButton();


    }
    public void addTempButton(){
        btn_mytemp = new Button(context);

        btn_mytemp.setLayoutParams(btn_params);
        btn_mytemp.setText(">?<");

        btn_alltemp = new Button(context);
        btn_alltemp.setText("./.");

        fbl_my.addView(btn_mytemp);
        fbl_all.addView(btn_alltemp);

    }
    int i =1;

    @Override
    public void onClick(View view) {
        FlexboxLayout fbl = (FlexboxLayout) view.getParent();
        if (fbl == fbl_my){
            Float afterX = btn_alltemp.getX()+btn_alltemp.getTop();
            Float afterY = btn_alltemp.getY()+btn_alltemp.getLeft();
//            Float beforX = view.getX()+view.getTop();
//            Float beforY = view.getY()+view.getLeft();
            Float beforX = view.getTranslationX();
            Float beforY = view.getTranslationY();

            ObjectAnimator a1 = ObjectAnimator.ofFloat(view,"X",0f,300f);
            ObjectAnimator a2 = ObjectAnimator.ofFloat(view,"y",0f,300f);
            AnimatorSet set = new AnimatorSet();
            set.playTogether(a1,a2);
            set.setDuration(3000);
            set.start();



        }

    }
}
