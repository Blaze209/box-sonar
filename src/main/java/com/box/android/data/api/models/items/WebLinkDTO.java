package com.box.android.data.api.models.items;

import com.box.android.data.api.models.PathCollectionDTO;
import com.box.android.data.api.models.PermissionsDTO;
import com.box.android.data.api.models.SharedLinkDTO;
import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.data.api.models.collections.CollectionDTO;
import com.box.android.data.api.models.items.mini.FolderMiniDTO;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.CollaborationRole;
import com.box.android.domain.models.SharedLinkModel;
import com.box.android.domain.models.item.ItemStatus;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxItem;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebLinkDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bL\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BÓ\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0010\b\u0003\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018\u0012\u0010\b\u0003\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018\u0012\u0010\b\u0003\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0018\u0012\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\u0010\b\u0003\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0018\u0012\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\"\u0012\n\b\u0003\u0010$\u001a\u0004\u0018\u00010 \u0012\n\b\u0003\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0003\u0010'\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0003\u0010(\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b)\u0010*J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0011\u0010d\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018HÆ\u0003J\u0011\u0010e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018HÆ\u0003J\u0011\u0010f\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0018HÆ\u0003J\u0010\u0010g\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0002\u0010IJ\u0010\u0010h\u001a\u0004\u0018\u00010 HÆ\u0003¢\u0006\u0002\u0010LJ\u0011\u0010i\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0018HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\"HÆ\u0003J\u0010\u0010k\u001a\u0004\u0018\u00010 HÆ\u0003¢\u0006\u0002\u0010LJ\u000b\u0010l\u001a\u0004\u0018\u00010&HÆ\u0003J\u0010\u0010m\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0002\u0010IJ\u000b\u0010n\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÚ\u0002\u0010o\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0010\b\u0003\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0010\b\u0003\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00182\u0010\b\u0003\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00182\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010 2\u0010\b\u0003\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u00182\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\"2\n\b\u0003\u0010$\u001a\u0004\u0018\u00010 2\n\b\u0003\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0003\u0010'\u001a\u0004\u0018\u00010\u001e2\n\b\u0003\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010pJ\u0013\u0010q\u001a\u00020 2\b\u0010r\u001a\u0004\u0018\u00010sHÖ\u0003J\t\u0010t\u001a\u00020uHÖ\u0001J\t\u0010v\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010,R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010,\"\u0004\b3\u0010.R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010,R\u0016\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010,R\u0016\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010,R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010,R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010,R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010@R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u001c\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u001c\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010ER\u001c\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010ER\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0096\u0004¢\u0006\n\n\u0002\u0010J\u001a\u0004\bH\u0010IR\u0018\u0010\u001f\u001a\u0004\u0018\u00010 X\u0096\u0004¢\u0006\n\n\u0002\u0010M\u001a\u0004\bK\u0010LR\u001c\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010ER\u0016\u0010#\u001a\u0004\u0018\u00010\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0018\u0010$\u001a\u0004\u0018\u00010 X\u0096\u0004¢\u0006\n\n\u0002\u0010M\u001a\u0004\b$\u0010LR\u0016\u0010%\u001a\u0004\u0018\u00010&X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0018\u0010'\u001a\u0004\u0018\u00010\u001eX\u0096\u0004¢\u0006\n\n\u0002\u0010J\u001a\u0004\bS\u0010IR\u0016\u0010(\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010,¨\u0006w"}, d2 = {"Lcom/box/android/data/api/models/items/WebLinkDTO;", "Lcom/box/android/data/api/models/items/IWebLinkDTO;", "id", "", "type", "name", BoxItem.FIELD_ETAG, "parent", "Lcom/box/android/data/api/models/items/mini/FolderMiniDTO;", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "Lcom/box/android/data/api/models/SharedLinkDTO;", "createdAt", "modifiedAt", "contentCreatedAt", "contentModifiedAt", "description", "pathCollection", "Lcom/box/android/data/api/models/PathCollectionDTO;", "modifiedBy", "Lcom/box/android/data/api/models/UserMiniDTO;", "ownedBy", "permissions", "Lcom/box/android/data/api/models/PermissionsDTO;", "allowedSharedLinkAccessLevels", "", "Lcom/box/android/domain/models/SharedLinkModel$Access;", "tags", BoxItem.FIELD_COLLECTIONS, "Lcom/box/android/data/api/models/collections/CollectionDTO;", "size", "", "hasCollaborations", "", "allowedInviteeRoles", "Lcom/box/android/domain/models/CollaborationRole;", "defaultInviteeRole", "isExternallyOwned", "itemStatus", "Lcom/box/android/domain/models/item/ItemStatus;", "commentCount", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/items/mini/FolderMiniDTO;Lcom/box/android/data/api/models/SharedLinkDTO;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/PathCollectionDTO;Lcom/box/android/data/api/models/UserMiniDTO;Lcom/box/android/data/api/models/UserMiniDTO;Lcom/box/android/data/api/models/PermissionsDTO;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/List;Lcom/box/android/domain/models/CollaborationRole;Ljava/lang/Boolean;Lcom/box/android/domain/models/item/ItemStatus;Ljava/lang/Long;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getType", "getName", "setName", "getEtag", "setEtag", "getParent", "()Lcom/box/android/data/api/models/items/mini/FolderMiniDTO;", "getSharedLink", "()Lcom/box/android/data/api/models/SharedLinkDTO;", "getCreatedAt", "getModifiedAt", "getContentCreatedAt", "getContentModifiedAt", "getDescription", "getPathCollection", "()Lcom/box/android/data/api/models/PathCollectionDTO;", "getModifiedBy", "()Lcom/box/android/data/api/models/UserMiniDTO;", "getOwnedBy", "getPermissions", "()Lcom/box/android/data/api/models/PermissionsDTO;", "getAllowedSharedLinkAccessLevels", "()Ljava/util/List;", "getTags", "getCollections", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getHasCollaborations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAllowedInviteeRoles", "getDefaultInviteeRole", "()Lcom/box/android/domain/models/CollaborationRole;", "getItemStatus", "()Lcom/box/android/domain/models/item/ItemStatus;", "getCommentCount", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/items/mini/FolderMiniDTO;Lcom/box/android/data/api/models/SharedLinkDTO;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/PathCollectionDTO;Lcom/box/android/data/api/models/UserMiniDTO;Lcom/box/android/data/api/models/UserMiniDTO;Lcom/box/android/data/api/models/PermissionsDTO;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/List;Lcom/box/android/domain/models/CollaborationRole;Ljava/lang/Boolean;Lcom/box/android/domain/models/item/ItemStatus;Ljava/lang/Long;Ljava/lang/String;)Lcom/box/android/data/api/models/items/WebLinkDTO;", "equals", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class WebLinkDTO implements IWebLinkDTO {
    private final List<CollaborationRole> allowedInviteeRoles;
    private final List<SharedLinkModel.Access> allowedSharedLinkAccessLevels;
    private final List<CollectionDTO> collections;
    private final Long commentCount;
    private final String contentCreatedAt;
    private final String contentModifiedAt;
    private final String createdAt;
    private final CollaborationRole defaultInviteeRole;
    private final String description;
    private String etag;
    private final Boolean hasCollaborations;
    private String id;
    private final Boolean isExternallyOwned;
    private final ItemStatus itemStatus;
    private final String modifiedAt;
    private final UserMiniDTO modifiedBy;
    private String name;
    private final UserMiniDTO ownedBy;
    private final FolderMiniDTO parent;
    private final PathCollectionDTO pathCollection;
    private final PermissionsDTO permissions;
    private final SharedLinkDTO sharedLink;
    private final Long size;
    private final List<String> tags;
    private final String type;
    private final String url;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WebLinkDTO copy$default(WebLinkDTO webLinkDTO, String str, String str2, String str3, String str4, FolderMiniDTO folderMiniDTO, SharedLinkDTO sharedLinkDTO, String str5, String str6, String str7, String str8, String str9, PathCollectionDTO pathCollectionDTO, UserMiniDTO userMiniDTO, UserMiniDTO userMiniDTO2, PermissionsDTO permissionsDTO, List list, List list2, List list3, Long l, Boolean bool, List list4, CollaborationRole collaborationRole, Boolean bool2, ItemStatus itemStatus, Long l2, String str10, int i, Object obj) {
        String str11;
        Long l3;
        String str12 = (i & 1) != 0 ? webLinkDTO.id : str;
        String str13 = (i & 2) != 0 ? webLinkDTO.type : str2;
        String str14 = (i & 4) != 0 ? webLinkDTO.name : str3;
        String str15 = (i & 8) != 0 ? webLinkDTO.etag : str4;
        FolderMiniDTO folderMiniDTO2 = (i & 16) != 0 ? webLinkDTO.parent : folderMiniDTO;
        SharedLinkDTO sharedLinkDTO2 = (i & 32) != 0 ? webLinkDTO.sharedLink : sharedLinkDTO;
        String str16 = (i & 64) != 0 ? webLinkDTO.createdAt : str5;
        String str17 = (i & 128) != 0 ? webLinkDTO.modifiedAt : str6;
        String str18 = (i & 256) != 0 ? webLinkDTO.contentCreatedAt : str7;
        String str19 = (i & 512) != 0 ? webLinkDTO.contentModifiedAt : str8;
        String str20 = (i & 1024) != 0 ? webLinkDTO.description : str9;
        PathCollectionDTO pathCollectionDTO2 = (i & 2048) != 0 ? webLinkDTO.pathCollection : pathCollectionDTO;
        UserMiniDTO userMiniDTO3 = (i & 4096) != 0 ? webLinkDTO.modifiedBy : userMiniDTO;
        UserMiniDTO userMiniDTO4 = (i & 8192) != 0 ? webLinkDTO.ownedBy : userMiniDTO2;
        String str21 = str12;
        PermissionsDTO permissionsDTO2 = (i & 16384) != 0 ? webLinkDTO.permissions : permissionsDTO;
        List list5 = (i & 32768) != 0 ? webLinkDTO.allowedSharedLinkAccessLevels : list;
        List list6 = (i & 65536) != 0 ? webLinkDTO.tags : list2;
        List list7 = (i & 131072) != 0 ? webLinkDTO.collections : list3;
        Long l4 = (i & 262144) != 0 ? webLinkDTO.size : l;
        Boolean bool3 = (i & 524288) != 0 ? webLinkDTO.hasCollaborations : bool;
        List list8 = (i & 1048576) != 0 ? webLinkDTO.allowedInviteeRoles : list4;
        CollaborationRole collaborationRole2 = (i & 2097152) != 0 ? webLinkDTO.defaultInviteeRole : collaborationRole;
        Boolean bool4 = (i & 4194304) != 0 ? webLinkDTO.isExternallyOwned : bool2;
        ItemStatus itemStatus2 = (i & 8388608) != 0 ? webLinkDTO.itemStatus : itemStatus;
        Long l5 = (i & 16777216) != 0 ? webLinkDTO.commentCount : l2;
        if ((i & 33554432) != 0) {
            l3 = l5;
            str11 = webLinkDTO.url;
        } else {
            str11 = str10;
            l3 = l5;
        }
        return webLinkDTO.copy(str21, str13, str14, str15, folderMiniDTO2, sharedLinkDTO2, str16, str17, str18, str19, str20, pathCollectionDTO2, userMiniDTO3, userMiniDTO4, permissionsDTO2, list5, list6, list7, l4, bool3, list8, collaborationRole2, bool4, itemStatus2, l3, str11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getContentModifiedAt() {
        return this.contentModifiedAt;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final PathCollectionDTO getPathCollection() {
        return this.pathCollection;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final UserMiniDTO getModifiedBy() {
        return this.modifiedBy;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final UserMiniDTO getOwnedBy() {
        return this.ownedBy;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final PermissionsDTO getPermissions() {
        return this.permissions;
    }

    public final List<SharedLinkModel.Access> component16() {
        return this.allowedSharedLinkAccessLevels;
    }

    public final List<String> component17() {
        return this.tags;
    }

    public final List<CollectionDTO> component18() {
        return this.collections;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final Long getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final Boolean getHasCollaborations() {
        return this.hasCollaborations;
    }

    public final List<CollaborationRole> component21() {
        return this.allowedInviteeRoles;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final CollaborationRole getDefaultInviteeRole() {
        return this.defaultInviteeRole;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final Boolean getIsExternallyOwned() {
        return this.isExternallyOwned;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final ItemStatus getItemStatus() {
        return this.itemStatus;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final Long getCommentCount() {
        return this.commentCount;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getEtag() {
        return this.etag;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final FolderMiniDTO getParent() {
        return this.parent;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final SharedLinkDTO getSharedLink() {
        return this.sharedLink;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getModifiedAt() {
        return this.modifiedAt;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getContentCreatedAt() {
        return this.contentCreatedAt;
    }

    public final WebLinkDTO copy(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "name") String name, @Json(name = BoxItem.FIELD_ETAG) String etag, @Json(name = "parent") FolderMiniDTO parent, @Json(name = "shared_link") SharedLinkDTO sharedLink, @Json(name = "created_at") String createdAt, @Json(name = "modified_at") String modifiedAt, @Json(name = "content_created_at") String contentCreatedAt, @Json(name = "content_modified_at") String contentModifiedAt, @Json(name = "description") String description, @Json(name = BoxItem.FIELD_PATH_COLLECTION) PathCollectionDTO pathCollection, @Json(name = "modified_by") UserMiniDTO modifiedBy, @Json(name = BoxItem.FIELD_OWNED_BY) UserMiniDTO ownedBy, @Json(name = "permissions") PermissionsDTO permissions, @Json(name = BoxItem.FIELD_ALLOWED_SHARED_LINK_ACCESS_LEVELS) List<? extends SharedLinkModel.Access> allowedSharedLinkAccessLevels, @Json(name = "tags") List<String> tags, @Json(name = BoxItem.FIELD_COLLECTIONS) List<CollectionDTO> collections, @Json(name = "size") Long size, @Json(name = BoxCollaborationItem.FIELD_HAS_COLLABORATIONS) Boolean hasCollaborations, @Json(name = BoxCollaborationItem.FIELD_ALLOWED_INVITEE_ROLES) List<? extends CollaborationRole> allowedInviteeRoles, @Json(name = BoxCollaborationItem.FIELD_DEFAULT_INVITEE_ROLE) CollaborationRole defaultInviteeRole, @Json(name = BoxCollaborationItem.FIELD_IS_EXTERNALLY_OWNED) Boolean isExternallyOwned, @Json(name = BoxItem.FIELD_ITEM_STATUS) ItemStatus itemStatus, @Json(name = "comment_count") Long commentCount, @Json(name = "url") String url) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        return new WebLinkDTO(id, type, name, etag, parent, sharedLink, createdAt, modifiedAt, contentCreatedAt, contentModifiedAt, description, pathCollection, modifiedBy, ownedBy, permissions, allowedSharedLinkAccessLevels, tags, collections, size, hasCollaborations, allowedInviteeRoles, defaultInviteeRole, isExternallyOwned, itemStatus, commentCount, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebLinkDTO)) {
            return false;
        }
        WebLinkDTO webLinkDTO = (WebLinkDTO) other;
        return Intrinsics.areEqual(this.id, webLinkDTO.id) && Intrinsics.areEqual(this.type, webLinkDTO.type) && Intrinsics.areEqual(this.name, webLinkDTO.name) && Intrinsics.areEqual(this.etag, webLinkDTO.etag) && Intrinsics.areEqual(this.parent, webLinkDTO.parent) && Intrinsics.areEqual(this.sharedLink, webLinkDTO.sharedLink) && Intrinsics.areEqual(this.createdAt, webLinkDTO.createdAt) && Intrinsics.areEqual(this.modifiedAt, webLinkDTO.modifiedAt) && Intrinsics.areEqual(this.contentCreatedAt, webLinkDTO.contentCreatedAt) && Intrinsics.areEqual(this.contentModifiedAt, webLinkDTO.contentModifiedAt) && Intrinsics.areEqual(this.description, webLinkDTO.description) && Intrinsics.areEqual(this.pathCollection, webLinkDTO.pathCollection) && Intrinsics.areEqual(this.modifiedBy, webLinkDTO.modifiedBy) && Intrinsics.areEqual(this.ownedBy, webLinkDTO.ownedBy) && Intrinsics.areEqual(this.permissions, webLinkDTO.permissions) && Intrinsics.areEqual(this.allowedSharedLinkAccessLevels, webLinkDTO.allowedSharedLinkAccessLevels) && Intrinsics.areEqual(this.tags, webLinkDTO.tags) && Intrinsics.areEqual(this.collections, webLinkDTO.collections) && Intrinsics.areEqual(this.size, webLinkDTO.size) && Intrinsics.areEqual(this.hasCollaborations, webLinkDTO.hasCollaborations) && Intrinsics.areEqual(this.allowedInviteeRoles, webLinkDTO.allowedInviteeRoles) && this.defaultInviteeRole == webLinkDTO.defaultInviteeRole && Intrinsics.areEqual(this.isExternallyOwned, webLinkDTO.isExternallyOwned) && this.itemStatus == webLinkDTO.itemStatus && Intrinsics.areEqual(this.commentCount, webLinkDTO.commentCount) && Intrinsics.areEqual(this.url, webLinkDTO.url);
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.etag;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        FolderMiniDTO folderMiniDTO = this.parent;
        int iHashCode4 = (iHashCode3 + (folderMiniDTO == null ? 0 : folderMiniDTO.hashCode())) * 31;
        SharedLinkDTO sharedLinkDTO = this.sharedLink;
        int iHashCode5 = (iHashCode4 + (sharedLinkDTO == null ? 0 : sharedLinkDTO.hashCode())) * 31;
        String str3 = this.createdAt;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.modifiedAt;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.contentCreatedAt;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.contentModifiedAt;
        int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.description;
        int iHashCode10 = (iHashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        PathCollectionDTO pathCollectionDTO = this.pathCollection;
        int iHashCode11 = (iHashCode10 + (pathCollectionDTO == null ? 0 : pathCollectionDTO.hashCode())) * 31;
        UserMiniDTO userMiniDTO = this.modifiedBy;
        int iHashCode12 = (iHashCode11 + (userMiniDTO == null ? 0 : userMiniDTO.hashCode())) * 31;
        UserMiniDTO userMiniDTO2 = this.ownedBy;
        int iHashCode13 = (iHashCode12 + (userMiniDTO2 == null ? 0 : userMiniDTO2.hashCode())) * 31;
        PermissionsDTO permissionsDTO = this.permissions;
        int iHashCode14 = (iHashCode13 + (permissionsDTO == null ? 0 : permissionsDTO.hashCode())) * 31;
        List<SharedLinkModel.Access> list = this.allowedSharedLinkAccessLevels;
        int iHashCode15 = (iHashCode14 + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.tags;
        int iHashCode16 = (iHashCode15 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<CollectionDTO> list3 = this.collections;
        int iHashCode17 = (iHashCode16 + (list3 == null ? 0 : list3.hashCode())) * 31;
        Long l = this.size;
        int iHashCode18 = (iHashCode17 + (l == null ? 0 : l.hashCode())) * 31;
        Boolean bool = this.hasCollaborations;
        int iHashCode19 = (iHashCode18 + (bool == null ? 0 : bool.hashCode())) * 31;
        List<CollaborationRole> list4 = this.allowedInviteeRoles;
        int iHashCode20 = (iHashCode19 + (list4 == null ? 0 : list4.hashCode())) * 31;
        CollaborationRole collaborationRole = this.defaultInviteeRole;
        int iHashCode21 = (iHashCode20 + (collaborationRole == null ? 0 : collaborationRole.hashCode())) * 31;
        Boolean bool2 = this.isExternallyOwned;
        int iHashCode22 = (iHashCode21 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        ItemStatus itemStatus = this.itemStatus;
        int iHashCode23 = (iHashCode22 + (itemStatus == null ? 0 : itemStatus.hashCode())) * 31;
        Long l2 = this.commentCount;
        int iHashCode24 = (iHashCode23 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str8 = this.url;
        return iHashCode24 + (str8 != null ? str8.hashCode() : 0);
    }

    public String toString() {
        return "WebLinkDTO(id=" + this.id + ", type=" + this.type + ", name=" + this.name + ", etag=" + this.etag + ", parent=" + this.parent + ", sharedLink=" + this.sharedLink + ", createdAt=" + this.createdAt + ", modifiedAt=" + this.modifiedAt + ", contentCreatedAt=" + this.contentCreatedAt + ", contentModifiedAt=" + this.contentModifiedAt + ", description=" + this.description + ", pathCollection=" + this.pathCollection + ", modifiedBy=" + this.modifiedBy + ", ownedBy=" + this.ownedBy + ", permissions=" + this.permissions + ", allowedSharedLinkAccessLevels=" + this.allowedSharedLinkAccessLevels + ", tags=" + this.tags + ", collections=" + this.collections + ", size=" + this.size + ", hasCollaborations=" + this.hasCollaborations + ", allowedInviteeRoles=" + this.allowedInviteeRoles + ", defaultInviteeRole=" + this.defaultInviteeRole + ", isExternallyOwned=" + this.isExternallyOwned + ", itemStatus=" + this.itemStatus + ", commentCount=" + this.commentCount + ", url=" + this.url + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WebLinkDTO(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "name") String str, @Json(name = BoxItem.FIELD_ETAG) String str2, @Json(name = "parent") FolderMiniDTO folderMiniDTO, @Json(name = "shared_link") SharedLinkDTO sharedLinkDTO, @Json(name = "created_at") String str3, @Json(name = "modified_at") String str4, @Json(name = "content_created_at") String str5, @Json(name = "content_modified_at") String str6, @Json(name = "description") String str7, @Json(name = BoxItem.FIELD_PATH_COLLECTION) PathCollectionDTO pathCollectionDTO, @Json(name = "modified_by") UserMiniDTO userMiniDTO, @Json(name = BoxItem.FIELD_OWNED_BY) UserMiniDTO userMiniDTO2, @Json(name = "permissions") PermissionsDTO permissionsDTO, @Json(name = BoxItem.FIELD_ALLOWED_SHARED_LINK_ACCESS_LEVELS) List<? extends SharedLinkModel.Access> list, @Json(name = "tags") List<String> list2, @Json(name = BoxItem.FIELD_COLLECTIONS) List<CollectionDTO> list3, @Json(name = "size") Long l, @Json(name = BoxCollaborationItem.FIELD_HAS_COLLABORATIONS) Boolean bool, @Json(name = BoxCollaborationItem.FIELD_ALLOWED_INVITEE_ROLES) List<? extends CollaborationRole> list4, @Json(name = BoxCollaborationItem.FIELD_DEFAULT_INVITEE_ROLE) CollaborationRole collaborationRole, @Json(name = BoxCollaborationItem.FIELD_IS_EXTERNALLY_OWNED) Boolean bool2, @Json(name = BoxItem.FIELD_ITEM_STATUS) ItemStatus itemStatus, @Json(name = "comment_count") Long l2, @Json(name = "url") String str8) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.type = type;
        this.name = str;
        this.etag = str2;
        this.parent = folderMiniDTO;
        this.sharedLink = sharedLinkDTO;
        this.createdAt = str3;
        this.modifiedAt = str4;
        this.contentCreatedAt = str5;
        this.contentModifiedAt = str6;
        this.description = str7;
        this.pathCollection = pathCollectionDTO;
        this.modifiedBy = userMiniDTO;
        this.ownedBy = userMiniDTO2;
        this.permissions = permissionsDTO;
        this.allowedSharedLinkAccessLevels = list;
        this.tags = list2;
        this.collections = list3;
        this.size = l;
        this.hasCollaborations = bool;
        this.allowedInviteeRoles = list4;
        this.defaultInviteeRole = collaborationRole;
        this.isExternallyOwned = bool2;
        this.itemStatus = itemStatus;
        this.commentCount = l2;
        this.url = str8;
    }

    public /* synthetic */ WebLinkDTO(String str, String str2, String str3, String str4, FolderMiniDTO folderMiniDTO, SharedLinkDTO sharedLinkDTO, String str5, String str6, String str7, String str8, String str9, PathCollectionDTO pathCollectionDTO, UserMiniDTO userMiniDTO, UserMiniDTO userMiniDTO2, PermissionsDTO permissionsDTO, List list, List list2, List list3, Long l, Boolean bool, List list4, CollaborationRole collaborationRole, Boolean bool2, ItemStatus itemStatus, Long l2, String str10, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : folderMiniDTO, (i & 32) != 0 ? null : sharedLinkDTO, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? null : str8, (i & 1024) != 0 ? null : str9, (i & 2048) != 0 ? null : pathCollectionDTO, (i & 4096) != 0 ? null : userMiniDTO, (i & 8192) != 0 ? null : userMiniDTO2, (i & 16384) != 0 ? null : permissionsDTO, (32768 & i) != 0 ? null : list, (65536 & i) != 0 ? null : list2, (131072 & i) != 0 ? null : list3, (262144 & i) != 0 ? null : l, (524288 & i) != 0 ? null : bool, (1048576 & i) != 0 ? null : list4, (2097152 & i) != 0 ? null : collaborationRole, (4194304 & i) != 0 ? null : bool2, (8388608 & i) != 0 ? null : itemStatus, (16777216 & i) != 0 ? null : l2, (i & 33554432) != 0 ? null : str10);
    }

    @Override // com.box.android.data.api.models.items.mini.IItemMiniDTO
    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    @Override // com.box.android.data.api.models.items.mini.IItemMiniDTO
    public String getType() {
        return this.type;
    }

    @Override // com.box.android.data.api.models.items.mini.IItemMiniDTO
    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    @Override // com.box.android.data.api.models.items.mini.IItemMiniDTO
    public String getEtag() {
        return this.etag;
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public FolderMiniDTO getParent() {
        return this.parent;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public SharedLinkDTO getSharedLink() {
        return this.sharedLink;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public String getCreatedAt() {
        return this.createdAt;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public String getModifiedAt() {
        return this.modifiedAt;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public String getContentCreatedAt() {
        return this.contentCreatedAt;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public String getContentModifiedAt() {
        return this.contentModifiedAt;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public String getDescription() {
        return this.description;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public PathCollectionDTO getPathCollection() {
        return this.pathCollection;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public UserMiniDTO getModifiedBy() {
        return this.modifiedBy;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public UserMiniDTO getOwnedBy() {
        return this.ownedBy;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public PermissionsDTO getPermissions() {
        return this.permissions;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public List<SharedLinkModel.Access> getAllowedSharedLinkAccessLevels() {
        return this.allowedSharedLinkAccessLevels;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public List<String> getTags() {
        return this.tags;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public List<CollectionDTO> getCollections() {
        return this.collections;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public Long getSize() {
        return this.size;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public Boolean getHasCollaborations() {
        return this.hasCollaborations;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public List<CollaborationRole> getAllowedInviteeRoles() {
        return this.allowedInviteeRoles;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public CollaborationRole getDefaultInviteeRole() {
        return this.defaultInviteeRole;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public Boolean isExternallyOwned() {
        return this.isExternallyOwned;
    }

    @Override // com.box.android.data.api.models.items.IItemDTO
    public ItemStatus getItemStatus() {
        return this.itemStatus;
    }

    @Override // com.box.android.data.api.models.items.IWebLinkDTO
    public Long getCommentCount() {
        return this.commentCount;
    }

    @Override // com.box.android.data.api.models.items.mini.IWebLinkMiniDTO
    public String getUrl() {
        return this.url;
    }
}
