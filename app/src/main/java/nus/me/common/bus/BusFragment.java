package nus.me.common.bus;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import nus.me.common.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BusFragment extends Fragment {


    private TextView tv_f;

    public BusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_bus, null);
        tv_f = (TextView) root.findViewById(R.id.tv_f);

        return root;
    }

    @Subscribe(threadMode = ThreadMode.MAIN) //在ui线程执行
    public void onUserEvent(MyEvent event) {
        Log.e("eee","eee");
        if (event.getType().equals("0")){
            tv_f.setText(""+event.getContent());
        }
    }

}
