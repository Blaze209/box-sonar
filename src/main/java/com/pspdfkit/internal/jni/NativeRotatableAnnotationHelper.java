package com.pspdfkit.internal.jni;

import android.graphics.RectF;
import com.pspdfkit.utils.Size;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeRotatableAnnotationHelper {

    public static final class CppProxy extends NativeRotatableAnnotationHelper {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeRotatableAnnotationHelper create();

        private native void nativeDestroy(long j);

        private native Size native_getContentSizeForRotation(long j, int i, RectF rectF, RectF rectF2, boolean z);

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

        @Override // com.pspdfkit.internal.jni.NativeRotatableAnnotationHelper
        public Size getContentSizeForRotation(int i, RectF rectF, RectF rectF2, boolean z) {
            return native_getContentSizeForRotation(this.nativeRef, i, rectF, rectF2, z);
        }
    }

    public static NativeRotatableAnnotationHelper create() {
        return CppProxy.create();
    }

    public abstract Size getContentSizeForRotation(int i, RectF rectF, RectF rectF2, boolean z);
}
