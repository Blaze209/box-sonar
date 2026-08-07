package sdk.pendo.io.a;

/* JADX INFO: loaded from: classes4.dex */
abstract class b0 {
    final int a;
    final int b;
    final String c;
    final String d;
    final String e;
    final long f;
    int g;

    b0(int i, int i2, String str, String str2, String str3, long j) {
        this.a = i;
        this.b = i2;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = j;
    }

    int a() {
        if (this.g == 0) {
            this.g = d0.b(this.e);
        }
        return this.g;
    }
}
