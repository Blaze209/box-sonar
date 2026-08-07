package com.box.android.domain.models.item;

import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.R;
import com.box.android.domain.mappers.RecentFileModelMapper;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0001\u001a\f\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u0002\u001a\f\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u0002\u001a\u000e\u0010\t\u001a\u0004\u0018\u00010\n*\u0004\u0018\u00010\u0002\u001a\n\u0010\u000b\u001a\u00020\f*\u00020\u0002\u001a\n\u0010\r\u001a\u00020\u000e*\u00020\u0002\u001a\n\u0010\u000f\u001a\u00020\u000e*\u00020\u0002¨\u0006\u0010"}, d2 = {"parentConsideringRootFolder", "", "Lcom/box/android/domain/models/item/ItemModel;", "fullPath", "separator", "parentWithRoot", "Lcom/box/android/domain/models/ItemId;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "type", "Lcom/box/android/domain/models/item/ItemType;", "toItemIdRemoteId", "Lcom/box/android/domain/models/ItemId$Remote;", "isViewOnly", "", "isInFavorites", "domain_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ItemModelKt {
    public static final String parentConsideringRootFolder(ItemModel itemModel) {
        Intrinsics.checkNotNullParameter(itemModel, "<this>");
        FolderModel parentFolder = itemModel.getParentFolder();
        if (parentFolder == null || parentFolder.isRoot()) {
            return (parentFolder != null || itemModel.isRooted()) ? CommonBoxUtil.LS(R.string.files) : "";
        }
        return parentFolder.getName();
    }

    public static final String fullPath(ItemModel itemModel, String separator) {
        String strJoinToString$default;
        String name;
        Intrinsics.checkNotNullParameter(itemModel, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        List<PathCollectionEntry> pathCollection = itemModel.getPathCollection();
        if (pathCollection != null) {
            List<PathCollectionEntry> list = pathCollection;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (PathCollectionEntry pathCollectionEntry : list) {
                if (Intrinsics.areEqual(pathCollectionEntry.getId().getBoxId(), "0")) {
                    name = CommonBoxUtil.LS(R.string.files);
                } else {
                    name = pathCollectionEntry.getName();
                }
                arrayList.add(name);
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (((String) obj).length() > 0) {
                    arrayList2.add(obj);
                }
            }
            strJoinToString$default = CollectionsKt.joinToString$default(arrayList2, separator, null, null, 0, null, null, 62, null);
        } else {
            strJoinToString$default = null;
        }
        return strJoinToString$default == null ? "" : strJoinToString$default;
    }

    public static /* synthetic */ String fullPath$default(ItemModel itemModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "/";
        }
        return fullPath(itemModel, str);
    }

    public static final ItemId parentWithRoot(ItemModel itemModel) {
        ItemId itemId;
        Intrinsics.checkNotNullParameter(itemModel, "<this>");
        FolderModel parentFolder = itemModel.getParentFolder();
        if (parentFolder != null && (itemId = parentFolder.getItemId()) != null) {
            return itemId;
        }
        if (itemModel.isRooted()) {
            return ItemId.INSTANCE.getROOT_ITEM_ID();
        }
        return null;
    }

    public static final FileModel fileModel(ItemModel itemModel) {
        Intrinsics.checkNotNullParameter(itemModel, "<this>");
        if (itemModel instanceof FileModel) {
            return (FileModel) itemModel;
        }
        if (itemModel instanceof RecentFileModel) {
            return RecentFileModelMapper.INSTANCE.toFileModel((RecentFileModel) itemModel);
        }
        return null;
    }

    public static final ItemType type(ItemModel itemModel) {
        if (itemModel instanceof FolderModel) {
            return ItemType.FOLDER;
        }
        if (itemModel instanceof FileModel) {
            return ItemType.FILE;
        }
        if (itemModel instanceof WebLinkModel) {
            return ItemType.WEBLINK;
        }
        if (itemModel instanceof RecentFileModel) {
            return ItemType.FILE;
        }
        return null;
    }

    public static final ItemId.Remote toItemIdRemoteId(ItemModel itemModel) {
        Intrinsics.checkNotNullParameter(itemModel, "<this>");
        ItemId.Remote remoteRemoteIdOrNull = itemModel.remoteIdOrNull();
        if (remoteRemoteIdOrNull != null) {
            return remoteRemoteIdOrNull;
        }
        BoxLogUtils.e(ExtensionsKt.getTAG(itemModel), "remoteId() called on local item " + itemModel.getItemId() + ". This is invalid operation. Returning invalid remote id.");
        if (itemModel instanceof FolderModel) {
            return new ItemId.Remote(((FolderModel) itemModel).getItemId().toString(), ItemType.FOLDER);
        }
        if ((itemModel instanceof FileModel) || (itemModel instanceof RecentFileModel)) {
            return new ItemId.Remote(itemModel.getItemId().toString(), ItemType.FILE);
        }
        return new ItemId.Remote(itemModel.getItemId().toString(), ItemType.WEBLINK);
    }

    public static final boolean isViewOnly(ItemModel itemModel) {
        Intrinsics.checkNotNullParameter(itemModel, "<this>");
        PermissionsModel permissions = itemModel.getPermissions();
        if (permissions != null) {
            return (!permissions.getCanPreview() || permissions.getCanDownload() || permissions.getCanUpload() || permissions.getCanRename() || permissions.getCanDelete() || permissions.getCanShare() || permissions.getCanInviteCollaborators() || permissions.getCanSetShareAccess()) ? false : true;
        }
        return true;
    }

    public static final boolean isInFavorites(ItemModel itemModel) {
        Intrinsics.checkNotNullParameter(itemModel, "<this>");
        List<CollectionModel> collections = itemModel.getCollections();
        if (collections != null) {
            List<CollectionModel> list = collections;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (((CollectionModel) it.next()).getType() == CollectionType.FAVORITES) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
