package com.box.android.modelcontroller;

import android.content.Context;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.controller.IPreviewController;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.preview.BoxThumbnailRequests;
import com.box.androidsdk.content.BoxExtendedApiPreview;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class MoCoBoxTransfers_Factory implements Factory<MoCoBoxTransfers> {
    private final Provider<BoxExtendedApiFile> boxApiFileProvider;
    private final Provider<BoxExtendedApiFolder> boxApiFolderProvider;
    private final Provider<BoxExtendedApiPreview> boxApiPreviewProvider;
    private final Provider<BoxApiPrivate> boxApiPrivateProvider;
    private final Provider<BoxThumbnailRequests> boxThumbnailRequestsProvider;
    private final Provider<Context> contextProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<IPreviewController> previewControllerProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private MoCoBoxTransfers_Factory(Provider<IUserContextManager> provider, Provider<Context> provider2, Provider<BoxThumbnailRequests> provider3, Provider<BoxExtendedApiFile> provider4, Provider<BoxExtendedApiFolder> provider5, Provider<BoxApiPrivate> provider6, Provider<BoxExtendedApiPreview> provider7, Provider<IPreviewController> provider8, Provider<FeatureFlips> provider9) {
        this.userContextManagerProvider = provider;
        this.contextProvider = provider2;
        this.boxThumbnailRequestsProvider = provider3;
        this.boxApiFileProvider = provider4;
        this.boxApiFolderProvider = provider5;
        this.boxApiPrivateProvider = provider6;
        this.boxApiPreviewProvider = provider7;
        this.previewControllerProvider = provider8;
        this.featureFlipsProvider = provider9;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MoCoBoxTransfers get() {
        return newInstance(this.userContextManagerProvider.get(), this.contextProvider.get(), this.boxThumbnailRequestsProvider.get(), this.boxApiFileProvider.get(), this.boxApiFolderProvider.get(), this.boxApiPrivateProvider.get(), this.boxApiPreviewProvider.get(), this.previewControllerProvider.get(), this.featureFlipsProvider.get());
    }

    public static MoCoBoxTransfers_Factory create(Provider<IUserContextManager> provider, Provider<Context> provider2, Provider<BoxThumbnailRequests> provider3, Provider<BoxExtendedApiFile> provider4, Provider<BoxExtendedApiFolder> provider5, Provider<BoxApiPrivate> provider6, Provider<BoxExtendedApiPreview> provider7, Provider<IPreviewController> provider8, Provider<FeatureFlips> provider9) {
        return new MoCoBoxTransfers_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static MoCoBoxTransfers newInstance(IUserContextManager iUserContextManager, Context context, BoxThumbnailRequests boxThumbnailRequests, BoxExtendedApiFile boxExtendedApiFile, BoxExtendedApiFolder boxExtendedApiFolder, BoxApiPrivate boxApiPrivate, BoxExtendedApiPreview boxExtendedApiPreview, IPreviewController iPreviewController, FeatureFlips featureFlips) {
        return new MoCoBoxTransfers(iUserContextManager, context, boxThumbnailRequests, boxExtendedApiFile, boxExtendedApiFolder, boxApiPrivate, boxExtendedApiPreview, iPreviewController, featureFlips);
    }
}
