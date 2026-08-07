package com.box.android.data.api.models.collections;

import com.box.android.data.api.models.PaginationDTO;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionItemsDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/box/android/data/api/models/collections/CollectionItemsDTO;", "", "entries", "", "Lcom/box/android/data/api/models/collections/CollectionItemDTO;", "pagination", "Lcom/box/android/data/api/models/PaginationDTO;", "<init>", "(Ljava/util/List;Lcom/box/android/data/api/models/PaginationDTO;)V", "getEntries", "()Ljava/util/List;", "getPagination", "()Lcom/box/android/data/api/models/PaginationDTO;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CollectionItemsDTO {
    private final List<CollectionItemDTO> entries;
    private final PaginationDTO pagination;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CollectionItemsDTO copy$default(CollectionItemsDTO collectionItemsDTO, List list, PaginationDTO paginationDTO, int i, Object obj) {
        if ((i & 1) != 0) {
            list = collectionItemsDTO.entries;
        }
        if ((i & 2) != 0) {
            paginationDTO = collectionItemsDTO.pagination;
        }
        return collectionItemsDTO.copy(list, paginationDTO);
    }

    public final List<CollectionItemDTO> component1() {
        return this.entries;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PaginationDTO getPagination() {
        return this.pagination;
    }

    public final CollectionItemsDTO copy(@Json(name = "data") List<CollectionItemDTO> entries, @Json(name = "pagination") PaginationDTO pagination) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        Intrinsics.checkNotNullParameter(pagination, "pagination");
        return new CollectionItemsDTO(entries, pagination);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CollectionItemsDTO)) {
            return false;
        }
        CollectionItemsDTO collectionItemsDTO = (CollectionItemsDTO) other;
        return Intrinsics.areEqual(this.entries, collectionItemsDTO.entries) && Intrinsics.areEqual(this.pagination, collectionItemsDTO.pagination);
    }

    public int hashCode() {
        return (this.entries.hashCode() * 31) + this.pagination.hashCode();
    }

    public String toString() {
        return "CollectionItemsDTO(entries=" + this.entries + ", pagination=" + this.pagination + ")";
    }

    public CollectionItemsDTO(@Json(name = "data") List<CollectionItemDTO> entries, @Json(name = "pagination") PaginationDTO pagination) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        Intrinsics.checkNotNullParameter(pagination, "pagination");
        this.entries = entries;
        this.pagination = pagination;
    }

    public final List<CollectionItemDTO> getEntries() {
        return this.entries;
    }

    public final PaginationDTO getPagination() {
        return this.pagination;
    }
}
