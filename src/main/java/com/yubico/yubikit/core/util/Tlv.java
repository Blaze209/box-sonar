package com.yubico.yubikit.core.util;

import androidx.work.WorkInfo;
import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class Tlv {
    private final byte[] bytes;
    private final int length;
    private final int offset;
    private final int tag;

    public Tlv(int i, @Nullable byte[] bArr) {
        this.tag = i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] byteArray = BigInteger.valueOf(i).toByteArray();
        int i2 = byteArray[0] == 0 ? 1 : 0;
        byteArrayOutputStream.write(byteArray, i2, byteArray.length - i2);
        int length = bArr == null ? 0 : bArr.length;
        this.length = length;
        if (length < 128) {
            byteArrayOutputStream.write(length);
        } else {
            byte[] byteArray2 = BigInteger.valueOf(length).toByteArray();
            int i3 = byteArray2[0] != 0 ? 0 : 1;
            byteArrayOutputStream.write(128 | (byteArray2.length - i3));
            byteArrayOutputStream.write(byteArray2, i3, byteArray2.length - i3);
        }
        this.offset = byteArrayOutputStream.size();
        if (bArr != null) {
            byteArrayOutputStream.write(bArr, 0, length);
        }
        this.bytes = byteArrayOutputStream.toByteArray();
    }

    public int getTag() {
        return this.tag;
    }

    public byte[] getValue() {
        byte[] bArr = this.bytes;
        int i = this.offset;
        return Arrays.copyOfRange(bArr, i, this.length + i);
    }

    public int getLength() {
        return this.length;
    }

    public byte[] getBytes() {
        byte[] bArr = this.bytes;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public String toString() {
        return String.format(Locale.ROOT, "Tlv(0x%x, %d, %s)", Integer.valueOf(this.tag), Integer.valueOf(this.length), StringUtils.bytesToHex(getValue()));
    }

    public static Tlv parse(byte[] bArr, int i, int i2) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i, i2);
        Tlv from = parseFrom(byteBufferWrap);
        if (byteBufferWrap.hasRemaining()) {
            throw new IllegalArgumentException("Extra data remaining");
        }
        return from;
    }

    public static Tlv parse(byte[] bArr) {
        return parse(bArr, 0, bArr.length);
    }

    static Tlv parseFrom(ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        int i = b & 255;
        if ((b & Ascii.US) == 31) {
            i = (i << 8) | (byteBuffer.get() & 255);
            while ((i & 128) == 128) {
                i = (byteBuffer.get() & 255) | (i << 8);
            }
        }
        int i2 = byteBuffer.get() & 255;
        if (i2 == 128) {
            throw new IllegalArgumentException("Indefinite length not supported");
        }
        if (i2 > 128) {
            int i3 = i2 + WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                i4 = (i4 << 8) | (byteBuffer.get() & 255);
            }
            i2 = i4;
        }
        byte[] bArr = new byte[i2];
        byteBuffer.get(bArr);
        return new Tlv(i, bArr);
    }
}
