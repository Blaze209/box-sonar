package com.box.android.browse.cpl.itemsList;

import com.box.android.base.cpl.ItemThumbnailEnvironment;
import com.box.android.base.presentation.multiselect.MultiselectEnvironment;
import com.box.android.browse.utilities.BoxFeatureBannerUtils;
import com.box.android.browse.utilities.BrowseAnalytics;
import com.box.android.coreservices.models.BoxModelOfflineManagerWrapper;
import com.box.android.coreservices.observability.appstart.apdex.AppStartApdexTracker;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.LocalSortPreferences;
import com.box.android.domain.metrics.Gen204PerformanceLogger;
import com.box.android.domain.services.ApdexService;
import com.box.android.domain.services.ISessionManager;
import com.box.android.domain.usecases.browse.ItemsViewUseCase;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: compiled from: ItemsListReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001e\u001a\u00020\u001fX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0012\u0010\"\u001a\u00020#X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0012\u0010&\u001a\u00020'X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0012\u0010*\u001a\u00020+X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0012\u0010.\u001a\u00020/X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0012\u00102\u001a\u000203X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0012\u00106\u001a\u000207X¦\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u001a\u0010:\u001a\u00020;8&X§\u0004¢\u0006\f\u0012\u0004\b<\u0010=\u001a\u0004\b>\u0010?¨\u0006@À\u0006\u0003"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/IItemsListViewEnvironment;", "", "itemsViewUseCase", "Lcom/box/android/domain/usecases/browse/ItemsViewUseCase;", "getItemsViewUseCase", "()Lcom/box/android/domain/usecases/browse/ItemsViewUseCase;", "thumbnailEnvironment", "Lcom/box/android/base/cpl/ItemThumbnailEnvironment;", "getThumbnailEnvironment", "()Lcom/box/android/base/cpl/ItemThumbnailEnvironment;", "gen204PerformanceLogger", "Lcom/box/android/domain/metrics/Gen204PerformanceLogger;", "getGen204PerformanceLogger", "()Lcom/box/android/domain/metrics/Gen204PerformanceLogger;", "featureBannerUtils", "Lcom/box/android/browse/utilities/BoxFeatureBannerUtils;", "getFeatureBannerUtils", "()Lcom/box/android/browse/utilities/BoxFeatureBannerUtils;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "sessionManager", "Lcom/box/android/domain/services/ISessionManager;", "getSessionManager", "()Lcom/box/android/domain/services/ISessionManager;", "multiselectEnvironment", "Lcom/box/android/base/presentation/multiselect/MultiselectEnvironment;", "getMultiselectEnvironment", "()Lcom/box/android/base/presentation/multiselect/MultiselectEnvironment;", "browseAnalytics", "Lcom/box/android/browse/utilities/BrowseAnalytics;", "getBrowseAnalytics", "()Lcom/box/android/browse/utilities/BrowseAnalytics;", "metricsUseCase", "Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "getMetricsUseCase", "()Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "apdexService", "Lcom/box/android/domain/services/ApdexService;", "getApdexService", "()Lcom/box/android/domain/services/ApdexService;", "appStartApdexTracker", "Lcom/box/android/coreservices/observability/appstart/apdex/AppStartApdexTracker;", "getAppStartApdexTracker", "()Lcom/box/android/coreservices/observability/appstart/apdex/AppStartApdexTracker;", "itemModelStateMapper", "Lcom/box/android/browse/cpl/itemsList/ItemModelStateMapper;", "getItemModelStateMapper", "()Lcom/box/android/browse/cpl/itemsList/ItemModelStateMapper;", "boxModelOfflineManagerWrapper", "Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;", "getBoxModelOfflineManagerWrapper", "()Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;", "localSortPreferences", "Lcom/box/android/domain/localrepo/LocalSortPreferences;", "getLocalSortPreferences", "()Lcom/box/android/domain/localrepo/LocalSortPreferences;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDispatcher$annotations", "()V", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IItemsListViewEnvironment {

    /* JADX INFO: compiled from: ItemsListReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void getDispatcher$annotations() {
        }
    }

    ApdexService getApdexService();

    AppStartApdexTracker getAppStartApdexTracker();

    BoxModelOfflineManagerWrapper getBoxModelOfflineManagerWrapper();

    BrowseAnalytics getBrowseAnalytics();

    CoroutineDispatcher getDispatcher();

    BoxFeatureBannerUtils getFeatureBannerUtils();

    Gen204PerformanceLogger getGen204PerformanceLogger();

    ItemModelStateMapper getItemModelStateMapper();

    ItemsViewUseCase getItemsViewUseCase();

    LocalSortPreferences getLocalSortPreferences();

    MetricsUseCase getMetricsUseCase();

    MultiselectEnvironment getMultiselectEnvironment();

    ISessionManager getSessionManager();

    ItemThumbnailEnvironment getThumbnailEnvironment();

    IUserContextManager getUserContextManager();
}
