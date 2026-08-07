package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDocumentSignatureValidator {

    public static final class CppProxy extends NativeDocumentSignatureValidator {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeDocumentSignatureValidator create(NativeFormField nativeFormField);

        private native void nativeDestroy(long j);

        private native void native_setCertificateCheckTime(long j, NativeCertificateCheckTime nativeCertificateCheckTime);

        private native void native_setCertificateRevocationResponses(long j, String str);

        private native void native_setCertificateValidationHttpClient(long j, NativeSimpleHTTPRequest nativeSimpleHTTPRequest);

        private native NativeSignatureValidationResult native_verifyDocument(long j, NativeKeyStore nativeKeyStore);

        private native NativeDocumentIntegrityStatus native_verifyIntegrity(long j);

        private native NativeCertificateChainValidationStatus native_verifySignature(long j, NativeKeyStore nativeKeyStore);

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

        @Override // com.pspdfkit.internal.jni.NativeDocumentSignatureValidator
        public void setCertificateCheckTime(NativeCertificateCheckTime nativeCertificateCheckTime) {
            native_setCertificateCheckTime(this.nativeRef, nativeCertificateCheckTime);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentSignatureValidator
        public void setCertificateRevocationResponses(String str) {
            native_setCertificateRevocationResponses(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentSignatureValidator
        public void setCertificateValidationHttpClient(NativeSimpleHTTPRequest nativeSimpleHTTPRequest) {
            native_setCertificateValidationHttpClient(this.nativeRef, nativeSimpleHTTPRequest);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentSignatureValidator
        public NativeSignatureValidationResult verifyDocument(NativeKeyStore nativeKeyStore) {
            return native_verifyDocument(this.nativeRef, nativeKeyStore);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentSignatureValidator
        public NativeDocumentIntegrityStatus verifyIntegrity() {
            return native_verifyIntegrity(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentSignatureValidator
        public NativeCertificateChainValidationStatus verifySignature(NativeKeyStore nativeKeyStore) {
            return native_verifySignature(this.nativeRef, nativeKeyStore);
        }
    }

    public static NativeDocumentSignatureValidator create(NativeFormField nativeFormField) {
        return CppProxy.create(nativeFormField);
    }

    public abstract void setCertificateCheckTime(NativeCertificateCheckTime nativeCertificateCheckTime);

    public abstract void setCertificateRevocationResponses(String str);

    public abstract void setCertificateValidationHttpClient(NativeSimpleHTTPRequest nativeSimpleHTTPRequest);

    public abstract NativeSignatureValidationResult verifyDocument(NativeKeyStore nativeKeyStore);

    public abstract NativeDocumentIntegrityStatus verifyIntegrity();

    public abstract NativeCertificateChainValidationStatus verifySignature(NativeKeyStore nativeKeyStore);
}
