package nus.me.common.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.icu.util.MeasureUnit;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by nus on 25/08/16.
 */
public class CustomView extends View {

    public CustomView(Context context) {
        this(context,null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true); // 设置抗锯齿
        // Paint.Style 三种样式
        // FILL 填充　STROKE 描边　FILL_AND_STROKE 填充并描边
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(1);

        canvas.drawCircle(100,100,20,paint);




    }
}
