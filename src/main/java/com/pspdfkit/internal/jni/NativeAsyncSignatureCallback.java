package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeAsyncSignatureCallback {

    public static final class CppProxy extends NativeAsyncSignatureCallback {
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

        private native void native_complete(long j, boolean z, byte[] bArr);

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

        @Override // com.pspdfkit.internal.jni.NativeAsyncSignatureCallback
        public void complete(boolean z, byte[] bArr) {
            native_complete(this.nativeRef, z, bArr);
        }
    }

    public abstract void complete(boolean z, byte[] bArr);
}
