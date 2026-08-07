package sdk.pendo.io.z3;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import sdk.pendo.io.d4.l;
import sdk.pendo.io.t3.f;

/* JADX INFO: loaded from: classes6.dex */
public final class c<T> implements f<T> {
    static final int i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object j = new Object();
    int b;
    long c;
    final int d;
    AtomicReferenceArray<Object> e;
    final int f;
    AtomicReferenceArray<Object> g;
    final AtomicLong a = new AtomicLong();
    final AtomicLong h = new AtomicLong();

    public c(int i2) {
        int iA = l.a(Math.max(8, i2));
        int i3 = iA - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(iA + 1);
        this.e = atomicReferenceArray;
        this.d = i3;
        b(iA);
        this.g = atomicReferenceArray;
        this.f = i3;
        this.c = iA - 2;
        b(0L);
    }

    private static int a(long j2, int i2) {
        return c(((int) j2) & i2);
    }

    private void b(int i2) {
        this.b = Math.min(i2 / 4, i);
    }

    private static int c(int i2) {
        return i2;
    }

    private long d() {
        return this.a.get();
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
        return d() == c();
    }

    @Override // sdk.pendo.io.t3.g
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.e;
        long jB = b();
        int i2 = this.d;
        int iA = a(jB, i2);
        if (jB < this.c) {
            return a(atomicReferenceArray, t, jB, iA);
        }
        long j2 = ((long) this.b) + jB;
        if (a(atomicReferenceArray, a(j2, i2)) == null) {
            this.c = j2 - 1;
            return a(atomicReferenceArray, t, jB, iA);
        }
        if (a(atomicReferenceArray, a(jB + 1, i2)) == null) {
            return a(atomicReferenceArray, t, jB, iA);
        }
        a(atomicReferenceArray, jB, iA, t, i2);
        return true;
    }

    @Override // sdk.pendo.io.t3.f, sdk.pendo.io.t3.g
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.g;
        long jA = a();
        int i2 = this.f;
        int iA = a(jA, i2);
        T t = (T) a(atomicReferenceArray, iA);
        boolean z = t == j;
        if (t == null || z) {
            if (z) {
                return a(b(atomicReferenceArray, i2 + 1), jA, i2);
            }
            return null;
        }
        a(atomicReferenceArray, iA, (Object) null);
        a(jA + 1);
        return t;
    }

    private long a() {
        return this.h.get();
    }

    private long b() {
        return this.a.get();
    }

    private long c() {
        return this.h.get();
    }

    private static <E> Object a(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
    }

    private AtomicReferenceArray<Object> b(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        int iC = c(i2);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) a(atomicReferenceArray, iC);
        a(atomicReferenceArray, iC, (Object) null);
        return atomicReferenceArray2;
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2) {
        this.g = atomicReferenceArray;
        int iA = a(j2, i2);
        T t = (T) a(atomicReferenceArray, iA);
        if (t != null) {
            a(atomicReferenceArray, iA, (Object) null);
            a(j2 + 1);
        }
        return t;
    }

    private void b(long j2) {
        this.a.lazySet(j2);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2, T t, long j3) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.e = atomicReferenceArray2;
        this.c = (j3 + j2) - 1;
        a(atomicReferenceArray2, i2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i2, j);
        b(j2 + 1);
    }

    private void a(long j2) {
        this.h.lazySet(j2);
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i2, Object obj) {
        atomicReferenceArray.lazySet(i2, obj);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, c(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j2, int i2) {
        a(atomicReferenceArray, i2, t);
        b(j2 + 1);
        return true;
    }
}
