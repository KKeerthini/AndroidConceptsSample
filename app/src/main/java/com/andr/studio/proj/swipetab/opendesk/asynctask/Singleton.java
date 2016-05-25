package com.andr.studio.proj.swipetab.opendesk.asynctask;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by CIPL0310 on 5/24/2016.
 */
public class Singleton {
    private static Singleton mInstance = null;

    private String mString;
    private HttpURLConnection conn;


    private Singleton(){
      //  mString = "Hello";
    }

    public static Singleton getInstance(){
        if(mInstance == null)
        {
            mInstance = new Singleton();
        }
        return mInstance;
    }

    public String getString(){
        return this.mString;
    }

    public void setString(String value){
        mString = value;
    }

    public HttpURLConnection httpReqConnect(String url,int TIMEOUT)
    {
        try {

            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setReadTimeout(TIMEOUT);
            conn.setConnectTimeout(TIMEOUT);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            //conn.setRequestMethod(request.name());
            conn.connect();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return  conn;
    }
}