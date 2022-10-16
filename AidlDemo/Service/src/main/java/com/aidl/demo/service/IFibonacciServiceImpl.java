package com.aidl.demo.service;

import android.os.SystemClock;
import android.util.Log;

import com.aidl.demo.common.FibonacciRequest;
import com.aidl.demo.common.FibonacciResponse;
import com.aidl.demo.common.IFibonacciService;
import com.aidl.fiblib.NativeLib;

public class IFibonacciServiceImpl extends IFibonacciService.Stub {
    private static final String TAG = "IFibonacciServiceImpl";

    public long fibJI(long n) {
        Log.d(TAG, String.format("fibJI(%d)", n));
        return NativeLib.fibJI(n);
    }

    public long fibJR(long n) {
        Log.d(TAG, String.format("fibJR(%d)", n));
        return NativeLib.fibJR(n);
    }

    public long fibNI(long n) {
        Log.d(TAG, String.format("fibNI(%d)", n));
        return NativeLib.fibNI(n);
    }

    public long fibNR(long n) {
        Log.d(TAG, String.format("fibNR(%d)", n));
        return NativeLib.fibNR(n);
    }

    public FibonacciResponse fib(FibonacciRequest request) {
        Log.d(TAG,
                String.format("fib(%d, %s)", request.getN(), request.getType()));
        long timeInMillis = SystemClock.uptimeMillis();
        long result;
        switch (request.getType()) {
            case ITERATIVE_JAVA:
                result = this.fibJI(request.getN());
                break;
            case RECURSIVE_JAVA:
                result = this.fibJR(request.getN());
                break;
            case ITERATIVE_NATIVE:
                result = this.fibNI(request.getN());
                break;
            case RECURSIVE_NATIVE:
                result = this.fibNR(request.getN());
                break;
            default:
                return null;
        }
        timeInMillis = SystemClock.uptimeMillis() - timeInMillis;
        return new FibonacciResponse(result, timeInMillis);
    }
}
