package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDocumentSignerDataSource {

    public static final class CppProxy extends NativeDocumentSignerDataSource {
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

        private native NativeSignatureAppearance native_signatureAppearance(long j, String str);

        private native NativeSignatureBiometricProperties native_signatureBiometricProperties(long j, String str);

        private native NativeEncryptionAlgorithm native_signatureEncryptionAlgorithm(long j, String str);

        private native Integer native_signatureEstimatedSize(long j, String str);

        private native NativeHashAlgorithm native_signatureHashAlgorithm(long j, String str);

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

        @Override // com.pspdfkit.internal.jni.NativeDocumentSignerDataSource
        public NativeSignatureAppearance signatureAppearance(String str) {
            return native_signatureAppearance(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentSignerDataSource
        public NativeSignatureBiometricProperties signatureBiometricProperties(String str) {
            return native_signatureBiometricProperties(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentSignerDataSource
        public NativeEncryptionAlgorithm signatureEncryptionAlgorithm(String str) {
            return native_signatureEncryptionAlgorithm(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentSignerDataSource
        public Integer signatureEstimatedSize(String str) {
            return native_signatureEstimatedSize(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentSignerDataSource
        public NativeHashAlgorithm signatureHashAlgorithm(String str) {
            return native_signatureHashAlgorithm(this.nativeRef, str);
        }
    }

    public abstract NativeSignatureAppearance signatureAppearance(String str);

    public abstract NativeSignatureBiometricProperties signatureBiometricProperties(String str);

    public abstract NativeEncryptionAlgorithm signatureEncryptionAlgorithm(String str);

    public abstract Integer signatureEstimatedSize(String str);

    public abstract NativeHashAlgorithm signatureHashAlgorithm(String str);
}
