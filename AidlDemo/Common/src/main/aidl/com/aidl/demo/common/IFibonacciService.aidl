// IFibonacciService.aidl
package com.aidl.demo.common;

import com.aidl.demo.common.FibonacciRequest;
import com.aidl.demo.common.FibonacciResponse;


// Declare any non-default types here with import statements

interface IFibonacciService {
    long fibJR(in long n);
    long fibJI(in long n);
    long fibNR(in long n);
    long fibNI(in long n);
    FibonacciResponse fib(in FibonacciRequest request);
}