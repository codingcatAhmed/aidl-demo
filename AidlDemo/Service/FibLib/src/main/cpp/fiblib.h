//
// Created by ahmed on 13/10/2022.
//
#include <jni.h>
#include <android/log.h>

#ifndef AIDLDEMO_FIBLIB_H
#define AIDLDEMO_FIBLIB_H
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_marakana_android_fibonaccinative_FibLib
 * Method:    fibNR
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_com_aidl_fiblib_NativeLib_ibNR
  (JNIEnv *, jclass, jlong);

/*
 * Class:     com_marakana_android_fibonaccinative_FibLib
 * Method:    fibNI
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_com_aidl_fiblib_NativeLib_fibNI
  (JNIEnv *, jclass, jlong);

#ifdef __cplusplus
}
#endif
#endif //AIDLDEMO_FIBLIB_H
