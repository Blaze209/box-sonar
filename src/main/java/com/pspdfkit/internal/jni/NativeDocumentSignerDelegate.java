package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDocumentSignerDelegate {

    public static final class CppProxy extends NativeDocumentSignerDelegate {
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

        private native void native_signData(long j, byte[] bArr, NativeHashAlgorithm nativeHashAlgorithm, NativeAsyncSignatureCallback nativeAsyncSignatureCallback);

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

        @Override // com.pspdfkit.internal.jni.NativeDocumentSignerDelegate
        public void signData(byte[] bArr, NativeHashAlgorithm nativeHashAlgorithm, NativeAsyncSignatureCallback nativeAsyncSignatureCallback) {
            native_signData(this.nativeRef, bArr, nativeHashAlgorithm, nativeAsyncSignatureCallback);
        }
    }

    public abstract void signData(byte[] bArr, NativeHashAlgorithm nativeHashAlgorithm, NativeAsyncSignatureCallback nativeAsyncSignatureCallback);
}
