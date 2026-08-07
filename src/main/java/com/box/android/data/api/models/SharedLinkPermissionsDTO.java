package com.box.android.data.api.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.WopiPropertyBuilder;
import com.box.androidsdk.content.models.BoxSharedLink;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedLinkPermissionsDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0010\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/box/android/data/api/models/SharedLinkPermissionsDTO;", "", "canDownload", "", "canPreview", WopiPropertyBuilder.IS_FILE_EDITABLE_PROPERTY, "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getCanDownload", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCanPreview", "getCanEdit", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/box/android/data/api/models/SharedLinkPermissionsDTO;", "equals", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SharedLinkPermissionsDTO {
    private final Boolean canDownload;
    private final Boolean canEdit;
    private final Boolean canPreview;

    public SharedLinkPermissionsDTO() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ SharedLinkPermissionsDTO copy$default(SharedLinkPermissionsDTO sharedLinkPermissionsDTO, Boolean bool, Boolean bool2, Boolean bool3, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = sharedLinkPermissionsDTO.canDownload;
        }
        if ((i & 2) != 0) {
            bool2 = sharedLinkPermissionsDTO.canPreview;
        }
        if ((i & 4) != 0) {
            bool3 = sharedLinkPermissionsDTO.canEdit;
        }
        return sharedLinkPermissionsDTO.copy(bool, bool2, bool3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getCanDownload() {
        return this.canDownload;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getCanPreview() {
        return this.canPreview;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getCanEdit() {
        return this.canEdit;
    }

    public final SharedLinkPermissionsDTO copy(@Json(name = BoxSharedLink.Permissions.FIELD_CAN_DOWNLOAD) Boolean canDownload, @Json(name = "can_preview") Boolean canPreview, @Json(name = BoxSharedLink.Permissions.FIELD_CAN_EDIT) Boolean canEdit) {
        return new SharedLinkPermissionsDTO(canDownload, canPreview, canEdit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SharedLinkPermissionsDTO)) {
            return false;
        }
        SharedLinkPermissionsDTO sharedLinkPermissionsDTO = (SharedLinkPermissionsDTO) other;
        return Intrinsics.areEqual(this.canDownload, sharedLinkPermissionsDTO.canDownload) && Intrinsics.areEqual(this.canPreview, sharedLinkPermissionsDTO.canPreview) && Intrinsics.areEqual(this.canEdit, sharedLinkPermissionsDTO.canEdit);
    }

    public int hashCode() {
        Boolean bool = this.canDownload;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.canPreview;
        int iHashCode2 = (iHashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.canEdit;
        return iHashCode2 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        return "SharedLinkPermissionsDTO(canDownload=" + this.canDownload + ", canPreview=" + this.canPreview + ", canEdit=" + this.canEdit + ")";
    }

    public SharedLinkPermissionsDTO(@Json(name = BoxSharedLink.Permissions.FIELD_CAN_DOWNLOAD) Boolean bool, @Json(name = "can_preview") Boolean bool2, @Json(name = BoxSharedLink.Permissions.FIELD_CAN_EDIT) Boolean bool3) {
        this.canDownload = bool;
        this.canPreview = bool2;
        this.canEdit = bool3;
    }

    public /* synthetic */ SharedLinkPermissionsDTO(Boolean bool, Boolean bool2, Boolean bool3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : bool3);
    }

    public final Boolean getCanDownload() {
        return this.canDownload;
    }

    public final Boolean getCanPreview() {
        return this.canPreview;
    }

    public final Boolean getCanEdit() {
        return this.canEdit;
    }
}
