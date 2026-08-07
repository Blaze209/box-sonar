package io.split.android.client.utils;

import androidx.collection.ScatterMapKt;
import androidx.media3.extractor.ts.PsExtractor;
import java.math.BigInteger;
import okio.Utf8;

/* JADX INFO: loaded from: classes4.dex */
public final class MurmurHash3 {
    private static final long C1 = -8663945395140668459L;
    private static final long C2 = 5545529020109919103L;
    private static final int M = 5;
    private static final int N1 = 1390208809;
    private static final int N2 = 944331445;
    private static final int R1 = 31;
    private static final int R2 = 27;
    private static final int R3 = 33;

    public static final class LongPair {
        public long val1;
        public long val2;
    }

    public static int fmix32(int h) {
        int i = (h ^ (h >>> 16)) * (-2048144789);
        int i2 = (i ^ (i >>> 13)) * (-1028477387);
        return i2 ^ (i2 >>> 16);
    }

    public static long fmix64(long k) {
        long j = (k ^ (k >>> 33)) * (-49064778989728563L);
        long j2 = (j ^ (j >>> 33)) * (-4265267296055464877L);
        return j2 ^ (j2 >>> 33);
    }

    public static long getLongLittleEndian(byte[] buf, int offset) {
        return (((long) buf[offset]) & 255) | (((long) buf[offset + 7]) << 56) | ((((long) buf[offset + 6]) & 255) << 48) | ((((long) buf[offset + 5]) & 255) << 40) | ((((long) buf[offset + 4]) & 255) << 32) | ((((long) buf[offset + 3]) & 255) << 24) | ((((long) buf[offset + 2]) & 255) << 16) | ((((long) buf[offset + 1]) & 255) << 8);
    }

