package com.box.android.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes11.dex */
public final class BoxModule_Companion_ProvideLocalModelExecutorFactory implements Factory<ThreadPoolExecutor> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ThreadPoolExecutor get() {
        return provideLocalModelExecutor();
    }

    public static BoxModule_Companion_ProvideLocalModelExecutorFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ThreadPoolExecutor provideLocalModelExecutor() {
        return (ThreadPoolExecutor) Preconditions.checkNotNullFromProvides(BoxModule.INSTANCE.provideLocalModelExecutor());
    }

    private static final class InstanceHolder {
        static final BoxModule_Companion_ProvideLocalModelExecutorFactory INSTANCE = new BoxModule_Companion_ProvideLocalModelExecutorFactory();

        private InstanceHolder() {
        }
    }
}
