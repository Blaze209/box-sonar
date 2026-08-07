package com.pspdfkit.instant.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeProgressObserver {

    public static final class CppProxy extends NativeProgressObserver {
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

        private native void native_onCancellation(long j, NativeProgressReporter nativeProgressReporter);

        private native void native_onError(long j, NativeProgressReporter nativeProgressReporter, NativeInstantError nativeInstantError);

        private native void native_onProgress(long j, NativeProgressReporter nativeProgressReporter);

        private native void native_onSuccess(long j, NativeProgressReporter nativeProgressReporter);

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

        @Override // com.pspdfkit.instant.internal.jni.NativeProgressObserver
        public void onCancellation(NativeProgressReporter nativeProgressReporter) {
            native_onCancellation(this.nativeRef, nativeProgressReporter);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeProgressObserver
        public void onError(NativeProgressReporter nativeProgressReporter, NativeInstantError nativeInstantError) {
            native_onError(this.nativeRef, nativeProgressReporter, nativeInstantError);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeProgressObserver
        public void onProgress(NativeProgressReporter nativeProgressReporter) {
            native_onProgress(this.nativeRef, nativeProgressReporter);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeProgressObserver
        public void onSuccess(NativeProgressReporter nativeProgressReporter) {
            native_onSuccess(this.nativeRef, nativeProgressReporter);
        }
    }

    public abstract void onCancellation(NativeProgressReporter nativeProgressReporter);

    public abstract void onError(NativeProgressReporter nativeProgressReporter, NativeInstantError nativeInstantError);

    public abstract void onProgress(NativeProgressReporter nativeProgressReporter);

    public abstract void onSuccess(NativeProgressReporter nativeProgressReporter);
}
