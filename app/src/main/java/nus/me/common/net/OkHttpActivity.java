package nus.me.common.net;

import android.os.Environment;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.FileCallBack;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import nus.me.common.R;
import okhttp3.Call;
import okhttp3.Response;

public class OkHttpActivity extends AppCompatActivity {


    @BindView(R.id.btn_get)Button btn_get;
    @BindView(R.id.btn_post)Button btn_post;
    @BindView(R.id.btn_post_String)Button btn_post_String;
    @BindView(R.id.btn_file)Button btn_file;
    @BindView(R.id.btn_form)Button btn_form;
    @BindView(R.id.btn_down)Button btn_down;
    @BindView(R.id.btn_img)Button btn_img;
    @BindView(R.id.pb)
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_get)
    public void onGetClick(View view){
        String url = "http://v.juhe.cn/toutiao/index";
        Log.e("click","btn_get");
        OkHttpUtils
                .get()
                .url(url)
                .addParams("key","f59e84b6381469d83e947ab566890987")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("response",e.toString());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("response",response);
                    }
                });
    }

    @OnClick(R.id.btn_post)
    public void onPostclick(View view){
        String url = "http://v.juhe.cn/toutiao/index";
        Log.e("click","btn_post");
        OkHttpUtils
                .post()

                .addParams("key","f59e84b6381469d83e947ab566890987")
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("post response",response.toString());

                    }
                });

    }

    @OnClick(R.id.btn_down)
    public void onDownClik(View view){
        String url= "http://apk.hiapk.com/web/api.do?qt=8051&id=723";
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath(),"dd.apk") {

                    @Override
                    public void inProgress(float progress, long total, int id) {
                        pb.setProgress((int) (100*progress));
                        Log.e("progress",(int) (100*progress)+"");

                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("call",call.toString()+"--\n"+e.toString()+"--\n"+id);
                    }

                    @Override
                    public void onResponse(File response, int id) {
                        Log.e("response",response.toString());

                    }
                });
    }

}
