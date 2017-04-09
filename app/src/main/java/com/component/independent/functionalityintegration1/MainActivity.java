package com.component.independent.functionalityintegration1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class MainActivity extends AppCompatActivity {

    String url_on ="https://api.thingspeak.com/update?api_key=6S9LM0BJ63OYT5CP&field1=1";
    String url_off ="https://api.thingspeak.com/update?api_key=6S9LM0BJ63OYT5CP&field1=0";

    TextView res;
    Button on,off,map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res =(TextView)findViewById(R.id.textView2) ;
        on = (Button)findViewById(R.id.button);
        off = (Button)findViewById(R.id.button2);
        map = (Button)findViewById(R.id.button3);

        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url_on, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        res.setText(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,"Something Went Wrong",Toast.LENGTH_LONG).show();
                    }
                });
                MySingletonOn.getInstance(MainActivity.this).addToQueue(stringRequest);
            }
        });

        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest2= new StringRequest(Request.Method.GET, url_off, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        res.setText(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,"Something Went Wrong",Toast.LENGTH_LONG).show();
                    }
                });
                MySingletonOff.getInstance(MainActivity.this).addToQueue(stringRequest2);
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,MapActivity.class);
                startActivity(i);

            }
        });


    }
}

