package com.box.android.data.jobs;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MarkForOfflineJob.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0003\u0010\b\u001a\u00020\u0007\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003JI\u0010!\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00072\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\"\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001a¨\u0006'"}, d2 = {"Lcom/box/android/data/jobs/MarkForOfflineRunningInfo;", "", "itemName", "", "itemRemoteId", "Lcom/box/android/domain/models/ItemId$Remote;", "downloadOriginalStatus", "Lcom/box/android/data/jobs/DownloadStatus;", "downloadPreviewStatus", "downloadOriginalJobId", "previewError", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId$Remote;Lcom/box/android/data/jobs/DownloadStatus;Lcom/box/android/data/jobs/DownloadStatus;Ljava/lang/String;Lcom/box/android/domain/models/DomainError;)V", "getItemName", "()Ljava/lang/String;", "getItemRemoteId", "()Lcom/box/android/domain/models/ItemId$Remote;", "getDownloadOriginalStatus", "()Lcom/box/android/data/jobs/DownloadStatus;", "getDownloadPreviewStatus", "getDownloadOriginalJobId", "getPreviewError", "()Lcom/box/android/domain/models/DomainError;", "isOriginalDownloadInProgress", "", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MarkForOfflineRunningInfo {
    private final String downloadOriginalJobId;
    private final DownloadStatus downloadOriginalStatus;
    private final DownloadStatus downloadPreviewStatus;
    private final String itemName;
    private final ItemId.Remote itemRemoteId;
    private final DomainError previewError;

    public static /* synthetic */ MarkForOfflineRunningInfo copy$default(MarkForOfflineRunningInfo markForOfflineRunningInfo, String str, ItemId.Remote remote, DownloadStatus downloadStatus, DownloadStatus downloadStatus2, String str2, DomainError domainError, int i, Object obj) {
        if ((i & 1) != 0) {
            str = markForOfflineRunningInfo.itemName;
        }
        if ((i & 2) != 0) {
            remote = markForOfflineRunningInfo.itemRemoteId;
        }
        if ((i & 4) != 0) {
            downloadStatus = markForOfflineRunningInfo.downloadOriginalStatus;
        }
        if ((i & 8) != 0) {
            downloadStatus2 = markForOfflineRunningInfo.downloadPreviewStatus;
        }
        if ((i & 16) != 0) {
            str2 = markForOfflineRunningInfo.downloadOriginalJobId;
        }
        if ((i & 32) != 0) {
            domainError = markForOfflineRunningInfo.previewError;
        }
        String str3 = str2;
        DomainError domainError2 = domainError;
        return markForOfflineRunningInfo.copy(str, remote, downloadStatus, downloadStatus2, str3, domainError2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getItemName() {
        return this.itemName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ItemId.Remote getItemRemoteId() {
        return this.itemRemoteId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final DownloadStatus getDownloadOriginalStatus() {
        return this.downloadOriginalStatus;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final DownloadStatus getDownloadPreviewStatus() {
        return this.downloadPreviewStatus;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDownloadOriginalJobId() {
        return this.downloadOriginalJobId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final DomainError getPreviewError() {
        return this.previewError;
    }

    public final MarkForOfflineRunningInfo copy(@Json String itemName, @Json ItemId.Remote itemRemoteId, @Json DownloadStatus downloadOriginalStatus, @Json DownloadStatus downloadPreviewStatus, @Json String downloadOriginalJobId, @Json DomainError previewError) {
        Intrinsics.checkNotNullParameter(itemName, "itemName");
        Intrinsics.checkNotNullParameter(itemRemoteId, "itemRemoteId");
        Intrinsics.checkNotNullParameter(downloadOriginalStatus, "downloadOriginalStatus");
        Intrinsics.checkNotNullParameter(downloadPreviewStatus, "downloadPreviewStatus");
        return new MarkForOfflineRunningInfo(itemName, itemRemoteId, downloadOriginalStatus, downloadPreviewStatus, downloadOriginalJobId, previewError);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MarkForOfflineRunningInfo)) {
            return false;
        }
        MarkForOfflineRunningInfo markForOfflineRunningInfo = (MarkForOfflineRunningInfo) other;
        return Intrinsics.areEqual(this.itemName, markForOfflineRunningInfo.itemName) && Intrinsics.areEqual(this.itemRemoteId, markForOfflineRunningInfo.itemRemoteId) && this.downloadOriginalStatus == markForOfflineRunningInfo.downloadOriginalStatus && this.downloadPreviewStatus == markForOfflineRunningInfo.downloadPreviewStatus && Intrinsics.areEqual(this.downloadOriginalJobId, markForOfflineRunningInfo.downloadOriginalJobId) && Intrinsics.areEqual(this.previewError, markForOfflineRunningInfo.previewError);
    }

    public int hashCode() {
        int iHashCode = ((((((this.itemName.hashCode() * 31) + this.itemRemoteId.hashCode()) * 31) + this.downloadOriginalStatus.hashCode()) * 31) + this.downloadPreviewStatus.hashCode()) * 31;
        String str = this.downloadOriginalJobId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        DomainError domainError = this.previewError;
        return iHashCode2 + (domainError != null ? domainError.hashCode() : 0);
    }

    public String toString() {
        return "MarkForOfflineRunningInfo(itemName=" + this.itemName + ", itemRemoteId=" + this.itemRemoteId + ", downloadOriginalStatus=" + this.downloadOriginalStatus + ", downloadPreviewStatus=" + this.downloadPreviewStatus + ", downloadOriginalJobId=" + this.downloadOriginalJobId + ", previewError=" + this.previewError + ")";
    }

    public MarkForOfflineRunningInfo(@Json String itemName, @Json ItemId.Remote itemRemoteId, @Json DownloadStatus downloadOriginalStatus, @Json DownloadStatus downloadPreviewStatus, @Json String str, @Json DomainError domainError) {
        Intrinsics.checkNotNullParameter(itemName, "itemName");
        Intrinsics.checkNotNullParameter(itemRemoteId, "itemRemoteId");
        Intrinsics.checkNotNullParameter(downloadOriginalStatus, "downloadOriginalStatus");
        Intrinsics.checkNotNullParameter(downloadPreviewStatus, "downloadPreviewStatus");
        this.itemName = itemName;
        this.itemRemoteId = itemRemoteId;
        this.downloadOriginalStatus = downloadOriginalStatus;
        this.downloadPreviewStatus = downloadPreviewStatus;
        this.downloadOriginalJobId = str;
        this.previewError = domainError;
    }

    public final String getItemName() {
        return this.itemName;
    }

    public final ItemId.Remote getItemRemoteId() {
        return this.itemRemoteId;
    }

    public /* synthetic */ MarkForOfflineRunningInfo(String str, ItemId.Remote remote, DownloadStatus downloadStatus, DownloadStatus downloadStatus2, String str2, DomainError domainError, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, remote, (i & 4) != 0 ? DownloadStatus.NotStarted : downloadStatus, (i & 8) != 0 ? DownloadStatus.NotStarted : downloadStatus2, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : domainError);
    }

    public final DownloadStatus getDownloadOriginalStatus() {
        return this.downloadOriginalStatus;
    }

    public final DownloadStatus getDownloadPreviewStatus() {
        return this.downloadPreviewStatus;
    }

    public final String getDownloadOriginalJobId() {
        return this.downloadOriginalJobId;
    }

    public final DomainError getPreviewError() {
        return this.previewError;
    }

    public final boolean isOriginalDownloadInProgress() {
        return this.downloadOriginalStatus == DownloadStatus.InProgress;
    }
}
