package com.box.android.base.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes9.dex */
public final class BaseModule_Companion_ProvideApiExecutorFactory implements Factory<ThreadPoolExecutor> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ThreadPoolExecutor get() {
        return provideApiExecutor();
    }

    public static BaseModule_Companion_ProvideApiExecutorFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ThreadPoolExecutor provideApiExecutor() {
        return (ThreadPoolExecutor) Preconditions.checkNotNullFromProvides(BaseModule.INSTANCE.provideApiExecutor());
    }

    private static final class InstanceHolder {
        static final BaseModule_Companion_ProvideApiExecutorFactory INSTANCE = new BaseModule_Companion_ProvideApiExecutorFactory();

        private InstanceHolder() {
        }
    }
}
