package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notification();
            }
        });
    }

    private void notification() {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this,"notify");
         builder.setSmallIcon(android.R.drawable.sym_def_app_icon);
         builder.setContentTitle("notification title");
         builder.setContentText("this is just simple notification test");

        Intent intent=new Intent(getApplicationContext(),B.class);
        PendingIntent pi=PendingIntent.getActivity(getApplicationContext(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pi);

        NotificationManagerCompat NMC=NotificationManagerCompat.from(MainActivity.this);
        NMC.notify(1,builder.build());
    }
}
