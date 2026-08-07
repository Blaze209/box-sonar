package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes14.dex */
@ElementTypesAreNonnullByDefault
public interface AsyncFunction<I, O> {
    ListenableFuture<O> apply(@ParametricNullness I input) throws Exception;
}
