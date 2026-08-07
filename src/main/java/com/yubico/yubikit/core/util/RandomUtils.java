package com.yubico.yubikit.core.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes3.dex */
public class RandomUtils {
    public static byte[] getRandomBytes(int i) {
        byte[] bArr = new byte[i];
        try {
            SecureRandom.getInstanceStrong().nextBytes(bArr);
            return bArr;
        } catch (NoSuchMethodError | NoSuchAlgorithmException unused) {
            new SecureRandom().nextBytes(bArr);
            return bArr;
        }
    }

    private RandomUtils() {
        throw new IllegalStateException();
    }
}
