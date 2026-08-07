package sdk.pendo.io.z4;

import androidx.core.app.NotificationCompat;
import com.box.androidsdk.content.models.BoxSimpleMessage;
import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.hc.core5.http.HeaderElements;
import sdk.pendo.io.e2.h0;

/* JADX INFO: loaded from: classes6.dex */
public class c extends sdk.pendo.io.a5.a {
    private static final Logger w = Logger.getLogger(c.class.getName());
    static h0.a x;
    static sdk.pendo.io.e2.e.a y;
    p b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private int g;
    private long h;
    private long i;
    private double j;
    private sdk.pendo.io.y4.a k;
    private long l;
    private Set<sdk.pendo.io.z4.e> m;
    private Date n;
    private URI o;
    private List<sdk.pendo.io.h5.c> p;
    private Queue<sdk.pendo.io.z4.d.b> q;
    private o r;
    sdk.pendo.io.b5.c s;
    private sdk.pendo.io.h5.d.b t;
    private sdk.pendo.io.h5.d.a u;
    ConcurrentHashMap<String, sdk.pendo.io.z4.e> v;

    class a implements Runnable {
        final /* synthetic */ n a;

        /* JADX INFO: renamed from: sdk.pendo.io.z4.c$a$a, reason: collision with other inner class name */
        class C0543a implements sdk.pendo.io.a5.a.InterfaceC0343a {
            final /* synthetic */ c a;

            C0543a(c cVar) {
                this.a = cVar;
            }

            @Override // sdk.pendo.io.a5.a.InterfaceC0343a
            public void call(Object... objArr) {
                this.a.a(NotificationCompat.CATEGORY_TRANSPORT, objArr);
            }
        }

        class b implements sdk.pendo.io.a5.a.InterfaceC0343a {
            final /* synthetic */ c a;

            b(c cVar) {
                this.a = cVar;
            }

            @Override // sdk.pendo.io.a5.a.InterfaceC0343a
            public void call(Object... objArr) {
                this.a.e();
                n nVar = a.this.a;
                if (nVar != null) {
                    nVar.a(null);
                }
            }
        }

        /* JADX INFO: renamed from: sdk.pendo.io.z4.c$a$c, reason: collision with other inner class name */
        class C0544c implements sdk.pendo.io.a5.a.InterfaceC0343a {
            final /* synthetic */ c a;

            C0544c(c cVar) {
                this.a = cVar;
            }

            @Override // sdk.pendo.io.a5.a.InterfaceC0343a
            public void call(Object... objArr) {
                Object obj = objArr.length > 0 ? objArr[0] : null;
                c.w.fine("connect_error");
                this.a.b();
                c cVar = this.a;
                cVar.b = p.CLOSED;
                cVar.b("connect_error", obj);
                if (a.this.a != null) {
                    a.this.a.a(new sdk.pendo.io.z4.f("Connection error", obj instanceof Exception ? (Exception) obj : null));
                } else {
                    this.a.d();
                }
            }
        }

        class d extends TimerTask {
            final /* synthetic */ long a;
            final /* synthetic */ sdk.pendo.io.z4.d.b b;
            final /* synthetic */ sdk.pendo.io.b5.c c;
            final /* synthetic */ c d;

            /* JADX INFO: renamed from: sdk.pendo.io.z4.c$a$d$a, reason: collision with other inner class name */
            class RunnableC0545a implements Runnable {
                RunnableC0545a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    c.w.fine(String.format(Locale.US, "connect attempt timed out after %d", Long.valueOf(d.this.a)));
                    d.this.b.destroy();
                    d.this.c.b();
                    d.this.c.a("error", new sdk.pendo.io.z4.f(ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE));
                    d dVar = d.this;
                    dVar.d.b("connect_timeout", Long.valueOf(dVar.a));
                }
            }

            d(long j, sdk.pendo.io.z4.d.b bVar, sdk.pendo.io.b5.c cVar, c cVar2) {
                this.a = j;
                this.b = bVar;
                this.c = cVar;
                this.d = cVar2;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                sdk.pendo.io.i5.a.a(new RunnableC0545a());
            }
        }

        class e implements sdk.pendo.io.z4.d.b {
            final /* synthetic */ Timer a;

            e(Timer timer) {
                this.a = timer;
            }

            @Override // sdk.pendo.io.z4.d.b
            public void destroy() {
                this.a.cancel();
            }
        }

