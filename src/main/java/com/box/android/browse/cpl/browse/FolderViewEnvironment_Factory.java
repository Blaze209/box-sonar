package com.box.android.browse.cpl.browse;

import com.box.android.base.cpl.ItemThumbnailEnvironment;
import com.box.android.base.presentation.multiselect.MultiselectEnvironment;
import com.box.android.browse.cpl.itemsList.ItemModelStateMapper;
import com.box.android.browse.utilities.BoxFeatureBannerUtils;
import com.box.android.browse.utilities.BrowseAnalytics;
import com.box.android.coreservices.models.BoxModelOfflineManagerWrapper;
import com.box.android.coreservices.observability.appstart.apdex.AppStartApdexTracker;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.LocalSortPreferences;
import com.box.android.domain.metrics.Gen204PerformanceLogger;
import com.box.android.domain.services.ApdexService;
import com.box.android.domain.services.ISessionManager;
import com.box.android.domain.usecases.browse.FolderViewInteractor;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes10.dex */
public final class FolderViewEnvironment_Factory implements Factory<FolderViewEnvironment> {
    private final Provider<ApdexService> apdexServiceProvider;
    private final Provider<AppStartApdexTracker> appStartApdexTrackerProvider;
    private final Provider<BoxModelOfflineManagerWrapper> boxModelOfflineManagerWrapperProvider;
    private final Provider<BrowseAnalytics> browseAnalyticsProvider;
    private final Provider<CoroutineDispatcher> dispatcherProvider;
    private final Provider<BoxFeatureBannerUtils> featureBannerUtilsProvider;
    private final Provider<Gen204PerformanceLogger> gen204PerformanceLoggerProvider;
    private final Provider<ItemModelStateMapper> itemModelStateMapperProvider;
    private final Provider<FolderViewInteractor> itemsViewUseCaseProvider;
    private final Provider<LocalSortPreferences> localSortPreferencesProvider;
    private final Provider<MetricsUseCase> metricsUseCaseProvider;
    private final Provider<MultiselectEnvironment> multiselectEnvironmentProvider;
    private final Provider<ISessionManager> sessionManagerProvider;
    private final Provider<ItemThumbnailEnvironment> thumbnailEnvironmentProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private FolderViewEnvironment_Factory(Provider<FolderViewInteractor> provider, Provider<ItemThumbnailEnvironment> provider2, Provider<Gen204PerformanceLogger> provider3, Provider<BoxFeatureBannerUtils> provider4, Provider<IUserContextManager> provider5, Provider<MultiselectEnvironment> provider6, Provider<BrowseAnalytics> provider7, Provider<ISessionManager> provider8, Provider<MetricsUseCase> provider9, Provider<ApdexService> provider10, Provider<AppStartApdexTracker> provider11, Provider<ItemModelStateMapper> provider12, Provider<BoxModelOfflineManagerWrapper> provider13, Provider<CoroutineDispatcher> provider14, Provider<LocalSortPreferences> provider15) {
        this.itemsViewUseCaseProvider = provider;
        this.thumbnailEnvironmentProvider = provider2;
        this.gen204PerformanceLoggerProvider = provider3;
        this.featureBannerUtilsProvider = provider4;
        this.userContextManagerProvider = provider5;
        this.multiselectEnvironmentProvider = provider6;
        this.browseAnalyticsProvider = provider7;
        this.sessionManagerProvider = provider8;
        this.metricsUseCaseProvider = provider9;
        this.apdexServiceProvider = provider10;
        this.appStartApdexTrackerProvider = provider11;
        this.itemModelStateMapperProvider = provider12;
        this.boxModelOfflineManagerWrapperProvider = provider13;
        this.dispatcherProvider = provider14;
        this.localSortPreferencesProvider = provider15;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FolderViewEnvironment get() {
        return newInstance(this.itemsViewUseCaseProvider.get(), this.thumbnailEnvironmentProvider.get(), this.gen204PerformanceLoggerProvider.get(), this.featureBannerUtilsProvider.get(), this.userContextManagerProvider.get(), this.multiselectEnvironmentProvider.get(), this.browseAnalyticsProvider.get(), this.sessionManagerProvider.get(), this.metricsUseCaseProvider.get(), this.apdexServiceProvider.get(), this.appStartApdexTrackerProvider.get(), this.itemModelStateMapperProvider.get(), this.boxModelOfflineManagerWrapperProvider.get(), this.dispatcherProvider.get(), this.localSortPreferencesProvider.get());
    }

    public static FolderViewEnvironment_Factory create(Provider<FolderViewInteractor> provider, Provider<ItemThumbnailEnvironment> provider2, Provider<Gen204PerformanceLogger> provider3, Provider<BoxFeatureBannerUtils> provider4, Provider<IUserContextManager> provider5, Provider<MultiselectEnvironment> provider6, Provider<BrowseAnalytics> provider7, Provider<ISessionManager> provider8, Provider<MetricsUseCase> provider9, Provider<ApdexService> provider10, Provider<AppStartApdexTracker> provider11, Provider<ItemModelStateMapper> provider12, Provider<BoxModelOfflineManagerWrapper> provider13, Provider<CoroutineDispatcher> provider14, Provider<LocalSortPreferences> provider15) {
        return new FolderViewEnvironment_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15);
    }

    public static FolderViewEnvironment newInstance(FolderViewInteractor folderViewInteractor, ItemThumbnailEnvironment itemThumbnailEnvironment, Gen204PerformanceLogger gen204PerformanceLogger, BoxFeatureBannerUtils boxFeatureBannerUtils, IUserContextManager iUserContextManager, MultiselectEnvironment multiselectEnvironment, BrowseAnalytics browseAnalytics, ISessionManager iSessionManager, MetricsUseCase metricsUseCase, ApdexService apdexService, AppStartApdexTracker appStartApdexTracker, ItemModelStateMapper itemModelStateMapper, BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper, CoroutineDispatcher coroutineDispatcher, LocalSortPreferences localSortPreferences) {
        return new FolderViewEnvironment(folderViewInteractor, itemThumbnailEnvironment, gen204PerformanceLogger, boxFeatureBannerUtils, iUserContextManager, multiselectEnvironment, browseAnalytics, iSessionManager, metricsUseCase, apdexService, appStartApdexTracker, itemModelStateMapper, boxModelOfflineManagerWrapper, coroutineDispatcher, localSortPreferences);
    }
}
