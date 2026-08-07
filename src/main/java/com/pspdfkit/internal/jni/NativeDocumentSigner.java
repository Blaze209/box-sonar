package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDocumentSigner {

    public static final class CppProxy extends NativeDocumentSigner {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeDocumentSigner create();

        private native void nativeDestroy(long j);

        private native void native_embedSignatureContentsInFormField(long j, NativeFormField nativeFormField, NativeSignatureContents nativeSignatureContents, NativeDataSink nativeDataSink, NativeDocumentSignerCallback nativeDocumentSignerCallback);

        private native NativeSignatureBiometricProperties native_getBiometricProperties(long j, String str);

        private native NativeDocumentSignerDataSource native_getDataSource(long j);

        private native NativeEncryptionAlgorithm native_getEncryptionAlgorithm(long j, String str);

        private native NativeFilterType native_getFilter(long j);

        private native NativeHashAlgorithm native_getHashAlgorithm(long j, String str);

        private native NativeSignatureAppearance native_getSignatureAppearance(long j, String str);

        private native int native_getSignatureEstimatedSize(long j, String str);

        private native NativeFilterSubtype native_getSubfilter(long j);

        private native void native_prepareFormFieldToBeSigned(long j, NativeFormField nativeFormField, NativeSignatureContents nativeSignatureContents, NativeDataSink nativeDataSink, NativeDocumentSignatureMetadata nativeDocumentSignatureMetadata, NativeDocumentSignerCallback nativeDocumentSignerCallback);

        private native void native_setDataSource(long j, NativeDocumentSignerDataSource nativeDocumentSignerDataSource);

        private native void native_setFilter(long j, NativeFilterType nativeFilterType);

        private native void native_setSubfilter(long j, NativeFilterSubtype nativeFilterSubtype);

        private native NativeDocumentSignerStatus native_signFormElement(long j, NativeFormField nativeFormField, ArrayList<NativeX509Certificate> arrayList, NativeDataSink nativeDataSink, NativeDocumentSignatureMetadata nativeDocumentSignatureMetadata, NativeExternalSignature nativeExternalSignature, NativeSignatureAppearance nativeSignatureAppearance, NativeSignatureBiometricProperties nativeSignatureBiometricProperties, Integer num);

        private native void native_signFormElementAsync(long j, NativeFormField nativeFormField, ArrayList<NativeX509Certificate> arrayList, NativeDataSink nativeDataSink, NativeDocumentSignatureMetadata nativeDocumentSignatureMetadata, NativeDocumentSignerDelegate nativeDocumentSignerDelegate, NativeDocumentSignerCallback nativeDocumentSignerCallback);

        public static native byte[] signData(byte[] bArr, NativePrivateKey nativePrivateKey, NativeHashAlgorithm nativeHashAlgorithm);

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

        @Override // com.pspdfkit.internal.jni.NativeDocumentSigner
        public void embedSignatureContentsInFormField(NativeFormField nativeFormField, NativeSignatureContents nativeSignatureContents, NativeDataSink nativeDataSink, NativeDocumentSignerCallback nativeDocumentSignerCallback) {
            native_embedSignatureContentsInFormField(this.nativeRef, nativeFormField, nativeSignatureContents, nativeDataSink, nativeDocumentSignerCallback);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentSigner
        public NativeSignatureBiometricProperties getBiometricProperties(String str) {
            return native_getBiometricProperties(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentSigner
        public NativeDocumentSignerDataSource getDataSource() {
            return native_getDataSource(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentSigner
        public NativeEncryptionAlgorithm getEncryptionAlgorithm(String str) {
            return native_getEncryptionAlgorithm(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentSigner
        public NativeFilterType getFilter() {
            return native_getFilter(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentSigner
        public NativeHashAlgorithm getHashAlgorithm(String str) {
            return native_getHashAlgorithm(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentSigner
        public NativeSignatureAppearance getSignatureAppearance(String str) {
            return native_getSignatureAppearance(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentSigner
        public int getSignatureEstimatedSize(String str) {
            return native_getSignatureEstimatedSize(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentSigner
        public NativeFilterSubtype getSubfilter() {
            return native_getSubfilter(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentSigner
        public void prepareFormFieldToBeSigned(NativeFormField nativeFormField, NativeSignatureContents nativeSignatureContents, NativeDataSink nativeDataSink, NativeDocumentSignatureMetadata nativeDocumentSignatureMetadata, NativeDocumentSignerCallback nativeDocumentSignerCallback) {
            native_prepareFormFieldToBeSigned(this.nativeRef, nativeFormField, nativeSignatureContents, nativeDataSink, nativeDocumentSignatureMetadata, nativeDocumentSignerCallback);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentSigner
        public void setDataSource(NativeDocumentSignerDataSource nativeDocumentSignerDataSource) {
            native_setDataSource(this.nativeRef, nativeDocumentSignerDataSource);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentSigner
        public void setFilter(NativeFilterType nativeFilterType) {
            native_setFilter(this.nativeRef, nativeFilterType);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentSigner
        public void setSubfilter(NativeFilterSubtype nativeFilterSubtype) {
            native_setSubfilter(this.nativeRef, nativeFilterSubtype);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentSigner
        public NativeDocumentSignerStatus signFormElement(NativeFormField nativeFormField, ArrayList<NativeX509Certificate> arrayList, NativeDataSink nativeDataSink, NativeDocumentSignatureMetadata nativeDocumentSignatureMetadata, NativeExternalSignature nativeExternalSignature, NativeSignatureAppearance nativeSignatureAppearance, NativeSignatureBiometricProperties nativeSignatureBiometricProperties, Integer num) {
            return native_signFormElement(this.nativeRef, nativeFormField, arrayList, nativeDataSink, nativeDocumentSignatureMetadata, nativeExternalSignature, nativeSignatureAppearance, nativeSignatureBiometricProperties, num);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentSigner
        public void signFormElementAsync(NativeFormField nativeFormField, ArrayList<NativeX509Certificate> arrayList, NativeDataSink nativeDataSink, NativeDocumentSignatureMetadata nativeDocumentSignatureMetadata, NativeDocumentSignerDelegate nativeDocumentSignerDelegate, NativeDocumentSignerCallback nativeDocumentSignerCallback) {
            native_signFormElementAsync(this.nativeRef, nativeFormField, arrayList, nativeDataSink, nativeDocumentSignatureMetadata, nativeDocumentSignerDelegate, nativeDocumentSignerCallback);
        }
    }

    public static NativeDocumentSigner create() {
        return CppProxy.create();
    }

    public static byte[] signData(byte[] bArr, NativePrivateKey nativePrivateKey, NativeHashAlgorithm nativeHashAlgorithm) {
        return CppProxy.signData(bArr, nativePrivateKey, nativeHashAlgorithm);
    }

    public abstract void embedSignatureContentsInFormField(NativeFormField nativeFormField, NativeSignatureContents nativeSignatureContents, NativeDataSink nativeDataSink, NativeDocumentSignerCallback nativeDocumentSignerCallback);

    public abstract NativeSignatureBiometricProperties getBiometricProperties(String str);

    public abstract NativeDocumentSignerDataSource getDataSource();

    public abstract NativeEncryptionAlgorithm getEncryptionAlgorithm(String str);

    public abstract NativeFilterType getFilter();

    public abstract NativeHashAlgorithm getHashAlgorithm(String str);

    public abstract NativeSignatureAppearance getSignatureAppearance(String str);

    public abstract int getSignatureEstimatedSize(String str);

    public abstract NativeFilterSubtype getSubfilter();

    public abstract void prepareFormFieldToBeSigned(NativeFormField nativeFormField, NativeSignatureContents nativeSignatureContents, NativeDataSink nativeDataSink, NativeDocumentSignatureMetadata nativeDocumentSignatureMetadata, NativeDocumentSignerCallback nativeDocumentSignerCallback);

    public abstract void setDataSource(NativeDocumentSignerDataSource nativeDocumentSignerDataSource);

    public abstract void setFilter(NativeFilterType nativeFilterType);

    public abstract void setSubfilter(NativeFilterSubtype nativeFilterSubtype);

    public abstract NativeDocumentSignerStatus signFormElement(NativeFormField nativeFormField, ArrayList<NativeX509Certificate> arrayList, NativeDataSink nativeDataSink, NativeDocumentSignatureMetadata nativeDocumentSignatureMetadata, NativeExternalSignature nativeExternalSignature, NativeSignatureAppearance nativeSignatureAppearance, NativeSignatureBiometricProperties nativeSignatureBiometricProperties, Integer num);

    public abstract void signFormElementAsync(NativeFormField nativeFormField, ArrayList<NativeX509Certificate> arrayList, NativeDataSink nativeDataSink, NativeDocumentSignatureMetadata nativeDocumentSignatureMetadata, NativeDocumentSignerDelegate nativeDocumentSignerDelegate, NativeDocumentSignerCallback nativeDocumentSignerCallback);
}
