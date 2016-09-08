package nus.me.common.view.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Timer;

import nus.me.common.R;

/**
 * Created by nus on 08/09/16.
 */
public class TimerButton extends Button {
    private  String tv_before,tv_after;
    private int itime;
    private int textColor;

    private Paint paint;
    private Rect bound;
    private Boolean btn_flag = true;


    public TimerButton(Context context) {
        this(context,null);
    }

    public TimerButton(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TimerButton(final Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        new Thread(){
            @Override
            public void run() {
                super.run();




            }
        }.start();


        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View view) {

                Toast.makeText(context,"click",Toast.LENGTH_SHORT).show();


            }
        });

        TypedArray  a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TimerButton,defStyleAttr,0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int att = a.getIndex(i);

            switch (att){
                case R.styleable.TimerButton_beforText:
                    tv_before = a.getString(att);
                    break;
                case R.styleable.TimerButton_afterText:
                    tv_after = a.getString(att);
                    break;
                case R.styleable.TimerButton_time:
                    itime = a.getInt(att,60);
                    break;
                case R.styleable.TimerButton_textColor:
                    textColor = a.getColor(att, Color.BLACK);
                    break;
            }
        }
        a.recycle();
        Log.e("init",tv_before+"-"+tv_after+"-"+itime+"===="+textColor);

        paint = new Paint();
        paint.setTextSize(18);
        bound = new Rect();
        paint.getTextBounds(tv_before+"->"+tv_after,0,(tv_before.length()+"->".length()+tv_after.length()),bound);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heigtMode = MeasureSpec.getMode(heightMeasureSpec);
        int heigtSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        if (widthMeasureSpec == MeasureSpec.EXACTLY){
            width = widthSize;
        }else {
            paint.setTextSize(18);
            paint.getTextBounds(tv_before+"->"+tv_after,0,(tv_before.length()+"->".length()+tv_after.length()),bound);
            float textWidth = bound.width();
            int desired = (int) (getPaddingLeft() +textWidth + getPaddingRight());
            width = desired;
        }


        if (heightMeasureSpec == MeasureSpec.EXACTLY){
            height = heigtSize;
        }else {
            paint.setTextSize(18);
            paint.getTextBounds(tv_before+"->"+tv_after,0,(tv_before.length()+"->".length()+tv_after.length()),bound);
            float textHeight = bound.height();
            int desired = (int) (getPaddingLeft() +textHeight + getPaddingRight());
            height = desired;
        }
        setMeasuredDimension(width, height);


    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),paint);

        paint.setColor(textColor);
        canvas.drawText(tv_before+"->"+tv_after,getWidth()/2-bound.width()/2,getHeight()/2+bound.height()/2,paint);

    }





}
