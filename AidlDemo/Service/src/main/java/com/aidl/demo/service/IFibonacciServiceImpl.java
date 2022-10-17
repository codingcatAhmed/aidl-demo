package com.aidl.demo.service;

import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;

import com.aidl.demo.common.FibonacciRequest;
import com.aidl.demo.common.FibonacciResponse;
import com.aidl.demo.common.IFibonacciService;
import com.aidl.demo.common.IFibonacciServiceResponseListener;
import com.aidl.fiblib.NativeLib;

public class IFibonacciServiceImpl extends IFibonacciService.Stub {
    private static final String TAG = "IFibonacciServiceImpl";

    @Override
    public void fib(FibonacciRequest request,
            IFibonacciServiceResponseListener listener) throws RemoteException {
        long n = request.getN();
        Log.d(TAG, "fib(" + n + ")");
        long timeInMillis = SystemClock.uptimeMillis();
        long result;
        switch (request.getType()) {
            case ITERATIVE_JAVA:
                result = NativeLib.fibJI(n);
                break;
            case RECURSIVE_JAVA:
                result = NativeLib.fibJR(n);
                break;
            case ITERATIVE_NATIVE:
                result = NativeLib.fibNI(n);
                break;
            case RECURSIVE_NATIVE:
                result = NativeLib.fibNR(n);
                break;
            default:
                result = 0;
        }
        timeInMillis = SystemClock.uptimeMillis() - timeInMillis;
        Log.d(TAG, String.format("Got fib(%d) = %d in %d ms", n, result,
                timeInMillis));
        listener.onResponse(new FibonacciResponse(result, timeInMillis));
    }
}
