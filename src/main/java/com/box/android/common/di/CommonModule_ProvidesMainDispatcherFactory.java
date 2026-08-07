package com.box.android.common.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes10.dex */
public final class CommonModule_ProvidesMainDispatcherFactory implements Factory<CoroutineDispatcher> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CoroutineDispatcher get() {
        return providesMainDispatcher();
    }

    public static CommonModule_ProvidesMainDispatcherFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CoroutineDispatcher providesMainDispatcher() {
        return (CoroutineDispatcher) Preconditions.checkNotNullFromProvides(CommonModule.INSTANCE.providesMainDispatcher());
    }

    private static final class InstanceHolder {
        static final CommonModule_ProvidesMainDispatcherFactory INSTANCE = new CommonModule_ProvidesMainDispatcherFactory();

        private InstanceHolder() {
        }
    }
}
