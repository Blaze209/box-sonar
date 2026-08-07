package com.box.android.coreservices.utilities;

import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.IAudioPlaylistItemsService;
import com.box.android.domain.services.IGalleryItemsService;
import com.box.android.domain.services.IdMappingService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class FileActionsManager_Factory implements Factory<FileActionsManager> {
    private final Provider<IAudioPlaylistItemsService> audioPlaylistItemsServiceProvider;
    private final Provider<BoxAccountManagerHelper> boxAccountManagerHelperProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<IGalleryItemsService> galleryItemsServiceProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private FileActionsManager_Factory(Provider<IdMappingService> provider, Provider<BoxAccountManagerHelper> provider2, Provider<IUserContextManager> provider3, Provider<IGalleryItemsService> provider4, Provider<IAudioPlaylistItemsService> provider5, Provider<FeatureFlips> provider6) {
        this.idMappingServiceProvider = provider;
        this.boxAccountManagerHelperProvider = provider2;
        this.userContextManagerProvider = provider3;
        this.galleryItemsServiceProvider = provider4;
        this.audioPlaylistItemsServiceProvider = provider5;
        this.featureFlipsProvider = provider6;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FileActionsManager get() {
        return newInstance(this.idMappingServiceProvider.get(), this.boxAccountManagerHelperProvider.get(), this.userContextManagerProvider.get(), this.galleryItemsServiceProvider.get(), this.audioPlaylistItemsServiceProvider.get(), this.featureFlipsProvider.get());
    }

    public static FileActionsManager_Factory create(Provider<IdMappingService> provider, Provider<BoxAccountManagerHelper> provider2, Provider<IUserContextManager> provider3, Provider<IGalleryItemsService> provider4, Provider<IAudioPlaylistItemsService> provider5, Provider<FeatureFlips> provider6) {
        return new FileActionsManager_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static FileActionsManager newInstance(IdMappingService idMappingService, BoxAccountManagerHelper boxAccountManagerHelper, IUserContextManager iUserContextManager, IGalleryItemsService iGalleryItemsService, IAudioPlaylistItemsService iAudioPlaylistItemsService, FeatureFlips featureFlips) {
        return new FileActionsManager(idMappingService, boxAccountManagerHelper, iUserContextManager, iGalleryItemsService, iAudioPlaylistItemsService, featureFlips);
    }
}
