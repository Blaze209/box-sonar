package com.amplitude.api;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes9.dex */
public class WorkerThread extends HandlerThread {
    private Handler handler;

    public WorkerThread(String str) {
        super(str, 10);
    }

    Handler getHandler() {
        return this.handler;
    }

    void post(Runnable runnable) {
        waitForInitialization();
        this.handler.post(runnable);
    }

    void postDelayed(Runnable runnable, long j) {
        waitForInitialization();
        this.handler.postDelayed(runnable, j);
    }

    void removeCallbacks(Runnable runnable) {
        waitForInitialization();
        this.handler.removeCallbacks(runnable);
    }

    private synchronized void waitForInitialization() {
        if (this.handler == null) {
            this.handler = new Handler(getLooper());
        }
    }
}
