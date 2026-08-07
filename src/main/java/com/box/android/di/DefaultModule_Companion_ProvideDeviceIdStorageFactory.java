package com.box.android.di;

import android.content.Context;
import com.box.android.domain.identity.IDeviceIdStorage;
import com.box.android.utilities.IStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvideDeviceIdStorageFactory implements Factory<IDeviceIdStorage> {
    private final Provider<Context> contextProvider;
    private final Provider<IStorage> storageProvider;

    private DefaultModule_Companion_ProvideDeviceIdStorageFactory(Provider<IStorage> provider, Provider<Context> provider2) {
        this.storageProvider = provider;
        this.contextProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public IDeviceIdStorage get() {
        return provideDeviceIdStorage(this.storageProvider.get(), this.contextProvider.get());
    }

    public static DefaultModule_Companion_ProvideDeviceIdStorageFactory create(Provider<IStorage> provider, Provider<Context> provider2) {
        return new DefaultModule_Companion_ProvideDeviceIdStorageFactory(provider, provider2);
    }

    public static IDeviceIdStorage provideDeviceIdStorage(IStorage iStorage, Context context) {
        return (IDeviceIdStorage) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.provideDeviceIdStorage(iStorage, context));
    }
}
