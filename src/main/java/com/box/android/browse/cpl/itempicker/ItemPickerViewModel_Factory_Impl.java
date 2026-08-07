package com.box.android.browse.cpl.itempicker;

import android.os.Bundle;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class ItemPickerViewModel_Factory_Impl implements ItemPickerViewModel.Factory {
    private final C0951ItemPickerViewModel_Factory delegateFactory;

    ItemPickerViewModel_Factory_Impl(C0951ItemPickerViewModel_Factory c0951ItemPickerViewModel_Factory) {
        this.delegateFactory = c0951ItemPickerViewModel_Factory;
    }

    @Override // com.box.android.common.utilities.ViewModelAssistedFactory
    public ItemPickerViewModel create(Bundle bundle) {
        return this.delegateFactory.get(bundle);
    }

    public static Provider<ItemPickerViewModel.Factory> create(C0951ItemPickerViewModel_Factory c0951ItemPickerViewModel_Factory) {
        return InstanceFactory.create(new ItemPickerViewModel_Factory_Impl(c0951ItemPickerViewModel_Factory));
    }

    public static dagger.internal.Provider<ItemPickerViewModel.Factory> createFactoryProvider(C0951ItemPickerViewModel_Factory c0951ItemPickerViewModel_Factory) {
        return InstanceFactory.create(new ItemPickerViewModel_Factory_Impl(c0951ItemPickerViewModel_Factory));
    }
}
