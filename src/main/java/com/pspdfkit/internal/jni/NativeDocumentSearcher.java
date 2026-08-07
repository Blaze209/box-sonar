package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDocumentSearcher {

    public static final class CppProxy extends NativeDocumentSearcher {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeDocumentSearcher create();

        private native void nativeDestroy(long j);

        private native void native_cancelSearches(long j);

        private native void native_searchDocument(long j, NativeDocument nativeDocument, NativeDocumentSearcherQuery nativeDocumentSearcherQuery, NativeDocumentSearcherQueryResultHandler nativeDocumentSearcherQueryResultHandler);

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

        @Override // com.pspdfkit.internal.jni.NativeDocumentSearcher
        public void cancelSearches() {
            native_cancelSearches(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentSearcher
        public void searchDocument(NativeDocument nativeDocument, NativeDocumentSearcherQuery nativeDocumentSearcherQuery, NativeDocumentSearcherQueryResultHandler nativeDocumentSearcherQueryResultHandler) {
            native_searchDocument(this.nativeRef, nativeDocument, nativeDocumentSearcherQuery, nativeDocumentSearcherQueryResultHandler);
        }
    }

    public static NativeDocumentSearcher create() {
        return CppProxy.create();
    }

    public abstract void cancelSearches();

    public abstract void searchDocument(NativeDocument nativeDocument, NativeDocumentSearcherQuery nativeDocumentSearcherQuery, NativeDocumentSearcherQueryResultHandler nativeDocumentSearcherQueryResultHandler);
}
