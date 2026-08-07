package com.geniusscansdk.camera.realtime;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.geniusscansdk.core.DocumentDetector;
import com.geniusscansdk.core.QuadStreamAnalyzer;
import java.lang.ref.WeakReference;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes13.dex */
class BorderDetectionThreadManager {
    private static final BorderDetectionThreadManager sInstance = new BorderDetectionThreadManager();
    private WeakReference<BorderDetectionCallback> callbackReference = new WeakReference<>(null);
    private final Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.geniusscansdk.camera.realtime.BorderDetectionThreadManager.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BorderDetectionTask borderDetectionTask = (BorderDetectionTask) message.obj;
            BorderDetectionCallback borderDetectionCallback = (BorderDetectionCallback) BorderDetectionThreadManager.this.callbackReference.get();
            if (borderDetectionTask == null || borderDetectionCallback == null) {
                return;
            }
            if (borderDetectionTask.getError() != null) {
                borderDetectionCallback.onBorderDetectionFailed(borderDetectionTask.getError());
            } else {
                borderDetectionCallback.onBorderDetectionFinished(borderDetectionTask.getResult());
            }
        }
    };
    private final BlockingQueue<Runnable> taskQueue;
    private final ThreadPoolExecutor threadPoolExec;

    public interface BorderDetectionCallback {
        void onBorderDetectionFailed(Exception exc);

        void onBorderDetectionFinished(QuadStreamAnalyzer.Result result);
    }

    public BorderDetectionThreadManager() {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
        this.taskQueue = arrayBlockingQueue;
        this.threadPoolExec = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, arrayBlockingQueue);
    }

    public static BorderDetectionThreadManager getInstance() {
        return sInstance;
    }

    public void setCallback(BorderDetectionCallback borderDetectionCallback) {
        this.callbackReference = new WeakReference<>(borderDetectionCallback);
    }

    public static void processPicture(byte[] bArr, int i, int i2, int i3, DocumentDetector documentDetector) {
        BorderDetectionThreadManager borderDetectionThreadManager = sInstance;
        if (borderDetectionThreadManager.callbackReference.get() == null) {
            throw new RuntimeException("Callback is not defined");
        }
        BorderDetectionTask borderDetectionTask = (BorderDetectionTask) borderDetectionThreadManager.taskQueue.poll();
        if (borderDetectionTask == null) {
            borderDetectionTask = new BorderDetectionTask(bArr, i, i2, i3, documentDetector);
        }
        borderDetectionThreadManager.threadPoolExec.execute(borderDetectionTask);
    }

    void endTask(BorderDetectionTask borderDetectionTask) {
        this.mHandler.obtainMessage(0, borderDetectionTask).sendToTarget();
    }
}
