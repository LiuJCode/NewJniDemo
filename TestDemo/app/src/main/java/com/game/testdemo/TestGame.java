package com.game.testdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.game.sdk.GGManage;

/**
 * 版权：七风网络科技 版权所有
 *
 * @author LIUJING
 * 版本：2.0
 * 创建日期：2020/8/27 0027
 * 描述：default
 */
public class TestGame extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        findViewById(R.id.aaa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GGManage.showFoaltgg(TestGame.this);
            }
        });

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                TestGame.this.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        GGManage.showFoaltgg(TestGame.this);
//                    }
//                });
//            }
//        });

    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub
        super.onWindowFocusChanged(hasFocus);
//        GGManage.showFoaltgg(TestGame.this);
    }

}
