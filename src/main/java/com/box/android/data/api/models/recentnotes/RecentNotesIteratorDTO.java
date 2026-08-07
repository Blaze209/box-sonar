package com.box.android.data.api.models.recentnotes;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxIterator;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecentNotesIteratorDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/box/android/data/api/models/recentnotes/RecentNotesIteratorDTO;", "", "entries", "", "Lcom/box/android/data/api/models/recentnotes/RecentNoteDTO;", "nextMarker", "", BoxIterator.FIELD_LIMIT, "", "<init>", "(Ljava/util/List;Ljava/lang/String;I)V", "getEntries", "()Ljava/util/List;", "getNextMarker", "()Ljava/lang/String;", "getLimit", "()I", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class RecentNotesIteratorDTO {
    private final List<RecentNoteDTO> entries;
    private final int limit;
    private final String nextMarker;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RecentNotesIteratorDTO copy$default(RecentNotesIteratorDTO recentNotesIteratorDTO, List list, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = recentNotesIteratorDTO.entries;
        }
        if ((i2 & 2) != 0) {
            str = recentNotesIteratorDTO.nextMarker;
        }
        if ((i2 & 4) != 0) {
            i = recentNotesIteratorDTO.limit;
        }
        return recentNotesIteratorDTO.copy(list, str, i);
    }

    public final List<RecentNoteDTO> component1() {
        return this.entries;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNextMarker() {
        return this.nextMarker;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getLimit() {
        return this.limit;
    }

    public final RecentNotesIteratorDTO copy(@Json(name = "entries") List<RecentNoteDTO> entries, @Json(name = BoxIterator.FIELD_NEXT_MARKER) String nextMarker, @Json(name = BoxIterator.FIELD_LIMIT) int limit) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        return new RecentNotesIteratorDTO(entries, nextMarker, limit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecentNotesIteratorDTO)) {
            return false;
        }
        RecentNotesIteratorDTO recentNotesIteratorDTO = (RecentNotesIteratorDTO) other;
        return Intrinsics.areEqual(this.entries, recentNotesIteratorDTO.entries) && Intrinsics.areEqual(this.nextMarker, recentNotesIteratorDTO.nextMarker) && this.limit == recentNotesIteratorDTO.limit;
    }

    public int hashCode() {
        int iHashCode = this.entries.hashCode() * 31;
        String str = this.nextMarker;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.limit);
    }

    public String toString() {
        return "RecentNotesIteratorDTO(entries=" + this.entries + ", nextMarker=" + this.nextMarker + ", limit=" + this.limit + ")";
    }

    public RecentNotesIteratorDTO(@Json(name = "entries") List<RecentNoteDTO> entries, @Json(name = BoxIterator.FIELD_NEXT_MARKER) String str, @Json(name = BoxIterator.FIELD_LIMIT) int i) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.entries = entries;
        this.nextMarker = str;
        this.limit = i;
    }

    public final List<RecentNoteDTO> getEntries() {
        return this.entries;
    }

    public final String getNextMarker() {
        return this.nextMarker;
    }

    public final int getLimit() {
        return this.limit;
    }
}
