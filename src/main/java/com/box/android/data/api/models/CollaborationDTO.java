package com.box.android.data.api.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxCollaboration;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollaborationDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/box/android/data/api/models/CollaborationDTO;", "", "id", "", "type", "inviteEmail", "accessibleBy", "Lcom/box/android/data/api/models/UserMiniDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/UserMiniDTO;)V", "getId", "()Ljava/lang/String;", "getType", "getInviteEmail", "getAccessibleBy", "()Lcom/box/android/data/api/models/UserMiniDTO;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CollaborationDTO {
    private final UserMiniDTO accessibleBy;
    private final String id;
    private final String inviteEmail;
    private final String type;

    public static /* synthetic */ CollaborationDTO copy$default(CollaborationDTO collaborationDTO, String str, String str2, String str3, UserMiniDTO userMiniDTO, int i, Object obj) {
        if ((i & 1) != 0) {
            str = collaborationDTO.id;
        }
        if ((i & 2) != 0) {
            str2 = collaborationDTO.type;
        }
        if ((i & 4) != 0) {
            str3 = collaborationDTO.inviteEmail;
        }
        if ((i & 8) != 0) {
            userMiniDTO = collaborationDTO.accessibleBy;
        }
        return collaborationDTO.copy(str, str2, str3, userMiniDTO);
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
    public final String getInviteEmail() {
        return this.inviteEmail;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final UserMiniDTO getAccessibleBy() {
        return this.accessibleBy;
    }

    public final CollaborationDTO copy(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = BoxCollaboration.FIELD_INVITE_EMAIL) String inviteEmail, @Json(name = "accessible_by") UserMiniDTO accessibleBy) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        return new CollaborationDTO(id, type, inviteEmail, accessibleBy);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CollaborationDTO)) {
            return false;
        }
        CollaborationDTO collaborationDTO = (CollaborationDTO) other;
        return Intrinsics.areEqual(this.id, collaborationDTO.id) && Intrinsics.areEqual(this.type, collaborationDTO.type) && Intrinsics.areEqual(this.inviteEmail, collaborationDTO.inviteEmail) && Intrinsics.areEqual(this.accessibleBy, collaborationDTO.accessibleBy);
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
        String str = this.inviteEmail;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        UserMiniDTO userMiniDTO = this.accessibleBy;
        return iHashCode2 + (userMiniDTO != null ? userMiniDTO.hashCode() : 0);
    }

    public String toString() {
        return "CollaborationDTO(id=" + this.id + ", type=" + this.type + ", inviteEmail=" + this.inviteEmail + ", accessibleBy=" + this.accessibleBy + ")";
    }

    public CollaborationDTO(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = BoxCollaboration.FIELD_INVITE_EMAIL) String str, @Json(name = "accessible_by") UserMiniDTO userMiniDTO) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.type = type;
        this.inviteEmail = str;
        this.accessibleBy = userMiniDTO;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final String getInviteEmail() {
        return this.inviteEmail;
    }

    public final UserMiniDTO getAccessibleBy() {
        return this.accessibleBy;
    }
}
