package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeCertificateRevocationManager {

    public static final class CppProxy extends NativeCertificateRevocationManager {
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native ArrayList<String> generateHttpRevocationRequests(NativeDocumentProvider nativeDocumentProvider, NativeKeyStore nativeKeyStore, ArrayList<NativeX509Certificate> arrayList);

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

    public static ArrayList<String> generateHttpRevocationRequests(NativeDocumentProvider nativeDocumentProvider, NativeKeyStore nativeKeyStore, ArrayList<NativeX509Certificate> arrayList) {
        return CppProxy.generateHttpRevocationRequests(nativeDocumentProvider, nativeKeyStore, arrayList);
    }
}
