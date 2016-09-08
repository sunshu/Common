package nus.me.common.view.ListView;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import nus.me.common.R;

/**
 * Created by nus on 06/09/16.
 */
public class LeftAdapter extends BaseAdapter{
    Context mContext;
    String str[];
    public LeftAdapter(Context context, String[] str) {
        this.mContext = context;
        this.str = str;
    }

    @Override
    public int getCount() {
        return str.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }



    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.item_left,null);
        View rl1 = v.findViewById(R.id.rl1);
        View rl2 = v.findViewById(R.id.rl2);
        rl1.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                
            }
        });


        return v;
    }
}
