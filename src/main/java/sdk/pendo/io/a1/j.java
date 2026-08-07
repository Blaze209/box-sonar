package sdk.pendo.io.a1;

import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes4.dex */
public class j {
    public static byte[] a(String str) {
        return a(str, "US-ASCII");
    }

    public static byte[] b(String str) {
        return a(str, "UTF-8");
    }

    private static IllegalStateException c(String str) {
        return new IllegalStateException("Unknown or unsupported character set name: " + str);
    }

    public static byte[] a(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException unused) {
            throw c(str2);
        }
    }

    public static String a(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException unused) {
            throw c(str);
        }
    }

    public static String a(byte[] bArr) {
        return a(bArr, "UTF-8");
    }
}
