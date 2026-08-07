package io.split.android.client.storage.cipher;

import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes4.dex */
public interface CipherProvider {
    Cipher getDecryptionCipher();

    Cipher getEncryptionCipher();

    void release(Cipher cipher);
}
