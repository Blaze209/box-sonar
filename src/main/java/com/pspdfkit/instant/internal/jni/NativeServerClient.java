package com.pspdfkit.instant.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeServerClient {

    public static final class CppProxy extends NativeServerClient {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeServerClientResult create(String str, String str2, String str3, NativeHTTPClient nativeHTTPClient, String str4);

        public static native String getProtocolVersion();

        private native void nativeDestroy(long j);

        private native String native_getAppId(long j);

        private native String native_getDataPath(long j);

        private native NativeStringResult native_getDocumentCachePath(long j);

        private native NativeServerDocumentLayerResult native_getLayerForJwt(long j, NativeInstantJWT nativeInstantJWT);

        private native String native_getServerURL(long j);

        private native NativeServerDocumentListResult native_listLocalDocuments(long j);

        private native NativeInstantError native_purgeDocumentWithId(long j, String str);

        private native NativeInstantError native_removeLocalStorage(long j);

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

        @Override // com.pspdfkit.instant.internal.jni.NativeServerClient
        public String getAppId() {
            return native_getAppId(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerClient
        public String getDataPath() {
            return native_getDataPath(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerClient
        public NativeStringResult getDocumentCachePath() {
            return native_getDocumentCachePath(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerClient
        public NativeServerDocumentLayerResult getLayerForJwt(NativeInstantJWT nativeInstantJWT) {
            return native_getLayerForJwt(this.nativeRef, nativeInstantJWT);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerClient
        public String getServerURL() {
            return native_getServerURL(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerClient
        public NativeServerDocumentListResult listLocalDocuments() {
            return native_listLocalDocuments(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerClient
        public NativeInstantError purgeDocumentWithId(String str) {
            return native_purgeDocumentWithId(this.nativeRef, str);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeServerClient
        public NativeInstantError removeLocalStorage() {
            return native_removeLocalStorage(this.nativeRef);
        }
    }

    public static NativeServerClientResult create(String str, String str2, String str3, NativeHTTPClient nativeHTTPClient, String str4) {
        return CppProxy.create(str, str2, str3, nativeHTTPClient, str4);
    }

    public static String getProtocolVersion() {
        return CppProxy.getProtocolVersion();
    }

    public abstract String getAppId();

    public abstract String getDataPath();

    public abstract NativeStringResult getDocumentCachePath();

    public abstract NativeServerDocumentLayerResult getLayerForJwt(NativeInstantJWT nativeInstantJWT);

    public abstract String getServerURL();

    public abstract NativeServerDocumentListResult listLocalDocuments();

    public abstract NativeInstantError purgeDocumentWithId(String str);

    public abstract NativeInstantError removeLocalStorage();
}
