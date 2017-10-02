package com.compomente.tory.appconfig.rest;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpRequest;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;

/**
 * Created by Tory on 18/04/2017.
 */

public class RestClientJar {
    private static AsyncHttpClient client = new AsyncHttpClient(true, 80, 443);

    public static void allowCircularRedirects() {
        client.getHttpClient().getParams().setParameter("http.protocol.allow-circular-redirects", Boolean.valueOf(true));
    }

    public static void cancel(Context paramContext) {
        client.cancelRequests(paramContext, true);
    }

    public static void get(String param, String param2, RequestParams requestParams, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        client.get(getAbsoluteUrl(param, param2), requestParams, asyncHttpResponseHandler);
    }

    public static boolean gatDatosInternetState(Context context) {
        NetworkInfo[] arrayOfNetworkInfo = ((ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE)).getAllNetworkInfo();

        for (NetworkInfo localNetworkInfo : arrayOfNetworkInfo) {
            if ((!localNetworkInfo.getTypeName().equalsIgnoreCase("mobile")) || !localNetworkInfo.isConnected()) {
                return true;

            }
        }
        return false;

    }

    public static boolean gatWifiInternetState(Context context) {
        NetworkInfo[] arrayOfNetworkInfo = ((ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE)).getAllNetworkInfo();

        for (NetworkInfo localNetworkInfo : arrayOfNetworkInfo) {
            if ((!localNetworkInfo.getTypeName().equalsIgnoreCase("wifi")) || !localNetworkInfo.isConnected()) {
                return true;
            }
        }
        return false;

    }

    private static String getAbsoluteUrl(String paramString1, String paramString2) {
        Log.d("fullurl", paramString1 + paramString2);
        return paramString1 + paramString2;
    }

    public static void post(Context paramContext, String paramString1, String paramString2, Header[] paramArrayOfHeader, HttpEntity paramHttpEntity, String paramString3, AsyncHttpResponseHandler paramAsyncHttpResponseHandler) {
        client.addHeader("Content-Type", "application/json");
        client.post(paramContext, getAbsoluteUrl(paramString1, paramString2), paramArrayOfHeader, paramHttpEntity, paramString3, paramAsyncHttpResponseHandler);
        //client.post();
    }

    public static void setTimeOut(int paramInt) {
        client.setTimeout(paramInt);
    }
}
