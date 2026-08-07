package sdk.pendo.io.c5;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import sdk.pendo.io.e2.b0;
import sdk.pendo.io.e2.c0;
import sdk.pendo.io.e2.d0;
import sdk.pendo.io.e2.e0;
import sdk.pendo.io.e2.v;
import sdk.pendo.io.e2.x;
import sdk.pendo.io.e2.z;

/* JADX INFO: loaded from: classes4.dex */
public class b extends sdk.pendo.io.c5.a {
    private static final Logger q;
    private static boolean r;

    class a implements sdk.pendo.io.a5.a.InterfaceC0343a {
        final /* synthetic */ b a;

        /* JADX INFO: renamed from: sdk.pendo.io.c5.b$a$a, reason: collision with other inner class name */
        class RunnableC0361a implements Runnable {
            final /* synthetic */ Object[] a;

            RunnableC0361a(Object[] objArr) {
                this.a = objArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.a("responseHeaders", this.a[0]);
            }
        }

        a(b bVar) {
            this.a = bVar;
        }

        @Override // sdk.pendo.io.a5.a.InterfaceC0343a
        public void call(Object... objArr) {
            sdk.pendo.io.i5.a.a(new RunnableC0361a(objArr));
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.c5.b$b, reason: collision with other inner class name */
    class C0362b implements sdk.pendo.io.a5.a.InterfaceC0343a {
        final /* synthetic */ b a;

        C0362b(b bVar) {
            this.a = bVar;
        }

        @Override // sdk.pendo.io.a5.a.InterfaceC0343a
        public void call(Object... objArr) {
            this.a.a("requestHeaders", objArr[0]);
        }
    }

    class c implements sdk.pendo.io.a5.a.InterfaceC0343a {
        final /* synthetic */ Runnable a;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.a.run();
            }
        }

        c(Runnable runnable) {
            this.a = runnable;
        }

        @Override // sdk.pendo.io.a5.a.InterfaceC0343a
        public void call(Object... objArr) {
            sdk.pendo.io.i5.a.a(new a());
        }
    }

    class d implements sdk.pendo.io.a5.a.InterfaceC0343a {
        final /* synthetic */ b a;

        class a implements Runnable {
            final /* synthetic */ Object[] a;

            a(Object[] objArr) {
                this.a = objArr;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x000f  */
            @Override // java.lang.Runnable
            public void run() {
                Exception exc;
                Object[] objArr = this.a;
                if (objArr.length > 0) {
                    Object obj = objArr[0];
                    if (obj instanceof Exception) {
                        exc = (Exception) obj;
                    } else {
                        exc = null;
                    }
                } else {
                    exc = null;
                }
                d.this.a.a("xhr post error", exc);
            }
        }

        d(b bVar) {
            this.a = bVar;
        }

        @Override // sdk.pendo.io.a5.a.InterfaceC0343a
        public void call(Object... objArr) {
            sdk.pendo.io.i5.a.a(new a(objArr));
        }
    }

    class e implements sdk.pendo.io.a5.a.InterfaceC0343a {
        final /* synthetic */ b a;

        class a implements Runnable {
            final /* synthetic */ Object[] a;

            a(Object[] objArr) {
                this.a = objArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                Object[] objArr = this.a;
                Object obj = objArr.length > 0 ? objArr[0] : null;
                if (obj instanceof String) {
                    e.this.a.b((String) obj);
                } else if (obj instanceof byte[]) {
                    e.this.a.a((byte[]) obj);
                }
            }
        }

        e(b bVar) {
            this.a = bVar;
        }

        @Override // sdk.pendo.io.a5.a.InterfaceC0343a
        public void call(Object... objArr) {
            sdk.pendo.io.i5.a.a(new a(objArr));
        }
    }

    class f implements sdk.pendo.io.a5.a.InterfaceC0343a {
        final /* synthetic */ b a;

        class a implements Runnable {
            final /* synthetic */ Object[] a;

            a(Object[] objArr) {
                this.a = objArr;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x000f  */
            @Override // java.lang.Runnable
            public void run() {
                Exception exc;
                Object[] objArr = this.a;
                if (objArr.length > 0) {
                    Object obj = objArr[0];
                    if (obj instanceof Exception) {
                        exc = (Exception) obj;
                    } else {
                        exc = null;
                    }
                } else {
                    exc = null;
                }
                f.this.a.a("xhr poll error", exc);
            }
        }

        f(b bVar) {
            this.a = bVar;
        }

        @Override // sdk.pendo.io.a5.a.InterfaceC0343a
        public void call(Object... objArr) {
            sdk.pendo.io.i5.a.a(new a(objArr));
        }
    }

    public static class g extends sdk.pendo.io.a5.a {
        private static final x h = x.c("application/octet-stream");
        private static final x i = x.c("text/plain;charset=UTF-8");
        private String b;
        private String c;
        private Object d;
        private sdk.pendo.io.e2.e.a e;
        private d0 f;
        private sdk.pendo.io.e2.e g;

