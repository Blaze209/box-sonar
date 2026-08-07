package com.box.android.collections.presentation.viewmodel;

import android.os.Bundle;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class CollectionItemsViewModel_Factory_Impl implements CollectionItemsViewModel.Factory {
    private final C1003CollectionItemsViewModel_Factory delegateFactory;

    CollectionItemsViewModel_Factory_Impl(C1003CollectionItemsViewModel_Factory c1003CollectionItemsViewModel_Factory) {
        this.delegateFactory = c1003CollectionItemsViewModel_Factory;
    }

    @Override // com.box.android.common.utilities.ViewModelAssistedFactory
    public CollectionItemsViewModel create(Bundle bundle) {
        return this.delegateFactory.get(bundle);
    }

    public static Provider<CollectionItemsViewModel.Factory> create(C1003CollectionItemsViewModel_Factory c1003CollectionItemsViewModel_Factory) {
        return InstanceFactory.create(new CollectionItemsViewModel_Factory_Impl(c1003CollectionItemsViewModel_Factory));
    }

    public static dagger.internal.Provider<CollectionItemsViewModel.Factory> createFactoryProvider(C1003CollectionItemsViewModel_Factory c1003CollectionItemsViewModel_Factory) {
        return InstanceFactory.create(new CollectionItemsViewModel_Factory_Impl(c1003CollectionItemsViewModel_Factory));
    }
}
