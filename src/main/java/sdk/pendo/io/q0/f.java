package sdk.pendo.io.q0;

import sdk.pendo.io.y0.h;

/* JADX INFO: loaded from: classes4.dex */
public abstract class f implements a {
    protected final sdk.pendo.io.v4.a a = sdk.pendo.io.v4.b.a(getClass());
    private String b;
    private String c;
    private h d;
    private String e;

    @Override // sdk.pendo.io.q0.a
    public h a() {
        return this.d;
    }

    public void b(String str) {
        this.c = str;
    }

    @Override // sdk.pendo.io.q0.a
    public String c() {
        return this.b;
    }

    public String e() {
        return this.c;
    }

    public String toString() {
        return getClass().getName() + "(" + this.b + "|" + this.c + ")";
    }

    public void a(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.e = str;
    }

    public void a(h hVar) {
        this.d = hVar;
    }
}
