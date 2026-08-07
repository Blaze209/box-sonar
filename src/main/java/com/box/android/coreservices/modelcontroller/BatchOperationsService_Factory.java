package com.box.android.coreservices.modelcontroller;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class BatchOperationsService_Factory implements Factory<BatchOperationsService> {
    private final Provider<IMoCoBatchOperations> mocoBatchOperationsProvider;

    private BatchOperationsService_Factory(Provider<IMoCoBatchOperations> provider) {
        this.mocoBatchOperationsProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BatchOperationsService get() {
        return newInstance(this.mocoBatchOperationsProvider.get());
    }

    public static BatchOperationsService_Factory create(Provider<IMoCoBatchOperations> provider) {
        return new BatchOperationsService_Factory(provider);
    }

    public static BatchOperationsService newInstance(IMoCoBatchOperations iMoCoBatchOperations) {
        return new BatchOperationsService(iMoCoBatchOperations);
    }
}
