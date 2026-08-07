package com.microsoft.intune.mam.client.identity;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public interface MAMIdentityExecutorsBehavior {
    Executor wrapExecutor(Executor executor);

    Executor wrapExecutor(Executor executor, Context context);

    ExecutorService wrapExecutorService(ExecutorService executorService);

    ExecutorService wrapExecutorService(ExecutorService executorService, Context context);
}
