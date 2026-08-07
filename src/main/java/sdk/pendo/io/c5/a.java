package sdk.pendo.io.c5;

import com.microsoft.identity.client.internal.MsalUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends sdk.pendo.io.b5.d {
    private static final Logger p = Logger.getLogger(a.class.getName());
    private boolean o;

    /* JADX INFO: renamed from: sdk.pendo.io.c5.a$a, reason: collision with other inner class name */
    class RunnableC0359a implements Runnable {
        final /* synthetic */ Runnable a;

        /* JADX INFO: renamed from: sdk.pendo.io.c5.a$a$a, reason: collision with other inner class name */
        class RunnableC0360a implements Runnable {
            final /* synthetic */ a a;

            RunnableC0360a(a aVar) {
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.p.fine("paused");
                ((sdk.pendo.io.b5.d) this.a).l = sdk.pendo.io.b5.d.e.PAUSED;
                RunnableC0359a.this.a.run();
            }
        }

        /* JADX INFO: renamed from: sdk.pendo.io.c5.a$a$b */
        class b implements sdk.pendo.io.a5.a.InterfaceC0343a {
            final /* synthetic */ int[] a;
            final /* synthetic */ Runnable b;

            b(int[] iArr, Runnable runnable) {
                this.a = iArr;
                this.b = runnable;
            }

            @Override // sdk.pendo.io.a5.a.InterfaceC0343a
            public void call(Object... objArr) {
                a.p.fine("pre-pause polling complete");
                int[] iArr = this.a;
                int i = iArr[0] - 1;
                iArr[0] = i;
                if (i == 0) {
                    this.b.run();
                }
            }
        }

        /* JADX INFO: renamed from: sdk.pendo.io.c5.a$a$c */
        class c implements sdk.pendo.io.a5.a.InterfaceC0343a {
            final /* synthetic */ int[] a;
            final /* synthetic */ Runnable b;

            c(int[] iArr, Runnable runnable) {
                this.a = iArr;
                this.b = runnable;
            }

            @Override // sdk.pendo.io.a5.a.InterfaceC0343a
            public void call(Object... objArr) {
                a.p.fine("pre-pause writing complete");
                int[] iArr = this.a;
                int i = iArr[0] - 1;
                iArr[0] = i;
                if (i == 0) {
                    this.b.run();
                }
            }
        }

        RunnableC0359a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            ((sdk.pendo.io.b5.d) aVar).l = sdk.pendo.io.b5.d.e.PAUSED;
            RunnableC0360a runnableC0360a = new RunnableC0360a(aVar);
            a aVar2 = a.this;
            boolean z = aVar2.o;
            if (!z && aVar2.b) {
                runnableC0360a.run();
                return;
            }
            int[] iArr = {0};
            if (z) {
                a.p.fine("we are currently polling - waiting to pause");
                iArr[0] = iArr[0] + 1;
                a.this.c("pollComplete", new b(iArr, runnableC0360a));
            }
            if (a.this.b) {
                return;
            }
            a.p.fine("we are currently writing - waiting to pause");
            iArr[0] = iArr[0] + 1;
            a.this.c("drain", new c(iArr, runnableC0360a));
        }
    }

    class b implements sdk.pendo.io.d5.c.e {
        final /* synthetic */ a a;

        b(a aVar) {
            this.a = aVar;
        }

        @Override // sdk.pendo.io.d5.c.e
        public boolean a(sdk.pendo.io.d5.b bVar, int i, int i2) {
            if (((sdk.pendo.io.b5.d) this.a).l == sdk.pendo.io.b5.d.e.OPENING) {
                this.a.f();
            }
            boolean zEquals = HeaderElements.CLOSE.equals(bVar.a);
            a aVar = this.a;
            if (zEquals) {
                aVar.e();
                return false;
            }
            aVar.a(bVar);
            return true;
        }
    }

    class c implements sdk.pendo.io.a5.a.InterfaceC0343a {
        final /* synthetic */ a a;

        c(a aVar) {
            this.a = aVar;
        }

        @Override // sdk.pendo.io.a5.a.InterfaceC0343a
        public void call(Object... objArr) {
            a.p.fine("writing close packet");
            try {
                this.a.b(new sdk.pendo.io.d5.b[]{new sdk.pendo.io.d5.b(HeaderElements.CLOSE)});
            } catch (sdk.pendo.io.j5.b e) {
                throw new RuntimeException(e);
            }
        }
    }

    class d implements Runnable {
        final /* synthetic */ a a;

        d(a aVar) {
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.a;
            aVar.b = true;
            aVar.a("drain", new Object[0]);
        }
    }

    class e implements sdk.pendo.io.d5.c.f {
        final /* synthetic */ a a;
        final /* synthetic */ Runnable b;

        e(a aVar, Runnable runnable) {
            this.a = aVar;
            this.b = runnable;
        }

        @Override // sdk.pendo.io.d5.c.f
        public void a(Object obj) {
            if (obj instanceof byte[]) {
                this.a.a((byte[]) obj, this.b);
            } else if (obj instanceof String) {
                this.a.a((String) obj, this.b);
            } else {
                a.p.warning("Unexpected data: " + obj);
            }
        }
    }

    public a(sdk.pendo.io.b5.d.C0355d c0355d) {
        super(c0355d);
        this.c = "polling";
    }

    private void a(Object obj) {
        Logger logger = p;
        Level level = Level.FINE;
        if (logger.isLoggable(level)) {
            logger.fine(String.format("polling got data %s", obj));
        }
        b bVar = new b(this);
        if (obj instanceof String) {
            sdk.pendo.io.d5.c.a((String) obj, bVar);
        } else if (obj instanceof byte[]) {
            sdk.pendo.io.d5.c.a((byte[]) obj, bVar);
        }
        if (this.l != sdk.pendo.io.b5.d.e.CLOSED) {
            this.o = false;
            a("pollComplete", new Object[0]);
            if (this.l == sdk.pendo.io.b5.d.e.OPEN) {
                i();
            } else if (logger.isLoggable(level)) {
                logger.fine(String.format("ignoring poll - transport state '%s'", this.l));
            }
        }
    }

    private void i() {
        p.fine("polling");
        this.o = true;
        h();
        a("poll", new Object[0]);
    }

    protected abstract void a(String str, Runnable runnable);

    protected abstract void a(byte[] bArr, Runnable runnable);

    @Override // sdk.pendo.io.b5.d
    protected void d() {
        i();
    }

    protected abstract void h();

    protected String j() {
        Map map = this.d;
        if (map == null) {
            map = new HashMap();
        }
        String str = this.e ? "https" : "http";
        if (this.f) {
            map.put(this.j, sdk.pendo.io.k5.a.a());
        }
        String strA = sdk.pendo.io.g5.a.a((Map<String, String>) map);
        String str2 = (this.g <= 0 || ((!"https".equals(str) || this.g == 443) && (!"http".equals(str) || this.g == 80))) ? "" : ":" + this.g;
        if (strA.length() > 0) {
            strA = MsalUtils.QUERY_STRING_SYMBOL + strA;
        }
        return str + "://" + (this.i.contains(":") ? "[" + this.i + "]" : this.i) + str2 + this.h + strA;
    }

    @Override // sdk.pendo.io.b5.d
    protected void c() {
        c cVar = new c(this);
        if (this.l == sdk.pendo.io.b5.d.e.OPEN) {
            p.fine("transport open - closing");
            cVar.call(new Object[0]);
        } else {
            p.fine("transport not open - deferring close");
            c("open", cVar);
        }
    }

    @Override // sdk.pendo.io.b5.d
    protected void b(String str) {
        a((Object) str);
    }

    @Override // sdk.pendo.io.b5.d
    protected void b(sdk.pendo.io.d5.b[] bVarArr) {
        this.b = false;
        sdk.pendo.io.d5.c.a(bVarArr, new e(this, new d(this)));
    }

    @Override // sdk.pendo.io.b5.d
    protected void a(byte[] bArr) {
        a((Object) bArr);
    }

    public void a(Runnable runnable) {
        sdk.pendo.io.i5.a.a(new RunnableC0359a(runnable));
    }
}
