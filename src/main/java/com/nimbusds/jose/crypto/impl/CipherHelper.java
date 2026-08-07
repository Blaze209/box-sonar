package com.nimbusds.jose.crypto.impl;

import com.nimbusds.jose.shaded.jcip.ThreadSafe;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: classes3.dex */
@ThreadSafe
public class CipherHelper {
    public static Cipher getInstance(String str, Provider provider) throws NoSuchPaddingException, NoSuchAlgorithmException {
        if (provider == null) {
            return Cipher.getInstance(str);
        }
        return Cipher.getInstance(str, provider);
    }
}
