package sdk.pendo.io.d4;

import java.util.concurrent.atomic.AtomicInteger;
import sdk.pendo.io.k3.o;

/* JADX INFO: loaded from: classes4.dex */
public final class h {
    public static void a(sdk.pendo.io.j3.b<?> bVar, AtomicInteger atomicInteger, c cVar) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable thA = cVar.a();
            if (thA != null) {
                bVar.onError(thA);
            } else {
                bVar.onComplete();
            }
        }
    }

    public static void a(o<?> oVar, AtomicInteger atomicInteger, c cVar) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable thA = cVar.a();
            if (thA != null) {
                oVar.onError(thA);
            } else {
                oVar.onComplete();
            }
        }
    }

    public static void a(sdk.pendo.io.j3.b<?> bVar, Throwable th, AtomicInteger atomicInteger, c cVar) {
        if (!cVar.a(th)) {
            sdk.pendo.io.g4.a.b(th);
        } else if (atomicInteger.getAndIncrement() == 0) {
            bVar.onError(cVar.a());
        }
    }

    public static void a(o<?> oVar, Throwable th, AtomicInteger atomicInteger, c cVar) {
        if (!cVar.a(th)) {
            sdk.pendo.io.g4.a.b(th);
        } else if (atomicInteger.getAndIncrement() == 0) {
            oVar.onError(cVar.a());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(sdk.pendo.io.j3.b<? super T> bVar, T t, AtomicInteger atomicInteger, c cVar) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            bVar.onNext(t);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable thA = cVar.a();
                if (thA != null) {
                    bVar.onError(thA);
                } else {
                    bVar.onComplete();
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(o<? super T> oVar, T t, AtomicInteger atomicInteger, c cVar) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            oVar.onNext(t);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable thA = cVar.a();
                if (thA != null) {
                    oVar.onError(thA);
                } else {
                    oVar.onComplete();
                }
            }
        }
    }
}
