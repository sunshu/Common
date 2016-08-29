package nus.me.common.tween;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import nus.me.common.R;


public class SelectDialogFragment extends DialogFragment {


    public SelectDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root =inflater.inflate(R.layout.fragment_select_dialog, container, true);
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate);
        animation.setDuration(5000);
        animation.setRepeatCount(1);
        root.startAnimation(animation);


        return root;
    }

}
