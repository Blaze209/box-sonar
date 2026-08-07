package com.pspdfkit.internal.jni;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativePrintConfiguration {

    public static final class CppProxy extends NativePrintConfiguration {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativePrintConfiguration create(NativeDocument nativeDocument);

        private native void nativeDestroy(long j);

        private native void native_setCache(long j, NativePageCache nativePageCache);

        private native void native_setDensity(long j, int i);

        private native void native_setMediaSize(long j, int i, int i2);

        private native void native_setMonochrome(long j, boolean z);

        private native void native_setPagesToPrint(long j, HashSet<Integer> hashSet);

        private native void native_setPreview(long j, boolean z);

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

        @Override // com.pspdfkit.internal.jni.NativePrintConfiguration
        public void setCache(NativePageCache nativePageCache) {
            native_setCache(this.nativeRef, nativePageCache);
        }

        @Override // com.pspdfkit.internal.jni.NativePrintConfiguration
        public void setDensity(int i) {
            native_setDensity(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativePrintConfiguration
        public void setMediaSize(int i, int i2) {
            native_setMediaSize(this.nativeRef, i, i2);
        }

        @Override // com.pspdfkit.internal.jni.NativePrintConfiguration
        public void setMonochrome(boolean z) {
            native_setMonochrome(this.nativeRef, z);
        }

        @Override // com.pspdfkit.internal.jni.NativePrintConfiguration
        public void setPagesToPrint(HashSet<Integer> hashSet) {
            native_setPagesToPrint(this.nativeRef, hashSet);
        }

        @Override // com.pspdfkit.internal.jni.NativePrintConfiguration
        public void setPreview(boolean z) {
            native_setPreview(this.nativeRef, z);
        }
    }

    public static NativePrintConfiguration create(NativeDocument nativeDocument) {
        return CppProxy.create(nativeDocument);
    }

    public abstract void setCache(NativePageCache nativePageCache);

    public abstract void setDensity(int i);

    public abstract void setMediaSize(int i, int i2);

    public abstract void setMonochrome(boolean z);

    public abstract void setPagesToPrint(HashSet<Integer> hashSet);

    public abstract void setPreview(boolean z);
}
