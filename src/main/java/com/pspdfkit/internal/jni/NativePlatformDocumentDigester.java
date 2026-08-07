package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativePlatformDocumentDigester {

    public static final class CppProxy extends NativePlatformDocumentDigester {
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativePlatformDocumentDigesterResult digestRangeOfDocument(NativeDocumentProvider nativeDocumentProvider, ArrayList<Long> arrayList, NativeHashAlgorithm nativeHashAlgorithm);

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

    public static NativePlatformDocumentDigesterResult digestRangeOfDocument(NativeDocumentProvider nativeDocumentProvider, ArrayList<Long> arrayList, NativeHashAlgorithm nativeHashAlgorithm) {
        return CppProxy.digestRangeOfDocument(nativeDocumentProvider, arrayList, nativeHashAlgorithm);
    }
}
