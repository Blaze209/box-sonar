package com.box.android.domain.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationUserModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ<\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;", "Lcom/box/android/domain/models/DomainModel;", "id", "", "type", "name", "deleted", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getId", "()Ljava/lang/String;", "getType", "getName", "getDeleted", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;", "equals", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class InboxNotificationUserModel implements DomainModel {
    private final Boolean deleted;
    private final String id;
    private final String name;
    private final String type;

    public static /* synthetic */ InboxNotificationUserModel copy$default(InboxNotificationUserModel inboxNotificationUserModel, String str, String str2, String str3, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inboxNotificationUserModel.id;
        }
        if ((i & 2) != 0) {
            str2 = inboxNotificationUserModel.type;
        }
        if ((i & 4) != 0) {
            str3 = inboxNotificationUserModel.name;
        }
        if ((i & 8) != 0) {
            bool = inboxNotificationUserModel.deleted;
        }
        return inboxNotificationUserModel.copy(str, str2, str3, bool);
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

    public final InboxNotificationUserModel copy(String id, String type, String name, Boolean deleted) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new InboxNotificationUserModel(id, type, name, deleted);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboxNotificationUserModel)) {
            return false;
        }
        InboxNotificationUserModel inboxNotificationUserModel = (InboxNotificationUserModel) other;
        return Intrinsics.areEqual(this.id, inboxNotificationUserModel.id) && Intrinsics.areEqual(this.type, inboxNotificationUserModel.type) && Intrinsics.areEqual(this.name, inboxNotificationUserModel.name) && Intrinsics.areEqual(this.deleted, inboxNotificationUserModel.deleted);
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
        return "InboxNotificationUserModel(id=" + this.id + ", type=" + this.type + ", name=" + this.name + ", deleted=" + this.deleted + ")";
    }

    public InboxNotificationUserModel(String str, String type, String str2, Boolean bool) {
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
