package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeSpanView {

    public static final class CppProxy extends NativeSpanView {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeSpanView createSpanView(byte[] bArr, long j);

        private native void nativeDestroy(long j);

        private native byte[] native_getBinary(long j);

        private native long native_getSize(long j);

        private native byte[] native_getSpanView(long j);

        private native boolean native_isEmpty(long j);

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

        @Override // com.pspdfkit.internal.jni.NativeSpanView
        public byte[] getBinary() {
            return native_getBinary(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSpanView
        public long getSize() {
            return native_getSize(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSpanView
        public byte[] getSpanView() {
            return native_getSpanView(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSpanView
        public boolean isEmpty() {
            return native_isEmpty(this.nativeRef);
        }
    }

    public static NativeSpanView createSpanView(byte[] bArr, long j) {
        return CppProxy.createSpanView(bArr, j);
    }

    public abstract byte[] getBinary();

    public abstract long getSize();

    public abstract byte[] getSpanView();

    public abstract boolean isEmpty();
}
