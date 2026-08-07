package com.yubico.yubikit.piv;

import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes3.dex */
public enum ManagementKeyType {
    TDES((byte) 3, "DESede", 24, 8),
    AES128((byte) 8, "AES", 16, 16),
    AES192((byte) 10, "AES", 24, 16),
    AES256(Ascii.FF, "AES", 32, 16);

    public final int challengeLength;
    public final String cipherName;
    public final int keyLength;
    public final byte value;

    ManagementKeyType(byte b, String str, int i, int i2) {
        this.value = b;
        this.cipherName = str;
        this.keyLength = i;
        this.challengeLength = i2;
    }

    public static ManagementKeyType fromValue(byte b) {
        for (ManagementKeyType managementKeyType : values()) {
            if (managementKeyType.value == b) {
                return managementKeyType;
            }
        }
        throw new IllegalArgumentException("Not a valid ManagementKeyType:" + ((int) b));
    }
}
