package com.google.crypto.tink;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes14.dex */
public interface Aead {
    byte[] decrypt(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException;

    byte[] encrypt(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException;
}
