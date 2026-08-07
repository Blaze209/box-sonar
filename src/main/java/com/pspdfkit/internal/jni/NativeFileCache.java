package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeFileCache {

    public static final class CppProxy extends NativeFileCache {
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

        private native NativeResult native_clear(long j);

        private native long native_currentCacheSize(long j);

        private native NativeCacheFileRetrieveResult native_get(long j, String str);

        private native boolean native_hasEntry(long j, String str);

        private native long native_maxCacheSize(long j);

        private native NativeResult native_put(long j, String str, String str2, NativeCacheFilePutOptions nativeCacheFilePutOptions);

        private native NativeResult native_remove(long j, String str);

        private native void native_setMaxCacheSize(long j, long j2);

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

        @Override // com.pspdfkit.internal.jni.NativeFileCache
        public NativeResult clear() {
            return native_clear(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFileCache
        public long currentCacheSize() {
            return native_currentCacheSize(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFileCache
        public NativeCacheFileRetrieveResult get(String str) {
            return native_get(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeFileCache
        public boolean hasEntry(String str) {
            return native_hasEntry(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeFileCache
        public long maxCacheSize() {
            return native_maxCacheSize(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeFileCache
        public NativeResult put(String str, String str2, NativeCacheFilePutOptions nativeCacheFilePutOptions) {
            return native_put(this.nativeRef, str, str2, nativeCacheFilePutOptions);
        }

        @Override // com.pspdfkit.internal.jni.NativeFileCache
        public NativeResult remove(String str) {
            return native_remove(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeFileCache
        public void setMaxCacheSize(long j) {
            native_setMaxCacheSize(this.nativeRef, j);
        }
    }

    public abstract NativeResult clear();

    public abstract long currentCacheSize();

    public abstract NativeCacheFileRetrieveResult get(String str);

    public abstract boolean hasEntry(String str);

    public abstract long maxCacheSize();

    public abstract NativeResult put(String str, String str2, NativeCacheFilePutOptions nativeCacheFilePutOptions);

    public abstract NativeResult remove(String str);

    public abstract void setMaxCacheSize(long j);
}
