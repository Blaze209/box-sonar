package com.box.android.routers;

import androidx.activity.result.ActivityResultCaller;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.box.android.base.presentation.BoxFragmentInterface;
import com.box.android.browse.cpl.browse.BrowseReducer;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.cpl.Store;
import com.box.android.cpl.mainphone.MainPhoneReducer;
import com.box.android.domain.configuration.FeatureFlips;
import com.github.clans.fab.FloatingActionMenu;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainPhoneBackNavigationHandler.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0010J\u0006\u0010\u0014\u001a\u00020\u0010J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\b\u0010\u0016\u001a\u00020\u0010H\u0002J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/box/android/routers/MainPhoneBackNavigationHandler;", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$State;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action;", "fabMenu", "Lcom/github/clans/fab/FloatingActionMenu;", "closeSearch", "Lkotlin/Function0;", "", "<init>", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/box/android/coreservices/services/IntentServices;Lcom/box/android/domain/configuration/FeatureFlips;Lcom/box/android/cpl/Store;Lcom/github/clans/fab/FloatingActionMenu;Lkotlin/jvm/functions/Function0;)V", "handleBackNavigation", "onSupportNavigateUp", "tryCloseFabMenu", "delegateHandleBackPressToFragments", "tryCloseRootFragment", "isAtRootFragment", "getFragmentStackCount", "", "shouldHandleRootNavigation", "navigateToAllFilesAndFinish", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MainPhoneBackNavigationHandler {
    public static final int $stable = 8;
    private final AppCompatActivity activity;
    private final Function0<Boolean> closeSearch;
    private final FloatingActionMenu fabMenu;
    private final FeatureFlips featureFlips;
    private final IntentServices intentServices;
    private final Store<MainPhoneReducer.State, MainPhoneReducer.Action> store;

    public MainPhoneBackNavigationHandler(AppCompatActivity activity, IntentServices intentServices, FeatureFlips featureFlips, Store<MainPhoneReducer.State, MainPhoneReducer.Action> store, FloatingActionMenu floatingActionMenu, Function0<Boolean> closeSearch) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(closeSearch, "closeSearch");
        this.activity = activity;
        this.intentServices = intentServices;
        this.featureFlips = featureFlips;
        this.store = store;
        this.fabMenu = floatingActionMenu;
        this.closeSearch = closeSearch;
    }

    public final boolean handleBackNavigation() {
        if (tryCloseFabMenu() || this.closeSearch.invoke().booleanValue() || delegateHandleBackPressToFragments()) {
            return true;
        }
        return tryCloseRootFragment();
    }

    public final boolean onSupportNavigateUp() {
        return shouldHandleRootNavigation() || handleBackNavigation();
    }

    private final boolean tryCloseFabMenu() {
        FloatingActionMenu floatingActionMenu = this.fabMenu;
        if (floatingActionMenu == null || !floatingActionMenu.isOpened()) {
            return false;
        }
        this.fabMenu.close(true);
        return true;
    }

    private final boolean delegateHandleBackPressToFragments() {
        List<Fragment> fragments = this.activity.getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
        for (ActivityResultCaller activityResultCaller : fragments) {
            if ((activityResultCaller instanceof BoxFragmentInterface) && ((BoxFragmentInterface) activityResultCaller).onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    private final boolean tryCloseRootFragment() {
        if (!isAtRootFragment()) {
            return false;
        }
        this.store.send(new MainPhoneReducer.Action.BrowseNestedAction(BrowseReducer.Action.CloseScreen.INSTANCE));
        this.activity.finish();
        return true;
    }

    private final boolean isAtRootFragment() {
        return getFragmentStackCount() == 1;
    }

    private final int getFragmentStackCount() {
        return this.activity.getSupportFragmentManager().getBackStackEntryCount();
    }

    private final boolean shouldHandleRootNavigation() {
        if (!isAtRootFragment() || !this.activity.isTaskRoot()) {
            return false;
        }
        navigateToAllFilesAndFinish();
        return true;
    }

    private final void navigateToAllFilesAndFinish() {
        AppCompatActivity appCompatActivity = this.activity;
        appCompatActivity.startActivity(this.intentServices.navigationActivityIntent(appCompatActivity, this.featureFlips.getMainScreenRedesign().getEnabled(), IntentServices.NavigationIntentTarget.ALL_FILES));
        appCompatActivity.finish();
    }
}
