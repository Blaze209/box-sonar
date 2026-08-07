package com.pspdfkit.internal.jni;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativePointsPager {

    public static final class CppProxy extends NativePointsPager {
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

        private native ArrayList<PointF> native_get(long j, int i, int i2);

        private native int native_size(long j);

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

        @Override // com.pspdfkit.internal.jni.NativePointsPager
        public ArrayList<PointF> get(int i, int i2) {
            return native_get(this.nativeRef, i, i2);
        }

        @Override // com.pspdfkit.internal.jni.NativePointsPager
        public int size() {
            return native_size(this.nativeRef);
        }
    }

    public abstract ArrayList<PointF> get(int i, int i2);

    public abstract int size();
}
