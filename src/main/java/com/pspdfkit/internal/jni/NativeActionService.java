package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeActionService {

    public static final class CppProxy extends NativeActionService {
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native byte[] getFlatbufferAdditionalActionsFormField(NativeFormField nativeFormField);

        public static native byte[] getFlatbufferPageActions(NativeDocumentProvider nativeDocumentProvider, int i);

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

    public static byte[] getFlatbufferAdditionalActionsFormField(NativeFormField nativeFormField) {
        return CppProxy.getFlatbufferAdditionalActionsFormField(nativeFormField);
    }

    public static byte[] getFlatbufferPageActions(NativeDocumentProvider nativeDocumentProvider, int i) {
        return CppProxy.getFlatbufferPageActions(nativeDocumentProvider, i);
    }
}
