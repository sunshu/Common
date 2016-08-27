package nus.me.common.net;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import cz.msebera.android.httpclient.Header;
import nus.me.common.R;

public class AsyncHttp_Activity extends AppCompatActivity {
//
    /**
     * 需要实名
     * 星座运势
     * 接口地址：http://web.juhe.cn:8080/constellation/getAll
     * 支持格式：json
     * 请求方式：http get
     * 请求示例：http://web.juhe.cn:8080/constellation/getAll?consName=%E7%8B%AE%E5%AD%90%E5%BA%A7&type=today&key=申请的KEY
     * 接口备注：十二星座的今日运势
     */
    /**
     * 查询快递String url="http://v.juhe.cn/exp/index?key=20ea8dcc33aed553874dfc9311c81e33&com=yt&no=882482622489943156";
     *
     */




    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_http_);

        tv_result = (TextView) findViewById(R.id.tv_result);
        findViewById(R.id.btn_get).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Async_Get();

            }
        });
        findViewById(R.id.btn_post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Async_Post();
            }
        });

        findViewById(R.id.btn1_get).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Async1_Get();

            }
        });

        findViewById(R.id.btn1_post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Async1_Post();
            }
        });



    }



    private void Async1_Get() {
        AsyncHttpClient client = RequestUtils.client;
        String url="http://v.juhe.cn/exp/index?key=20ea8dcc33aed553874dfc9311c81e33&com=yt&no=882482622489943156";
        client.get(url, new NetCallBack() {
            @Override
            public void onMySuccess(int statusCode, String response) {

            }

            @Override
            public void onMyFailure(int statusCode, String response) {

            }
        });


    }

    private void Async1_Post() {
        AsyncHttpClient client = RequestUtils.client;
        String url = "http://v.juhe.cn/exp/index";
        RequestParams params = new RequestParams();
        params.put("key","20ea8dcc33aed553874dfc9311c81e33");
        params.put("com","yt");
        params.put("no","882482622489943156");
        client.post(url,params, new NetCallBack() {
            @Override
            public void onMySuccess(int statusCode, String response) {

            }

            @Override
            public void onMyFailure(int statusCode, String response) {

            }
        });
    }

    private void Async_Get() {
        AsyncHttpClient client = new AsyncHttpClient();
        String url="http://v.juhe.cn/exp/index?key=20ea8dcc33aed553874dfc9311c81e33&com=yt&no=882482622489943156";
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                try {
                    String response = new String(responseBody,"utf-8");
                    System.out.println();
                    tv_result.setText(response);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                try {
                    String response = new String(responseBody,"utf-8");
                    tv_result.setText(response);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void Async_Post() {
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://v.juhe.cn/exp/index";
        RequestParams params = new RequestParams();
        params.put("key","20ea8dcc33aed553874dfc9311c81e33");
        params.put("com","yt");
        params.put("no","882482622489943156");
        client.post(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                try {
                    String response = new String(responseBody,"utf-8");
                    System.out.println();
                    tv_result.setText("");
                    SystemClock.sleep(1000);
                    tv_result.setText(response);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                try {
                    String response = new String(responseBody,"utf-8");
                    tv_result.setText("");
                    SystemClock.sleep(1000);
                    tv_result.setText(response);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
