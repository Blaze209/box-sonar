package com.box.android.clientadmin.integrity;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class DeviceIntegrityVerifier_Factory implements Factory<DeviceIntegrityVerifier> {
    private final Provider<IntegrityAPICaller> integrityAPICallerProvider;

    private DeviceIntegrityVerifier_Factory(Provider<IntegrityAPICaller> provider) {
        this.integrityAPICallerProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DeviceIntegrityVerifier get() {
        return newInstance(this.integrityAPICallerProvider.get());
    }

    public static DeviceIntegrityVerifier_Factory create(Provider<IntegrityAPICaller> provider) {
        return new DeviceIntegrityVerifier_Factory(provider);
    }

    public static DeviceIntegrityVerifier newInstance(IntegrityAPICaller integrityAPICaller) {
        return new DeviceIntegrityVerifier(integrityAPICaller);
    }
}