    public static long murmurhash3_x86_32(CharSequence data, int offset, int len, int seed) {
        int i = offset + len;
        int i2 = offset;
        int i3 = seed;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i2 < i) {
            int i7 = i2 + 1;
            int iCharAt = data.charAt(i2);
            int i8 = 8;
            if (iCharAt < 128) {
                i2 = i7;
            } else if (iCharAt < 2048) {
                iCharAt = (((iCharAt & 63) | 128) << 8) | (iCharAt >> 6) | 192;
                i2 = i7;
                i8 = 16;
            } else if (iCharAt < 55296 || iCharAt > 57343 || i7 >= i) {
                iCharAt = (((iCharAt & 63) | 128) << 16) | (iCharAt >> 12) | 224 | ((((iCharAt >> 6) & 63) | 128) << 8);
                i2 = i7;
                i8 = 24;
            } else {
                i2 += 2;
                int iCharAt2 = ((iCharAt - Utf8.HIGH_SURROGATE_HEADER) << 10) + (data.charAt(i7) & 1023);
                iCharAt = (((iCharAt2 & 63) | 128) << 24) | (((iCharAt2 >> 18) | PsExtractor.VIDEO_STREAM_MASK) & 255) | ((((iCharAt2 >> 12) & 63) | 128) << 8) | ((((iCharAt2 >> 6) & 63) | 128) << 16);
                i8 = 32;
            }
            i6 |= iCharAt << i4;
            i4 += i8;
            if (i4 >= 32) {
                int i9 = i6 * ScatterMapKt.MurmurHashC1;
                int i10 = i3 ^ (((i9 >>> 17) | (i9 << 15)) * 461845907);
                i3 = (((i10 >>> 19) | (i10 << 13)) * 5) - 430675100;
                i4 -= 32;
                i6 = i4 != 0 ? iCharAt >>> (i8 - i4) : 0;
                i5 += 4;
            }
        }
        if (i4 > 0) {
            i5 += i4 >> 3;
            int i11 = i6 * ScatterMapKt.MurmurHashC1;
            i3 ^= ((i11 << 15) | (i11 >>> 17)) * 461845907;
        }
        int i12 = i3 ^ i5;
        int i13 = (i12 ^ (i12 >>> 16)) * (-2048144789);
        int i14 = (i13 ^ (i13 >>> 13)) * (-1028477387);
        return ((long) (i14 ^ (i14 >>> 16))) & 4294967295L;
    }

    private static long getLittleEndianLong(final byte[] data, final int index) {
        return ((((long) data[index + 7]) & 255) << 56) | (((long) data[index]) & 255) | ((((long) data[index + 1]) & 255) << 8) | ((((long) data[index + 2]) & 255) << 16) | ((((long) data[index + 3]) & 255) << 24) | ((((long) data[index + 4]) & 255) << 32) | ((((long) data[index + 5]) & 255) << 40) | ((((long) data[index + 6]) & 255) << 48);
    }

    public static BigInteger[] unsignedHash128x64(final byte[] data) {
        long[] jArrHash128x64 = hash128x64(data);
        return new BigInteger[]{new BigInteger(Long.toBinaryString(jArrHash128x64[0]), 2), new BigInteger(Long.toBinaryString(jArrHash128x64[1]), 2)};
    }

    public static long[] hash128x64(final byte[] data) {
        return hash128x64(data, 0, data.length, 0L);
    }

    public static long[] hash128x64(final byte[] data, final int offset, final int length, final long seed) {
        char c;
        char c2;
        int i = length >> 4;
        long jRotateLeft = seed;
        long jRotateLeft2 = jRotateLeft;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = offset + (i2 << 4);
            long littleEndianLong = getLittleEndianLong(data, i3);
            long littleEndianLong2 = getLittleEndianLong(data, i3 + 8);
            jRotateLeft = ((Long.rotateLeft(jRotateLeft ^ (Long.rotateLeft(littleEndianLong * C1, 31) * C2), 27) + jRotateLeft2) * 5) + 1390208809;
            jRotateLeft2 = ((Long.rotateLeft(jRotateLeft2 ^ (Long.rotateLeft(littleEndianLong2 * C2, 33) * C1), 31) + jRotateLeft) * 5) + 944331445;
        }
        int i4 = offset + (i << 4);
        long j = 0;
        switch ((offset + length) - i4) {
            case 4:
                j ^= (((long) data[i4 + 3]) & 255) << 24;
            case 3:
                j ^= (((long) data[i4 + 2]) & 255) << 16;
            case 2:
                j ^= (((long) data[i4 + 1]) & 255) << 8;
            case 1:
                jRotateLeft ^= Long.rotateLeft((j ^ ((long) (data[i4] & 255))) * C1, 31) * C2;
                break;
            case 5:
                c = ' ';
                j ^= (((long) data[i4 + 4]) & 255) << c;
                j ^= (((long) data[i4 + 3]) & 255) << 24;
                j ^= (((long) data[i4 + 2]) & 255) << 16;
                j ^= (((long) data[i4 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j ^ ((long) (data[i4] & 255))) * C1, 31) * C2;
                break;
            case 6:
                c2 = '(';
                c = ' ';
                j ^= (((long) data[i4 + 5]) & 255) << c2;
                j ^= (((long) data[i4 + 4]) & 255) << c;
                j ^= (((long) data[i4 + 3]) & 255) << 24;
                j ^= (((long) data[i4 + 2]) & 255) << 16;
                j ^= (((long) data[i4 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j ^ ((long) (data[i4] & 255))) * C1, 31) * C2;
                break;
            case 7:
                c2 = '(';
                c = ' ';
                j ^= (((long) data[i4 + 6]) & 255) << 48;
                j ^= (((long) data[i4 + 5]) & 255) << c2;
                j ^= (((long) data[i4 + 4]) & 255) << c;
                j ^= (((long) data[i4 + 3]) & 255) << 24;
                j ^= (((long) data[i4 + 2]) & 255) << 16;
                j ^= (((long) data[i4 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j ^ ((long) (data[i4] & 255))) * C1, 31) * C2;
                break;
            case 8:
                c2 = '(';
                c = ' ';
                j = (((long) data[i4 + 7]) & 255) << 56;
                j ^= (((long) data[i4 + 6]) & 255) << 48;
                j ^= (((long) data[i4 + 5]) & 255) << c2;
                j ^= (((long) data[i4 + 4]) & 255) << c;
                j ^= (((long) data[i4 + 3]) & 255) << 24;
                j ^= (((long) data[i4 + 2]) & 255) << 16;
                j ^= (((long) data[i4 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j ^ ((long) (data[i4] & 255))) * C1, 31) * C2;
                break;
            case 9:
                c2 = '(';
                c = ' ';
                jRotateLeft2 ^= Long.rotateLeft((j ^ ((long) (data[i4 + 8] & 255))) * C2, 33) * C1;
                j = (((long) data[i4 + 7]) & 255) << 56;
                j ^= (((long) data[i4 + 6]) & 255) << 48;
                j ^= (((long) data[i4 + 5]) & 255) << c2;
                j ^= (((long) data[i4 + 4]) & 255) << c;
                j ^= (((long) data[i4 + 3]) & 255) << 24;
                j ^= (((long) data[i4 + 2]) & 255) << 16;
                j ^= (((long) data[i4 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j ^ ((long) (data[i4] & 255))) * C1, 31) * C2;
                break;
            case 10:
                c2 = '(';
                c = ' ';
                j ^= (((long) data[i4 + 9]) & 255) << 8;
                jRotateLeft2 ^= Long.rotateLeft((j ^ ((long) (data[i4 + 8] & 255))) * C2, 33) * C1;
                j = (((long) data[i4 + 7]) & 255) << 56;
                j ^= (((long) data[i4 + 6]) & 255) << 48;
                j ^= (((long) data[i4 + 5]) & 255) << c2;
                j ^= (((long) data[i4 + 4]) & 255) << c;
                j ^= (((long) data[i4 + 3]) & 255) << 24;
                j ^= (((long) data[i4 + 2]) & 255) << 16;
                j ^= (((long) data[i4 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j ^ ((long) (data[i4] & 255))) * C1, 31) * C2;
                break;
            case 11:
                c2 = '(';
                c = ' ';
                j ^= (((long) data[i4 + 10]) & 255) << 16;
                j ^= (((long) data[i4 + 9]) & 255) << 8;
                jRotateLeft2 ^= Long.rotateLeft((j ^ ((long) (data[i4 + 8] & 255))) * C2, 33) * C1;
                j = (((long) data[i4 + 7]) & 255) << 56;
                j ^= (((long) data[i4 + 6]) & 255) << 48;
                j ^= (((long) data[i4 + 5]) & 255) << c2;
                j ^= (((long) data[i4 + 4]) & 255) << c;
                j ^= (((long) data[i4 + 3]) & 255) << 24;
                j ^= (((long) data[i4 + 2]) & 255) << 16;
                j ^= (((long) data[i4 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j ^ ((long) (data[i4] & 255))) * C1, 31) * C2;
                break;
            case 12:
                c2 = '(';
                c = ' ';
                j ^= (((long) data[i4 + 11]) & 255) << 24;
                j ^= (((long) data[i4 + 10]) & 255) << 16;
                j ^= (((long) data[i4 + 9]) & 255) << 8;
                jRotateLeft2 ^= Long.rotateLeft((j ^ ((long) (data[i4 + 8] & 255))) * C2, 33) * C1;
                j = (((long) data[i4 + 7]) & 255) << 56;
                j ^= (((long) data[i4 + 6]) & 255) << 48;
                j ^= (((long) data[i4 + 5]) & 255) << c2;
                j ^= (((long) data[i4 + 4]) & 255) << c;
                j ^= (((long) data[i4 + 3]) & 255) << 24;
                j ^= (((long) data[i4 + 2]) & 255) << 16;
                j ^= (((long) data[i4 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j ^ ((long) (data[i4] & 255))) * C1, 31) * C2;
                break;
            case 13:
                c2 = '(';
                c = ' ';
                j ^= (((long) data[i4 + 12]) & 255) << c;
                j ^= (((long) data[i4 + 11]) & 255) << 24;
                j ^= (((long) data[i4 + 10]) & 255) << 16;
                j ^= (((long) data[i4 + 9]) & 255) << 8;
                jRotateLeft2 ^= Long.rotateLeft((j ^ ((long) (data[i4 + 8] & 255))) * C2, 33) * C1;
                j = (((long) data[i4 + 7]) & 255) << 56;
                j ^= (((long) data[i4 + 6]) & 255) << 48;
                j ^= (((long) data[i4 + 5]) & 255) << c2;
                j ^= (((long) data[i4 + 4]) & 255) << c;
                j ^= (((long) data[i4 + 3]) & 255) << 24;
                j ^= (((long) data[i4 + 2]) & 255) << 16;
                j ^= (((long) data[i4 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j ^ ((long) (data[i4] & 255))) * C1, 31) * C2;
                break;
            case 14:
                c2 = '(';
                c = ' ';
                j ^= (((long) data[i4 + 13]) & 255) << c2;
                j ^= (((long) data[i4 + 12]) & 255) << c;
                j ^= (((long) data[i4 + 11]) & 255) << 24;
                j ^= (((long) data[i4 + 10]) & 255) << 16;
                j ^= (((long) data[i4 + 9]) & 255) << 8;
                jRotateLeft2 ^= Long.rotateLeft((j ^ ((long) (data[i4 + 8] & 255))) * C2, 33) * C1;
                j = (((long) data[i4 + 7]) & 255) << 56;
                j ^= (((long) data[i4 + 6]) & 255) << 48;
                j ^= (((long) data[i4 + 5]) & 255) << c2;
                j ^= (((long) data[i4 + 4]) & 255) << c;
                j ^= (((long) data[i4 + 3]) & 255) << 24;
                j ^= (((long) data[i4 + 2]) & 255) << 16;
                j ^= (((long) data[i4 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j ^ ((long) (data[i4] & 255))) * C1, 31) * C2;
                break;
            case 15:
                c2 = '(';
                c = ' ';
                j = (((long) data[i4 + 14]) & 255) << 48;
                j ^= (((long) data[i4 + 13]) & 255) << c2;
                j ^= (((long) data[i4 + 12]) & 255) << c;
                j ^= (((long) data[i4 + 11]) & 255) << 24;
                j ^= (((long) data[i4 + 10]) & 255) << 16;
                j ^= (((long) data[i4 + 9]) & 255) << 8;
                jRotateLeft2 ^= Long.rotateLeft((j ^ ((long) (data[i4 + 8] & 255))) * C2, 33) * C1;
                j = (((long) data[i4 + 7]) & 255) << 56;
                j ^= (((long) data[i4 + 6]) & 255) << 48;
                j ^= (((long) data[i4 + 5]) & 255) << c2;
                j ^= (((long) data[i4 + 4]) & 255) << c;
                j ^= (((long) data[i4 + 3]) & 255) << 24;
                j ^= (((long) data[i4 + 2]) & 255) << 16;
                j ^= (((long) data[i4 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j ^ ((long) (data[i4] & 255))) * C1, 31) * C2;
                break;
        }
        long j2 = length;
        long j3 = jRotateLeft ^ j2;
        long j4 = j2 ^ jRotateLeft2;
        long j5 = j3 + j4;
        long j6 = j4 + j5;
        long jFmix64 = fmix64(j5);
        long jFmix65 = fmix64(j6);
        long j7 = jFmix64 + jFmix65;
        return new long[]{j7, jFmix65 + j7};
    }
}
