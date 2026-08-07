package com.box.android.collections.presentation.viewmodel;

import android.os.Bundle;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class CollectionMembershipsViewModel_Factory_Impl implements CollectionMembershipsViewModel.Factory {
    private final C1004CollectionMembershipsViewModel_Factory delegateFactory;

    CollectionMembershipsViewModel_Factory_Impl(C1004CollectionMembershipsViewModel_Factory c1004CollectionMembershipsViewModel_Factory) {
        this.delegateFactory = c1004CollectionMembershipsViewModel_Factory;
    }

    @Override // com.box.android.common.utilities.ViewModelAssistedFactory
    public CollectionMembershipsViewModel create(Bundle bundle) {
        return this.delegateFactory.get(bundle);
    }

    public static Provider<CollectionMembershipsViewModel.Factory> create(C1004CollectionMembershipsViewModel_Factory c1004CollectionMembershipsViewModel_Factory) {
        return InstanceFactory.create(new CollectionMembershipsViewModel_Factory_Impl(c1004CollectionMembershipsViewModel_Factory));
    }

    public static dagger.internal.Provider<CollectionMembershipsViewModel.Factory> createFactoryProvider(C1004CollectionMembershipsViewModel_Factory c1004CollectionMembershipsViewModel_Factory) {
        return InstanceFactory.create(new CollectionMembershipsViewModel_Factory_Impl(c1004CollectionMembershipsViewModel_Factory));
    }
}
