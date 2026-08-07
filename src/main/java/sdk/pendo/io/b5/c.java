package sdk.pendo.io.b5;

import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.hc.core5.http.HeaderElements;
import org.json.JSONException;
import sdk.pendo.io.e2.h0;
import sdk.pendo.io.e2.z;

/* JADX INFO: loaded from: classes4.dex */
public class c extends sdk.pendo.io.a5.a {
    private static final Logger C = Logger.getLogger(c.class.getName());
    private static boolean D = false;
    private static h0.a E;
    private static sdk.pendo.io.e2.e.a F;
    private static z G;
    private ScheduledExecutorService A;
    private final sdk.pendo.io.a5.a.InterfaceC0343a B;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    int g;
    private int h;
    private int i;
    private long j;
    private long k;
    private String l;
    String m;
    private String n;
    private String o;
    private List<String> p;
    private Map<String, sdk.pendo.io.b5.d.C0355d> q;
    private List<String> r;
    private Map<String, String> s;
    LinkedList<sdk.pendo.io.d5.b> t;
    sdk.pendo.io.b5.d u;
    private Future v;
    private Future w;
    private h0.a x;
    private sdk.pendo.io.e2.e.a y;
    private v z;

    class a implements sdk.pendo.io.a5.a.InterfaceC0343a {
        final /* synthetic */ sdk.pendo.io.a5.a.InterfaceC0343a a;

        a(sdk.pendo.io.a5.a.InterfaceC0343a interfaceC0343a) {
            this.a = interfaceC0343a;
        }

        @Override // sdk.pendo.io.a5.a.InterfaceC0343a
        public void call(Object... objArr) {
            this.a.call("transport closed");
        }
    }

    class b implements sdk.pendo.io.a5.a.InterfaceC0343a {
        final /* synthetic */ sdk.pendo.io.a5.a.InterfaceC0343a a;

        b(sdk.pendo.io.a5.a.InterfaceC0343a interfaceC0343a) {
            this.a = interfaceC0343a;
        }

        @Override // sdk.pendo.io.a5.a.InterfaceC0343a
        public void call(Object... objArr) {
            this.a.call("socket closed");
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.b5.c$c, reason: collision with other inner class name */
    class C0352c implements sdk.pendo.io.a5.a.InterfaceC0343a {
        final /* synthetic */ sdk.pendo.io.b5.d[] a;
        final /* synthetic */ sdk.pendo.io.a5.a.InterfaceC0343a b;

        C0352c(sdk.pendo.io.b5.d[] dVarArr, sdk.pendo.io.a5.a.InterfaceC0343a interfaceC0343a) {
            this.a = dVarArr;
            this.b = interfaceC0343a;
        }

        @Override // sdk.pendo.io.a5.a.InterfaceC0343a
        public void call(Object... objArr) {
            sdk.pendo.io.b5.d dVar = (sdk.pendo.io.b5.d) objArr[0];
            sdk.pendo.io.b5.d dVar2 = this.a[0];
            if (dVar2 == null || dVar.c.equals(dVar2.c)) {
                return;
            }
            Logger logger = c.C;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format(Locale.US, "'%s' works - aborting '%s'", dVar.c, this.a[0].c));
            }
            this.b.call(new Object[0]);
        }
    }

    class d implements Runnable {
        final /* synthetic */ sdk.pendo.io.b5.d[] a;
        final /* synthetic */ sdk.pendo.io.a5.a.InterfaceC0343a b;
        final /* synthetic */ sdk.pendo.io.a5.a.InterfaceC0343a c;
        final /* synthetic */ sdk.pendo.io.a5.a.InterfaceC0343a d;
        final /* synthetic */ c e;
        final /* synthetic */ sdk.pendo.io.a5.a.InterfaceC0343a f;
        final /* synthetic */ sdk.pendo.io.a5.a.InterfaceC0343a g;

