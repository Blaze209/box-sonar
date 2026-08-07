package com.box.android.browse.cpl.navigationmodernization;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.base.presentation.utilities.IItemClickHandler;
import com.box.android.base.presentation.utilities.IItemMoreActionsHandler;
import com.box.android.browse.cpl.itemsList.BottomSheetItemAction;
import com.box.android.browse.cpl.itemsList.ItemsBatchActionNavigationHelper;
import com.box.android.browse.cpl.navigationmodernization.compose.BrowseNavigationMappingKt;
import com.box.android.browse.utilities.CopyOrMoveHelper;
import com.box.android.common.utilities.IntentUtils;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.mappers.FileModelMapper;
import com.box.android.domain.mappers.FolderModelMapper;
import com.box.android.domain.mappers.ItemModelMapper;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BrowseNavigator.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018J\u001c\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u001bJ\"\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u001d2\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001bH\u0002J2\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u001f2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!2\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/BrowseNavigator;", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "itemClickHandler", "Lcom/box/android/base/presentation/utilities/IItemClickHandler;", "itemMoreActionsHandler", "Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler;", "copyOrMoveHelper", "Lcom/box/android/browse/utilities/CopyOrMoveHelper;", "<init>", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/box/android/coreservices/services/IntentServices;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/base/presentation/utilities/IItemClickHandler;Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler;Lcom/box/android/browse/utilities/CopyOrMoveHelper;)V", "navController", "Landroidx/navigation/NavController;", "batchActionNavigationHelper", "Lcom/box/android/browse/cpl/itemsList/ItemsBatchActionNavigationHelper;", "init", "", "navigateTo", FirebaseAnalytics.Param.DESTINATION, "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination;", "navigateToWithCallback", "callback", "Lkotlin/Function0;", "navigateToOuterDestination", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination;", "navigateToItemsBatchActionFlow", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$ItemsBatchActionFlow;", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "pendingOuterNavigationCallback", "outerNavigationWithCallbackLauncher", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BrowseNavigator {
    public static final int $stable = 8;
    private final AppCompatActivity activity;
    private final ItemsBatchActionNavigationHelper batchActionNavigationHelper;
    private final IntentServices intentServices;
    private final IItemClickHandler itemClickHandler;
    private final IItemMoreActionsHandler itemMoreActionsHandler;
    private NavController navController;
    private final ActivityResultLauncher<Intent> outerNavigationWithCallbackLauncher;
    private Function0<Unit> pendingOuterNavigationCallback;
    private final IUserContextManager userContextManager;

    public BrowseNavigator(AppCompatActivity activity, IntentServices intentServices, IUserContextManager userContextManager, IItemClickHandler itemClickHandler, IItemMoreActionsHandler itemMoreActionsHandler, CopyOrMoveHelper copyOrMoveHelper) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(itemClickHandler, "itemClickHandler");
        Intrinsics.checkNotNullParameter(itemMoreActionsHandler, "itemMoreActionsHandler");
        Intrinsics.checkNotNullParameter(copyOrMoveHelper, "copyOrMoveHelper");
        this.activity = activity;
        this.intentServices = intentServices;
        this.userContextManager = userContextManager;
        this.itemClickHandler = itemClickHandler;
        this.itemMoreActionsHandler = itemMoreActionsHandler;
        this.batchActionNavigationHelper = new ItemsBatchActionNavigationHelper(activity, copyOrMoveHelper, intentServices);
        this.outerNavigationWithCallbackLauncher = activity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.box.android.browse.cpl.navigationmodernization.BrowseNavigator$outerNavigationWithCallbackLauncher$1
            @Override // androidx.activity.result.ActivityResultCallback
            public void onActivityResult(ActivityResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                Function0 function0 = this.this$0.pendingOuterNavigationCallback;
                if (function0 != null) {
                    function0.invoke();
                }
                this.this$0.pendingOuterNavigationCallback = null;
            }
        });
    }

    public final void init(NavController navController) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        this.navController = navController;
    }

    public final void navigateTo(BrowseDestination destination) {
        NavController navController;
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (!(destination instanceof BrowseDestination.InnerDestination.TabsScreen)) {
            if (!(destination instanceof BrowseDestination.OuterDestination)) {
                throw new NoWhenBranchMatchedException();
            }
            navigateToOuterDestination$default(this, (BrowseDestination.OuterDestination) destination, null, 2, null);
        } else {
            NavController navController2 = this.navController;
            if (navController2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navController");
                navController = null;
            } else {
                navController = navController2;
            }
            NavController.navigate$default(navController, BrowseNavigationMappingKt.toRoute((BrowseDestination.InnerDestination.TabsScreen) destination), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        }
    }

    public final void navigateToWithCallback(BrowseDestination destination, final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.pendingOuterNavigationCallback == null && (destination instanceof BrowseDestination.OuterDestination)) {
            this.pendingOuterNavigationCallback = callback;
            navigateToOuterDestination((BrowseDestination.OuterDestination) destination, new Function0() { // from class: com.box.android.browse.cpl.navigationmodernization.BrowseNavigator$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BrowseNavigator.navigateToWithCallback$lambda$0(callback, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit navigateToWithCallback$lambda$0(Function0 function0, BrowseNavigator browseNavigator) {
        function0.invoke();
        browseNavigator.pendingOuterNavigationCallback = null;
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void navigateToOuterDestination$default(BrowseNavigator browseNavigator, BrowseDestination.OuterDestination outerDestination, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        browseNavigator.navigateToOuterDestination(outerDestination, function0);
    }

    private final void navigateToOuterDestination(BrowseDestination.OuterDestination destination, final Function0<Unit> callback) {
        ActivityResultLauncher<Intent> activityResultLauncher = callback != null ? this.outerNavigationWithCallbackLauncher : null;
        if (destination instanceof BrowseDestination.OuterDestination.Folder) {
            this.itemClickHandler.onFolderClick(FolderModelMapper.toBoxFolder$default(FolderModelMapper.INSTANCE, ((BrowseDestination.OuterDestination.Folder) destination).getFolderModel(), false, 1, null), new IItemClickHandler.FolderClickConfig(null, 67108864, activityResultLauncher, false, 9, null));
            return;
        }
        if (destination instanceof BrowseDestination.OuterDestination.File) {
            BrowseDestination.OuterDestination.File file = (BrowseDestination.OuterDestination.File) destination;
            this.itemClickHandler.onFileClick(FileModelMapper.toBoxFile$default(FileModelMapper.INSTANCE, file.getFileModel(), false, 1, null), new IItemClickHandler.FileClickConfig(file.getPreviewSource(), null, activityResultLauncher, callback, null, null, null, false, false, 498, null));
            return;
        }
        if (destination instanceof BrowseDestination.OuterDestination.WebLink) {
            IItemClickHandler.onClick$default(this.itemClickHandler, ItemModelMapper.toBoxItem$default(ItemModelMapper.INSTANCE, ((BrowseDestination.OuterDestination.WebLink) destination).getWebLinkModel(), false, 1, null), PreviewSource.Browse.INSTANCE, activityResultLauncher, false, 8, null);
            return;
        }
        if (destination instanceof BrowseDestination.OuterDestination.RecentFile) {
            IItemClickHandler.onClick$default(this.itemClickHandler, ItemModelMapper.toBoxItem$default(ItemModelMapper.INSTANCE, ((BrowseDestination.OuterDestination.RecentFile) destination).getRecentFileModel(), false, 1, null), PreviewSource.Recents.INSTANCE, activityResultLauncher, false, 8, null);
            return;
        }
        if (destination instanceof BrowseDestination.OuterDestination.FeatureBanner) {
            if (activityResultLauncher != null) {
                ((BrowseDestination.OuterDestination.FeatureBanner) destination).getData().getBanner().onPrimaryActionClicked(activityResultLauncher);
                return;
            } else {
                ((BrowseDestination.OuterDestination.FeatureBanner) destination).getData().getBanner().onPrimaryActionClicked(this.activity);
                return;
            }
        }
        if (destination instanceof BrowseDestination.OuterDestination.InviteCollaborators) {
            IntentUtils.INSTANCE.launchWithLauncherIfExistOrWithActivity(this.intentServices.inviteCollaboratorsActivityIntent(this.activity, ((BrowseDestination.OuterDestination.InviteCollaborators) destination).getFolderModel(), this.userContextManager.getBoxSession(this.activity)), this.activity, activityResultLauncher);
            return;
        }
        if (destination instanceof BrowseDestination.OuterDestination.CreateNewDocument) {
            BrowseDestination.OuterDestination.CreateNewDocument createNewDocument = (BrowseDestination.OuterDestination.CreateNewDocument) destination;
            ItemId itemId = createNewDocument.getFolderModel().getItemId();
            ItemId.Remote remote = itemId instanceof ItemId.Remote ? (ItemId.Remote) itemId : null;
            if (remote == null) {
                BoxLogUtils.e("Can't create file inside folder with local id, folder id = " + createNewDocument.getFolderModel().getItemId());
                return;
            } else {
                this.activity.startActivity(this.intentServices.createDocumentTaskIntent(this.activity, remote.getBoxId(), createNewDocument.getAssetName()));
                return;
            }
        }
        if (destination instanceof BrowseDestination.OuterDestination.ItemMoreActionsMenu) {
            this.itemMoreActionsHandler.setOnMenuClosedListener(new Function0() { // from class: com.box.android.browse.cpl.navigationmodernization.BrowseNavigator$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BrowseNavigator.navigateToOuterDestination$lambda$0(callback);
                }
            });
            BrowseDestination.OuterDestination.ItemMoreActionsMenu itemMoreActionsMenu = (BrowseDestination.OuterDestination.ItemMoreActionsMenu) destination;
            this.itemMoreActionsHandler.setOnBottomSheetActionListener(itemMoreActionsMenu.getOnBottomSheetAction());
            IItemMoreActionsHandler iItemMoreActionsHandler = this.itemMoreActionsHandler;
            ItemModel itemModel = itemMoreActionsMenu.getItemModel();
            BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType = itemMoreActionsMenu.getBottomSheetMenuType();
            BottomSheetAttributes.LaunchContext launchContext = itemMoreActionsMenu.getLaunchContext();
            List<BottomSheetItemAction> availableActions = itemMoreActionsMenu.getAvailableActions();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(availableActions, 10));
            Iterator<T> it = availableActions.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((BottomSheetItemAction) it.next()).getId()));
            }
            iItemMoreActionsHandler.showBottomSheet(itemModel, bottomSheetMenuType, launchContext, arrayList);
            return;
        }
        if (destination instanceof BrowseDestination.OuterDestination.ItemsBatchActionFlow) {
            navigateToItemsBatchActionFlow((BrowseDestination.OuterDestination.ItemsBatchActionFlow) destination, activityResultLauncher, callback);
        } else {
            if (!(destination instanceof BrowseDestination.OuterDestination.PlayStoreBoxPage)) {
                throw new NoWhenBranchMatchedException();
            }
            IntentUtils.INSTANCE.launchWithLauncherIfExistOrWithActivity(this.intentServices.playStoreBoxPageIntent(), this.activity, activityResultLauncher);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit navigateToOuterDestination$lambda$0(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void navigateToItemsBatchActionFlow$default(BrowseNavigator browseNavigator, BrowseDestination.OuterDestination.ItemsBatchActionFlow itemsBatchActionFlow, ActivityResultLauncher activityResultLauncher, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        browseNavigator.navigateToItemsBatchActionFlow(itemsBatchActionFlow, activityResultLauncher, function0);
    }

    private final void navigateToItemsBatchActionFlow(final BrowseDestination.OuterDestination.ItemsBatchActionFlow destination, ActivityResultLauncher<Intent> launcher, final Function0<Unit> callback) {
        BrowseDestination.OuterDestination.ItemsBatchActionFlow.BatchAction batchAction = destination.getBatchAction();
        if (Intrinsics.areEqual(batchAction, BrowseDestination.OuterDestination.ItemsBatchActionFlow.BatchAction.CopyMove.INSTANCE)) {
            this.batchActionNavigationHelper.navigateToCopyMoveFlow(destination.getItems(), launcher);
        } else if (Intrinsics.areEqual(batchAction, BrowseDestination.OuterDestination.ItemsBatchActionFlow.BatchAction.Delete.INSTANCE)) {
            this.batchActionNavigationHelper.navigateToDeleteFlow(destination.getItems(), launcher);
        } else {
            if (!(batchAction instanceof BrowseDestination.OuterDestination.ItemsBatchActionFlow.BatchAction.Export)) {
                throw new NoWhenBranchMatchedException();
            }
            this.batchActionNavigationHelper.navigateToExportFlow(new Function1() { // from class: com.box.android.browse.cpl.navigationmodernization.BrowseNavigator$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BrowseNavigator.navigateToItemsBatchActionFlow$lambda$0(destination, callback, (String) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit navigateToItemsBatchActionFlow$lambda$0(BrowseDestination.OuterDestination.ItemsBatchActionFlow itemsBatchActionFlow, Function0 function0, String str) {
        ((BrowseDestination.OuterDestination.ItemsBatchActionFlow.BatchAction.Export) itemsBatchActionFlow.getBatchAction()).getOnExportFolderSelected().invoke(str);
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }
}
