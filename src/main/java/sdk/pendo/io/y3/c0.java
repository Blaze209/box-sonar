package sdk.pendo.io.y3;

import android.R;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class c0 {

    public static final class a<T> extends AtomicInteger implements sdk.pendo.io.t3.b<T>, Runnable {
        final sdk.pendo.io.k3.o<? super T> a;
        final T b;

        public a(sdk.pendo.io.k3.o<? super T> oVar, T t) {
            this.a = oVar;
            this.b = t;
        }

        @Override // sdk.pendo.io.t3.c
        public int a(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            lazySet(1);
            return 1;
        }

        @Override // sdk.pendo.io.t3.g
        public void clear() {
            lazySet(3);
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            set(3);
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return get() == 3;
        }

        @Override // sdk.pendo.io.t3.g
        public boolean isEmpty() {
            return get() != 1;
        }

        @Override // sdk.pendo.io.t3.g
        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // sdk.pendo.io.t3.g
        public T poll() {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.b;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.a.onNext(this.b);
                if (get() == 2) {
                    lazySet(3);
                    this.a.onComplete();
                }
            }
        }
    }

    static final class b<T, R> extends sdk.pendo.io.k3.j<R> {
        final T a;
        final sdk.pendo.io.q3.h<? super T, ? extends sdk.pendo.io.k3.m<? extends R>> b;

        b(T t, sdk.pendo.io.q3.h<? super T, ? extends sdk.pendo.io.k3.m<? extends R>> hVar) {
            this.a = t;
            this.b = hVar;
        }

        @Override // sdk.pendo.io.k3.j
        public void b(sdk.pendo.io.k3.o<? super R> oVar) {
            try {
                sdk.pendo.io.k3.m mVar = (sdk.pendo.io.k3.m) sdk.pendo.io.s3.b.a(this.b.apply(this.a), "The mapper returned a null ObservableSource");
                if (!(mVar instanceof Callable)) {
                    mVar.a(oVar);
                    return;
                }
                try {
                    Object objCall = ((Callable) mVar).call();
                    if (objCall == null) {
                        sdk.pendo.io.r3.c.a(oVar);
                        return;
                    }
                    a aVar = new a(oVar, objCall);
                    oVar.onSubscribe(aVar);
                    aVar.run();
                } catch (Throwable th) {
                    sdk.pendo.io.p3.b.b(th);
                    sdk.pendo.io.r3.c.a(th, oVar);
                }
            } catch (Throwable th2) {
                sdk.pendo.io.r3.c.a(th2, oVar);
            }
        }
    }

    public static <T, U> sdk.pendo.io.k3.j<U> a(T t, sdk.pendo.io.q3.h<? super T, ? extends sdk.pendo.io.k3.m<? extends U>> hVar) {
        return sdk.pendo.io.g4.a.a(new b(t, hVar));
    }

    public static <T, R> boolean a(sdk.pendo.io.k3.m<T> mVar, sdk.pendo.io.k3.o<? super R> oVar, sdk.pendo.io.q3.h<? super T, ? extends sdk.pendo.io.k3.m<? extends R>> hVar) {
        if (!(mVar instanceof Callable)) {
            return false;
        }
        try {
            R r = (Object) ((Callable) mVar).call();
            if (r == null) {
                sdk.pendo.io.r3.c.a(oVar);
                return true;
            }
            sdk.pendo.io.k3.m mVar2 = (sdk.pendo.io.k3.m) sdk.pendo.io.s3.b.a(hVar.apply(r), "The mapper returned a null ObservableSource");
            if (mVar2 instanceof Callable) {
                Object objCall = ((Callable) mVar2).call();
                if (objCall == null) {
                    sdk.pendo.io.r3.c.a(oVar);
                    return true;
                }
                a aVar = new a(oVar, objCall);
                oVar.onSubscribe(aVar);
                aVar.run();
            } else {
                mVar2.a(oVar);
            }
            return true;
        } catch (Throwable th) {
            sdk.pendo.io.p3.b.b(th);
            sdk.pendo.io.r3.c.a(th, oVar);
            return true;
        }
    }
}
