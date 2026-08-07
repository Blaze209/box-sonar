package sdk.pendo.io.a;

/* JADX INFO: loaded from: classes4.dex */
final class x extends w {
    private final c0 c;
    private final int d;
    private final int e;
    private final int f;
    private int g;
    private final d h;
    private int i;
    private final d j;
    private int k;
    private final d l;
    private int m;
    private final d n;
    private int o;
    private final d p;
    private int q;
    private final d r;
    private int s;

    x(c0 c0Var, int i, int i2, int i3) {
        super(589824);
        this.c = c0Var;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.h = new d();
        this.j = new d();
        this.l = new d();
        this.n = new d();
        this.p = new d();
        this.r = new d();
    }

    @Override // sdk.pendo.io.a.w
    public void a() {
    }

    void a(d dVar) {
        d dVarD = dVar.d(this.c.f("Module")).c(this.h.b + 16 + this.j.b + this.l.b + this.n.b + this.p.b).d(this.d).d(this.e).d(this.f).d(this.g);
        d dVar2 = this.h;
        d dVarD2 = dVarD.a(dVar2.a, 0, dVar2.b).d(this.i);
        d dVar3 = this.j;
        d dVarD3 = dVarD2.a(dVar3.a, 0, dVar3.b).d(this.k);
        d dVar4 = this.l;
        d dVarD4 = dVarD3.a(dVar4.a, 0, dVar4.b).d(this.m);
        d dVar5 = this.n;
        d dVarD5 = dVarD4.a(dVar5.a, 0, dVar5.b).d(this.o);
        d dVar6 = this.p;
        dVarD5.a(dVar6.a, 0, dVar6.b);
        if (this.q > 0) {
            d dVarD6 = dVar.d(this.c.f("ModulePackages")).c(this.r.b + 2).d(this.q);
            d dVar7 = this.r;
            dVarD6.a(dVar7.a, 0, dVar7.b);
        }
        if (this.s > 0) {
            dVar.d(this.c.f("ModuleMainClass")).c(2).d(this.s);
        }
    }

    int b() {
        this.c.f("Module");
        int i = this.h.b + 22 + this.j.b + this.l.b + this.n.b + this.p.b;
        if (this.q > 0) {
            this.c.f("ModulePackages");
            i += this.r.b + 8;
        }
        if (this.s <= 0) {
            return i;
        }
        this.c.f("ModuleMainClass");
        return i + 8;
    }

    int c() {
        return (this.q > 0 ? 1 : 0) + 1 + (this.s > 0 ? 1 : 0);
    }

    @Override // sdk.pendo.io.a.w
    public void b(String str, int i, String... strArr) {
        this.l.d(this.c.d(str).a).d(i);
        d dVar = this.l;
        if (strArr == null) {
            dVar.d(0);
        } else {
            dVar.d(strArr.length);
            for (String str2 : strArr) {
                this.l.d(this.c.c(str2).a);
            }
        }
        this.k++;
    }

    @Override // sdk.pendo.io.a.w
    public void c(String str) {
        this.n.d(this.c.a(str).a);
        this.m++;
    }

    @Override // sdk.pendo.io.a.w
    public void a(String str, int i, String... strArr) {
        this.j.d(this.c.d(str).a).d(i);
        d dVar = this.j;
        if (strArr == null) {
            dVar.d(0);
        } else {
            dVar.d(strArr.length);
            for (String str2 : strArr) {
                this.j.d(this.c.c(str2).a);
            }
        }
        this.i++;
    }

    @Override // sdk.pendo.io.a.w
    public void b(String str) {
        this.r.d(this.c.d(str).a);
        this.q++;
    }

    @Override // sdk.pendo.io.a.w
    public void a(String str) {
        this.s = this.c.a(str).a;
    }

    @Override // sdk.pendo.io.a.w
    public void a(String str, String... strArr) {
        this.p.d(this.c.a(str).a);
        this.p.d(strArr.length);
        for (String str2 : strArr) {
            this.p.d(this.c.a(str2).a);
        }
        this.o++;
    }

    @Override // sdk.pendo.io.a.w
    public void a(String str, int i, String str2) {
        this.h.d(this.c.c(str).a).d(i).d(str2 == null ? 0 : this.c.f(str2));
        this.g++;
    }
}
