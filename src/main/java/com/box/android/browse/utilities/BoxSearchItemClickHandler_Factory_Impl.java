package com.box.android.browse.utilities;

import androidx.appcompat.app.AppCompatActivity;
import com.box.android.base.presentation.utilities.IItemClickHandler;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class BoxSearchItemClickHandler_Factory_Impl implements BoxSearchItemClickHandler.Factory {
    private final C0961BoxSearchItemClickHandler_Factory delegateFactory;

    BoxSearchItemClickHandler_Factory_Impl(C0961BoxSearchItemClickHandler_Factory c0961BoxSearchItemClickHandler_Factory) {
        this.delegateFactory = c0961BoxSearchItemClickHandler_Factory;
    }

    @Override // com.box.android.browse.utilities.BoxSearchItemClickHandler.Factory
    public BoxSearchItemClickHandler create(AppCompatActivity appCompatActivity, IItemClickHandler iItemClickHandler) {
        return this.delegateFactory.get(iItemClickHandler, appCompatActivity);
    }

    public static Provider<BoxSearchItemClickHandler.Factory> create(C0961BoxSearchItemClickHandler_Factory c0961BoxSearchItemClickHandler_Factory) {
        return InstanceFactory.create(new BoxSearchItemClickHandler_Factory_Impl(c0961BoxSearchItemClickHandler_Factory));
    }

    public static dagger.internal.Provider<BoxSearchItemClickHandler.Factory> createFactoryProvider(C0961BoxSearchItemClickHandler_Factory c0961BoxSearchItemClickHandler_Factory) {
        return InstanceFactory.create(new BoxSearchItemClickHandler_Factory_Impl(c0961BoxSearchItemClickHandler_Factory));
    }
}
