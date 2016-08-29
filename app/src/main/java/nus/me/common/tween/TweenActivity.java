package nus.me.common.tween;

import android.app.Dialog;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import nus.me.common.R;

public class TweenActivity extends AppCompatActivity {

    @BindView(R.id.iv)
        ImageView iv;

    @BindView(R.id.iv1)
    ImageView iv1;

    @BindView(R.id.btn_dialog)
    Button btn_dialog;
    @BindView(R.id.lv)
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);
        ButterKnife.bind(this);


        Animation testrotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        testrotate.setDuration(3000);
        testrotate.setRepeatCount(-1);
        iv.startAnimation(testrotate );

        Animation anim = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        LinearInterpolator lir = new LinearInterpolator();
        anim.setInterpolator(lir);
        anim.setDuration(2000);
        iv1.setAnimation(anim);


        final SelectDialogFragment fragment = new SelectDialogFragment();


        btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment.show(getSupportFragmentManager(),"select");
            }
        });

        MySimplAdapter adapter = new MySimplAdapter(TweenActivity.this);
        lv.setAdapter(adapter);





    }
}
