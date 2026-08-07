package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeStampAnnotationHelper {

    public static final class CppProxy extends NativeStampAnnotationHelper {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeStampAnnotationHelper create();

        private native void nativeDestroy(long j);

        private native String native_getPreferredIconName(long j, NativeStampType nativeStampType);

        private native NativeStampType native_getStampType(long j, String str);

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

        @Override // com.pspdfkit.internal.jni.NativeStampAnnotationHelper
        public String getPreferredIconName(NativeStampType nativeStampType) {
            return native_getPreferredIconName(this.nativeRef, nativeStampType);
        }

        @Override // com.pspdfkit.internal.jni.NativeStampAnnotationHelper
        public NativeStampType getStampType(String str) {
            return native_getStampType(this.nativeRef, str);
        }
    }

    public static NativeStampAnnotationHelper create() {
        return CppProxy.create();
    }

    public abstract String getPreferredIconName(NativeStampType nativeStampType);

    public abstract NativeStampType getStampType(String str);
}
