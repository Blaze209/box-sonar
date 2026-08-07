package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativePublicKey {

    public static final class CppProxy extends NativePublicKey {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativePublicKey createFromRawPublicKey(String str);

        private native void nativeDestroy(long j);

        private native int native_keyLength(long j);

        private native String native_publicKeyScheme(long j);

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

        @Override // com.pspdfkit.internal.jni.NativePublicKey
        public int keyLength() {
            return native_keyLength(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativePublicKey
        public String publicKeyScheme() {
            return native_publicKeyScheme(this.nativeRef);
        }
    }

    public static NativePublicKey createFromRawPublicKey(String str) {
        return CppProxy.createFromRawPublicKey(str);
    }

    public abstract int keyLength();

    public abstract String publicKeyScheme();
}
