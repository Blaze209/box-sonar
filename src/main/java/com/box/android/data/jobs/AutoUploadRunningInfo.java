package com.box.android.data.jobs;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AutoUploadJob.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\"\b\u0087\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0003\u0010\n\u001a\u00020\u000b\u0012\u0014\b\u0001\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r\u0012\u000e\b\u0001\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f\u0012\u0014\b\u0001\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r\u0012\u0014\b\u0001\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\r¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003J\u0015\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rHÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fHÆ\u0003J\u0015\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rHÆ\u0003J\u0015\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\rHÆ\u0003J\u0097\u0001\u0010/\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\u000b2\u0014\b\u0003\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r2\u000e\b\u0003\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0014\b\u0003\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r2\u0014\b\u0003\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\rHÆ\u0001J\u0013\u00100\u001a\u00020\t2\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u000bHÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 ¨\u00064"}, d2 = {"Lcom/box/android/data/jobs/AutoUploadRunningInfo;", "", "uploadFolderId", "", "sourceFolderPath", "lastSyncTime", "", "syncEnabledTime", "shouldNotify", "", "totalFiles", "", "runningRequests", "", "succeededFiles", "", "failedFiles", "sizes", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJZILjava/util/Map;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;)V", "getUploadFolderId", "()Ljava/lang/String;", "getSourceFolderPath", "getLastSyncTime", "()J", "getSyncEnabledTime", "getShouldNotify", "()Z", "getTotalFiles", "()I", "getRunningRequests", "()Ljava/util/Map;", "getSucceededFiles", "()Ljava/util/Set;", "getFailedFiles", "getSizes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AutoUploadRunningInfo {
    private final Map<String, String> failedFiles;
    private final long lastSyncTime;
    private final Map<String, String> runningRequests;
    private final boolean shouldNotify;
    private final Map<String, Double> sizes;
    private final String sourceFolderPath;
    private final Set<String> succeededFiles;
    private final long syncEnabledTime;
    private final int totalFiles;
    private final String uploadFolderId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AutoUploadRunningInfo copy$default(AutoUploadRunningInfo autoUploadRunningInfo, String str, String str2, long j, long j2, boolean z, int i, Map map, Set set, Map map2, Map map3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = autoUploadRunningInfo.uploadFolderId;
        }
        if ((i2 & 2) != 0) {
            str2 = autoUploadRunningInfo.sourceFolderPath;
        }
        if ((i2 & 4) != 0) {
            j = autoUploadRunningInfo.lastSyncTime;
        }
        if ((i2 & 8) != 0) {
            j2 = autoUploadRunningInfo.syncEnabledTime;
        }
        if ((i2 & 16) != 0) {
            z = autoUploadRunningInfo.shouldNotify;
        }
        if ((i2 & 32) != 0) {
            i = autoUploadRunningInfo.totalFiles;
        }
        if ((i2 & 64) != 0) {
            map = autoUploadRunningInfo.runningRequests;
        }
        if ((i2 & 128) != 0) {
            set = autoUploadRunningInfo.succeededFiles;
        }
        if ((i2 & 256) != 0) {
            map2 = autoUploadRunningInfo.failedFiles;
        }
        if ((i2 & 512) != 0) {
            map3 = autoUploadRunningInfo.sizes;
        }
        Map map4 = map2;
        Map map5 = map3;
        long j3 = j2;
        long j4 = j;
        return autoUploadRunningInfo.copy(str, str2, j4, j3, z, i, map, set, map4, map5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUploadFolderId() {
        return this.uploadFolderId;
    }

    public final Map<String, Double> component10() {
        return this.sizes;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSourceFolderPath() {
        return this.sourceFolderPath;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getLastSyncTime() {
        return this.lastSyncTime;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getSyncEnabledTime() {
        return this.syncEnabledTime;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getShouldNotify() {
        return this.shouldNotify;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getTotalFiles() {
        return this.totalFiles;
    }

    public final Map<String, String> component7() {
        return this.runningRequests;
    }

    public final Set<String> component8() {
        return this.succeededFiles;
    }

    public final Map<String, String> component9() {
        return this.failedFiles;
    }

    public final AutoUploadRunningInfo copy(@Json String uploadFolderId, @Json String sourceFolderPath, @Json long lastSyncTime, @Json long syncEnabledTime, @Json boolean shouldNotify, @Json int totalFiles, @Json Map<String, String> runningRequests, @Json Set<String> succeededFiles, @Json Map<String, String> failedFiles, @Json Map<String, Double> sizes) {
        Intrinsics.checkNotNullParameter(uploadFolderId, "uploadFolderId");
        Intrinsics.checkNotNullParameter(sourceFolderPath, "sourceFolderPath");
        Intrinsics.checkNotNullParameter(runningRequests, "runningRequests");
        Intrinsics.checkNotNullParameter(succeededFiles, "succeededFiles");
        Intrinsics.checkNotNullParameter(failedFiles, "failedFiles");
        Intrinsics.checkNotNullParameter(sizes, "sizes");
        return new AutoUploadRunningInfo(uploadFolderId, sourceFolderPath, lastSyncTime, syncEnabledTime, shouldNotify, totalFiles, runningRequests, succeededFiles, failedFiles, sizes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AutoUploadRunningInfo)) {
            return false;
        }
        AutoUploadRunningInfo autoUploadRunningInfo = (AutoUploadRunningInfo) other;
        return Intrinsics.areEqual(this.uploadFolderId, autoUploadRunningInfo.uploadFolderId) && Intrinsics.areEqual(this.sourceFolderPath, autoUploadRunningInfo.sourceFolderPath) && this.lastSyncTime == autoUploadRunningInfo.lastSyncTime && this.syncEnabledTime == autoUploadRunningInfo.syncEnabledTime && this.shouldNotify == autoUploadRunningInfo.shouldNotify && this.totalFiles == autoUploadRunningInfo.totalFiles && Intrinsics.areEqual(this.runningRequests, autoUploadRunningInfo.runningRequests) && Intrinsics.areEqual(this.succeededFiles, autoUploadRunningInfo.succeededFiles) && Intrinsics.areEqual(this.failedFiles, autoUploadRunningInfo.failedFiles) && Intrinsics.areEqual(this.sizes, autoUploadRunningInfo.sizes);
    }

    public int hashCode() {
        return (((((((((((((((((this.uploadFolderId.hashCode() * 31) + this.sourceFolderPath.hashCode()) * 31) + Long.hashCode(this.lastSyncTime)) * 31) + Long.hashCode(this.syncEnabledTime)) * 31) + Boolean.hashCode(this.shouldNotify)) * 31) + Integer.hashCode(this.totalFiles)) * 31) + this.runningRequests.hashCode()) * 31) + this.succeededFiles.hashCode()) * 31) + this.failedFiles.hashCode()) * 31) + this.sizes.hashCode();
    }

    public String toString() {
        return "AutoUploadRunningInfo(uploadFolderId=" + this.uploadFolderId + ", sourceFolderPath=" + this.sourceFolderPath + ", lastSyncTime=" + this.lastSyncTime + ", syncEnabledTime=" + this.syncEnabledTime + ", shouldNotify=" + this.shouldNotify + ", totalFiles=" + this.totalFiles + ", runningRequests=" + this.runningRequests + ", succeededFiles=" + this.succeededFiles + ", failedFiles=" + this.failedFiles + ", sizes=" + this.sizes + ")";
    }

    public AutoUploadRunningInfo(@Json String uploadFolderId, @Json String sourceFolderPath, @Json long j, @Json long j2, @Json boolean z, @Json int i, @Json Map<String, String> runningRequests, @Json Set<String> succeededFiles, @Json Map<String, String> failedFiles, @Json Map<String, Double> sizes) {
        Intrinsics.checkNotNullParameter(uploadFolderId, "uploadFolderId");
        Intrinsics.checkNotNullParameter(sourceFolderPath, "sourceFolderPath");
        Intrinsics.checkNotNullParameter(runningRequests, "runningRequests");
        Intrinsics.checkNotNullParameter(succeededFiles, "succeededFiles");
        Intrinsics.checkNotNullParameter(failedFiles, "failedFiles");
        Intrinsics.checkNotNullParameter(sizes, "sizes");
        this.uploadFolderId = uploadFolderId;
        this.sourceFolderPath = sourceFolderPath;
        this.lastSyncTime = j;
        this.syncEnabledTime = j2;
        this.shouldNotify = z;
        this.totalFiles = i;
        this.runningRequests = runningRequests;
        this.succeededFiles = succeededFiles;
        this.failedFiles = failedFiles;
        this.sizes = sizes;
    }

    public /* synthetic */ AutoUploadRunningInfo(String str, String str2, long j, long j2, boolean z, int i, Map map, Set set, Map map2, Map map3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j, j2, z, (i2 & 32) != 0 ? 0 : i, map, set, map2, map3);
    }

    public final String getUploadFolderId() {
        return this.uploadFolderId;
    }

    public final String getSourceFolderPath() {
        return this.sourceFolderPath;
    }

    public final long getLastSyncTime() {
        return this.lastSyncTime;
    }

    public final long getSyncEnabledTime() {
        return this.syncEnabledTime;
    }

    public final boolean getShouldNotify() {
        return this.shouldNotify;
    }

    public final int getTotalFiles() {
        return this.totalFiles;
    }

    public final Map<String, String> getRunningRequests() {
        return this.runningRequests;
    }

    public final Set<String> getSucceededFiles() {
        return this.succeededFiles;
    }

    public final Map<String, String> getFailedFiles() {
        return this.failedFiles;
    }

    public final Map<String, Double> getSizes() {
        return this.sizes;
    }
}
