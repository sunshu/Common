package nus.me.common.property;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import nus.me.common.R;

public class PropertyActivity extends AppCompatActivity {

    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.iv1)
    ImageView iv1;

    @BindView(R.id.iv_y)
    ImageView ivy;
    @BindView(R.id.iv_r)
    ImageView ivr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
        ButterKnife.bind(this);




    }

    @OnClick(R.id.iv)
    public void onIvClick(View view){
        Intent intent = new Intent(Intent.ACTION_PICK,null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
        startActivityForResult(intent,100);

    }

    @OnClick(R.id.iv_r)
    public void onRedClick(View view){
        ObjectAnimator anim = new ObjectAnimator();
        anim.ofFloat(view,"translationX",0,ivy.getX()-ivr.getX()).setDuration(2000).start();
        anim.ofFloat(ivy,"translationX",0,-ivy.getX()+ivr.getX()).setDuration(2000).start();
    }



    @OnClick(R.id.iv1)
    public void onPClick(View view){

        ObjectAnimator anim1 = ObjectAnimator.ofFloat(iv1, "translationX", 0, 200).setDuration(2000);// 位移
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(iv1, "translationY", 0, 200).setDuration(2000);
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(iv1, "rotation", 0, 600).setDuration(2000); // 旋转、
//        ObjectAnimator anim4 = ObjectAnimator.ofFloat(iv1,"");

        android.animation.AnimatorSet set1 = new AnimatorSet();
        set1.playTogether(anim1,anim2,anim3);
        set1.start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode ==RESULT_OK && requestCode == 100){
            if (data!= null){
                iv.setImageURI(data.getData());
            }
        }

    }
}
