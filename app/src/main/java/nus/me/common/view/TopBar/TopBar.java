package nus.me.common.view.TopBar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import nus.me.common.R;

/**
 * Created by nus on 16-8-24.
 */
public class TopBar extends RelativeLayout {
    private Button btn_left,btn_right;
    private TextView tv_title;
    private LayoutInflater inflater;
    private OnTopBarClickListener topBarClickListener;

    public TopBar(Context context) {
        this(context,null);
    }

    public TopBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.topbar,this);
        btn_left = (Button) findViewById(R.id.btn_topbar_left);
        btn_right = (Button) findViewById(R.id.btn_topbar_right);
        tv_title = (TextView) findViewById(R.id.tv_topbar_title);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.TopBar);
        int leftBtnBackground = typedArray.getResourceId(R.styleable.TopBar_leftBackground,0);
        int rightBtnBackground = typedArray.getResourceId(R.styleable.TopBar_rightBackground,0);
        String titleText = typedArray.getString(R.styleable.TopBar_titleText);
        float titleTextSize = typedArray.getDimension(R.styleable.TopBar_titleTextSize, 0);
//        int titleTextColor = typedArray.getColor(R.styleable.TopBar_titleTextColor, 0xffff00);
        typedArray.recycle();

        btn_left.setBackgroundResource(leftBtnBackground);
        btn_right.setBackgroundResource(rightBtnBackground);
        tv_title.setText(titleText);
        tv_title.setTextSize(titleTextSize);
//        tv_title.setTextColor(titleTextColor);


        btn_left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {


                    topBarClickListener.onLeftButtonClick();

            }
        });


        btn_right.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                    topBarClickListener.onRightButtonClick();

            }
        });

    }


    public interface OnTopBarClickListener{
        void onLeftButtonClick();
        void onRightButtonClick();
    }

    public  void setOnTopBarClickLListener(OnTopBarClickListener topBarClickListener){
        this.topBarClickListener = topBarClickListener;
    }


}
