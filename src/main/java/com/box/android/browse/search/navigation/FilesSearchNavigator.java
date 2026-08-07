package com.box.android.browse.search.navigation;

import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.box.android.base.compose.NavControllerExtensionsKt;
import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.base.presentation.utilities.IItemMoreActionsHandler;
import com.box.android.browse.search.navigation.compose.FilesSearchNavigationMappingKt;
import com.box.android.browse.utilities.BoxSearchItemClickHandler;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilesSearchNavigator.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000bJ\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/search/navigation/FilesSearchNavigator;", "", "boxSearchItemClickHandler", "Lcom/box/android/browse/utilities/BoxSearchItemClickHandler;", "itemMoreActionsHandler", "Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler;", "<init>", "(Lcom/box/android/browse/utilities/BoxSearchItemClickHandler;Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler;)V", "navController", "Landroidx/navigation/NavController;", "init", "", "navigateTo", FirebaseAnalytics.Param.DESTINATION, "Lcom/box/android/browse/search/navigation/FilesSearchDestination;", "popBackStack", "navigateToOuterDestination", "Lcom/box/android/browse/search/navigation/FilesSearchDestination$OuterDestination;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FilesSearchNavigator {
    public static final int $stable = 8;
    private final BoxSearchItemClickHandler boxSearchItemClickHandler;
    private final IItemMoreActionsHandler itemMoreActionsHandler;
    private NavController navController;

    public FilesSearchNavigator(BoxSearchItemClickHandler boxSearchItemClickHandler, IItemMoreActionsHandler itemMoreActionsHandler) {
        Intrinsics.checkNotNullParameter(boxSearchItemClickHandler, "boxSearchItemClickHandler");
        Intrinsics.checkNotNullParameter(itemMoreActionsHandler, "itemMoreActionsHandler");
        this.boxSearchItemClickHandler = boxSearchItemClickHandler;
        this.itemMoreActionsHandler = itemMoreActionsHandler;
    }

    public final void init(NavController navController) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        this.navController = navController;
    }

    public final void navigateTo(FilesSearchDestination destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (!(destination instanceof FilesSearchDestination.InnerDestination.Search)) {
            if (!(destination instanceof FilesSearchDestination.OuterDestination)) {
                throw new NoWhenBranchMatchedException();
            }
            navigateToOuterDestination((FilesSearchDestination.OuterDestination) destination);
        } else {
            NavController navController = this.navController;
            if (navController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navController");
                navController = null;
            }
            NavController.navigate$default(navController, FilesSearchNavigationMappingKt.toRoute((FilesSearchDestination.InnerDestination.Search) destination), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        }
    }

    public final void popBackStack() {
        NavController navController = this.navController;
        if (navController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController = null;
        }
        NavControllerExtensionsKt.popBackStackSafely(navController);
    }

    private final void navigateToOuterDestination(FilesSearchDestination.OuterDestination destination) {
        if (destination instanceof FilesSearchDestination.OuterDestination.FilesSearchItem) {
            this.boxSearchItemClickHandler.onClick(((FilesSearchDestination.OuterDestination.FilesSearchItem) destination).getBoxSearchItem());
        } else {
            if (!(destination instanceof FilesSearchDestination.OuterDestination.FilesSearchItemMoreActionsMenu)) {
                throw new NoWhenBranchMatchedException();
            }
            FilesSearchDestination.OuterDestination.FilesSearchItemMoreActionsMenu filesSearchItemMoreActionsMenu = (FilesSearchDestination.OuterDestination.FilesSearchItemMoreActionsMenu) destination;
            IItemMoreActionsHandler.showBottomSheet$default(this.itemMoreActionsHandler, filesSearchItemMoreActionsMenu.getBoxSearchItem(), filesSearchItemMoreActionsMenu.getBottomSheetMenuType(), (BottomSheetAttributes.LaunchContext) null, (List) null, 12, (Object) null);
        }
    }
}
