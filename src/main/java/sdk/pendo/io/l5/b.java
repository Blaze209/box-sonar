package sdk.pendo.io.l5;

import java.util.concurrent.Executor;
import sdk.pendo.io.l5.i;

/* JADX INFO: loaded from: classes4.dex */
public class b<C extends i> {
    private final h a;
    private k b;
    private Executor c;
    private final g d;
    private boolean e;
    private e f;

    public class a implements sdk.pendo.io.m5.c<i> {
        public a() {
        }

        @Override // sdk.pendo.io.m5.c
        public void a(sdk.pendo.io.n5.b bVar, i iVar) {
            String str = "Execution Error in StateHolder [" + bVar.c() + "] ";
            if (bVar.b() != null) {
                str = str + "on EventHolder [" + bVar.b() + "] ";
            }
            b.this.f.a("Error", new Exception(str + "with Context [" + bVar.a() + "] ", bVar));
        }
    }

    protected b(h hVar) {
        g gVar = new g();
        this.d = gVar;
        this.e = false;
        this.f = new f();
        this.a = hVar;
        gVar.a(g.a.ERROR, (h) null, (c) null, new a());
    }

    private void b(h hVar, C c) {
        if (c.c()) {
            return;
        }
        try {
            if (b()) {
                this.f.a("when enter %s for %s <<<", hVar, c);
            }
            this.d.b(hVar, c);
            if (b()) {
                this.f.a("when enter %s for %s >>>", hVar, c);
            }
            if (this.b.a(hVar)) {
                a(hVar, c);
            }
        } catch (Exception e) {
            a(new sdk.pendo.io.n5.b(hVar, null, e, "Execution Error in [whenEnter] handler", c));
        }
    }

    private void c(h hVar, C c) {
        if (c.c()) {
            return;
        }
        try {
            if (b()) {
                this.f.a("when leave %s for %s <<<", hVar, c);
            }
            this.d.c(hVar, c);
            if (b()) {
                this.f.a("when leave %s for %s >>>", hVar, c);
            }
        } catch (Exception e) {
            a(new sdk.pendo.io.n5.b(hVar, null, e, "Execution Error in [whenLeave] handler", c));
        }
    }

    protected void a(sdk.pendo.io.n5.b bVar) {
        this.d.a(bVar);
        a(bVar.c(), bVar.a());
    }

    private void c() {
        if (this.c == null) {
            this.c = new sdk.pendo.io.l5.a();
        }
    }

    protected void a(h hVar, C c) {
        if (c.c()) {
            return;
        }
        try {
            if (b()) {
                this.f.a("terminating context %s", c);
            }
            c.e();
            this.d.a(hVar, c);
        } catch (Exception e) {
            this.f.a("Execution Error in [whenTerminate] handler", e);
        }
    }

    protected boolean b() {
        return this.e;
    }

    protected void a(Runnable runnable, C c) {
        if (c.c()) {
            return;
        }
        this.c.execute(runnable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C1 extends i> b<C1> b(h hVar, sdk.pendo.io.m5.a<C1> aVar) {
        this.d.a(g.a.STATE_LEAVE, hVar, (c) null, aVar);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C1 extends i> b<C1> a(Executor executor) {
        this.c = executor;
        return this;
    }

    protected h a() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z, i iVar, h hVar) {
        h hVarB;
        if (!z && (hVarB = iVar.b()) != null) {
            c(hVarB, iVar);
        }
        iVar.a(hVar);
        b(hVar, iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(j jVar, c cVar, h hVar, i iVar) {
        try {
            h hVarD = jVar.d();
            if (b()) {
                this.f.a("when triggered %s in %s for %s <<<", cVar, hVar, iVar);
            }
            this.d.a(cVar, hVar, hVarD, iVar);
            iVar.a(cVar);
            if (b()) {
                this.f.a("when triggered %s in %s for %s >>>", cVar, hVar, iVar);
            }
            a(hVarD, false, iVar);
        } catch (Exception e) {
            a(new sdk.pendo.io.n5.b(hVar, cVar, e, "Execution Error in [trigger]", iVar));
        }
    }

    protected void a(boolean z) {
        this.b = new k(j.a(), !z);
    }

    public boolean a(c cVar, C c) {
        try {
            return a(cVar, true, (i) c);
        } catch (sdk.pendo.io.n5.c unused) {
            return false;
        }
    }

    protected void a(final h hVar, final boolean z, final C c) {
        a(new Runnable() { // from class: sdk.pendo.io.l5.b$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(z, c, hVar);
            }
        }, c);
    }

    public void a(boolean z, C c) {
        h hVarB;
        boolean z2;
        c();
        c.a(this);
        if (c.b() == null) {
            hVarB = this.a;
            z2 = false;
        } else {
            if (!z) {
                return;
            }
            hVarB = c.b();
            z2 = true;
        }
        a(hVarB, z2, c);
    }

    private boolean a(final c cVar, boolean z, final C c) throws sdk.pendo.io.n5.c {
        if (c.c()) {
            return false;
        }
        final h hVarB = c.b();
        final j jVarA = this.b.a(hVarB, cVar);
        if (jVarA != null) {
            a(new Runnable() { // from class: sdk.pendo.io.l5.b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(jVarA, cVar, hVarB, c);
                }
            }, c);
        } else if (!z) {
            throw new sdk.pendo.io.n5.c("Invalid Event: " + cVar + " triggered while in State: " + c.b() + " for " + c);
        }
        return jVarA != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C1 extends i> b<C1> a(h hVar, sdk.pendo.io.m5.a<C1> aVar) {
        this.d.a(g.a.STATE_ENTER, hVar, (c) null, aVar);
        return this;
    }
}
