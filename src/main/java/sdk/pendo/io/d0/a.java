package sdk.pendo.io.d0;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import sdk.pendo.io.a0.f;
import sdk.pendo.io.a0.i;
import sdk.pendo.io.a0.k;
import sdk.pendo.io.a0.l;
import sdk.pendo.io.a0.n;
import sdk.pendo.io.h0.c;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends c {
    private static final Writer p = new C0370a();
    private static final n q = new n("closed");
    private final List<i> m;
    private String n;
    private i o;

    /* JADX INFO: renamed from: sdk.pendo.io.d0.a$a, reason: collision with other inner class name */
    class C0370a extends Writer {
        C0370a() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    }

    public a() {
        super(p);
        this.m = new ArrayList();
        this.o = k.a;
    }

    private i o() {
        List<i> list = this.m;
        return list.get(list.size() - 1);
    }

    @Override // sdk.pendo.io.h0.c
    public c a(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.m.isEmpty() || this.n != null) {
            throw new IllegalStateException();
        }
        if (!(o() instanceof l)) {
            throw new IllegalStateException();
        }
        this.n = str;
        return this;
    }

    @Override // sdk.pendo.io.h0.c
    public c c() {
        f fVar = new f();
        a(fVar);
        this.m.add(fVar);
        return this;
    }

    @Override // sdk.pendo.io.h0.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.m.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.m.add(q);
    }

    @Override // sdk.pendo.io.h0.c
    public c d() {
        l lVar = new l();
        a(lVar);
        this.m.add(lVar);
        return this;
    }

    @Override // sdk.pendo.io.h0.c
    public c e() {
        if (this.m.isEmpty() || this.n != null) {
            throw new IllegalStateException();
        }
        if (!(o() instanceof f)) {
            throw new IllegalStateException();
        }
        List<i> list = this.m;
        list.remove(list.size() - 1);
        return this;
    }

    @Override // sdk.pendo.io.h0.c
    public c f() {
        if (this.m.isEmpty() || this.n != null) {
            throw new IllegalStateException();
        }
        if (!(o() instanceof l)) {
            throw new IllegalStateException();
        }
        List<i> list = this.m;
        list.remove(list.size() - 1);
        return this;
    }

    @Override // sdk.pendo.io.h0.c, java.io.Flushable
    public void flush() {
    }

    @Override // sdk.pendo.io.h0.c
    public c k() {
        a(k.a);
        return this;
    }

    public i n() {
        if (this.m.isEmpty()) {
            return this.o;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.m);
    }

    private void a(i iVar) {
        if (this.n != null) {
            if (!iVar.i() || g()) {
                ((l) o()).a(this.n, iVar);
            }
            this.n = null;
            return;
        }
        if (this.m.isEmpty()) {
            this.o = iVar;
            return;
        }
        i iVarO = o();
        if (!(iVarO instanceof f)) {
            throw new IllegalStateException();
        }
        ((f) iVarO).a(iVar);
    }

    @Override // sdk.pendo.io.h0.c
    public c d(String str) {
        if (str == null) {
            return k();
        }
        a(new n(str));
        return this;
    }

    @Override // sdk.pendo.io.h0.c
    public c a(long j) {
        a(new n(Long.valueOf(j)));
        return this;
    }

    @Override // sdk.pendo.io.h0.c
    public c d(boolean z) {
        a(new n(Boolean.valueOf(z)));
        return this;
    }

    @Override // sdk.pendo.io.h0.c
    public c a(Boolean bool) {
        if (bool == null) {
            return k();
        }
        a(new n(bool));
        return this;
    }

    @Override // sdk.pendo.io.h0.c
    public c a(Number number) {
        if (number == null) {
            return k();
        }
        if (!i()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        a(new n(number));
        return this;
    }
}
