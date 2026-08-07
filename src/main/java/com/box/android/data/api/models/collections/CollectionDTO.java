package com.box.android.data.api.models.collections;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.CollectionType;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u0017\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/box/android/data/api/models/collections/CollectionDTO;", "", "id", "", "name", "collectionType", "Lcom/box/android/domain/models/CollectionType;", "createdAt", "updatedAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/domain/models/CollectionType;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getCollectionType", "()Lcom/box/android/domain/models/CollectionType;", "getCreatedAt", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CollectionDTO {
    private final CollectionType collectionType;
    private final String createdAt;
    private final String id;
    private final String name;
    private final String updatedAt;

    public static /* synthetic */ CollectionDTO copy$default(CollectionDTO collectionDTO, String str, String str2, CollectionType collectionType, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = collectionDTO.id;
        }
        if ((i & 2) != 0) {
            str2 = collectionDTO.name;
        }
        if ((i & 4) != 0) {
            collectionType = collectionDTO.collectionType;
        }
        if ((i & 8) != 0) {
            str3 = collectionDTO.createdAt;
        }
        if ((i & 16) != 0) {
            str4 = collectionDTO.updatedAt;
        }
        String str5 = str4;
        CollectionType collectionType2 = collectionType;
        return collectionDTO.copy(str, str2, collectionType2, str3, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final CollectionType getCollectionType() {
        return this.collectionType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final CollectionDTO copy(@Json(name = "id") String id, @Json(name = "name") String name, @Json(name = "collection_type") CollectionType collectionType, @Json(name = "created_at") String createdAt, @Json(name = IDToken.UPDATED_AT) String updatedAt) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(collectionType, "collectionType");
        return new CollectionDTO(id, name, collectionType, createdAt, updatedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CollectionDTO)) {
            return false;
        }
        CollectionDTO collectionDTO = (CollectionDTO) other;
        return Intrinsics.areEqual(this.id, collectionDTO.id) && Intrinsics.areEqual(this.name, collectionDTO.name) && this.collectionType == collectionDTO.collectionType && Intrinsics.areEqual(this.createdAt, collectionDTO.createdAt) && Intrinsics.areEqual(this.updatedAt, collectionDTO.updatedAt);
    }

    public int hashCode() {
        int iHashCode = ((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.collectionType.hashCode()) * 31;
        String str = this.createdAt;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.updatedAt;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "CollectionDTO(id=" + this.id + ", name=" + this.name + ", collectionType=" + this.collectionType + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ")";
    }

    public CollectionDTO(@Json(name = "id") String id, @Json(name = "name") String name, @Json(name = "collection_type") CollectionType collectionType, @Json(name = "created_at") String str, @Json(name = IDToken.UPDATED_AT) String str2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(collectionType, "collectionType");
        this.id = id;
        this.name = name;
        this.collectionType = collectionType;
        this.createdAt = str;
        this.updatedAt = str2;
    }

    public /* synthetic */ CollectionDTO(String str, String str2, CollectionType collectionType, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, collectionType, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4);
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final CollectionType getCollectionType() {
        return this.collectionType;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getUpdatedAt() {
        return this.updatedAt;
    }
}
