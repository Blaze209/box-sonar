package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDocumentValidator {

    public static final class CppProxy extends NativeDocumentValidator {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeDocumentValidator create(NativeDocument nativeDocument);

        private native void nativeDestroy(long j);

        private native boolean native_validate(long j);

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

        @Override // com.pspdfkit.internal.jni.NativeDocumentValidator
        public boolean validate() {
            return native_validate(this.nativeRef);
        }
    }

    public static NativeDocumentValidator create(NativeDocument nativeDocument) {
        return CppProxy.create(nativeDocument);
    }

    public abstract boolean validate();
}
