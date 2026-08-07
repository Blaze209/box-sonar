package com.box.android.data.controller.impl;

import com.box.android.coreservices.modelcontroller.IMoCoAdminSettings;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.controller.IBrowseController;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.BoxExtendedApiPreview;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class BoxPreviewController_Factory implements Factory<BoxPreviewController> {
    private final Provider<BoxExtendedApiFolder> boxExtendedApiFolderProvider;
    private final Provider<BoxExtendedApiPreview> boxExtendedApiPreviewProvider;
    private final Provider<IBrowseController> browseControllerProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<IMoCoAdminSettings> moCoAdminSettingsProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private BoxPreviewController_Factory(Provider<IUserContextManager> userContextManagerProvider, Provider<BoxExtendedApiPreview> boxExtendedApiPreviewProvider, Provider<BoxExtendedApiFolder> boxExtendedApiFolderProvider, Provider<IBrowseController> browseControllerProvider, Provider<IMoCoAdminSettings> moCoAdminSettingsProvider, Provider<FeatureFlips> featureFlipsProvider) {
        this.userContextManagerProvider = userContextManagerProvider;
        this.boxExtendedApiPreviewProvider = boxExtendedApiPreviewProvider;
        this.boxExtendedApiFolderProvider = boxExtendedApiFolderProvider;
        this.browseControllerProvider = browseControllerProvider;
        this.moCoAdminSettingsProvider = moCoAdminSettingsProvider;
        this.featureFlipsProvider = featureFlipsProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxPreviewController get() {
        return newInstance(this.userContextManagerProvider.get(), this.boxExtendedApiPreviewProvider.get(), this.boxExtendedApiFolderProvider.get(), this.browseControllerProvider.get(), this.moCoAdminSettingsProvider.get(), this.featureFlipsProvider.get());
    }

    public static BoxPreviewController_Factory create(Provider<IUserContextManager> userContextManagerProvider, Provider<BoxExtendedApiPreview> boxExtendedApiPreviewProvider, Provider<BoxExtendedApiFolder> boxExtendedApiFolderProvider, Provider<IBrowseController> browseControllerProvider, Provider<IMoCoAdminSettings> moCoAdminSettingsProvider, Provider<FeatureFlips> featureFlipsProvider) {
        return new BoxPreviewController_Factory(userContextManagerProvider, boxExtendedApiPreviewProvider, boxExtendedApiFolderProvider, browseControllerProvider, moCoAdminSettingsProvider, featureFlipsProvider);
    }

    public static BoxPreviewController newInstance(IUserContextManager userContextManager, BoxExtendedApiPreview boxExtendedApiPreview, BoxExtendedApiFolder boxExtendedApiFolder, IBrowseController browseController, IMoCoAdminSettings moCoAdminSettings, FeatureFlips featureFlips) {
        return new BoxPreviewController(userContextManager, boxExtendedApiPreview, boxExtendedApiFolder, browseController, moCoAdminSettings, featureFlips);
    }
}
