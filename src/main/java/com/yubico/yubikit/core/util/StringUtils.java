package com.yubico.yubikit.core.util;

/* JADX INFO: loaded from: classes3.dex */
public class StringUtils {
    public static String bytesToHex(byte[] bArr) {
        return bytesToHex(bArr, 0, bArr.length);
    }

    public static String bytesToHex(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        while (i < i2) {
            sb.append(String.format("%02x ", Byte.valueOf(bArr[i])));
            i++;
        }
        return sb.toString();
    }

    private StringUtils() {
        throw new IllegalStateException();
    }
}
