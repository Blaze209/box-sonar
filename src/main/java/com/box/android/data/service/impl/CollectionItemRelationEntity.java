package com.box.android.data.service.impl;

import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionsServiceUtils.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/box/android/data/service/impl/CollectionItemRelationEntity;", "", BoxItemJob.COLLECTION_ID, "", "itemId", "itemType", "networkFetchedAt", "Ljava/util/Date;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V", "getCollectionId", "()Ljava/lang/String;", "getItemId", "getItemType", "getNetworkFetchedAt", "()Ljava/util/Date;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CollectionItemRelationEntity {
    private final String collectionId;
    private final String itemId;
    private final String itemType;
    private final Date networkFetchedAt;

    public static /* synthetic */ CollectionItemRelationEntity copy$default(CollectionItemRelationEntity collectionItemRelationEntity, String str, String str2, String str3, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            str = collectionItemRelationEntity.collectionId;
        }
        if ((i & 2) != 0) {
            str2 = collectionItemRelationEntity.itemId;
        }
        if ((i & 4) != 0) {
            str3 = collectionItemRelationEntity.itemType;
        }
        if ((i & 8) != 0) {
            date = collectionItemRelationEntity.networkFetchedAt;
        }
        return collectionItemRelationEntity.copy(str, str2, str3, date);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCollectionId() {
        return this.collectionId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getItemId() {
        return this.itemId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getItemType() {
        return this.itemType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Date getNetworkFetchedAt() {
        return this.networkFetchedAt;
    }

    public final CollectionItemRelationEntity copy(String collectionId, String itemId, String itemType, Date networkFetchedAt) {
        Intrinsics.checkNotNullParameter(collectionId, "collectionId");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        Intrinsics.checkNotNullParameter(networkFetchedAt, "networkFetchedAt");
        return new CollectionItemRelationEntity(collectionId, itemId, itemType, networkFetchedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CollectionItemRelationEntity)) {
            return false;
        }
        CollectionItemRelationEntity collectionItemRelationEntity = (CollectionItemRelationEntity) other;
        return Intrinsics.areEqual(this.collectionId, collectionItemRelationEntity.collectionId) && Intrinsics.areEqual(this.itemId, collectionItemRelationEntity.itemId) && Intrinsics.areEqual(this.itemType, collectionItemRelationEntity.itemType) && Intrinsics.areEqual(this.networkFetchedAt, collectionItemRelationEntity.networkFetchedAt);
    }

    public int hashCode() {
        return (((((this.collectionId.hashCode() * 31) + this.itemId.hashCode()) * 31) + this.itemType.hashCode()) * 31) + this.networkFetchedAt.hashCode();
    }

    public String toString() {
        return "CollectionItemRelationEntity(collectionId=" + this.collectionId + ", itemId=" + this.itemId + ", itemType=" + this.itemType + ", networkFetchedAt=" + this.networkFetchedAt + ")";
    }

    public CollectionItemRelationEntity(String collectionId, String itemId, String itemType, Date networkFetchedAt) {
        Intrinsics.checkNotNullParameter(collectionId, "collectionId");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        Intrinsics.checkNotNullParameter(networkFetchedAt, "networkFetchedAt");
        this.collectionId = collectionId;
        this.itemId = itemId;
        this.itemType = itemType;
        this.networkFetchedAt = networkFetchedAt;
    }

    public final String getCollectionId() {
        return this.collectionId;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final String getItemType() {
        return this.itemType;
    }

    public /* synthetic */ CollectionItemRelationEntity(String str, String str2, String str3, Date date, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? new Date() : date);
    }

    public final Date getNetworkFetchedAt() {
        return this.networkFetchedAt;
    }
}
