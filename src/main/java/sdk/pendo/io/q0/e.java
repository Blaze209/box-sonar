package sdk.pendo.io.q0;

import java.security.Security;
import java.util.Arrays;
import sdk.pendo.io.r0.l;
import sdk.pendo.io.r0.m;
import sdk.pendo.io.r0.n;
import sdk.pendo.io.r0.p;
import sdk.pendo.io.r0.q;
import sdk.pendo.io.r0.r;
import sdk.pendo.io.u0.h;

/* JADX INFO: loaded from: classes4.dex */
public class e {
    private static final sdk.pendo.io.v4.a e = sdk.pendo.io.v4.b.a((Class<?>) e.class);
    private static final e f = new e();
    private d<sdk.pendo.io.u0.f> a;
    private d<p> b;
    private d<sdk.pendo.io.r0.g> c;
    private d<sdk.pendo.io.c1.a> d;

    private e() {
        f();
    }

    public static e b() {
        return f;
    }

    private void f() {
        String property = System.getProperty("java.version");
        String property2 = System.getProperty("java.vendor");
        String property3 = System.getProperty("java.home");
        String string = Arrays.toString(Security.getProviders());
        sdk.pendo.io.v4.a aVar = e;
        aVar.a("Initializing jose4j (running with Java {} from {} at {} with {} security providers installed)...", property, property2, property3, string);
        long jCurrentTimeMillis = System.currentTimeMillis();
        d<sdk.pendo.io.u0.f> dVar = new d<>("alg", sdk.pendo.io.u0.f.class);
        this.a = dVar;
        dVar.b(new h());
        this.a.b(new sdk.pendo.io.u0.d.a());
        this.a.b(new sdk.pendo.io.u0.d.b());
        this.a.b(new sdk.pendo.io.u0.d.c());
        this.a.b(new sdk.pendo.io.u0.c());
        this.a.b(new sdk.pendo.io.u0.b.a());
        this.a.b(new sdk.pendo.io.u0.b.C0494b());
        this.a.b(new sdk.pendo.io.u0.b.c());
        this.a.b(new sdk.pendo.io.u0.b.d());
        this.a.b(new sdk.pendo.io.u0.g.d());
        this.a.b(new sdk.pendo.io.u0.g.e());
        this.a.b(new sdk.pendo.io.u0.g.f());
        this.a.b(new sdk.pendo.io.u0.g.a());
        this.a.b(new sdk.pendo.io.u0.g.b());
        this.a.b(new sdk.pendo.io.u0.g.c());
        aVar.b("JWS signature algorithms: {}", this.a.a());
        d<p> dVar2 = new d<>("alg", p.class);
        this.b = dVar2;
        dVar2.b(new r.a());
        this.b.b(new r.c());
        this.b.b(new r.b());
        this.b.b(new l());
        this.b.b(new sdk.pendo.io.r0.d.a());
        this.b.b(new sdk.pendo.io.r0.d.b());
        this.b.b(new sdk.pendo.io.r0.d.c());
        this.b.b(new m());
        this.b.b(new n.a());
        this.b.b(new n.b());
        this.b.b(new n.c());
        this.b.b(new q.a());
        this.b.b(new q.b());
        this.b.b(new q.c());
        this.b.b(new sdk.pendo.io.r0.c.a());
        this.b.b(new sdk.pendo.io.r0.c.b());
        this.b.b(new sdk.pendo.io.r0.c.C0470c());
        aVar.b("JWE key management algorithms: {}", this.b.a());
        d<sdk.pendo.io.r0.g> dVar3 = new d<>("enc", sdk.pendo.io.r0.g.class);
        this.c = dVar3;
        dVar3.b(new sdk.pendo.io.r0.a.C0468a());
        this.c.b(new sdk.pendo.io.r0.a.b());
        this.c.b(new sdk.pendo.io.r0.a.c());
        this.c.b(new sdk.pendo.io.r0.b.a());
        this.c.b(new sdk.pendo.io.r0.b.C0469b());
        this.c.b(new sdk.pendo.io.r0.b.c());
        aVar.b("JWE content encryption algorithms: {}", this.c.a());
        d<sdk.pendo.io.c1.a> dVar4 = new d<>("zip", sdk.pendo.io.c1.a.class);
        this.d = dVar4;
        dVar4.b(new sdk.pendo.io.c1.b());
        aVar.b("JWE compression algorithms: {}", this.d.a());
        aVar.b("Initialized jose4j in {}ms", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
    }

    public d<sdk.pendo.io.c1.a> a() {
        return this.d;
    }

    public d<sdk.pendo.io.r0.g> c() {
        return this.c;
    }

    public d<p> d() {
        return this.b;
    }

    public d<sdk.pendo.io.u0.f> e() {
        return this.a;
    }
}
