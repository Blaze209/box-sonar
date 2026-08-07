package com.box.android.domain.models.item;

import android.os.Parcelable;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.DomainModel;
import com.box.android.domain.models.ItemId;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.box.androidsdk.content.models.BoxItem;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001AB\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010=\u001a\u0004\u0018\u00010>J\b\u0010?\u001a\u0004\u0018\u00010\nJ\u0006\u0010@\u001a\u00020\nR\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u0012\u0010\u0013\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0010R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u001aX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001aX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0014\u0010\u001f\u001a\u0004\u0018\u00010 X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u0004\u0018\u00010 X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u0014\u0010%\u001a\u0004\u0018\u00010 X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\"R\u0014\u0010'\u001a\u0004\u0018\u00010 X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\"R\u0014\u0010)\u001a\u0004\u0018\u00010*X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u0004\u0018\u00010.X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u001a\u00101\u001a\n\u0012\u0004\u0012\u000203\u0018\u000102X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u001a\u00106\u001a\n\u0012\u0004\u0012\u000207\u0018\u000102X¦\u0004¢\u0006\u0006\u001a\u0004\b8\u00105R\u0014\u00109\u001a\u0004\u0018\u00010:X¦\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<\u0082\u0001\u0005B\u0015CDE¨\u0006F"}, d2 = {"Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainModel;", "Landroid/os/Parcelable;", "<init>", "()V", "itemId", "Lcom/box/android/domain/models/ItemId;", "getItemId", "()Lcom/box/android/domain/models/ItemId;", "name", "", "getName", "()Ljava/lang/String;", "hasCollaborations", "", "getHasCollaborations", "()Z", "description", "getDescription", "isExternallyOwned", "parentFolder", "Lcom/box/android/domain/models/item/FolderModel;", "getParentFolder", "()Lcom/box/android/domain/models/item/FolderModel;", "isRooted", "owner", "Lcom/box/android/domain/models/item/UserModel;", "getOwner", "()Lcom/box/android/domain/models/item/UserModel;", "updatedBy", "getUpdatedBy", "createdDate", "Ljava/util/Date;", "getCreatedDate", "()Ljava/util/Date;", "contentCreatedDate", "getContentCreatedDate", "modifiedDate", "getModifiedDate", "contentModifiedDate", "getContentModifiedDate", "size", "", "getSize", "()Ljava/lang/Long;", "permissions", "Lcom/box/android/domain/models/item/PermissionsModel;", "getPermissions", "()Lcom/box/android/domain/models/item/PermissionsModel;", "pathCollection", "", "Lcom/box/android/domain/models/item/PathCollectionEntry;", "getPathCollection", "()Ljava/util/List;", BoxItem.FIELD_COLLECTIONS, "Lcom/box/android/domain/models/CollectionModel;", "getCollections", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "Lcom/box/android/domain/models/item/SharedLinkModel;", "getSharedLink", "()Lcom/box/android/domain/models/item/SharedLinkModel;", "remoteIdOrNull", "Lcom/box/android/domain/models/ItemId$Remote;", "boxIdOrNull", "boxIdOrThrow", "Companion", "Lcom/box/android/domain/models/item/FileModel;", "Lcom/box/android/domain/models/item/RecentFileModel;", "Lcom/box/android/domain/models/item/UnknownItemModel;", "Lcom/box/android/domain/models/item/WebLinkModel;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ItemModel implements DomainModel, Parcelable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ ItemModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract List<CollectionModel> getCollections();

    public abstract Date getContentCreatedDate();

    public abstract Date getContentModifiedDate();

    public abstract Date getCreatedDate();

    public abstract String getDescription();

    public abstract boolean getHasCollaborations();

    public abstract ItemId getItemId();

    public abstract Date getModifiedDate();

    public abstract String getName();

    public abstract UserModel getOwner();

    public abstract FolderModel getParentFolder();

    public abstract List<PathCollectionEntry> getPathCollection();

    public abstract PermissionsModel getPermissions();

    public abstract SharedLinkModel getSharedLink();

    public abstract Long getSize();

    public abstract UserModel getUpdatedBy();

    public abstract boolean isExternallyOwned();

    public abstract boolean isRooted();

    private ItemModel() {
    }

    /* JADX INFO: compiled from: ItemModel.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/box/android/domain/models/item/ItemModel$Companion;", "", "<init>", "()V", "buildApproximateLegacyPathCollection", "", "Lcom/box/android/domain/models/item/PathCollectionEntry;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<PathCollectionEntry> buildApproximateLegacyPathCollection(ItemModel itemModel) {
            FolderModel parentFolder;
            Intrinsics.checkNotNullParameter(itemModel, "itemModel");
            ArrayList arrayList = new ArrayList();
            if (itemModel.isRooted()) {
                arrayList.add(new PathCollectionEntry(new ItemId.Remote("0", ItemType.FOLDER), ""));
            }
            FolderModel parentFolder2 = itemModel.getParentFolder();
            if ((parentFolder2 == null || !parentFolder2.isRoot()) && (parentFolder = itemModel.getParentFolder()) != null) {
                arrayList.add(new PathCollectionEntry(ItemModelKt.toItemIdRemoteId(parentFolder), parentFolder.getName()));
            }
            return arrayList;
        }
    }

    public final ItemId.Remote remoteIdOrNull() {
        ItemId itemId = getItemId();
        if (itemId instanceof ItemId.Remote) {
            return (ItemId.Remote) itemId;
        }
        return null;
    }

    public final String boxIdOrNull() {
        ItemId.Remote remoteRemoteIdOrNull = remoteIdOrNull();
        if (remoteRemoteIdOrNull != null) {
            return remoteRemoteIdOrNull.getBoxId();
        }
        return null;
    }

    public final String boxIdOrThrow() {
        String strBoxIdOrNull = boxIdOrNull();
        if (strBoxIdOrNull != null) {
            return strBoxIdOrNull;
        }
        throw new IllegalArgumentException("ItemModel does not have remote id.");
    }
}
