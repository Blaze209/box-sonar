package org.jose4j.jwe;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import org.jose4j.lang.JoseException;

/* JADX INFO: loaded from: classes5.dex */
public class CipherUtil {
    static Cipher getCipher(String str, String str2) throws JoseException {
        try {
            return str2 == null ? Cipher.getInstance(str) : Cipher.getInstance(str, str2);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new JoseException(e.toString(), e);
        } catch (NoSuchProviderException e2) {
            throw new JoseException("Unable to get a Cipher implementation of " + str + " using provider " + str2, e2);
        }
    }
}
