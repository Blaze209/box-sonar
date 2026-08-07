package com.pspdfkit.internal.jni;

import android.graphics.Bitmap;
import android.graphics.RectF;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeAnnotationRenderer {

    public static final class CppProxy extends NativeAnnotationRenderer {
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native boolean drawAnnotation(NativeAnnotation nativeAnnotation, Bitmap bitmap, int i, int i2, int i3, int i4, NativeAnnotationRenderingConfig nativeAnnotationRenderingConfig);

        public static native NativeResult drawAnnotationWithAppearanceStreamType(NativeAnnotation nativeAnnotation, Bitmap bitmap, int i, int i2, int i3, int i4, NativeAnnotationRenderingConfig nativeAnnotationRenderingConfig, NativeAppearanceStreamType nativeAppearanceStreamType);

        public static native boolean drawRawAPStream(NativeDataProvider nativeDataProvider, int i, RectF rectF, Bitmap bitmap, int i2, int i3, int i4, int i5, NativeAnnotationRenderingConfig nativeAnnotationRenderingConfig);

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

    public static boolean drawAnnotation(NativeAnnotation nativeAnnotation, Bitmap bitmap, int i, int i2, int i3, int i4, NativeAnnotationRenderingConfig nativeAnnotationRenderingConfig) {
        return CppProxy.drawAnnotation(nativeAnnotation, bitmap, i, i2, i3, i4, nativeAnnotationRenderingConfig);
    }

    public static NativeResult drawAnnotationWithAppearanceStreamType(NativeAnnotation nativeAnnotation, Bitmap bitmap, int i, int i2, int i3, int i4, NativeAnnotationRenderingConfig nativeAnnotationRenderingConfig, NativeAppearanceStreamType nativeAppearanceStreamType) {
        return CppProxy.drawAnnotationWithAppearanceStreamType(nativeAnnotation, bitmap, i, i2, i3, i4, nativeAnnotationRenderingConfig, nativeAppearanceStreamType);
    }

    public static boolean drawRawAPStream(NativeDataProvider nativeDataProvider, int i, RectF rectF, Bitmap bitmap, int i2, int i3, int i4, int i5, NativeAnnotationRenderingConfig nativeAnnotationRenderingConfig) {
        return CppProxy.drawRawAPStream(nativeDataProvider, i, rectF, bitmap, i2, i3, i4, i5, nativeAnnotationRenderingConfig);
    }
}
