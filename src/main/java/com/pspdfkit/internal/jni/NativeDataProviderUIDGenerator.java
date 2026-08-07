package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDataProviderUIDGenerator {

    public static final class CppProxy extends NativeDataProviderUIDGenerator {
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native String generateUid(NativeDataProvider nativeDataProvider);

        public static native byte[] getUidData(NativeDataProvider nativeDataProvider);

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

    public static String generateUid(NativeDataProvider nativeDataProvider) {
        return CppProxy.generateUid(nativeDataProvider);
    }

    public static byte[] getUidData(NativeDataProvider nativeDataProvider) {
        return CppProxy.getUidData(nativeDataProvider);
    }
}
