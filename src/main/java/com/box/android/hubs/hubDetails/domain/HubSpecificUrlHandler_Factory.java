package com.box.android.hubs.hubDetails.domain;

import com.box.android.domain.services.IRemoteItemService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class HubSpecificUrlHandler_Factory implements Factory<HubSpecificUrlHandler> {
    private final Provider<IRemoteItemService> itemServiceProvider;

    private HubSpecificUrlHandler_Factory(Provider<IRemoteItemService> provider) {
        this.itemServiceProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public HubSpecificUrlHandler get() {
        return newInstance(this.itemServiceProvider.get());
    }

    public static HubSpecificUrlHandler_Factory create(Provider<IRemoteItemService> provider) {
        return new HubSpecificUrlHandler_Factory(provider);
    }

    public static HubSpecificUrlHandler newInstance(IRemoteItemService iRemoteItemService) {
        return new HubSpecificUrlHandler(iRemoteItemService);
    }
}
