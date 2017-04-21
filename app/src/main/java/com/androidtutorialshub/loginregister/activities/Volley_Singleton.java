package com.androidtutorialshub.loginregister.activities;

/**
 * Created by Cristian Azurdia on 20/04/2017.
 */

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public final class Volley_Singleton {
    private static Volley_Singleton singleton;
    private static RequestQueue request;
    private static Context context;

    private Volley_Singleton(Context contexto){
        Volley_Singleton.context = contexto;
        request = getRequestQueue();
    }

    public static synchronized Volley_Singleton getInstance(Context context) {
        if (singleton == null) {
            singleton = new Volley_Singleton(context);
        }
        return singleton;
    }

    public RequestQueue getRequestQueue() {
        if (request == null) {
            request = Volley.newRequestQueue(context.getApplicationContext());
        }
        return request;
    }

    public  void addToRequestQueue(Request req) {
        getRequestQueue().add(req);
    }
}
