package com.box.android.di;

import com.box.android.utilities.IStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvideStorageFactory implements Factory<IStorage> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public IStorage get() {
        return provideStorage();
    }

    public static DefaultModule_Companion_ProvideStorageFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static IStorage provideStorage() {
        return (IStorage) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.provideStorage());
    }

    private static final class InstanceHolder {
        static final DefaultModule_Companion_ProvideStorageFactory INSTANCE = new DefaultModule_Companion_ProvideStorageFactory();

        private InstanceHolder() {
        }
    }
}
