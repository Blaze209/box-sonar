package sdk.pendo.io.d4;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import sdk.pendo.io.k3.o;

/* JADX INFO: loaded from: classes4.dex */
public final class m {
    public static <T, U> boolean a(boolean z, boolean z2, o<?> oVar, boolean z3, sdk.pendo.io.t3.g<?> gVar, sdk.pendo.io.o3.b bVar, j<T, U> jVar) {
        if (jVar.b()) {
            gVar.clear();
            bVar.dispose();
            return true;
        }
        if (!z) {
            return false;
        }
        if (z3) {
            if (!z2) {
                return false;
            }
            if (bVar != null) {
                bVar.dispose();
            }
            Throwable thC = jVar.c();
            if (thC != null) {
                oVar.onError(thC);
            } else {
                oVar.onComplete();
            }
            return true;
        }
        Throwable thC2 = jVar.c();
        if (thC2 != null) {
            gVar.clear();
            if (bVar != null) {
                bVar.dispose();
            }
            oVar.onError(thC2);
            return true;
        }
        if (!z2) {
            return false;
        }
        if (bVar != null) {
            bVar.dispose();
        }
        oVar.onComplete();
        return true;
    }

    public static <T> boolean b(long j, sdk.pendo.io.j3.b<? super T> bVar, Queue<T> queue, AtomicLong atomicLong, sdk.pendo.io.q3.d dVar) {
        long j2;
        do {
            j2 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j2, d.a(Long.MAX_VALUE & j2, j) | (j2 & Long.MIN_VALUE)));
        if (j2 != Long.MIN_VALUE) {
            return false;
        }
        a(j | Long.MIN_VALUE, bVar, queue, atomicLong, dVar);
        return true;
    }

    public static <T, U> void a(sdk.pendo.io.t3.f<T> fVar, o<? super U> oVar, boolean z, sdk.pendo.io.o3.b bVar, j<T, U> jVar) {
        int iA = 1;
        while (true) {
            sdk.pendo.io.t3.f<T> fVar2 = fVar;
            o<? super U> oVar2 = oVar;
            boolean z2 = z;
            sdk.pendo.io.o3.b bVar2 = bVar;
            j<T, U> jVar2 = jVar;
            if (a(jVar.a(), fVar.isEmpty(), oVar2, z2, fVar2, bVar2, jVar2)) {
                return;
            }
            while (true) {
                boolean zA = jVar2.a();
                T tPoll = fVar2.poll();
                boolean z3 = tPoll == null;
                boolean z4 = z3;
                if (a(zA, z3, oVar2, z2, fVar2, bVar2, jVar2)) {
                    return;
                }
                if (z4) {
                    break;
                } else {
                    jVar2.a(oVar2, tPoll);
                }
            }
            iA = jVar2.a(-iA);
            if (iA == 0) {
                return;
            }
            oVar = oVar2;
            z = z2;
            fVar = fVar2;
            bVar = bVar2;
            jVar = jVar2;
        }
    }

    static boolean a(sdk.pendo.io.q3.d dVar) {
        try {
            return dVar.getAsBoolean();
        } catch (Throwable th) {
            sdk.pendo.io.p3.b.b(th);
            return true;
        }
    }

    public static <T> void a(sdk.pendo.io.j3.b<? super T> bVar, Queue<T> queue, AtomicLong atomicLong, sdk.pendo.io.q3.d dVar) {
        long j;
        long j2;
        if (queue.isEmpty()) {
            bVar.onComplete();
            return;
        }
        if (a(atomicLong.get(), bVar, queue, atomicLong, dVar)) {
            return;
        }
        do {
            j = atomicLong.get();
            if ((j & Long.MIN_VALUE) != 0) {
                return;
            } else {
                j2 = j | Long.MIN_VALUE;
            }
        } while (!atomicLong.compareAndSet(j, j2));
        if (j != 0) {
            a(j2, bVar, queue, atomicLong, dVar);
        }
    }

    static <T> boolean a(long j, sdk.pendo.io.j3.b<? super T> bVar, Queue<T> queue, AtomicLong atomicLong, sdk.pendo.io.q3.d dVar) {
        long j2 = j & Long.MIN_VALUE;
        while (true) {
            if (j2 != j) {
                if (a(dVar)) {
                    return true;
                }
                T tPoll = queue.poll();
                if (tPoll == null) {
                    bVar.onComplete();
                    return true;
                }
                bVar.onNext(tPoll);
                j2++;
            } else {
                if (a(dVar)) {
                    return true;
                }
                if (queue.isEmpty()) {
                    bVar.onComplete();
                    return true;
                }
                j = atomicLong.get();
                if (j == j2) {
                    long jAddAndGet = atomicLong.addAndGet(-(j2 & Long.MAX_VALUE));
                    if ((Long.MAX_VALUE & jAddAndGet) == 0) {
                        return false;
                    }
                    j2 = jAddAndGet & Long.MIN_VALUE;
                    j = jAddAndGet;
                } else {
                    continue;
                }
            }
        }
    }
}