        a(n nVar) {
            this.a = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            p pVar;
            a aVar;
            Logger logger = c.w;
            Level level = Level.FINE;
            if (logger.isLoggable(level)) {
                logger.fine(String.format(Locale.US, "readyState %s", c.this.b));
            }
            p pVar2 = c.this.b;
            if (pVar2 == p.OPEN || pVar2 == (pVar = p.OPENING)) {
                return;
            }
            if (logger.isLoggable(level)) {
                logger.fine(String.format(Locale.US, "opening %s", c.this.o));
            }
            c cVar = c.this;
            c cVar2 = c.this;
            cVar.s = new m(cVar2.o, cVar2.r);
            c cVar3 = c.this;
            sdk.pendo.io.b5.c cVar4 = cVar3.s;
            cVar3.b = pVar;
            cVar3.d = false;
            cVar4.b(NotificationCompat.CATEGORY_TRANSPORT, new C0543a(cVar3));
            sdk.pendo.io.z4.d.b bVarA = sdk.pendo.io.z4.d.a(cVar4, "open", new b(cVar3));
            sdk.pendo.io.z4.d.b bVarA2 = sdk.pendo.io.z4.d.a(cVar4, "error", new C0544c(cVar3));
            long j = c.this.l;
            if (j >= 0) {
                logger.fine(String.format(Locale.US, "connection attempt will timeout after %d", Long.valueOf(j)));
                Timer timer = new Timer();
                aVar = this;
                timer.schedule(aVar.new d(j, bVarA, cVar4, cVar3), j);
                c.this.q.add(aVar.new e(timer));
            } else {
                aVar = this;
            }
            c.this.q.add(bVarA);
            c.this.q.add(bVarA2);
            c.this.s.h();
        }
    }

    class b implements sdk.pendo.io.h5.d.b.a {
        final /* synthetic */ c a;

        b(c cVar) {
            this.a = cVar;
        }

        @Override // sdk.pendo.io.h5.d.b.a
        public void call(Object[] objArr) {
            for (Object obj : objArr) {
                if (obj instanceof String) {
                    this.a.s.e((String) obj);
                } else if (obj instanceof byte[]) {
                    this.a.s.a((byte[]) obj);
                }
            }
            c cVar = this.a;
            cVar.f = false;
            cVar.j();
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.z4.c$c, reason: collision with other inner class name */
    class C0546c extends TimerTask {
        final /* synthetic */ c a;

        /* JADX INFO: renamed from: sdk.pendo.io.z4.c$c$a */
        class a implements Runnable {

            /* JADX INFO: renamed from: sdk.pendo.io.z4.c$c$a$a, reason: collision with other inner class name */
            class C0547a implements n {
                C0547a() {
                }

                @Override // sdk.pendo.io.z4.c.n
                public void a(Exception exc) {
                    if (exc == null) {
                        c.w.fine("reconnect success");
                        C0546c.this.a.h();
                        return;
                    }
                    c.w.fine("reconnect attempt error");
                    c cVar = C0546c.this.a;
                    cVar.e = false;
                    cVar.l();
                    C0546c.this.a.b("reconnect_error", exc);
                }
            }

            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C0546c.this.a.d) {
                    return;
                }
                c.w.fine("attempting reconnect");
                int iB = C0546c.this.a.k.b();
                C0546c.this.a.b("reconnect_attempt", Integer.valueOf(iB));
                C0546c.this.a.b("reconnecting", Integer.valueOf(iB));
                c cVar = C0546c.this.a;
                if (cVar.d) {
                    return;
                }
                cVar.a(new C0547a());
            }
        }

        C0546c(c cVar) {
            this.a = cVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            sdk.pendo.io.i5.a.a(new a());
        }
    }

    class d implements sdk.pendo.io.z4.d.b {
        final /* synthetic */ Timer a;

        d(Timer timer) {
            this.a = timer;
        }

        @Override // sdk.pendo.io.z4.d.b
        public void destroy() {
            this.a.cancel();
        }
    }

    class e implements sdk.pendo.io.a5.a.InterfaceC0343a {
        e() {
        }

        @Override // sdk.pendo.io.a5.a.InterfaceC0343a
        public void call(Object... objArr) {
            Object obj = objArr[0];
            if (obj instanceof String) {
                c.this.d((String) obj);
            } else if (obj instanceof byte[]) {
                c.this.a((byte[]) obj);
            }
        }
    }

    class f implements sdk.pendo.io.a5.a.InterfaceC0343a {
        f() {
        }

        @Override // sdk.pendo.io.a5.a.InterfaceC0343a
        public void call(Object... objArr) {
            c.this.f();
        }
    }

    class g implements sdk.pendo.io.a5.a.InterfaceC0343a {
        g() {
        }

        @Override // sdk.pendo.io.a5.a.InterfaceC0343a
        public void call(Object... objArr) {
            c.this.g();
        }
    }

    class h implements sdk.pendo.io.a5.a.InterfaceC0343a {
        h() {
        }

        @Override // sdk.pendo.io.a5.a.InterfaceC0343a
        public void call(Object... objArr) {
            c.this.a((Exception) objArr[0]);
        }
    }

    class i implements sdk.pendo.io.a5.a.InterfaceC0343a {
        i() {
        }

        @Override // sdk.pendo.io.a5.a.InterfaceC0343a
        public void call(Object... objArr) {
            c.this.c((String) objArr[0]);
        }
    }

    class j implements sdk.pendo.io.h5.d.a.InterfaceC0396a {
        j() {
        }

        @Override // sdk.pendo.io.h5.d.a.InterfaceC0396a
        public void a(sdk.pendo.io.h5.c cVar) {
            c.this.a(cVar);
        }
    }

    class k implements sdk.pendo.io.a5.a.InterfaceC0343a {
        final /* synthetic */ c a;
        final /* synthetic */ sdk.pendo.io.z4.e b;

        k(c cVar, sdk.pendo.io.z4.e eVar) {
            this.a = cVar;
            this.b = eVar;
        }

        @Override // sdk.pendo.io.a5.a.InterfaceC0343a
        public void call(Object... objArr) {
            this.a.m.add(this.b);
        }
    }

    class l implements sdk.pendo.io.a5.a.InterfaceC0343a {
        final /* synthetic */ sdk.pendo.io.z4.e a;
        final /* synthetic */ c b;
        final /* synthetic */ String c;

        l(sdk.pendo.io.z4.e eVar, c cVar, String str) {
            this.a = eVar;
            this.b = cVar;
            this.c = str;
        }

        @Override // sdk.pendo.io.a5.a.InterfaceC0343a
        public void call(Object... objArr) {
            this.a.b = this.b.b(this.c);
        }
    }

    private static class m extends sdk.pendo.io.b5.c {
        m(URI uri, sdk.pendo.io.b5.c.u uVar) {
            super(uri, uVar);
        }
    }

    public interface n {
        void a(Exception exc);
    }

    public static class o extends sdk.pendo.io.b5.c.u {
        public int s;
        public long t;
        public long u;
        public double v;
        public sdk.pendo.io.h5.d.b w;
        public sdk.pendo.io.h5.d.a x;
        public boolean r = true;
        public long y = 20000;
    }

    enum p {
        CLOSED,
        OPENING,
        OPEN
    }

    public c() {
        this(null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        w.fine("cleanup");
        while (true) {
            sdk.pendo.io.z4.d.b bVarPoll = this.q.poll();
            if (bVarPoll == null) {
                this.u.a((sdk.pendo.io.h5.d.a.InterfaceC0396a) null);
                this.p.clear();
                this.f = false;
                this.n = null;
                this.u.destroy();
                return;
            }
            bVarPoll.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (!this.e && this.c && this.k.b() == 0) {
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        w.fine("open");
        b();
        this.b = p.OPEN;
        a("open", new Object[0]);
        sdk.pendo.io.b5.c cVar = this.s;
        this.q.add(sdk.pendo.io.z4.d.a(cVar, "data", new e()));
        this.q.add(sdk.pendo.io.z4.d.a(cVar, "ping", new f()));
        this.q.add(sdk.pendo.io.z4.d.a(cVar, "pong", new g()));
        this.q.add(sdk.pendo.io.z4.d.a(cVar, "error", new h()));
        this.q.add(sdk.pendo.io.z4.d.a(cVar, HeaderElements.CLOSE, new i()));
        this.u.a(new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.n = new Date();
        b("ping", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        b("pong", Long.valueOf(this.n != null ? new Date().getTime() - this.n.getTime() : 0L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        int iB = this.k.b();
        this.e = false;
        this.k.c();
        o();
        b(BoxSimpleMessage.MESSAGE_RECONNECT, Integer.valueOf(iB));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.p.isEmpty() || this.f) {
            return;
        }
        b(this.p.remove(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.e || this.d) {
            return;
        }
        if (this.k.b() >= this.g) {
            w.fine("reconnect failed");
            this.k.c();
            b("reconnect_failed", new Object[0]);
            this.e = false;
            return;
        }
        long jA = this.k.a();
        w.fine(String.format(Locale.US, "will wait %dms before reconnect attempt", Long.valueOf(jA)));
        this.e = true;
        Timer timer = new Timer();
        timer.schedule(new C0546c(this), jA);
        this.q.add(new d(timer));
    }

    private void o() {
        for (Map.Entry<String, sdk.pendo.io.z4.e> entry : this.v.entrySet()) {
            String key = entry.getKey();
            entry.getValue().b = b(key);
        }
    }

    void a(sdk.pendo.io.z4.e eVar) {
        this.m.remove(eVar);
        if (this.m.isEmpty()) {
            c();
        }
    }

    void c() {
        w.fine("disconnect");
        this.d = true;
        this.e = false;
        if (this.b != p.OPEN) {
            b();
        }
        this.k.c();
        this.b = p.CLOSED;
        sdk.pendo.io.b5.c cVar = this.s;
        if (cVar != null) {
            cVar.b();
        }
    }

    public c i() {
        return a((n) null);
    }

    public final double k() {
        return this.j;
    }

    public final long m() {
        return this.h;
    }

    public final long n() {
        return this.i;
    }

    public c(URI uri, o oVar) {
        this.m = new HashSet();
        oVar = oVar == null ? new o() : oVar;
        if (oVar.b == null) {
            oVar.b = "/socket.io";
        }
        if (oVar.j == null) {
            oVar.j = x;
        }
        if (oVar.k == null) {
            oVar.k = y;
        }
        this.r = oVar;
        this.v = new ConcurrentHashMap<>();
        this.q = new LinkedList();
        a(oVar.r);
        int i2 = oVar.s;
        a(i2 == 0 ? Integer.MAX_VALUE : i2);
        long j2 = oVar.t;
        a(j2 == 0 ? 1000L : j2);
        long j3 = oVar.u;
        b(j3 == 0 ? 5000L : j3);
        double d2 = oVar.v;
        a(d2 == 0.0d ? 0.5d : d2);
        this.k = new sdk.pendo.io.y4.a().b(m()).a(n()).a(k());
        c(oVar.y);
        this.b = p.CLOSED;
        this.o = uri;
        this.f = false;
        this.p = new ArrayList();
        sdk.pendo.io.h5.d.b bVar = oVar.w;
        this.t = bVar == null ? new sdk.pendo.io.h5.b.c() : bVar;
        sdk.pendo.io.h5.d.a aVar = oVar.x;
        this.u = aVar == null ? new sdk.pendo.io.h5.b.C0395b() : aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr) {
        this.u.a(bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, Object... objArr) {
        a(str, objArr);
        Iterator<sdk.pendo.io.z4.e> it = this.v.values().iterator();
        while (it.hasNext()) {
            it.next().a(str, objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        w.fine("onclose");
        b();
        this.k.c();
        this.b = p.CLOSED;
        a(HeaderElements.CLOSE, str);
        if (!this.c || this.d) {
            return;
        }
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        this.u.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(sdk.pendo.io.h5.c cVar) {
        a("packet", cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str) {
        return ("/".equals(str) ? "" : str + "#") + this.s.e();
    }

    public c c(long j2) {
        this.l = j2;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Exception exc) {
        w.log(Level.FINE, "error", (Throwable) exc);
        b("error", exc);
    }

    void b(sdk.pendo.io.h5.c cVar) {
        Logger logger = w;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format(Locale.US, "writing packet %s", cVar));
        }
        String str = cVar.f;
        if (str != null && !str.isEmpty() && cVar.a == 0) {
            cVar.c += MsalUtils.QUERY_STRING_SYMBOL + cVar.f;
        }
        if (this.f) {
            this.p.add(cVar);
        } else {
            this.f = true;
            this.t.a(cVar, new b(this));
        }
    }

    public c a(n nVar) {
        sdk.pendo.io.i5.a.a(new a(nVar));
        return this;
    }

    public c b(long j2) {
        this.i = j2;
        sdk.pendo.io.y4.a aVar = this.k;
        if (aVar != null) {
            aVar.a(j2);
        }
        return this;
    }

    public c a(double d2) {
        this.j = d2;
        sdk.pendo.io.y4.a aVar = this.k;
        if (aVar != null) {
            aVar.a(d2);
        }
        return this;
    }

    public c a(boolean z) {
        this.c = z;
        return this;
    }

    public c a(int i2) {
        this.g = i2;
        return this;
    }

    public c a(long j2) {
        this.h = j2;
        sdk.pendo.io.y4.a aVar = this.k;
        if (aVar != null) {
            aVar.b(j2);
        }
        return this;
    }

    public sdk.pendo.io.z4.e a(String str, o oVar) {
        sdk.pendo.io.z4.e eVar = this.v.get(str);
        if (eVar == null) {
            eVar = new sdk.pendo.io.z4.e(this, str, oVar);
            sdk.pendo.io.z4.e eVarPutIfAbsent = this.v.putIfAbsent(str, eVar);
            if (eVarPutIfAbsent != null) {
                return eVarPutIfAbsent;
            }
            eVar.b("connecting", new k(this, eVar));
            eVar.b("connect", new l(eVar, this, str));
        }
        return eVar;
    }
}
