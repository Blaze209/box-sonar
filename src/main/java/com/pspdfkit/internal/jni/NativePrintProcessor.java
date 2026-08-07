package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativePrintProcessor {

    public static final class CppProxy extends NativePrintProcessor {
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native void asyncGenerateToDataSink(NativePrintConfiguration nativePrintConfiguration, NativeProcessorDelegate nativeProcessorDelegate, NativeDataSink nativeDataSink);

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

    public static void asyncGenerateToDataSink(NativePrintConfiguration nativePrintConfiguration, NativeProcessorDelegate nativeProcessorDelegate, NativeDataSink nativeDataSink) {
        CppProxy.asyncGenerateToDataSink(nativePrintConfiguration, nativeProcessorDelegate, nativeDataSink);
    }
}
