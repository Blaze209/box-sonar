package sdk.pendo.io.y4;

import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class a {
    private long a = 100;
    private long b = 10000;
    private int c = 2;
    private double d;
    private int e;

    public long a() {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(this.a);
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(this.c);
        int i = this.e;
        this.e = i + 1;
        BigInteger bigIntegerMultiply = bigIntegerValueOf.multiply(bigIntegerValueOf2.pow(i));
        if (this.d != 0.0d) {
            double dRandom = Math.random();
            BigInteger bigInteger = BigDecimal.valueOf(dRandom).multiply(BigDecimal.valueOf(this.d)).multiply(new BigDecimal(bigIntegerMultiply)).toBigInteger();
            bigIntegerMultiply = (((int) Math.floor(dRandom * 10.0d)) & 1) == 0 ? bigIntegerMultiply.subtract(bigInteger) : bigIntegerMultiply.add(bigInteger);
        }
        return bigIntegerMultiply.min(BigInteger.valueOf(this.b)).longValue();
    }

    public int b() {
        return this.e;
    }

    public void c() {
        this.e = 0;
    }

    public a a(double d) {
        this.d = d;
        return this;
    }

    public a b(long j) {
        this.a = j;
        return this;
    }

    public a a(long j) {
        this.b = j;
        return this;
    }
}
