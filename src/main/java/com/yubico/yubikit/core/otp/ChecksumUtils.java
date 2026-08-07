package com.yubico.yubikit.core.otp;

/* JADX INFO: loaded from: classes3.dex */
public class ChecksumUtils {
    private static final short CRC_OK_RESIDUAL = -3912;

    public static short calculateCrc(byte[] bArr, int i) {
        int i2 = 65535;
        for (int i3 = 0; i3 < i; i3++) {
            i2 ^= bArr[i3] & 255;
            for (int i4 = 0; i4 < 8; i4++) {
                int i5 = i2 & 1;
                i2 >>= 1;
                if (i5 == 1) {
                    i2 ^= 33800;
                }
            }
        }
        return (short) (i2 & 65535);
    }

    public static boolean checkCrc(byte[] bArr, int i) {
        return calculateCrc(bArr, i) == -3912;
    }

    private ChecksumUtils() {
        throw new IllegalStateException();
    }
}
