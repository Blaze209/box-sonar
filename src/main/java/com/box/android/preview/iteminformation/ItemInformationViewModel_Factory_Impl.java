package com.box.android.preview.iteminformation;

import android.os.Bundle;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class ItemInformationViewModel_Factory_Impl implements ItemInformationViewModel.Factory {
    private final C1678ItemInformationViewModel_Factory delegateFactory;

    ItemInformationViewModel_Factory_Impl(C1678ItemInformationViewModel_Factory c1678ItemInformationViewModel_Factory) {
        this.delegateFactory = c1678ItemInformationViewModel_Factory;
    }

    @Override // com.box.android.common.utilities.ViewModelAssistedFactory
    public ItemInformationViewModel create(Bundle bundle) {
        return this.delegateFactory.get(bundle);
    }

    public static Provider<ItemInformationViewModel.Factory> create(C1678ItemInformationViewModel_Factory c1678ItemInformationViewModel_Factory) {
        return InstanceFactory.create(new ItemInformationViewModel_Factory_Impl(c1678ItemInformationViewModel_Factory));
    }

    public static dagger.internal.Provider<ItemInformationViewModel.Factory> createFactoryProvider(C1678ItemInformationViewModel_Factory c1678ItemInformationViewModel_Factory) {
        return InstanceFactory.create(new ItemInformationViewModel_Factory_Impl(c1678ItemInformationViewModel_Factory));
    }
}
