package com.pspdfkit.instant.internal.jni;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeHTTPClient {

    public static final class CppProxy extends NativeHTTPClient {
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

        private native NativeHTTPRequest native_DELETEWithData(long j, byte[] bArr, String str, NativeHTTPUploadEventHandler nativeHTTPUploadEventHandler, HashMap<String, String> map);

        private native NativeHTTPRequest native_GET(long j, String str, NativeHTTPDownloadEventHandler nativeHTTPDownloadEventHandler, HashMap<String, String> map);

        private native NativeHTTPRequest native_POSTData(long j, byte[] bArr, String str, NativeHTTPUploadEventHandler nativeHTTPUploadEventHandler, NativeHTTPDownloadEventHandler nativeHTTPDownloadEventHandler, HashMap<String, String> map);

        private native NativeHTTPRequest native_POSTFile(long j, String str, String str2, NativeHTTPUploadEventHandler nativeHTTPUploadEventHandler, NativeHTTPDownloadEventHandler nativeHTTPDownloadEventHandler, HashMap<String, String> map);

        private native NativeHTTPRequest native_PUTData(long j, byte[] bArr, String str, NativeHTTPUploadEventHandler nativeHTTPUploadEventHandler, HashMap<String, String> map);

        private native NativeHTTPRequest native_PUTFile(long j, String str, String str2, NativeHTTPUploadEventHandler nativeHTTPUploadEventHandler, HashMap<String, String> map);

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

        @Override // com.pspdfkit.instant.internal.jni.NativeHTTPClient
        public NativeHTTPRequest DELETEWithData(byte[] bArr, String str, NativeHTTPUploadEventHandler nativeHTTPUploadEventHandler, HashMap<String, String> map) {
            return native_DELETEWithData(this.nativeRef, bArr, str, nativeHTTPUploadEventHandler, map);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeHTTPClient
        public NativeHTTPRequest GET(String str, NativeHTTPDownloadEventHandler nativeHTTPDownloadEventHandler, HashMap<String, String> map) {
            return native_GET(this.nativeRef, str, nativeHTTPDownloadEventHandler, map);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeHTTPClient
        public NativeHTTPRequest POSTData(byte[] bArr, String str, NativeHTTPUploadEventHandler nativeHTTPUploadEventHandler, NativeHTTPDownloadEventHandler nativeHTTPDownloadEventHandler, HashMap<String, String> map) {
            return native_POSTData(this.nativeRef, bArr, str, nativeHTTPUploadEventHandler, nativeHTTPDownloadEventHandler, map);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeHTTPClient
        public NativeHTTPRequest POSTFile(String str, String str2, NativeHTTPUploadEventHandler nativeHTTPUploadEventHandler, NativeHTTPDownloadEventHandler nativeHTTPDownloadEventHandler, HashMap<String, String> map) {
            return native_POSTFile(this.nativeRef, str, str2, nativeHTTPUploadEventHandler, nativeHTTPDownloadEventHandler, map);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeHTTPClient
        public NativeHTTPRequest PUTData(byte[] bArr, String str, NativeHTTPUploadEventHandler nativeHTTPUploadEventHandler, HashMap<String, String> map) {
            return native_PUTData(this.nativeRef, bArr, str, nativeHTTPUploadEventHandler, map);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeHTTPClient
        public NativeHTTPRequest PUTFile(String str, String str2, NativeHTTPUploadEventHandler nativeHTTPUploadEventHandler, HashMap<String, String> map) {
            return native_PUTFile(this.nativeRef, str, str2, nativeHTTPUploadEventHandler, map);
        }
    }

    public abstract NativeHTTPRequest DELETEWithData(byte[] bArr, String str, NativeHTTPUploadEventHandler nativeHTTPUploadEventHandler, HashMap<String, String> map);

    public abstract NativeHTTPRequest GET(String str, NativeHTTPDownloadEventHandler nativeHTTPDownloadEventHandler, HashMap<String, String> map);

    public abstract NativeHTTPRequest POSTData(byte[] bArr, String str, NativeHTTPUploadEventHandler nativeHTTPUploadEventHandler, NativeHTTPDownloadEventHandler nativeHTTPDownloadEventHandler, HashMap<String, String> map);

    public abstract NativeHTTPRequest POSTFile(String str, String str2, NativeHTTPUploadEventHandler nativeHTTPUploadEventHandler, NativeHTTPDownloadEventHandler nativeHTTPDownloadEventHandler, HashMap<String, String> map);

    public abstract NativeHTTPRequest PUTData(byte[] bArr, String str, NativeHTTPUploadEventHandler nativeHTTPUploadEventHandler, HashMap<String, String> map);

    public abstract NativeHTTPRequest PUTFile(String str, String str2, NativeHTTPUploadEventHandler nativeHTTPUploadEventHandler, HashMap<String, String> map);
}
