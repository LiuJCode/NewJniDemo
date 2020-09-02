package com.game.sdk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.game.sdk.jni.QFGame;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("qifengjs-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);
        tv.setText(QFGame.test("我是谁？我是JNI"));
//        AiQuYouXi.AiQuYouXiui();
        //tv.setText(stringFromJNI());
        QFGame.init(MainActivity.this);
        QFGame.setNum(10);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
//    public native String stringFromJNI();
}
