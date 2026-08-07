package com.box.android.browse.cpl.itemsList;

import android.content.DialogInterface;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.base.presentation.utilities.IItemActionHandler;
import com.box.android.browse.utilities.CopyOrMoveHelper;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.ItemModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActionableItemsListRouter.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ActionableItemsListRouter;", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "itemActionHandler", "Lcom/box/android/base/presentation/utilities/IItemActionHandler;", "copyOrMoveHelper", "Lcom/box/android/browse/utilities/CopyOrMoveHelper;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "launchContext", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$LaunchContext;", "<init>", "(Landroidx/appcompat/app/AppCompatActivity;Landroidx/activity/result/ActivityResultLauncher;Lcom/box/android/base/presentation/utilities/IItemActionHandler;Lcom/box/android/browse/utilities/CopyOrMoveHelper;Lcom/box/android/coreservices/services/IntentServices;Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$LaunchContext;)V", "batchActionNavigationHelper", "Lcom/box/android/browse/cpl/itemsList/ItemsBatchActionNavigationHelper;", "navigate", "", "itemActionRoute", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$State;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ActionableItemsListRouter {
    public static final int $stable = 8;
    private final AppCompatActivity activity;
    private final ItemsBatchActionNavigationHelper batchActionNavigationHelper;
    private final IntentServices intentServices;
    private final IItemActionHandler itemActionHandler;
    private final BottomSheetAttributes.LaunchContext launchContext;
    private final ActivityResultLauncher<Intent> launcher;

    public ActionableItemsListRouter(AppCompatActivity activity, ActivityResultLauncher<Intent> launcher, IItemActionHandler itemActionHandler, CopyOrMoveHelper copyOrMoveHelper, IntentServices intentServices, BottomSheetAttributes.LaunchContext launchContext) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(launcher, "launcher");
        Intrinsics.checkNotNullParameter(itemActionHandler, "itemActionHandler");
        Intrinsics.checkNotNullParameter(copyOrMoveHelper, "copyOrMoveHelper");
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        Intrinsics.checkNotNullParameter(launchContext, "launchContext");
        this.activity = activity;
        this.launcher = launcher;
        this.itemActionHandler = itemActionHandler;
        this.intentServices = intentServices;
        this.launchContext = launchContext;
        this.batchActionNavigationHelper = new ItemsBatchActionNavigationHelper(activity, copyOrMoveHelper, intentServices);
    }

    public /* synthetic */ ActionableItemsListRouter(AppCompatActivity appCompatActivity, ActivityResultLauncher activityResultLauncher, IItemActionHandler iItemActionHandler, CopyOrMoveHelper copyOrMoveHelper, IntentServices intentServices, BottomSheetAttributes.LaunchContext.Default r13, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appCompatActivity, activityResultLauncher, iItemActionHandler, copyOrMoveHelper, intentServices, (i & 32) != 0 ? BottomSheetAttributes.LaunchContext.Default.INSTANCE : r13);
    }

    public final void navigate(ActionableItemsListReducer.Route itemActionRoute, final Store<ActionableItemsListReducer.State, ActionableItemsListReducer.Action> store) {
        Intrinsics.checkNotNullParameter(itemActionRoute, "itemActionRoute");
        Intrinsics.checkNotNullParameter(store, "store");
        if (itemActionRoute instanceof ActionableItemsListReducer.Route.Batch.BatchCopyMove) {
            this.batchActionNavigationHelper.navigateToCopyMoveFlow(((ActionableItemsListReducer.Route.Batch.BatchCopyMove) itemActionRoute).getFiles(), this.launcher);
            store.send(ActionableItemsListReducer.Action.ExitMultiselectMode.INSTANCE);
            return;
        }
        if (itemActionRoute instanceof ActionableItemsListReducer.Route.Batch.BatchDelete) {
            this.batchActionNavigationHelper.navigateToDeleteFlow(((ActionableItemsListReducer.Route.Batch.BatchDelete) itemActionRoute).getFiles(), this.launcher);
            store.send(ActionableItemsListReducer.Action.ExitMultiselectMode.INSTANCE);
            return;
        }
        if (itemActionRoute instanceof ActionableItemsListReducer.Route.Batch.BatchExport) {
            this.batchActionNavigationHelper.navigateToExportFlow(new Function1() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListRouter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ActionableItemsListRouter.navigate$lambda$0(store, (String) obj);
                }
            });
            store.send(ActionableItemsListReducer.Action.ExitMultiselectMode.INSTANCE);
            return;
        }
        if (itemActionRoute instanceof ActionableItemsListReducer.Route.MoreActions) {
            this.itemActionHandler.setOnItemClosedListener(new Function0() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListRouter$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ActionableItemsListRouter.navigate$lambda$1(store);
                }
            });
            this.itemActionHandler.setOnBottomSheetActionListener(new Function2() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListRouter$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ActionableItemsListRouter.navigate$lambda$2(store, ((Integer) obj).intValue(), (ItemModel) obj2);
                }
            });
            IItemActionHandler iItemActionHandler = this.itemActionHandler;
            ActionableItemsListReducer.Route.MoreActions moreActions = (ActionableItemsListReducer.Route.MoreActions) itemActionRoute;
            ItemModel item = moreActions.getItem();
            BottomSheetAttributes.BottomSheetMenuType.AddRemoveCollectionItems addRemoveCollectionItems = BottomSheetAttributes.BottomSheetMenuType.AddRemoveCollectionItems.INSTANCE;
            List<BottomSheetItemAction> availableActions = moreActions.getAvailableActions();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(availableActions, 10));
            Iterator<T> it = availableActions.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((BottomSheetItemAction) it.next()).getId()));
            }
            BottomSheetAttributes.BottomSheetMenuType.AddRemoveCollectionItems addRemoveCollectionItems2 = addRemoveCollectionItems;
            IItemActionHandler.showBottomSheet$default(iItemActionHandler, item, addRemoveCollectionItems2, this.launchContext, (DialogInterface.OnShowListener) null, arrayList, 8, (Object) null);
            return;
        }
        if (!(itemActionRoute instanceof ActionableItemsListReducer.Route.UpdateApp)) {
            throw new NoWhenBranchMatchedException();
        }
        this.activity.startActivity(this.intentServices.playStoreBoxPageIntent());
        store.send(ActionableItemsListReducer.Action.NavigationCompleted.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit navigate$lambda$0(Store store, String str) {
        store.send(ActionableItemsListReducerKt.downloadToSelectedFolder(ActionableItemsListReducer.Action.INSTANCE, str));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit navigate$lambda$1(Store store) {
        store.send(ActionableItemsListReducer.Action.NavigationCompleted.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit navigate$lambda$2(Store store, int i, ItemModel itemModel) {
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        if (i == BottomSheetItemAction.BoxAi.getId()) {
            store.send(new ActionableItemsListReducer.Action.OpenBoxAiForItem(itemModel));
        }
        return Unit.INSTANCE;
    }
}
