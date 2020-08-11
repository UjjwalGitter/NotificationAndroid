package com.ujjwalsingh.notificationandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.renderscript.RenderScript;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String MESSAGE_EXTRA="MessageAction";
    Button one, two;
    NotificationManager manager;
    EditText titleET, messageET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        titleET = findViewById(R.id.editText);
        messageET = findViewById(R.id.editText2);
        one = findViewById(R.id.one);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btOneClick();
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btTwoClick();
            }
        });
        two = findViewById(R.id.two);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    private void initView() {
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
    }

    public void btOneClick() {

        String title = titleET.getText().toString();
        String message = messageET.getText().toString();

        Intent activityIntent = new Intent(this, MainActivity.class);

        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, activityIntent, 0);


        Intent actionActivityIntent = new Intent(this, SecondActivity.class);
        actionActivityIntent.putExtra(MESSAGE_EXTRA,message);
        PendingIntent actionIntent = PendingIntent.getActivity(this, 0, actionActivityIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(this, App.CONSTANT_ONE).
                setSmallIcon(R.drawable.ic_looks_one_black_24dp)
                .setContentTitle(title)
                .setContentIntent(contentIntent)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.parseColor("#1E88E5"))
                .setAutoCancel(false)
                .setOnlyAlertOnce(true)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .addAction(R.drawable.ic_stat_name, "Action 1",actionIntent)
                .addAction(R.drawable.ic_stat_name, "Action 2",null)
                .build();

        manager.notify(1, notification);
    }

    public void btTwoClick() {
        String title = titleET.getText().toString();
        String message = messageET.getText().toString();

        Intent broadcastIntent = new Intent(this,NotificationBroadcastReceiver.class);
        broadcastIntent.putExtra(MESSAGE_EXTRA,message);
        PendingIntent broadPendentIntent = PendingIntent.getBroadcast(this,0,broadcastIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(this, App.CONSTANT_two)                  .setSmallIcon(R.drawable.ic_looks_two_black_24dp)
                .setContentTitle(title)
                .setContentText(message)
                .addAction(R.drawable.ic_stat_name,"Show Toast",broadPendentIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT).build();

        manager.notify(2, notification);
    }
}
