package com.box.android.data.api.models.collections;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.CollectionType;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateCollectionDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/api/models/collections/CreateCollectionDTO;", "", "name", "", "collectionType", "Lcom/box/android/domain/models/CollectionType;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/CollectionType;)V", "getName", "()Ljava/lang/String;", "getCollectionType", "()Lcom/box/android/domain/models/CollectionType;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CreateCollectionDTO {
    private final CollectionType collectionType;
    private final String name;

    public static /* synthetic */ CreateCollectionDTO copy$default(CreateCollectionDTO createCollectionDTO, String str, CollectionType collectionType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = createCollectionDTO.name;
        }
        if ((i & 2) != 0) {
            collectionType = createCollectionDTO.collectionType;
        }
        return createCollectionDTO.copy(str, collectionType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CollectionType getCollectionType() {
        return this.collectionType;
    }

    public final CreateCollectionDTO copy(@Json(name = "name") String name, @Json(name = "collection_type") CollectionType collectionType) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(collectionType, "collectionType");
        return new CreateCollectionDTO(name, collectionType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateCollectionDTO)) {
            return false;
        }
        CreateCollectionDTO createCollectionDTO = (CreateCollectionDTO) other;
        return Intrinsics.areEqual(this.name, createCollectionDTO.name) && this.collectionType == createCollectionDTO.collectionType;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.collectionType.hashCode();
    }

    public String toString() {
        return "CreateCollectionDTO(name=" + this.name + ", collectionType=" + this.collectionType + ")";
    }

    public CreateCollectionDTO(@Json(name = "name") String name, @Json(name = "collection_type") CollectionType collectionType) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(collectionType, "collectionType");
        this.name = name;
        this.collectionType = collectionType;
    }

    public final CollectionType getCollectionType() {
        return this.collectionType;
    }

    public final String getName() {
        return this.name;
    }
}
