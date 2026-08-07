package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDigitalSignatureCreator {

    public static final class CppProxy extends NativeDigitalSignatureCreator {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeDigitalSignatureCreationResult create(ArrayList<NativeX509Certificate> arrayList, NativeDigitalSignatureMetadata nativeDigitalSignatureMetadata);

        private native void nativeDestroy(long j);

        private native NativeDigitalSignatureResult native_finishSignature(long j, String str, byte[] bArr, NativeDataProvider nativeDataProvider);

        private native NativeDataToSignResult native_getDataToSign(long j, String str, NativeDataProvider nativeDataProvider);

        private native NativeDigitalSignatureResult native_prepareSignature(long j, NativeFormField nativeFormField, NativeDataProvider nativeDataProvider);

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

        @Override // com.pspdfkit.internal.jni.NativeDigitalSignatureCreator
        public NativeDigitalSignatureResult finishSignature(String str, byte[] bArr, NativeDataProvider nativeDataProvider) {
            return native_finishSignature(this.nativeRef, str, bArr, nativeDataProvider);
        }

        @Override // com.pspdfkit.internal.jni.NativeDigitalSignatureCreator
        public NativeDataToSignResult getDataToSign(String str, NativeDataProvider nativeDataProvider) {
            return native_getDataToSign(this.nativeRef, str, nativeDataProvider);
        }

        @Override // com.pspdfkit.internal.jni.NativeDigitalSignatureCreator
        public NativeDigitalSignatureResult prepareSignature(NativeFormField nativeFormField, NativeDataProvider nativeDataProvider) {
            return native_prepareSignature(this.nativeRef, nativeFormField, nativeDataProvider);
        }
    }

    public static NativeDigitalSignatureCreationResult create(ArrayList<NativeX509Certificate> arrayList, NativeDigitalSignatureMetadata nativeDigitalSignatureMetadata) {
        return CppProxy.create(arrayList, nativeDigitalSignatureMetadata);
    }

    public abstract NativeDigitalSignatureResult finishSignature(String str, byte[] bArr, NativeDataProvider nativeDataProvider);

    public abstract NativeDataToSignResult getDataToSign(String str, NativeDataProvider nativeDataProvider);

    public abstract NativeDigitalSignatureResult prepareSignature(NativeFormField nativeFormField, NativeDataProvider nativeDataProvider);
}
