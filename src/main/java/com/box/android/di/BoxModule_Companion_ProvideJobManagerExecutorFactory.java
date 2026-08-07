package com.box.android.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes11.dex */
public final class BoxModule_Companion_ProvideJobManagerExecutorFactory implements Factory<ThreadPoolExecutor> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ThreadPoolExecutor get() {
        return provideJobManagerExecutor();
    }

    public static BoxModule_Companion_ProvideJobManagerExecutorFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ThreadPoolExecutor provideJobManagerExecutor() {
        return (ThreadPoolExecutor) Preconditions.checkNotNullFromProvides(BoxModule.INSTANCE.provideJobManagerExecutor());
    }

    private static final class InstanceHolder {
        static final BoxModule_Companion_ProvideJobManagerExecutorFactory INSTANCE = new BoxModule_Companion_ProvideJobManagerExecutorFactory();

        private InstanceHolder() {
        }
    }
}
