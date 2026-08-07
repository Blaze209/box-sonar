package com.box.android.navigationmodernization.homescreen.navigation.compose;

import androidx.appcompat.app.AppCompatActivity;
import com.box.android.base.presentation.utilities.IItemClickHandler;
import com.box.android.base.presentation.utilities.IItemMoreActionsHandler;
import com.box.android.browse.cpl.browse.fab.FabManager;
import com.box.android.browse.utilities.CopyOrMoveHelper;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.navigationmodernization.homescreen.navigation.compose.HomeScreenInnerNavigatorsProviderFactory_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes12.dex */
public final class C1660HomeScreenInnerNavigatorsProviderFactory_Factory {
    private final Provider<CopyOrMoveHelper> copyOrMoveHelperProvider;
    private final Provider<FabManager> fabManagerProvider;
    private final Provider<IntentServices> intentServicesProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private C1660HomeScreenInnerNavigatorsProviderFactory_Factory(Provider<IntentServices> provider, Provider<IUserContextManager> provider2, Provider<CopyOrMoveHelper> provider3, Provider<FabManager> provider4) {
        this.intentServicesProvider = provider;
        this.userContextManagerProvider = provider2;
        this.copyOrMoveHelperProvider = provider3;
        this.fabManagerProvider = provider4;
    }

    public HomeScreenInnerNavigatorsProviderFactory get(AppCompatActivity appCompatActivity, IItemClickHandler iItemClickHandler, IItemMoreActionsHandler iItemMoreActionsHandler) {
        return newInstance(this.intentServicesProvider.get(), this.userContextManagerProvider.get(), this.copyOrMoveHelperProvider.get(), this.fabManagerProvider.get(), appCompatActivity, iItemClickHandler, iItemMoreActionsHandler);
    }

    public static C1660HomeScreenInnerNavigatorsProviderFactory_Factory create(Provider<IntentServices> provider, Provider<IUserContextManager> provider2, Provider<CopyOrMoveHelper> provider3, Provider<FabManager> provider4) {
        return new C1660HomeScreenInnerNavigatorsProviderFactory_Factory(provider, provider2, provider3, provider4);
    }

    public static HomeScreenInnerNavigatorsProviderFactory newInstance(IntentServices intentServices, IUserContextManager iUserContextManager, CopyOrMoveHelper copyOrMoveHelper, FabManager fabManager, AppCompatActivity appCompatActivity, IItemClickHandler iItemClickHandler, IItemMoreActionsHandler iItemMoreActionsHandler) {
        return new HomeScreenInnerNavigatorsProviderFactory(intentServices, iUserContextManager, copyOrMoveHelper, fabManager, appCompatActivity, iItemClickHandler, iItemMoreActionsHandler);
    }
}
