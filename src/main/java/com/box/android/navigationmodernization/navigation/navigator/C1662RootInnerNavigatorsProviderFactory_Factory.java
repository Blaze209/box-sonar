package com.box.android.navigationmodernization.navigation.navigator;

import androidx.appcompat.app.AppCompatActivity;
import com.box.android.base.presentation.utilities.IItemClickHandler;
import com.box.android.base.presentation.utilities.IItemMoreActionsHandler;
import com.box.android.browse.utilities.BoxSearchItemClickHandler;
import com.box.android.coreservices.services.IntentServices;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.navigationmodernization.navigation.navigator.RootInnerNavigatorsProviderFactory_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes12.dex */
public final class C1662RootInnerNavigatorsProviderFactory_Factory {
    private final Provider<BoxSearchItemClickHandler.Factory> boxSearchItemClickHandlerFactoryProvider;
    private final Provider<IntentServices> intentServicesProvider;

    private C1662RootInnerNavigatorsProviderFactory_Factory(Provider<BoxSearchItemClickHandler.Factory> provider, Provider<IntentServices> provider2) {
        this.boxSearchItemClickHandlerFactoryProvider = provider;
        this.intentServicesProvider = provider2;
    }

    public RootInnerNavigatorsProviderFactory get(AppCompatActivity appCompatActivity, IItemClickHandler iItemClickHandler, IItemMoreActionsHandler iItemMoreActionsHandler) {
        return newInstance(this.boxSearchItemClickHandlerFactoryProvider.get(), this.intentServicesProvider.get(), appCompatActivity, iItemClickHandler, iItemMoreActionsHandler);
    }

    public static C1662RootInnerNavigatorsProviderFactory_Factory create(Provider<BoxSearchItemClickHandler.Factory> provider, Provider<IntentServices> provider2) {
        return new C1662RootInnerNavigatorsProviderFactory_Factory(provider, provider2);
    }

    public static RootInnerNavigatorsProviderFactory newInstance(BoxSearchItemClickHandler.Factory factory, IntentServices intentServices, AppCompatActivity appCompatActivity, IItemClickHandler iItemClickHandler, IItemMoreActionsHandler iItemMoreActionsHandler) {
        return new RootInnerNavigatorsProviderFactory(factory, intentServices, appCompatActivity, iItemClickHandler, iItemMoreActionsHandler);
    }
}
