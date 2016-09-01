package nus.me.common.game1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;
import nus.me.common.R;

public class Game1Activity extends AppCompatActivity {

    private Context mContext;
    // 利用二位数组创建若干二位小方块
    private ImageView[][] iv_game_arr = new ImageView[3][5];
    @BindView(R.id.gl_main)
    GridLayout gl_main;

    private ImageView iv_null ;
    private int bgBitmapwidth;
    private GestureDetector gestureDetector;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);
        ButterKnife.bind(this);
        mContext = this;

        gestureDetector = new GestureDetector(mContext, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float v, float v1) {

                Toast.makeText(mContext,getDirByGes(e1.getX(),e1.getY(),e2.getX(),e2.getY())+"",Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        initGame();
        initTouch();

    }

    private void initTouch() {



    }

    // 判断逻辑有问题

    public int getDirByGes(float startX,float stopX,float startY,float stopY){
        int Left =1;
        int Right = 2;
        int Up =3;
        int Down =4;
        boolean isLeftOrRight = Math.abs(startX -stopX) > Math.abs(startY-stopY);
        Log.e("isL",isLeftOrRight+"--");
        if (isLeftOrRight){
            if (startX - stopX >0){
            return Right;
            }else{
            return Left;
            }

        }else{
            if (startY-stopY>0){
                return Up;
            }else{
                return Down;
            }
        }


    }



    private void initGame() {

        Bitmap bgBitmap =((BitmapDrawable)getResources().getDrawable(R.drawable.game1)).getBitmap();
        for (int i = 0; i < iv_game_arr.length; i++) {
            for (int j = 0; j < iv_game_arr[0].length; j++) {
                bgBitmapwidth = bgBitmap.getWidth()/iv_game_arr[0].length;

                Bitmap bm =null;
                // 根据行宽切图
                bm =  Bitmap.createBitmap(bgBitmap,j* bgBitmapwidth,i* bgBitmapwidth, bgBitmapwidth, bgBitmapwidth);


                iv_game_arr[i][j] = new ImageView(this);
                iv_game_arr[i][j].setImageBitmap(bm);
                iv_game_arr[i][j].setPadding(2,2,2,2);
                iv_game_arr[i][j].setTag(new ClassData(i,j,bm));
                iv_game_arr[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View view) {
                        if (isHasNextImageView((ImageView) view)){

                        changeDataByImageView((ImageView) view);
                            anim.setFillAfter(true);

                            view.startAnimation(anim);
                            anim.setAnimationListener(new Animation.AnimationListener() {
                                @Override
                                public void onAnimationStart(Animation animation) {

                                }

                                @Override
                                public void onAnimationEnd(Animation animation) {
                                view.clearAnimation();
                                ClassData data = (ClassData) view.getTag();
                                iv_null.setImageBitmap(data.getBitmap());
                                ClassData null_data = (ClassData) iv_null.getTag();
                                null_data.setBitmap(data.getBitmap());
                                    null_data.setP_x(data.getP_x());
                                    null_data.setP_x(data.getP_y());
                                //　设置挡墙点击为空
                                    setNullImageView((ImageView) view);


                                }

                                @Override
                                public void onAnimationRepeat(Animation animation) {

                                }
                            });
                        }



                    }
                });

            }
        }


        for (int i = 0; i < iv_game_arr.length; i++) {
            for (int j = 0; j < iv_game_arr[0].length; j++) {
            gl_main.addView(iv_game_arr[i][j]);
            }
        }

        setNullImageView(iv_game_arr[2][3]);

    }

private void setNullImageView(ImageView niv){
    niv.setImageBitmap(null);


    iv_null = niv;
}


private boolean isHasNextImageView(ImageView iv){
    // 分别获取当前空方块的位置和点击位置
    ClassData nullData = (ClassData) iv_null.getTag();
    ClassData touchData = (ClassData) iv.getTag();
    if (nullData.getX() == touchData.getX() &&nullData.getY() == touchData.getY()+1){
        // 当前位置的上方
        Toast.makeText(mContext,"相邻",Toast.LENGTH_SHORT).show();
        return true;
    }else if (nullData.getX() == touchData.getX() &&nullData.getY() == touchData.getY()-1){
        // 当前位置的下方
        Toast.makeText(mContext,"相邻",Toast.LENGTH_SHORT).show();
        return true;
    }else if (nullData.getY() == touchData.getY() && nullData.getX() == touchData.getX()+1){
        // 当前位置的左方
        Toast.makeText(mContext,"相邻",Toast.LENGTH_SHORT).show();
        return true;
    }else if (nullData.getY() == touchData.getY() &&nullData.getX() == touchData.getX()-1){
        // 当前位置的友方
        Toast.makeText(mContext,"相邻",Toast.LENGTH_SHORT).show();
        return true;
    }else


        return false;
}

//    动画交换两个方块

    TranslateAnimation anim;
    private void changeDataByImageView(ImageView iv) {
        Log.e("iv.getX", iv.getX() + "");
        Log.e("iv_null.getX", iv_null.getX() + "");

        // 右移
        if (iv.getX() < iv_null.getX() && iv.getY() == iv_null.getY()) {
            if (isHasNextImageView(iv)){
                anim = new TranslateAnimation(0,iv.getWidth(),0.1f,0.1f);
                anim.setDuration(300);
                Log.e("移动","右移");

            }

        }

        // 左移
       else if (iv.getX() > iv_null.getX() && iv.getY() == iv_null.getY()) {
            if (isHasNextImageView(iv)){
                anim = new TranslateAnimation(0,-iv.getWidth(),0.1f,0.1f);
                anim.setDuration(300);
                Log.e("移动","左移");

            }

        }

        // 上移
        else  if (iv.getY() > iv_null.getY() && iv.getX() == iv_null.getX()) {
            if (isHasNextImageView(iv)){
                anim = new TranslateAnimation(0.1f,0.1f,0,-iv.getWidth());
                anim.setDuration(300);
                Log.e("移动","上移");
            }

        }

        // 下移
        else   if (iv.getY() < iv_null.getY() && iv.getX() == iv_null.getX()) {
            if (isHasNextImageView(iv)){
                anim = new TranslateAnimation(0.1f,0.1f,0,iv.getWidth());
                anim.setDuration(300);
                Log.e("移动","下移");
            }

        }




    }

}
