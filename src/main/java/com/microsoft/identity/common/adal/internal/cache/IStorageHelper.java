package com.microsoft.identity.common.adal.internal.cache;

import java.io.IOException;
import java.security.GeneralSecurityException;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes14.dex */
public interface IStorageHelper {
    String decrypt(String str) throws GeneralSecurityException, IOException;

    String encrypt(String str) throws GeneralSecurityException, IOException;

    SecretKey loadSecretKeyForEncryption() throws GeneralSecurityException, IOException;
}
