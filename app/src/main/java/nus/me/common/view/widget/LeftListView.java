package nus.me.common.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by nus on 06/09/16.
 */
public class LeftListView extends ListView {
    public LeftListView(Context context) {
        this(context,null);
    }

    public LeftListView(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    public LeftListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {

    }
}
