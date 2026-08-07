package com.box.android.data.jobs;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DownloadFolderJob.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\u0014\b\u0001\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0005\u0012\u0014\b\u0003\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003JU\u0010\u001a\u001a\u00020\u00002\u0014\b\u0003\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u00052\u0014\b\u0003\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/box/android/data/jobs/DownloadFolderSessionInfo;", "", "pendingChildJobsToSizeMap", "", "", "", "totalSize", "sizeDownloaded", "failedChildJobsToSizeMap", "lastRecordError", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Ljava/util/Map;JJLjava/util/Map;Lcom/box/android/domain/models/DomainError;)V", "getPendingChildJobsToSizeMap", "()Ljava/util/Map;", "getTotalSize", "()J", "getSizeDownloaded", "getFailedChildJobsToSizeMap", "getLastRecordError", "()Lcom/box/android/domain/models/DomainError;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class DownloadFolderSessionInfo {
    private final Map<String, Long> failedChildJobsToSizeMap;
    private final DomainError lastRecordError;
    private final Map<String, Long> pendingChildJobsToSizeMap;
    private final long sizeDownloaded;
    private final long totalSize;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DownloadFolderSessionInfo copy$default(DownloadFolderSessionInfo downloadFolderSessionInfo, Map map, long j, long j2, Map map2, DomainError domainError, int i, Object obj) {
        if ((i & 1) != 0) {
            map = downloadFolderSessionInfo.pendingChildJobsToSizeMap;
        }
        if ((i & 2) != 0) {
            j = downloadFolderSessionInfo.totalSize;
        }
        if ((i & 4) != 0) {
            j2 = downloadFolderSessionInfo.sizeDownloaded;
        }
        if ((i & 8) != 0) {
            map2 = downloadFolderSessionInfo.failedChildJobsToSizeMap;
        }
        if ((i & 16) != 0) {
            domainError = downloadFolderSessionInfo.lastRecordError;
        }
        long j3 = j2;
        return downloadFolderSessionInfo.copy(map, j, j3, map2, domainError);
    }

    public final Map<String, Long> component1() {
        return this.pendingChildJobsToSizeMap;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getTotalSize() {
        return this.totalSize;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getSizeDownloaded() {
        return this.sizeDownloaded;
    }

    public final Map<String, Long> component4() {
        return this.failedChildJobsToSizeMap;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final DomainError getLastRecordError() {
        return this.lastRecordError;
    }

    public final DownloadFolderSessionInfo copy(@Json(name = "pending_child_jobs") Map<String, Long> pendingChildJobsToSizeMap, @Json(name = "total_size") long totalSize, @Json(name = "size_downloaded") long sizeDownloaded, @Json(name = "failed_child_jobs") Map<String, Long> failedChildJobsToSizeMap, @Json(name = "last_record_error") DomainError lastRecordError) {
        Intrinsics.checkNotNullParameter(pendingChildJobsToSizeMap, "pendingChildJobsToSizeMap");
        Intrinsics.checkNotNullParameter(failedChildJobsToSizeMap, "failedChildJobsToSizeMap");
        return new DownloadFolderSessionInfo(pendingChildJobsToSizeMap, totalSize, sizeDownloaded, failedChildJobsToSizeMap, lastRecordError);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadFolderSessionInfo)) {
            return false;
        }
        DownloadFolderSessionInfo downloadFolderSessionInfo = (DownloadFolderSessionInfo) other;
        return Intrinsics.areEqual(this.pendingChildJobsToSizeMap, downloadFolderSessionInfo.pendingChildJobsToSizeMap) && this.totalSize == downloadFolderSessionInfo.totalSize && this.sizeDownloaded == downloadFolderSessionInfo.sizeDownloaded && Intrinsics.areEqual(this.failedChildJobsToSizeMap, downloadFolderSessionInfo.failedChildJobsToSizeMap) && Intrinsics.areEqual(this.lastRecordError, downloadFolderSessionInfo.lastRecordError);
    }

    public int hashCode() {
        int iHashCode = ((((((this.pendingChildJobsToSizeMap.hashCode() * 31) + Long.hashCode(this.totalSize)) * 31) + Long.hashCode(this.sizeDownloaded)) * 31) + this.failedChildJobsToSizeMap.hashCode()) * 31;
        DomainError domainError = this.lastRecordError;
        return iHashCode + (domainError == null ? 0 : domainError.hashCode());
    }

    public String toString() {
        return "DownloadFolderSessionInfo(pendingChildJobsToSizeMap=" + this.pendingChildJobsToSizeMap + ", totalSize=" + this.totalSize + ", sizeDownloaded=" + this.sizeDownloaded + ", failedChildJobsToSizeMap=" + this.failedChildJobsToSizeMap + ", lastRecordError=" + this.lastRecordError + ")";
    }

    public DownloadFolderSessionInfo(@Json(name = "pending_child_jobs") Map<String, Long> pendingChildJobsToSizeMap, @Json(name = "total_size") long j, @Json(name = "size_downloaded") long j2, @Json(name = "failed_child_jobs") Map<String, Long> failedChildJobsToSizeMap, @Json(name = "last_record_error") DomainError domainError) {
        Intrinsics.checkNotNullParameter(pendingChildJobsToSizeMap, "pendingChildJobsToSizeMap");
        Intrinsics.checkNotNullParameter(failedChildJobsToSizeMap, "failedChildJobsToSizeMap");
        this.pendingChildJobsToSizeMap = pendingChildJobsToSizeMap;
        this.totalSize = j;
        this.sizeDownloaded = j2;
        this.failedChildJobsToSizeMap = failedChildJobsToSizeMap;
        this.lastRecordError = domainError;
    }

    public final Map<String, Long> getPendingChildJobsToSizeMap() {
        return this.pendingChildJobsToSizeMap;
    }

    public final long getTotalSize() {
        return this.totalSize;
    }

    public final long getSizeDownloaded() {
        return this.sizeDownloaded;
    }

    public /* synthetic */ DownloadFolderSessionInfo(Map map, long j, long j2, Map map2, DomainError domainError, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, j, j2, (i & 8) != 0 ? MapsKt.emptyMap() : map2, (i & 16) != 0 ? null : domainError);
    }

    public final Map<String, Long> getFailedChildJobsToSizeMap() {
        return this.failedChildJobsToSizeMap;
    }

    public final DomainError getLastRecordError() {
        return this.lastRecordError;
    }
}
