package com.yubico.yubikit.core.smartcard;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class ApduResponse {
    private final byte[] bytes;

    public ApduResponse(byte[] bArr) {
        if (bArr.length < 2) {
            throw new IllegalArgumentException("Invalid APDU response data");
        }
        this.bytes = Arrays.copyOf(bArr, bArr.length);
    }

    public short getSw() {
        byte[] bArr = this.bytes;
        return (short) ((bArr[bArr.length - 1] & 255) | ((bArr[bArr.length - 2] & 255) << 8));
    }

    public byte[] getData() {
        byte[] bArr = this.bytes;
        return Arrays.copyOfRange(bArr, 0, bArr.length - 2);
    }

    public byte[] getBytes() {
        byte[] bArr = this.bytes;
        return Arrays.copyOf(bArr, bArr.length);
    }
}
