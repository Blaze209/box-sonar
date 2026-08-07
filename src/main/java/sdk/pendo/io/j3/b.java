package sdk.pendo.io.j3;

/* JADX INFO: loaded from: classes4.dex */
public interface b<T> {
    void a(c cVar);

    void onComplete();

    void onError(Throwable th);

    void onNext(T t);
}
