package com.component.independent.functionalityintegration1;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by jai00 on 08-04-2017.
 */

public class MySingletonMaps {

    static MySingletonMaps mInstance;
    RequestQueue requestQueue;
    Context mCtx;

    MySingletonMaps(Context context) {
        mCtx = context;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue() {
        if(requestQueue==null)
        {
            requestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }

        return requestQueue;
    }


    public static synchronized MySingletonMaps getInstance(Context context){
        if(mInstance==null){
            mInstance = new MySingletonMaps(context);
        }
        return mInstance;
    }


    public<T> void addToQueue(Request<T> request){
        requestQueue.add(request);
    }
}
