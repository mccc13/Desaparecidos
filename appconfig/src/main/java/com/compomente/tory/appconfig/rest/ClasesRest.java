package com.compomente.tory.appconfig.rest;


import android.annotation.TargetApi;
import android.content.Context;

import com.loopj.android.http.AsyncHttpResponseHandler;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.apache.http.Header;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;

import cz.msebera.android.httpclient.HttpEntity;

/**
 * Created by Tory on 18/04/2017.
 */

@TargetApi(19)
public abstract class ClasesRest extends AsyncHttpResponseHandler {
    protected Context context;
    protected boolean exitoso;
    protected boolean finalizado;

    public ClasesRest(Context context) {
        this.context = context;
    }

    protected void callToPostWithParameterMetods(JSONObject jsonObject) {
        try {
            StringEntity localStringEntity;
            localStringEntity = new StringEntity(jsonObject.toString(), "UTF-8");
            RestClientJar.allowCircularRedirects();
            RestClientJar.setTimeOut(getTimeOut());
            RestClientJar.post(this.context, getURL(), getMethod(), null, (HttpEntity) localStringEntity, "application/json", this);

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    protected void callToPostWithutParameterMetods() {
        RestClientJar.allowCircularRedirects();
        RestClientJar.setTimeOut(getTimeOut());
        RestClientJar.post(this.context, getURL(), getMethod(), null, null, "application/json", this);
    }

    protected abstract void onErrorLogico(int paramInt, String paramStrind);

    @Override
    public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
        onSuccess(new String(responseBody, Charset.forName("UTF-8")));
    }

    @Override
    public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {

    }

    protected void onSuccess(String paraString) {
    }

    public void onFinish() {
        this.finalizado = true;
        super.onFinish();
    }

    protected abstract String getMethod();

    protected abstract int getTimeOut();

    protected abstract String getURL();

    public boolean isExitoso() {
        return exitoso;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setExitoso(boolean exitoso) {
        this.exitoso = exitoso;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
    //public ClasesRest(Context context) this.context = context;


    //}


}


