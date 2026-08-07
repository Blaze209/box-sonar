package com.box.android.data.api.models.comment;

import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.data.api.models.items.mini.ItemIdDTO;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxComment;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommentV2ResponseDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\b\u0012\b\b\u0001\u0010\f\u001a\u00020\r\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\t\u0010'\u001a\u00020\rHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000fHÆ\u0003Jg\u0010)\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\b2\b\b\u0003\u0010\f\u001a\u00020\r2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00060"}, d2 = {"Lcom/box/android/data/api/models/comment/CommentV2ResponseDTO;", "", "id", "", "type", "message", "taggedMessage", "createdAt", "Ljava/util/Date;", "createdBy", "Lcom/box/android/data/api/models/UserMiniDTO;", "modifiedAt", "permissions", "Lcom/box/android/data/api/models/comment/CommentPermissionsDTO;", "item", "Lcom/box/android/data/api/models/items/mini/ItemIdDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Lcom/box/android/data/api/models/UserMiniDTO;Ljava/util/Date;Lcom/box/android/data/api/models/comment/CommentPermissionsDTO;Lcom/box/android/data/api/models/items/mini/ItemIdDTO;)V", "getId", "()Ljava/lang/String;", "getType", "getMessage", "getTaggedMessage", "getCreatedAt", "()Ljava/util/Date;", "getCreatedBy", "()Lcom/box/android/data/api/models/UserMiniDTO;", "getModifiedAt", "getPermissions", "()Lcom/box/android/data/api/models/comment/CommentPermissionsDTO;", "getItem", "()Lcom/box/android/data/api/models/items/mini/ItemIdDTO;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CommentV2ResponseDTO {
    private final Date createdAt;
    private final UserMiniDTO createdBy;
    private final String id;
    private final ItemIdDTO item;
    private final String message;
    private final Date modifiedAt;
    private final CommentPermissionsDTO permissions;
    private final String taggedMessage;
    private final String type;

    public static /* synthetic */ CommentV2ResponseDTO copy$default(CommentV2ResponseDTO commentV2ResponseDTO, String str, String str2, String str3, String str4, Date date, UserMiniDTO userMiniDTO, Date date2, CommentPermissionsDTO commentPermissionsDTO, ItemIdDTO itemIdDTO, int i, Object obj) {
        if ((i & 1) != 0) {
            str = commentV2ResponseDTO.id;
        }
        if ((i & 2) != 0) {
            str2 = commentV2ResponseDTO.type;
        }
        if ((i & 4) != 0) {
            str3 = commentV2ResponseDTO.message;
        }
        if ((i & 8) != 0) {
            str4 = commentV2ResponseDTO.taggedMessage;
        }
        if ((i & 16) != 0) {
            date = commentV2ResponseDTO.createdAt;
        }
        if ((i & 32) != 0) {
            userMiniDTO = commentV2ResponseDTO.createdBy;
        }
        if ((i & 64) != 0) {
            date2 = commentV2ResponseDTO.modifiedAt;
        }
        if ((i & 128) != 0) {
            commentPermissionsDTO = commentV2ResponseDTO.permissions;
        }
        if ((i & 256) != 0) {
            itemIdDTO = commentV2ResponseDTO.item;
        }
        CommentPermissionsDTO commentPermissionsDTO2 = commentPermissionsDTO;
        ItemIdDTO itemIdDTO2 = itemIdDTO;
        UserMiniDTO userMiniDTO2 = userMiniDTO;
        Date date3 = date2;
        Date date4 = date;
        String str5 = str3;
        return commentV2ResponseDTO.copy(str, str2, str5, str4, date4, userMiniDTO2, date3, commentPermissionsDTO2, itemIdDTO2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTaggedMessage() {
        return this.taggedMessage;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Date getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final UserMiniDTO getCreatedBy() {
        return this.createdBy;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Date getModifiedAt() {
        return this.modifiedAt;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final CommentPermissionsDTO getPermissions() {
        return this.permissions;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final ItemIdDTO getItem() {
        return this.item;
    }

    public final CommentV2ResponseDTO copy(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "message") String message, @Json(name = BoxComment.FIELD_TAGGED_MESSAGE) String taggedMessage, @Json(name = "created_at") Date createdAt, @Json(name = "created_by") UserMiniDTO createdBy, @Json(name = "modified_at") Date modifiedAt, @Json(name = "permissions") CommentPermissionsDTO permissions, @Json(name = "item") ItemIdDTO item) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(createdBy, "createdBy");
        Intrinsics.checkNotNullParameter(modifiedAt, "modifiedAt");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        return new CommentV2ResponseDTO(id, type, message, taggedMessage, createdAt, createdBy, modifiedAt, permissions, item);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommentV2ResponseDTO)) {
            return false;
        }
        CommentV2ResponseDTO commentV2ResponseDTO = (CommentV2ResponseDTO) other;
        return Intrinsics.areEqual(this.id, commentV2ResponseDTO.id) && Intrinsics.areEqual(this.type, commentV2ResponseDTO.type) && Intrinsics.areEqual(this.message, commentV2ResponseDTO.message) && Intrinsics.areEqual(this.taggedMessage, commentV2ResponseDTO.taggedMessage) && Intrinsics.areEqual(this.createdAt, commentV2ResponseDTO.createdAt) && Intrinsics.areEqual(this.createdBy, commentV2ResponseDTO.createdBy) && Intrinsics.areEqual(this.modifiedAt, commentV2ResponseDTO.modifiedAt) && Intrinsics.areEqual(this.permissions, commentV2ResponseDTO.permissions) && Intrinsics.areEqual(this.item, commentV2ResponseDTO.item);
    }

    public int hashCode() {
        int iHashCode = ((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.message.hashCode()) * 31;
        String str = this.taggedMessage;
        int iHashCode2 = (((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.createdAt.hashCode()) * 31) + this.createdBy.hashCode()) * 31) + this.modifiedAt.hashCode()) * 31) + this.permissions.hashCode()) * 31;
        ItemIdDTO itemIdDTO = this.item;
        return iHashCode2 + (itemIdDTO != null ? itemIdDTO.hashCode() : 0);
    }

    public String toString() {
        return "CommentV2ResponseDTO(id=" + this.id + ", type=" + this.type + ", message=" + this.message + ", taggedMessage=" + this.taggedMessage + ", createdAt=" + this.createdAt + ", createdBy=" + this.createdBy + ", modifiedAt=" + this.modifiedAt + ", permissions=" + this.permissions + ", item=" + this.item + ")";
    }

    public CommentV2ResponseDTO(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "message") String message, @Json(name = BoxComment.FIELD_TAGGED_MESSAGE) String str, @Json(name = "created_at") Date createdAt, @Json(name = "created_by") UserMiniDTO createdBy, @Json(name = "modified_at") Date modifiedAt, @Json(name = "permissions") CommentPermissionsDTO permissions, @Json(name = "item") ItemIdDTO itemIdDTO) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(createdBy, "createdBy");
        Intrinsics.checkNotNullParameter(modifiedAt, "modifiedAt");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        this.id = id;
        this.type = type;
        this.message = message;
        this.taggedMessage = str;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.modifiedAt = modifiedAt;
        this.permissions = permissions;
        this.item = itemIdDTO;
    }

    public /* synthetic */ CommentV2ResponseDTO(String str, String str2, String str3, String str4, Date date, UserMiniDTO userMiniDTO, Date date2, CommentPermissionsDTO commentPermissionsDTO, ItemIdDTO itemIdDTO, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, date, userMiniDTO, date2, commentPermissionsDTO, (i & 256) != 0 ? null : itemIdDTO);
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getTaggedMessage() {
        return this.taggedMessage;
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final UserMiniDTO getCreatedBy() {
        return this.createdBy;
    }

    public final Date getModifiedAt() {
        return this.modifiedAt;
    }

    public final CommentPermissionsDTO getPermissions() {
        return this.permissions;
    }

    public final ItemIdDTO getItem() {
        return this.item;
    }
}
