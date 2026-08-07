package com.box.android.navigationmodernization.homescreen.navigation;

import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.PopUpToBuilder;
import com.box.android.navigationmodernization.homescreen.navigation.compose.HomeScreenNavigationMappingKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HomeScreenNavigator.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/box/android/navigationmodernization/homescreen/navigation/HomeScreenNavigator;", "", "navController", "Landroidx/navigation/NavHostController;", "<init>", "(Landroidx/navigation/NavHostController;)V", "navigateTo", "", FirebaseAnalytics.Param.DESTINATION, "Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination;", "resetToIfNotAtDestination", "isAtDestination", "", "resetTo", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HomeScreenNavigator {
    public static final int $stable = 8;
    private final NavHostController navController;

    public HomeScreenNavigator(NavHostController navController) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        this.navController = navController;
    }

    public final void navigateTo(HomeNavigationBarDestination destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        this.navController.navigate(HomeScreenNavigationMappingKt.toRoute(destination), new Function1() { // from class: com.box.android.navigationmodernization.homescreen.navigation.HomeScreenNavigator$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HomeScreenNavigator.navigateTo$lambda$0(this.f$0, (NavOptionsBuilder) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit navigateTo$lambda$0(HomeScreenNavigator homeScreenNavigator, NavOptionsBuilder navigate) {
        Intrinsics.checkNotNullParameter(navigate, "$this$navigate");
        navigate.popUpTo(homeScreenNavigator.navController.getGraph().getId(), new Function1() { // from class: com.box.android.navigationmodernization.homescreen.navigation.HomeScreenNavigator$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HomeScreenNavigator.navigateTo$lambda$0$0((PopUpToBuilder) obj);
            }
        });
        navigate.setRestoreState(true);
        navigate.setLaunchSingleTop(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit navigateTo$lambda$0$0(PopUpToBuilder popUpTo) {
        Intrinsics.checkNotNullParameter(popUpTo, "$this$popUpTo");
        popUpTo.setSaveState(true);
        return Unit.INSTANCE;
    }

    public final void resetToIfNotAtDestination(HomeNavigationBarDestination destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (isAtDestination(destination)) {
            return;
        }
        resetTo(destination);
    }

    private final boolean isAtDestination(HomeNavigationBarDestination destination) {
        NavGraph parent;
        NavDestination currentDestination = this.navController.getCurrentDestination();
        return Intrinsics.areEqual((currentDestination == null || (parent = currentDestination.getParent()) == null) ? null : parent.getRoute(), HomeScreenNavigationMappingKt.toRoute(destination));
    }

    private final void resetTo(HomeNavigationBarDestination destination) {
        this.navController.navigate(HomeScreenNavigationMappingKt.toRoute(destination), new Function1() { // from class: com.box.android.navigationmodernization.homescreen.navigation.HomeScreenNavigator$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HomeScreenNavigator.resetTo$lambda$0(this.f$0, (NavOptionsBuilder) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resetTo$lambda$0(HomeScreenNavigator homeScreenNavigator, NavOptionsBuilder navigate) {
        Intrinsics.checkNotNullParameter(navigate, "$this$navigate");
        navigate.popUpTo(homeScreenNavigator.navController.getGraph().getId(), new Function1() { // from class: com.box.android.navigationmodernization.homescreen.navigation.HomeScreenNavigator$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HomeScreenNavigator.resetTo$lambda$0$0((PopUpToBuilder) obj);
            }
        });
        navigate.setRestoreState(false);
        navigate.setLaunchSingleTop(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resetTo$lambda$0$0(PopUpToBuilder popUpTo) {
        Intrinsics.checkNotNullParameter(popUpTo, "$this$popUpTo");
        popUpTo.setSaveState(true);
        return Unit.INSTANCE;
    }
}
