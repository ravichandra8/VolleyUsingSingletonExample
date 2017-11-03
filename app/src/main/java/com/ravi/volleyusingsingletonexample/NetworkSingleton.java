package com.ravi.volleyusingsingletonexample;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
/**
 * Created by Ravichandra on 10/28/2017.
 */

public class NetworkSingleton {
    //require private static variable for singletonclass
    private static NetworkSingleton instance;
    private RequestQueue requestQueue;

    private static Context mCtx;
   //require private constructor for singletonclass
    private NetworkSingleton(Context context)
    {
        mCtx=context;
        requestQueue=getRequestQueue();
    }

    public RequestQueue getRequestQueue()
    {
        if(requestQueue==null)
        {
            requestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return requestQueue;
    }
    //call the pulic factor method. create the ojbect one time.
    public static synchronized NetworkSingleton getInstance(Context context)
    {
        if(instance==null)
        {
            instance=new NetworkSingleton(context);
        }
  return instance;
    }

    public<T> void addtoRequestQue(Request<T> request)
    {
        requestQueue.add(request);
    }

}
