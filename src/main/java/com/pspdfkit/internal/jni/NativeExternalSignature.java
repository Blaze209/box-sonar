package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeExternalSignature {
    public abstract NativeEncryptionAlgorithm encryptionAlgorithm();

    public abstract byte[] signData(byte[] bArr, NativeHashAlgorithm nativeHashAlgorithm);
}
