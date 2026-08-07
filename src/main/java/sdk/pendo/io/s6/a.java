package sdk.pendo.io.s6;

import java.util.concurrent.TimeUnit;
import sdk.pendo.io.k3.j;
import sdk.pendo.io.q3.h;

/* JADX INFO: loaded from: classes5.dex */
public class a implements h<j<? extends Throwable>, j<?>> {
    private final int a;
    private final int b;
    private int c = 0;

    /* JADX INFO: renamed from: sdk.pendo.io.s6.a$a, reason: collision with other inner class name */
    class C0479a implements h<Throwable, j<?>> {
        C0479a() {
        }

        @Override // sdk.pendo.io.q3.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public j<?> apply(Throwable th) {
            a aVar = a.this;
            int i = aVar.c + 1;
            aVar.c = i;
            return i < aVar.a ? j.f(aVar.b, TimeUnit.MILLISECONDS) : j.a(th);
        }
    }

    public a(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // sdk.pendo.io.q3.h
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public j<?> apply(j<? extends Throwable> jVar) {
        return jVar.b(new C0479a());
    }
}
