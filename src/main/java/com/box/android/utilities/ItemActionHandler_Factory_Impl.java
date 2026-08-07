package com.box.android.utilities;

import androidx.appcompat.app.AppCompatActivity;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class ItemActionHandler_Factory_Impl implements ItemActionHandler.Factory {
    private final C1727ItemActionHandler_Factory delegateFactory;

    ItemActionHandler_Factory_Impl(C1727ItemActionHandler_Factory c1727ItemActionHandler_Factory) {
        this.delegateFactory = c1727ItemActionHandler_Factory;
    }

    @Override // com.box.android.base.presentation.utilities.IItemActionHandler.Factory
    public ItemActionHandler create(AppCompatActivity appCompatActivity) {
        return this.delegateFactory.get(appCompatActivity);
    }

    public static Provider<ItemActionHandler.Factory> create(C1727ItemActionHandler_Factory c1727ItemActionHandler_Factory) {
        return InstanceFactory.create(new ItemActionHandler_Factory_Impl(c1727ItemActionHandler_Factory));
    }

    public static dagger.internal.Provider<ItemActionHandler.Factory> createFactoryProvider(C1727ItemActionHandler_Factory c1727ItemActionHandler_Factory) {
        return InstanceFactory.create(new ItemActionHandler_Factory_Impl(c1727ItemActionHandler_Factory));
    }
}
