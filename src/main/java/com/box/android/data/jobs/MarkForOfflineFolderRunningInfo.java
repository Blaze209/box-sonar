package com.box.android.data.jobs;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.ItemId;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MarkForOfflineFolderJob.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\u000e\b\u0001\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u000e\b\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003J]\u0010 \u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\u0014\b\u0003\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0003\u0010\b\u001a\u00020\t2\u000e\b\u0003\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u000e\b\u0003\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\tHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018¨\u0006&"}, d2 = {"Lcom/box/android/data/jobs/MarkForOfflineFolderRunningInfo;", "", "itemName", "", "itemRemoteId", "Lcom/box/android/domain/models/ItemId$Remote;", "childJobMap", "", "totalFiles", "", "succeededFiles", "", "failedFiles", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId$Remote;Ljava/util/Map;ILjava/util/Set;Ljava/util/Set;)V", "getItemName", "()Ljava/lang/String;", "getItemRemoteId", "()Lcom/box/android/domain/models/ItemId$Remote;", "getChildJobMap", "()Ljava/util/Map;", "getTotalFiles", "()I", "getSucceededFiles", "()Ljava/util/Set;", "getFailedFiles", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MarkForOfflineFolderRunningInfo {
    private final Map<String, String> childJobMap;
    private final Set<String> failedFiles;
    private final String itemName;
    private final ItemId.Remote itemRemoteId;
    private final Set<String> succeededFiles;
    private final int totalFiles;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MarkForOfflineFolderRunningInfo copy$default(MarkForOfflineFolderRunningInfo markForOfflineFolderRunningInfo, String str, ItemId.Remote remote, Map map, int i, Set set, Set set2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = markForOfflineFolderRunningInfo.itemName;
        }
        if ((i2 & 2) != 0) {
            remote = markForOfflineFolderRunningInfo.itemRemoteId;
        }
        if ((i2 & 4) != 0) {
            map = markForOfflineFolderRunningInfo.childJobMap;
        }
        if ((i2 & 8) != 0) {
            i = markForOfflineFolderRunningInfo.totalFiles;
        }
        if ((i2 & 16) != 0) {
            set = markForOfflineFolderRunningInfo.succeededFiles;
        }
        if ((i2 & 32) != 0) {
            set2 = markForOfflineFolderRunningInfo.failedFiles;
        }
        Set set3 = set;
        Set set4 = set2;
        return markForOfflineFolderRunningInfo.copy(str, remote, map, i, set3, set4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getItemName() {
        return this.itemName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ItemId.Remote getItemRemoteId() {
        return this.itemRemoteId;
    }

    public final Map<String, String> component3() {
        return this.childJobMap;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getTotalFiles() {
        return this.totalFiles;
    }

    public final Set<String> component5() {
        return this.succeededFiles;
    }

    public final Set<String> component6() {
        return this.failedFiles;
    }

    public final MarkForOfflineFolderRunningInfo copy(@Json String itemName, @Json ItemId.Remote itemRemoteId, @Json Map<String, String> childJobMap, @Json int totalFiles, @Json Set<String> succeededFiles, @Json Set<String> failedFiles) {
        Intrinsics.checkNotNullParameter(itemName, "itemName");
        Intrinsics.checkNotNullParameter(itemRemoteId, "itemRemoteId");
        Intrinsics.checkNotNullParameter(childJobMap, "childJobMap");
        Intrinsics.checkNotNullParameter(succeededFiles, "succeededFiles");
        Intrinsics.checkNotNullParameter(failedFiles, "failedFiles");
        return new MarkForOfflineFolderRunningInfo(itemName, itemRemoteId, childJobMap, totalFiles, succeededFiles, failedFiles);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MarkForOfflineFolderRunningInfo)) {
            return false;
        }
        MarkForOfflineFolderRunningInfo markForOfflineFolderRunningInfo = (MarkForOfflineFolderRunningInfo) other;
        return Intrinsics.areEqual(this.itemName, markForOfflineFolderRunningInfo.itemName) && Intrinsics.areEqual(this.itemRemoteId, markForOfflineFolderRunningInfo.itemRemoteId) && Intrinsics.areEqual(this.childJobMap, markForOfflineFolderRunningInfo.childJobMap) && this.totalFiles == markForOfflineFolderRunningInfo.totalFiles && Intrinsics.areEqual(this.succeededFiles, markForOfflineFolderRunningInfo.succeededFiles) && Intrinsics.areEqual(this.failedFiles, markForOfflineFolderRunningInfo.failedFiles);
    }

    public int hashCode() {
        return (((((((((this.itemName.hashCode() * 31) + this.itemRemoteId.hashCode()) * 31) + this.childJobMap.hashCode()) * 31) + Integer.hashCode(this.totalFiles)) * 31) + this.succeededFiles.hashCode()) * 31) + this.failedFiles.hashCode();
    }

    public String toString() {
        return "MarkForOfflineFolderRunningInfo(itemName=" + this.itemName + ", itemRemoteId=" + this.itemRemoteId + ", childJobMap=" + this.childJobMap + ", totalFiles=" + this.totalFiles + ", succeededFiles=" + this.succeededFiles + ", failedFiles=" + this.failedFiles + ")";
    }

    public MarkForOfflineFolderRunningInfo(@Json String itemName, @Json ItemId.Remote itemRemoteId, @Json Map<String, String> childJobMap, @Json int i, @Json Set<String> succeededFiles, @Json Set<String> failedFiles) {
        Intrinsics.checkNotNullParameter(itemName, "itemName");
        Intrinsics.checkNotNullParameter(itemRemoteId, "itemRemoteId");
        Intrinsics.checkNotNullParameter(childJobMap, "childJobMap");
        Intrinsics.checkNotNullParameter(succeededFiles, "succeededFiles");
        Intrinsics.checkNotNullParameter(failedFiles, "failedFiles");
        this.itemName = itemName;
        this.itemRemoteId = itemRemoteId;
        this.childJobMap = childJobMap;
        this.totalFiles = i;
        this.succeededFiles = succeededFiles;
        this.failedFiles = failedFiles;
    }

    public final String getItemName() {
        return this.itemName;
    }

    public final ItemId.Remote getItemRemoteId() {
        return this.itemRemoteId;
    }

    public final Map<String, String> getChildJobMap() {
        return this.childJobMap;
    }

    public final int getTotalFiles() {
        return this.totalFiles;
    }

    public final Set<String> getSucceededFiles() {
        return this.succeededFiles;
    }

    public final Set<String> getFailedFiles() {
        return this.failedFiles;
    }
}
