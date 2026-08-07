package com.box.android.collections.presentation.navigationmodernization.navigation;

import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.Navigator;
import androidx.navigation.PopUpToBuilder;
import com.box.android.base.compose.NavControllerExtensionsKt;
import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.base.presentation.utilities.IItemClickHandler;
import com.box.android.base.presentation.utilities.IItemMoreActionsHandler;
import com.box.android.collections.presentation.navigationmodernization.navigation.compose.CollectionsNavigationMappingKt;
import com.box.android.domain.mappers.ItemModelMapper;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionsNavigator.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u000bJ\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsNavigator;", "", "itemClickHandler", "Lcom/box/android/base/presentation/utilities/IItemClickHandler;", "itemMoreActionsHandler", "Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler;", "<init>", "(Lcom/box/android/base/presentation/utilities/IItemClickHandler;Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler;)V", "navController", "Landroidx/navigation/NavController;", "init", "", "navigateTo", FirebaseAnalytics.Param.DESTINATION, "Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination;", "resetTo", "config", "Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsNavigationConfig;", "popBackStack", "navigateToOuterDestination", "Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsDestination$OuterDestination;", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionsNavigator {
    public static final int $stable = 8;
    private final IItemClickHandler itemClickHandler;
    private final IItemMoreActionsHandler itemMoreActionsHandler;
    private NavController navController;

    public CollectionsNavigator(IItemClickHandler itemClickHandler, IItemMoreActionsHandler itemMoreActionsHandler) {
        Intrinsics.checkNotNullParameter(itemClickHandler, "itemClickHandler");
        Intrinsics.checkNotNullParameter(itemMoreActionsHandler, "itemMoreActionsHandler");
        this.itemClickHandler = itemClickHandler;
        this.itemMoreActionsHandler = itemMoreActionsHandler;
    }

    public final void init(NavController navController) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        this.navController = navController;
    }

    public final void navigateTo(CollectionsDestination destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (!(destination instanceof CollectionsDestination.InnerDestination)) {
            if (!(destination instanceof CollectionsDestination.OuterDestination)) {
                throw new NoWhenBranchMatchedException();
            }
            navigateToOuterDestination((CollectionsDestination.OuterDestination) destination);
        } else {
            NavController navController = this.navController;
            if (navController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navController");
                navController = null;
            }
            NavController.navigate$default(navController, CollectionsNavigationMappingKt.toRoute((CollectionsDestination.InnerDestination) destination), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        }
    }

    public final void resetTo(CollectionsNavigationConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        NavController navController = this.navController;
        if (navController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController = null;
        }
        navController.navigate(CollectionsNavigationMappingKt.toRoute(config.getStartDestination()), new Function1() { // from class: com.box.android.collections.presentation.navigationmodernization.navigation.CollectionsNavigator$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CollectionsNavigator.resetTo$lambda$0((NavOptionsBuilder) obj);
            }
        });
        for (CollectionsDestination.InnerDestination innerDestination : config.getAdditionalDestinations()) {
            NavController navController2 = this.navController;
            if (navController2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navController");
                navController2 = null;
            }
            navController2.navigate(CollectionsNavigationMappingKt.toRoute(innerDestination), new Function1() { // from class: com.box.android.collections.presentation.navigationmodernization.navigation.CollectionsNavigator$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CollectionsNavigator.resetTo$lambda$1$0((NavOptionsBuilder) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resetTo$lambda$0(NavOptionsBuilder navigate) {
        Intrinsics.checkNotNullParameter(navigate, "$this$navigate");
        navigate.popUpTo(CollectionsNavigationMappingKt.graphToRoute(CollectionsDestination.INSTANCE), new Function1() { // from class: com.box.android.collections.presentation.navigationmodernization.navigation.CollectionsNavigator$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CollectionsNavigator.resetTo$lambda$0$0((PopUpToBuilder) obj);
            }
        });
        navigate.setLaunchSingleTop(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resetTo$lambda$0$0(PopUpToBuilder popUpTo) {
        Intrinsics.checkNotNullParameter(popUpTo, "$this$popUpTo");
        popUpTo.setInclusive(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resetTo$lambda$1$0(NavOptionsBuilder navigate) {
        Intrinsics.checkNotNullParameter(navigate, "$this$navigate");
        navigate.setLaunchSingleTop(true);
        return Unit.INSTANCE;
    }

    public final void popBackStack() {
        NavController navController = this.navController;
        if (navController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController = null;
        }
        NavControllerExtensionsKt.popBackStackSafely(navController);
    }

    private final void navigateToOuterDestination(CollectionsDestination.OuterDestination destination) {
        if (destination instanceof CollectionsDestination.OuterDestination.Item) {
            CollectionsDestination.OuterDestination.Item item = (CollectionsDestination.OuterDestination.Item) destination;
            IItemClickHandler.onClick$default(this.itemClickHandler, ItemModelMapper.toBoxItem$default(ItemModelMapper.INSTANCE, item.getItemModel(), false, 1, null), item.getPreviewSource(), null, false, 12, null);
        } else {
            if (!(destination instanceof CollectionsDestination.OuterDestination.ItemMoreActionsMenu)) {
                throw new NoWhenBranchMatchedException();
            }
            CollectionsDestination.OuterDestination.ItemMoreActionsMenu itemMoreActionsMenu = (CollectionsDestination.OuterDestination.ItemMoreActionsMenu) destination;
            IItemMoreActionsHandler.showBottomSheet$default(this.itemMoreActionsHandler, itemMoreActionsMenu.getItemModel(), itemMoreActionsMenu.getBottomSheetMenuType(), (BottomSheetAttributes.LaunchContext) null, (List) null, 12, (Object) null);
        }
    }
}
