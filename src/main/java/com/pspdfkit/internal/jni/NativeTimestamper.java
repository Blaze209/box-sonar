package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeTimestamper {

    public static final class CppProxy extends NativeTimestamper {
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeDigitalSignatureBinaryResult deserializeTimestampToken(String str);

        public static native String generateTimestampRequest(NativeTimestampAuthorityInfo nativeTimestampAuthorityInfo, byte[] bArr, boolean z);

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

    public static NativeDigitalSignatureBinaryResult deserializeTimestampToken(String str) {
        return CppProxy.deserializeTimestampToken(str);
    }

    public static String generateTimestampRequest(NativeTimestampAuthorityInfo nativeTimestampAuthorityInfo, byte[] bArr, boolean z) {
        return CppProxy.generateTimestampRequest(nativeTimestampAuthorityInfo, bArr, z);
    }
}
