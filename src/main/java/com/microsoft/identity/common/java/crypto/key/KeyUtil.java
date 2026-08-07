package com.microsoft.identity.common.java.crypto.key;

import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.base64.Base64Util;
import com.microsoft.identity.common.java.logging.Logger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes14.dex */
public class KeyUtil {
    public static final String HMAC_ALGORITHM = "HmacSHA256";
    private static final String HMAC_KEYSPEC_ALGORITHM = "AES";
    public static final String HMAC_KEY_HASH_ALGORITHM = "SHA-256";
    private static final String TAG = "KeyUtil";
    public static final String UNKNOWN_THUMBPRINT = "UNKNOWN_THUMBPRINT";

    public static String getKeyThumbPrint(ISecretKeyProvider iSecretKeyProvider) {
        if (iSecretKeyProvider == null) {
            throw new NullPointerException("keyLoader is marked non-null but is null");
        }
        try {
            return getKeyThumbPrint(iSecretKeyProvider.getKey());
        } catch (Throwable th) {
            Logger.warn(TAG + ":getKeyThumbPrint", "failed to load key:" + th.getMessage());
            return UNKNOWN_THUMBPRINT;
        }
    }

    public static String getKeyThumbPrint(SecretKey secretKey) {
        if (secretKey == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        try {
            return getKeyThumbPrintFromHmacKey(getHMacKey(secretKey));
        } catch (Throwable th) {
            Logger.warn(TAG + ":getKeyThumbPrint", "failed to calculate thumbprint:" + th.getMessage());
            return UNKNOWN_THUMBPRINT;
        }
    }

    public static String getKeyThumbPrintFromHmacKey(SecretKey secretKey) {
        if (secretKey == null) {
            throw new NullPointerException("hmacKey is marked non-null but is null");
        }
        try {
            byte[] bytes = "012345678910111213141516".getBytes(AuthenticationConstants.ENCODING_UTF8);
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKey);
            return Base64Util.encodeUrlSafeString(mac.doFinal(bytes));
        } catch (Throwable th) {
            Logger.warn(TAG + ":getKeyThumbPrintFromHmacKey", "failed to calculate thumbprint:" + th.getMessage());
            return UNKNOWN_THUMBPRINT;
        }
    }

    public static SecretKey getHMacKey(SecretKey secretKey) throws NoSuchAlgorithmException {
        if (secretKey == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        byte[] encoded = secretKey.getEncoded();
        return encoded != null ? new SecretKeySpec(MessageDigest.getInstance("SHA-256").digest(encoded), "AES") : secretKey;
    }
}
