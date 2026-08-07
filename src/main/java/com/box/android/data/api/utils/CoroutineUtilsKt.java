package com.box.android.data.api.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: compiled from: CoroutineUtils.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"singleThreadContext", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "getSingleThreadContext", "()Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "data_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CoroutineUtilsKt {
    private static final ExecutorCoroutineDispatcher singleThreadContext;

    static {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        singleThreadContext = ExecutorsKt.from(executorServiceNewSingleThreadExecutor);
    }

    public static final ExecutorCoroutineDispatcher getSingleThreadContext() {
        return singleThreadContext;
    }
}
