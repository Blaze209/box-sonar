package com.facebook.common.util;

import android.util.Base64;
import com.google.common.base.Ascii;
import com.yubico.yubikit.core.fido.CtapException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes13.dex */
public class SecureHashUtil {
    private static final int BUFFER_SIZE = 4096;
    static final byte[] HEX_CHAR_TABLE = {CtapException.ERR_NOT_ALLOWED, CtapException.ERR_PIN_INVALID, CtapException.ERR_PIN_BLOCKED, CtapException.ERR_PIN_AUTH_INVALID, CtapException.ERR_PIN_AUTH_BLOCKED, CtapException.ERR_PIN_NOT_SET, CtapException.ERR_PIN_REQUIRED, CtapException.ERR_PIN_POLICY_VIOLATION, CtapException.ERR_PIN_TOKEN_EXPIRED, CtapException.ERR_REQUEST_TOO_LARGE, 97, 98, 99, 100, 101, 102};

    public static String makeSHA1Hash(String str) {
        try {
            return makeSHA1Hash(str.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String makeSHA1Hash(byte[] bArr) {
        return makeHash(bArr, "SHA-1");
    }

    public static String makeSHA256Hash(byte[] bArr) {
        return makeHash(bArr, "SHA-256");
    }

    public static String makeSHA1HashBase64(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(bArr, 0, bArr.length);
            return Base64.encodeToString(messageDigest.digest(), 11);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String makeMD5Hash(String str) {
        try {
            return makeMD5Hash(str.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String makeMD5Hash(byte[] bArr) {
        return makeHash(bArr, MessageDigestAlgorithms.MD5);
    }

    public static String makeMD5Hash(InputStream inputStream) throws IOException {
        return makeHash(inputStream, MessageDigestAlgorithms.MD5);
    }

    public static String convertToHex(byte[] bArr) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder(bArr.length);
        for (byte b : bArr) {
            byte[] bArr2 = HEX_CHAR_TABLE;
            sb.append((char) bArr2[(b & 255) >>> 4]);
            sb.append((char) bArr2[b & Ascii.SI]);
        }
        return sb.toString();
    }

    private static String makeHash(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr, 0, bArr.length);
            return convertToHex(messageDigest.digest());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static String makeHash(InputStream inputStream, String str) throws IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i > 0) {
                    messageDigest.update(bArr, 0, i);
                } else {
                    return convertToHex(messageDigest.digest());
                }
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }
}
