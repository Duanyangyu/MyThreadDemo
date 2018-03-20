package com.duan.thread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    private Object mSync;
    private DecodeThread decodeThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSync = new Object();
        decodeThread = new DecodeThread();
        decodeThread.setName("DecoderThread");
        decodeThread.start();
    }

    public void btnStart(View view){
        decodeThread.restart();
        Log.e(TAG,"start:decodeThread.state:"+decodeThread.getState().name());
        Log.e(TAG,"start:mainThread.state:"+Thread.currentThread().getState().name());
    }

    public void btnPause(View view){
        decodeThread.pause();
    }

}
