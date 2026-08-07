package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeX509CRL {

    public static final class CppProxy extends NativeX509CRL {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeX509CRL createFromData(byte[] bArr);

        private native void nativeDestroy(long j);

        private native String native_getIssuerDN(long j);

        private native int native_getSerialNumber(long j);

        private native boolean native_isRevoked(long j, NativeX509Certificate nativeX509Certificate);

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

        @Override // com.pspdfkit.internal.jni.NativeX509CRL
        public String getIssuerDN() {
            return native_getIssuerDN(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeX509CRL
        public int getSerialNumber() {
            return native_getSerialNumber(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeX509CRL
        public boolean isRevoked(NativeX509Certificate nativeX509Certificate) {
            return native_isRevoked(this.nativeRef, nativeX509Certificate);
        }
    }

    public static NativeX509CRL createFromData(byte[] bArr) {
        return CppProxy.createFromData(bArr);
    }

    public abstract String getIssuerDN();

    public abstract int getSerialNumber();

    public abstract boolean isRevoked(NativeX509Certificate nativeX509Certificate);
}
