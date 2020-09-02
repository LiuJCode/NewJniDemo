package com.game.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * @版权：七风网络科技版权所有
 * @author：刘晶
 * @版本：2.1
 * @创建日期：2020/06/08
 * @描述：浮标基类
 **/
public  class GGFloatView {
    protected Activity mContext;
    protected View floatview;
    private static WindowManager mWindowManager;
    float num = 1;
    protected  void initFloatView() {
      TextView jiansu =  floatview.findViewById(R.id.jiansu);
      TextView jiasu  =   floatview.findViewById(R.id.jiasu);
        jiansu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num > 1) {
                    num --;
                }
                Log.i("GGGmae","减少" + num);
                GGManage.ggGameChange(num);
            }
        });
        jiasu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num < 20) {
                    num ++;
                }
                Log.i("GGGmae","增加" + num);
                GGManage.ggGameChange(num);
            }
        });
    };

    protected int getLayoutViewId() {
        return R.layout.gggame;
    }

    public void showFloatView(Activity mctivity) {
        this.mContext = mctivity;
        onCreatFloatView();
        initFloatView();
    }

    public void removeFloatView() {
        removeView();
    }

    private void onCreatFloatView() {
        try {
            if (floatview == null) {
                if (mContext == null) {
                    Log.i("GGGAME","游戏传入的context为null");
                    return;
                }
                WindowManager.LayoutParams wmParams = new WindowManager.LayoutParams();
                // 获取的是WindowManagerImpl.CompatModeWrapper
                if (mWindowManager == null && mContext != null) {
                    mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
                }
                wmParams.type = 1028;
                // 设置图片格式，效果为背景透明
                wmParams.format = PixelFormat.RGBA_8888;
                // 设置浮动窗口不可聚焦（实现操作除浮动窗口外的其他可见窗口的操作）
//                FLAG_NOT_FOCUSABLE FLAG_NOT_TOUCH_MODAL
                wmParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL; //关键 否则页面弹不出键盘
//                wmParams.softInputMode = LayoutParams.SOFT_INPUT_ADJUST_PAN; //键盘弹出形式
                // 调整悬浮窗显示的停靠位置为左侧置顶
                wmParams.gravity = Gravity.LEFT | Gravity.BOTTOM;
                // 以屏幕左上角为原点，设置x、y初始值，相对于gravity
                wmParams.x = 0;
                wmParams.y = 0;
                wmParams.alpha = 1;
                // 设置悬浮窗口长宽数据
                wmParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
                wmParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
                floatview = LayoutInflater.from(mContext).inflate(getLayoutViewId(), null);
                // 添加mFloatLayout
                if (mWindowManager == null || floatview == null) {
                    throw new Exception("空指指针了");
                } else {
                    mWindowManager.addView(floatview, wmParams);
                }
            } else {
                //如果页面已经存在就先移除掉，再调用一个新的。
                if (mWindowManager != null && floatview != null) {
                    mWindowManager.removeView(floatview);
                }
                floatview = null;
                onCreatFloatView();
            }
        } catch (IllegalArgumentException e) {
            // TODO: handle exception
            Log.e("Exception", "初始化IllegalArgumentException");
        } catch (Exception e) {
            // TODO: handle exception
            Log.e("catch", "err: ", e);
            Log.i("GGGAME","获取mWindowManager失败");
        }
    }

    /**
     * 移除view
     */
    private void removeView() {
        try {
            if (mWindowManager != null && floatview != null) {
                mWindowManager.removeView(floatview);
            }
        } catch (IllegalArgumentException e) {
            Log.e("catch", "err: ", e);
        } catch (Exception e) {
            Log.e("catch", "err: ", e);
        } finally {
//            if (floatview != null) {
//                floatview = null;
//            }
//            if (mWindowManager != null) {
//                mWindowManager = null;
//            }
//            if (mContext != null) {
//                mContext = null;
//            }
        }
    }
}
