package com.box.android.di;

import com.box.android.domain.identity.DeviceId;
import com.box.android.domain.identity.IDeviceIdStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvideDeviceIdFactory implements Factory<DeviceId> {
    private final Provider<IDeviceIdStorage> deviceIdStorageProvider;

    private DefaultModule_Companion_ProvideDeviceIdFactory(Provider<IDeviceIdStorage> provider) {
        this.deviceIdStorageProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DeviceId get() {
        return provideDeviceId(this.deviceIdStorageProvider.get());
    }

    public static DefaultModule_Companion_ProvideDeviceIdFactory create(Provider<IDeviceIdStorage> provider) {
        return new DefaultModule_Companion_ProvideDeviceIdFactory(provider);
    }

    public static DeviceId provideDeviceId(IDeviceIdStorage iDeviceIdStorage) {
        return (DeviceId) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.provideDeviceId(iDeviceIdStorage));
    }
}
