package com.pspdfkit.internal.jni;

import android.graphics.RectF;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativePdfObjectsHitDetector {

    public static final class CppProxy extends NativePdfObjectsHitDetector {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativePdfObjectsHitDetector create();

        private native void nativeDestroy(long j);

        private native NativeAnnotationPager native_filterAndSortAnnotationsAtPdfRect(long j, NativeAnnotationPager nativeAnnotationPager, RectF rectF, NativeAnnotationHitDetectionOptions nativeAnnotationHitDetectionOptions);

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

        @Override // com.pspdfkit.internal.jni.NativePdfObjectsHitDetector
        public NativeAnnotationPager filterAndSortAnnotationsAtPdfRect(NativeAnnotationPager nativeAnnotationPager, RectF rectF, NativeAnnotationHitDetectionOptions nativeAnnotationHitDetectionOptions) {
            return native_filterAndSortAnnotationsAtPdfRect(this.nativeRef, nativeAnnotationPager, rectF, nativeAnnotationHitDetectionOptions);
        }
    }

    public static NativePdfObjectsHitDetector create() {
        return CppProxy.create();
    }

    public abstract NativeAnnotationPager filterAndSortAnnotationsAtPdfRect(NativeAnnotationPager nativeAnnotationPager, RectF rectF, NativeAnnotationHitDetectionOptions nativeAnnotationHitDetectionOptions);
}
