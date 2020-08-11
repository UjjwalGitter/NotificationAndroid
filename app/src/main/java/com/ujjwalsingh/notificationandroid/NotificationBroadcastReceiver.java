package com.ujjwalsingh.notificationandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import static com.ujjwalsingh.notificationandroid.MainActivity.MESSAGE_EXTRA;

public class NotificationBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent!=null){
            if (intent.hasExtra(MESSAGE_EXTRA)){
                Toast.makeText(context, MESSAGE_EXTRA.toString()+"message from broadcast", Toast.LENGTH_SHORT).show();
            }
        }
    }
}