package com.box.android.domain.offline;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import com.box.android.domain.models.item.ItemType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OfflineStateModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003JZ\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010¨\u0006("}, d2 = {"Lcom/box/android/domain/offline/OfflineStateModel;", "Lcom/box/android/domain/models/DomainModel;", "itemId", "", "itemType", "Lcom/box/android/domain/models/item/ItemType;", "isUserSaved", "", "isUserRemoved", "startedDate", "", "completedDate", "sha1", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/item/ItemType;ZZLjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "getItemId", "()Ljava/lang/String;", "getItemType", "()Lcom/box/android/domain/models/item/ItemType;", "()Z", "getStartedDate", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCompletedDate", "getSha1", "component1", "component2", "component3", "component4", "component5", "component6", "component7", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Lcom/box/android/domain/models/item/ItemType;ZZLjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Lcom/box/android/domain/offline/OfflineStateModel;", "equals", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class OfflineStateModel implements DomainModel {
    private final Long completedDate;
    private final boolean isUserRemoved;
    private final boolean isUserSaved;
    private final String itemId;
    private final ItemType itemType;
    private final String sha1;
    private final Long startedDate;

    public static /* synthetic */ OfflineStateModel copy$default(OfflineStateModel offlineStateModel, String str, ItemType itemType, boolean z, boolean z2, Long l, Long l2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = offlineStateModel.itemId;
        }
        if ((i & 2) != 0) {
            itemType = offlineStateModel.itemType;
        }
        if ((i & 4) != 0) {
            z = offlineStateModel.isUserSaved;
        }
        if ((i & 8) != 0) {
            z2 = offlineStateModel.isUserRemoved;
        }
        if ((i & 16) != 0) {
            l = offlineStateModel.startedDate;
        }
        if ((i & 32) != 0) {
            l2 = offlineStateModel.completedDate;
        }
        if ((i & 64) != 0) {
            str2 = offlineStateModel.sha1;
        }
        Long l3 = l2;
        String str3 = str2;
        Long l4 = l;
        boolean z3 = z;
        return offlineStateModel.copy(str, itemType, z3, z2, l4, l3, str3);
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

    public final OfflineStateModel copy(String itemId, ItemType itemType, boolean isUserSaved, boolean isUserRemoved, Long startedDate, Long completedDate, String sha1) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        return new OfflineStateModel(itemId, itemType, isUserSaved, isUserRemoved, startedDate, completedDate, sha1);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfflineStateModel)) {
            return false;
        }
        OfflineStateModel offlineStateModel = (OfflineStateModel) other;
        return Intrinsics.areEqual(this.itemId, offlineStateModel.itemId) && this.itemType == offlineStateModel.itemType && this.isUserSaved == offlineStateModel.isUserSaved && this.isUserRemoved == offlineStateModel.isUserRemoved && Intrinsics.areEqual(this.startedDate, offlineStateModel.startedDate) && Intrinsics.areEqual(this.completedDate, offlineStateModel.completedDate) && Intrinsics.areEqual(this.sha1, offlineStateModel.sha1);
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
        return "OfflineStateModel(itemId=" + this.itemId + ", itemType=" + this.itemType + ", isUserSaved=" + this.isUserSaved + ", isUserRemoved=" + this.isUserRemoved + ", startedDate=" + this.startedDate + ", completedDate=" + this.completedDate + ", sha1=" + this.sha1 + ")";
    }

    public OfflineStateModel(String itemId, ItemType itemType, boolean z, boolean z2, Long l, Long l2, String str) {
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

    public /* synthetic */ OfflineStateModel(String str, ItemType itemType, boolean z, boolean z2, Long l, Long l2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
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
