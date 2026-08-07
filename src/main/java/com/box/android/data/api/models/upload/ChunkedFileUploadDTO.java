package com.box.android.data.api.models.upload;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxIterator;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChunkedFileUploadDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006\u0012\u0010\b\u0001\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003\u0012\b\b\u0001\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003JI\u0010\u0019\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\u0010\b\u0003\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00032\b\b\u0003\u0010\n\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010¨\u0006!"}, d2 = {"Lcom/box/android/data/api/models/upload/ChunkedFileUploadDTO;", "", "entries", "", "Lcom/box/android/data/api/models/upload/UploadFileChunkDTO;", BoxIterator.FIELD_LIMIT, "", "offset", "chunkOrder", "Lcom/box/android/data/api/models/upload/FileChunkOrder;", "totalCount", "<init>", "(Ljava/util/List;JJLjava/util/List;J)V", "getEntries", "()Ljava/util/List;", "getLimit", "()J", "getOffset", "getChunkOrder", "getTotalCount", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ChunkedFileUploadDTO {
    private final List<FileChunkOrder> chunkOrder;
    private final List<UploadFileChunkDTO> entries;
    private final long limit;
    private final long offset;
    private final long totalCount;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChunkedFileUploadDTO copy$default(ChunkedFileUploadDTO chunkedFileUploadDTO, List list, long j, long j2, List list2, long j3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = chunkedFileUploadDTO.entries;
        }
        if ((i & 2) != 0) {
            j = chunkedFileUploadDTO.limit;
        }
        if ((i & 4) != 0) {
            j2 = chunkedFileUploadDTO.offset;
        }
        if ((i & 8) != 0) {
            list2 = chunkedFileUploadDTO.chunkOrder;
        }
        if ((i & 16) != 0) {
            j3 = chunkedFileUploadDTO.totalCount;
        }
        List list3 = list2;
        long j4 = j2;
        return chunkedFileUploadDTO.copy(list, j, j4, list3, j3);
    }

    public final List<UploadFileChunkDTO> component1() {
        return this.entries;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getLimit() {
        return this.limit;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getOffset() {
        return this.offset;
    }

    public final List<FileChunkOrder> component4() {
        return this.chunkOrder;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getTotalCount() {
        return this.totalCount;
    }

    public final ChunkedFileUploadDTO copy(@Json(name = "entries") List<UploadFileChunkDTO> entries, @Json(name = BoxIterator.FIELD_LIMIT) long limit, @Json(name = "offset") long offset, @Json(name = BoxIterator.FIELD_ORDER) List<FileChunkOrder> chunkOrder, @Json(name = BoxIterator.FIELD_TOTAL_COUNT) long totalCount) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        return new ChunkedFileUploadDTO(entries, limit, offset, chunkOrder, totalCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChunkedFileUploadDTO)) {
            return false;
        }
        ChunkedFileUploadDTO chunkedFileUploadDTO = (ChunkedFileUploadDTO) other;
        return Intrinsics.areEqual(this.entries, chunkedFileUploadDTO.entries) && this.limit == chunkedFileUploadDTO.limit && this.offset == chunkedFileUploadDTO.offset && Intrinsics.areEqual(this.chunkOrder, chunkedFileUploadDTO.chunkOrder) && this.totalCount == chunkedFileUploadDTO.totalCount;
    }

    public int hashCode() {
        int iHashCode = ((((this.entries.hashCode() * 31) + Long.hashCode(this.limit)) * 31) + Long.hashCode(this.offset)) * 31;
        List<FileChunkOrder> list = this.chunkOrder;
        return ((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + Long.hashCode(this.totalCount);
    }

    public String toString() {
        return "ChunkedFileUploadDTO(entries=" + this.entries + ", limit=" + this.limit + ", offset=" + this.offset + ", chunkOrder=" + this.chunkOrder + ", totalCount=" + this.totalCount + ")";
    }

    public ChunkedFileUploadDTO(@Json(name = "entries") List<UploadFileChunkDTO> entries, @Json(name = BoxIterator.FIELD_LIMIT) long j, @Json(name = "offset") long j2, @Json(name = BoxIterator.FIELD_ORDER) List<FileChunkOrder> list, @Json(name = BoxIterator.FIELD_TOTAL_COUNT) long j3) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.entries = entries;
        this.limit = j;
        this.offset = j2;
        this.chunkOrder = list;
        this.totalCount = j3;
    }

    public final List<UploadFileChunkDTO> getEntries() {
        return this.entries;
    }

    public final long getLimit() {
        return this.limit;
    }

    public final long getOffset() {
        return this.offset;
    }

    public final List<FileChunkOrder> getChunkOrder() {
        return this.chunkOrder;
    }

    public final long getTotalCount() {
        return this.totalCount;
    }
}
