package sdk.pendo.io.k3;

/* JADX INFO: loaded from: classes4.dex */
public interface h<T> {
    void onComplete();

    void onError(Throwable th);

    void onSubscribe(sdk.pendo.io.o3.b bVar);

    void onSuccess(T t);
}
