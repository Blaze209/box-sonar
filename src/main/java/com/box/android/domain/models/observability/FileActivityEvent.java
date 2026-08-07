package com.box.android.domain.models.observability;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Gen204EventModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/box/android/domain/models/observability/FileActivityEvent;", "Lcom/box/android/domain/models/observability/Gen204Event;", "Lcom/box/android/domain/models/DomainModel;", "fileActivityAction", "", "failReason", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getFileActivityAction", "()Ljava/lang/String;", "getFailReason", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FileActivityEvent extends Gen204Event implements DomainModel {
    private final String failReason;
    private final String fileActivityAction;

    public static /* synthetic */ FileActivityEvent copy$default(FileActivityEvent fileActivityEvent, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fileActivityEvent.fileActivityAction;
        }
        if ((i & 2) != 0) {
            str2 = fileActivityEvent.failReason;
        }
        return fileActivityEvent.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFileActivityAction() {
        return this.fileActivityAction;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFailReason() {
        return this.failReason;
    }

    public final FileActivityEvent copy(String fileActivityAction, String failReason) {
        Intrinsics.checkNotNullParameter(fileActivityAction, "fileActivityAction");
        return new FileActivityEvent(fileActivityAction, failReason);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileActivityEvent)) {
            return false;
        }
        FileActivityEvent fileActivityEvent = (FileActivityEvent) other;
        return Intrinsics.areEqual(this.fileActivityAction, fileActivityEvent.fileActivityAction) && Intrinsics.areEqual(this.failReason, fileActivityEvent.failReason);
    }

    public int hashCode() {
        int iHashCode = this.fileActivityAction.hashCode() * 31;
        String str = this.failReason;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "FileActivityEvent(fileActivityAction=" + this.fileActivityAction + ", failReason=" + this.failReason + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileActivityEvent(String fileActivityAction, String str) {
        super(0L, null, null, 7, null);
        Intrinsics.checkNotNullParameter(fileActivityAction, "fileActivityAction");
        this.fileActivityAction = fileActivityAction;
        this.failReason = str;
    }

    public final String getFailReason() {
        return this.failReason;
    }

    public final String getFileActivityAction() {
        return this.fileActivityAction;
    }
}
