package sdk.pendo.io.a4;

import com.google.common.util.concurrent.Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes4.dex */
public final class k extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, sdk.pendo.io.o3.b {
    static final Object b = new Object();
    static final Object c = new Object();
    static final Object d = new Object();
    static final Object e = new Object();
    final Runnable a;

    public k(Runnable runnable, sdk.pendo.io.r3.a aVar) {
        super(3);
        this.a = runnable;
        lazySet(0, aVar);
    }

    public void a(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == e) {
                return;
            }
            if (obj == c) {
                future.cancel(false);
                return;
            } else if (obj == d) {
                future.cancel(true);
                return;
            }
        } while (!Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0.m(this, 1, obj, future));
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    @Override // sdk.pendo.io.o3.b
    public void dispose() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        while (true) {
            Object obj5 = get(1);
            if (obj5 == e || obj5 == (obj3 = c) || obj5 == (obj4 = d)) {
                break;
            }
            boolean z = get(2) != Thread.currentThread();
            if (z) {
                obj3 = obj4;
            }
            if (Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0.m(this, 1, obj5, obj3)) {
                if (obj5 == null) {
                    break;
                }
                ((Future) obj5).cancel(z);
                break;
            }
        }
        do {
            obj = get(0);
            if (obj == e || obj == (obj2 = b) || obj == null) {
                return;
            }
        } while (!Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0.m(this, 0, obj, obj2));
        ((sdk.pendo.io.r3.a) obj).b(this);
    }

    @Override // sdk.pendo.io.o3.b
    public boolean isDisposed() {
        Object obj = get(0);
        return obj == b || obj == e;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        lazySet(2, Thread.currentThread());
        try {
            this.a.run();
        } catch (Throwable th) {
            try {
                sdk.pendo.io.g4.a.b(th);
            } finally {
                lazySet(2, null);
                Object obj3 = get(0);
                if (obj3 != b && Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0.m(this, 0, obj3, e) && obj3 != null) {
                    ((sdk.pendo.io.r3.a) obj3).b(this);
                }
                do {
                    obj = get(1);
                    if (obj == c || obj == d) {
                        break;
                    }
                } while (!Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0.m(this, 1, obj, e));
            }
        }
        lazySet(2, null);
        Object obj4 = get(0);
        if (obj4 != b && Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0.m(this, 0, obj4, e) && obj4 != null) {
            ((sdk.pendo.io.r3.a) obj4).b(this);
        }
        do {
            obj = get(1);
            Object obj5 = c;
            if (obj == obj5) {
                return;
            } else {
                if (obj == obj2) {
                    return;
                }
            }
        } while (!Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0.m(this, 1, obj, e));
    }
}
