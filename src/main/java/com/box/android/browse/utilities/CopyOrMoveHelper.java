package com.box.android.browse.utilities;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import com.box.android.base.presentation.multiselect.MultiselectReducer;
import com.box.android.browse.R;
import com.box.android.browse.cpl.copymove.CopyOrMoveActivity;
import com.box.android.browse.cpl.copymove.CopyOrMoveReducer;
import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import com.box.android.domain.mappers.FolderModelMapper;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.androidsdk.content.models.BoxFolder;
import com.facebook.react.devsupport.StackTraceHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.events.ComposeIdentificationData;

/* JADX INFO: compiled from: CopyOrMoveHelper.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u001c\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\u0010"}, d2 = {"Lcom/box/android/browse/utilities/CopyOrMoveHelper;", "", "<init>", "()V", "startCopyOrMoveFlow", "", "context", "Landroid/content/Context;", "itemsToCopy", "", "Lcom/box/android/domain/models/item/ItemModel;", "startCopyOrMoveFlowItemModel", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "Companion", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CopyOrMoveHelper {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Inject
    public CopyOrMoveHelper() {
    }

    public final void startCopyOrMoveFlow(Context context, List<? extends ItemModel> itemsToCopy) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemsToCopy, "itemsToCopy");
        startCopyOrMoveFlowItemModel(context, itemsToCopy);
    }

    public final void startCopyOrMoveFlowItemModel(Context context, List<? extends ItemModel> itemsToCopy) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemsToCopy, "itemsToCopy");
        context.startActivity(CopyOrMoveActivity.INSTANCE.getLaunchIntent(context, CollectionsKt.listOf(INSTANCE.rootFolder(context)), itemsToCopy));
    }

    public final void startCopyOrMoveFlow(Context context, ActivityResultLauncher<Intent> launcher, List<? extends ItemModel> itemsToCopy) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(launcher, "launcher");
        Intrinsics.checkNotNullParameter(itemsToCopy, "itemsToCopy");
        launcher.launch(CopyOrMoveActivity.INSTANCE.getLaunchIntent(context, CollectionsKt.listOf(INSTANCE.rootFolder(context)), itemsToCopy));
    }

    /* JADX INFO: compiled from: CopyOrMoveHelper.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\"\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J$\u0010\u0015\u001a\u00020\u000f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bH\u0002J\"\u0010\u0017\u001a\u00020\u000f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bJ*\u0010\u0018\u001a\u00020\u000f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002¨\u0006\u001d"}, d2 = {"Lcom/box/android/browse/utilities/CopyOrMoveHelper$Companion;", "", "<init>", "()V", "rootFolder", "Lcom/box/android/domain/models/item/FolderModel;", "context", "Landroid/content/Context;", "createInitialState", "Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$State;", ComposeIdentificationData.HIERARCHY, "", "Lcom/box/android/domain/models/item/ItemModel;", "itemsToCopy", "hasPermissions", "", "itemsListViewState", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$State;", "isInsideOriginFolder", "originFolderId", "Lcom/box/android/domain/models/ItemId;", "isInsideItemsToCopyMove", StackTraceHelper.STACK_KEY, "isCopyEnabled", "isMoveEnabled", "isCreateFolderEnabled", "hasData", "itemLoadingState", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$LoadingState;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final FolderModel rootFolder(Context context) {
            FolderModelMapper folderModelMapper = FolderModelMapper.INSTANCE;
            BoxFolder boxFolderCreateFromIdAndName = BoxFolder.createFromIdAndName("0", context.getString(R.string.files));
            Intrinsics.checkNotNullExpressionValue(boxFolderCreateFromIdAndName, "createFromIdAndName(...)");
            return FolderModelMapper.toFolderModel$default(folderModelMapper, boxFolderCreateFromIdAndName, false, 1, null);
        }

        public final CopyOrMoveReducer.State createInitialState(List<? extends ItemModel> hierarchy, List<? extends ItemModel> itemsToCopy) {
            ItemId.Remote root_item_id;
            FolderModel parentFolder;
            Intrinsics.checkNotNullParameter(hierarchy, "hierarchy");
            Intrinsics.checkNotNullParameter(itemsToCopy, "itemsToCopy");
            ArrayList arrayList = new ArrayList();
            for (ItemModel itemModel : hierarchy) {
                Intrinsics.checkNotNull(itemModel, "null cannot be cast to non-null type com.box.android.domain.models.item.FolderModel");
                FolderModel folderModel = (FolderModel) itemModel;
                MultiselectReducer.State.Unavailable unavailable = MultiselectReducer.State.Unavailable.INSTANCE;
                List<? extends ItemModel> list = itemsToCopy;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(ItemModelKt.toItemIdRemoteId((ItemModel) it.next()));
                }
                arrayList.add(new ItemsListReducer.State(null, null, null, folderModel, true, CollectionsKt.toSet(arrayList2), null, false, unavailable, null, null, null, null, null, false, false, 65223, null));
            }
            ItemModel itemModel2 = (ItemModel) CollectionsKt.firstOrNull((List) itemsToCopy);
            if (itemModel2 == null || (parentFolder = itemModel2.getParentFolder()) == null || (root_item_id = parentFolder.remoteIdOrNull()) == null) {
                root_item_id = ItemId.INSTANCE.getROOT_ITEM_ID();
            }
            return new CopyOrMoveReducer.State(false, null, root_item_id, arrayList, itemsToCopy, isCopyEnabled(itemsToCopy, arrayList), isMoveEnabled(itemsToCopy, arrayList, ((ItemsListReducer.State) CollectionsKt.last((List) arrayList)).getCurrentFolder().getItemId()), isCreateFolderEnabled((ItemsListReducer.State) CollectionsKt.last((List) arrayList)));
        }

        private final boolean hasPermissions(ItemsListReducer.State itemsListViewState) {
            PermissionsModel permissions = itemsListViewState.getCurrentFolder().getPermissions();
            if (permissions != null) {
                return permissions.getCanUpload();
            }
            return true;
        }

        private final boolean isInsideOriginFolder(ItemsListReducer.State itemsListViewState, ItemId originFolderId) {
            return Intrinsics.areEqual(itemsListViewState.getCurrentFolder().getItemId(), originFolderId);
        }

        private final boolean isInsideItemsToCopyMove(List<? extends ItemModel> itemsToCopy, List<ItemsListReducer.State> stack) {
            List<? extends ItemModel> list = itemsToCopy;
            if ((list instanceof Collection) && list.isEmpty()) {
                return false;
            }
            for (ItemModel itemModel : list) {
                Iterator<T> it = stack.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((ItemsListReducer.State) it.next()).getCurrentFolder().getItemId(), itemModel.getItemId())) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final boolean isCopyEnabled(List<? extends ItemModel> itemsToCopy, List<ItemsListReducer.State> stack) {
            Intrinsics.checkNotNullParameter(itemsToCopy, "itemsToCopy");
            Intrinsics.checkNotNullParameter(stack, "stack");
            return !isInsideItemsToCopyMove(itemsToCopy, stack) && hasPermissions((ItemsListReducer.State) CollectionsKt.last((List) stack)) && hasData(((ItemsListReducer.State) CollectionsKt.last((List) stack)).getItemLoadingState());
        }

        public final boolean isMoveEnabled(List<? extends ItemModel> itemsToCopy, List<ItemsListReducer.State> stack, ItemId originFolderId) {
            Intrinsics.checkNotNullParameter(itemsToCopy, "itemsToCopy");
            Intrinsics.checkNotNullParameter(stack, "stack");
            Intrinsics.checkNotNullParameter(originFolderId, "originFolderId");
            return isCopyEnabled(itemsToCopy, stack) && !isInsideOriginFolder((ItemsListReducer.State) CollectionsKt.last((List) stack), originFolderId) && hasData(((ItemsListReducer.State) CollectionsKt.last((List) stack)).getItemLoadingState());
        }

        public final boolean isCreateFolderEnabled(ItemsListReducer.State itemsListViewState) {
            Intrinsics.checkNotNullParameter(itemsListViewState, "itemsListViewState");
            return hasPermissions(itemsListViewState) && hasData(itemsListViewState.getItemLoadingState());
        }

        private final boolean hasData(ItemsListReducer.LoadingState itemLoadingState) {
            return (Intrinsics.areEqual(itemLoadingState, ItemsListReducer.LoadingState.ForbiddenByPolicy.INSTANCE) || Intrinsics.areEqual(itemLoadingState, ItemsListReducer.LoadingState.Loading.INSTANCE) || Intrinsics.areEqual(itemLoadingState, ItemsListReducer.LoadingState.Error.INSTANCE)) ? false : true;
        }
    }
}
