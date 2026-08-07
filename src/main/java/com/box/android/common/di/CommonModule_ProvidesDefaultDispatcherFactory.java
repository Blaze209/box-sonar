package com.box.android.common.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes10.dex */
public final class CommonModule_ProvidesDefaultDispatcherFactory implements Factory<CoroutineDispatcher> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CoroutineDispatcher get() {
        return providesDefaultDispatcher();
    }

    public static CommonModule_ProvidesDefaultDispatcherFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CoroutineDispatcher providesDefaultDispatcher() {
        return (CoroutineDispatcher) Preconditions.checkNotNullFromProvides(CommonModule.INSTANCE.providesDefaultDispatcher());
    }

    private static final class InstanceHolder {
        static final CommonModule_ProvidesDefaultDispatcherFactory INSTANCE = new CommonModule_ProvidesDefaultDispatcherFactory();

        private InstanceHolder() {
        }
    }
}
