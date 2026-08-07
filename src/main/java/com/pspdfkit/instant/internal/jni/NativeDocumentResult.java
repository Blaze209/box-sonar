package com.pspdfkit.instant.internal.jni;

import com.pspdfkit.internal.jni.NativeDocumentOpenResult;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDocumentResult {

    public static final class CppProxy extends NativeDocumentResult {
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

        private native NativeInstantError native_error(long j);

        private native boolean native_isError(long j);

        private native NativeDocumentOpenResult native_toPdfcResult(long j);

        private native NativeLayerDocumentContainer native_value(long j);

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

        @Override // com.pspdfkit.instant.internal.jni.NativeDocumentResult
        public NativeInstantError error() {
            return native_error(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeDocumentResult
        public boolean isError() {
            return native_isError(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeDocumentResult
        public NativeDocumentOpenResult toPdfcResult() {
            return native_toPdfcResult(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeDocumentResult
        public NativeLayerDocumentContainer value() {
            return native_value(this.nativeRef);
        }
    }

    public abstract NativeInstantError error();

    public abstract boolean isError();

    public abstract NativeDocumentOpenResult toPdfcResult();

    public abstract NativeLayerDocumentContainer value();
}
