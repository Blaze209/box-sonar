package com.pspdfkit.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class su {
    public static final ExecutorCoroutineDispatcher a;

    static {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.pspdfkit.internal.su$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return su.a(runnable);
            }
        });
        executorServiceNewSingleThreadExecutor.getClass();
        a = ExecutorsKt.from(executorServiceNewSingleThreadExecutor);
    }

    public static final Thread a(Runnable runnable) {
        Thread thread = new Thread(runnable, "nutrient-smart-zoom-text-lookup");
        thread.setDaemon(true);
        return thread;
    }
}
