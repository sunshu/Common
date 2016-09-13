package nus.me.common.ndk;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import nus.me.common.R;

public class NDKActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndk);
    }

}
