package com.box.android.data.api.models.comment;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.WopiPropertyBuilder;
import com.box.androidsdk.content.models.BoxSharedLink;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;

/* JADX INFO: compiled from: CommentV2ResponseDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/api/models/comment/CommentPermissionsDTO;", "", "canDelete", "", WopiPropertyBuilder.IS_FILE_EDITABLE_PROPERTY, "canReply", "<init>", "(ZZZ)V", "getCanDelete", "()Z", "getCanEdit", "getCanReply", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CommentPermissionsDTO {
    private final boolean canDelete;
    private final boolean canEdit;
    private final boolean canReply;

    public static /* synthetic */ CommentPermissionsDTO copy$default(CommentPermissionsDTO commentPermissionsDTO, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = commentPermissionsDTO.canDelete;
        }
        if ((i & 2) != 0) {
            z2 = commentPermissionsDTO.canEdit;
        }
        if ((i & 4) != 0) {
            z3 = commentPermissionsDTO.canReply;
        }
        return commentPermissionsDTO.copy(z, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getCanDelete() {
        return this.canDelete;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCanEdit() {
        return this.canEdit;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getCanReply() {
        return this.canReply;
    }

    public final CommentPermissionsDTO copy(@Json(name = "can_delete") boolean canDelete, @Json(name = BoxSharedLink.Permissions.FIELD_CAN_EDIT) boolean canEdit, @Json(name = "can_reply") boolean canReply) {
        return new CommentPermissionsDTO(canDelete, canEdit, canReply);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommentPermissionsDTO)) {
            return false;
        }
        CommentPermissionsDTO commentPermissionsDTO = (CommentPermissionsDTO) other;
        return this.canDelete == commentPermissionsDTO.canDelete && this.canEdit == commentPermissionsDTO.canEdit && this.canReply == commentPermissionsDTO.canReply;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.canDelete) * 31) + Boolean.hashCode(this.canEdit)) * 31) + Boolean.hashCode(this.canReply);
    }

    public String toString() {
        return "CommentPermissionsDTO(canDelete=" + this.canDelete + ", canEdit=" + this.canEdit + ", canReply=" + this.canReply + ")";
    }

    public CommentPermissionsDTO(@Json(name = "can_delete") boolean z, @Json(name = BoxSharedLink.Permissions.FIELD_CAN_EDIT) boolean z2, @Json(name = "can_reply") boolean z3) {
        this.canDelete = z;
        this.canEdit = z2;
        this.canReply = z3;
    }

    public final boolean getCanDelete() {
        return this.canDelete;
    }

    public final boolean getCanEdit() {
        return this.canEdit;
    }

    public final boolean getCanReply() {
        return this.canReply;
    }
}
