package com.box.android.utilities;

import androidx.appcompat.app.AppCompatActivity;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class ItemMoreActionsHandler_Factory_Impl implements ItemMoreActionsHandler.Factory {
    private final C1729ItemMoreActionsHandler_Factory delegateFactory;

    ItemMoreActionsHandler_Factory_Impl(C1729ItemMoreActionsHandler_Factory c1729ItemMoreActionsHandler_Factory) {
        this.delegateFactory = c1729ItemMoreActionsHandler_Factory;
    }

    @Override // com.box.android.base.presentation.utilities.IItemMoreActionsHandler.Factory
    public ItemMoreActionsHandler create(AppCompatActivity appCompatActivity) {
        return this.delegateFactory.get(appCompatActivity);
    }

    public static Provider<ItemMoreActionsHandler.Factory> create(C1729ItemMoreActionsHandler_Factory c1729ItemMoreActionsHandler_Factory) {
        return InstanceFactory.create(new ItemMoreActionsHandler_Factory_Impl(c1729ItemMoreActionsHandler_Factory));
    }

    public static dagger.internal.Provider<ItemMoreActionsHandler.Factory> createFactoryProvider(C1729ItemMoreActionsHandler_Factory c1729ItemMoreActionsHandler_Factory) {
        return InstanceFactory.create(new ItemMoreActionsHandler_Factory_Impl(c1729ItemMoreActionsHandler_Factory));
    }
}
