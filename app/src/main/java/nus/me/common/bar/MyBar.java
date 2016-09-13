package nus.me.common.bar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;

/**
 * Created by nus on 13/09/16.
 */
public class MyBar extends Toolbar {
    public MyBar(Context context) {
        this(context,null);
    }

    public MyBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setMyColor(int color){
        this.setBackgroundColor(color);
    }


}
