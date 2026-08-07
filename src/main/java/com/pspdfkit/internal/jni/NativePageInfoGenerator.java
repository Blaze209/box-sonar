package com.pspdfkit.internal.jni;

import android.graphics.RectF;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativePageInfoGenerator {

    public static final class CppProxy extends NativePageInfoGenerator {
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        private native void nativeDestroy(long j);

        public static native NativePageInfo pageInfoWithRotationOffset(NativePageInfo nativePageInfo, byte b);

        public static native NativePageInfo pageInfoWithUntransformedBbox(RectF rectF, byte b, byte b2, boolean z);

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

    public static NativePageInfo pageInfoWithRotationOffset(NativePageInfo nativePageInfo, byte b) {
        return CppProxy.pageInfoWithRotationOffset(nativePageInfo, b);
    }

    public static NativePageInfo pageInfoWithUntransformedBbox(RectF rectF, byte b, byte b2, boolean z) {
        return CppProxy.pageInfoWithUntransformedBbox(rectF, b, b2, z);
    }
}
