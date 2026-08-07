package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeCacheFactory {

    public static final class CppProxy extends NativeCacheFactory {
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeFileCache createDiskFileCache(String str, long j, int i, NativeCacheFileOperations nativeCacheFileOperations);

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

    public static NativeFileCache createDiskFileCache(String str, long j, int i, NativeCacheFileOperations nativeCacheFileOperations) {
        return CppProxy.createDiskFileCache(str, j, i, nativeCacheFileOperations);
    }
}
