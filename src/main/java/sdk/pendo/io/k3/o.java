package sdk.pendo.io.k3;

/* JADX INFO: loaded from: classes4.dex */
public interface o<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(sdk.pendo.io.o3.b bVar);
}
