//
// Created by Administrator on 2020/8/18 0018.
// 放JNI代码，就是java的Native代码生成的JNI函数
//
/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
#include "demo.cpp"
/* Header for class com_my_myjni_jni_Demo */

#ifndef _Included_com_my_myjni_jni_Demo
#define _Included_com_my_myjni_jni_Demo
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_my_myjni_jni_Demo
 * Method:    sum
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_com_my_myjni_jni_Demo_sum
        (JNIEnv *, jobject, jint a, jint b) {
    Demo demo = Demo();
    jint result = demo.sum(a, b);
    return result;
}

#ifdef __cplusplus
}
#endif
#endif

