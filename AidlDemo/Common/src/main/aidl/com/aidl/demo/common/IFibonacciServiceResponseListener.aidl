// IFibonacciServiceResponseListener.aidl
package com.aidl.demo.common;

import com.aidl.demo.common.FibonacciRequest;
import com.aidl.demo.common.FibonacciResponse;

oneway interface IFibonacciServiceResponseListener {
    void onResponse(in FibonacciResponse response);
}