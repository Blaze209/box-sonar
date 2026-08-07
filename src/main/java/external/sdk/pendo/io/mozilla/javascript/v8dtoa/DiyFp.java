package external.sdk.pendo.io.mozilla.javascript.v8dtoa;

import cz.msebera.android.httpclient.impl.client.cache.CacheValidityPolicy;

/* JADX INFO: loaded from: classes4.dex */
class DiyFp {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int kSignificandSize = 64;
    static final long kUint64MSB = Long.MIN_VALUE;
    private int e;
    private long f;

    DiyFp() {
        this.f = 0L;
        this.e = 0;
    }

    static DiyFp minus(DiyFp diyFp, DiyFp diyFp2) {
        DiyFp diyFp3 = new DiyFp(diyFp.f, diyFp.e);
        diyFp3.subtract(diyFp2);
        return diyFp3;
    }

    static DiyFp normalize(DiyFp diyFp) {
        DiyFp diyFp2 = new DiyFp(diyFp.f, diyFp.e);
        diyFp2.normalize();
        return diyFp2;
    }

    static DiyFp times(DiyFp diyFp, DiyFp diyFp2) {
        DiyFp diyFp3 = new DiyFp(diyFp.f, diyFp.e);
        diyFp3.multiply(diyFp2);
        return diyFp3;
    }

    private static boolean uint64_gte(long j, long j2) {
        if (j != j2) {
            if (!(((j < 0) ^ (j > j2)) ^ (j2 < 0))) {
                return false;
            }
        }
        return true;
    }

    int e() {
        return this.e;
    }

    long f() {
        return this.f;
    }

    void multiply(DiyFp diyFp) {
        long j = this.f;
        long j2 = j >>> 32;
        long j3 = j & 4294967295L;
        long j4 = diyFp.f;
        long j5 = j4 >>> 32;
        long j6 = j4 & 4294967295L;
        long j7 = j2 * j5;
        long j8 = j5 * j3;
        long j9 = j2 * j6;
        long j10 = j7 + (j9 >>> 32) + (j8 >>> 32) + ((((((j3 * j6) >>> 32) + (j9 & 4294967295L)) + (4294967295L & j8)) + CacheValidityPolicy.MAX_AGE) >>> 32);
        this.e += diyFp.e + 64;
        this.f = j10;
    }

    void setE(int i) {
        this.e = i;
    }

    void setF(long j) {
        this.f = j;
    }

    void subtract(DiyFp diyFp) {
        this.f -= diyFp.f;
    }

    public String toString() {
        return "[DiyFp f:" + this.f + ", e:" + this.e + "]";
    }

    DiyFp(long j, int i) {
        this.f = j;
        this.e = i;
    }

    void normalize() {
        long j = this.f;
        int i = this.e;
        while (((-18014398509481984L) & j) == 0) {
            j <<= 10;
            i -= 10;
        }
        while ((Long.MIN_VALUE & j) == 0) {
            j <<= 1;
            i--;
        }
        this.f = j;
        this.e = i;
    }
}
