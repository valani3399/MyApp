package com.example.sa04.work;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.time.Instant;

public class SinginActivity extends AppCompatActivity {
    Button notragister,signin;
    EditText e;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String gmail = "gmailKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singin);
        signin=(Button)findViewById(R.id.btn_signin);
        e=(EditText)findViewById(R.id.et_e);
        notragister=(Button)findViewById(R.id.btn_notragidster);
        final SharedPreferences sharedPreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        notragister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent f = new Intent(SinginActivity.this, SignupActivity.class);
                startActivity(f);
                finish();
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent f = new Intent(SinginActivity.this, PankajActivity.class);
                startActivity(f);
                finish();
                String g = signin.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(gmail, g);
                editor.putBoolean("Is_login",false);
                editor.commit();


            }
        });

    }
}
