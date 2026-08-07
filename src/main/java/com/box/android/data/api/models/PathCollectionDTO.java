package com.box.android.data.api.models;

import com.box.android.data.api.models.items.mini.FolderMiniDTO;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxIterator;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PathCollectionDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J#\u0010\u0012\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/box/android/data/api/models/PathCollectionDTO;", "", "entries", "", "Lcom/box/android/data/api/models/items/mini/FolderMiniDTO;", "totalCount", "", "<init>", "(Ljava/util/List;I)V", "getEntries", "()Ljava/util/List;", "getTotalCount", "()I", "isRooted", "", "()Z", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PathCollectionDTO {
    private final List<FolderMiniDTO> entries;
    private final boolean isRooted;
    private final int totalCount;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PathCollectionDTO copy$default(PathCollectionDTO pathCollectionDTO, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = pathCollectionDTO.entries;
        }
        if ((i2 & 2) != 0) {
            i = pathCollectionDTO.totalCount;
        }
        return pathCollectionDTO.copy(list, i);
    }

    public final List<FolderMiniDTO> component1() {
        return this.entries;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTotalCount() {
        return this.totalCount;
    }

    public final PathCollectionDTO copy(@Json(name = "entries") List<FolderMiniDTO> entries, @Json(name = BoxIterator.FIELD_TOTAL_COUNT) int totalCount) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        return new PathCollectionDTO(entries, totalCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PathCollectionDTO)) {
            return false;
        }
        PathCollectionDTO pathCollectionDTO = (PathCollectionDTO) other;
        return Intrinsics.areEqual(this.entries, pathCollectionDTO.entries) && this.totalCount == pathCollectionDTO.totalCount;
    }

    public int hashCode() {
        return (this.entries.hashCode() * 31) + Integer.hashCode(this.totalCount);
    }

    public String toString() {
        return "PathCollectionDTO(entries=" + this.entries + ", totalCount=" + this.totalCount + ")";
    }

    public PathCollectionDTO(@Json(name = "entries") List<FolderMiniDTO> entries, @Json(name = BoxIterator.FIELD_TOTAL_COUNT) int i) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.entries = entries;
        this.totalCount = i;
        this.isRooted = entries.isEmpty() ? false : entries.get(0).isRoot();
    }

    public final List<FolderMiniDTO> getEntries() {
        return this.entries;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    /* JADX INFO: renamed from: isRooted, reason: from getter */
    public final boolean getIsRooted() {
        return this.isRooted;
    }
}
