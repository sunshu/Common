package nus.me.common.img;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import nus.me.common.R;

public class Picasso_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);
        String tburl = "https://img.alicdn.com/tps/i2/TB1bNE7LFXXXXaOXFXXwFSA1XXX-292-116.png_145x145.jpg";
        ImageView iv = (ImageView) findViewById(R.id.iv);
        ImageView iv1 = (ImageView) findViewById(R.id.iv1);
        ImageView iv2 = (ImageView) findViewById(R.id.iv2);
        Picasso.with(this).load(tburl).into(iv);
        Picasso.with(this).load(tburl).resize(50,50).centerInside().into(iv1);
        Picasso.with(this).load(tburl).resize(100,100).centerCrop().error(R.mipmap.ic_launcher).into(iv2);
    }
}
