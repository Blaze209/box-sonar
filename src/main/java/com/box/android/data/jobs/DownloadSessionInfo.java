package com.box.android.data.jobs;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DownloadFileJob.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003\u0012\u0014\b\u0001\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0003HÆ\u0003J\u0015\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J_\u0010\u001b\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0003\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u00062\u000e\b\u0003\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0014\b\u0003\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0003\u0010\u000b\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/box/android/data/jobs/DownloadSessionInfo;", "", "chunksToDownload", "", "", "childJobs", "", "", "succeededChunks", "Lcom/box/android/data/jobs/ChunkData;", "failedRequests", "progress", "<init>", "(Ljava/util/Set;Ljava/util/Map;Ljava/util/Set;Ljava/util/Map;J)V", "getChunksToDownload", "()Ljava/util/Set;", "getChildJobs", "()Ljava/util/Map;", "getSucceededChunks", "getFailedRequests", "getProgress", "()J", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class DownloadSessionInfo {
    private final Map<String, Long> childJobs;
    private final Set<Long> chunksToDownload;
    private final Map<Long, String> failedRequests;
    private final long progress;
    private final Set<ChunkData> succeededChunks;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DownloadSessionInfo copy$default(DownloadSessionInfo downloadSessionInfo, Set set, Map map, Set set2, Map map2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            set = downloadSessionInfo.chunksToDownload;
        }
        if ((i & 2) != 0) {
            map = downloadSessionInfo.childJobs;
        }
        if ((i & 4) != 0) {
            set2 = downloadSessionInfo.succeededChunks;
        }
        if ((i & 8) != 0) {
            map2 = downloadSessionInfo.failedRequests;
        }
        if ((i & 16) != 0) {
            j = downloadSessionInfo.progress;
        }
        long j2 = j;
        return downloadSessionInfo.copy(set, map, set2, map2, j2);
    }

    public final Set<Long> component1() {
        return this.chunksToDownload;
    }

    public final Map<String, Long> component2() {
        return this.childJobs;
    }

    public final Set<ChunkData> component3() {
        return this.succeededChunks;
    }

    public final Map<Long, String> component4() {
        return this.failedRequests;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getProgress() {
        return this.progress;
    }

    public final DownloadSessionInfo copy(@Json(name = "chunks_to_download") Set<Long> chunksToDownload, @Json(name = "child_requests") Map<String, Long> childJobs, @Json(name = "succeeded_chunks") Set<ChunkData> succeededChunks, @Json(name = "failed_requests") Map<Long, String> failedRequests, @Json(name = "progress") long progress) {
        Intrinsics.checkNotNullParameter(chunksToDownload, "chunksToDownload");
        Intrinsics.checkNotNullParameter(childJobs, "childJobs");
        Intrinsics.checkNotNullParameter(succeededChunks, "succeededChunks");
        Intrinsics.checkNotNullParameter(failedRequests, "failedRequests");
        return new DownloadSessionInfo(chunksToDownload, childJobs, succeededChunks, failedRequests, progress);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadSessionInfo)) {
            return false;
        }
        DownloadSessionInfo downloadSessionInfo = (DownloadSessionInfo) other;
        return Intrinsics.areEqual(this.chunksToDownload, downloadSessionInfo.chunksToDownload) && Intrinsics.areEqual(this.childJobs, downloadSessionInfo.childJobs) && Intrinsics.areEqual(this.succeededChunks, downloadSessionInfo.succeededChunks) && Intrinsics.areEqual(this.failedRequests, downloadSessionInfo.failedRequests) && this.progress == downloadSessionInfo.progress;
    }

    public int hashCode() {
        return (((((((this.chunksToDownload.hashCode() * 31) + this.childJobs.hashCode()) * 31) + this.succeededChunks.hashCode()) * 31) + this.failedRequests.hashCode()) * 31) + Long.hashCode(this.progress);
    }

    public String toString() {
        return "DownloadSessionInfo(chunksToDownload=" + this.chunksToDownload + ", childJobs=" + this.childJobs + ", succeededChunks=" + this.succeededChunks + ", failedRequests=" + this.failedRequests + ", progress=" + this.progress + ")";
    }

    public DownloadSessionInfo(@Json(name = "chunks_to_download") Set<Long> chunksToDownload, @Json(name = "child_requests") Map<String, Long> childJobs, @Json(name = "succeeded_chunks") Set<ChunkData> succeededChunks, @Json(name = "failed_requests") Map<Long, String> failedRequests, @Json(name = "progress") long j) {
        Intrinsics.checkNotNullParameter(chunksToDownload, "chunksToDownload");
        Intrinsics.checkNotNullParameter(childJobs, "childJobs");
        Intrinsics.checkNotNullParameter(succeededChunks, "succeededChunks");
        Intrinsics.checkNotNullParameter(failedRequests, "failedRequests");
        this.chunksToDownload = chunksToDownload;
        this.childJobs = childJobs;
        this.succeededChunks = succeededChunks;
        this.failedRequests = failedRequests;
        this.progress = j;
    }

    public final Set<Long> getChunksToDownload() {
        return this.chunksToDownload;
    }

    public final Map<String, Long> getChildJobs() {
        return this.childJobs;
    }

    public final Set<ChunkData> getSucceededChunks() {
        return this.succeededChunks;
    }

    public final Map<Long, String> getFailedRequests() {
        return this.failedRequests;
    }

    public final long getProgress() {
        return this.progress;
    }
}
