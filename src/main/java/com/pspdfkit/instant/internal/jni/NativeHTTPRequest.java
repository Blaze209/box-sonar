package com.pspdfkit.instant.internal.jni;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeHTTPRequest {

    public static final class CppProxy extends NativeHTTPRequest {
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

        private native void native_cancel(long j);

        private native byte[] native_getBodyData(long j);

        private native NativeHTTPDownloadEventHandler native_getDownloadEventHandler(long j);

        private native String native_getFilePath(long j);

        private native HashMap<String, String> native_getHeaders(long j);

        private native NativeHTTPRequestState native_getRequestState(long j);

        private native NativeHTTPUploadEventHandler native_getUploadEventHandler(long j);

        private native String native_getUri(long j);

        private native NativeHTTPResponse native_stallThisThread(long j);

        private native boolean native_start(long j);

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

        @Override // com.pspdfkit.instant.internal.jni.NativeHTTPRequest
        public void cancel() {
            native_cancel(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeHTTPRequest
        public byte[] getBodyData() {
            return native_getBodyData(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeHTTPRequest
        public NativeHTTPDownloadEventHandler getDownloadEventHandler() {
            return native_getDownloadEventHandler(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeHTTPRequest
        public String getFilePath() {
            return native_getFilePath(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeHTTPRequest
        public HashMap<String, String> getHeaders() {
            return native_getHeaders(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeHTTPRequest
        public NativeHTTPRequestState getRequestState() {
            return native_getRequestState(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeHTTPRequest
        public NativeHTTPUploadEventHandler getUploadEventHandler() {
            return native_getUploadEventHandler(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeHTTPRequest
        public String getUri() {
            return native_getUri(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeHTTPRequest
        public NativeHTTPResponse stallThisThread() {
            return native_stallThisThread(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeHTTPRequest
        public boolean start() {
            return native_start(this.nativeRef);
        }
    }

    public abstract void cancel();

    public abstract byte[] getBodyData();

    public abstract NativeHTTPDownloadEventHandler getDownloadEventHandler();

    public abstract String getFilePath();

    public abstract HashMap<String, String> getHeaders();

    public abstract NativeHTTPRequestState getRequestState();

    public abstract NativeHTTPUploadEventHandler getUploadEventHandler();

    public abstract String getUri();

    public abstract NativeHTTPResponse stallThisThread();

    public abstract boolean start();
}
