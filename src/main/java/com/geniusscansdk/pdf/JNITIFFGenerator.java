package com.geniusscansdk.pdf;

import com.geniusscansdk.core.JNILogger;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes13.dex */
abstract class JNITIFFGenerator {
    public abstract JNIPDFGeneratorError generateTIFF(String str);

    JNITIFFGenerator() {
    }

    public static JNITIFFGenerator createWithDocument(JNIPDFDocument jNIPDFDocument, JNILogger jNILogger) {
        return CppProxy.createWithDocument(jNIPDFDocument, jNILogger);
    }

    private static final class CppProxy extends JNITIFFGenerator {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        public static native JNITIFFGenerator createWithDocument(JNIPDFDocument jNIPDFDocument, JNILogger jNILogger);

        private native void nativeDestroy(long j);

        private native JNIPDFGeneratorError native_generateTIFF(long j, String str);

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

        @Override // com.geniusscansdk.pdf.JNITIFFGenerator
        public JNIPDFGeneratorError generateTIFF(String str) {
            return native_generateTIFF(this.nativeRef, str);
        }
    }
}
