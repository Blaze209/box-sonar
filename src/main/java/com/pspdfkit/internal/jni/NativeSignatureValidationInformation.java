package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeSignatureValidationInformation {

    public static final class CppProxy extends NativeSignatureValidationInformation {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeSignatureValidationInformation create(NativeDigitalSignatureType nativeDigitalSignatureType, NativePAdESSignatureLevel nativePAdESSignatureLevel, NativeX509Certificate nativeX509Certificate, NativeCertificateChainValidationStatus nativeCertificateChainValidationStatus, NativeTimestampInformation nativeTimestampInformation, NativeEncryptionAlgorithm nativeEncryptionAlgorithm, NativeHashAlgorithm nativeHashAlgorithm, boolean z);

        private native void nativeDestroy(long j);

        private native NativeCertificateChainValidationStatus native_getCertificateChainValidationStatus(long j);

        private native NativeHashAlgorithm native_getHashAlgorithm(long j);

        private native NativePAdESSignatureLevel native_getPadesSignatureLevel(long j);

        private native NativeEncryptionAlgorithm native_getSignatureAlgorithm(long j);

        private native NativeDigitalSignatureType native_getSignatureType(long j);

        private native NativeX509Certificate native_getSigningCertificate(long j);

        private native NativeTimestampInformation native_getTimestampStatus(long j);

        private native boolean native_isLtv(long j);

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

        @Override // com.pspdfkit.internal.jni.NativeSignatureValidationInformation
        public NativeCertificateChainValidationStatus getCertificateChainValidationStatus() {
            return native_getCertificateChainValidationStatus(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureValidationInformation
        public NativeHashAlgorithm getHashAlgorithm() {
            return native_getHashAlgorithm(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureValidationInformation
        public NativePAdESSignatureLevel getPadesSignatureLevel() {
            return native_getPadesSignatureLevel(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureValidationInformation
        public NativeEncryptionAlgorithm getSignatureAlgorithm() {
            return native_getSignatureAlgorithm(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureValidationInformation
        public NativeDigitalSignatureType getSignatureType() {
            return native_getSignatureType(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureValidationInformation
        public NativeX509Certificate getSigningCertificate() {
            return native_getSigningCertificate(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureValidationInformation
        public NativeTimestampInformation getTimestampStatus() {
            return native_getTimestampStatus(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureValidationInformation
        public boolean isLtv() {
            return native_isLtv(this.nativeRef);
        }
    }

    public static NativeSignatureValidationInformation create(NativeDigitalSignatureType nativeDigitalSignatureType, NativePAdESSignatureLevel nativePAdESSignatureLevel, NativeX509Certificate nativeX509Certificate, NativeCertificateChainValidationStatus nativeCertificateChainValidationStatus, NativeTimestampInformation nativeTimestampInformation, NativeEncryptionAlgorithm nativeEncryptionAlgorithm, NativeHashAlgorithm nativeHashAlgorithm, boolean z) {
        return CppProxy.create(nativeDigitalSignatureType, nativePAdESSignatureLevel, nativeX509Certificate, nativeCertificateChainValidationStatus, nativeTimestampInformation, nativeEncryptionAlgorithm, nativeHashAlgorithm, z);
    }

    public abstract NativeCertificateChainValidationStatus getCertificateChainValidationStatus();

    public abstract NativeHashAlgorithm getHashAlgorithm();

    public abstract NativePAdESSignatureLevel getPadesSignatureLevel();

    public abstract NativeEncryptionAlgorithm getSignatureAlgorithm();

    public abstract NativeDigitalSignatureType getSignatureType();

    public abstract NativeX509Certificate getSigningCertificate();

    public abstract NativeTimestampInformation getTimestampStatus();

    public abstract boolean isLtv();
}
