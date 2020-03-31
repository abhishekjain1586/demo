package com.example.abhishekjain.mvvmdemo.ipcservice;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyService extends IntentService {

    private String TAG = MyService.class.getSimpleName();

    public MyService() {
        super("");
    }

    public MyService(String name) {
        super(name);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate()");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "onHandleIntent()");

        Messenger messenger = intent.getParcelableExtra("callback-messenger");
        Message message = new Message();
        message.what = 1;
        try {
            messenger.send(message);
        } catch (RemoteException e) {
            e.printStackTrace();
        } finally {
            message.recycle();
        }
    }
}
