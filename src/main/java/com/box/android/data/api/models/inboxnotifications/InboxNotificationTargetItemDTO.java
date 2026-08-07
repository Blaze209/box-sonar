package com.box.android.data.api.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationTargetItemDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010JD\u0010\u0017\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\b\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationTargetItemDTO;", "", "id", "", "type", "name", "hasCollaborations", "", "isExternallyOwned", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getId", "()Ljava/lang/String;", "getType", "getName", "getHasCollaborations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationTargetItemDTO;", "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class InboxNotificationTargetItemDTO {
    private final Boolean hasCollaborations;
    private final String id;
    private final Boolean isExternallyOwned;
    private final String name;
    private final String type;

    public static /* synthetic */ InboxNotificationTargetItemDTO copy$default(InboxNotificationTargetItemDTO inboxNotificationTargetItemDTO, String str, String str2, String str3, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inboxNotificationTargetItemDTO.id;
        }
        if ((i & 2) != 0) {
            str2 = inboxNotificationTargetItemDTO.type;
        }
        if ((i & 4) != 0) {
            str3 = inboxNotificationTargetItemDTO.name;
        }
        if ((i & 8) != 0) {
            bool = inboxNotificationTargetItemDTO.hasCollaborations;
        }
        if ((i & 16) != 0) {
            bool2 = inboxNotificationTargetItemDTO.isExternallyOwned;
        }
        Boolean bool3 = bool2;
        String str4 = str3;
        return inboxNotificationTargetItemDTO.copy(str, str2, str4, bool, bool3);
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
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getHasCollaborations() {
        return this.hasCollaborations;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getIsExternallyOwned() {
        return this.isExternallyOwned;
    }

    public final InboxNotificationTargetItemDTO copy(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "name") String name, @Json(name = BoxCollaborationItem.FIELD_HAS_COLLABORATIONS) Boolean hasCollaborations, @Json(name = BoxCollaborationItem.FIELD_IS_EXTERNALLY_OWNED) Boolean isExternallyOwned) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        return new InboxNotificationTargetItemDTO(id, type, name, hasCollaborations, isExternallyOwned);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboxNotificationTargetItemDTO)) {
            return false;
        }
        InboxNotificationTargetItemDTO inboxNotificationTargetItemDTO = (InboxNotificationTargetItemDTO) other;
        return Intrinsics.areEqual(this.id, inboxNotificationTargetItemDTO.id) && Intrinsics.areEqual(this.type, inboxNotificationTargetItemDTO.type) && Intrinsics.areEqual(this.name, inboxNotificationTargetItemDTO.name) && Intrinsics.areEqual(this.hasCollaborations, inboxNotificationTargetItemDTO.hasCollaborations) && Intrinsics.areEqual(this.isExternallyOwned, inboxNotificationTargetItemDTO.isExternallyOwned);
    }

    public int hashCode() {
        int iHashCode = ((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.name.hashCode()) * 31;
        Boolean bool = this.hasCollaborations;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isExternallyOwned;
        return iHashCode2 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        return "InboxNotificationTargetItemDTO(id=" + this.id + ", type=" + this.type + ", name=" + this.name + ", hasCollaborations=" + this.hasCollaborations + ", isExternallyOwned=" + this.isExternallyOwned + ")";
    }

    public InboxNotificationTargetItemDTO(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "name") String name, @Json(name = BoxCollaborationItem.FIELD_HAS_COLLABORATIONS) Boolean bool, @Json(name = BoxCollaborationItem.FIELD_IS_EXTERNALLY_OWNED) Boolean bool2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = id;
        this.type = type;
        this.name = name;
        this.hasCollaborations = bool;
        this.isExternallyOwned = bool2;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final String getName() {
        return this.name;
    }

    public final Boolean getHasCollaborations() {
        return this.hasCollaborations;
    }

    public final Boolean isExternallyOwned() {
        return this.isExternallyOwned;
    }
}
