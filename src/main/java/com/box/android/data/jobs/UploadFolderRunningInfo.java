package com.box.android.data.jobs;

import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UploadFolderJob.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\u0007\u001a\u00020\b\u0012\u0014\b\u0001\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n\u0012\u000e\b\u0001\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f\u0012\u0014\b\u0001\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n\u0012\u0014\b\u0001\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\u0015\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003J\u0015\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\u0015\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\nHÆ\u0003J\u008f\u0001\u0010(\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0007\u001a\u00020\b2\u0014\b\u0003\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n2\u000e\b\u0003\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0014\b\u0003\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n2\u0014\b\u0003\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\nHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\bHÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001a¨\u0006."}, d2 = {"Lcom/box/android/data/jobs/UploadFolderRunningInfo;", "", BoxCommonConstants.EXTRA_FOLDER_NAME, "", "localFolderId", "parentFolderLocalId", "folderRemoteId", "totalFiles", "", "runningRequests", "", "succeededFiles", "", "failedFiles", "sizes", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/Map;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;)V", "getFolderName", "()Ljava/lang/String;", "getLocalFolderId", "getParentFolderLocalId", "getFolderRemoteId", "getTotalFiles", "()I", "getRunningRequests", "()Ljava/util/Map;", "getSucceededFiles", "()Ljava/util/Set;", "getFailedFiles", "getSizes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class UploadFolderRunningInfo {
    private final Map<String, String> failedFiles;
    private final String folderName;
    private final String folderRemoteId;
    private final String localFolderId;
    private final String parentFolderLocalId;
    private final Map<String, String> runningRequests;
    private final Map<String, Double> sizes;
    private final Set<String> succeededFiles;
    private final int totalFiles;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UploadFolderRunningInfo copy$default(UploadFolderRunningInfo uploadFolderRunningInfo, String str, String str2, String str3, String str4, int i, Map map, Set set, Map map2, Map map3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = uploadFolderRunningInfo.folderName;
        }
        if ((i2 & 2) != 0) {
            str2 = uploadFolderRunningInfo.localFolderId;
        }
        if ((i2 & 4) != 0) {
            str3 = uploadFolderRunningInfo.parentFolderLocalId;
        }
        if ((i2 & 8) != 0) {
            str4 = uploadFolderRunningInfo.folderRemoteId;
        }
        if ((i2 & 16) != 0) {
            i = uploadFolderRunningInfo.totalFiles;
        }
        if ((i2 & 32) != 0) {
            map = uploadFolderRunningInfo.runningRequests;
        }
        if ((i2 & 64) != 0) {
            set = uploadFolderRunningInfo.succeededFiles;
        }
        if ((i2 & 128) != 0) {
            map2 = uploadFolderRunningInfo.failedFiles;
        }
        if ((i2 & 256) != 0) {
            map3 = uploadFolderRunningInfo.sizes;
        }
        Map map4 = map2;
        Map map5 = map3;
        Map map6 = map;
        Set set2 = set;
        int i3 = i;
        String str5 = str3;
        return uploadFolderRunningInfo.copy(str, str2, str5, str4, i3, map6, set2, map4, map5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFolderName() {
        return this.folderName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLocalFolderId() {
        return this.localFolderId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getParentFolderLocalId() {
        return this.parentFolderLocalId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFolderRemoteId() {
        return this.folderRemoteId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getTotalFiles() {
        return this.totalFiles;
    }

    public final Map<String, String> component6() {
        return this.runningRequests;
    }

    public final Set<String> component7() {
        return this.succeededFiles;
    }

    public final Map<String, String> component8() {
        return this.failedFiles;
    }

    public final Map<String, Double> component9() {
        return this.sizes;
    }

    public final UploadFolderRunningInfo copy(@Json String folderName, @Json String localFolderId, @Json String parentFolderLocalId, @Json String folderRemoteId, @Json int totalFiles, @Json Map<String, String> runningRequests, @Json Set<String> succeededFiles, @Json Map<String, String> failedFiles, @Json Map<String, Double> sizes) {
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(localFolderId, "localFolderId");
        Intrinsics.checkNotNullParameter(parentFolderLocalId, "parentFolderLocalId");
        Intrinsics.checkNotNullParameter(runningRequests, "runningRequests");
        Intrinsics.checkNotNullParameter(succeededFiles, "succeededFiles");
        Intrinsics.checkNotNullParameter(failedFiles, "failedFiles");
        Intrinsics.checkNotNullParameter(sizes, "sizes");
        return new UploadFolderRunningInfo(folderName, localFolderId, parentFolderLocalId, folderRemoteId, totalFiles, runningRequests, succeededFiles, failedFiles, sizes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadFolderRunningInfo)) {
            return false;
        }
        UploadFolderRunningInfo uploadFolderRunningInfo = (UploadFolderRunningInfo) other;
        return Intrinsics.areEqual(this.folderName, uploadFolderRunningInfo.folderName) && Intrinsics.areEqual(this.localFolderId, uploadFolderRunningInfo.localFolderId) && Intrinsics.areEqual(this.parentFolderLocalId, uploadFolderRunningInfo.parentFolderLocalId) && Intrinsics.areEqual(this.folderRemoteId, uploadFolderRunningInfo.folderRemoteId) && this.totalFiles == uploadFolderRunningInfo.totalFiles && Intrinsics.areEqual(this.runningRequests, uploadFolderRunningInfo.runningRequests) && Intrinsics.areEqual(this.succeededFiles, uploadFolderRunningInfo.succeededFiles) && Intrinsics.areEqual(this.failedFiles, uploadFolderRunningInfo.failedFiles) && Intrinsics.areEqual(this.sizes, uploadFolderRunningInfo.sizes);
    }

    public int hashCode() {
        int iHashCode = ((((this.folderName.hashCode() * 31) + this.localFolderId.hashCode()) * 31) + this.parentFolderLocalId.hashCode()) * 31;
        String str = this.folderRemoteId;
        return ((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.totalFiles)) * 31) + this.runningRequests.hashCode()) * 31) + this.succeededFiles.hashCode()) * 31) + this.failedFiles.hashCode()) * 31) + this.sizes.hashCode();
    }

    public String toString() {
        return "UploadFolderRunningInfo(folderName=" + this.folderName + ", localFolderId=" + this.localFolderId + ", parentFolderLocalId=" + this.parentFolderLocalId + ", folderRemoteId=" + this.folderRemoteId + ", totalFiles=" + this.totalFiles + ", runningRequests=" + this.runningRequests + ", succeededFiles=" + this.succeededFiles + ", failedFiles=" + this.failedFiles + ", sizes=" + this.sizes + ")";
    }

    public UploadFolderRunningInfo(@Json String folderName, @Json String localFolderId, @Json String parentFolderLocalId, @Json String str, @Json int i, @Json Map<String, String> runningRequests, @Json Set<String> succeededFiles, @Json Map<String, String> failedFiles, @Json Map<String, Double> sizes) {
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(localFolderId, "localFolderId");
        Intrinsics.checkNotNullParameter(parentFolderLocalId, "parentFolderLocalId");
        Intrinsics.checkNotNullParameter(runningRequests, "runningRequests");
        Intrinsics.checkNotNullParameter(succeededFiles, "succeededFiles");
        Intrinsics.checkNotNullParameter(failedFiles, "failedFiles");
        Intrinsics.checkNotNullParameter(sizes, "sizes");
        this.folderName = folderName;
        this.localFolderId = localFolderId;
        this.parentFolderLocalId = parentFolderLocalId;
        this.folderRemoteId = str;
        this.totalFiles = i;
        this.runningRequests = runningRequests;
        this.succeededFiles = succeededFiles;
        this.failedFiles = failedFiles;
        this.sizes = sizes;
    }

    public /* synthetic */ UploadFolderRunningInfo(String str, String str2, String str3, String str4, int i, Map map, Set set, Map map2, Map map3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? 0 : i, map, set, map2, map3);
    }

    public final String getFolderName() {
        return this.folderName;
    }

    public final String getLocalFolderId() {
        return this.localFolderId;
    }

    public final String getParentFolderLocalId() {
        return this.parentFolderLocalId;
    }

    public final String getFolderRemoteId() {
        return this.folderRemoteId;
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
