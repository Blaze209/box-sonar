package com.box.android.navigationmodernization.navigation.navigator;

import androidx.appcompat.app.AppCompatActivity;
import com.box.android.base.presentation.utilities.IItemClickHandler;
import com.box.android.base.presentation.utilities.IItemMoreActionsHandler;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class RootInnerNavigatorsProviderFactory_Factory_Impl implements RootInnerNavigatorsProviderFactory.Factory {
    private final C1662RootInnerNavigatorsProviderFactory_Factory delegateFactory;

    RootInnerNavigatorsProviderFactory_Factory_Impl(C1662RootInnerNavigatorsProviderFactory_Factory c1662RootInnerNavigatorsProviderFactory_Factory) {
        this.delegateFactory = c1662RootInnerNavigatorsProviderFactory_Factory;
    }

    @Override // com.box.android.navigationmodernization.navigation.navigator.RootInnerNavigatorsProviderFactory.Factory
    public RootInnerNavigatorsProviderFactory create(AppCompatActivity appCompatActivity, IItemClickHandler iItemClickHandler, IItemMoreActionsHandler iItemMoreActionsHandler) {
        return this.delegateFactory.get(appCompatActivity, iItemClickHandler, iItemMoreActionsHandler);
    }

    public static Provider<RootInnerNavigatorsProviderFactory.Factory> create(C1662RootInnerNavigatorsProviderFactory_Factory c1662RootInnerNavigatorsProviderFactory_Factory) {
        return InstanceFactory.create(new RootInnerNavigatorsProviderFactory_Factory_Impl(c1662RootInnerNavigatorsProviderFactory_Factory));
    }

    public static dagger.internal.Provider<RootInnerNavigatorsProviderFactory.Factory> createFactoryProvider(C1662RootInnerNavigatorsProviderFactory_Factory c1662RootInnerNavigatorsProviderFactory_Factory) {
        return InstanceFactory.create(new RootInnerNavigatorsProviderFactory_Factory_Impl(c1662RootInnerNavigatorsProviderFactory_Factory));
    }
}
