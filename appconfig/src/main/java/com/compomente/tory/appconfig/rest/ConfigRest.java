package com.compomente.tory.appconfig.rest;

import android.content.Context;

/**
 * Created by Tory on 18/04/2017.
 */

public abstract class ConfigRest extends ClasesRest {
    public ConfigRest(Context context) {
        super(context);
    }
    public void ObtenerConfig()
    {
        callToPostWithutParameterMetods();
    }

    protected String getMetod()
    {
        return "/ObtenerConfig";
    }

    protected int getTimeOut()
    {
        return 30000;
    }

    protected String getURL()
    {
       // return GlobalApp.getInstance().getConfiguracionBLInstance().getSWConfiguracion();
        return "sacamos de la base de dosta la url";
    }

    public void onSuccess(String paramString)
    {
        super.onSuccess(paramString);
    }

    public abstract void onSuccess(String paramString, int paramInt);

}
