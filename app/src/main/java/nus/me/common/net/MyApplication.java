package nus.me.common.net;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.lang.ref.ReferenceQueue;

/**
 * Created by nus on 16-8-23.
 */
public class MyApplication extends Application {


    private static RequestQueue queue;

    @Override
    public void onCreate() {
        super.onCreate();
//     Volley　请求队列，并实例
        queue = Volley.newRequestQueue(getApplicationContext());

    }
//    暴露方法，返回请求队列
    public static RequestQueue getRequestQueue(){
        return queue;
    }

}
