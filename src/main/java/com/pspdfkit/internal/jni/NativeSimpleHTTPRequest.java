package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeSimpleHTTPRequest {

    public static final class CppProxy extends NativeSimpleHTTPRequest {
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

        private native NativeSimpleHTTPResponse native_sendData(long j, NativeHTTPMethod nativeHTTPMethod, String str, byte[] bArr);

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

        @Override // com.pspdfkit.internal.jni.NativeSimpleHTTPRequest
        public NativeSimpleHTTPResponse sendData(NativeHTTPMethod nativeHTTPMethod, String str, byte[] bArr) {
            return native_sendData(this.nativeRef, nativeHTTPMethod, str, bArr);
        }
    }

    public abstract NativeSimpleHTTPResponse sendData(NativeHTTPMethod nativeHTTPMethod, String str, byte[] bArr);
}
