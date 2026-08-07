package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeProcessor {

    public static final class CppProxy extends NativeProcessor {
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native void asyncGenerateToDataSink(NativeProcessorConfiguration nativeProcessorConfiguration, NativeProcessorDelegate nativeProcessorDelegate, NativeDocumentSaveOptions nativeDocumentSaveOptions, NativeDataSink nativeDataSink);

        public static native void asyncGenerateToFile(NativeProcessorConfiguration nativeProcessorConfiguration, NativeProcessorDelegate nativeProcessorDelegate, NativeDocumentSaveOptions nativeDocumentSaveOptions, String str);

        public static native NativeResult generateToDataSink(NativeProcessorConfiguration nativeProcessorConfiguration, NativeProcessorDelegate nativeProcessorDelegate, NativeDocumentSaveOptions nativeDocumentSaveOptions, NativeDataSink nativeDataSink);

        public static native NativeResult generateToFile(NativeProcessorConfiguration nativeProcessorConfiguration, NativeProcessorDelegate nativeProcessorDelegate, NativeDocumentSaveOptions nativeDocumentSaveOptions, String str);

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

    public static void asyncGenerateToDataSink(NativeProcessorConfiguration nativeProcessorConfiguration, NativeProcessorDelegate nativeProcessorDelegate, NativeDocumentSaveOptions nativeDocumentSaveOptions, NativeDataSink nativeDataSink) {
        CppProxy.asyncGenerateToDataSink(nativeProcessorConfiguration, nativeProcessorDelegate, nativeDocumentSaveOptions, nativeDataSink);
    }

    public static void asyncGenerateToFile(NativeProcessorConfiguration nativeProcessorConfiguration, NativeProcessorDelegate nativeProcessorDelegate, NativeDocumentSaveOptions nativeDocumentSaveOptions, String str) {
        CppProxy.asyncGenerateToFile(nativeProcessorConfiguration, nativeProcessorDelegate, nativeDocumentSaveOptions, str);
    }

    public static NativeResult generateToDataSink(NativeProcessorConfiguration nativeProcessorConfiguration, NativeProcessorDelegate nativeProcessorDelegate, NativeDocumentSaveOptions nativeDocumentSaveOptions, NativeDataSink nativeDataSink) {
        return CppProxy.generateToDataSink(nativeProcessorConfiguration, nativeProcessorDelegate, nativeDocumentSaveOptions, nativeDataSink);
    }

    public static NativeResult generateToFile(NativeProcessorConfiguration nativeProcessorConfiguration, NativeProcessorDelegate nativeProcessorDelegate, NativeDocumentSaveOptions nativeDocumentSaveOptions, String str) {
        return CppProxy.generateToFile(nativeProcessorConfiguration, nativeProcessorDelegate, nativeDocumentSaveOptions, str);
    }
}
