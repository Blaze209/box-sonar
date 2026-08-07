package sdk.pendo.io.k0;

import sdk.pendo.io.a1.j;

/* JADX INFO: loaded from: classes4.dex */
public class b {
    private sdk.pendo.io.l0.a a = new sdk.pendo.io.l0.a(-1, null, true);

    public static byte[] d(String str) {
        return a().a(str);
    }

    public byte[] a(String str) {
        return this.a.a(str);
    }

    public String b(String str) {
        return a(str, "UTF-8");
    }

    public String c(String str) {
        return b(str, "UTF-8");
    }

    public String a(String str, String str2) {
        return j.a(a(str), str2);
    }

    public String b(String str, String str2) {
        return a(j.a(str, str2));
    }

    public static String b(byte[] bArr) {
        return a().a(bArr);
    }

    public String a(byte[] bArr) {
        return this.a.d(bArr);
    }

    private static b a() {
        return new b();
    }
}
