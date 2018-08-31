package com.example.sa04.work;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static com.example.sa04.work.SinginActivity.MyPREFERENCES;

public class SplaceActivity extends AppCompatActivity {
    private Handler mWaitHandler = new Handler();
    private boolean isLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splace);
        final SharedPreferences sharedPreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        isLogin = sharedPreferences.getBoolean("Is_login", false);

        mWaitHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(isLogin) {
                    Intent intent = new Intent(getApplicationContext(), PankajActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(getApplicationContext(), SinginActivity.class);
                    startActivity(intent);
                }

            }
        }, 2000);
    }
    public void onDestroy() {
        super.onDestroy();
        mWaitHandler.removeCallbacksAndMessages(null);
    }

}
