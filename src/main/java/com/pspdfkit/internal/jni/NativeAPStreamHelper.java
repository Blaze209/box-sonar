package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeAPStreamHelper {

    public static final class CppProxy extends NativeAPStreamHelper {
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeResult exportAPStream(NativeAnnotation nativeAnnotation, NativeDataSink nativeDataSink, boolean z);

        public static native NativeResult importAPStream(NativeAnnotation nativeAnnotation, NativeDataProvider nativeDataProvider, boolean z, String str);

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

    public static NativeResult exportAPStream(NativeAnnotation nativeAnnotation, NativeDataSink nativeDataSink, boolean z) {
        return CppProxy.exportAPStream(nativeAnnotation, nativeDataSink, z);
    }

    public static NativeResult importAPStream(NativeAnnotation nativeAnnotation, NativeDataProvider nativeDataProvider, boolean z, String str) {
        return CppProxy.importAPStream(nativeAnnotation, nativeDataProvider, z, str);
    }
}
