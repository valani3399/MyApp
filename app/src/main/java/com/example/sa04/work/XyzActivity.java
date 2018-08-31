package com.example.sa04.work;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class XyzActivity extends AppCompatActivity {
    EditText textView;
    Button button;
    String is;
    private String email;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xyz);
        textView=(EditText)findViewById(R.id.tv_name);
        button=(Button)findViewById(R.id.btn_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hear gettext one reason gettext gives values button on clik event.......
                email=textView.getText().toString();
                SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(XyzActivity.this);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("Email",email);
                editor.apply();

                is=sharedPreferences.getString("Email",null);
                if(email.length()>0){
                    Toast.makeText(XyzActivity.this, "sucess", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(XyzActivity.this, "Not", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

}
