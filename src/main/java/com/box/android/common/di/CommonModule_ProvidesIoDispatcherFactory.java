package com.box.android.common.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes10.dex */
public final class CommonModule_ProvidesIoDispatcherFactory implements Factory<CoroutineDispatcher> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CoroutineDispatcher get() {
        return providesIoDispatcher();
    }

    public static CommonModule_ProvidesIoDispatcherFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CoroutineDispatcher providesIoDispatcher() {
        return (CoroutineDispatcher) Preconditions.checkNotNullFromProvides(CommonModule.INSTANCE.providesIoDispatcher());
    }

    private static final class InstanceHolder {
        static final CommonModule_ProvidesIoDispatcherFactory INSTANCE = new CommonModule_ProvidesIoDispatcherFactory();

        private InstanceHolder() {
        }
    }
}
