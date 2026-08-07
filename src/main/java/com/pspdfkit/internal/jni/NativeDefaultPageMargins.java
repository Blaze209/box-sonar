package com.pspdfkit.internal.jni;

import com.pspdfkit.utils.EdgeInsets;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDefaultPageMargins {

    public static final class CppProxy extends NativeDefaultPageMargins {
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        private native void nativeDestroy(long j);

        public static native EdgeInsets pageMarginsForBinding();

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

    public static EdgeInsets pageMarginsForBinding() {
        return CppProxy.pageMarginsForBinding();
    }
}
