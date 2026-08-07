package com.box.android.utilities;

import androidx.appcompat.app.AppCompatActivity;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.utilities.ItemMoreActionsHandler_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C1729ItemMoreActionsHandler_Factory {
    private final Provider<ItemActionHandler.Factory> itemActionHandlerFactoryProvider;

    private C1729ItemMoreActionsHandler_Factory(Provider<ItemActionHandler.Factory> provider) {
        this.itemActionHandlerFactoryProvider = provider;
    }

    public ItemMoreActionsHandler get(AppCompatActivity appCompatActivity) {
        return newInstance(this.itemActionHandlerFactoryProvider.get(), appCompatActivity);
    }

    public static C1729ItemMoreActionsHandler_Factory create(Provider<ItemActionHandler.Factory> provider) {
        return new C1729ItemMoreActionsHandler_Factory(provider);
    }

    public static ItemMoreActionsHandler newInstance(ItemActionHandler.Factory factory, AppCompatActivity appCompatActivity) {
        return new ItemMoreActionsHandler(factory, appCompatActivity);
    }
}
