package com.andr.studio.proj.swipetab;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.andr.studio.proj.swipetab.interfaces.AsyncInterface;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Created by CIPL310 on 9/16/2015.
 */
public class HttpReq extends AsyncTask<String, String, String> {

    Context context;
    private AsyncInterface taskcomp;
    BufferedReader readInputStream=null;
    String url_req;
    Integer url_no;



  public HttpReq(Context context,AsyncInterface taskcomp,String url_req,Integer url_no)
    {
        this.context=context;
        this.taskcomp=taskcomp;
        this.url_req=url_req;
        this.url_no=url_no;
    }


    @Override
    protected String doInBackground(String... params) {
        InputStream inputStream = null;
        HttpURLConnection httpURLConnection = null;
        URL url = null;
        String responseJSON="";
       // taskcomp.ontaskcompleted(result);
        Integer result = 0;
        try {
            url=new URL(url_req);
        } catch (MalformedURLException e) {
            Log.d("Malfunction", "" + e.toString());
        }
        try {

            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.setRequestMethod("GET");
            int statuscode = httpURLConnection.getResponseCode();
            if (statuscode == 200) {
                inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                String response = inputStream.toString();
                Log.d("HTTPResponse", response);
               readInputStream=new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

                  String str = null;
                StringBuilder sb = new StringBuilder(8192);
                 while((str =readInputStream.readLine()) != null)
                  {
                      sb.append(str);
                      Log.d("result", "httpreq" + sb.toString());
                      responseJSON=sb.toString();
                  }
                readInputStream.close();
                result = 1;
            } else {
                result = 0;
            }
        } catch (IOException e) {
            Log.d("IOException", "" + e.toString());
        }
       if(url_no==1) {
           SingletonClaz.getInstance().JSONResponse = responseJSON;
           Log.d("Singleton string store", SingletonClaz.getInstance().JSONResponse);
       }
        else
       {
           SingletonClaz.getInstance().JSONResponse2 = responseJSON;
           Log.d("Singleton store 2", SingletonClaz.getInstance().JSONResponse2);
       }
        return responseJSON;


    }



}
