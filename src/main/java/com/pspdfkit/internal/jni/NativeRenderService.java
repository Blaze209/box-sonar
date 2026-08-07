package com.pspdfkit.internal.jni;

import android.graphics.Bitmap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeRenderService {

    public static final class CppProxy extends NativeRenderService {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeRenderService create(NativeDocument nativeDocument);

        private native void nativeDestroy(long j);

        private native NativePageComplexityOrError native_getPageComplexity(long j, int i);

        private native NativeProgressiveRenderSessionOrError native_startProgressiveRender(long j, NativeProgressiveRenderConfig nativeProgressiveRenderConfig, Bitmap bitmap);

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

        @Override // com.pspdfkit.internal.jni.NativeRenderService
        public NativePageComplexityOrError getPageComplexity(int i) {
            return native_getPageComplexity(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeRenderService
        public NativeProgressiveRenderSessionOrError startProgressiveRender(NativeProgressiveRenderConfig nativeProgressiveRenderConfig, Bitmap bitmap) {
            return native_startProgressiveRender(this.nativeRef, nativeProgressiveRenderConfig, bitmap);
        }
    }

    public static NativeRenderService create(NativeDocument nativeDocument) {
        return CppProxy.create(nativeDocument);
    }

    public abstract NativePageComplexityOrError getPageComplexity(int i);

    public abstract NativeProgressiveRenderSessionOrError startProgressiveRender(NativeProgressiveRenderConfig nativeProgressiveRenderConfig, Bitmap bitmap);
}
