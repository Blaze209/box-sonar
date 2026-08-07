package com.geniusscansdk.core;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes13.dex */
public abstract class JNITextLayoutToTextConverter {
    public abstract JNITextLayoutToTextConverterResult convert(JNITextLayout jNITextLayout);

    public static JNITextLayoutToTextConverter create(JNILogger jNILogger) {
        return CppProxy.create(jNILogger);
    }

    private static final class CppProxy extends JNITextLayoutToTextConverter {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        public static native JNITextLayoutToTextConverter create(JNILogger jNILogger);

        private native void nativeDestroy(long j);

        private native JNITextLayoutToTextConverterResult native_convert(long j, JNITextLayout jNITextLayout);

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

        @Override // com.geniusscansdk.core.JNITextLayoutToTextConverter
        public JNITextLayoutToTextConverterResult convert(JNITextLayout jNITextLayout) {
            return native_convert(this.nativeRef, jNITextLayout);
        }
    }
}
