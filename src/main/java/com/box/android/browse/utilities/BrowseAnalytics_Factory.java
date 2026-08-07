package com.box.android.browse.utilities;

import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.domain.identity.IUserContextManager;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class BrowseAnalytics_Factory implements Factory<BrowseAnalytics> {
    private final Provider<IBaseModelController> baseModelControllerProvider;
    private final Provider<BoxExtendedApiFolder> boxExtendedApiFolderProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private BrowseAnalytics_Factory(Provider<IBaseModelController> provider, Provider<BoxExtendedApiFolder> provider2, Provider<IUserContextManager> provider3) {
        this.baseModelControllerProvider = provider;
        this.boxExtendedApiFolderProvider = provider2;
        this.userContextManagerProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BrowseAnalytics get() {
        return newInstance(this.baseModelControllerProvider.get(), this.boxExtendedApiFolderProvider.get(), this.userContextManagerProvider.get());
    }

    public static BrowseAnalytics_Factory create(Provider<IBaseModelController> provider, Provider<BoxExtendedApiFolder> provider2, Provider<IUserContextManager> provider3) {
        return new BrowseAnalytics_Factory(provider, provider2, provider3);
    }

    public static BrowseAnalytics newInstance(IBaseModelController iBaseModelController, BoxExtendedApiFolder boxExtendedApiFolder, IUserContextManager iUserContextManager) {
        return new BrowseAnalytics(iBaseModelController, boxExtendedApiFolder, iUserContextManager);
    }
}
