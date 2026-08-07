package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDatabaseEncryptionProvider {
    public abstract boolean encryptDatabase(Long l, byte[] bArr);

    public abstract boolean reEncryptDatabase(Long l, byte[] bArr);
}
