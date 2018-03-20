package com.duan.thread;

import android.util.Log;

/**
 * Created by duanyy on 2018/3/19.
 */

public class DecodeThread extends Thread {

    public static final String TAG = "DecodeThread";

    private Object mSync;
    private int count = 0;
    private boolean mPause;

    public DecodeThread() {
        super();
        this.mSync = new Object();
    }

    public void pause(){
        synchronized (mSync){
            Log.e(TAG,"pause:currentThread.name:"+Thread.currentThread().getName()+", state:"+Thread.currentThread().getState().name());
            this.mPause = true;
        }
    }

    public void restart(){
        synchronized (mSync){
            this.mPause = false;
            mSync.notifyAll();
        }
    }

    @Override
    public void run() {
        super.run();
        for(;;){
            synchronized (mSync){
                Log.e(TAG,"run-1:currentThread.name:"+Thread.currentThread().getName()+", state:"+Thread.currentThread().getState().name());
                if (mPause){
                    try {
                        mSync.wait();//释放同步锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Log.e(TAG,"run-2:currentThread.name:"+Thread.currentThread().getName()+", state:"+Thread.currentThread().getState().name());
            }

            Log.e(TAG,getState().name()+", count="+String.valueOf(count++));

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
