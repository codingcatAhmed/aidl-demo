package com.aidl.demo.service;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

public class FibonacciService extends Service { // <1>

    private static final String TAG = "FibonacciService";

    private IFibonacciServiceImpl service; // <2>

    @Override
    public void onCreate() {
        super.onCreate();
        this.service = new IFibonacciServiceImpl(); // <3>
        Log.d(TAG, "onCreate()'ed"); // <5>
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind()'ed"); // <5>
        return (IBinder) this.service; // <4>
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind()'ed"); // <5>
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "ow²nDestroy()'ed");
        this.service = null;
        super.onDestroy();
    }
}
