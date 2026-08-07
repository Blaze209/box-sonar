package io.reactivex.rxjava3.core;

/* JADX INFO: loaded from: classes4.dex */
@FunctionalInterface
public interface CompletableTransformer {
    CompletableSource apply(Completable upstream);
}
