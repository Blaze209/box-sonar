package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativePlatformThreads {

    public static final class CppProxy extends NativePlatformThreads {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        private native void nativeDestroy(long j);

        private native void native_createThread(long j, String str, NativeThreadFunc nativeThreadFunc, NativeThreadPriority nativeThreadPriority);

        private native Boolean native_isMainThread(long j);

        public void _djinni_private_destroy() {
            if (this.destroyed.getAndSet(true)) {
                return;
            }
            nativeDestroy(this.nativeRef);
        }

        public void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.pspdfkit.internal.jni.NativePlatformThreads
        public void createThread(String str, NativeThreadFunc nativeThreadFunc, NativeThreadPriority nativeThreadPriority) {
            native_createThread(this.nativeRef, str, nativeThreadFunc, nativeThreadPriority);
        }

        @Override // com.pspdfkit.internal.jni.NativePlatformThreads
        public Boolean isMainThread() {
            return native_isMainThread(this.nativeRef);
        }
    }

    public abstract void createThread(String str, NativeThreadFunc nativeThreadFunc, NativeThreadPriority nativeThreadPriority);

    public abstract Boolean isMainThread();
}
