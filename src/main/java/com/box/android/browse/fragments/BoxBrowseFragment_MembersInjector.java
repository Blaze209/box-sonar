package com.box.android.browse.fragments;

import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.controller.IBrowseController;
import com.box.android.domain.metrics.Gen204PerformanceLogger;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class BoxBrowseFragment_MembersInjector implements MembersInjector<BoxBrowseFragment> {
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<Gen204PerformanceLogger> gen204PerformanceLoggerProvider;
    private final Provider<IBrowseController> mControllerProvider;
    private final Provider<ThumbnailManager> mThumbnailManagerProvider;

    private BoxBrowseFragment_MembersInjector(Provider<IBrowseController> provider, Provider<ThumbnailManager> provider2, Provider<Gen204PerformanceLogger> provider3, Provider<FeatureFlips> provider4) {
        this.mControllerProvider = provider;
        this.mThumbnailManagerProvider = provider2;
        this.gen204PerformanceLoggerProvider = provider3;
        this.featureFlipsProvider = provider4;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(BoxBrowseFragment boxBrowseFragment) {
        injectMController(boxBrowseFragment, this.mControllerProvider.get());
        injectMThumbnailManager(boxBrowseFragment, this.mThumbnailManagerProvider.get());
        injectGen204PerformanceLogger(boxBrowseFragment, this.gen204PerformanceLoggerProvider.get());
        injectFeatureFlips(boxBrowseFragment, this.featureFlipsProvider.get());
    }

    public static MembersInjector<BoxBrowseFragment> create(Provider<IBrowseController> provider, Provider<ThumbnailManager> provider2, Provider<Gen204PerformanceLogger> provider3, Provider<FeatureFlips> provider4) {
        return new BoxBrowseFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    public static void injectMController(BoxBrowseFragment boxBrowseFragment, IBrowseController iBrowseController) {
        boxBrowseFragment.mController = iBrowseController;
    }

    public static void injectMThumbnailManager(BoxBrowseFragment boxBrowseFragment, ThumbnailManager thumbnailManager) {
        boxBrowseFragment.mThumbnailManager = thumbnailManager;
    }

    public static void injectGen204PerformanceLogger(BoxBrowseFragment boxBrowseFragment, Gen204PerformanceLogger gen204PerformanceLogger) {
        boxBrowseFragment.gen204PerformanceLogger = gen204PerformanceLogger;
    }

    public static void injectFeatureFlips(BoxBrowseFragment boxBrowseFragment, FeatureFlips featureFlips) {
        boxBrowseFragment.featureFlips = featureFlips;
    }
}
