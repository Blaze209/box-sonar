package com.box.android.data.api.models.items;

import com.box.android.data.api.models.PathCollectionDTO;
import com.box.android.data.api.models.PermissionsDTO;
import com.box.android.data.api.models.SharedLinkDTO;
import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.data.api.models.collections.CollectionDTO;
import com.box.android.data.api.models.items.mini.FolderMiniDTO;
import com.box.android.data.api.models.items.mini.IItemMiniDTO;
import com.box.android.domain.models.CollaborationRole;
import com.box.android.domain.models.SharedLinkModel;
import com.box.android.domain.models.item.ItemStatus;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.box.androidsdk.content.models.BoxItem;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: IItemDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u0004\u0018\u00010!X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u0004\u0018\u00010%X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u001a\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010)X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010,R\u001a\u0010/\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010)X¦\u0004¢\u0006\u0006\u001a\u0004\b1\u0010,R\u0014\u00102\u001a\u0004\u0018\u000103X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00106\u001a\u0004\u0018\u000107X¦\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u001a\u0010:\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010)X¦\u0004¢\u0006\u0006\u001a\u0004\b<\u0010,R\u0014\u0010=\u001a\u0004\u0018\u00010;X¦\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0014\u0010@\u001a\u0004\u0018\u000107X¦\u0004¢\u0006\u0006\u001a\u0004\b@\u00109¨\u0006AÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/models/items/IItemDTO;", "Lcom/box/android/data/api/models/items/mini/IItemMiniDTO;", "createdAt", "", "getCreatedAt", "()Ljava/lang/String;", "modifiedAt", "getModifiedAt", "contentCreatedAt", "getContentCreatedAt", "contentModifiedAt", "getContentModifiedAt", "description", "getDescription", "pathCollection", "Lcom/box/android/data/api/models/PathCollectionDTO;", "getPathCollection", "()Lcom/box/android/data/api/models/PathCollectionDTO;", "modifiedBy", "Lcom/box/android/data/api/models/UserMiniDTO;", "getModifiedBy", "()Lcom/box/android/data/api/models/UserMiniDTO;", "ownedBy", "getOwnedBy", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "Lcom/box/android/data/api/models/SharedLinkDTO;", "getSharedLink", "()Lcom/box/android/data/api/models/SharedLinkDTO;", "parent", "Lcom/box/android/data/api/models/items/mini/FolderMiniDTO;", "getParent", "()Lcom/box/android/data/api/models/items/mini/FolderMiniDTO;", "itemStatus", "Lcom/box/android/domain/models/item/ItemStatus;", "getItemStatus", "()Lcom/box/android/domain/models/item/ItemStatus;", "permissions", "Lcom/box/android/data/api/models/PermissionsDTO;", "getPermissions", "()Lcom/box/android/data/api/models/PermissionsDTO;", "allowedSharedLinkAccessLevels", "", "Lcom/box/android/domain/models/SharedLinkModel$Access;", "getAllowedSharedLinkAccessLevels", "()Ljava/util/List;", "tags", "getTags", BoxItem.FIELD_COLLECTIONS, "Lcom/box/android/data/api/models/collections/CollectionDTO;", "getCollections", "size", "", "getSize", "()Ljava/lang/Long;", "hasCollaborations", "", "getHasCollaborations", "()Ljava/lang/Boolean;", "allowedInviteeRoles", "Lcom/box/android/domain/models/CollaborationRole;", "getAllowedInviteeRoles", "defaultInviteeRole", "getDefaultInviteeRole", "()Lcom/box/android/domain/models/CollaborationRole;", "isExternallyOwned", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IItemDTO extends IItemMiniDTO {
    List<CollaborationRole> getAllowedInviteeRoles();

    List<SharedLinkModel.Access> getAllowedSharedLinkAccessLevels();

    List<CollectionDTO> getCollections();

    String getContentCreatedAt();

    String getContentModifiedAt();

    String getCreatedAt();

    CollaborationRole getDefaultInviteeRole();

    String getDescription();

    Boolean getHasCollaborations();

    ItemStatus getItemStatus();

    String getModifiedAt();

    UserMiniDTO getModifiedBy();

    UserMiniDTO getOwnedBy();

    FolderMiniDTO getParent();

    PathCollectionDTO getPathCollection();

    PermissionsDTO getPermissions();

    SharedLinkDTO getSharedLink();

    Long getSize();

    List<String> getTags();

    Boolean isExternallyOwned();
}
