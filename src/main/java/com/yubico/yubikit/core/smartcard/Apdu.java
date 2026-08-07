package com.yubico.yubikit.core.smartcard;

import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class Apdu {
    private final byte cla;
    private final byte[] data;
    private final byte ins;
    private final int le;
    private final byte p1;
    private final byte p2;

    private Apdu(byte b, byte b2, byte b3, byte b4, @Nullable byte[] bArr, int i) {
        this.cla = b;
        this.ins = b2;
        this.p1 = b3;
        this.p2 = b4;
        this.data = bArr == null ? new byte[0] : bArr;
        this.le = i;
    }

    private Apdu(byte b, byte b2, byte b3, byte b4, @Nullable byte[] bArr) {
        this(b, b2, b3, b4, bArr, 0);
    }

    public Apdu(int i, int i2, int i3, int i4, @Nullable byte[] bArr, int i5) {
        this(validateByte(i, "CLA"), validateByte(i2, "INS"), validateByte(i3, "P1"), validateByte(i4, "P2"), bArr, i5);
    }

    public Apdu(int i, int i2, int i3, int i4, @Nullable byte[] bArr) {
        this(i, i2, i3, i4, bArr, 0);
    }

    public byte[] getData() {
        byte[] bArr = this.data;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public byte getCla() {
        return this.cla;
    }

    public byte getIns() {
        return this.ins;
    }

    public byte getP1() {
        return this.p1;
    }

    public byte getP2() {
        return this.p2;
    }

    public int getLe() {
        return this.le;
    }

    private static byte validateByte(int i, String str) {
        if (i > 255 || i < -128) {
            throw new IllegalArgumentException("Invalid value for " + str + ", must fit in a byte");
        }
        return (byte) i;
    }
}
