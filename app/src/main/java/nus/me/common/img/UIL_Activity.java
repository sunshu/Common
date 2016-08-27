package nus.me.common.img;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import nus.me.common.R;

public class UIL_Activity extends AppCompatActivity {
    private ImageLoader loader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uil_);
        loader =ImageLoader.getInstance();

        ImageView iv_uil = (ImageView) findViewById(R.id.iv_uil);
        ImageView iv2 = (ImageView) findViewById(R.id.iv２);



        String imgUrl = "https://www.baidu.com/img/bd_logo1.png";
        loader.displayImage(imgUrl,iv_uil);
        String uri = "file://"+"本地路径";
        String qqurl = "http://mat1.gtimg.com/www/images/qq2012/qqlogo_1x.png";
        loader.displayImage(qqurl, iv2, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String s, View view) {

            }

            @Override
            public void onLoadingFailed(String s, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String s, View view, Bitmap bitmap) {
                Log.e(s,"complete");
            }

            @Override
            public void onLoadingCancelled(String s, View view) {

            }
        });


    }
}
