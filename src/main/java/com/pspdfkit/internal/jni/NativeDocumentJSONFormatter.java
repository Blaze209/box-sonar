package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDocumentJSONFormatter {

    public static final class CppProxy extends NativeDocumentJSONFormatter {
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeResult exportJson(NativeInstantJSONVersion nativeInstantJSONVersion, NativeDocument nativeDocument, int i, NativeDataSink nativeDataSink);

        public static native NativeSkippedAnnotationResult getSkippedAnnotations(NativeDocument nativeDocument, int i, NativeDataProvider nativeDataProvider, boolean z);

        public static native NativeImportDocumentJSONResult importJson(NativeDocument nativeDocument, int i, NativeDataProvider nativeDataProvider, boolean z);

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

    public static NativeResult exportJson(NativeInstantJSONVersion nativeInstantJSONVersion, NativeDocument nativeDocument, int i, NativeDataSink nativeDataSink) {
        return CppProxy.exportJson(nativeInstantJSONVersion, nativeDocument, i, nativeDataSink);
    }

    public static NativeSkippedAnnotationResult getSkippedAnnotations(NativeDocument nativeDocument, int i, NativeDataProvider nativeDataProvider, boolean z) {
        return CppProxy.getSkippedAnnotations(nativeDocument, i, nativeDataProvider, z);
    }

    public static NativeImportDocumentJSONResult importJson(NativeDocument nativeDocument, int i, NativeDataProvider nativeDataProvider, boolean z) {
        return CppProxy.importJson(nativeDocument, i, nativeDataProvider, z);
    }
}
