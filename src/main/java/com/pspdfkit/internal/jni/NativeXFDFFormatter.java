package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeXFDFFormatter {

    public static final class CppProxy extends NativeXFDFFormatter {
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        private native void nativeDestroy(long j);

        public static native NativeXFDFImportResult parseXfdf(NativeDocument nativeDocument, int i, NativeDataProvider nativeDataProvider, NativeXFDFOptions nativeXFDFOptions);

        public static native NativeResult writeXfdf(NativeDocument nativeDocument, int i, ArrayList<NativeAnnotation> arrayList, ArrayList<NativeFormField> arrayList2, String str, NativeDataSink nativeDataSink, NativeXFDFOptions nativeXFDFOptions);

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

    public static NativeXFDFImportResult parseXfdf(NativeDocument nativeDocument, int i, NativeDataProvider nativeDataProvider, NativeXFDFOptions nativeXFDFOptions) {
        return CppProxy.parseXfdf(nativeDocument, i, nativeDataProvider, nativeXFDFOptions);
    }

    public static NativeResult writeXfdf(NativeDocument nativeDocument, int i, ArrayList<NativeAnnotation> arrayList, ArrayList<NativeFormField> arrayList2, String str, NativeDataSink nativeDataSink, NativeXFDFOptions nativeXFDFOptions) {
        return CppProxy.writeXfdf(nativeDocument, i, arrayList, arrayList2, str, nativeDataSink, nativeXFDFOptions);
    }
}
