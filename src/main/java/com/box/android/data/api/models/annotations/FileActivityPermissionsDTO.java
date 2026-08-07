package com.box.android.data.api.models.annotations;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.WopiPropertyBuilder;
import com.box.androidsdk.content.models.BoxSharedLink;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FileActivityPermissionsDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/box/android/data/api/models/annotations/FileActivityPermissionsDTO;", "", "canDelete", "", WopiPropertyBuilder.IS_FILE_EDITABLE_PROPERTY, "canChangeStatus", "canResolve", "canReply", "<init>", "(ZZZZZ)V", "getCanDelete", "()Z", "getCanEdit", "getCanChangeStatus", "getCanResolve", "getCanReply", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FileActivityPermissionsDTO {
    private final boolean canChangeStatus;
    private final boolean canDelete;
    private final boolean canEdit;
    private final boolean canReply;
    private final boolean canResolve;

    public FileActivityPermissionsDTO() {
        this(false, false, false, false, false, 31, null);
    }

    public static /* synthetic */ FileActivityPermissionsDTO copy$default(FileActivityPermissionsDTO fileActivityPermissionsDTO, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, Object obj) {
        if ((i & 1) != 0) {
            z = fileActivityPermissionsDTO.canDelete;
        }
        if ((i & 2) != 0) {
            z2 = fileActivityPermissionsDTO.canEdit;
        }
        if ((i & 4) != 0) {
            z3 = fileActivityPermissionsDTO.canChangeStatus;
        }
        if ((i & 8) != 0) {
            z4 = fileActivityPermissionsDTO.canResolve;
        }
        if ((i & 16) != 0) {
            z5 = fileActivityPermissionsDTO.canReply;
        }
        boolean z6 = z5;
        boolean z7 = z3;
        return fileActivityPermissionsDTO.copy(z, z2, z7, z4, z6);
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
    public final boolean getCanChangeStatus() {
        return this.canChangeStatus;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getCanResolve() {
        return this.canResolve;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getCanReply() {
        return this.canReply;
    }

    public final FileActivityPermissionsDTO copy(@Json(name = "can_delete") boolean canDelete, @Json(name = BoxSharedLink.Permissions.FIELD_CAN_EDIT) boolean canEdit, @Json(name = "can_change_status") boolean canChangeStatus, @Json(name = "can_resolve") boolean canResolve, @Json(name = "can_reply") boolean canReply) {
        return new FileActivityPermissionsDTO(canDelete, canEdit, canChangeStatus, canResolve, canReply);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileActivityPermissionsDTO)) {
            return false;
        }
        FileActivityPermissionsDTO fileActivityPermissionsDTO = (FileActivityPermissionsDTO) other;
        return this.canDelete == fileActivityPermissionsDTO.canDelete && this.canEdit == fileActivityPermissionsDTO.canEdit && this.canChangeStatus == fileActivityPermissionsDTO.canChangeStatus && this.canResolve == fileActivityPermissionsDTO.canResolve && this.canReply == fileActivityPermissionsDTO.canReply;
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.canDelete) * 31) + Boolean.hashCode(this.canEdit)) * 31) + Boolean.hashCode(this.canChangeStatus)) * 31) + Boolean.hashCode(this.canResolve)) * 31) + Boolean.hashCode(this.canReply);
    }

    public String toString() {
        return "FileActivityPermissionsDTO(canDelete=" + this.canDelete + ", canEdit=" + this.canEdit + ", canChangeStatus=" + this.canChangeStatus + ", canResolve=" + this.canResolve + ", canReply=" + this.canReply + ")";
    }

    public FileActivityPermissionsDTO(@Json(name = "can_delete") boolean z, @Json(name = BoxSharedLink.Permissions.FIELD_CAN_EDIT) boolean z2, @Json(name = "can_change_status") boolean z3, @Json(name = "can_resolve") boolean z4, @Json(name = "can_reply") boolean z5) {
        this.canDelete = z;
        this.canEdit = z2;
        this.canChangeStatus = z3;
        this.canResolve = z4;
        this.canReply = z5;
    }

    public /* synthetic */ FileActivityPermissionsDTO(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4, (i & 16) != 0 ? false : z5);
    }

    public final boolean getCanDelete() {
        return this.canDelete;
    }

    public final boolean getCanEdit() {
        return this.canEdit;
    }

    public final boolean getCanChangeStatus() {
        return this.canChangeStatus;
    }

    public final boolean getCanResolve() {
        return this.canResolve;
    }

    public final boolean getCanReply() {
        return this.canReply;
    }
}
