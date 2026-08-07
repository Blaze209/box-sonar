package com.box.android.navigationmodernization.homescreen.navigation.compose;

import androidx.appcompat.app.AppCompatActivity;
import com.box.android.base.presentation.utilities.IItemClickHandler;
import com.box.android.base.presentation.utilities.IItemMoreActionsHandler;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class HomeScreenInnerNavigatorsProviderFactory_Factory_Impl implements HomeScreenInnerNavigatorsProviderFactory.Factory {
    private final C1660HomeScreenInnerNavigatorsProviderFactory_Factory delegateFactory;

    HomeScreenInnerNavigatorsProviderFactory_Factory_Impl(C1660HomeScreenInnerNavigatorsProviderFactory_Factory c1660HomeScreenInnerNavigatorsProviderFactory_Factory) {
        this.delegateFactory = c1660HomeScreenInnerNavigatorsProviderFactory_Factory;
    }

    @Override // com.box.android.navigationmodernization.homescreen.navigation.compose.HomeScreenInnerNavigatorsProviderFactory.Factory
    public HomeScreenInnerNavigatorsProviderFactory create(AppCompatActivity appCompatActivity, IItemClickHandler iItemClickHandler, IItemMoreActionsHandler iItemMoreActionsHandler) {
        return this.delegateFactory.get(appCompatActivity, iItemClickHandler, iItemMoreActionsHandler);
    }

    public static Provider<HomeScreenInnerNavigatorsProviderFactory.Factory> create(C1660HomeScreenInnerNavigatorsProviderFactory_Factory c1660HomeScreenInnerNavigatorsProviderFactory_Factory) {
        return InstanceFactory.create(new HomeScreenInnerNavigatorsProviderFactory_Factory_Impl(c1660HomeScreenInnerNavigatorsProviderFactory_Factory));
    }

    public static dagger.internal.Provider<HomeScreenInnerNavigatorsProviderFactory.Factory> createFactoryProvider(C1660HomeScreenInnerNavigatorsProviderFactory_Factory c1660HomeScreenInnerNavigatorsProviderFactory_Factory) {
        return InstanceFactory.create(new HomeScreenInnerNavigatorsProviderFactory_Factory_Impl(c1660HomeScreenInnerNavigatorsProviderFactory_Factory));
    }
}
