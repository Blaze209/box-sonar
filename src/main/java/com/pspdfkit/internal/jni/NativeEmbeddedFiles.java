package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeEmbeddedFiles {

    public static final class CppProxy extends NativeEmbeddedFiles {
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeEmbeddedFileAddResult add(NativeDocumentProvider nativeDocumentProvider, NativeEmbeddedFile nativeEmbeddedFile, NativeDataProvider nativeDataProvider);

        public static native NativeResult extract(NativeDocumentProvider nativeDocumentProvider, String str, NativeDataSink nativeDataSink);

        public static native NativeEmbeddedFileListResult list(NativeDocumentProvider nativeDocumentProvider);

        private native void nativeDestroy(long j);

        public static native NativeResult remove(NativeDocumentProvider nativeDocumentProvider, String str);

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

    public static NativeEmbeddedFileAddResult add(NativeDocumentProvider nativeDocumentProvider, NativeEmbeddedFile nativeEmbeddedFile, NativeDataProvider nativeDataProvider) {
        return CppProxy.add(nativeDocumentProvider, nativeEmbeddedFile, nativeDataProvider);
    }

    public static NativeResult extract(NativeDocumentProvider nativeDocumentProvider, String str, NativeDataSink nativeDataSink) {
        return CppProxy.extract(nativeDocumentProvider, str, nativeDataSink);
    }

    public static NativeEmbeddedFileListResult list(NativeDocumentProvider nativeDocumentProvider) {
        return CppProxy.list(nativeDocumentProvider);
    }

    public static NativeResult remove(NativeDocumentProvider nativeDocumentProvider, String str) {
        return CppProxy.remove(nativeDocumentProvider, str);
    }
}
