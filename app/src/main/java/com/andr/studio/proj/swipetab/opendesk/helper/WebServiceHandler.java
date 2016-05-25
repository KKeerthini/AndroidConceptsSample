package com.andr.studio.proj.swipetab.opendesk.helper;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.andr.studio.proj.swipetab.opendesk.asynctask.Singleton;


public class WebServiceHandler {

    private static WebServiceHandler serviceHandler = new WebServiceHandler();

    private final int TIMEOUT = 1000 * 2;

    private HttpURLConnection conn;
    private int reqresponseCode;
    private JSONObject JSONresponseText;
    private StringBuilder sb;
    private OutputStream outputStream;
    private StringBuilder cookies = null;
    private boolean enableSession = false;
    HashMap<String, StringBuilder> headerAttributes = null;
    StringBuilder connectionAlive = null, keepAlive = null, sessionDate = null, expires = null;

    private WebServiceHandler() {

    }

    public static JSONObject runService(String url, JSONObject object, RequestType request) {
        return serviceHandler.serviceCall(url, object, request);
    }

    private JSONObject serviceCall(String url, JSONObject object, RequestType request) {
        try {

            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setReadTimeout(TIMEOUT);
            conn.setConnectTimeout(TIMEOUT);
            conn.setRequestProperty("Content-Type", "application/json");

            if (headerAttributes != null) {
                if (headerAttributes.get("cookie") != null) {
                    String cookie = headerAttributes.get("cookie").toString();
                    conn.setRequestProperty("Set-Cookie", cookie);
                }
                if (headerAttributes.get("connectionAlive") != null) {
                    String connAlive = headerAttributes.get("connectionAlive").toString();
                    conn.setRequestProperty("Connection", connAlive);
                }

                if (headerAttributes.get("keepAlive") != null) {
                    String keepAlive = headerAttributes.get("keepAlive").toString();
                    conn.setRequestProperty("Keep-Alive", keepAlive);
                }
                if (headerAttributes.get("session") != null) {
                    String sessionDate = headerAttributes.get("session").toString();
                    conn.setRequestProperty("Date", sessionDate);
                }
                if (headerAttributes.get("expiry") != null) {
                    String expiry = headerAttributes.get("expiry").toString();
                    conn.setRequestProperty("Expires ", expiry);
                }
                if (headerAttributes.get("Server") != null) {
                    String server = headerAttributes.get("Server").toString();
                    conn.setRequestProperty("Server", server);
                }
                if (headerAttributes.get("lastModified") != null) {
                    String lastModified = headerAttributes.get("lastModified").toString();
                    conn.setRequestProperty("Last-Modified", lastModified);
                }
                if (headerAttributes.get("contentEncoding") != null) {
                    String contentEncoding = headerAttributes.get("contentEncoding").toString();
                    conn.setRequestProperty("Content-Encoding", contentEncoding);
                }
                if (headerAttributes.get("contentLength") != null) {
                    String contentLength = headerAttributes.get("contentLength").toString();
                    conn.setRequestProperty("Content-Length", contentLength);
                    conn.setFixedLengthStreamingMode(Integer.parseInt(contentLength));

                }
            }


            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod(request.name());
            conn.connect();

            Log.d("Url", url);

            // Checking HTTP request method type
            switch (request) {

                case GET:
                    break;

                case POST:

                case PUT:
                    if (object != null) {
                        Log.d("Post Data", object.toString());
                        byte[] outputInBytes = object.toString().getBytes("UTF-8");
                        outputStream = conn.getOutputStream();
                        outputStream.write(outputInBytes);
                        outputStream.flush();
                        outputStream.close();
                    }
                    break;

                case DELETE:
                    break;

                default:
                    break;
            }

            reqresponseCode = conn.getResponseCode();

            if (reqresponseCode == HttpURLConnection.HTTP_OK) {
                try {

                    sb = new StringBuilder();
                    InputStreamReader in = new InputStreamReader(
                            conn.getInputStream(), "iso-8859-1");
                    int read;
                    char[] buff = new char[1024];
                    while ((read = in.read(buff)) != -1) {
                        sb.append(buff, 0, read);

                    }
                    Log.d("Response", sb.toString());

                    if (isEnableSession()) {
                        enableSession();
                    }

                } catch (Exception e) {
                    Log.e("Buffer Error", "Error converting result " + e.toString());
                }

                JSONresponseText = new JSONObject(sb.toString());
            } else
                Log.d("Error", "Http " + reqresponseCode + " Error From Url");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            Log.e("JSON Parser", "ERROR: " + e.toString());
        }

        return JSONresponseText;

    }

