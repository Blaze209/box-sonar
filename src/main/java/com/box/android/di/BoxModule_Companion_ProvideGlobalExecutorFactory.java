package com.box.android.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes11.dex */
public final class BoxModule_Companion_ProvideGlobalExecutorFactory implements Factory<ThreadPoolExecutor> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ThreadPoolExecutor get() {
        return provideGlobalExecutor();
    }

    public static BoxModule_Companion_ProvideGlobalExecutorFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ThreadPoolExecutor provideGlobalExecutor() {
        return (ThreadPoolExecutor) Preconditions.checkNotNullFromProvides(BoxModule.INSTANCE.provideGlobalExecutor());
    }

    private static final class InstanceHolder {
        static final BoxModule_Companion_ProvideGlobalExecutorFactory INSTANCE = new BoxModule_Companion_ProvideGlobalExecutorFactory();

        private InstanceHolder() {
        }
    }
}
