package sdk.pendo.io.l5;

import java.io.Serializable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class i implements Serializable {
    private static volatile long h = 1;
    private b b;
    private h c;
    private c d;
    private final AtomicBoolean e = new AtomicBoolean(false);
    private final AtomicBoolean f = new AtomicBoolean(false);
    private final CountDownLatch g = new CountDownLatch(1);
    private final String a = d() + ":" + getClass().getSimpleName();

    public c a() {
        return this.d;
    }

    public synchronized h b() {
        return this.c;
    }

    public boolean c() {
        return this.e.get();
    }

    protected long d() {
        long j = h;
        h = 1 + j;
        return j;
    }

    protected void e() {
        this.e.set(true);
        this.g.countDown();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.a == ((i) obj).a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a;
    }

    protected void a(b<? extends i> bVar) {
        this.b = bVar;
    }

    void a(c cVar) {
        this.d = cVar;
    }

    public synchronized void a(h hVar) {
        this.c = hVar;
    }
}
