package com.box.android.navigationmodernization.navigation.navigator;

import android.content.Context;
import android.content.Intent;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.Navigator;
import androidx.navigation.PopUpToBuilder;
import com.box.android.activities.settings.SettingsActivity;
import com.box.android.base.compose.NavControllerExtensionsKt;
import com.box.android.base.presentation.utilities.IItemClickHandler;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.mappers.ItemModelMapper;
import com.box.android.jobsui.JobsUIActivity;
import com.box.android.navigationmodernization.navigation.RootNavigationDestination;
import com.box.android.navigationmodernization.navigation.compose.RootNavigationMappingKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RootNavigator.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u0012H\u0002J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/box/android/navigationmodernization/navigation/navigator/RootNavigator;", "", "navController", "Landroidx/navigation/NavHostController;", "context", "Landroid/content/Context;", "itemClickHandler", "Lcom/box/android/base/presentation/utilities/IItemClickHandler;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "<init>", "(Landroidx/navigation/NavHostController;Landroid/content/Context;Lcom/box/android/base/presentation/utilities/IItemClickHandler;Lcom/box/android/domain/configuration/FeatureFlips;)V", "navigateTo", "", FirebaseAnalytics.Param.DESTINATION, "Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination;", "popBackStack", "resetToIfNotAtDestination", "Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$InnerDestination;", "resolveSearchDestination", "Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$InnerDestination$Search;", "navigateToOuterDestination", "Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$OuterDestination;", "isAtDestination", "", "resetTo", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RootNavigator {
    public static final int $stable = 8;
    private final Context context;
    private final FeatureFlips featureFlips;
    private final IItemClickHandler itemClickHandler;
    private final NavHostController navController;

    public RootNavigator(NavHostController navController, Context context, IItemClickHandler itemClickHandler, FeatureFlips featureFlips) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemClickHandler, "itemClickHandler");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        this.navController = navController;
        this.context = context;
        this.itemClickHandler = itemClickHandler;
        this.featureFlips = featureFlips;
    }

    public final void navigateTo(RootNavigationDestination destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (Intrinsics.areEqual(destination, RootNavigationDestination.InnerDestination.Search.INSTANCE)) {
            NavController.navigate$default((NavController) this.navController, RootNavigationMappingKt.toRoute(resolveSearchDestination()), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        } else if (destination instanceof RootNavigationDestination.InnerDestination) {
            NavController.navigate$default((NavController) this.navController, RootNavigationMappingKt.toRoute((RootNavigationDestination.InnerDestination) destination), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        } else {
            if (!(destination instanceof RootNavigationDestination.OuterDestination)) {
                throw new NoWhenBranchMatchedException();
            }
            navigateToOuterDestination((RootNavigationDestination.OuterDestination) destination);
        }
    }

    public final void popBackStack() {
        NavControllerExtensionsKt.popBackStackSafely(this.navController);
    }

    public final void resetToIfNotAtDestination(RootNavigationDestination.InnerDestination destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (isAtDestination(destination)) {
            return;
        }
        resetTo(destination);
    }

    private final RootNavigationDestination.InnerDestination.Search resolveSearchDestination() {
        if (this.featureFlips.getUnifiedSearch().getEnabled()) {
            return RootNavigationDestination.InnerDestination.Search.Unified.INSTANCE;
        }
        return RootNavigationDestination.InnerDestination.Search.Files.INSTANCE;
    }

    private final void navigateToOuterDestination(RootNavigationDestination.OuterDestination destination) {
        if (Intrinsics.areEqual(destination, RootNavigationDestination.OuterDestination.JobsUI.INSTANCE)) {
            this.context.startActivity(new Intent(this.context, (Class<?>) JobsUIActivity.class));
        } else if (Intrinsics.areEqual(destination, RootNavigationDestination.OuterDestination.Settings.INSTANCE)) {
            Context context = this.context;
            context.startActivity(SettingsActivity.getStartIntent(context, null));
        } else {
            if (!(destination instanceof RootNavigationDestination.OuterDestination.Item)) {
                throw new NoWhenBranchMatchedException();
            }
            RootNavigationDestination.OuterDestination.Item item = (RootNavigationDestination.OuterDestination.Item) destination;
            IItemClickHandler.onClick$default(this.itemClickHandler, ItemModelMapper.toBoxItem$default(ItemModelMapper.INSTANCE, item.getItemModel(), false, 1, null), item.getPreviewSource(), null, false, 12, null);
        }
    }

    private final boolean isAtDestination(RootNavigationDestination.InnerDestination destination) {
        String route = RootNavigationMappingKt.toRoute(destination);
        NavDestination currentDestination = this.navController.getCurrentDestination();
        if (currentDestination == null) {
            return false;
        }
        if (Intrinsics.areEqual(currentDestination.getRoute(), route)) {
            return true;
        }
        NavGraph parent = currentDestination.getParent();
        return Intrinsics.areEqual(parent != null ? parent.getRoute() : null, route);
    }

    private final void resetTo(RootNavigationDestination.InnerDestination destination) {
        final String route = RootNavigationMappingKt.toRoute(RootNavigationDestination.InnerDestination.HomeScreen.INSTANCE);
        this.navController.navigate(RootNavigationMappingKt.toRoute(destination), new Function1() { // from class: com.box.android.navigationmodernization.navigation.navigator.RootNavigator$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RootNavigator.resetTo$lambda$0(route, (NavOptionsBuilder) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resetTo$lambda$0(String str, NavOptionsBuilder navigate) {
        Intrinsics.checkNotNullParameter(navigate, "$this$navigate");
        navigate.popUpTo(str, new Function1() { // from class: com.box.android.navigationmodernization.navigation.navigator.RootNavigator$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RootNavigator.resetTo$lambda$0$0((PopUpToBuilder) obj);
            }
        });
        navigate.setRestoreState(false);
        navigate.setLaunchSingleTop(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resetTo$lambda$0$0(PopUpToBuilder popUpTo) {
        Intrinsics.checkNotNullParameter(popUpTo, "$this$popUpTo");
        popUpTo.setInclusive(false);
        return Unit.INSTANCE;
    }
}
