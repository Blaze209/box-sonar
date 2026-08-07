package sdk.pendo.io.y0;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class b {
    public static BigInteger a(String str) {
        return a(new sdk.pendo.io.k0.b().a(str));
    }

    public static byte[] b(BigInteger bigInteger) {
        if (bigInteger.signum() < 0) {
            throw new IllegalArgumentException("Cannot convert negative values to an unsigned magnitude byte array: " + bigInteger);
        }
        byte[] byteArray = bigInteger.toByteArray();
        return (bigInteger.bitLength() % 8 == 0 && byteArray[0] == 0 && byteArray.length > 1) ? sdk.pendo.io.a1.a.a(byteArray, 1, byteArray.length - 1) : byteArray;
    }

    public static BigInteger a(byte[] bArr) {
        return new BigInteger(1, bArr);
    }

    public static byte[] b(BigInteger bigInteger, int i) {
        byte[] bArrB = b(bigInteger);
        return i > bArrB.length ? sdk.pendo.io.a1.a.a(new byte[i - bArrB.length], bArrB) : bArrB;
    }

    public static String a(BigInteger bigInteger) {
        return new sdk.pendo.io.k0.b().a(b(bigInteger));
    }

    public static String a(BigInteger bigInteger, int i) {
        return new sdk.pendo.io.k0.b().a(b(bigInteger, i));
    }
}
