package com.pspdfkit.instant.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeProgressReporter {

    public static final class CppProxy extends NativeProgressReporter {
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

        private native void native_addObserver(long j, NativeProgressObserver nativeProgressObserver);

        private native void native_cancel(long j);

        private native double native_getCurrentProgress(long j);

        private native boolean native_isInFinalState(long j);

        private native void native_removeObserver(long j, NativeProgressObserver nativeProgressObserver);

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

        @Override // com.pspdfkit.instant.internal.jni.NativeProgressReporter
        public void addObserver(NativeProgressObserver nativeProgressObserver) {
            native_addObserver(this.nativeRef, nativeProgressObserver);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeProgressReporter
        public void cancel() {
            native_cancel(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeProgressReporter
        public double getCurrentProgress() {
            return native_getCurrentProgress(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeProgressReporter
        public boolean isInFinalState() {
            return native_isInFinalState(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeProgressReporter
        public void removeObserver(NativeProgressObserver nativeProgressObserver) {
            native_removeObserver(this.nativeRef, nativeProgressObserver);
        }
    }

    public abstract void addObserver(NativeProgressObserver nativeProgressObserver);

    public abstract void cancel();

    public abstract double getCurrentProgress();

    public abstract boolean isInFinalState();

    public abstract void removeObserver(NativeProgressObserver nativeProgressObserver);
}
