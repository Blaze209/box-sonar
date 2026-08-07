package sdk.pendo.io.s0;

import sdk.pendo.io.a1.j;

/* JADX INFO: loaded from: classes5.dex */
public class d {
    private sdk.pendo.io.k0.b a = new sdk.pendo.io.k0.b();
    private c b;

    public d(String str) {
        this.b = b.a(str);
    }

    byte[] a(String str) {
        return a(this.a.a(str));
    }

    public byte[] a(byte[] bArr, int i, String str, String str2, String str3) {
        return this.b.a(bArr, i, sdk.pendo.io.a1.a.a(a(j.b(str)), a(str2), a(str3), sdk.pendo.io.a1.a.c(i), sdk.pendo.io.a1.a.a));
    }

    byte[] a(byte[] bArr) {
        if (bArr == null) {
            bArr = sdk.pendo.io.a1.a.a;
        }
        return sdk.pendo.io.a1.a.a(sdk.pendo.io.a1.a.c(bArr.length), bArr);
    }
}
