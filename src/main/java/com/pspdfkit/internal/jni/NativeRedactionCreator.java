package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeRedactionCreator {

    public static final class CppProxy extends NativeRedactionCreator {
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native ArrayList<Long> createRedactionsFromSearchResults(NativeDocument nativeDocument, NativeDocumentSearcherQuery nativeDocumentSearcherQuery, NativeRedactionPreset nativeRedactionPreset);

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

    public static ArrayList<Long> createRedactionsFromSearchResults(NativeDocument nativeDocument, NativeDocumentSearcherQuery nativeDocumentSearcherQuery, NativeRedactionPreset nativeRedactionPreset) {
        return CppProxy.createRedactionsFromSearchResults(nativeDocument, nativeDocumentSearcherQuery, nativeRedactionPreset);
    }
}
