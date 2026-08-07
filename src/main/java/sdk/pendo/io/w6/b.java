package sdk.pendo.io.w6;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.k3.j;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.q3.e;

/* JADX INFO: loaded from: classes5.dex */
public final class b {
    private static final b b = new b();
    private final sdk.pendo.io.j4.a<c> a;

    class a implements ComponentCallbacks2 {
        a() {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i) {
            PendoLogger.d("Test = level = " + i, new Object[0]);
            if (i >= 20) {
                b.this.a.onNext(c.IN_BACKGROUND);
            }
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.w6.b$b, reason: collision with other inner class name */
    class C0514b implements e<c> {
        C0514b() {
        }

        @Override // sdk.pendo.io.q3.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(c cVar) {
            PendoLogger.d("AppFlow: " + cVar.name(), new Object[0]);
        }
    }

    public enum c {
        IN_BACKGROUND(sdk.pendo.io.r5.d.APP_IN_BACKGROUND),
        IN_FOREGROUND(sdk.pendo.io.r5.d.APP_IN_FOREGROUND);

        public final sdk.pendo.io.r5.d event;

        c(sdk.pendo.io.r5.d dVar) {
            this.event = dVar;
        }

        public String b() {
            return this.event.b();
        }
    }

    private b() {
        sdk.pendo.io.j4.a<c> aVarB = sdk.pendo.io.j4.a.b(c.IN_FOREGROUND);
        this.a = aVarB;
        Context contextO = PendoInternal.o();
        if (contextO != null) {
            contextO.registerComponentCallbacks(new a());
        }
        aVarB.a(sdk.pendo.io.t6.d.a(new C0514b(), "ApplicationFlowManager app flow state observer"));
    }

    public static synchronized b e() {
        return b;
    }

    public void a() {
        this.a.onNext(c.IN_BACKGROUND);
    }

    public void b() {
        this.a.onNext(c.IN_FOREGROUND);
    }

    public j<c> c() {
        return a(false);
    }

    public c d() {
        return this.a.n();
    }

    public boolean f() {
        return c.IN_BACKGROUND.equals(d());
    }

    public j<c> a(boolean z) {
        sdk.pendo.io.j4.a<c> aVar = this.a;
        return z ? aVar.d() : aVar;
    }
}
