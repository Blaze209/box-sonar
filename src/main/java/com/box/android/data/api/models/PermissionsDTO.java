package com.box.android.data.api.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxSharedLink;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PermissionsDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b,\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u009e\u0001\u0010+\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020\u00032\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u000202HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0016\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0017\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0018\u0010\u0012R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0019\u0010\u0012R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001a\u0010\u0012R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001b\u0010\u0012R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001c\u0010\u0012R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001d\u0010\u0012R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001e\u0010\u0012¨\u00063"}, d2 = {"Lcom/box/android/data/api/models/PermissionsDTO;", "", "canInviteCollaborator", "", "canSetShareAccess", "canDownload", "canPreview", "canComment", "canUpload", "canRename", "canDelete", "canShare", "canViewAnnotations", "canCreateAnnotations", "canApplyWatermark", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getCanInviteCollaborator", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCanSetShareAccess", "getCanDownload", "getCanPreview", "getCanComment", "getCanUpload", "getCanRename", "getCanDelete", "getCanShare", "getCanViewAnnotations", "getCanCreateAnnotations", "getCanApplyWatermark", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/box/android/data/api/models/PermissionsDTO;", "equals", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PermissionsDTO {
    private final Boolean canApplyWatermark;
    private final Boolean canComment;
    private final Boolean canCreateAnnotations;
    private final Boolean canDelete;
    private final Boolean canDownload;
    private final Boolean canInviteCollaborator;
    private final Boolean canPreview;
    private final Boolean canRename;
    private final Boolean canSetShareAccess;
    private final Boolean canShare;
    private final Boolean canUpload;
    private final Boolean canViewAnnotations;

    public PermissionsDTO() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    public static /* synthetic */ PermissionsDTO copy$default(PermissionsDTO permissionsDTO, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, Boolean bool12, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = permissionsDTO.canInviteCollaborator;
        }
        if ((i & 2) != 0) {
            bool2 = permissionsDTO.canSetShareAccess;
        }
        if ((i & 4) != 0) {
            bool3 = permissionsDTO.canDownload;
        }
        if ((i & 8) != 0) {
            bool4 = permissionsDTO.canPreview;
        }
        if ((i & 16) != 0) {
            bool5 = permissionsDTO.canComment;
        }
        if ((i & 32) != 0) {
            bool6 = permissionsDTO.canUpload;
        }
        if ((i & 64) != 0) {
            bool7 = permissionsDTO.canRename;
        }
        if ((i & 128) != 0) {
            bool8 = permissionsDTO.canDelete;
        }
        if ((i & 256) != 0) {
            bool9 = permissionsDTO.canShare;
        }
        if ((i & 512) != 0) {
            bool10 = permissionsDTO.canViewAnnotations;
        }
        if ((i & 1024) != 0) {
            bool11 = permissionsDTO.canCreateAnnotations;
        }
        if ((i & 2048) != 0) {
            bool12 = permissionsDTO.canApplyWatermark;
        }
        Boolean bool13 = bool11;
        Boolean bool14 = bool12;
        Boolean bool15 = bool9;
        Boolean bool16 = bool10;
        Boolean bool17 = bool7;
        Boolean bool18 = bool8;
        Boolean bool19 = bool5;
        Boolean bool20 = bool6;
        return permissionsDTO.copy(bool, bool2, bool3, bool4, bool19, bool20, bool17, bool18, bool15, bool16, bool13, bool14);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getCanInviteCollaborator() {
        return this.canInviteCollaborator;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Boolean getCanViewAnnotations() {
        return this.canViewAnnotations;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Boolean getCanCreateAnnotations() {
        return this.canCreateAnnotations;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Boolean getCanApplyWatermark() {
        return this.canApplyWatermark;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getCanSetShareAccess() {
        return this.canSetShareAccess;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getCanDownload() {
        return this.canDownload;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getCanPreview() {
        return this.canPreview;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getCanComment() {
        return this.canComment;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Boolean getCanUpload() {
        return this.canUpload;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Boolean getCanRename() {
        return this.canRename;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Boolean getCanDelete() {
        return this.canDelete;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Boolean getCanShare() {
        return this.canShare;
    }

    public final PermissionsDTO copy(@Json(name = "can_invite_collaborator") Boolean canInviteCollaborator, @Json(name = "can_set_share_access") Boolean canSetShareAccess, @Json(name = BoxSharedLink.Permissions.FIELD_CAN_DOWNLOAD) Boolean canDownload, @Json(name = "can_preview") Boolean canPreview, @Json(name = "can_comment") Boolean canComment, @Json(name = "can_upload") Boolean canUpload, @Json(name = "can_rename") Boolean canRename, @Json(name = "can_delete") Boolean canDelete, @Json(name = "can_share") Boolean canShare, @Json(name = "can_view_annotations") Boolean canViewAnnotations, @Json(name = "can_create_annotations") Boolean canCreateAnnotations, @Json(name = "can_apply_watermark") Boolean canApplyWatermark) {
        return new PermissionsDTO(canInviteCollaborator, canSetShareAccess, canDownload, canPreview, canComment, canUpload, canRename, canDelete, canShare, canViewAnnotations, canCreateAnnotations, canApplyWatermark);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PermissionsDTO)) {
            return false;
        }
        PermissionsDTO permissionsDTO = (PermissionsDTO) other;
        return Intrinsics.areEqual(this.canInviteCollaborator, permissionsDTO.canInviteCollaborator) && Intrinsics.areEqual(this.canSetShareAccess, permissionsDTO.canSetShareAccess) && Intrinsics.areEqual(this.canDownload, permissionsDTO.canDownload) && Intrinsics.areEqual(this.canPreview, permissionsDTO.canPreview) && Intrinsics.areEqual(this.canComment, permissionsDTO.canComment) && Intrinsics.areEqual(this.canUpload, permissionsDTO.canUpload) && Intrinsics.areEqual(this.canRename, permissionsDTO.canRename) && Intrinsics.areEqual(this.canDelete, permissionsDTO.canDelete) && Intrinsics.areEqual(this.canShare, permissionsDTO.canShare) && Intrinsics.areEqual(this.canViewAnnotations, permissionsDTO.canViewAnnotations) && Intrinsics.areEqual(this.canCreateAnnotations, permissionsDTO.canCreateAnnotations) && Intrinsics.areEqual(this.canApplyWatermark, permissionsDTO.canApplyWatermark);
    }

    public int hashCode() {
        Boolean bool = this.canInviteCollaborator;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.canSetShareAccess;
        int iHashCode2 = (iHashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.canDownload;
        int iHashCode3 = (iHashCode2 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.canPreview;
        int iHashCode4 = (iHashCode3 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.canComment;
        int iHashCode5 = (iHashCode4 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Boolean bool6 = this.canUpload;
        int iHashCode6 = (iHashCode5 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Boolean bool7 = this.canRename;
        int iHashCode7 = (iHashCode6 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
        Boolean bool8 = this.canDelete;
        int iHashCode8 = (iHashCode7 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
        Boolean bool9 = this.canShare;
        int iHashCode9 = (iHashCode8 + (bool9 == null ? 0 : bool9.hashCode())) * 31;
        Boolean bool10 = this.canViewAnnotations;
        int iHashCode10 = (iHashCode9 + (bool10 == null ? 0 : bool10.hashCode())) * 31;
        Boolean bool11 = this.canCreateAnnotations;
        int iHashCode11 = (iHashCode10 + (bool11 == null ? 0 : bool11.hashCode())) * 31;
        Boolean bool12 = this.canApplyWatermark;
        return iHashCode11 + (bool12 != null ? bool12.hashCode() : 0);
    }

    public String toString() {
        return "PermissionsDTO(canInviteCollaborator=" + this.canInviteCollaborator + ", canSetShareAccess=" + this.canSetShareAccess + ", canDownload=" + this.canDownload + ", canPreview=" + this.canPreview + ", canComment=" + this.canComment + ", canUpload=" + this.canUpload + ", canRename=" + this.canRename + ", canDelete=" + this.canDelete + ", canShare=" + this.canShare + ", canViewAnnotations=" + this.canViewAnnotations + ", canCreateAnnotations=" + this.canCreateAnnotations + ", canApplyWatermark=" + this.canApplyWatermark + ")";
    }

    public PermissionsDTO(@Json(name = "can_invite_collaborator") Boolean bool, @Json(name = "can_set_share_access") Boolean bool2, @Json(name = BoxSharedLink.Permissions.FIELD_CAN_DOWNLOAD) Boolean bool3, @Json(name = "can_preview") Boolean bool4, @Json(name = "can_comment") Boolean bool5, @Json(name = "can_upload") Boolean bool6, @Json(name = "can_rename") Boolean bool7, @Json(name = "can_delete") Boolean bool8, @Json(name = "can_share") Boolean bool9, @Json(name = "can_view_annotations") Boolean bool10, @Json(name = "can_create_annotations") Boolean bool11, @Json(name = "can_apply_watermark") Boolean bool12) {
        this.canInviteCollaborator = bool;
        this.canSetShareAccess = bool2;
        this.canDownload = bool3;
        this.canPreview = bool4;
        this.canComment = bool5;
        this.canUpload = bool6;
        this.canRename = bool7;
        this.canDelete = bool8;
        this.canShare = bool9;
        this.canViewAnnotations = bool10;
        this.canCreateAnnotations = bool11;
        this.canApplyWatermark = bool12;
    }

    public /* synthetic */ PermissionsDTO(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, Boolean bool12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : bool3, (i & 8) != 0 ? null : bool4, (i & 16) != 0 ? null : bool5, (i & 32) != 0 ? null : bool6, (i & 64) != 0 ? null : bool7, (i & 128) != 0 ? null : bool8, (i & 256) != 0 ? null : bool9, (i & 512) != 0 ? null : bool10, (i & 1024) != 0 ? null : bool11, (i & 2048) != 0 ? null : bool12);
    }

    public final Boolean getCanInviteCollaborator() {
        return this.canInviteCollaborator;
    }

    public final Boolean getCanSetShareAccess() {
        return this.canSetShareAccess;
    }

    public final Boolean getCanDownload() {
        return this.canDownload;
    }

    public final Boolean getCanPreview() {
        return this.canPreview;
    }

    public final Boolean getCanComment() {
        return this.canComment;
    }

    public final Boolean getCanUpload() {
        return this.canUpload;
    }

    public final Boolean getCanRename() {
        return this.canRename;
    }

    public final Boolean getCanDelete() {
        return this.canDelete;
    }

    public final Boolean getCanShare() {
        return this.canShare;
    }

    public final Boolean getCanViewAnnotations() {
        return this.canViewAnnotations;
    }

    public final Boolean getCanCreateAnnotations() {
        return this.canCreateAnnotations;
    }

    public final Boolean getCanApplyWatermark() {
        return this.canApplyWatermark;
    }
}
