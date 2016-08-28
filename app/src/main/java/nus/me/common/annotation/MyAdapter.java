package nus.me.common.annotation;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import nus.me.common.R;

/**
 * Created by nus on 28/08/16.
 */
public class MyAdapter extends BaseAdapter {
    private List<TData> Datas;
    private Context mContext;

    public MyAdapter(List<TData> datas, Context mContext) {
        Datas = datas;
        this.mContext = mContext;
    }


    @Override
    public int getCount() {
        return Datas.size();
    }

    @Override
    public Object getItem(int i) {
        return Datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    static  class Holder{
        @BindView(R.id.tv_title) TextView tv_title;
        @BindView(R.id.tv_content) TextView tv_content;
        public Holder(View v) {
            ButterKnife.bind(this,v);
        }

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder = null;
        if (view == null){
            view = View.inflate(mContext, R.layout.adapter_tdatas,null);
            holder = new Holder(view);
            view.setTag(holder);
        }else {
            holder = (Holder) view.getTag();
        }
        holder.tv_title.setText(Datas.get(i).getTitle());
        holder.tv_content.setText(Datas.get(i).getData());
        return view;
    }


}
