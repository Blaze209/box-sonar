package sdk.pendo.io.a4;

import java.util.concurrent.ThreadFactory;
import sdk.pendo.io.k3.p;

/* JADX INFO: loaded from: classes4.dex */
public final class e extends p {
    private static final h d = new h("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    final ThreadFactory c;

    public e() {
        this(d);
    }

    @Override // sdk.pendo.io.k3.p
    public p.c a() {
        return new f(this.c);
    }

    public e(ThreadFactory threadFactory) {
        this.c = threadFactory;
    }
}
