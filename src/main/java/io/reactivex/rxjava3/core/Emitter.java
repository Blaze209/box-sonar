package io.reactivex.rxjava3.core;

/* JADX INFO: loaded from: classes4.dex */
public interface Emitter<T> {
    void onComplete();

    void onError(Throwable error);

    void onNext(T value);
}
