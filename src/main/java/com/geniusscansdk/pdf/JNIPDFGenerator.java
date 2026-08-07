package com.geniusscansdk.pdf;

import com.geniusscansdk.core.JNILogger;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes13.dex */
abstract class JNIPDFGenerator {
    public abstract JNIPDFGeneratorError generatePDF(String str);

    public abstract byte[] generatePDFToMemory();

    JNIPDFGenerator() {
    }

    public static JNIPDFGenerator createWithDocument(JNIPDFDocument jNIPDFDocument, JNIPDFGeneratorConfiguration jNIPDFGeneratorConfiguration, JNIPDFImageProcessor jNIPDFImageProcessor, JNILogger jNILogger) {
        return CppProxy.createWithDocument(jNIPDFDocument, jNIPDFGeneratorConfiguration, jNIPDFImageProcessor, jNILogger);
    }

    private static final class CppProxy extends JNIPDFGenerator {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        public static native JNIPDFGenerator createWithDocument(JNIPDFDocument jNIPDFDocument, JNIPDFGeneratorConfiguration jNIPDFGeneratorConfiguration, JNIPDFImageProcessor jNIPDFImageProcessor, JNILogger jNILogger);

        private native void nativeDestroy(long j);

        private native JNIPDFGeneratorError native_generatePDF(long j, String str);

        private native byte[] native_generatePDFToMemory(long j);

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

        @Override // com.geniusscansdk.pdf.JNIPDFGenerator
        public JNIPDFGeneratorError generatePDF(String str) {
            return native_generatePDF(this.nativeRef, str);
        }

        @Override // com.geniusscansdk.pdf.JNIPDFGenerator
        public byte[] generatePDFToMemory() {
            return native_generatePDFToMemory(this.nativeRef);
        }
    }
}
