package com.geniusscansdk.ocr;

import com.geniusscansdk.core.JNILogger;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes13.dex */
abstract class JNIOCREngine {
    public abstract JNIOCREngineResult recognizeText(JNIOCREngineInput jNIOCREngineInput);

    JNIOCREngine() {
    }

    public static JNIOCREngine create(JNIOCREngineConfiguration jNIOCREngineConfiguration, JNILogger jNILogger, JNIOCREngineProgressListener jNIOCREngineProgressListener) {
        return CppProxy.create(jNIOCREngineConfiguration, jNILogger, jNIOCREngineProgressListener);
    }

    private static final class CppProxy extends JNIOCREngine {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        public static native JNIOCREngine create(JNIOCREngineConfiguration jNIOCREngineConfiguration, JNILogger jNILogger, JNIOCREngineProgressListener jNIOCREngineProgressListener);

        private native void nativeDestroy(long j);

        private native JNIOCREngineResult native_recognizeText(long j, JNIOCREngineInput jNIOCREngineInput);

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public void _djinni_private_destroy() {
            if (this.destroyed.getAndSet(true)) {
                return;
            }
            nativeDestroy(this.nativeRef);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.geniusscansdk.ocr.JNIOCREngine
        public JNIOCREngineResult recognizeText(JNIOCREngineInput jNIOCREngineInput) {
            return native_recognizeText(this.nativeRef, jNIOCREngineInput);
        }
    }
}
