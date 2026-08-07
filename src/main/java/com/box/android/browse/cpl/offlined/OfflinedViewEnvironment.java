package com.box.android.browse.cpl.offlined;

import com.box.android.base.cpl.ItemThumbnailEnvironment;
import com.box.android.base.presentation.multiselect.MultiselectEnvironment;
import com.box.android.browse.cpl.itemsList.IItemsListViewEnvironment;
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
import com.box.android.domain.usecases.browse.OfflinedViewInteractor;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: OfflinedReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\b\u0007\u0018\u00002\u00020\u0001B\u0083\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\b\b\u0003\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f¢\u0006\u0004\b \u0010!R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0014\u0010\u0018\u001a\u00020\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0014\u0010\u001a\u001a\u00020\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0014\u0010\u001c\u001a\u00020\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0014\u0010\u001e\u001a\u00020\u001fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?¨\u0006@"}, d2 = {"Lcom/box/android/browse/cpl/offlined/OfflinedViewEnvironment;", "Lcom/box/android/browse/cpl/itemsList/IItemsListViewEnvironment;", "itemsViewUseCase", "Lcom/box/android/domain/usecases/browse/OfflinedViewInteractor;", "thumbnailEnvironment", "Lcom/box/android/base/cpl/ItemThumbnailEnvironment;", "gen204PerformanceLogger", "Lcom/box/android/domain/metrics/Gen204PerformanceLogger;", "featureBannerUtils", "Lcom/box/android/browse/utilities/BoxFeatureBannerUtils;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "multiselectEnvironment", "Lcom/box/android/base/presentation/multiselect/MultiselectEnvironment;", "browseAnalytics", "Lcom/box/android/browse/utilities/BrowseAnalytics;", "sessionManager", "Lcom/box/android/domain/services/ISessionManager;", "metricsUseCase", "Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "apdexService", "Lcom/box/android/domain/services/ApdexService;", "appStartApdexTracker", "Lcom/box/android/coreservices/observability/appstart/apdex/AppStartApdexTracker;", "itemModelStateMapper", "Lcom/box/android/browse/cpl/itemsList/ItemModelStateMapper;", "boxModelOfflineManagerWrapper", "Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "localSortPreferences", "Lcom/box/android/domain/localrepo/LocalSortPreferences;", "<init>", "(Lcom/box/android/domain/usecases/browse/OfflinedViewInteractor;Lcom/box/android/base/cpl/ItemThumbnailEnvironment;Lcom/box/android/domain/metrics/Gen204PerformanceLogger;Lcom/box/android/browse/utilities/BoxFeatureBannerUtils;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/base/presentation/multiselect/MultiselectEnvironment;Lcom/box/android/browse/utilities/BrowseAnalytics;Lcom/box/android/domain/services/ISessionManager;Lcom/box/android/domain/usecases/observability/MetricsUseCase;Lcom/box/android/domain/services/ApdexService;Lcom/box/android/coreservices/observability/appstart/apdex/AppStartApdexTracker;Lcom/box/android/browse/cpl/itemsList/ItemModelStateMapper;Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/box/android/domain/localrepo/LocalSortPreferences;)V", "getItemsViewUseCase", "()Lcom/box/android/domain/usecases/browse/OfflinedViewInteractor;", "getThumbnailEnvironment", "()Lcom/box/android/base/cpl/ItemThumbnailEnvironment;", "getGen204PerformanceLogger", "()Lcom/box/android/domain/metrics/Gen204PerformanceLogger;", "getFeatureBannerUtils", "()Lcom/box/android/browse/utilities/BoxFeatureBannerUtils;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "getMultiselectEnvironment", "()Lcom/box/android/base/presentation/multiselect/MultiselectEnvironment;", "getBrowseAnalytics", "()Lcom/box/android/browse/utilities/BrowseAnalytics;", "getSessionManager", "()Lcom/box/android/domain/services/ISessionManager;", "getMetricsUseCase", "()Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "getApdexService", "()Lcom/box/android/domain/services/ApdexService;", "getAppStartApdexTracker", "()Lcom/box/android/coreservices/observability/appstart/apdex/AppStartApdexTracker;", "getItemModelStateMapper", "()Lcom/box/android/browse/cpl/itemsList/ItemModelStateMapper;", "getBoxModelOfflineManagerWrapper", "()Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getLocalSortPreferences", "()Lcom/box/android/domain/localrepo/LocalSortPreferences;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OfflinedViewEnvironment implements IItemsListViewEnvironment {
    public static final int $stable = 8;
    private final ApdexService apdexService;
    private final AppStartApdexTracker appStartApdexTracker;
    private final BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper;
    private final BrowseAnalytics browseAnalytics;
    private final CoroutineDispatcher dispatcher;
    private final BoxFeatureBannerUtils featureBannerUtils;
    private final Gen204PerformanceLogger gen204PerformanceLogger;
    private final ItemModelStateMapper itemModelStateMapper;
    private final OfflinedViewInteractor itemsViewUseCase;
    private final LocalSortPreferences localSortPreferences;
    private final MetricsUseCase metricsUseCase;
    private final MultiselectEnvironment multiselectEnvironment;
    private final ISessionManager sessionManager;
    private final ItemThumbnailEnvironment thumbnailEnvironment;
    private final IUserContextManager userContextManager;

    @Inject
    public OfflinedViewEnvironment(OfflinedViewInteractor itemsViewUseCase, ItemThumbnailEnvironment thumbnailEnvironment, Gen204PerformanceLogger gen204PerformanceLogger, BoxFeatureBannerUtils featureBannerUtils, IUserContextManager userContextManager, MultiselectEnvironment multiselectEnvironment, BrowseAnalytics browseAnalytics, ISessionManager sessionManager, MetricsUseCase metricsUseCase, ApdexService apdexService, AppStartApdexTracker appStartApdexTracker, ItemModelStateMapper itemModelStateMapper, BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper, CoroutineDispatcher dispatcher, LocalSortPreferences localSortPreferences) {
        Intrinsics.checkNotNullParameter(itemsViewUseCase, "itemsViewUseCase");
        Intrinsics.checkNotNullParameter(thumbnailEnvironment, "thumbnailEnvironment");
        Intrinsics.checkNotNullParameter(gen204PerformanceLogger, "gen204PerformanceLogger");
        Intrinsics.checkNotNullParameter(featureBannerUtils, "featureBannerUtils");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(multiselectEnvironment, "multiselectEnvironment");
        Intrinsics.checkNotNullParameter(browseAnalytics, "browseAnalytics");
        Intrinsics.checkNotNullParameter(sessionManager, "sessionManager");
        Intrinsics.checkNotNullParameter(metricsUseCase, "metricsUseCase");
        Intrinsics.checkNotNullParameter(apdexService, "apdexService");
        Intrinsics.checkNotNullParameter(appStartApdexTracker, "appStartApdexTracker");
        Intrinsics.checkNotNullParameter(itemModelStateMapper, "itemModelStateMapper");
        Intrinsics.checkNotNullParameter(boxModelOfflineManagerWrapper, "boxModelOfflineManagerWrapper");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(localSortPreferences, "localSortPreferences");
        this.itemsViewUseCase = itemsViewUseCase;
        this.thumbnailEnvironment = thumbnailEnvironment;
        this.gen204PerformanceLogger = gen204PerformanceLogger;
        this.featureBannerUtils = featureBannerUtils;
        this.userContextManager = userContextManager;
        this.multiselectEnvironment = multiselectEnvironment;
        this.browseAnalytics = browseAnalytics;
        this.sessionManager = sessionManager;
        this.metricsUseCase = metricsUseCase;
        this.apdexService = apdexService;
        this.appStartApdexTracker = appStartApdexTracker;
        this.itemModelStateMapper = itemModelStateMapper;
        this.boxModelOfflineManagerWrapper = boxModelOfflineManagerWrapper;
        this.dispatcher = dispatcher;
        this.localSortPreferences = localSortPreferences;
    }

    @Override // com.box.android.browse.cpl.itemsList.IItemsListViewEnvironment
    public OfflinedViewInteractor getItemsViewUseCase() {
        return this.itemsViewUseCase;
    }

    @Override // com.box.android.browse.cpl.itemsList.IItemsListViewEnvironment
    public ItemThumbnailEnvironment getThumbnailEnvironment() {
        return this.thumbnailEnvironment;
    }

    @Override // com.box.android.browse.cpl.itemsList.IItemsListViewEnvironment
    public Gen204PerformanceLogger getGen204PerformanceLogger() {
        return this.gen204PerformanceLogger;
    }

    @Override // com.box.android.browse.cpl.itemsList.IItemsListViewEnvironment
    public BoxFeatureBannerUtils getFeatureBannerUtils() {
        return this.featureBannerUtils;
    }

    @Override // com.box.android.browse.cpl.itemsList.IItemsListViewEnvironment
    public IUserContextManager getUserContextManager() {
        return this.userContextManager;
    }

    @Override // com.box.android.browse.cpl.itemsList.IItemsListViewEnvironment
    public MultiselectEnvironment getMultiselectEnvironment() {
        return this.multiselectEnvironment;
    }

    @Override // com.box.android.browse.cpl.itemsList.IItemsListViewEnvironment
    public BrowseAnalytics getBrowseAnalytics() {
        return this.browseAnalytics;
    }

    @Override // com.box.android.browse.cpl.itemsList.IItemsListViewEnvironment
    public ISessionManager getSessionManager() {
        return this.sessionManager;
    }

    @Override // com.box.android.browse.cpl.itemsList.IItemsListViewEnvironment
    public MetricsUseCase getMetricsUseCase() {
        return this.metricsUseCase;
    }

    @Override // com.box.android.browse.cpl.itemsList.IItemsListViewEnvironment
    public ApdexService getApdexService() {
        return this.apdexService;
    }

    @Override // com.box.android.browse.cpl.itemsList.IItemsListViewEnvironment
    public AppStartApdexTracker getAppStartApdexTracker() {
        return this.appStartApdexTracker;
    }

    @Override // com.box.android.browse.cpl.itemsList.IItemsListViewEnvironment
    public ItemModelStateMapper getItemModelStateMapper() {
        return this.itemModelStateMapper;
    }

    @Override // com.box.android.browse.cpl.itemsList.IItemsListViewEnvironment
    public BoxModelOfflineManagerWrapper getBoxModelOfflineManagerWrapper() {
        return this.boxModelOfflineManagerWrapper;
    }

    public /* synthetic */ OfflinedViewEnvironment(OfflinedViewInteractor offlinedViewInteractor, ItemThumbnailEnvironment itemThumbnailEnvironment, Gen204PerformanceLogger gen204PerformanceLogger, BoxFeatureBannerUtils boxFeatureBannerUtils, IUserContextManager iUserContextManager, MultiselectEnvironment multiselectEnvironment, BrowseAnalytics browseAnalytics, ISessionManager iSessionManager, MetricsUseCase metricsUseCase, ApdexService apdexService, AppStartApdexTracker appStartApdexTracker, ItemModelStateMapper itemModelStateMapper, BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper, CoroutineDispatcher coroutineDispatcher, LocalSortPreferences localSortPreferences, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(offlinedViewInteractor, itemThumbnailEnvironment, gen204PerformanceLogger, boxFeatureBannerUtils, iUserContextManager, multiselectEnvironment, browseAnalytics, iSessionManager, metricsUseCase, apdexService, appStartApdexTracker, itemModelStateMapper, boxModelOfflineManagerWrapper, (i & 8192) != 0 ? Dispatchers.getDefault() : coroutineDispatcher, localSortPreferences);
    }

    @Override // com.box.android.browse.cpl.itemsList.IItemsListViewEnvironment
    public CoroutineDispatcher getDispatcher() {
        return this.dispatcher;
    }

    @Override // com.box.android.browse.cpl.itemsList.IItemsListViewEnvironment
    public LocalSortPreferences getLocalSortPreferences() {
        return this.localSortPreferences;
    }
}
