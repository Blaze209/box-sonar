package com.box.android.navigation;

import androidx.core.content.ContextCompat;
import com.box.android.R;
import com.box.android.coreservices.models.BoxAccountSettings;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.utils.InboxBadgeTextFormatter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: NavigationBottomBar.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0011J\u0006\u0010\u0017\u001a\u00020\u0011J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\u001a\u001a\u00020\u0011J\u000e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\u001dJ \u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010$\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006%"}, d2 = {"Lcom/box/android/navigation/NavigationBottomBar;", "", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "boxAccountSettings", "Lcom/box/android/coreservices/models/BoxAccountSettings;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "<init>", "(Lcom/box/android/domain/configuration/FeatureFlips;Lcom/box/android/coreservices/models/BoxAccountSettings;Lcom/box/android/domain/identity/IUserContextManager;)V", "bottomBar", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "getBottomBar", "()Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "setBottomBar", "(Lcom/google/android/material/bottomnavigation/BottomNavigationView;)V", "updateCombinedBadgeCount", "", "count", "", "hasMore", "", "show", "hide", "isHubsAvailable", "initialize", "refresh", "setSelected", "navigationTarget", "Lcom/box/android/navigation/NavigationTarget;", "setItemSelectedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/google/android/material/navigation/NavigationBarView$OnItemSelectedListener;", "getLastUsedTab", "showNavigationBadgeWithCount", "menuId", "hideNavigationBadge", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NavigationBottomBar {
    public static final int $stable = 8;
    public BottomNavigationView bottomBar;
    private final BoxAccountSettings boxAccountSettings;
    private final FeatureFlips featureFlips;
    private final IUserContextManager userContextManager;

    @Inject
    public NavigationBottomBar(FeatureFlips featureFlips, BoxAccountSettings boxAccountSettings, IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        Intrinsics.checkNotNullParameter(boxAccountSettings, "boxAccountSettings");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        this.featureFlips = featureFlips;
        this.boxAccountSettings = boxAccountSettings;
        this.userContextManager = userContextManager;
    }

    public final BottomNavigationView getBottomBar() {
        BottomNavigationView bottomNavigationView = this.bottomBar;
        if (bottomNavigationView != null) {
            return bottomNavigationView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bottomBar");
        return null;
    }

    public final void setBottomBar(BottomNavigationView bottomNavigationView) {
        Intrinsics.checkNotNullParameter(bottomNavigationView, "<set-?>");
        this.bottomBar = bottomNavigationView;
    }

    public static /* synthetic */ void updateCombinedBadgeCount$default(NavigationBottomBar navigationBottomBar, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        navigationBottomBar.updateCombinedBadgeCount(i, z);
    }

    public final void updateCombinedBadgeCount(int count, boolean hasMore) {
        int bottomBarMenuId = NavigationTarget.getBottomBarMenuId(NavigationTarget.INBOX);
        if (count <= 0) {
            hideNavigationBadge(bottomBarMenuId);
        } else {
            showNavigationBadgeWithCount(bottomBarMenuId, count, hasMore);
        }
    }

    public final void show() {
        getBottomBar().setVisibility(0);
    }

    public final void hide() {
        getBottomBar().setVisibility(8);
    }

    private final boolean isHubsAvailable() {
        return this.featureFlips.getHubsFeatureFlip().getEnabled() && this.boxAccountSettings.isHubsGalleryEnabled();
    }

    public final void initialize(BottomNavigationView bottomBar) {
        Intrinsics.checkNotNullParameter(bottomBar, "bottomBar");
        setBottomBar(bottomBar);
        refresh();
    }

    public final void refresh() {
        getBottomBar().getMenu().findItem(R.id.action_hubs).setVisible(isHubsAvailable());
    }

    public final void setSelected(NavigationTarget navigationTarget) {
        Intrinsics.checkNotNullParameter(navigationTarget, "navigationTarget");
        getBottomBar().setSelectedItemId(NavigationTarget.getBottomBarMenuId(navigationTarget));
    }

    public final void setItemSelectedListener(NavigationBarView.OnItemSelectedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        getBottomBar().setOnItemSelectedListener(listener);
    }

    public final NavigationTarget getLastUsedTab() {
        NavigationTarget navigationTarget = null;
        String string = this.userContextManager.getUserSharedPrefs().getString(Navigation.LAST_USED_TAB_KEY, null);
        NavigationTarget navigationTarget2 = NavigationTarget.ALL_FILES;
        for (NavigationTarget navigationTarget3 : NavigationTarget.values()) {
            if (StringsKt.equals(navigationTarget3.name(), string, true)) {
                navigationTarget = navigationTarget3;
                break;
            }
        }
        NavigationTarget navigationTarget4 = navigationTarget;
        if (navigationTarget4 != null) {
            navigationTarget2 = navigationTarget4;
        }
        NavigationTarget navigationTarget5 = navigationTarget2;
        if (navigationTarget5 == NavigationTarget.HUBS && !isHubsAvailable()) {
            return NavigationTarget.ALL_FILES;
        }
        Intrinsics.checkNotNull(navigationTarget5);
        return navigationTarget5;
    }

    private final void showNavigationBadgeWithCount(int menuId, int count, boolean hasMore) {
        BadgeDrawable orCreateBadge = getBottomBar().getOrCreateBadge(menuId);
        Intrinsics.checkNotNullExpressionValue(orCreateBadge, "getOrCreateBadge(...)");
        orCreateBadge.setVisible(true);
        orCreateBadge.setBackgroundColor(ContextCompat.getColor(getBottomBar().getContext(), R.color.box_watermelon_red_110));
        String badgeText = InboxBadgeTextFormatter.formatBadgeText(count, hasMore);
        if (badgeText != null) {
            orCreateBadge.setText(badgeText);
        }
    }

    private final void hideNavigationBadge(int menuId) {
        BadgeDrawable orCreateBadge = getBottomBar().getOrCreateBadge(menuId);
        Intrinsics.checkNotNullExpressionValue(orCreateBadge, "getOrCreateBadge(...)");
        orCreateBadge.setVisible(false);
    }
}
