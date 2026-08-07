package sdk.pendo.io.d6;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.q3.e;
import sdk.pendo.io.q3.h;
import sdk.pendo.io.q3.j;
import sdk.pendo.io.s7.g0;
import sdk.pendo.io.s7.t0;
import sdk.pendo.io.t4.f;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements d {
    private static volatile c g;
    private final sdk.pendo.io.j4.a<Boolean> b = sdk.pendo.io.j4.a.b(Boolean.FALSE);
    private final sdk.pendo.io.j4.a<sdk.pendo.io.t4.a> c = sdk.pendo.io.j4.a.m();
    private final sdk.pendo.io.j4.a<ArrayList<Activity>> d = sdk.pendo.io.j4.a.b(new ArrayList());
    private final sdk.pendo.io.j4.a<g0<Activity>> e = sdk.pendo.io.j4.a.b(new g0(null));
    private final AtomicBoolean f = new AtomicBoolean(false);
    private final sdk.pendo.io.t6.b a = new sdk.pendo.io.t6.b(e(), d(), c());

    class a implements h<List<Activity>, Activity> {
        a() {
        }

        @Override // sdk.pendo.io.q3.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Activity apply(List<Activity> list) {
            return list.get(list.size() - 1);
        }
    }

    class b implements j<List<Activity>> {
        b() {
        }

        @Override // sdk.pendo.io.q3.j
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean test(List<Activity> list) {
            return (list == null || list.isEmpty()) ? false : true;
        }
    }

    private c() {
        b().a(new e() { // from class: sdk.pendo.io.d6.c$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                this.f$0.a((t0) obj);
            }
        }, new e() { // from class: sdk.pendo.io.d6.c$$ExternalSyntheticLambda1
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                c.a((Throwable) obj);
            }
        });
    }

    public static synchronized c h() {
        if (g == null) {
            g = new c();
        }
        return g;
    }

    public synchronized void a(Activity activity) {
        if (!this.f.getAndSet(false)) {
            ArrayList<Activity> arrayListN = this.d.n();
            arrayListN.add(activity);
            this.d.onNext(arrayListN);
        }
    }

    public sdk.pendo.io.k3.j<t0> b() {
        return j().a(new sdk.pendo.io.r6.a(sdk.pendo.io.t4.a.CREATE)).c(new h() { // from class: sdk.pendo.io.d6.c$$ExternalSyntheticLambda2
            @Override // sdk.pendo.io.q3.h
            public final Object apply(Object obj) {
                return c.b((sdk.pendo.io.t4.a) obj);
            }
        });
    }

    public sdk.pendo.io.k3.j<sdk.pendo.io.t4.a> c() {
        return j().a(new sdk.pendo.io.r6.a(sdk.pendo.io.t4.a.DESTROY));
    }

    public sdk.pendo.io.k3.j<sdk.pendo.io.t4.a> d() {
        return j().a(new sdk.pendo.io.r6.a(sdk.pendo.io.t4.a.PAUSE));
    }

    public sdk.pendo.io.k3.j<sdk.pendo.io.t4.a> e() {
        return j().a(new sdk.pendo.io.r6.a(sdk.pendo.io.t4.a.RESUME));
    }

    public List<Activity> f() {
        return this.d.n();
    }

    public String g() {
        Activity activityA = a();
        if (activityA == null) {
            return null;
        }
        return activityA.getLocalClassName();
    }

    public synchronized Activity i() {
        return this.e.n().a();
    }

    public sdk.pendo.io.k3.j<sdk.pendo.io.t4.a> j() {
        return this.c;
    }

    public synchronized void k() {
        this.f.set(true);
    }

    public void l() {
        this.a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ t0 b(sdk.pendo.io.t4.a aVar) {
        return new t0();
    }

    public sdk.pendo.io.k3.j<Activity> a(sdk.pendo.io.t4.a aVar) {
        return this.d.a(new b()).c(new a()).a(f.a(this.c, aVar));
    }

    public void c(sdk.pendo.io.t4.a aVar) {
        this.c.onNext(aVar);
    }

    @Override // sdk.pendo.io.d6.d
    public synchronized Activity a() {
        ArrayList<Activity> arrayListN = this.d.n();
        int size = arrayListN.size() - 1;
        if (size < 0) {
            return null;
        }
        return arrayListN.get(size);
    }

    public synchronized void b(Activity activity) {
        if (!this.f.getAndSet(false)) {
            ArrayList<Activity> arrayListN = this.d.n();
            arrayListN.remove(activity);
            if (arrayListN.isEmpty()) {
                this.e.onNext(new g0<>(activity));
            }
            this.d.onNext(arrayListN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(t0 t0Var) {
        this.b.onNext(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Throwable th) {
        PendoLogger.w(th, "First Activity on create observable error", new Object[0]);
    }

    public synchronized void a(String str) {
        g0<Activity> g0VarN = this.e.n();
        if (!g0VarN.getIsEmpty() && g0VarN.a().getLocalClassName().equals(str)) {
            this.e.onNext(new g0<>(null));
        }
    }
}