        d(sdk.pendo.io.b5.d[] dVarArr, sdk.pendo.io.a5.a.InterfaceC0343a interfaceC0343a, sdk.pendo.io.a5.a.InterfaceC0343a interfaceC0343a2, sdk.pendo.io.a5.a.InterfaceC0343a interfaceC0343a3, c cVar, sdk.pendo.io.a5.a.InterfaceC0343a interfaceC0343a4, sdk.pendo.io.a5.a.InterfaceC0343a interfaceC0343a5) {
            this.a = dVarArr;
            this.b = interfaceC0343a;
            this.c = interfaceC0343a2;
            this.d = interfaceC0343a3;
            this.e = cVar;
            this.f = interfaceC0343a4;
            this.g = interfaceC0343a5;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a[0].a("open", this.b);
            this.a[0].a("error", this.c);
            this.a[0].a(HeaderElements.CLOSE, this.d);
            this.e.a(HeaderElements.CLOSE, this.f);
            this.e.a("upgrading", this.g);
        }
    }

    class e implements Runnable {
        final /* synthetic */ c a;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = e.this.a;
                if (cVar.z == v.CLOSED) {
                    return;
                }
                cVar.c("ping timeout");
            }
        }

        e(c cVar) {
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            sdk.pendo.io.i5.a.a(new a());
        }
    }

    class f implements Runnable {
        final /* synthetic */ c a;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Logger logger = c.C;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(String.format(Locale.US, "writing ping packet - expecting pong within %sms", Long.valueOf(f.this.a.k)));
                }
                f.this.a.i();
                c cVar = f.this.a;
                cVar.a(cVar.k);
            }
        }

        f(c cVar) {
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            sdk.pendo.io.i5.a.a(new a());
        }
    }

    class g implements Runnable {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.a("ping", new Object[0]);
            }
        }

        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.b("ping", new a());
        }
    }

    class h implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ Runnable b;

        h(String str, Runnable runnable) {
            this.a = str;
            this.b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a("message", this.a, this.b);
        }
    }

    class i implements Runnable {
        final /* synthetic */ byte[] a;
        final /* synthetic */ Runnable b;

        i(byte[] bArr, Runnable runnable) {
            this.a = bArr;
            this.b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a("message", this.a, this.b);
        }
    }

    class j implements sdk.pendo.io.a5.a.InterfaceC0343a {
        final /* synthetic */ Runnable a;

        j(Runnable runnable) {
            this.a = runnable;
        }

        @Override // sdk.pendo.io.a5.a.InterfaceC0343a
        public void call(Object... objArr) {
            this.a.run();
        }
    }

    class k implements sdk.pendo.io.a5.a.InterfaceC0343a {
        k() {
        }

        @Override // sdk.pendo.io.a5.a.InterfaceC0343a
        public void call(Object... objArr) {
            c.this.a(objArr.length > 0 ? ((Long) objArr[0]).longValue() : 0L);
        }
    }

    class l implements Runnable {

        class a implements Runnable {
            final /* synthetic */ c a;

            a(c cVar) {
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.a("error", new sdk.pendo.io.b5.a("No transports available"));
            }
        }

        l() {
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0028  */
        /* JADX WARN: Code duplicated, block: B:13:0x0033  */
        /* JADX WARN: Code duplicated, block: B:9:0x001c  */
        @Override // java.lang.Runnable
        public void run() {
            String str;
            c cVar = c.this;
            if (cVar.f && c.D) {
                str = "websocket";
                if (!cVar.p.contains("websocket")) {
                    if (c.this.p.size() == 0) {
                        sdk.pendo.io.i5.a.b(new a(c.this));
                        return;
                    }
                    str = (String) c.this.p.get(0);
                }
            } else {
                if (c.this.p.size() == 0) {
                    sdk.pendo.io.i5.a.b(new a(c.this));
                    return;
                }
                str = (String) c.this.p.get(0);
            }
            c cVar2 = c.this;
            cVar2.z = v.OPENING;
            sdk.pendo.io.b5.d dVarB = cVar2.b(str);
            c.this.a(dVarB);
            dVarB.g();
        }
    }

    class m implements Runnable {

        class a implements Runnable {
            final /* synthetic */ c a;

            a(c cVar) {
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.c("forced close");
                c.C.fine("socket closing - telling transport to close");
                this.a.u.b();
            }
        }

        class b implements sdk.pendo.io.a5.a.InterfaceC0343a {
            final /* synthetic */ c a;
            final /* synthetic */ sdk.pendo.io.a5.a.InterfaceC0343a[] b;
            final /* synthetic */ Runnable c;

            b(c cVar, sdk.pendo.io.a5.a.InterfaceC0343a[] interfaceC0343aArr, Runnable runnable) {
                this.a = cVar;
                this.b = interfaceC0343aArr;
                this.c = runnable;
            }

            @Override // sdk.pendo.io.a5.a.InterfaceC0343a
            public void call(Object... objArr) {
                this.a.a(HeaderElements.UPGRADE, this.b[0]);
                this.a.a("upgradeError", this.b[0]);
                this.c.run();
            }
        }

        /* JADX INFO: renamed from: sdk.pendo.io.b5.c$m$c, reason: collision with other inner class name */
        class RunnableC0353c implements Runnable {
            final /* synthetic */ c a;
            final /* synthetic */ sdk.pendo.io.a5.a.InterfaceC0343a[] b;

            RunnableC0353c(c cVar, sdk.pendo.io.a5.a.InterfaceC0343a[] interfaceC0343aArr) {
                this.a = cVar;
                this.b = interfaceC0343aArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.c(HeaderElements.UPGRADE, this.b[0]);
                this.a.c("upgradeError", this.b[0]);
            }
        }

        class d implements sdk.pendo.io.a5.a.InterfaceC0343a {
            final /* synthetic */ Runnable a;
            final /* synthetic */ Runnable b;

            d(Runnable runnable, Runnable runnable2) {
                this.a = runnable;
                this.b = runnable2;
            }

            @Override // sdk.pendo.io.a5.a.InterfaceC0343a
            public void call(Object... objArr) {
                (c.this.e ? this.a : this.b).run();
            }
        }

        m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            v vVar = cVar.z;
            if (vVar == v.OPENING || vVar == v.OPEN) {
                cVar.z = v.CLOSING;
                a aVar = new a(cVar);
                sdk.pendo.io.a5.a.InterfaceC0343a[] interfaceC0343aArr = new sdk.pendo.io.a5.a.InterfaceC0343a[1];
                interfaceC0343aArr[0] = new b(cVar, interfaceC0343aArr, aVar);
                RunnableC0353c runnableC0353c = new RunnableC0353c(cVar, interfaceC0343aArr);
                if (c.this.t.size() > 0) {
                    c.this.c("drain", new d(runnableC0353c, aVar));
                } else if (c.this.e) {
                    runnableC0353c.run();
                } else {
                    aVar.run();
                }
            }
        }
    }

    class n implements sdk.pendo.io.a5.a.InterfaceC0343a {
        final /* synthetic */ c a;

        n(c cVar) {
            this.a = cVar;
        }

        @Override // sdk.pendo.io.a5.a.InterfaceC0343a
        public void call(Object... objArr) {
            this.a.c("transport close");
        }
    }

    class o implements sdk.pendo.io.a5.a.InterfaceC0343a {
        final /* synthetic */ c a;

        o(c cVar) {
            this.a = cVar;
        }

        @Override // sdk.pendo.io.a5.a.InterfaceC0343a
        public void call(Object... objArr) {
            this.a.a(objArr.length > 0 ? (Exception) objArr[0] : null);
        }
    }

    class p implements sdk.pendo.io.a5.a.InterfaceC0343a {
        final /* synthetic */ c a;

        p(c cVar) {
            this.a = cVar;
        }

        @Override // sdk.pendo.io.a5.a.InterfaceC0343a
        public void call(Object... objArr) {
            this.a.a(objArr.length > 0 ? (sdk.pendo.io.d5.b) objArr[0] : null);
        }
    }

    class q implements sdk.pendo.io.a5.a.InterfaceC0343a {
        final /* synthetic */ c a;

        q(c cVar) {
            this.a = cVar;
        }

        @Override // sdk.pendo.io.a5.a.InterfaceC0343a
        public void call(Object... objArr) {
            this.a.f();
        }
    }

    class r implements sdk.pendo.io.a5.a.InterfaceC0343a {
        final /* synthetic */ boolean[] a;
        final /* synthetic */ String b;
        final /* synthetic */ sdk.pendo.io.b5.d[] c;
        final /* synthetic */ c d;
        final /* synthetic */ Runnable[] e;

        class a implements sdk.pendo.io.a5.a.InterfaceC0343a {

            /* JADX INFO: renamed from: sdk.pendo.io.b5.c$r$a$a, reason: collision with other inner class name */
            class RunnableC0354a implements Runnable {
                RunnableC0354a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    r rVar = r.this;
                    if (rVar.a[0] || v.CLOSED == rVar.d.z) {
                        return;
                    }
                    c.C.fine("changing transport and sending upgrade packet");
                    r.this.e[0].run();
                    r rVar2 = r.this;
                    rVar2.d.a(rVar2.c[0]);
                    r.this.c[0].a(new sdk.pendo.io.d5.b[]{new sdk.pendo.io.d5.b(HeaderElements.UPGRADE)});
                    r rVar3 = r.this;
                    rVar3.d.a(HeaderElements.UPGRADE, rVar3.c[0]);
                    r rVar4 = r.this;
                    rVar4.c[0] = null;
                    c cVar = rVar4.d;
                    cVar.e = false;
                    cVar.c();
                }
            }

            a() {
            }

            @Override // sdk.pendo.io.a5.a.InterfaceC0343a
            public void call(Object... objArr) {
                if (r.this.a[0]) {
                    return;
                }
                sdk.pendo.io.d5.b bVar = (sdk.pendo.io.d5.b) objArr[0];
                if (!"pong".equals(bVar.a) || !"probe".equals(bVar.b)) {
                    Logger logger = c.C;
                    if (logger.isLoggable(Level.FINE)) {
                        logger.fine(String.format(Locale.US, "probe transport '%s' failed", r.this.b));
                    }
                    sdk.pendo.io.b5.a aVar = new sdk.pendo.io.b5.a("probe error");
                    r rVar = r.this;
                    aVar.a = rVar.c[0].c;
                    rVar.d.a("upgradeError", aVar);
                    return;
                }
                Logger logger2 = c.C;
                Level level = Level.FINE;
                if (logger2.isLoggable(level)) {
                    logger2.fine(String.format(Locale.US, "probe transport '%s' pong", r.this.b));
                }
                r rVar2 = r.this;
                c cVar = rVar2.d;
                cVar.e = true;
                cVar.a("upgrading", rVar2.c[0]);
                sdk.pendo.io.b5.d dVar = r.this.c[0];
                if (dVar == null) {
                    return;
                }
                c.D = "websocket".equals(dVar.c);
                if (logger2.isLoggable(level)) {
                    logger2.fine(String.format(Locale.US, "pausing current transport '%s'", r.this.d.u.c));
                }
                ((sdk.pendo.io.c5.a) r.this.d.u).a((Runnable) new RunnableC0354a());
            }
        }

        r(boolean[] zArr, String str, sdk.pendo.io.b5.d[] dVarArr, c cVar, Runnable[] runnableArr) {
            this.a = zArr;
            this.b = str;
            this.c = dVarArr;
            this.d = cVar;
            this.e = runnableArr;
        }

        @Override // sdk.pendo.io.a5.a.InterfaceC0343a
        public void call(Object... objArr) {
            if (this.a[0]) {
                return;
            }
            Logger logger = c.C;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format(Locale.US, "probe transport '%s' opened", this.b));
            }
            this.c[0].a(new sdk.pendo.io.d5.b[]{new sdk.pendo.io.d5.b("ping", "probe")});
            this.c[0].c("packet", new a());
        }
    }

    class s implements sdk.pendo.io.a5.a.InterfaceC0343a {
        final /* synthetic */ boolean[] a;
        final /* synthetic */ Runnable[] b;
        final /* synthetic */ sdk.pendo.io.b5.d[] c;

        s(boolean[] zArr, Runnable[] runnableArr, sdk.pendo.io.b5.d[] dVarArr) {
            this.a = zArr;
            this.b = runnableArr;
            this.c = dVarArr;
        }

        @Override // sdk.pendo.io.a5.a.InterfaceC0343a
        public void call(Object... objArr) {
            boolean[] zArr = this.a;
            if (zArr[0]) {
                return;
            }
            zArr[0] = true;
            this.b[0].run();
            this.c[0].b();
            this.c[0] = null;
        }
    }

    class t implements sdk.pendo.io.a5.a.InterfaceC0343a {
        final /* synthetic */ sdk.pendo.io.b5.d[] a;
        final /* synthetic */ sdk.pendo.io.a5.a.InterfaceC0343a b;
        final /* synthetic */ String c;
        final /* synthetic */ c d;

        t(sdk.pendo.io.b5.d[] dVarArr, sdk.pendo.io.a5.a.InterfaceC0343a interfaceC0343a, String str, c cVar) {
            this.a = dVarArr;
            this.b = interfaceC0343a;
            this.c = str;
            this.d = cVar;
        }

        @Override // sdk.pendo.io.a5.a.InterfaceC0343a
        public void call(Object... objArr) {
            sdk.pendo.io.b5.a aVar;
            Object obj = objArr[0];
            if (obj instanceof Exception) {
                aVar = new sdk.pendo.io.b5.a("probe error", (Exception) obj);
            } else {
                aVar = obj instanceof String ? new sdk.pendo.io.b5.a("probe error: " + ((String) obj)) : new sdk.pendo.io.b5.a("probe error");
            }
            aVar.a = this.a[0].c;
            this.b.call(new Object[0]);
            Logger logger = c.C;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format(Locale.US, "probe transport \"%s\" failed because of error: %s", this.c, obj));
            }
            this.d.a("upgradeError", aVar);
        }
    }

    public static class u extends sdk.pendo.io.b5.d.C0355d {
        public String[] l;
        public boolean m = true;
        public boolean n;
        public String o;
        public String p;
        public Map<String, sdk.pendo.io.b5.d.C0355d> q;

        /* JADX INFO: Access modifiers changed from: private */
        public static u a(URI uri, u uVar) {
            if (uVar == null) {
                uVar = new u();
            }
            uVar.o = uri.getHost();
            uVar.d = "https".equals(uri.getScheme()) || "wss".equals(uri.getScheme());
            uVar.f = uri.getPort();
            String rawQuery = uri.getRawQuery();
            if (rawQuery != null) {
                uVar.p = rawQuery;
            }
            return uVar;
        }
    }

    private enum v {
        OPENING,
        OPEN,
        CLOSING,
        CLOSED;

        @Override // java.lang.Enum
        public String toString() {
            return super.toString().toLowerCase(Locale.US);
        }
    }

    public c() {
        this(new u());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.z == v.CLOSED || !this.u.b || this.e || this.t.size() == 0) {
            return;
        }
        Logger logger = C;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format(Locale.US, "flushing %d packets in socket", Integer.valueOf(this.t.size())));
        }
        this.i = this.t.size();
        sdk.pendo.io.b5.d dVar = this.u;
        LinkedList<sdk.pendo.io.d5.b> linkedList = this.t;
        dVar.a((sdk.pendo.io.d5.b[]) linkedList.toArray(new sdk.pendo.io.d5.b[linkedList.size()]));
        a("flush", new Object[0]);
    }

    private ScheduledExecutorService d() {
        ScheduledExecutorService scheduledExecutorService = this.A;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            this.A = Executors.newSingleThreadScheduledExecutor();
        }
        return this.A;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        for (int i2 = 0; i2 < this.i; i2++) {
            this.t.poll();
        }
        this.i = 0;
        if (this.t.size() == 0) {
            a("drain", new Object[0]);
        } else {
            c();
        }
    }

    private void g() {
        Logger logger = C;
        logger.fine("socket open");
        v vVar = v.OPEN;
        this.z = vVar;
        D = "websocket".equals(this.u.c);
        a("open", new Object[0]);
        c();
        if (this.z == vVar && this.c && (this.u instanceof sdk.pendo.io.c5.a)) {
            logger.fine("starting upgrade probes");
            Iterator<String> it = this.r.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        sdk.pendo.io.i5.a.a(new g());
    }

    private void j() {
        Future future = this.w;
        if (future != null) {
            future.cancel(false);
        }
        this.w = d().schedule(new f(this), this.j, TimeUnit.MILLISECONDS);
    }

    List<String> a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (this.p.contains(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public c b() {
        sdk.pendo.io.i5.a.a(new m());
        return this;
    }

    public String e() {
        return this.l;
    }

    public c h() {
        sdk.pendo.io.i5.a.a(new l());
        return this;
    }

    public c(URI uri, u uVar) {
        this(uri != null ? u.a(uri, uVar) : uVar);
    }

    private void a(String str, Exception exc) {
        v vVar = v.OPENING;
        v vVar2 = this.z;
        if (vVar == vVar2 || v.OPEN == vVar2 || v.CLOSING == vVar2) {
            Logger logger = C;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format(Locale.US, "socket close with reason: %s", str));
            }
            Future future = this.w;
            if (future != null) {
                future.cancel(false);
            }
            Future future2 = this.v;
            if (future2 != null) {
                future2.cancel(false);
            }
            ScheduledExecutorService scheduledExecutorService = this.A;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdown();
            }
            this.u.a(HeaderElements.CLOSE);
            this.u.b();
            this.u.a();
            this.z = v.CLOSED;
            this.l = null;
            a(HeaderElements.CLOSE, str, exc);
            this.t.clear();
            this.i = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public sdk.pendo.io.b5.d b(String str) {
        sdk.pendo.io.b5.d bVar;
        Logger logger = C;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format(Locale.US, "creating transport '%s'", str));
        }
        HashMap map = new HashMap(this.s);
        map.put("EIO", String.valueOf(3));
        map.put(NotificationCompat.CATEGORY_TRANSPORT, str);
        String str2 = this.l;
        if (str2 != null) {
            map.put(CmcdConfiguration.KEY_SESSION_ID, str2);
        }
        sdk.pendo.io.b5.d.C0355d c0355d = this.q.get(str);
        sdk.pendo.io.b5.d.C0355d c0355d2 = new sdk.pendo.io.b5.d.C0355d();
        c0355d2.h = map;
        c0355d2.i = this;
        c0355d2.a = c0355d != null ? c0355d.a : this.m;
        c0355d2.f = c0355d != null ? c0355d.f : this.g;
        c0355d2.d = c0355d != null ? c0355d.d : this.b;
        c0355d2.b = c0355d != null ? c0355d.b : this.n;
        c0355d2.e = c0355d != null ? c0355d.e : this.d;
        c0355d2.c = c0355d != null ? c0355d.c : this.o;
        c0355d2.g = c0355d != null ? c0355d.g : this.h;
        c0355d2.k = c0355d != null ? c0355d.k : this.y;
        c0355d2.j = c0355d != null ? c0355d.j : this.x;
        if ("websocket".equals(str)) {
            bVar = new sdk.pendo.io.c5.c(c0355d2);
        } else {
            if (!"polling".equals(str)) {
                throw new RuntimeException();
            }
            bVar = new sdk.pendo.io.c5.b(c0355d2);
        }
        a(NotificationCompat.CATEGORY_TRANSPORT, bVar);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        a(str, (Exception) null);
    }

    private void d(String str) {
        Logger logger = C;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format(Locale.US, "probing transport '%s'", str));
        }
        sdk.pendo.io.b5.d[] dVarArr = {b(str)};
        boolean[] zArr = {false};
        D = false;
        Runnable[] runnableArr = {new d(dVarArr, rVar, tVar, aVar, this, bVar, c0352c)};
        r rVar = new r(zArr, str, dVarArr, this, runnableArr);
        s sVar = new s(zArr, runnableArr, dVarArr);
        t tVar = new t(dVarArr, sVar, str, this);
        a aVar = new a(tVar);
        b bVar = new b(tVar);
        C0352c c0352c = new C0352c(dVarArr, sVar);
        dVarArr[0].c("open", rVar);
        dVarArr[0].c("error", tVar);
        dVarArr[0].c(HeaderElements.CLOSE, aVar);
        c(HeaderElements.CLOSE, bVar);
        c("upgrading", c0352c);
        dVarArr[0].g();
    }

    public void e(String str) {
        c(str, (Runnable) null);
    }

    public c(u uVar) {
        this.t = new LinkedList<>();
        this.B = new k();
        String strSubstring = uVar.o;
        if (strSubstring != null) {
            if (strSubstring.split(":").length > 2) {
                int iIndexOf = strSubstring.indexOf(91);
                strSubstring = iIndexOf != -1 ? strSubstring.substring(iIndexOf + 1) : strSubstring;
                int iLastIndexOf = strSubstring.lastIndexOf(93);
                if (iLastIndexOf != -1) {
                    strSubstring = strSubstring.substring(0, iLastIndexOf);
                }
            }
            uVar.a = strSubstring;
        }
        boolean z = uVar.d;
        this.b = z;
        if (uVar.f == -1) {
            uVar.f = z ? 443 : 80;
        }
        String str = uVar.a;
        this.m = str == null ? "localhost" : str;
        this.g = uVar.f;
        String str2 = uVar.p;
        this.s = str2 != null ? sdk.pendo.io.g5.a.a(str2) : new HashMap<>();
        this.c = uVar.m;
        StringBuilder sb = new StringBuilder();
        String str3 = uVar.b;
        this.n = sb.append((str3 == null ? "/engine.io" : str3).replaceAll("/$", "")).append("/").toString();
        String str4 = uVar.c;
        this.o = str4 == null ? "t" : str4;
        this.d = uVar.e;
        String[] strArr = uVar.l;
        this.p = new ArrayList(Arrays.asList(strArr == null ? new String[]{"polling", "websocket"} : strArr));
        Map<String, sdk.pendo.io.b5.d.C0355d> map = uVar.q;
        this.q = map == null ? new HashMap<>() : map;
        int i2 = uVar.g;
        this.h = i2 == 0 ? 843 : i2;
        this.f = uVar.n;
        sdk.pendo.io.e2.e.a aVar = uVar.k;
        aVar = aVar == null ? F : aVar;
        this.y = aVar;
        h0.a aVar2 = uVar.j;
        this.x = aVar2 == null ? E : aVar2;
        if (aVar == null) {
            if (G == null) {
                G = new z();
            }
            this.y = G;
        }
        if (this.x == null) {
            if (G == null) {
                G = new z();
            }
            this.x = G;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Exception exc) {
        Logger logger = C;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format(Locale.US, "socket error %s", exc));
        }
        D = false;
        a("error", exc);
        a("transport error", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, Runnable runnable) {
        a(new sdk.pendo.io.d5.b(str), runnable);
    }

    public void c(String str, Runnable runnable) {
        a(str, runnable);
    }

    private void a(sdk.pendo.io.b5.b bVar) {
        a("handshake", bVar);
        String str = bVar.a;
        this.l = str;
        this.u.d.put(CmcdConfiguration.KEY_SESSION_ID, str);
        this.r = a(Arrays.asList(bVar.b));
        this.j = bVar.c;
        this.k = bVar.d;
        g();
        if (v.CLOSED == this.z) {
            return;
        }
        j();
        a("heartbeat", this.B);
        b("heartbeat", this.B);
    }

    public void b(byte[] bArr, Runnable runnable) {
        a(bArr, runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        Future future = this.v;
        if (future != null) {
            future.cancel(false);
        }
        if (j2 <= 0) {
            j2 = this.j + this.k;
        }
        this.v = d().schedule(new e(this), j2, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(sdk.pendo.io.d5.b bVar) {
        v vVar = this.z;
        if (vVar != v.OPENING && vVar != v.OPEN && vVar != v.CLOSING) {
            Logger logger = C;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format(Locale.US, "packet received with socket readyState '%s'", this.z));
                return;
            }
            return;
        }
        Logger logger2 = C;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(String.format(Locale.US, "socket received: type '%s', data '%s'", bVar.a, bVar.b));
        }
        a("packet", bVar);
        a("heartbeat", new Object[0]);
        if ("open".equals(bVar.a)) {
            try {
                a(new sdk.pendo.io.b5.b((String) bVar.b));
                return;
            } catch (JSONException e2) {
                a("error", new sdk.pendo.io.b5.a(e2));
                return;
            }
        }
        if ("pong".equals(bVar.a)) {
            j();
            a("pong", new Object[0]);
        } else if ("error".equals(bVar.a)) {
            sdk.pendo.io.b5.a aVar = new sdk.pendo.io.b5.a("server error");
            aVar.b = bVar.b;
            a(aVar);
        } else if ("message".equals(bVar.a)) {
            a("data", bVar.b);
            a("message", bVar.b);
        }
    }

    public void a(String str, Runnable runnable) {
        sdk.pendo.io.i5.a.a(new h(str, runnable));
    }

    public void a(byte[] bArr, Runnable runnable) {
        sdk.pendo.io.i5.a.a(new i(bArr, runnable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, Runnable runnable) {
        a(new sdk.pendo.io.d5.b(str, str2), runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, byte[] bArr, Runnable runnable) {
        a(new sdk.pendo.io.d5.b(str, bArr), runnable);
    }

    private void a(sdk.pendo.io.d5.b bVar, Runnable runnable) {
        v vVar = v.CLOSING;
        v vVar2 = this.z;
        if (vVar == vVar2 || v.CLOSED == vVar2) {
            return;
        }
        a("packetCreate", bVar);
        this.t.offer(bVar);
        if (runnable != null) {
            c("flush", new j(runnable));
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(sdk.pendo.io.b5.d dVar) {
        Logger logger = C;
        Level level = Level.FINE;
        if (logger.isLoggable(level)) {
            logger.fine(String.format(Locale.US, "setting transport %s", dVar.c));
        }
        if (this.u != null) {
            if (logger.isLoggable(level)) {
                logger.fine(String.format(Locale.US, "clearing existing transport %s", this.u.c));
            }
            this.u.a();
        }
        this.u = dVar;
        dVar.b("drain", new q(this)).b("packet", new p(this)).b("error", new o(this)).b(HeaderElements.CLOSE, new n(this));
    }

    public void a(byte[] bArr) {
        b(bArr, (Runnable) null);
    }
}
