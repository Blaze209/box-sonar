package com.box.android.common.di;

import com.box.android.cpl.IStoreFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes10.dex */
public final class CommonModule_ProvidesStoreFactoryFactory implements Factory<IStoreFactory> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public IStoreFactory get() {
        return providesStoreFactory();
    }

    public static CommonModule_ProvidesStoreFactoryFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static IStoreFactory providesStoreFactory() {
        return (IStoreFactory) Preconditions.checkNotNullFromProvides(CommonModule.INSTANCE.providesStoreFactory());
    }

    private static final class InstanceHolder {
        static final CommonModule_ProvidesStoreFactoryFactory INSTANCE = new CommonModule_ProvidesStoreFactoryFactory();

        private InstanceHolder() {
        }
    }
}
