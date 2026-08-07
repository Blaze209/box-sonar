package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDigitalSignatureMetadata {
    public static final int DEFAULT_SIGNATURE_SIZE = 32768;

    public static final class CppProxy extends NativeDigitalSignatureMetadata {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeDigitalSignatureMetadata create();

        private native void nativeDestroy(long j);

        private native NativeSignatureAppearance native_getAppearance(long j);

        private native NativeSignatureBiometricProperties native_getBiometricProperties(long j);

        private native int native_getEstimatedSize(long j);

        private native NativeHashAlgorithm native_getHashAlgorithm(long j);

        private native String native_getHttpRevocationResponses(long j);

        private native String native_getLocation(long j);

        private native String native_getReason(long j);

        private native NativeKeyStore native_getTrustedKeyStore(long j);

        private native NativeDigitalSignatureType native_getType(long j);

        private native void native_setAppearance(long j, NativeSignatureAppearance nativeSignatureAppearance);

        private native void native_setBiometricProperties(long j, NativeSignatureBiometricProperties nativeSignatureBiometricProperties);

        private native void native_setEstimatedSize(long j, int i);

        private native void native_setHashAlgorithm(long j, NativeHashAlgorithm nativeHashAlgorithm);

        private native void native_setHttpRevocationResponses(long j, String str);

        private native void native_setLocation(long j, String str);

        private native void native_setReason(long j, String str);

        private native void native_setTrustedKeyStore(long j, NativeKeyStore nativeKeyStore);

        private native void native_setType(long j, NativeDigitalSignatureType nativeDigitalSignatureType);

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

        @Override // com.pspdfkit.internal.jni.NativeDigitalSignatureMetadata
        public NativeSignatureAppearance getAppearance() {
            return native_getAppearance(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDigitalSignatureMetadata
        public NativeSignatureBiometricProperties getBiometricProperties() {
            return native_getBiometricProperties(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDigitalSignatureMetadata
        public int getEstimatedSize() {
            return native_getEstimatedSize(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDigitalSignatureMetadata
        public NativeHashAlgorithm getHashAlgorithm() {
            return native_getHashAlgorithm(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDigitalSignatureMetadata
        public String getHttpRevocationResponses() {
            return native_getHttpRevocationResponses(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDigitalSignatureMetadata
        public String getLocation() {
            return native_getLocation(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDigitalSignatureMetadata
        public String getReason() {
            return native_getReason(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDigitalSignatureMetadata
        public NativeKeyStore getTrustedKeyStore() {
            return native_getTrustedKeyStore(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDigitalSignatureMetadata
        public NativeDigitalSignatureType getType() {
            return native_getType(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDigitalSignatureMetadata
        public void setAppearance(NativeSignatureAppearance nativeSignatureAppearance) {
            native_setAppearance(this.nativeRef, nativeSignatureAppearance);
        }

        @Override // com.pspdfkit.internal.jni.NativeDigitalSignatureMetadata
        public void setBiometricProperties(NativeSignatureBiometricProperties nativeSignatureBiometricProperties) {
            native_setBiometricProperties(this.nativeRef, nativeSignatureBiometricProperties);
        }

        @Override // com.pspdfkit.internal.jni.NativeDigitalSignatureMetadata
        public void setEstimatedSize(int i) {
            native_setEstimatedSize(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeDigitalSignatureMetadata
        public void setHashAlgorithm(NativeHashAlgorithm nativeHashAlgorithm) {
            native_setHashAlgorithm(this.nativeRef, nativeHashAlgorithm);
        }

        @Override // com.pspdfkit.internal.jni.NativeDigitalSignatureMetadata
        public void setHttpRevocationResponses(String str) {
            native_setHttpRevocationResponses(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDigitalSignatureMetadata
        public void setLocation(String str) {
            native_setLocation(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDigitalSignatureMetadata
        public void setReason(String str) {
            native_setReason(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDigitalSignatureMetadata
        public void setTrustedKeyStore(NativeKeyStore nativeKeyStore) {
            native_setTrustedKeyStore(this.nativeRef, nativeKeyStore);
        }

        @Override // com.pspdfkit.internal.jni.NativeDigitalSignatureMetadata
        public void setType(NativeDigitalSignatureType nativeDigitalSignatureType) {
            native_setType(this.nativeRef, nativeDigitalSignatureType);
        }
    }

    public static NativeDigitalSignatureMetadata create() {
        return CppProxy.create();
    }

    public abstract NativeSignatureAppearance getAppearance();

    public abstract NativeSignatureBiometricProperties getBiometricProperties();

    public abstract int getEstimatedSize();

    public abstract NativeHashAlgorithm getHashAlgorithm();

    public abstract String getHttpRevocationResponses();

    public abstract String getLocation();

    public abstract String getReason();

    public abstract NativeKeyStore getTrustedKeyStore();

    public abstract NativeDigitalSignatureType getType();

    public abstract void setAppearance(NativeSignatureAppearance nativeSignatureAppearance);

    public abstract void setBiometricProperties(NativeSignatureBiometricProperties nativeSignatureBiometricProperties);

    public abstract void setEstimatedSize(int i);

    public abstract void setHashAlgorithm(NativeHashAlgorithm nativeHashAlgorithm);

    public abstract void setHttpRevocationResponses(String str);

    public abstract void setLocation(String str);

    public abstract void setReason(String str);

    public abstract void setTrustedKeyStore(NativeKeyStore nativeKeyStore);

    public abstract void setType(NativeDigitalSignatureType nativeDigitalSignatureType);
}
