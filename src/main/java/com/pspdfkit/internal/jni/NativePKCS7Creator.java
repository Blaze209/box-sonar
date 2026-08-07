package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativePKCS7Creator {

    public static final class CppProxy extends NativePKCS7Creator {
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeDigitalSignatureBinaryResult createCadesAttributesToSign(byte[] bArr, NativeHashAlgorithm nativeHashAlgorithm, NativeX509Certificate nativeX509Certificate);

        public static native NativeDigitalSignatureBinaryResult createSignature(NativeDigitalSignatureType nativeDigitalSignatureType, byte[] bArr, byte[] bArr2, ArrayList<NativeX509Certificate> arrayList, byte[] bArr3, NativeHashAlgorithm nativeHashAlgorithm);

        private native void nativeDestroy(long j);

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
    }

    public static NativeDigitalSignatureBinaryResult createCadesAttributesToSign(byte[] bArr, NativeHashAlgorithm nativeHashAlgorithm, NativeX509Certificate nativeX509Certificate) {
        return CppProxy.createCadesAttributesToSign(bArr, nativeHashAlgorithm, nativeX509Certificate);
    }

    public static NativeDigitalSignatureBinaryResult createSignature(NativeDigitalSignatureType nativeDigitalSignatureType, byte[] bArr, byte[] bArr2, ArrayList<NativeX509Certificate> arrayList, byte[] bArr3, NativeHashAlgorithm nativeHashAlgorithm) {
        return CppProxy.createSignature(nativeDigitalSignatureType, bArr, bArr2, arrayList, bArr3, nativeHashAlgorithm);
    }
}
