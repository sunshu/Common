package nus.me.common.net;

import android.util.Log;

import com.loopj.android.http.AsyncHttpResponseHandler;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;

/**
 * Created by nus on 27/08/16.
 */
public abstract class NetCallBack extends AsyncHttpResponseHandler {

    @Override
    public void onStart() {
        Log.i("AsyncHttp","请求开始");
        super.onStart();
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        try {
            String response = new String(responseBody,"utf-8");
            Log.i("AsyncHttp","请求成功"+response);
            onMySuccess(statusCode, response);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        try {
            String response = new String(responseBody,"utf-8");
            Log.i("AsyncHttp","请求失败"+response);
            onMyFailure(statusCode, response);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public abstract void onMySuccess(int statusCode, String response);
    public abstract void onMyFailure(int statusCode, String response);

}
