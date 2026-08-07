package sdk.pendo.io.a1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    public static final byte[] a = new byte[0];

    public static int a(byte b) {
        return b >= 0 ? b : 256 - (~(b - 1));
    }

    public static int a(int i) {
        if (i > 268435455 || i < 0) {
            throw new k("Invalid byte length (" + i + ") for converting to bit length");
        }
        return i * 8;
    }

    public static int b(int i) {
        return i / 8;
    }

    public static byte[] c(int i) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.putInt(i);
        return byteBufferAllocate.array();
    }

    public static byte[] d(int i) {
        return a(i, (SecureRandom) null);
    }

    public static byte[] e(byte[] bArr) {
        int length = bArr.length / 2;
        return a(bArr, length, length);
    }

    public static String f(byte[] bArr) {
        String strA = new sdk.pendo.io.k0.b().a(bArr);
        int[] iArrB = b(bArr);
        return Arrays.toString(iArrB) + "(" + iArrB.length + "bytes/" + a(iArrB.length) + "bits) | base64url encoded: " + strA;
    }

    public static int a(byte[] bArr) {
        return a(bArr.length);
    }

    public static int[] b(byte[] bArr) {
        int[] iArr = new int[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            iArr[i] = a(bArr[i]);
        }
        return iArr;
    }

    public static byte[] c(byte[] bArr) {
        return a(bArr, 0, bArr.length / 2);
    }

    public static byte[] d(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[(length - 1) - i] = bArr[i];
        }
        return bArr2;
    }

    public static byte[] a(byte[]... bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (byte[] bArr2 : bArr) {
                byteArrayOutputStream.write(bArr2);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new IllegalStateException("IOEx from ByteArrayOutputStream?!", e);
        }
    }

    public static byte[] a(long j) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.putLong(j);
        return byteBufferAllocate.array();
    }

    public static byte[] a(int i, SecureRandom secureRandom) {
        if (secureRandom == null) {
            secureRandom = new SecureRandom();
        }
        byte[] bArr = new byte[i];
        secureRandom.nextBytes(bArr);
        return bArr;
    }

    public static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            bArr = a;
        }
        if (bArr2 == null) {
            bArr2 = a;
        }
        int iMin = Math.min(bArr.length, bArr2.length);
        int iMax = Math.max(bArr.length, bArr2.length);
        int i = 0;
        for (int i2 = 0; i2 < iMin; i2++) {
            i |= bArr[i2] ^ bArr2[i2];
        }
        return i == 0 && iMin == iMax;
    }

    public static byte[] a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }
}
