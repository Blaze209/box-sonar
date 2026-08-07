package com.box.android.data.api.models.annotations;

import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivityDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\b\u0003\u0010\f\u001a\u00020\r\u0012\b\b\u0003\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0013\u001a\u00020\b\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0001\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0006HÆ\u0003J\t\u00106\u001a\u00020\bHÆ\u0003J\u000f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\t\u00108\u001a\u00020\rHÆ\u0003J\t\u00109\u001a\u00020\u000fHÆ\u0003J\t\u0010:\u001a\u00020\u0011HÆ\u0003J\t\u0010;\u001a\u00020\u0006HÆ\u0003J\t\u0010<\u001a\u00020\bHÆ\u0003J\t\u0010=\u001a\u00020\u0015HÆ\u0003J\t\u0010>\u001a\u00020\u0017HÆ\u0003J\t\u0010?\u001a\u00020\u0019HÆ\u0003J\u0091\u0001\u0010@\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\u000e\b\u0003\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0003\u0010\f\u001a\u00020\r2\b\b\u0003\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u0010\u001a\u00020\u00112\b\b\u0003\u0010\u0012\u001a\u00020\u00062\b\b\u0003\u0010\u0013\u001a\u00020\b2\b\b\u0003\u0010\u0014\u001a\u00020\u00152\b\b\u0003\u0010\u0016\u001a\u00020\u00172\b\b\u0003\u0010\u0018\u001a\u00020\u0019HÆ\u0001J\u0013\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010D\u001a\u00020\rHÖ\u0001J\t\u0010E\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0012\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b+\u0010 R\u0011\u0010\u0013\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\"R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b1\u00102¨\u0006F"}, d2 = {"Lcom/box/android/data/api/models/annotations/AnnotationDTO;", "", "id", "", "type", "createdAt", "Ljava/util/Date;", "createdBy", "Lcom/box/android/data/api/models/UserMiniDTO;", "replies", "", "Lcom/box/android/data/api/models/annotations/CommentDTO;", "totalReplies", "", "description", "Lcom/box/android/data/api/models/annotations/DescriptionDTO;", "fileVersion", "Lcom/box/android/data/api/models/annotations/AnnotationFileVersionDTO;", "modifiedAt", "modifiedBy", "permissions", "Lcom/box/android/data/api/models/annotations/FileActivityPermissionsDTO;", "status", "Lcom/box/android/data/api/models/annotations/Status;", "target", "Lcom/box/android/data/api/models/annotations/TargetDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Lcom/box/android/data/api/models/UserMiniDTO;Ljava/util/List;ILcom/box/android/data/api/models/annotations/DescriptionDTO;Lcom/box/android/data/api/models/annotations/AnnotationFileVersionDTO;Ljava/util/Date;Lcom/box/android/data/api/models/UserMiniDTO;Lcom/box/android/data/api/models/annotations/FileActivityPermissionsDTO;Lcom/box/android/data/api/models/annotations/Status;Lcom/box/android/data/api/models/annotations/TargetDTO;)V", "getId", "()Ljava/lang/String;", "getType", "getCreatedAt", "()Ljava/util/Date;", "getCreatedBy", "()Lcom/box/android/data/api/models/UserMiniDTO;", "getReplies", "()Ljava/util/List;", "getTotalReplies", "()I", "getDescription", "()Lcom/box/android/data/api/models/annotations/DescriptionDTO;", "getFileVersion", "()Lcom/box/android/data/api/models/annotations/AnnotationFileVersionDTO;", "getModifiedAt", "getModifiedBy", "getPermissions", "()Lcom/box/android/data/api/models/annotations/FileActivityPermissionsDTO;", "getStatus", "()Lcom/box/android/data/api/models/annotations/Status;", "getTarget", "()Lcom/box/android/data/api/models/annotations/TargetDTO;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AnnotationDTO {
    private final Date createdAt;
    private final UserMiniDTO createdBy;
    private final DescriptionDTO description;
    private final AnnotationFileVersionDTO fileVersion;
    private final String id;
    private final Date modifiedAt;
    private final UserMiniDTO modifiedBy;
    private final FileActivityPermissionsDTO permissions;
    private final List<CommentDTO> replies;
    private final Status status;
    private final TargetDTO target;
    private final int totalReplies;
    private final String type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnnotationDTO copy$default(AnnotationDTO annotationDTO, String str, String str2, Date date, UserMiniDTO userMiniDTO, List list, int i, DescriptionDTO descriptionDTO, AnnotationFileVersionDTO annotationFileVersionDTO, Date date2, UserMiniDTO userMiniDTO2, FileActivityPermissionsDTO fileActivityPermissionsDTO, Status status, TargetDTO targetDTO, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = annotationDTO.id;
        }
        return annotationDTO.copy(str, (i2 & 2) != 0 ? annotationDTO.type : str2, (i2 & 4) != 0 ? annotationDTO.createdAt : date, (i2 & 8) != 0 ? annotationDTO.createdBy : userMiniDTO, (i2 & 16) != 0 ? annotationDTO.replies : list, (i2 & 32) != 0 ? annotationDTO.totalReplies : i, (i2 & 64) != 0 ? annotationDTO.description : descriptionDTO, (i2 & 128) != 0 ? annotationDTO.fileVersion : annotationFileVersionDTO, (i2 & 256) != 0 ? annotationDTO.modifiedAt : date2, (i2 & 512) != 0 ? annotationDTO.modifiedBy : userMiniDTO2, (i2 & 1024) != 0 ? annotationDTO.permissions : fileActivityPermissionsDTO, (i2 & 2048) != 0 ? annotationDTO.status : status, (i2 & 4096) != 0 ? annotationDTO.target : targetDTO);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final UserMiniDTO getModifiedBy() {
        return this.modifiedBy;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final FileActivityPermissionsDTO getPermissions() {
        return this.permissions;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Status getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final TargetDTO getTarget() {
        return this.target;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Date getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final UserMiniDTO getCreatedBy() {
        return this.createdBy;
    }

    public final List<CommentDTO> component5() {
        return this.replies;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getTotalReplies() {
        return this.totalReplies;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final DescriptionDTO getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final AnnotationFileVersionDTO getFileVersion() {
        return this.fileVersion;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Date getModifiedAt() {
        return this.modifiedAt;
    }

    public final AnnotationDTO copy(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "created_at") Date createdAt, @Json(name = "created_by") UserMiniDTO createdBy, @Json(name = "replies") List<CommentDTO> replies, @Json(name = "total_reply_count") int totalReplies, @Json(name = "description") DescriptionDTO description, @Json(name = "file_version") AnnotationFileVersionDTO fileVersion, @Json(name = "modified_at") Date modifiedAt, @Json(name = "modified_by") UserMiniDTO modifiedBy, @Json(name = "permissions") FileActivityPermissionsDTO permissions, @Json(name = "status") Status status, @Json(name = "target") TargetDTO target) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(createdBy, "createdBy");
        Intrinsics.checkNotNullParameter(replies, "replies");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(fileVersion, "fileVersion");
        Intrinsics.checkNotNullParameter(modifiedAt, "modifiedAt");
        Intrinsics.checkNotNullParameter(modifiedBy, "modifiedBy");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(target, "target");
        return new AnnotationDTO(id, type, createdAt, createdBy, replies, totalReplies, description, fileVersion, modifiedAt, modifiedBy, permissions, status, target);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnnotationDTO)) {
            return false;
        }
        AnnotationDTO annotationDTO = (AnnotationDTO) other;
        return Intrinsics.areEqual(this.id, annotationDTO.id) && Intrinsics.areEqual(this.type, annotationDTO.type) && Intrinsics.areEqual(this.createdAt, annotationDTO.createdAt) && Intrinsics.areEqual(this.createdBy, annotationDTO.createdBy) && Intrinsics.areEqual(this.replies, annotationDTO.replies) && this.totalReplies == annotationDTO.totalReplies && Intrinsics.areEqual(this.description, annotationDTO.description) && Intrinsics.areEqual(this.fileVersion, annotationDTO.fileVersion) && Intrinsics.areEqual(this.modifiedAt, annotationDTO.modifiedAt) && Intrinsics.areEqual(this.modifiedBy, annotationDTO.modifiedBy) && Intrinsics.areEqual(this.permissions, annotationDTO.permissions) && this.status == annotationDTO.status && Intrinsics.areEqual(this.target, annotationDTO.target);
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.createdAt.hashCode()) * 31) + this.createdBy.hashCode()) * 31) + this.replies.hashCode()) * 31) + Integer.hashCode(this.totalReplies)) * 31) + this.description.hashCode()) * 31) + this.fileVersion.hashCode()) * 31) + this.modifiedAt.hashCode()) * 31) + this.modifiedBy.hashCode()) * 31) + this.permissions.hashCode()) * 31) + this.status.hashCode()) * 31) + this.target.hashCode();
    }

    public String toString() {
        return "AnnotationDTO(id=" + this.id + ", type=" + this.type + ", createdAt=" + this.createdAt + ", createdBy=" + this.createdBy + ", replies=" + this.replies + ", totalReplies=" + this.totalReplies + ", description=" + this.description + ", fileVersion=" + this.fileVersion + ", modifiedAt=" + this.modifiedAt + ", modifiedBy=" + this.modifiedBy + ", permissions=" + this.permissions + ", status=" + this.status + ", target=" + this.target + ")";
    }

    public AnnotationDTO(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "created_at") Date createdAt, @Json(name = "created_by") UserMiniDTO createdBy, @Json(name = "replies") List<CommentDTO> replies, @Json(name = "total_reply_count") int i, @Json(name = "description") DescriptionDTO description, @Json(name = "file_version") AnnotationFileVersionDTO fileVersion, @Json(name = "modified_at") Date modifiedAt, @Json(name = "modified_by") UserMiniDTO modifiedBy, @Json(name = "permissions") FileActivityPermissionsDTO permissions, @Json(name = "status") Status status, @Json(name = "target") TargetDTO target) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(createdBy, "createdBy");
        Intrinsics.checkNotNullParameter(replies, "replies");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(fileVersion, "fileVersion");
        Intrinsics.checkNotNullParameter(modifiedAt, "modifiedAt");
        Intrinsics.checkNotNullParameter(modifiedBy, "modifiedBy");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(target, "target");
        this.id = id;
        this.type = type;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.replies = replies;
        this.totalReplies = i;
        this.description = description;
        this.fileVersion = fileVersion;
        this.modifiedAt = modifiedAt;
        this.modifiedBy = modifiedBy;
        this.permissions = permissions;
        this.status = status;
        this.target = target;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final UserMiniDTO getCreatedBy() {
        return this.createdBy;
    }

    public final List<CommentDTO> getReplies() {
        return this.replies;
    }

    public final int getTotalReplies() {
        return this.totalReplies;
    }

    public /* synthetic */ AnnotationDTO(String str, String str2, Date date, UserMiniDTO userMiniDTO, List list, int i, DescriptionDTO descriptionDTO, AnnotationFileVersionDTO annotationFileVersionDTO, Date date2, UserMiniDTO userMiniDTO2, FileActivityPermissionsDTO fileActivityPermissionsDTO, Status status, TargetDTO targetDTO, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, date, userMiniDTO, list, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? new DescriptionDTO("") : descriptionDTO, annotationFileVersionDTO, date2, userMiniDTO2, fileActivityPermissionsDTO, status, targetDTO);
    }

    public final DescriptionDTO getDescription() {
        return this.description;
    }

    public final AnnotationFileVersionDTO getFileVersion() {
        return this.fileVersion;
    }

    public final Date getModifiedAt() {
        return this.modifiedAt;
    }

    public final UserMiniDTO getModifiedBy() {
        return this.modifiedBy;
    }

    public final FileActivityPermissionsDTO getPermissions() {
        return this.permissions;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final TargetDTO getTarget() {
        return this.target;
    }
}
