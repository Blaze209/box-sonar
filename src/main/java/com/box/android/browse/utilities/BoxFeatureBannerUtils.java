package com.box.android.browse.utilities;

import android.content.SharedPreferences;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.box.android.domain.services.IAppInBackgroundService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxFeatureBanners.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\t\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\fJ\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\fJ\b\u0010\u0015\u001a\u00020\u0010H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/box/android/browse/utilities/BoxFeatureBannerUtils;", "", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "appInBackgroundService", "Lcom/box/android/domain/services/IAppInBackgroundService;", "<init>", "(Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/domain/services/IAppInBackgroundService;)V", "appStateListener", "com/box/android/browse/utilities/BoxFeatureBannerUtils$appStateListener$1", "Lcom/box/android/browse/utilities/BoxFeatureBannerUtils$appStateListener$1;", "getFeatureBanner", "Lcom/box/android/browse/utilities/BoxFeatureBanner;", "bannerId", "", "shouldShowFeatureBanner", "", HubsObservability.HUB_ASSET_BANNER, "setBannerDismissed", "", "setBannerDisplayed", "bannerDisplayLimitNotReached", "Companion", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxFeatureBannerUtils {
    public static final String BANNER_DISPLAY_COUNT = "banner_display_count";
    public static final String INCREMENT_BANNER_DISPLAY_COUNT_ONCE = "increment_banner_display_count";
    public static final int MAX_BANNER_DISPLAY_COUNT = 3;
    private final BoxFeatureBannerUtils$appStateListener$1 appStateListener;
    private final IUserContextManager userContextManager;
    public static final int $stable = 8;

    /* JADX WARN: Type inference failed for: r2v1, types: [com.box.android.browse.utilities.BoxFeatureBannerUtils$appStateListener$1] */
    @Inject
    public BoxFeatureBannerUtils(IUserContextManager userContextManager, IAppInBackgroundService appInBackgroundService) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(appInBackgroundService, "appInBackgroundService");
        this.userContextManager = userContextManager;
        ?? r2 = new IAppInBackgroundService.Listener() { // from class: com.box.android.browse.utilities.BoxFeatureBannerUtils$appStateListener$1
            @Override // com.box.android.domain.services.IAppInBackgroundService.Listener
            public /* bridge */ void onMoveToForeground() {
                super.onMoveToForeground();
            }

            @Override // com.box.android.domain.services.IAppInBackgroundService.Listener
            public void onMoveToBackground() {
                this.this$0.userContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.FEATURE_BANNERS).edit().putBoolean(BoxFeatureBannerUtils.INCREMENT_BANNER_DISPLAY_COUNT_ONCE, true).apply();
            }
        };
        this.appStateListener = r2;
        appInBackgroundService.add((IAppInBackgroundService.Listener) r2);
    }

    public final BoxFeatureBanner getFeatureBanner(int bannerId) {
        for (BoxFeatureBanner boxFeatureBanner : BoxFeatureBanner.values()) {
            if (boxFeatureBanner.getId() == bannerId) {
                return boxFeatureBanner;
            }
        }
        return null;
    }

    public final boolean shouldShowFeatureBanner(BoxFeatureBanner banner) {
        Intrinsics.checkNotNullParameter(banner, "banner");
        return bannerDisplayLimitNotReached() && !this.userContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.FEATURE_BANNERS).getBoolean(banner.name(), false);
    }

    public final void setBannerDismissed(BoxFeatureBanner banner) {
        Intrinsics.checkNotNullParameter(banner, "banner");
        BoxAmplitudeAnalytics.createFeatureBannerEventBuilder().setFeature(banner.getFeatureIdentifier()).setBannerId(banner.getId()).logEvent(BoxAnalyticsParams.EVENT_PRODUCT_BANNER_DISMISSED);
        this.userContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.FEATURE_BANNERS).edit().putBoolean(banner.name(), true).apply();
    }

    public final void setBannerDisplayed(BoxFeatureBanner banner) {
        Intrinsics.checkNotNullParameter(banner, "banner");
        SharedPreferences userSharedPrefs = this.userContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.FEATURE_BANNERS);
        int i = userSharedPrefs.getInt(BANNER_DISPLAY_COUNT, 0);
        if (userSharedPrefs.getBoolean(INCREMENT_BANNER_DISPLAY_COUNT_ONCE, true) && i <= 3) {
            SharedPreferences.Editor editorEdit = userSharedPrefs.edit();
            editorEdit.putInt(BANNER_DISPLAY_COUNT, i + 1);
            editorEdit.putBoolean(INCREMENT_BANNER_DISPLAY_COUNT_ONCE, false).apply();
        }
        BoxAmplitudeAnalytics.createFeatureBannerEventBuilder().setFeature(banner.getFeatureIdentifier()).setBannerId(banner.getId()).logEvent(BoxAnalyticsParams.EVENT_PRODUCT_BANNER_DISPLAYED);
    }

    public final boolean bannerDisplayLimitNotReached() {
        return this.userContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.FEATURE_BANNERS).getInt(BANNER_DISPLAY_COUNT, 0) < 3;
    }
}
