package sdk.pendo.io.r3;

import sdk.pendo.io.k3.h;
import sdk.pendo.io.k3.o;

/* JADX INFO: loaded from: classes4.dex */
public enum c implements sdk.pendo.io.t3.b<Object> {
    INSTANCE,
    NEVER;

    public static void a(h<?> hVar) {
        hVar.onSubscribe(INSTANCE);
        hVar.onComplete();
    }

    @Override // sdk.pendo.io.t3.c
    public int a(int i) {
        return i & 2;
    }

    @Override // sdk.pendo.io.t3.g
    public void clear() {
    }

    @Override // sdk.pendo.io.o3.b
    public void dispose() {
    }

    @Override // sdk.pendo.io.o3.b
    public boolean isDisposed() {
        return this == INSTANCE;
    }

    @Override // sdk.pendo.io.t3.g
    public boolean isEmpty() {
        return true;
    }

    @Override // sdk.pendo.io.t3.g
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // sdk.pendo.io.t3.g
    public Object poll() {
        return null;
    }

    public static void a(o<?> oVar) {
        oVar.onSubscribe(INSTANCE);
        oVar.onComplete();
    }

    public static void a(Throwable th, o<?> oVar) {
        oVar.onSubscribe(INSTANCE);
        oVar.onError(th);
    }
}
