package com.box.android.utilities;

import android.app.Application;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class DeviceIdStorage_Factory implements Factory<DeviceIdStorage> {
    private final Provider<Application> appProvider;
    private final Provider<IStorage> storageProvider;

    private DeviceIdStorage_Factory(Provider<Application> provider, Provider<IStorage> provider2) {
        this.appProvider = provider;
        this.storageProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DeviceIdStorage get() {
        return newInstance(this.appProvider.get(), this.storageProvider.get());
    }

    public static DeviceIdStorage_Factory create(Provider<Application> provider, Provider<IStorage> provider2) {
        return new DeviceIdStorage_Factory(provider, provider2);
    }

    public static DeviceIdStorage newInstance(Application application, IStorage iStorage) {
        return new DeviceIdStorage(application, iStorage);
    }
}
