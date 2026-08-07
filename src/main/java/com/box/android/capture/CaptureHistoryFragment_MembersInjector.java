package com.box.android.capture;

import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.coreservices.models.BoxModelOfflineManagerWrapper;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.IOfflineService;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class CaptureHistoryFragment_MembersInjector implements MembersInjector<CaptureHistoryFragment> {
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<BoxModelOfflineManagerWrapper> offlineManagerWrapperProvider;
    private final Provider<IOfflineService> offlineServiceProvider;
    private final Provider<ThumbnailManager> thumbnailManagerProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private CaptureHistoryFragment_MembersInjector(Provider<ThumbnailManager> provider, Provider<FeatureFlips> provider2, Provider<IUserContextManager> provider3, Provider<IOfflineService> provider4, Provider<BoxModelOfflineManagerWrapper> provider5) {
        this.thumbnailManagerProvider = provider;
        this.featureFlipsProvider = provider2;
        this.userContextManagerProvider = provider3;
        this.offlineServiceProvider = provider4;
        this.offlineManagerWrapperProvider = provider5;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(CaptureHistoryFragment captureHistoryFragment) {
        injectThumbnailManager(captureHistoryFragment, this.thumbnailManagerProvider.get());
        injectFeatureFlips(captureHistoryFragment, this.featureFlipsProvider.get());
        injectUserContextManager(captureHistoryFragment, this.userContextManagerProvider.get());
        injectOfflineService(captureHistoryFragment, this.offlineServiceProvider.get());
        injectOfflineManagerWrapper(captureHistoryFragment, this.offlineManagerWrapperProvider.get());
    }

    public static MembersInjector<CaptureHistoryFragment> create(Provider<ThumbnailManager> provider, Provider<FeatureFlips> provider2, Provider<IUserContextManager> provider3, Provider<IOfflineService> provider4, Provider<BoxModelOfflineManagerWrapper> provider5) {
        return new CaptureHistoryFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    public static void injectThumbnailManager(CaptureHistoryFragment captureHistoryFragment, ThumbnailManager thumbnailManager) {
        captureHistoryFragment.thumbnailManager = thumbnailManager;
    }

    public static void injectFeatureFlips(CaptureHistoryFragment captureHistoryFragment, FeatureFlips featureFlips) {
        captureHistoryFragment.featureFlips = featureFlips;
    }

    public static void injectUserContextManager(CaptureHistoryFragment captureHistoryFragment, IUserContextManager iUserContextManager) {
        captureHistoryFragment.userContextManager = iUserContextManager;
    }

    public static void injectOfflineService(CaptureHistoryFragment captureHistoryFragment, IOfflineService iOfflineService) {
        captureHistoryFragment.offlineService = iOfflineService;
    }

    public static void injectOfflineManagerWrapper(CaptureHistoryFragment captureHistoryFragment, BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper) {
        captureHistoryFragment.offlineManagerWrapper = boxModelOfflineManagerWrapper;
    }
}
