package com.example.abhishekjain.mvvmdemo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, intent.getStringExtra("text_to_display"), Toast.LENGTH_LONG).show();
    }
}
