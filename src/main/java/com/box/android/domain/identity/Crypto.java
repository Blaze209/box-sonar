package com.box.android.domain.identity;

import com.box.androidsdk.content.utils.BoxLogUtils;
import com.google.common.base.Ascii;
import com.yubico.yubikit.core.fido.CtapException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes11.dex */
public final class Crypto {
    private static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();

    private Crypto() {
    }

    public static String md5(InputStream inputStream) throws NoSuchAlgorithmException, IOException {
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (i > 0) {
                messageDigest.update(bArr, 0, i);
            } else {
                inputStream.close();
                return asHex(messageDigest.digest());
            }
        }
    }

    public static String md5(String str) {
        try {
            return md5(new ByteArrayInputStream(str.getBytes("UTF8")));
        } catch (UnsupportedEncodingException e) {
            BoxLogUtils.logException(e);
            return null;
        } catch (IOException e2) {
            BoxLogUtils.logException(e2);
            return null;
        } catch (NoSuchAlgorithmException e3) {
            BoxLogUtils.logException(e3);
            return null;
        }
    }

    public static String sha1(InputStream inputStream) throws IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[8192];
            while (true) {
                int i = inputStream.read(bArr);
                if (i > 0) {
                    messageDigest.update(bArr, 0, i);
                } else {
                    inputStream.close();
                    return asHex(messageDigest.digest());
                }
            }
        } catch (NoSuchAlgorithmException e) {
            BoxLogUtils.logException(e);
            return null;
        }
    }

    public static String sha1(String str) {
        try {
            return sha1(new ByteArrayInputStream(str.getBytes("UTF8")));
        } catch (UnsupportedEncodingException e) {
            BoxLogUtils.logException(e);
            return null;
        } catch (IOException e2) {
            BoxLogUtils.logException(e2);
            return null;
        }
    }

    public static String sha1(String str, int i) {
        String strSha1 = str;
        for (int i2 = 0; i2 < i; i2++) {
            strSha1 = sha1(str);
            if (strSha1 == null) {
                return strSha1;
            }
        }
        return strSha1;
    }

    public static String sha256(InputStream inputStream) throws IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bArr = new byte[8192];
            while (true) {
                int i = inputStream.read(bArr);
                if (i > 0) {
                    messageDigest.update(bArr, 0, i);
                } else {
                    inputStream.close();
                    return asHex(messageDigest.digest());
                }
            }
        } catch (NoSuchAlgorithmException e) {
            BoxLogUtils.logException(e);
            return null;
        }
    }

    public static String sha256(String str) {
        try {
            return sha256(new ByteArrayInputStream(str.getBytes("UTF8")));
        } catch (UnsupportedEncodingException e) {
            BoxLogUtils.logException(e);
            return null;
        } catch (IOException e2) {
            BoxLogUtils.logException(e2);
            return null;
        }
    }

    public static String sha256(String str, int i) {
        String strSha256 = str;
        for (int i2 = 0; i2 < i; i2++) {
            strSha256 = sha256(str);
            if (strSha256 == null) {
                return strSha256;
            }
        }
        return strSha256;
    }

    public static String asHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            char[] cArr2 = HEX_CHARS;
            byte b = bArr[i];
            cArr[i2] = cArr2[(b & CtapException.ERR_VENDOR_FIRST) >>> 4];
            cArr[i2 + 1] = cArr2[b & Ascii.SI];
        }
        return new String(cArr);
    }
}
