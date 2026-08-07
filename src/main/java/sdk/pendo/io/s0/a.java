package sdk.pendo.io.s0;

import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes5.dex */
public class a implements c {
    private static final sdk.pendo.io.v4.a c = sdk.pendo.io.v4.b.a((Class<?>) a.class);
    private int a;
    private MessageDigest b;

    public a(String str, String str2) {
        this.b = sdk.pendo.io.a1.c.a(str, str2);
        a();
    }

    private boolean b() {
        return false;
    }

    long a(int i) {
        return (int) Math.ceil(i / this.a);
    }

    private void a() {
        this.a = sdk.pendo.io.a1.a.a(this.b.getDigestLength());
        if (b()) {
            c.b("Hash Algorithm: {} with hashlen: {} bits", this.b.getAlgorithm(), Integer.valueOf(this.a));
        }
    }

    @Override // sdk.pendo.io.s0.c
    public byte[] a(byte[] bArr, int i, byte[] bArr2) {
        long jA = a(i);
        if (b()) {
            sdk.pendo.io.v4.a aVar = c;
            aVar.a("reps: {}", String.valueOf(jA));
            aVar.a("otherInfo: {}", sdk.pendo.io.a1.a.f(bArr2));
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i2 = 1; i2 <= jA; i2++) {
            byte[] bArrC = sdk.pendo.io.a1.a.c(i2);
            if (b()) {
                sdk.pendo.io.v4.a aVar2 = c;
                aVar2.a("rep {} hashing ", Integer.valueOf(i2));
                aVar2.a(" counter: {}", sdk.pendo.io.a1.a.f(bArrC));
                aVar2.a(" z: {}", sdk.pendo.io.a1.a.f(bArr));
                aVar2.a(" otherInfo: {}", sdk.pendo.io.a1.a.f(bArr2));
            }
            this.b.update(bArrC);
            this.b.update(bArr);
            this.b.update(bArr2);
            byte[] bArrDigest = this.b.digest();
            if (b()) {
                c.b(" k({}): {}", Integer.valueOf(i2), sdk.pendo.io.a1.a.f(bArrDigest));
            }
            byteArrayOutputStream.write(bArrDigest, 0, bArrDigest.length);
        }
        int iB = sdk.pendo.io.a1.a.b(i);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (b()) {
            c.a("derived key material: {}", sdk.pendo.io.a1.a.f(byteArray));
        }
        if (byteArray.length != iB) {
            byteArray = sdk.pendo.io.a1.a.a(byteArray, 0, iB);
            if (b()) {
                c.b("first {} bits of derived key material: {}", Integer.valueOf(i), sdk.pendo.io.a1.a.f(byteArray));
            }
        }
        if (b()) {
            c.a("final derived key material: {}", sdk.pendo.io.a1.a.f(byteArray));
        }
        return byteArray;
    }
}
