package nus.me.common.ftp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPFile;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;
import it.sauronsoftware.ftp4j.FTPListParseException;
import nus.me.common.R;

public class Ftp_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ftp_);


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                FTPClient client = new FTPClient();
                try {
                    client.connect("192.168.1.100");
                } catch (Exception e) {
                    Log.e("Log","连接异常");
                    e.printStackTrace();
                }

                try {
                    client.login("nus","love");
                } catch (Exception e) {
                    Log.e("Log","登陆异常");
                    e.printStackTrace();
                }

                if (client.isConnected()){


                    try {
                        FTPFile[] list = client.list();
                        for (int i = 0; i < list.length; i++) {
                            Log.e("name",list[i].getName());
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (FTPIllegalReplyException e) {
                        e.printStackTrace();
                    } catch (FTPException e) {
                        e.printStackTrace();
                    } catch (FTPDataTransferException e) {
                        e.printStackTrace();
                    } catch (FTPAbortedException e) {
                        e.printStackTrace();
                    } catch (FTPListParseException e) {
                        e.printStackTrace();
                    }

                };

            }
        });

        thread.start();


    }
}
