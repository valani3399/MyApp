package com.example.sa04.work;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class PostActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        postmethod("http://httpbin.org/post");
    }

    private void postmethod(String s) {
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(
                Request.Method.POST,
                s,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);

    }
}
