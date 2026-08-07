package com.box.android.hubs.hubDetails.presentation;

import android.os.Bundle;
import com.box.android.cpl.IStoreFactory;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.hubs.hubDetails.presentation.HubDetailsViewModel_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes12.dex */
public final class C1648HubDetailsViewModel_Factory {
    private final Provider<HubDetailsEnvironment> environmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private C1648HubDetailsViewModel_Factory(Provider<IStoreFactory> provider, Provider<HubDetailsEnvironment> provider2) {
        this.storeFactoryProvider = provider;
        this.environmentProvider = provider2;
    }

    public HubDetailsViewModel get(Bundle bundle) {
        return newInstance(bundle, this.storeFactoryProvider.get(), this.environmentProvider.get());
    }

    public static C1648HubDetailsViewModel_Factory create(Provider<IStoreFactory> provider, Provider<HubDetailsEnvironment> provider2) {
        return new C1648HubDetailsViewModel_Factory(provider, provider2);
    }

    public static HubDetailsViewModel newInstance(Bundle bundle, IStoreFactory iStoreFactory, HubDetailsEnvironment hubDetailsEnvironment) {
        return new HubDetailsViewModel(bundle, iStoreFactory, hubDetailsEnvironment);
    }
}
