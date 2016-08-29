package nus.me.common.tween;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import nus.me.common.R;

/**
 * Created by nus on 29/08/16.
 */
public class MySimplAdapter extends BaseAdapter {

    Context context;

    public MySimplAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 100;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    class ViewHolder {
        private ImageView iv;
        private TextView tv;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder =null;

            view = LayoutInflater.from(context).inflate(R.layout.adapte_simp,null);
            Animation anim = AnimationUtils.loadAnimation(context, R.anim.scale);
            anim.setFillAfter(true);
            anim.setDuration(500);

            view.startAnimation(anim);








        return view;
    }
}
