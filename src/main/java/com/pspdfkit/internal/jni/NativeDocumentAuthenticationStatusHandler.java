package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDocumentAuthenticationStatusHandler {

    public static final class CppProxy extends NativeDocumentAuthenticationStatusHandler {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeDocumentAuthenticationStatusHandler create(NativeDocumentProvider nativeDocumentProvider);

        private native void nativeDestroy(long j);

        private native boolean native_checkPassword(long j, String str, NativePasswordType nativePasswordType);

        private native String native_getPassword(long j);

        private native String native_getUserPassword(long j, String str);

        private native boolean native_isUnlockedWithFullAccess(long j);

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

        @Override // com.pspdfkit.internal.jni.NativeDocumentAuthenticationStatusHandler
        public boolean checkPassword(String str, NativePasswordType nativePasswordType) {
            return native_checkPassword(this.nativeRef, str, nativePasswordType);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentAuthenticationStatusHandler
        public String getPassword() {
            return native_getPassword(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentAuthenticationStatusHandler
        public String getUserPassword(String str) {
            return native_getUserPassword(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentAuthenticationStatusHandler
        public boolean isUnlockedWithFullAccess() {
            return native_isUnlockedWithFullAccess(this.nativeRef);
        }
    }

    public static NativeDocumentAuthenticationStatusHandler create(NativeDocumentProvider nativeDocumentProvider) {
        return CppProxy.create(nativeDocumentProvider);
    }

    public abstract boolean checkPassword(String str, NativePasswordType nativePasswordType);

    public abstract String getPassword();

    public abstract String getUserPassword(String str);

    public abstract boolean isUnlockedWithFullAccess();
}