    public static void setEnableSession(boolean enableSession) {
        serviceHandler.enableSession = enableSession;
    }

    private boolean isEnableSession() {
        return enableSession;
    }

    public HashMap<String, StringBuilder> enableSession() {

        Map<String, List<String>> map = conn.getHeaderFields();
        if (map != null) {

            headerAttributes = new HashMap<>();
            for (Map.Entry<String, List<String>> headers : conn.getHeaderFields().entrySet()) {
                if (headers.getKey() != null && headers.getKey().equals("Set-Cookie")) {
                    cookies = new StringBuilder();
                    for (String value : headers.getValue()) {
                        cookies.append(value);
                    }
                    headerAttributes.put("cookies", cookies);
                }

                if (headers.getKey() != null && ("Connection").equals(headers.getKey())) {
                    connectionAlive = new StringBuilder();
                    for (String value : headers.getValue()) {
                        connectionAlive.append(value);
                    }
                    headerAttributes.put("connectionAlive", connectionAlive);
                }

                if (headers.getKey() != null && ("Keep-Alive").equals(headers.getKey())) {
                    keepAlive = new StringBuilder();
                    for (String value : headers.getValue()) {
                        keepAlive.append(value);
                    }
                    headerAttributes.put("keepAlive", keepAlive);
                }

                if (headers.getKey() != null && ("Date").equals(headers.getKey())) {
                    sessionDate = new StringBuilder();
                    for (String value : headers.getValue()) {
                        sessionDate.append(value);
                    }
                    headerAttributes.put("session", sessionDate);
                }
                if (headers.getKey() != null && ("Expires").equals(headers.getKey())) {
                    expires = new StringBuilder();
                    for (String value : headers.getValue()) {
                        expires.append(value);
                    }
                    headerAttributes.put("expiry", expires);
                }
                if (headers.getKey() != null && ("Server").equals(headers.getKey())) {
                    StringBuilder server = new StringBuilder();
                    for (String value : headers.getValue()) {
                        server.append(value);
                    }
                    headerAttributes.put("Server", server);
                }
                if (headers.getKey() != null && ("Last-Modified").equals(headers.getKey())) {
                    StringBuilder lastMod = new StringBuilder();
                    for (String value : headers.getValue()) {
                        lastMod.append(value);
                    }
                    headerAttributes.put("lastModified", lastMod);
                }
                if (headers.getKey() != null && ("Content-Encoding").equals(headers.getKey())) {
                    StringBuilder lastMod = new StringBuilder();
                    for (String value : headers.getValue()) {
                        lastMod.append(value);
                    }
                    headerAttributes.put("contentEncoding", lastMod);
                }

                if (headers.getKey() != null && ("Content-Length").equals(headers.getKey())) {
                    StringBuilder lastMod = new StringBuilder();
                    for (String value : headers.getValue()) {
                        lastMod.append(value);
                    }
                    headerAttributes.put("contentLength", lastMod);
                }

            }
        }
        return headerAttributes;
    }

}

/*
Cache-Control →no-store, no-cache, must-revalidate, post-check=0, pre-check=0
		Connection →Keep-Alive
		Content-Encoding →gzip
		Content-Length →240
		Content-Type →application/json; charset=UTF-8
		Date →Wed, 25 May 2016 06:19:14 GMT
		Expires →Sat, 26 Jul 1997 05:00:00 GMT
		Keep-Alive →timeout=15, max=100
		Last-Modified →Wed, 25 May 2016 06:19:14 GMT
		Server →Apache/2.2.15 (Red Hat)
		Vary →Accept-Encoding*/
