package sdk.pendo.io.c4;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.d4.d;

/* JADX INFO: loaded from: classes4.dex */
public class b extends AtomicInteger implements sdk.pendo.io.j3.c {
    sdk.pendo.io.j3.c a;
    long b;
    final AtomicReference<sdk.pendo.io.j3.c> c = new AtomicReference<>();
    final AtomicLong d = new AtomicLong();
    final AtomicLong e = new AtomicLong();
    final boolean f;
    volatile boolean g;
    protected boolean h;

    public b(boolean z) {
        this.f = z;
    }

    final void a() {
        if (getAndIncrement() != 0) {
            return;
        }
        b();
    }

    final void b() {
        int iAddAndGet = 1;
        long jA = 0;
        sdk.pendo.io.j3.c cVar = null;
        do {
            sdk.pendo.io.j3.c andSet = this.c.get();
            if (andSet != null) {
                andSet = this.c.getAndSet(null);
            }
            long andSet2 = this.d.get();
            if (andSet2 != 0) {
                andSet2 = this.d.getAndSet(0L);
            }
            long andSet3 = this.e.get();
            if (andSet3 != 0) {
                andSet3 = this.e.getAndSet(0L);
            }
            sdk.pendo.io.j3.c cVar2 = this.a;
            if (this.g) {
                if (cVar2 != null) {
                    cVar2.cancel();
                    this.a = null;
                }
                if (andSet != null) {
                    andSet.cancel();
                }
            } else {
                long jA2 = this.b;
                if (jA2 != Long.MAX_VALUE) {
                    jA2 = d.a(jA2, andSet2);
                    if (jA2 != Long.MAX_VALUE) {
                        jA2 -= andSet3;
                        if (jA2 < 0) {
                            c.a(jA2);
                            jA2 = 0;
                        }
                    }
                    this.b = jA2;
                }
                if (andSet != null) {
                    if (cVar2 != null && this.f) {
                        cVar2.cancel();
                    }
                    this.a = andSet;
                    if (jA2 != 0) {
                        jA = d.a(jA, jA2);
                        cVar = andSet;
                    }
                } else if (cVar2 != null && andSet2 != 0) {
                    jA = d.a(jA, andSet2);
                    cVar = cVar2;
                }
            }
            iAddAndGet = addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
        if (jA != 0) {
            cVar.request(jA);
        }
    }

    @Override // sdk.pendo.io.j3.c
    public void cancel() {
        if (this.g) {
            return;
        }
        this.g = true;
        a();
    }

    @Override // sdk.pendo.io.j3.c
    public final void request(long j) {
        if (!c.b(j) || this.h) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            d.a(this.d, j);
            a();
            return;
        }
        long j2 = this.b;
        if (j2 != Long.MAX_VALUE) {
            long jA = d.a(j2, j);
            this.b = jA;
            if (jA == Long.MAX_VALUE) {
                this.h = true;
            }
        }
        sdk.pendo.io.j3.c cVar = this.a;
        if (decrementAndGet() != 0) {
            b();
        }
        if (cVar != null) {
            cVar.request(j);
        }
    }

    public final void b(long j) {
        if (this.h) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            d.a(this.e, j);
            a();
            return;
        }
        long j2 = this.b;
        if (j2 != Long.MAX_VALUE) {
            long j3 = j2 - j;
            if (j3 < 0) {
                c.a(j3);
                j3 = 0;
            }
            this.b = j3;
        }
        if (decrementAndGet() == 0) {
            return;
        }
        b();
    }

    public final void b(sdk.pendo.io.j3.c cVar) {
        if (this.g) {
            cVar.cancel();
            return;
        }
        sdk.pendo.io.s3.b.a(cVar, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            sdk.pendo.io.j3.c andSet = this.c.getAndSet(cVar);
            if (andSet != null && this.f) {
                andSet.cancel();
            }
            a();
            return;
        }
        sdk.pendo.io.j3.c cVar2 = this.a;
        if (cVar2 != null && this.f) {
            cVar2.cancel();
        }
        this.a = cVar;
        long j = this.b;
        if (decrementAndGet() != 0) {
            b();
        }
        if (j != 0) {
            cVar.request(j);
        }
    }
}
