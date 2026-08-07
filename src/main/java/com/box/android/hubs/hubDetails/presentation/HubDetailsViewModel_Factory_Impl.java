package com.box.android.hubs.hubDetails.presentation;

import android.os.Bundle;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class HubDetailsViewModel_Factory_Impl implements HubDetailsViewModel.Factory {
    private final C1648HubDetailsViewModel_Factory delegateFactory;

    HubDetailsViewModel_Factory_Impl(C1648HubDetailsViewModel_Factory c1648HubDetailsViewModel_Factory) {
        this.delegateFactory = c1648HubDetailsViewModel_Factory;
    }

    @Override // com.box.android.common.utilities.ViewModelAssistedFactory
    public HubDetailsViewModel create(Bundle bundle) {
        return this.delegateFactory.get(bundle);
    }

    public static Provider<HubDetailsViewModel.Factory> create(C1648HubDetailsViewModel_Factory c1648HubDetailsViewModel_Factory) {
        return InstanceFactory.create(new HubDetailsViewModel_Factory_Impl(c1648HubDetailsViewModel_Factory));
    }

    public static dagger.internal.Provider<HubDetailsViewModel.Factory> createFactoryProvider(C1648HubDetailsViewModel_Factory c1648HubDetailsViewModel_Factory) {
        return InstanceFactory.create(new HubDetailsViewModel_Factory_Impl(c1648HubDetailsViewModel_Factory));
    }
}
