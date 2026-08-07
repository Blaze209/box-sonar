package com.box.android.search.navigation;

import androidx.activity.ComponentActivity;
import androidx.navigation.NavController;
import com.box.android.base.compose.NavControllerExtensionsKt;
import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.base.presentation.utilities.IItemMoreActionsHandler;
import com.box.android.browse.utilities.BoxSearchItemClickHandler;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.mappers.ItemModelMapper;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.search.navigation.compose.SearchNavigationMappingKt;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchNavigator.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016J\"\u0010\u0017\u001a\u0004\u0018\u0001H\u0018\"\b\b\u0000\u0010\u0018*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0001J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020 H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/box/android/search/navigation/SearchNavigator;", "", "activity", "Landroidx/activity/ComponentActivity;", "navController", "Landroidx/navigation/NavController;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "boxSearchItemClickHandler", "Lcom/box/android/browse/utilities/BoxSearchItemClickHandler;", "itemMoreActionsHandler", "Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler;", "onFolderSelected", "Lkotlin/Function1;", "Lcom/box/android/domain/models/item/FolderModel;", "", "onFileSelected", "Lcom/box/android/domain/models/item/FileModel;", "<init>", "(Landroidx/activity/ComponentActivity;Landroidx/navigation/NavController;Lcom/box/android/coreservices/services/IntentServices;Lcom/box/android/browse/utilities/BoxSearchItemClickHandler;Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "navigateTo", FirebaseAnalytics.Param.DESTINATION, "Lcom/box/android/search/navigation/SearchDestination;", "navigateForResult", "R", "Lcom/box/android/search/navigation/SearchDestination$InnerDestination;", "(Lcom/box/android/search/navigation/SearchDestination$InnerDestination;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "popBackStack", "", "popWithResult", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "navigateToOuterDestination", "Lcom/box/android/search/navigation/SearchDestination$OuterDestination;", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SearchNavigator {
    public static final int $stable = 8;
    private final ComponentActivity activity;
    private final BoxSearchItemClickHandler boxSearchItemClickHandler;
    private final IntentServices intentServices;
    private final IItemMoreActionsHandler itemMoreActionsHandler;
    private final NavController navController;
    private final Function1<FileModel, Unit> onFileSelected;
    private final Function1<FolderModel, Unit> onFolderSelected;

    /* JADX WARN: Multi-variable type inference failed */
    public SearchNavigator(ComponentActivity activity, NavController navController, IntentServices intentServices, BoxSearchItemClickHandler boxSearchItemClickHandler, IItemMoreActionsHandler itemMoreActionsHandler, Function1<? super FolderModel, Unit> function1, Function1<? super FileModel, Unit> function2) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        Intrinsics.checkNotNullParameter(boxSearchItemClickHandler, "boxSearchItemClickHandler");
        Intrinsics.checkNotNullParameter(itemMoreActionsHandler, "itemMoreActionsHandler");
        this.activity = activity;
        this.navController = navController;
        this.intentServices = intentServices;
        this.boxSearchItemClickHandler = boxSearchItemClickHandler;
        this.itemMoreActionsHandler = itemMoreActionsHandler;
        this.onFolderSelected = function1;
        this.onFileSelected = function2;
    }

    public /* synthetic */ SearchNavigator(ComponentActivity componentActivity, NavController navController, IntentServices intentServices, BoxSearchItemClickHandler boxSearchItemClickHandler, IItemMoreActionsHandler iItemMoreActionsHandler, Function1 function1, Function1 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(componentActivity, navController, intentServices, boxSearchItemClickHandler, iItemMoreActionsHandler, (i & 32) != 0 ? null : function1, (i & 64) != 0 ? null : function2);
    }

    public final void navigateTo(SearchDestination destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (destination instanceof SearchDestination.InnerDestination) {
            SearchDestination.InnerDestination innerDestination = (SearchDestination.InnerDestination) destination;
            NavControllerExtensionsKt.navigateWithArgs(this.navController, SearchNavigationMappingKt.toRoute(innerDestination), innerDestination.getNavArgs());
        } else {
            if (!(destination instanceof SearchDestination.OuterDestination)) {
                throw new NoWhenBranchMatchedException();
            }
            navigateToOuterDestination((SearchDestination.OuterDestination) destination);
        }
    }

    public final <R> Object navigateForResult(SearchDestination.InnerDestination innerDestination, Continuation<? super R> continuation) {
        return NavControllerExtensionsKt.navigateForResult(this.navController, SearchNavigationMappingKt.toRoute(innerDestination), innerDestination.getNavArgs(), continuation);
    }

    public final boolean popBackStack() {
        return NavControllerExtensionsKt.popBackStackSafely(this.navController);
    }

    public final void popWithResult(Object result) {
        Intrinsics.checkNotNullParameter(result, "result");
        NavControllerExtensionsKt.popWithResult(this.navController, result);
    }

    private final void navigateToOuterDestination(SearchDestination.OuterDestination destination) {
        Function1<FileModel, Unit> function1;
        Function1<FolderModel, Unit> function2;
        if (destination instanceof SearchDestination.OuterDestination.Item) {
            SearchDestination.OuterDestination.Item item = (SearchDestination.OuterDestination.Item) destination;
            ItemModel itemModel = item.getItemModel();
            if ((itemModel instanceof FolderModel) && (function2 = this.onFolderSelected) != null) {
                function2.invoke((FolderModel) itemModel);
                return;
            } else if (!(itemModel instanceof FileModel) || (function1 = this.onFileSelected) == null) {
                this.boxSearchItemClickHandler.onClick(ItemModelMapper.toBoxItem$default(ItemModelMapper.INSTANCE, item.getItemModel(), false, 1, null), item.getAccessibleSharedLink());
                return;
            } else {
                function1.invoke((FileModel) itemModel);
                return;
            }
        }
        if (destination instanceof SearchDestination.OuterDestination.Hub) {
            this.activity.startActivity(this.intentServices.hubDetailsActivityIntent(this.activity, ((SearchDestination.OuterDestination.Hub) destination).getHubId()));
        } else {
            if (!(destination instanceof SearchDestination.OuterDestination.ItemMoreActionsMenu)) {
                throw new NoWhenBranchMatchedException();
            }
            IItemMoreActionsHandler.showBottomSheet$default(this.itemMoreActionsHandler, ((SearchDestination.OuterDestination.ItemMoreActionsMenu) destination).getItemModel(), BottomSheetAttributes.BottomSheetMenuType.AddRemoveCollectionItems.INSTANCE, (BottomSheetAttributes.LaunchContext) null, (List) null, 12, (Object) null);
        }
    }
}
