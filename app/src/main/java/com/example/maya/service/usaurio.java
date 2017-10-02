package com.example.maya.service;


import android.content.Context;

import com.compomente.tory.appconfig.rest.ClasesRest;

/**
 * Created by Tory on 01/10/2017.
 */

public class usaurio extends ClasesRest {

    public usaurio(Context context) {
        super(context);
    }

    @Override
    protected void onErrorLogico(int paramInt, String paramStrind) {

    }

    @Override
    protected String getMethod() {
        return null;
    }

    @Override
    protected int getTimeOut() {
        return 0;
    }

    @Override
    protected String getURL() {
        return null;
    }
}
