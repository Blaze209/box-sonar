package com.box.android.observability.appstart;

import android.app.Activity;
import com.box.android.adapters.NavigationTabAdapter;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.coreservices.observability.appstart.AppStartType;
import com.box.android.coreservices.observability.appstart.IAppStartDestinationPage;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.fragments.NavigationTabFragment;
import com.box.android.navigation.Navigation;
import com.box.android.navigation.NavigationTarget;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BrowseTabAppStartDestinationPage.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0002J\b\u0010\u0012\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/box/android/observability/appstart/BrowseTabAppStartDestinationPage;", "Lcom/box/android/coreservices/observability/appstart/IAppStartDestinationPage;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "<init>", "(Lcom/box/android/domain/identity/IUserContextManager;)V", "appStartType", "Lcom/box/android/coreservices/observability/appstart/AppStartType;", "isDestinationActivity", "", "activity", "Landroid/app/Activity;", "shouldRecordAppStart", "recordAppStart", "", "isAppStartRecorded", "consumeAppStartType", "isSupportedNavigationBottomTab", "isSupportedBrowseTopTab", "getNavigationBottomTab", "Lcom/box/android/navigation/NavigationTarget;", "getBrowseTopTabPosition", "", "getBrowseTopTabFolderId", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BrowseTabAppStartDestinationPage implements IAppStartDestinationPage {
    public static final int $stable = 8;
    private AppStartType appStartType;
    private final IUserContextManager userContextManager;

    @Inject
    public BrowseTabAppStartDestinationPage(IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        this.userContextManager = userContextManager;
    }

    @Override // com.box.android.coreservices.observability.appstart.IAppStartDestinationPage
    public boolean isDestinationActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return activity instanceof Navigation;
    }

    @Override // com.box.android.coreservices.observability.appstart.IAppStartDestinationPage
    public boolean shouldRecordAppStart(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return isDestinationActivity(activity) && isSupportedNavigationBottomTab() && isSupportedBrowseTopTab();
    }

    @Override // com.box.android.coreservices.observability.appstart.IAppStartDestinationPage
    public void recordAppStart(AppStartType appStartType) {
        Intrinsics.checkNotNullParameter(appStartType, "appStartType");
        this.appStartType = appStartType;
    }

    @Override // com.box.android.coreservices.observability.appstart.IAppStartDestinationPage
    public boolean isAppStartRecorded() {
        return this.appStartType != null;
    }

    @Override // com.box.android.coreservices.observability.appstart.IAppStartDestinationPage
    public AppStartType consumeAppStartType() {
        AppStartType appStartType = this.appStartType;
        this.appStartType = null;
        return appStartType;
    }

    private final boolean isSupportedNavigationBottomTab() {
        return getNavigationBottomTab() == NavigationTarget.ALL_FILES;
    }

    private final boolean isSupportedBrowseTopTab() {
        return getBrowseTopTabFolderId() != null;
    }

    private final NavigationTarget getNavigationBottomTab() {
        NavigationTarget navigationTargetValueOf;
        String string = this.userContextManager.getUserSharedPrefs().getString(Navigation.LAST_USED_TAB_KEY, null);
        return (string == null || (navigationTargetValueOf = NavigationTarget.valueOf(string)) == null) ? NavigationTarget.ALL_FILES : navigationTargetValueOf;
    }

    private final int getBrowseTopTabPosition() {
        return this.userContextManager.getUserSharedPrefs().getInt(NavigationTabFragment.EXTRA_LAST_TAB_POSITION, NavigationTabAdapter.TabOrder.ALL_FILES.ordinal());
    }

    private final String getBrowseTopTabFolderId() {
        int browseTopTabPosition = getBrowseTopTabPosition();
        if (browseTopTabPosition == NavigationTabAdapter.TabOrder.ALL_FILES.ordinal()) {
            return "0";
        }
        if (browseTopTabPosition == NavigationTabAdapter.TabOrder.RECENT.ordinal()) {
            return BoxCommonConstants.RECENTS_ROOT_FOLDER_ID;
        }
        return null;
    }
}
