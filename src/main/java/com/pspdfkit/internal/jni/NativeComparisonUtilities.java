package com.pspdfkit.internal.jni;

import android.graphics.Matrix;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeComparisonUtilities {

    public static final class CppProxy extends NativeComparisonUtilities {
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native Matrix calculateMatrixFromPoints(ArrayList<PointF> arrayList);

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

    public static Matrix calculateMatrixFromPoints(ArrayList<PointF> arrayList) {
        return CppProxy.calculateMatrixFromPoints(arrayList);
    }
}
