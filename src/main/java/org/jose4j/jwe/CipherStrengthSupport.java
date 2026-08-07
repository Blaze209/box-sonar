package org.jose4j.jwe;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import org.jose4j.lang.ByteUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class CipherStrengthSupport {
    private static final Logger log = LoggerFactory.getLogger((Class<?>) CipherStrengthSupport.class);

    public static boolean isAvailable(String str, int i) {
        int iBitLength = ByteUtil.bitLength(i);
        try {
            int maxAllowedKeyLength = Cipher.getMaxAllowedKeyLength(str);
            boolean z = iBitLength <= maxAllowedKeyLength;
            if (!z) {
                log.debug("max allowed key length for {} is {}", str, Integer.valueOf(maxAllowedKeyLength));
            }
            return z;
        } catch (NoSuchAlgorithmException e) {
            log.debug("Unknown/unsupported algorithm, {} {}", str, e);
            return false;
        }
    }
}
