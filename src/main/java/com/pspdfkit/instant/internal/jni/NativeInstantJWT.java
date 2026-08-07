package com.pspdfkit.instant.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeInstantJWT {

    public static final class CppProxy extends NativeInstantJWT {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native String canonicalize(String str, String str2, boolean z);

        public static native String defaultLayerName();

        private native void nativeDestroy(long j);

        private native String native_canonicalName(long j, boolean z);

        private native String native_creatorName(long j);

        private native String native_documentId(long j);

        private native String native_layerName(long j);

        private native String native_rawValue(long j);

        private native String native_userId(long j);

        public static native NativeInstantJWTResult parse(String str);

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

        @Override // com.pspdfkit.instant.internal.jni.NativeInstantJWT
        public String canonicalName(boolean z) {
            return native_canonicalName(this.nativeRef, z);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeInstantJWT
        public String creatorName() {
            return native_creatorName(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeInstantJWT
        public String documentId() {
            return native_documentId(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeInstantJWT
        public String layerName() {
            return native_layerName(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeInstantJWT
        public String rawValue() {
            return native_rawValue(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeInstantJWT
        public String userId() {
            return native_userId(this.nativeRef);
        }
    }

    public static String canonicalize(String str, String str2, boolean z) {
        return CppProxy.canonicalize(str, str2, z);
    }

    public static String defaultLayerName() {
        return CppProxy.defaultLayerName();
    }

    public static NativeInstantJWTResult parse(String str) {
        return CppProxy.parse(str);
    }

    public abstract String canonicalName(boolean z);

    public abstract String creatorName();

    public abstract String documentId();

    public abstract String layerName();

    public abstract String rawValue();

    public abstract String userId();
}
