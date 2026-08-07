package com.microsoft.identity.common.java.crypto;

import com.microsoft.identity.common.java.exception.ClientException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Signature;
import javax.annotation.Nullable;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: classes14.dex */
public class ProviderFactory {
    public static Signature getSignature(String str, @Nullable Provider provider) throws ClientException {
        if (str == null) {
            throw new NullPointerException("algorithm is marked non-null but is null");
        }
        try {
            if (provider != null) {
                return Signature.getInstance(str, provider);
            }
            return Signature.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new ClientException("no_such_algorithm", e.getMessage(), e);
        }
    }

    public static Cipher getCipher(String str, @Nullable Provider provider) throws ClientException {
        if (str == null) {
            throw new NullPointerException("algorithm is marked non-null but is null");
        }
        try {
            if (provider != null) {
                return Cipher.getInstance(str, provider);
            }
            return Cipher.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new ClientException("no_such_algorithm", e.getMessage(), e);
        } catch (NoSuchPaddingException e2) {
            throw new ClientException(ClientException.NO_SUCH_PADDING, e2.getMessage(), e2);
        }
    }

    public static Mac getMac(String str, @Nullable Provider provider) throws ClientException {
        if (str == null) {
            throw new NullPointerException("algorithm is marked non-null but is null");
        }
        try {
            if (provider != null) {
                return Mac.getInstance(str, provider);
            }
            return Mac.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new ClientException("no_such_algorithm", e.getMessage(), e);
        }
    }

    public static KeyPairGenerator getKeyPairGenerator(String str, @Nullable Provider provider) throws ClientException {
        if (str == null) {
            throw new NullPointerException("algorithm is marked non-null but is null");
        }
        try {
            if (provider != null) {
                return KeyPairGenerator.getInstance(str, provider);
            }
            return KeyPairGenerator.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new ClientException("no_such_algorithm", e.getMessage(), e);
        }
    }

    public static KeyFactory getKeyFactory(String str, @Nullable Provider provider) throws ClientException {
        if (str == null) {
            throw new NullPointerException("algorithm is marked non-null but is null");
        }
        try {
            if (provider != null) {
                return KeyFactory.getInstance(str, provider);
            }
            return KeyFactory.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new ClientException("no_such_algorithm", e.getMessage(), e);
        }
    }

    public static MessageDigest getMessageDigest(String str, @Nullable Provider provider) throws ClientException {
        if (str == null) {
            throw new NullPointerException("algorithm is marked non-null but is null");
        }
        try {
            if (provider != null) {
                return MessageDigest.getInstance(str, provider);
            }
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new ClientException("no_such_algorithm", e.getMessage(), e);
        }
    }
}
