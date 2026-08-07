package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeProgressiveRenderSession {

    public static final class CppProxy extends NativeProgressiveRenderSession {
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

        private native void native_cancel(long j);

        private native NativeProgressiveRenderStepResult native_continueRender(long j, int i);

        private native NativeProgressiveRenderStatus native_getStatus(long j);

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

        @Override // com.pspdfkit.internal.jni.NativeProgressiveRenderSession
        public void cancel() {
            native_cancel(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeProgressiveRenderSession
        public NativeProgressiveRenderStepResult continueRender(int i) {
            return native_continueRender(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeProgressiveRenderSession
        public NativeProgressiveRenderStatus getStatus() {
            return native_getStatus(this.nativeRef);
        }
    }

    public abstract void cancel();

    public abstract NativeProgressiveRenderStepResult continueRender(int i);

    public abstract NativeProgressiveRenderStatus getStatus();
}
