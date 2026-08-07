package com.box.android.browse.cpl.itemsList;

import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.browse.cpl.navigationmodernization.BrowseDestination;
import com.box.android.browse.cpl.navigationmodernization.BrowseNavigator;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.ItemModel;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActionableItemsListNavigation.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001aR\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fH\u0000\u001aL\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fH\u0002\u001a*\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fH\u0002¨\u0006\u0015"}, d2 = {"navigateActionableItemsList", "", "navigator", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseNavigator;", "route", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$State;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "bottomSheetMenuType", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType;", "launchContext", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$LaunchContext;", "onReturnCallback", "Lkotlin/Function0;", "handleMoreActions", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route$MoreActions;", "navigateToWithCallbackIfNeeded", FirebaseAnalytics.Param.DESTINATION, "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination;", "browse_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ActionableItemsListNavigationKt {
    public static /* synthetic */ void navigateActionableItemsList$default(BrowseNavigator browseNavigator, ActionableItemsListReducer.Route route, Store store, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType, BottomSheetAttributes.LaunchContext launchContext, Function0 function0, int i, Object obj) {
        if ((i & 8) != 0) {
            bottomSheetMenuType = BottomSheetAttributes.BottomSheetMenuType.AddRemoveCollectionItems.INSTANCE;
        }
        BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType2 = bottomSheetMenuType;
        if ((i & 16) != 0) {
            launchContext = BottomSheetAttributes.LaunchContext.Default.INSTANCE;
        }
        BottomSheetAttributes.LaunchContext launchContext2 = launchContext;
        if ((i & 32) != 0) {
            function0 = null;
        }
        navigateActionableItemsList(browseNavigator, route, store, bottomSheetMenuType2, launchContext2, function0);
    }

    public static final void navigateActionableItemsList(BrowseNavigator navigator, ActionableItemsListReducer.Route route, final Store<ActionableItemsListReducer.State, ActionableItemsListReducer.Action> store, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType, BottomSheetAttributes.LaunchContext launchContext, Function0<Unit> function0) {
        BrowseDestination.OuterDestination.ItemsBatchActionFlow.BatchAction.Export export;
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(bottomSheetMenuType, "bottomSheetMenuType");
        Intrinsics.checkNotNullParameter(launchContext, "launchContext");
        if (route instanceof ActionableItemsListReducer.Route.Batch) {
            ActionableItemsListReducer.Route.Batch batch = (ActionableItemsListReducer.Route.Batch) route;
            if (batch instanceof ActionableItemsListReducer.Route.Batch.BatchCopyMove) {
                export = BrowseDestination.OuterDestination.ItemsBatchActionFlow.BatchAction.CopyMove.INSTANCE;
            } else if (batch instanceof ActionableItemsListReducer.Route.Batch.BatchDelete) {
                export = BrowseDestination.OuterDestination.ItemsBatchActionFlow.BatchAction.Delete.INSTANCE;
            } else {
                if (!(batch instanceof ActionableItemsListReducer.Route.Batch.BatchExport)) {
                    throw new NoWhenBranchMatchedException();
                }
                export = new BrowseDestination.OuterDestination.ItemsBatchActionFlow.BatchAction.Export(new Function1() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListNavigationKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ActionableItemsListNavigationKt.navigateActionableItemsList$lambda$0(store, (String) obj);
                    }
                });
            }
            navigateToWithCallbackIfNeeded(navigator, new BrowseDestination.OuterDestination.ItemsBatchActionFlow(export, batch.getFiles()), function0);
            store.send(ActionableItemsListReducer.Action.ExitMultiselectMode.INSTANCE);
            return;
        }
        if (route instanceof ActionableItemsListReducer.Route.MoreActions) {
            handleMoreActions(navigator, (ActionableItemsListReducer.Route.MoreActions) route, bottomSheetMenuType, launchContext, store, function0);
        } else {
            if (!(route instanceof ActionableItemsListReducer.Route.UpdateApp)) {
                throw new NoWhenBranchMatchedException();
            }
            navigateToWithCallbackIfNeeded(navigator, BrowseDestination.OuterDestination.PlayStoreBoxPage.INSTANCE, function0);
            store.send(ActionableItemsListReducer.Action.NavigationCompleted.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit navigateActionableItemsList$lambda$0(Store store, String str) {
        store.send(ActionableItemsListReducerKt.downloadToSelectedFolder(ActionableItemsListReducer.Action.INSTANCE, str));
        return Unit.INSTANCE;
    }

    private static final void handleMoreActions(BrowseNavigator browseNavigator, ActionableItemsListReducer.Route.MoreActions moreActions, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType, BottomSheetAttributes.LaunchContext launchContext, final Store<ActionableItemsListReducer.State, ActionableItemsListReducer.Action> store, final Function0<Unit> function0) {
        browseNavigator.navigateToWithCallback(new BrowseDestination.OuterDestination.ItemMoreActionsMenu(moreActions.getItem(), bottomSheetMenuType, launchContext, moreActions.getAvailableActions(), new Function2() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListNavigationKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ActionableItemsListNavigationKt.handleMoreActions$lambda$0(store, ((Integer) obj).intValue(), (ItemModel) obj2);
            }
        }), new Function0() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListNavigationKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ActionableItemsListNavigationKt.handleMoreActions$lambda$1(store, function0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleMoreActions$lambda$0(Store store, int i, ItemModel itemModel) {
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        if (i == BottomSheetItemAction.BoxAi.getId()) {
            store.send(new ActionableItemsListReducer.Action.OpenBoxAiForItem(itemModel));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleMoreActions$lambda$1(Store store, Function0 function0) {
        store.send(ActionableItemsListReducer.Action.NavigationCompleted.INSTANCE);
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    static /* synthetic */ void navigateToWithCallbackIfNeeded$default(BrowseNavigator browseNavigator, BrowseDestination.OuterDestination outerDestination, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        navigateToWithCallbackIfNeeded(browseNavigator, outerDestination, function0);
    }

    private static final void navigateToWithCallbackIfNeeded(BrowseNavigator browseNavigator, BrowseDestination.OuterDestination outerDestination, Function0<Unit> function0) {
        if (function0 == null) {
            browseNavigator.navigateTo(outerDestination);
        } else {
            browseNavigator.navigateToWithCallback(outerDestination, function0);
        }
    }
}
