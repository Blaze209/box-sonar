package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativePlatformPKCS7 {

    public static final class CppProxy extends NativePlatformPKCS7 {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativePlatformPKCS7 create(NativeFilterSubtype nativeFilterSubtype, byte[] bArr, NativePrivateKey nativePrivateKey, ArrayList<NativeX509Certificate> arrayList, NativeHashAlgorithm nativeHashAlgorithm, NativeEncryptionAlgorithm nativeEncryptionAlgorithm);

        public static native NativePlatformPKCS7 createFromSignedDigest(NativeFilterSubtype nativeFilterSubtype, byte[] bArr, byte[] bArr2, ArrayList<NativeX509Certificate> arrayList, NativeHashAlgorithm nativeHashAlgorithm, NativeEncryptionAlgorithm nativeEncryptionAlgorithm, byte[] bArr3);

        private native void nativeDestroy(long j);

        private native byte[] native_data(long j);

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

        @Override // com.pspdfkit.internal.jni.NativePlatformPKCS7
        public byte[] data() {
            return native_data(this.nativeRef);
        }
    }

    public static NativePlatformPKCS7 create(NativeFilterSubtype nativeFilterSubtype, byte[] bArr, NativePrivateKey nativePrivateKey, ArrayList<NativeX509Certificate> arrayList, NativeHashAlgorithm nativeHashAlgorithm, NativeEncryptionAlgorithm nativeEncryptionAlgorithm) {
        return CppProxy.create(nativeFilterSubtype, bArr, nativePrivateKey, arrayList, nativeHashAlgorithm, nativeEncryptionAlgorithm);
    }

    public static NativePlatformPKCS7 createFromSignedDigest(NativeFilterSubtype nativeFilterSubtype, byte[] bArr, byte[] bArr2, ArrayList<NativeX509Certificate> arrayList, NativeHashAlgorithm nativeHashAlgorithm, NativeEncryptionAlgorithm nativeEncryptionAlgorithm, byte[] bArr3) {
        return CppProxy.createFromSignedDigest(nativeFilterSubtype, bArr, bArr2, arrayList, nativeHashAlgorithm, nativeEncryptionAlgorithm, bArr3);
    }

    public abstract byte[] data();
}
