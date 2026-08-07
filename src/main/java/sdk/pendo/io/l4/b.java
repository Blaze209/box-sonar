package sdk.pendo.io.l4;

import sdk.pendo.io.e2.b0;

/* JADX INFO: loaded from: classes4.dex */
public interface b<T> extends Cloneable {
    void a(d<T> dVar);

    void cancel();

    /* JADX INFO: renamed from: clone */
    b<T> mo16772clone();

    r<T> execute();

    boolean isCanceled();

    b0 request();
}
