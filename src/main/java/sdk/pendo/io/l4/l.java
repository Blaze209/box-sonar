package sdk.pendo.io.l4;

import java.io.IOException;
import java.util.Objects;
import javax.annotation.Nullable;
import sdk.pendo.io.e2.b0;
import sdk.pendo.io.e2.d0;
import sdk.pendo.io.e2.e0;
import sdk.pendo.io.e2.x;
import sdk.pendo.io.s2.a0;

/* JADX INFO: loaded from: classes4.dex */
final class l<T> implements sdk.pendo.io.l4.b<T> {
    private final q a;
    private final Object[] b;
    private final sdk.pendo.io.e2.e.a c;
    private final f<e0, T> d;
    private volatile boolean e;

    @Nullable
    private sdk.pendo.io.e2.e f;

    @Nullable
    private Throwable g;
    private boolean h;

    class a implements sdk.pendo.io.e2.f {
        final /* synthetic */ d a;

        a(d dVar) {
            this.a = dVar;
        }

        private void a(Throwable th) {
            try {
                this.a.a(l.this, th);
            } catch (Throwable th2) {
                w.a(th2);
                th2.printStackTrace();
            }
        }

        @Override // sdk.pendo.io.e2.f
        public void a(sdk.pendo.io.e2.e eVar, IOException iOException) {
            a(iOException);
        }

        @Override // sdk.pendo.io.e2.f
        public void a(sdk.pendo.io.e2.e eVar, d0 d0Var) {
            try {
                try {
                    this.a.a(l.this, l.this.a(d0Var));
                } catch (Throwable th) {
                    w.a(th);
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                w.a(th2);
                a(th2);
            }
        }
    }

    static final class b extends e0 {
        private final e0 c;
        private final sdk.pendo.io.s2.f d;

        @Nullable
        IOException e;

        class a extends sdk.pendo.io.s2.j {
            a(a0 a0Var) {
                super(a0Var);
            }

            @Override // sdk.pendo.io.s2.j, sdk.pendo.io.s2.a0
            public long b(sdk.pendo.io.s2.d dVar, long j) throws IOException {
                try {
                    return super.b(dVar, j);
                } catch (IOException e) {
                    b.this.e = e;
                    throw e;
                }
            }
        }

        b(e0 e0Var) {
            this.c = e0Var;
            this.d = sdk.pendo.io.s2.o.a(new a(e0Var.getSource()));
        }

        @Override // sdk.pendo.io.e2.e0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.c.close();
        }

        @Override // sdk.pendo.io.e2.e0
        /* JADX INFO: renamed from: e */
        public long getContentLength() {
            return this.c.getContentLength();
        }

        @Override // sdk.pendo.io.e2.e0
        /* JADX INFO: renamed from: f */
        public x getC() {
            return this.c.getC();
        }

        @Override // sdk.pendo.io.e2.e0
        /* JADX INFO: renamed from: g */
        public sdk.pendo.io.s2.f getSource() {
            return this.d;
        }

        void i() throws IOException {
            IOException iOException = this.e;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    static final class c extends e0 {

        @Nullable
        private final x c;
        private final long d;

        c(@Nullable x xVar, long j) {
            this.c = xVar;
            this.d = j;
        }

        @Override // sdk.pendo.io.e2.e0
        /* JADX INFO: renamed from: e */
        public long getContentLength() {
            return this.d;
        }

        @Override // sdk.pendo.io.e2.e0
        /* JADX INFO: renamed from: f */
        public x getC() {
            return this.c;
        }

        @Override // sdk.pendo.io.e2.e0
        /* JADX INFO: renamed from: g */
        public sdk.pendo.io.s2.f getSource() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    l(q qVar, Object[] objArr, sdk.pendo.io.e2.e.a aVar, f<e0, T> fVar) {
        this.a = qVar;
        this.b = objArr;
        this.c = aVar;
        this.d = fVar;
    }

    private sdk.pendo.io.e2.e b() {
        sdk.pendo.io.e2.e eVarA = this.c.a(this.a.a(this.b));
        if (eVarA != null) {
            return eVarA;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    private sdk.pendo.io.e2.e c() throws IOException {
        sdk.pendo.io.e2.e eVar = this.f;
        if (eVar != null) {
            return eVar;
        }
        Throwable th = this.g;
        if (th != null) {
            if (th instanceof IOException) {
                throw ((IOException) th);
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw ((Error) th);
        }
        try {
            sdk.pendo.io.e2.e eVarB = b();
            this.f = eVarB;
            return eVarB;
        } catch (IOException | Error | RuntimeException e) {
            w.a(e);
            this.g = e;
            throw e;
        }
    }

    @Override // sdk.pendo.io.l4.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public l<T> clone() {
        return new l<>(this.a, this.b, this.c, this.d);
    }

    @Override // sdk.pendo.io.l4.b
    public void cancel() {
        sdk.pendo.io.e2.e eVar;
        this.e = true;
        synchronized (this) {
            eVar = this.f;
        }
        if (eVar != null) {
            eVar.cancel();
        }
    }

    @Override // sdk.pendo.io.l4.b
    public r<T> execute() {
        sdk.pendo.io.e2.e eVarC;
        synchronized (this) {
            if (this.h) {
                throw new IllegalStateException("Already executed.");
            }
            this.h = true;
            eVarC = c();
        }
        if (this.e) {
            eVarC.cancel();
        }
        return a(eVarC.execute());
    }

    @Override // sdk.pendo.io.l4.b
    public boolean isCanceled() {
        boolean z = true;
        if (this.e) {
            return true;
        }
        synchronized (this) {
            sdk.pendo.io.e2.e eVar = this.f;
            if (eVar == null || !eVar.getCanceled()) {
                z = false;
            }
        }
        return z;
    }

    @Override // sdk.pendo.io.l4.b
    public synchronized b0 request() {
        try {
        } catch (IOException e) {
            throw new RuntimeException("Unable to create request.", e);
        }
        return c().request();
    }

    @Override // sdk.pendo.io.l4.b
    public void a(d<T> dVar) {
        sdk.pendo.io.e2.e eVar;
        Throwable th;
        Objects.requireNonNull(dVar, "callback == null");
        synchronized (this) {
            if (this.h) {
                throw new IllegalStateException("Already executed.");
            }
            this.h = true;
            eVar = this.f;
            th = this.g;
            if (eVar == null && th == null) {
                try {
                    sdk.pendo.io.e2.e eVarB = b();
                    this.f = eVarB;
                    eVar = eVarB;
                } catch (Throwable th2) {
                    th = th2;
                    w.a(th);
                    this.g = th;
                }
            }
        }
        if (th != null) {
            dVar.a(this, th);
            return;
        }
        if (this.e) {
            eVar.cancel();
        }
        eVar.a(new a(dVar));
    }

    r<T> a(d0 d0Var) throws IOException {
        e0 e0VarB = d0Var.b();
        d0 d0VarA = d0Var.m().a(new c(e0VarB.getC(), e0VarB.getContentLength())).a();
        int code = d0VarA.getCode();
        if (code < 200 || code >= 300) {
            try {
                return r.a(w.a(e0VarB), d0VarA);
            } finally {
                e0VarB.close();
            }
        }
        if (code == 204 || code == 205) {
            e0VarB.close();
            return r.a((Object) null, d0VarA);
        }
        b bVar = new b(e0VarB);
        try {
            return r.a(this.d.convert(bVar), d0VarA);
        } catch (RuntimeException e) {
            bVar.i();
            throw e;
        }
    }
}
