package com.box.android.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes11.dex */
public final class BoxModule_Companion_ProvideFileTransferExecutorFactory implements Factory<ThreadPoolExecutor> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ThreadPoolExecutor get() {
        return provideFileTransferExecutor();
    }

    public static BoxModule_Companion_ProvideFileTransferExecutorFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ThreadPoolExecutor provideFileTransferExecutor() {
        return (ThreadPoolExecutor) Preconditions.checkNotNullFromProvides(BoxModule.INSTANCE.provideFileTransferExecutor());
    }

    private static final class InstanceHolder {
        static final BoxModule_Companion_ProvideFileTransferExecutorFactory INSTANCE = new BoxModule_Companion_ProvideFileTransferExecutorFactory();

        private InstanceHolder() {
        }
    }
}
