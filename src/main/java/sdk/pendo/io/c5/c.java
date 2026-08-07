package sdk.pendo.io.c5;

import com.microsoft.identity.client.internal.MsalUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;
import sdk.pendo.io.b5.d;
import sdk.pendo.io.e2.b0;
import sdk.pendo.io.e2.d0;
import sdk.pendo.io.e2.h0;
import sdk.pendo.io.e2.i0;
import sdk.pendo.io.e2.z;
import sdk.pendo.io.s2.g;

/* JADX INFO: loaded from: classes4.dex */
public class c extends d {
    private static final Logger p = Logger.getLogger(sdk.pendo.io.c5.b.class.getName());
    private h0 o;

    class a extends i0 {
        final /* synthetic */ c a;

        /* JADX INFO: renamed from: sdk.pendo.io.c5.c$a$a, reason: collision with other inner class name */
        class RunnableC0364a implements Runnable {
            final /* synthetic */ Map a;

            RunnableC0364a(Map map) {
                this.a = map;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.a("responseHeaders", this.a);
                a.this.a.f();
            }
        }

        class b implements Runnable {
            final /* synthetic */ String a;

            b(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.b(this.a);
            }
        }

        /* JADX INFO: renamed from: sdk.pendo.io.c5.c$a$c, reason: collision with other inner class name */
        class RunnableC0365c implements Runnable {
            final /* synthetic */ g a;

            RunnableC0365c(g gVar) {
                this.a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.a(this.a.l());
            }
        }

        class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.e();
            }
        }

        class e implements Runnable {
            final /* synthetic */ Throwable a;

            e(Throwable th) {
                this.a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.a("websocket error", (Exception) this.a);
            }
        }

        a(c cVar) {
            this.a = cVar;
        }

        @Override // sdk.pendo.io.e2.i0
        public void a(h0 h0Var, int i, String str) {
            sdk.pendo.io.i5.a.a(new d());
        }

        @Override // sdk.pendo.io.e2.i0
        public void a(h0 h0Var, Throwable th, d0 d0Var) {
            if (th instanceof Exception) {
                sdk.pendo.io.i5.a.a(new e(th));
            }
        }

        @Override // sdk.pendo.io.e2.i0
        public void a(h0 h0Var, String str) {
            if (str == null) {
                return;
            }
            sdk.pendo.io.i5.a.a(new b(str));
        }

        @Override // sdk.pendo.io.e2.i0
        public void a(h0 h0Var, g gVar) {
            if (gVar == null) {
                return;
            }
            sdk.pendo.io.i5.a.a(new RunnableC0365c(gVar));
        }

        @Override // sdk.pendo.io.e2.i0
        public void a(h0 h0Var, d0 d0Var) {
            sdk.pendo.io.i5.a.a(new RunnableC0364a(d0Var.getHeaders().b()));
        }
    }

    class b implements Runnable {
        final /* synthetic */ c a;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = b.this.a;
                cVar.b = true;
                cVar.a("drain", new Object[0]);
            }
        }

        b(c cVar) {
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            sdk.pendo.io.i5.a.b(new a());
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.c5.c$c, reason: collision with other inner class name */
    class C0366c implements sdk.pendo.io.d5.c.f {
        final /* synthetic */ c a;
        final /* synthetic */ int[] b;
        final /* synthetic */ Runnable c;

        C0366c(c cVar, int[] iArr, Runnable runnable) {
            this.a = cVar;
            this.b = iArr;
            this.c = runnable;
        }

        @Override // sdk.pendo.io.d5.c.f
        public void a(Object obj) {
            try {
                if (obj instanceof String) {
                    this.a.o.send((String) obj);
                } else if (obj instanceof byte[]) {
                    this.a.o.a(g.a((byte[]) obj));
                }
            } catch (IllegalStateException unused) {
                c.p.fine("websocket closed before we could write");
            }
            int[] iArr = this.b;
            int i = iArr[0] - 1;
            iArr[0] = i;
            if (i == 0) {
                this.c.run();
            }
        }
    }

    public c(d.C0355d c0355d) {
        super(c0355d);
        this.c = "websocket";
    }

    @Override // sdk.pendo.io.b5.d
    protected void c() {
        h0 h0Var = this.o;
        if (h0Var != null) {
            h0Var.close(1000, "");
            this.o = null;
        }
    }

    @Override // sdk.pendo.io.b5.d
    protected void d() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        a("requestHeaders", treeMap);
        h0.a zVar = this.m;
        if (zVar == null) {
            zVar = new z();
        }
        b0.a aVarB = new b0.a().b(h());
        for (Map.Entry entry : treeMap.entrySet()) {
            Iterator it = ((List) entry.getValue()).iterator();
            while (it.hasNext()) {
                aVarB.a((String) entry.getKey(), (String) it.next());
            }
        }
        this.o = zVar.a(aVarB.a(), new a(this));
    }

    protected String h() {
        Map map = this.d;
        if (map == null) {
            map = new HashMap();
        }
        String str = this.e ? "wss" : "ws";
        String str2 = (this.g <= 0 || ((!"wss".equals(str) || this.g == 443) && (!"ws".equals(str) || this.g == 80))) ? "" : ":" + this.g;
        if (this.f) {
            map.put(this.j, sdk.pendo.io.k5.a.a());
        }
        String strA = sdk.pendo.io.g5.a.a((Map<String, String>) map);
        if (strA.length() > 0) {
            strA = MsalUtils.QUERY_STRING_SYMBOL + strA;
        }
        return str + "://" + (this.i.contains(":") ? "[" + this.i + "]" : this.i) + str2 + this.h + strA;
    }

    @Override // sdk.pendo.io.b5.d
    protected void b(sdk.pendo.io.d5.b[] bVarArr) {
        this.b = false;
        b bVar = new b(this);
        int[] iArr = {bVarArr.length};
        for (sdk.pendo.io.d5.b bVar2 : bVarArr) {
            d.e eVar = this.l;
            if (eVar != d.e.OPENING && eVar != d.e.OPEN) {
                return;
            }
            sdk.pendo.io.d5.c.c(bVar2, new C0366c(this, iArr, bVar));
        }
    }
}
