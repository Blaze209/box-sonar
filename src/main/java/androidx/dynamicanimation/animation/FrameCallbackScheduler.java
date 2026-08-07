package androidx.dynamicanimation.animation;

/* JADX INFO: loaded from: classes8.dex */
public interface FrameCallbackScheduler {
    boolean isCurrentThread();

    void postFrameCallback(Runnable runnable);
}
