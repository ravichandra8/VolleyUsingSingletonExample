package com.ravi.volleyusingsingletonexample;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {
    String url1 = "https://api.androidhive.info/volley/person_array.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

              final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();

        JsonArrayRequest req = new JsonArrayRequest(url1,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("response", response.toString());
                        pDialog.hide();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("response", "Error: " + error.getMessage());
                pDialog.hide();
            }
        });

// Adding request to request queue
        //  AppController.getInstance().addToRequestQueue(req, tag_json_arry);

       NetworkSingleton.getInstance(getApplicationContext()).addtoRequestQue(req);





    }
}
