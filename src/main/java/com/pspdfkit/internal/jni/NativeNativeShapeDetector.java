package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeNativeShapeDetector {

    public static final class CppProxy extends NativeNativeShapeDetector {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeNativeShapeDetector createFromTemplatesData(byte[] bArr);

        private native void nativeDestroy(long j);

        private native NativeShapeDetectorResult native_detectShape(long j, NativePointsPager nativePointsPager);

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

        @Override // com.pspdfkit.internal.jni.NativeNativeShapeDetector
        public NativeShapeDetectorResult detectShape(NativePointsPager nativePointsPager) {
            return native_detectShape(this.nativeRef, nativePointsPager);
        }
    }

    public static NativeNativeShapeDetector createFromTemplatesData(byte[] bArr) {
        return CppProxy.createFromTemplatesData(bArr);
    }

    public abstract NativeShapeDetectorResult detectShape(NativePointsPager nativePointsPager);
}
