package com.game.sdk.jni;

import android.app.Activity;

/**
 * @author LIUJING
 * new  .class file
 * javah -classpath . -jni com.game.sdk.jni.QFGame
 */
public class QFGame {
    public static native int InitQFServer();

    public static native void setQFNum(float num);

    public static native void QFAddTime();

    public static native String test(String testMsg);

    public static Activity ACTIVITY;

    public static void init(Activity activity) {
        ACTIVITY = activity;
        InitQFServer();
    }

    public static void setNum(float num) {
        setQFNum(num);
    }
}
