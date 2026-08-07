package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeAnnotationListResult {

    public static final class CppProxy extends NativeAnnotationListResult {
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

        private native NativeDjinniError native_error(long j);

        private native boolean native_hasError(long j);

        private native ArrayList<NativeAnnotation> native_value(long j);

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

        @Override // com.pspdfkit.internal.jni.NativeAnnotationListResult
        public NativeDjinniError error() {
            return native_error(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotationListResult
        public boolean hasError() {
            return native_hasError(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeAnnotationListResult
        public ArrayList<NativeAnnotation> value() {
            return native_value(this.nativeRef);
        }
    }

    public abstract NativeDjinniError error();

    public abstract boolean hasError();

    public abstract ArrayList<NativeAnnotation> value();
}
