package com.box.android.data.service.impl;

import com.box.android.domain.services.IOfflineService;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class OfflineFilesPolicyEnforcer_Factory implements Factory<OfflineFilesPolicyEnforcer> {
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;
    private final Provider<IOfflineService> offlineServiceProvider;

    private OfflineFilesPolicyEnforcer_Factory(Provider<IOfflineService> offlineServiceProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        this.offlineServiceProvider = offlineServiceProvider;
        this.ioDispatcherProvider = ioDispatcherProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public OfflineFilesPolicyEnforcer get() {
        return newInstance(this.offlineServiceProvider.get(), this.ioDispatcherProvider.get());
    }

    public static OfflineFilesPolicyEnforcer_Factory create(Provider<IOfflineService> offlineServiceProvider, Provider<CoroutineDispatcher> ioDispatcherProvider) {
        return new OfflineFilesPolicyEnforcer_Factory(offlineServiceProvider, ioDispatcherProvider);
    }

    public static OfflineFilesPolicyEnforcer newInstance(IOfflineService offlineService, CoroutineDispatcher ioDispatcher) {
        return new OfflineFilesPolicyEnforcer(offlineService, ioDispatcher);
    }
}
