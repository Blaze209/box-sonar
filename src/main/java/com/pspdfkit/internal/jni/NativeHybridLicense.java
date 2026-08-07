package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeHybridLicense {

    public static final class CppProxy extends NativeHybridLicense {
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native String androidHybridIdToString(NativeAndroidHybridId nativeAndroidHybridId);

        public static native String iOSHybridIdToString(NativeIOSHybridId nativeIOSHybridId);

        private native void nativeDestroy(long j);

        public static native NativeAndroidHybridId stringToAndroidHybridId(String str);

        public static native NativeIOSHybridId stringToIOSHybridId(String str);

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

    public static String androidHybridIdToString(NativeAndroidHybridId nativeAndroidHybridId) {
        return CppProxy.androidHybridIdToString(nativeAndroidHybridId);
    }

    public static String iOSHybridIdToString(NativeIOSHybridId nativeIOSHybridId) {
        return CppProxy.iOSHybridIdToString(nativeIOSHybridId);
    }

    public static NativeAndroidHybridId stringToAndroidHybridId(String str) {
        return CppProxy.stringToAndroidHybridId(str);
    }

    public static NativeIOSHybridId stringToIOSHybridId(String str) {
        return CppProxy.stringToIOSHybridId(str);
    }
}
