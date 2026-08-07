package sdk.pendo.io.z3;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import sdk.pendo.io.d4.l;
import sdk.pendo.io.t3.f;

/* JADX INFO: loaded from: classes6.dex */
public final class b<E> extends AtomicReferenceArray<E> implements f<E> {
    private static final Integer f = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    final int a;
    final AtomicLong b;
    long c;
    final AtomicLong d;
    final int e;

    public b(int i) {
        super(l.a(i));
        this.a = length() - 1;
        this.b = new AtomicLong();
        this.d = new AtomicLong();
        this.e = Math.min(i / 4, f.intValue());
    }

    int a(long j) {
        return this.a & ((int) j);
    }

    int a(long j, int i) {
        return ((int) j) & i;
    }

    E b(int i) {
        return get(i);
    }

    void c(long j) {
        this.b.lazySet(j);
    }

    @Override // sdk.pendo.io.t3.g
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // sdk.pendo.io.t3.g
    public boolean isEmpty() {
        return this.b.get() == this.d.get();
    }

    @Override // sdk.pendo.io.t3.g
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        int i = this.a;
        long j = this.b.get();
        int iA = a(j, i);
        if (j >= this.c) {
            long j2 = ((long) this.e) + j;
            if (b(a(j2, i)) == null) {
                this.c = j2;
            } else if (b(iA) != null) {
                return false;
            }
        }
        a(iA, e);
        c(j + 1);
        return true;
    }

    @Override // sdk.pendo.io.t3.f, sdk.pendo.io.t3.g
    public E poll() {
        long j = this.d.get();
        int iA = a(j);
        E eB = b(iA);
        if (eB == null) {
            return null;
        }
        b(j + 1);
        a(iA, (Object) null);
        return eB;
    }

    void b(long j) {
        this.d.lazySet(j);
    }

    void a(int i, E e) {
        lazySet(i, e);
    }
}
