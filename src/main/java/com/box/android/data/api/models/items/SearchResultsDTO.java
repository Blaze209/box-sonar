package com.box.android.data.api.models.items;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxIterator;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchResultsDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0001\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J@\u0010\u0017\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/box/android/data/api/models/items/SearchResultsDTO;", "", "entries", "", "Lcom/box/android/data/api/models/items/SearchResultEntryDTO;", BoxIterator.FIELD_LIMIT, "", "offset", "totalCount", "<init>", "(Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;J)V", "getEntries", "()Ljava/util/List;", "getLimit", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getOffset", "getTotalCount", "()J", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;J)Lcom/box/android/data/api/models/items/SearchResultsDTO;", "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SearchResultsDTO {
    private final List<SearchResultEntryDTO> entries;
    private final Long limit;
    private final Long offset;
    private final long totalCount;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchResultsDTO copy$default(SearchResultsDTO searchResultsDTO, List list, Long l, Long l2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            list = searchResultsDTO.entries;
        }
        if ((i & 2) != 0) {
            l = searchResultsDTO.limit;
        }
        if ((i & 4) != 0) {
            l2 = searchResultsDTO.offset;
        }
        if ((i & 8) != 0) {
            j = searchResultsDTO.totalCount;
        }
        Long l3 = l2;
        return searchResultsDTO.copy(list, l, l3, j);
    }

    public final List<SearchResultEntryDTO> component1() {
        return this.entries;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getLimit() {
        return this.limit;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getOffset() {
        return this.offset;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getTotalCount() {
        return this.totalCount;
    }

    public final SearchResultsDTO copy(@Json(name = "entries") List<SearchResultEntryDTO> entries, @Json(name = BoxIterator.FIELD_LIMIT) Long limit, @Json(name = "offset") Long offset, @Json(name = BoxIterator.FIELD_TOTAL_COUNT) long totalCount) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        return new SearchResultsDTO(entries, limit, offset, totalCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchResultsDTO)) {
            return false;
        }
        SearchResultsDTO searchResultsDTO = (SearchResultsDTO) other;
        return Intrinsics.areEqual(this.entries, searchResultsDTO.entries) && Intrinsics.areEqual(this.limit, searchResultsDTO.limit) && Intrinsics.areEqual(this.offset, searchResultsDTO.offset) && this.totalCount == searchResultsDTO.totalCount;
    }

    public int hashCode() {
        int iHashCode = this.entries.hashCode() * 31;
        Long l = this.limit;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.offset;
        return ((iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31) + Long.hashCode(this.totalCount);
    }

    public String toString() {
        return "SearchResultsDTO(entries=" + this.entries + ", limit=" + this.limit + ", offset=" + this.offset + ", totalCount=" + this.totalCount + ")";
    }

    public SearchResultsDTO(@Json(name = "entries") List<SearchResultEntryDTO> entries, @Json(name = BoxIterator.FIELD_LIMIT) Long l, @Json(name = "offset") Long l2, @Json(name = BoxIterator.FIELD_TOTAL_COUNT) long j) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.entries = entries;
        this.limit = l;
        this.offset = l2;
        this.totalCount = j;
    }

    public final List<SearchResultEntryDTO> getEntries() {
        return this.entries;
    }

    public final Long getLimit() {
        return this.limit;
    }

    public final Long getOffset() {
        return this.offset;
    }

    public final long getTotalCount() {
        return this.totalCount;
    }
}
