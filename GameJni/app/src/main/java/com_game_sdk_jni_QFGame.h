/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_game_sdk_jni_QFGame */

#ifndef _Included_com_game_sdk_jni_QFGame
#define _Included_com_game_sdk_jni_QFGame
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_game_sdk_jni_QFGame
 * Method:    InitQFServer
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_game_sdk_jni_QFGame_InitQFServer
  (JNIEnv *, jclass);

/*
 * Class:     com_game_sdk_jni_QFGame
 * Method:    setQFNum
 * Signature: (F)V
 */
JNIEXPORT void JNICALL Java_com_game_sdk_jni_QFGame_setQFNum
  (JNIEnv *, jclass, jfloat);

/*
 * Class:     com_game_sdk_jni_QFGame
 * Method:    QFAddTime
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_game_sdk_jni_QFGame_QFAddTime
  (JNIEnv *, jclass);

/*
 * Class:     com_game_sdk_jni_QFGame
 * Method:    test
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_game_sdk_jni_QFGame_test
  (JNIEnv *, jclass, jstring);

#ifdef __cplusplus
}
#endif
#endif
