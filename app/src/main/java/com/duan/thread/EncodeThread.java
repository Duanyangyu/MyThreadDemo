package com.duan.thread;

import android.util.Log;

/**
 * Created by duanyy on 2018/3/19.
 */

public class EncodeThread extends Thread {

    public static final String TAG = "EncodeThread";

    private Object mSync;
    private int count = 0;

    public EncodeThread() {
        super();
        this.mSync = new Object();
    }

    @Override
    public void run() {
        super.run();

        for(;;){
            Log.e(TAG, String.valueOf(count++));
        }
    }
}