        class a implements sdk.pendo.io.e2.f {
            final /* synthetic */ g a;

            a(g gVar) {
                this.a = gVar;
            }

            @Override // sdk.pendo.io.e2.f
            public void a(sdk.pendo.io.e2.e eVar, IOException iOException) {
                this.a.a(iOException);
            }

            @Override // sdk.pendo.io.e2.f
            public void a(sdk.pendo.io.e2.e eVar, d0 d0Var) {
                g gVar = this.a;
                gVar.f = d0Var;
                gVar.b(d0Var.getHeaders().b());
                try {
                    if (d0Var.j()) {
                        this.a.c();
                    } else {
                        this.a.a(new IOException(Integer.toString(d0Var.getCode())));
                    }
                } finally {
                    d0Var.close();
                }
            }
        }

        /* JADX INFO: renamed from: sdk.pendo.io.c5.b$g$b, reason: collision with other inner class name */
        public static class C0363b {
            public String a;
            public String b;
            public Object c;
            public sdk.pendo.io.e2.e.a d;
        }

        public g(C0363b c0363b) {
            String str = c0363b.b;
            this.b = str == null ? "GET" : str;
            this.c = c0363b.a;
            this.d = c0363b.c;
            sdk.pendo.io.e2.e.a aVar = c0363b.d;
            this.e = aVar == null ? new z() : aVar;
        }

        private void a(byte[] bArr) {
            a("data", bArr);
            d();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            e0 e0VarB = this.f.b();
            try {
                if ("application/octet-stream".equalsIgnoreCase(e0VarB.getC().getMediaType())) {
                    a(e0VarB.b());
                } else {
                    b(e0VarB.h());
                }
            } catch (IOException e) {
                a(e);
            }
        }

        private void d() {
            a("success", new Object[0]);
        }

        public void b() {
            if (b.r) {
                b.q.fine(String.format("xhr open %s: %s", this.b, this.c));
            }
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            if ("POST".equals(this.b)) {
                treeMap.put("Content-type", this.d instanceof byte[] ? new LinkedList(Collections.singletonList("application/octet-stream")) : new LinkedList(Collections.singletonList("text/plain;charset=UTF-8")));
            }
            treeMap.put("Accept", new LinkedList(Collections.singletonList("*/*")));
            a(treeMap);
            if (b.r) {
                Logger logger = b.q;
                String str = this.c;
                Object string = this.d;
                if (string instanceof byte[]) {
                    string = Arrays.toString((byte[]) string);
                }
                logger.fine(String.format("sending xhr with url %s | data %s", str, string));
            }
            b0.a aVar = new b0.a();
            for (Map.Entry<String, List<String>> entry : treeMap.entrySet()) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    aVar.a(entry.getKey(), it.next());
                }
            }
            Object obj = this.d;
            sdk.pendo.io.e2.e eVarA = this.e.a(aVar.a(v.c(this.c)).a(this.b, obj instanceof byte[] ? c0.a(h, (byte[]) obj) : obj instanceof String ? c0.a(i, (String) obj) : null).a());
            this.g = eVarA;
            eVarA.a(new a(this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Exception exc) {
            a("error", exc);
        }

        private void b(String str) {
            a("data", str);
            d();
        }

        private void a(Map<String, List<String>> map) {
            a("requestHeaders", map);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Map<String, List<String>> map) {
            a("responseHeaders", map);
        }
    }

    static {
        Logger logger = Logger.getLogger(b.class.getName());
        q = logger;
        r = logger.isLoggable(Level.FINE);
    }

    public b(sdk.pendo.io.b5.d.C0355d c0355d) {
        super(c0355d);
    }

    @Override // sdk.pendo.io.c5.a
    protected void h() {
        q.fine("xhr poll");
        g gVarK = k();
        gVarK.b("data", new e(this));
        gVarK.b("error", new f(this));
        gVarK.b();
    }

    protected g k() {
        return a((g.C0363b) null);
    }

    private void a(Object obj, Runnable runnable) {
        g.C0363b c0363b = new g.C0363b();
        c0363b.b = "POST";
        c0363b.c = obj;
        g gVarA = a(c0363b);
        gVarA.b("success", new c(runnable));
        gVarA.b("error", new d(this));
        gVarA.b();
    }

    @Override // sdk.pendo.io.c5.a
    protected void a(String str, Runnable runnable) {
        a((Object) str, runnable);
    }

    @Override // sdk.pendo.io.c5.a
    protected void a(byte[] bArr, Runnable runnable) {
        a((Object) bArr, runnable);
    }

    protected g a(g.C0363b c0363b) {
        if (c0363b == null) {
            c0363b = new g.C0363b();
        }
        c0363b.a = j();
        c0363b.d = this.n;
        g gVar = new g(c0363b);
        gVar.b("requestHeaders", new C0362b(this)).b("responseHeaders", new a(this));
        return gVar;
    }
}
