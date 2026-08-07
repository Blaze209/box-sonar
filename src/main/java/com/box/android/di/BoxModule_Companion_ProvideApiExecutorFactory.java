package com.box.android.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes11.dex */
public final class BoxModule_Companion_ProvideApiExecutorFactory implements Factory<ThreadPoolExecutor> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ThreadPoolExecutor get() {
        return provideApiExecutor();
    }

    public static BoxModule_Companion_ProvideApiExecutorFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ThreadPoolExecutor provideApiExecutor() {
        return (ThreadPoolExecutor) Preconditions.checkNotNullFromProvides(BoxModule.INSTANCE.provideApiExecutor());
    }

    private static final class InstanceHolder {
        static final BoxModule_Companion_ProvideApiExecutorFactory INSTANCE = new BoxModule_Companion_ProvideApiExecutorFactory();

        private InstanceHolder() {
        }
    }
}
