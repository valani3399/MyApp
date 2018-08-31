package com.example.sa04.work;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.RemoteInput;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class BroadCastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast);
        registerReceiver(broadcastReceiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
    BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            int is=intent.getIntExtra("level",0);
            Log.e("____________is______",""+is);
            int chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);

//            if(chargePlug == 1 || chargePlug==2){
//
//
//            }
            NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            if(!(chargePlug==2 || chargePlug==1) && is>30){
                NotificationCompat.Builder builder = new NotificationCompat.Builder(BroadCastActivity.this)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentTitle("Bettry leval in form")
                        .setContentText("Your battry leval less 50% plase plagin your mobail");

                Intent notificationIntent = new Intent(String.valueOf(BroadCastActivity.this));
                PendingIntent contentIntent = PendingIntent.getActivity(BroadCastActivity.this, 0, notificationIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(contentIntent);

                manager.notify(0, builder.build());
                Toast.makeText(context, "50 up", Toast.LENGTH_SHORT).show();

            }else if((chargePlug==1 || chargePlug==2) && is<50){
                manager.cancelAll();
                Toast.makeText(context, "50 less", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(context, "pluging", Toast.LENGTH_SHORT).show();
            }

        }
    };
}
