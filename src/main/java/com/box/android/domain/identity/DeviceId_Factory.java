package com.box.android.domain.identity;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DeviceId_Factory implements Factory<DeviceId> {
    private final Provider<IDeviceIdStorage> idStorageProvider;

    private DeviceId_Factory(Provider<IDeviceIdStorage> provider) {
        this.idStorageProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DeviceId get() {
        return newInstance(this.idStorageProvider.get());
    }

    public static DeviceId_Factory create(Provider<IDeviceIdStorage> provider) {
        return new DeviceId_Factory(provider);
    }

    public static DeviceId newInstance(IDeviceIdStorage iDeviceIdStorage) {
        return new DeviceId(iDeviceIdStorage);
    }
}
