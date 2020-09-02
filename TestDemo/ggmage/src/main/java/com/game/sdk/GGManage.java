package com.game.sdk;

import android.app.Activity;
import android.util.Log;

import com.game.sdk.jni.QFGame;

/**
 * 版权：七风网络科技 版权所有
 *
 * @author LIUJING
 * 版本：2.0
 * 创建日期：2020/8/27 0027
 * 描述：游戏加速管理
 */
public class GGManage {
    static {
        System.loadLibrary("qifengjs-lib");
    }

    public static void showFoaltgg(Activity activity) {
        QFGame.init(activity);
        GGFloatView ggFloatView = new GGFloatView();
        ggFloatView.showFloatView(activity);
    }

    public static void ggGameChange(float num) {
        Log.i("GGGame","加速还是减速 = " + num);
        QFGame.setNum(num);
    }
}
