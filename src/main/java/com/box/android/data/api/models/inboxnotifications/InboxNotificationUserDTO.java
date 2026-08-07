package com.box.android.data.api.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationUserDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ<\u0010\u0015\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationUserDTO;", "", "id", "", "type", "name", "deleted", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getId", "()Ljava/lang/String;", "getType", "getName", "getDeleted", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationUserDTO;", "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class InboxNotificationUserDTO {
    private final Boolean deleted;
    private final String id;
    private final String name;
    private final String type;

    public static /* synthetic */ InboxNotificationUserDTO copy$default(InboxNotificationUserDTO inboxNotificationUserDTO, String str, String str2, String str3, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inboxNotificationUserDTO.id;
        }
        if ((i & 2) != 0) {
            str2 = inboxNotificationUserDTO.type;
        }
        if ((i & 4) != 0) {
            str3 = inboxNotificationUserDTO.name;
        }
        if ((i & 8) != 0) {
            bool = inboxNotificationUserDTO.deleted;
        }
        return inboxNotificationUserDTO.copy(str, str2, str3, bool);
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
    public final Boolean getDeleted() {
        return this.deleted;
    }

    public final InboxNotificationUserDTO copy(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "name") String name, @Json(name = "deleted") Boolean deleted) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new InboxNotificationUserDTO(id, type, name, deleted);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboxNotificationUserDTO)) {
            return false;
        }
        InboxNotificationUserDTO inboxNotificationUserDTO = (InboxNotificationUserDTO) other;
        return Intrinsics.areEqual(this.id, inboxNotificationUserDTO.id) && Intrinsics.areEqual(this.type, inboxNotificationUserDTO.type) && Intrinsics.areEqual(this.name, inboxNotificationUserDTO.name) && Intrinsics.areEqual(this.deleted, inboxNotificationUserDTO.deleted);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.type.hashCode()) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.deleted;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "InboxNotificationUserDTO(id=" + this.id + ", type=" + this.type + ", name=" + this.name + ", deleted=" + this.deleted + ")";
    }

    public InboxNotificationUserDTO(@Json(name = "id") String str, @Json(name = "type") String type, @Json(name = "name") String str2, @Json(name = "deleted") Boolean bool) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = str;
        this.type = type;
        this.name = str2;
        this.deleted = bool;
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

    public final Boolean getDeleted() {
        return this.deleted;
    }
}
