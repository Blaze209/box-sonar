package com.box.android.utilities;

import androidx.appcompat.app.AppCompatActivity;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class ItemClickHandler_Factory_Impl implements ItemClickHandler.Factory {
    private final C1728ItemClickHandler_Factory delegateFactory;

    ItemClickHandler_Factory_Impl(C1728ItemClickHandler_Factory c1728ItemClickHandler_Factory) {
        this.delegateFactory = c1728ItemClickHandler_Factory;
    }

    @Override // com.box.android.base.presentation.utilities.IItemClickHandler.Factory
    public ItemClickHandler create(AppCompatActivity appCompatActivity) {
        return this.delegateFactory.get(appCompatActivity);
    }

    public static Provider<ItemClickHandler.Factory> create(C1728ItemClickHandler_Factory c1728ItemClickHandler_Factory) {
        return InstanceFactory.create(new ItemClickHandler_Factory_Impl(c1728ItemClickHandler_Factory));
    }

    public static dagger.internal.Provider<ItemClickHandler.Factory> createFactoryProvider(C1728ItemClickHandler_Factory c1728ItemClickHandler_Factory) {
        return InstanceFactory.create(new ItemClickHandler_Factory_Impl(c1728ItemClickHandler_Factory));
    }
}
