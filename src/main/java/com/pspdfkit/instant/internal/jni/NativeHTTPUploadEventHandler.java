package com.pspdfkit.instant.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeHTTPUploadEventHandler {

    public static final class CppProxy extends NativeHTTPUploadEventHandler {
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

        private native void native_onFailure(long j, NativeHTTPRequest nativeHTTPRequest, NativeHTTPError nativeHTTPError, String str, NativeHTTPResponse nativeHTTPResponse);

        private native void native_onProgress(long j, NativeHTTPRequest nativeHTTPRequest, long j2);

        private native void native_onResponse(long j, NativeHTTPRequest nativeHTTPRequest, NativeHTTPResponse nativeHTTPResponse);

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

        @Override // com.pspdfkit.instant.internal.jni.NativeHTTPUploadEventHandler
        public void onFailure(NativeHTTPRequest nativeHTTPRequest, NativeHTTPError nativeHTTPError, String str, NativeHTTPResponse nativeHTTPResponse) {
            native_onFailure(this.nativeRef, nativeHTTPRequest, nativeHTTPError, str, nativeHTTPResponse);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeHTTPUploadEventHandler
        public void onProgress(NativeHTTPRequest nativeHTTPRequest, long j) {
            native_onProgress(this.nativeRef, nativeHTTPRequest, j);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeHTTPUploadEventHandler
        public void onResponse(NativeHTTPRequest nativeHTTPRequest, NativeHTTPResponse nativeHTTPResponse) {
            native_onResponse(this.nativeRef, nativeHTTPRequest, nativeHTTPResponse);
        }
    }

    public abstract void onFailure(NativeHTTPRequest nativeHTTPRequest, NativeHTTPError nativeHTTPError, String str, NativeHTTPResponse nativeHTTPResponse);

    public abstract void onProgress(NativeHTTPRequest nativeHTTPRequest, long j);

    public abstract void onResponse(NativeHTTPRequest nativeHTTPRequest, NativeHTTPResponse nativeHTTPResponse);
}
