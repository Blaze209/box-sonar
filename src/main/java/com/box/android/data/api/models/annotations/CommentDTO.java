package com.box.android.data.api.models.annotations;

import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxComment;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivityDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\u000e\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00000\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\t\u001a\u00020\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f\u0012\b\b\u0001\u0010\r\u001a\u00020\u000e\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\b\b\u0003\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0003\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00000\u0007HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00103\u001a\u00020\nHÆ\u0003J\t\u00104\u001a\u00020\fHÆ\u0003J\t\u00105\u001a\u00020\u000eHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u00107\u001a\u00020\u0011HÆ\u0003J\t\u00108\u001a\u00020\u0013HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u0099\u0001\u0010;\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\u000e\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00000\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\f2\b\b\u0003\u0010\r\u001a\u00020\u000e2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\f2\b\b\u0003\u0010\u0010\u001a\u00020\u00112\b\b\u0003\u0010\u0012\u001a\u00020\u00132\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0001J\u0013\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020\nHÖ\u0001J\t\u0010@\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b-\u0010,¨\u0006A"}, d2 = {"Lcom/box/android/data/api/models/annotations/CommentDTO;", "", "id", "", "type", "message", "replies", "", "taggedMessage", "totalReplies", "", "createdAt", "Ljava/util/Date;", "createdBy", "Lcom/box/android/data/api/models/UserMiniDTO;", "modifiedAt", "status", "Lcom/box/android/data/api/models/annotations/Status;", "permissions", "Lcom/box/android/data/api/models/annotations/FileActivityPermissionsDTO;", "item", "Lcom/box/android/data/api/models/annotations/ReferenceDTO;", "parent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ILjava/util/Date;Lcom/box/android/data/api/models/UserMiniDTO;Ljava/util/Date;Lcom/box/android/data/api/models/annotations/Status;Lcom/box/android/data/api/models/annotations/FileActivityPermissionsDTO;Lcom/box/android/data/api/models/annotations/ReferenceDTO;Lcom/box/android/data/api/models/annotations/ReferenceDTO;)V", "getId", "()Ljava/lang/String;", "getType", "getMessage", "getReplies", "()Ljava/util/List;", "getTaggedMessage", "getTotalReplies", "()I", "getCreatedAt", "()Ljava/util/Date;", "getCreatedBy", "()Lcom/box/android/data/api/models/UserMiniDTO;", "getModifiedAt", "getStatus", "()Lcom/box/android/data/api/models/annotations/Status;", "getPermissions", "()Lcom/box/android/data/api/models/annotations/FileActivityPermissionsDTO;", "getItem", "()Lcom/box/android/data/api/models/annotations/ReferenceDTO;", "getParent", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CommentDTO {
    private final Date createdAt;
    private final UserMiniDTO createdBy;
    private final String id;
    private final ReferenceDTO item;
    private final String message;
    private final Date modifiedAt;
    private final ReferenceDTO parent;
    private final FileActivityPermissionsDTO permissions;
    private final List<CommentDTO> replies;
    private final Status status;
    private final String taggedMessage;
    private final int totalReplies;
    private final String type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommentDTO copy$default(CommentDTO commentDTO, String str, String str2, String str3, List list, String str4, int i, Date date, UserMiniDTO userMiniDTO, Date date2, Status status, FileActivityPermissionsDTO fileActivityPermissionsDTO, ReferenceDTO referenceDTO, ReferenceDTO referenceDTO2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = commentDTO.id;
        }
        return commentDTO.copy(str, (i2 & 2) != 0 ? commentDTO.type : str2, (i2 & 4) != 0 ? commentDTO.message : str3, (i2 & 8) != 0 ? commentDTO.replies : list, (i2 & 16) != 0 ? commentDTO.taggedMessage : str4, (i2 & 32) != 0 ? commentDTO.totalReplies : i, (i2 & 64) != 0 ? commentDTO.createdAt : date, (i2 & 128) != 0 ? commentDTO.createdBy : userMiniDTO, (i2 & 256) != 0 ? commentDTO.modifiedAt : date2, (i2 & 512) != 0 ? commentDTO.status : status, (i2 & 1024) != 0 ? commentDTO.permissions : fileActivityPermissionsDTO, (i2 & 2048) != 0 ? commentDTO.item : referenceDTO, (i2 & 4096) != 0 ? commentDTO.parent : referenceDTO2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Status getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final FileActivityPermissionsDTO getPermissions() {
        return this.permissions;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final ReferenceDTO getItem() {
        return this.item;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final ReferenceDTO getParent() {
        return this.parent;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final List<CommentDTO> component4() {
        return this.replies;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTaggedMessage() {
        return this.taggedMessage;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getTotalReplies() {
        return this.totalReplies;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Date getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final UserMiniDTO getCreatedBy() {
        return this.createdBy;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Date getModifiedAt() {
        return this.modifiedAt;
    }

    public final CommentDTO copy(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "message") String message, @Json(name = "replies") List<CommentDTO> replies, @Json(name = BoxComment.FIELD_TAGGED_MESSAGE) String taggedMessage, @Json(name = "total_reply_count") int totalReplies, @Json(name = "created_at") Date createdAt, @Json(name = "created_by") UserMiniDTO createdBy, @Json(name = "modified_at") Date modifiedAt, @Json(name = "status") Status status, @Json(name = "permissions") FileActivityPermissionsDTO permissions, @Json(name = "item") ReferenceDTO item, @Json(name = "parent") ReferenceDTO parent) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(replies, "replies");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(createdBy, "createdBy");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        return new CommentDTO(id, type, message, replies, taggedMessage, totalReplies, createdAt, createdBy, modifiedAt, status, permissions, item, parent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommentDTO)) {
            return false;
        }
        CommentDTO commentDTO = (CommentDTO) other;
        return Intrinsics.areEqual(this.id, commentDTO.id) && Intrinsics.areEqual(this.type, commentDTO.type) && Intrinsics.areEqual(this.message, commentDTO.message) && Intrinsics.areEqual(this.replies, commentDTO.replies) && Intrinsics.areEqual(this.taggedMessage, commentDTO.taggedMessage) && this.totalReplies == commentDTO.totalReplies && Intrinsics.areEqual(this.createdAt, commentDTO.createdAt) && Intrinsics.areEqual(this.createdBy, commentDTO.createdBy) && Intrinsics.areEqual(this.modifiedAt, commentDTO.modifiedAt) && this.status == commentDTO.status && Intrinsics.areEqual(this.permissions, commentDTO.permissions) && Intrinsics.areEqual(this.item, commentDTO.item) && Intrinsics.areEqual(this.parent, commentDTO.parent);
    }

    public int hashCode() {
        int iHashCode = ((((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.message.hashCode()) * 31) + this.replies.hashCode()) * 31;
        String str = this.taggedMessage;
        int iHashCode2 = (((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.totalReplies)) * 31) + this.createdAt.hashCode()) * 31) + this.createdBy.hashCode()) * 31;
        Date date = this.modifiedAt;
        int iHashCode3 = (((((iHashCode2 + (date == null ? 0 : date.hashCode())) * 31) + this.status.hashCode()) * 31) + this.permissions.hashCode()) * 31;
        ReferenceDTO referenceDTO = this.item;
        int iHashCode4 = (iHashCode3 + (referenceDTO == null ? 0 : referenceDTO.hashCode())) * 31;
        ReferenceDTO referenceDTO2 = this.parent;
        return iHashCode4 + (referenceDTO2 != null ? referenceDTO2.hashCode() : 0);
    }

    public String toString() {
        return "CommentDTO(id=" + this.id + ", type=" + this.type + ", message=" + this.message + ", replies=" + this.replies + ", taggedMessage=" + this.taggedMessage + ", totalReplies=" + this.totalReplies + ", createdAt=" + this.createdAt + ", createdBy=" + this.createdBy + ", modifiedAt=" + this.modifiedAt + ", status=" + this.status + ", permissions=" + this.permissions + ", item=" + this.item + ", parent=" + this.parent + ")";
    }

    public CommentDTO(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "message") String message, @Json(name = "replies") List<CommentDTO> replies, @Json(name = BoxComment.FIELD_TAGGED_MESSAGE) String str, @Json(name = "total_reply_count") int i, @Json(name = "created_at") Date createdAt, @Json(name = "created_by") UserMiniDTO createdBy, @Json(name = "modified_at") Date date, @Json(name = "status") Status status, @Json(name = "permissions") FileActivityPermissionsDTO permissions, @Json(name = "item") ReferenceDTO referenceDTO, @Json(name = "parent") ReferenceDTO referenceDTO2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(replies, "replies");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(createdBy, "createdBy");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        this.id = id;
        this.type = type;
        this.message = message;
        this.replies = replies;
        this.taggedMessage = str;
        this.totalReplies = i;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.modifiedAt = date;
        this.status = status;
        this.permissions = permissions;
        this.item = referenceDTO;
        this.parent = referenceDTO2;
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

    public /* synthetic */ CommentDTO(String str, String str2, String str3, List list, String str4, int i, Date date, UserMiniDTO userMiniDTO, Date date2, Status status, FileActivityPermissionsDTO fileActivityPermissionsDTO, ReferenceDTO referenceDTO, ReferenceDTO referenceDTO2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i2 & 8) != 0 ? CollectionsKt.emptyList() : list, str4, (i2 & 32) != 0 ? 0 : i, date, userMiniDTO, date2, (i2 & 512) != 0 ? Status.OPEN : status, (i2 & 1024) != 0 ? new FileActivityPermissionsDTO(false, false, false, false, false, 31, null) : fileActivityPermissionsDTO, referenceDTO, referenceDTO2);
    }

    public final List<CommentDTO> getReplies() {
        return this.replies;
    }

    public final String getTaggedMessage() {
        return this.taggedMessage;
    }

    public final int getTotalReplies() {
        return this.totalReplies;
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

    public final Status getStatus() {
        return this.status;
    }

    public final FileActivityPermissionsDTO getPermissions() {
        return this.permissions;
    }

    public final ReferenceDTO getItem() {
        return this.item;
    }

    public final ReferenceDTO getParent() {
        return this.parent;
    }
}
