package nus.me.common.net;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import nus.me.common.MyApplication;
import nus.me.common.R;

public class VolleyActivity extends AppCompatActivity {

    String url="http://v.juhe.cn/exp/index?key=20ea8dcc33aed553874dfc9311c81e33&com=yt&no=882482622489943156";
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

        tv_result = (TextView) findViewById(R.id.tv_result);
        findViewById(R.id.btn_get).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volley_Get();

            }
        });
        findViewById(R.id.btn_post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volley_Post();
            }
        });



    }


    private void volley_Get() {


        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                Toast.makeText(VolleyActivity.this,response,Toast.LENGTH_LONG).show();
                tv_result.setText(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(VolleyActivity.this,"网络请求失败",Toast.LENGTH_LONG).show();
                Log.e("response+error",error.toString());
                tv_result.setText(error.toString());
            }
        });

        request.setTag("getTag");
        MyApplication.getRequestQueue().add(request);

    }

    private void volley_Post() {
        String  url = "http://v.juhe.cn/exp/index";
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                tv_result.setText(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tv_result.setText(error.toString());

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hp = new HashMap<String, String>();
                hp.put("key","20ea8dcc33aed553874dfc9311c81e33");
                hp.put("com","yt");
                hp.put("no","882482622489943156");
                return hp;
            }
        };

        request.setTag("postTag");
        MyApplication.getRequestQueue().add(request);




    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyApplication.getRequestQueue().cancelAll("getTag");
        MyApplication.getRequestQueue().cancelAll("postTag");

    }
}


