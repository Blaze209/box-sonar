package com.box.android.domain.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.FileModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaptureHistoryModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/box/android/domain/models/CaptureHistoryModel;", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "jobInfo", "Lcom/box/android/domain/models/JobInfo;", "contentUrl", "", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Lcom/box/android/domain/models/JobInfo;Ljava/lang/String;)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "getJobInfo", "()Lcom/box/android/domain/models/JobInfo;", "getContentUrl", "()Ljava/lang/String;", "setContentUrl", "(Ljava/lang/String;)V", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CaptureHistoryModel {
    private String contentUrl;
    private final FileModel fileModel;
    private final JobInfo jobInfo;

    public static /* synthetic */ CaptureHistoryModel copy$default(CaptureHistoryModel captureHistoryModel, FileModel fileModel, JobInfo jobInfo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            fileModel = captureHistoryModel.fileModel;
        }
        if ((i & 2) != 0) {
            jobInfo = captureHistoryModel.jobInfo;
        }
        if ((i & 4) != 0) {
            str = captureHistoryModel.contentUrl;
        }
        return captureHistoryModel.copy(fileModel, jobInfo, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final FileModel getFileModel() {
        return this.fileModel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final JobInfo getJobInfo() {
        return this.jobInfo;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getContentUrl() {
        return this.contentUrl;
    }

    public final CaptureHistoryModel copy(FileModel fileModel, JobInfo jobInfo, String contentUrl) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        return new CaptureHistoryModel(fileModel, jobInfo, contentUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CaptureHistoryModel)) {
            return false;
        }
        CaptureHistoryModel captureHistoryModel = (CaptureHistoryModel) other;
        return Intrinsics.areEqual(this.fileModel, captureHistoryModel.fileModel) && Intrinsics.areEqual(this.jobInfo, captureHistoryModel.jobInfo) && Intrinsics.areEqual(this.contentUrl, captureHistoryModel.contentUrl);
    }

    public int hashCode() {
        int iHashCode = this.fileModel.hashCode() * 31;
        JobInfo jobInfo = this.jobInfo;
        int iHashCode2 = (iHashCode + (jobInfo == null ? 0 : jobInfo.hashCode())) * 31;
        String str = this.contentUrl;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "CaptureHistoryModel(fileModel=" + this.fileModel + ", jobInfo=" + this.jobInfo + ", contentUrl=" + this.contentUrl + ")";
    }

    public CaptureHistoryModel(FileModel fileModel, JobInfo jobInfo, String str) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        this.fileModel = fileModel;
        this.jobInfo = jobInfo;
        this.contentUrl = str;
    }

    public /* synthetic */ CaptureHistoryModel(FileModel fileModel, JobInfo jobInfo, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fileModel, jobInfo, (i & 4) != 0 ? null : str);
    }

    public final String getContentUrl() {
        return this.contentUrl;
    }

    public final FileModel getFileModel() {
        return this.fileModel;
    }

    public final JobInfo getJobInfo() {
        return this.jobInfo;
    }

    public final void setContentUrl(String str) {
        this.contentUrl = str;
    }
}
