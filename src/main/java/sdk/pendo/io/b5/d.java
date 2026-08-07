package sdk.pendo.io.b5;

import java.util.Locale;
import java.util.Map;
import org.apache.hc.core5.http.HeaderElements;
import sdk.pendo.io.e2.h0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d extends sdk.pendo.io.a5.a {
    public boolean b;
    public String c;
    public Map<String, String> d;
    protected boolean e;
    protected boolean f;
    protected int g;
    protected String h;
    protected String i;
    protected String j;
    protected sdk.pendo.io.b5.c k;
    protected e l;
    protected h0.a m;
    protected sdk.pendo.io.e2.e.a n;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            e eVar = dVar.l;
            if (eVar == e.CLOSED || eVar == null) {
                dVar.l = e.OPENING;
                dVar.d();
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            e eVar = dVar.l;
            if (eVar == e.OPENING || eVar == e.OPEN) {
                dVar.c();
                d.this.e();
            }
        }
    }

    class c implements Runnable {
        final /* synthetic */ sdk.pendo.io.d5.b[] a;

        c(sdk.pendo.io.d5.b[] bVarArr) {
            this.a = bVarArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            if (dVar.l != e.OPEN) {
                throw new RuntimeException("Transport not open");
            }
            try {
                dVar.b(this.a);
            } catch (sdk.pendo.io.j5.b e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.b5.d$d, reason: collision with other inner class name */
    public static class C0355d {
        public String a;
        public String b;
        public String c;
        public boolean d;
        public boolean e;
        public int f = -1;
        public int g = -1;
        public Map<String, String> h;
        protected sdk.pendo.io.b5.c i;
        public h0.a j;
        public sdk.pendo.io.e2.e.a k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public enum e {
        OPENING,
        OPEN,
        CLOSED,
        PAUSED;

        @Override // java.lang.Enum
        public String toString() {
            return super.toString().toLowerCase(Locale.US);
        }
    }

    public d(C0355d c0355d) {
        this.h = c0355d.b;
        this.i = c0355d.a;
        this.g = c0355d.f;
        this.e = c0355d.d;
        this.d = c0355d.h;
        this.j = c0355d.c;
        this.f = c0355d.e;
        this.k = c0355d.i;
        this.m = c0355d.j;
        this.n = c0355d.k;
    }

    protected void a(byte[] bArr) {
        a(sdk.pendo.io.d5.c.b(bArr));
    }

    public d b() {
        sdk.pendo.io.i5.a.a(new b());
        return this;
    }

    protected abstract void b(sdk.pendo.io.d5.b[] bVarArr);

    protected abstract void c();

    protected abstract void d();

    protected void e() {
        this.l = e.CLOSED;
        a(HeaderElements.CLOSE, new Object[0]);
    }

    protected void f() {
        this.l = e.OPEN;
        this.b = true;
        a("open", new Object[0]);
    }

    public d g() {
        sdk.pendo.io.i5.a.a(new a());
        return this;
    }

    protected d a(String str, Exception exc) {
        a("error", new sdk.pendo.io.b5.a(str, exc));
        return this;
    }

    protected void b(String str) {
        a(sdk.pendo.io.d5.c.a(str));
    }

    protected void a(sdk.pendo.io.d5.b bVar) {
        a("packet", bVar);
    }

    public void a(sdk.pendo.io.d5.b[] bVarArr) {
        sdk.pendo.io.i5.a.a(new c(bVarArr));
    }
}
