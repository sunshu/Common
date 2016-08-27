package nus.me.common.net;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

/**
 * Created by nus on 27/08/16.
 */
public class RequestUtils {
    /**
     * AsyncHttp 封装
     *
     */
    public static AsyncHttpClient client = new AsyncHttpClient();

    public static void ClientGet(String url,NetCallBack callBack){
        client.get(url, callBack);

    }

    public static void ClientPost(String url, RequestParams params,NetCallBack callBack){
        client.post(url,params,callBack);

    }




}
