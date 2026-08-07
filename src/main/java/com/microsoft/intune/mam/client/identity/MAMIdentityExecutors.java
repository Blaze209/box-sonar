package com.microsoft.intune.mam.client.identity;

import android.content.Context;
import com.microsoft.intune.mam.client.app.MAMComponents;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMIdentityExecutors {
    private static final MAMIdentityExecutorsBehavior BEHAVIOR = (MAMIdentityExecutorsBehavior) MAMComponents.get(MAMIdentityExecutorsBehavior.class);

    private MAMIdentityExecutors() {
    }

    public static Executor wrapExecutor(Executor executor) {
        MAMIdentityExecutorsBehavior mAMIdentityExecutorsBehavior = BEHAVIOR;
        return mAMIdentityExecutorsBehavior == null ? executor : mAMIdentityExecutorsBehavior.wrapExecutor(executor);
    }

    public static Executor wrapExecutor(Executor executor, Context context) {
        MAMIdentityExecutorsBehavior mAMIdentityExecutorsBehavior = BEHAVIOR;
        return mAMIdentityExecutorsBehavior == null ? executor : mAMIdentityExecutorsBehavior.wrapExecutor(executor, context);
    }

    public static ExecutorService wrapExecutorService(ExecutorService executorService) {
        MAMIdentityExecutorsBehavior mAMIdentityExecutorsBehavior = BEHAVIOR;
        return mAMIdentityExecutorsBehavior == null ? executorService : mAMIdentityExecutorsBehavior.wrapExecutorService(executorService);
    }

    public static ExecutorService wrapExecutorService(ExecutorService executorService, Context context) {
        MAMIdentityExecutorsBehavior mAMIdentityExecutorsBehavior = BEHAVIOR;
        return mAMIdentityExecutorsBehavior == null ? executorService : mAMIdentityExecutorsBehavior.wrapExecutorService(executorService, context);
    }
}
