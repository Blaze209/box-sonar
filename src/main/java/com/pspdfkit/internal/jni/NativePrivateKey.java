package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativePrivateKey {

    public static final class CppProxy extends NativePrivateKey {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativePrivateKey createFromRawPrivateKey(byte[] bArr, NativePrivateKeyEncoding nativePrivateKeyEncoding);

        private native void nativeDestroy(long j);

        private native NativeEncryptionAlgorithm native_encryptionAlgorithm(long j);

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

        @Override // com.pspdfkit.internal.jni.NativePrivateKey
        public NativeEncryptionAlgorithm encryptionAlgorithm() {
            return native_encryptionAlgorithm(this.nativeRef);
        }
    }

    public static NativePrivateKey createFromRawPrivateKey(byte[] bArr, NativePrivateKeyEncoding nativePrivateKeyEncoding) {
        return CppProxy.createFromRawPrivateKey(bArr, nativePrivateKeyEncoding);
    }

    public abstract NativeEncryptionAlgorithm encryptionAlgorithm();
}
