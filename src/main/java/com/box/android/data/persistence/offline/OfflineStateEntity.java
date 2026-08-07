package com.box.android.data.persistence.offline;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.ItemType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OfflineStateEntity.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003JZ\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0013R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010¨\u0006'"}, d2 = {"Lcom/box/android/data/persistence/offline/OfflineStateEntity;", "", "itemId", "", "itemType", "Lcom/box/android/domain/models/item/ItemType;", "isUserSaved", "", "isUserRemoved", "startedDate", "", "completedDate", "sha1", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/item/ItemType;ZZLjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "getItemId", "()Ljava/lang/String;", "getItemType", "()Lcom/box/android/domain/models/item/ItemType;", "()Z", "getStartedDate", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCompletedDate", "getSha1", "component1", "component2", "component3", "component4", "component5", "component6", "component7", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Lcom/box/android/domain/models/item/ItemType;ZZLjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Lcom/box/android/data/persistence/offline/OfflineStateEntity;", "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class OfflineStateEntity {
    private final Long completedDate;
    private final boolean isUserRemoved;
    private final boolean isUserSaved;
    private final String itemId;
    private final ItemType itemType;
    private final String sha1;
    private final Long startedDate;

    public static /* synthetic */ OfflineStateEntity copy$default(OfflineStateEntity offlineStateEntity, String str, ItemType itemType, boolean z, boolean z2, Long l, Long l2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = offlineStateEntity.itemId;
        }
        if ((i & 2) != 0) {
            itemType = offlineStateEntity.itemType;
        }
        if ((i & 4) != 0) {
            z = offlineStateEntity.isUserSaved;
        }
        if ((i & 8) != 0) {
            z2 = offlineStateEntity.isUserRemoved;
        }
        if ((i & 16) != 0) {
            l = offlineStateEntity.startedDate;
        }
        if ((i & 32) != 0) {
            l2 = offlineStateEntity.completedDate;
        }
        if ((i & 64) != 0) {
            str2 = offlineStateEntity.sha1;
        }
        Long l3 = l2;
        String str3 = str2;
        Long l4 = l;
        boolean z3 = z;
        return offlineStateEntity.copy(str, itemType, z3, z2, l4, l3, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getItemId() {
        return this.itemId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ItemType getItemType() {
        return this.itemType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsUserSaved() {
        return this.isUserSaved;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsUserRemoved() {
        return this.isUserRemoved;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Long getStartedDate() {
        return this.startedDate;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getCompletedDate() {
        return this.completedDate;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getSha1() {
        return this.sha1;
    }

    public final OfflineStateEntity copy(String itemId, ItemType itemType, boolean isUserSaved, boolean isUserRemoved, Long startedDate, Long completedDate, String sha1) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        return new OfflineStateEntity(itemId, itemType, isUserSaved, isUserRemoved, startedDate, completedDate, sha1);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfflineStateEntity)) {
            return false;
        }
        OfflineStateEntity offlineStateEntity = (OfflineStateEntity) other;
        return Intrinsics.areEqual(this.itemId, offlineStateEntity.itemId) && this.itemType == offlineStateEntity.itemType && this.isUserSaved == offlineStateEntity.isUserSaved && this.isUserRemoved == offlineStateEntity.isUserRemoved && Intrinsics.areEqual(this.startedDate, offlineStateEntity.startedDate) && Intrinsics.areEqual(this.completedDate, offlineStateEntity.completedDate) && Intrinsics.areEqual(this.sha1, offlineStateEntity.sha1);
    }

    public int hashCode() {
        int iHashCode = ((((((this.itemId.hashCode() * 31) + this.itemType.hashCode()) * 31) + Boolean.hashCode(this.isUserSaved)) * 31) + Boolean.hashCode(this.isUserRemoved)) * 31;
        Long l = this.startedDate;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.completedDate;
        int iHashCode3 = (iHashCode2 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str = this.sha1;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "OfflineStateEntity(itemId=" + this.itemId + ", itemType=" + this.itemType + ", isUserSaved=" + this.isUserSaved + ", isUserRemoved=" + this.isUserRemoved + ", startedDate=" + this.startedDate + ", completedDate=" + this.completedDate + ", sha1=" + this.sha1 + ")";
    }

    public OfflineStateEntity(String itemId, ItemType itemType, boolean z, boolean z2, Long l, Long l2, String str) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        this.itemId = itemId;
        this.itemType = itemType;
        this.isUserSaved = z;
        this.isUserRemoved = z2;
        this.startedDate = l;
        this.completedDate = l2;
        this.sha1 = str;
    }

    public /* synthetic */ OfflineStateEntity(String str, ItemType itemType, boolean z, boolean z2, Long l, Long l2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, itemType, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? null : l, (i & 32) != 0 ? null : l2, (i & 64) != 0 ? null : str2);
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final ItemType getItemType() {
        return this.itemType;
    }

    public final boolean isUserSaved() {
        return this.isUserSaved;
    }

    public final boolean isUserRemoved() {
        return this.isUserRemoved;
    }

    public final Long getStartedDate() {
        return this.startedDate;
    }

    public final Long getCompletedDate() {
        return this.completedDate;
    }

    public final String getSha1() {
        return this.sha1;
    }
}
