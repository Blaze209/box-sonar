package com.box.android.browse.fragments;

import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.controller.IBrowseController;
import com.box.android.domain.metrics.Gen204PerformanceLogger;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class SearchFragment_MembersInjector implements MembersInjector<SearchFragment> {
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<Gen204PerformanceLogger> gen204PerformanceLoggerProvider;
    private final Provider<IBaseModelController> mBaseMocoProvider;
    private final Provider<IBrowseController> mControllerProvider;
    private final Provider<ThumbnailManager> mThumbnailManagerProvider;
    private final Provider<SearchFragment.TimeLogHelper> mTimeLogHelperProvider;

    private SearchFragment_MembersInjector(Provider<IBrowseController> provider, Provider<ThumbnailManager> provider2, Provider<Gen204PerformanceLogger> provider3, Provider<FeatureFlips> provider4, Provider<IBaseModelController> provider5, Provider<SearchFragment.TimeLogHelper> provider6) {
        this.mControllerProvider = provider;
        this.mThumbnailManagerProvider = provider2;
        this.gen204PerformanceLoggerProvider = provider3;
        this.featureFlipsProvider = provider4;
        this.mBaseMocoProvider = provider5;
        this.mTimeLogHelperProvider = provider6;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(SearchFragment searchFragment) {
        BoxBrowseFragment_MembersInjector.injectMController(searchFragment, this.mControllerProvider.get());
        BoxBrowseFragment_MembersInjector.injectMThumbnailManager(searchFragment, this.mThumbnailManagerProvider.get());
        BoxBrowseFragment_MembersInjector.injectGen204PerformanceLogger(searchFragment, this.gen204PerformanceLoggerProvider.get());
        BoxBrowseFragment_MembersInjector.injectFeatureFlips(searchFragment, this.featureFlipsProvider.get());
        injectMBaseMoco(searchFragment, this.mBaseMocoProvider.get());
        injectMTimeLogHelper(searchFragment, this.mTimeLogHelperProvider.get());
    }

    public static MembersInjector<SearchFragment> create(Provider<IBrowseController> provider, Provider<ThumbnailManager> provider2, Provider<Gen204PerformanceLogger> provider3, Provider<FeatureFlips> provider4, Provider<IBaseModelController> provider5, Provider<SearchFragment.TimeLogHelper> provider6) {
        return new SearchFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static void injectMBaseMoco(SearchFragment searchFragment, IBaseModelController iBaseModelController) {
        searchFragment.mBaseMoco = iBaseModelController;
    }

    public static void injectMTimeLogHelper(SearchFragment searchFragment, SearchFragment.TimeLogHelper timeLogHelper) {
        searchFragment.mTimeLogHelper = timeLogHelper;
    }
}
