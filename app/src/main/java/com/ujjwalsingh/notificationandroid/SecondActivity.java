package com.ujjwalsingh.notificationandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import static com.ujjwalsingh.notificationandroid.MainActivity.MESSAGE_EXTRA;

public class SecondActivity extends AppCompatActivity {
TextView actionMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        actionMessage = findViewById(R.id.mess);

        if (getIntent().hasExtra(MESSAGE_EXTRA)){
            String message = getIntent().getStringExtra(MESSAGE_EXTRA);
            Toast.makeText(this, "message for action "+message, Toast.LENGTH_SHORT).show();
            actionMessage.setText(message);
        }
    }
}
