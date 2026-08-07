package com.pspdfkit.internal.jni;

import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeTimestampInformation {

    public static final class CppProxy extends NativeTimestampInformation {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeTimestampInformation create(NativeX509Certificate nativeX509Certificate, Date date);

        private native void nativeDestroy(long j);

        private native NativeX509Certificate native_getSigningCertificate(long j);

        private native Date native_getTrustedDate(long j);

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

        @Override // com.pspdfkit.internal.jni.NativeTimestampInformation
        public NativeX509Certificate getSigningCertificate() {
            return native_getSigningCertificate(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeTimestampInformation
        public Date getTrustedDate() {
            return native_getTrustedDate(this.nativeRef);
        }
    }

    public static NativeTimestampInformation create(NativeX509Certificate nativeX509Certificate, Date date) {
        return CppProxy.create(nativeX509Certificate, date);
    }

    public abstract NativeX509Certificate getSigningCertificate();

    public abstract Date getTrustedDate();
}
