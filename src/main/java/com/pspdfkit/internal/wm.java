package com.pspdfkit.internal;

import android.os.Looper;
import com.pspdfkit.internal.jni.NativePlatformThreads;
import com.pspdfkit.internal.jni.NativeThreadFunc;
import com.pspdfkit.internal.jni.NativeThreadPriority;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class wm extends NativePlatformThreads {
    @Override // com.pspdfkit.internal.jni.NativePlatformThreads
    public final void createThread(String str, final NativeThreadFunc nativeThreadFunc, NativeThreadPriority nativeThreadPriority) {
        Objects.requireNonNull(nativeThreadFunc);
        Thread thread = new Thread(new Runnable() { // from class: com.pspdfkit.internal.wm$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                nativeThreadFunc.runThread();
            }
        }, str);
        thread.setDaemon(true);
        thread.start();
    }

    @Override // com.pspdfkit.internal.jni.NativePlatformThreads
    public final Boolean isMainThread() {
        return Boolean.valueOf(Looper.myLooper() == Looper.getMainLooper());
    }
}
