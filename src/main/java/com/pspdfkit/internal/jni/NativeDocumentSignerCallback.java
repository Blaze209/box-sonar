package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDocumentSignerCallback {

    public static final class CppProxy extends NativeDocumentSignerCallback {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        private native void nativeDestroy(long j);

        private native void native_complete(long j, NativeDocumentSignerStatus nativeDocumentSignerStatus, NativeDataSink nativeDataSink, String str, ArrayList<Long> arrayList);

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

        @Override // com.pspdfkit.internal.jni.NativeDocumentSignerCallback
        public void complete(NativeDocumentSignerStatus nativeDocumentSignerStatus, NativeDataSink nativeDataSink, String str, ArrayList<Long> arrayList) {
            native_complete(this.nativeRef, nativeDocumentSignerStatus, nativeDataSink, str, arrayList);
        }
    }

    public abstract void complete(NativeDocumentSignerStatus nativeDocumentSignerStatus, NativeDataSink nativeDataSink, String str, ArrayList<Long> arrayList);
}
