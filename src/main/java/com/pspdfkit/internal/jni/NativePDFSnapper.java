package com.pspdfkit.internal.jni;

import android.graphics.PointF;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativePDFSnapper {

    public static final class CppProxy extends NativePDFSnapper {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativePDFSnapper create(NativePage nativePage);

        public static native NativePDFSnapper createWithConfiguration(NativePage nativePage, NativeSnapperConfiguration nativeSnapperConfiguration);

        private native void nativeDestroy(long j);

        private native NativeSnapperConfiguration native_getConfiguration(long j);

        private native void native_setConfiguration(long j, NativeSnapperConfiguration nativeSnapperConfiguration);

        private native NativeSnapResult native_snap(long j, PointF pointF);

        private native NativeSnapResult native_trySnapNonBlocking(long j, PointF pointF);

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

        @Override // com.pspdfkit.internal.jni.NativePDFSnapper
        public NativeSnapperConfiguration getConfiguration() {
            return native_getConfiguration(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativePDFSnapper
        public void setConfiguration(NativeSnapperConfiguration nativeSnapperConfiguration) {
            native_setConfiguration(this.nativeRef, nativeSnapperConfiguration);
        }

        @Override // com.pspdfkit.internal.jni.NativePDFSnapper
        public NativeSnapResult snap(PointF pointF) {
            return native_snap(this.nativeRef, pointF);
        }

        @Override // com.pspdfkit.internal.jni.NativePDFSnapper
        public NativeSnapResult trySnapNonBlocking(PointF pointF) {
            return native_trySnapNonBlocking(this.nativeRef, pointF);
        }
    }

    public static NativePDFSnapper create(NativePage nativePage) {
        return CppProxy.create(nativePage);
    }

    public static NativePDFSnapper createWithConfiguration(NativePage nativePage, NativeSnapperConfiguration nativeSnapperConfiguration) {
        return CppProxy.createWithConfiguration(nativePage, nativeSnapperConfiguration);
    }

    public abstract NativeSnapperConfiguration getConfiguration();

    public abstract void setConfiguration(NativeSnapperConfiguration nativeSnapperConfiguration);

    public abstract NativeSnapResult snap(PointF pointF);

    public abstract NativeSnapResult trySnapNonBlocking(PointF pointF);
}
