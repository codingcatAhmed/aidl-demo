// IFibonacciService.aidl
package com.aidl.demo.common;

import com.aidl.demo.common.FibonacciRequest;
import com.aidl.demo.common.FibonacciResponse;
import com.aidl.demo.common.IFibonacciServiceResponseListener;

// Declare any non-default types here with import statements

oneway interface IFibonacciService {
    void fib(in FibonacciRequest request, in IFibonacciServiceResponseListener listener);
}