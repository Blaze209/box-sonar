package com.pspdfkit.internal.jni;

import android.graphics.Bitmap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativePageCache {

    public static final class CppProxy extends NativePageCache {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativePageCache create(int i);

        private native void nativeDestroy(long j);

        private native void native_clear(long j);

        private native boolean native_get(long j, Bitmap bitmap, String str, NativePageRenderingConfig nativePageRenderingConfig);

        private native void native_remove(long j, String str);

        private native void native_setSize(long j, int i);

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

        @Override // com.pspdfkit.internal.jni.NativePageCache
        public void clear() {
            native_clear(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativePageCache
        public boolean get(Bitmap bitmap, String str, NativePageRenderingConfig nativePageRenderingConfig) {
            return native_get(this.nativeRef, bitmap, str, nativePageRenderingConfig);
        }

        @Override // com.pspdfkit.internal.jni.NativePageCache
        public void remove(String str) {
            native_remove(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativePageCache
        public void setSize(int i) {
            native_setSize(this.nativeRef, i);
        }
    }

    public static NativePageCache create(int i) {
        return CppProxy.create(i);
    }

    public abstract void clear();

    public abstract boolean get(Bitmap bitmap, String str, NativePageRenderingConfig nativePageRenderingConfig);

    public abstract void remove(String str);

    public abstract void setSize(int i);
}
