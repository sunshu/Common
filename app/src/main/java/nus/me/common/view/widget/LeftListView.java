package nus.me.common.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import nus.me.common.R;

/**
 * Created by nus on 06/09/16.
 */
public class LeftListView extends ListView {

    private int touchSlop;

    private boolean isSiding;

    private int xDown,yDown;

    private int xMove,yMove;

    private LayoutInflater mInflater;

    private PopupWindow mPopupWindow;

    private int mpHeight,mpWidth;

    private View mCurrentView;

    private int mCurrentPosition;

    private DelButtonClickListener mdelListener;
    private Button btn_del;


    public LeftListView(Context context) {
        this(context,null);
    }

    public LeftListView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LeftListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = mInflater.inflate(R.layout.item_del, null);
        btn_del = (Button) view.findViewById(R.id.btn_del);

        mPopupWindow = new PopupWindow(view, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mPopupWindow.getContentView().measure(0,0);
        mpHeight = mPopupWindow.getContentView().getMeasuredHeight();
        mpWidth=mPopupWindow.getContentView().getMeasuredWidth();

    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int atction = ev.getAction();
        int x = (int) ev.getX();
        int y = (int) ev.getY();

        switch (atction){
            case MotionEvent.ACTION_DOWN:{
                xDown = x;
                yDown = y;
//       如果当前popupWindow显示，则直接隐藏，然后屏蔽ListView的touch事件的下传
                if (mPopupWindow.isShowing()){
                    mPopupWindow.dismiss();
                    return false;
                }
//       获得当前手指按下的item 的位置
                mCurrentPosition = pointToPosition(xDown,yDown);
//      获得当前手指按下的item
                View view = getChildAt(mCurrentPosition - getFirstVisiblePosition());
                mCurrentView = view;
                break;
            }
            case MotionEvent.ACTION_MOVE:{

                break;
            }
            case MotionEvent.ACTION_UP:{


            }



        }



        return super.dispatchTouchEvent(ev);

    }

    interface DelButtonClickListener{

    };


}
