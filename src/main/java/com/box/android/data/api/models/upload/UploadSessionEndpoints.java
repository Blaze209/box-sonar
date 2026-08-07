package com.box.android.data.api.models.upload;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxUploadSessionEndpoints;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UploadSessionDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/box/android/data/api/models/upload/UploadSessionEndpoints;", "", "abortEndpoint", "", "commitEndpoint", "listPartsEndpoint", "logEventEndpoint", "statusEndpoint", "uploadPartEndpoint", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAbortEndpoint", "()Ljava/lang/String;", "getCommitEndpoint", "getListPartsEndpoint", "getLogEventEndpoint", "getStatusEndpoint", "getUploadPartEndpoint", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class UploadSessionEndpoints {
    private final String abortEndpoint;
    private final String commitEndpoint;
    private final String listPartsEndpoint;
    private final String logEventEndpoint;
    private final String statusEndpoint;
    private final String uploadPartEndpoint;

    public static /* synthetic */ UploadSessionEndpoints copy$default(UploadSessionEndpoints uploadSessionEndpoints, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = uploadSessionEndpoints.abortEndpoint;
        }
        if ((i & 2) != 0) {
            str2 = uploadSessionEndpoints.commitEndpoint;
        }
        if ((i & 4) != 0) {
            str3 = uploadSessionEndpoints.listPartsEndpoint;
        }
        if ((i & 8) != 0) {
            str4 = uploadSessionEndpoints.logEventEndpoint;
        }
        if ((i & 16) != 0) {
            str5 = uploadSessionEndpoints.statusEndpoint;
        }
        if ((i & 32) != 0) {
            str6 = uploadSessionEndpoints.uploadPartEndpoint;
        }
        String str7 = str5;
        String str8 = str6;
        return uploadSessionEndpoints.copy(str, str2, str3, str4, str7, str8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAbortEndpoint() {
        return this.abortEndpoint;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCommitEndpoint() {
        return this.commitEndpoint;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getListPartsEndpoint() {
        return this.listPartsEndpoint;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLogEventEndpoint() {
        return this.logEventEndpoint;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getStatusEndpoint() {
        return this.statusEndpoint;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getUploadPartEndpoint() {
        return this.uploadPartEndpoint;
    }

    public final UploadSessionEndpoints copy(@Json(name = BoxUploadSessionEndpoints.FIELD_ABORT) String abortEndpoint, @Json(name = BoxUploadSessionEndpoints.FIELD_COMMIT) String commitEndpoint, @Json(name = BoxUploadSessionEndpoints.FIELD_LIST_PARTS) String listPartsEndpoint, @Json(name = "log_event") String logEventEndpoint, @Json(name = "status") String statusEndpoint, @Json(name = BoxUploadSessionEndpoints.FIELD_UPLOAD_PART) String uploadPartEndpoint) {
        Intrinsics.checkNotNullParameter(abortEndpoint, "abortEndpoint");
        Intrinsics.checkNotNullParameter(commitEndpoint, "commitEndpoint");
        Intrinsics.checkNotNullParameter(listPartsEndpoint, "listPartsEndpoint");
        Intrinsics.checkNotNullParameter(logEventEndpoint, "logEventEndpoint");
        Intrinsics.checkNotNullParameter(statusEndpoint, "statusEndpoint");
        Intrinsics.checkNotNullParameter(uploadPartEndpoint, "uploadPartEndpoint");
        return new UploadSessionEndpoints(abortEndpoint, commitEndpoint, listPartsEndpoint, logEventEndpoint, statusEndpoint, uploadPartEndpoint);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadSessionEndpoints)) {
            return false;
        }
        UploadSessionEndpoints uploadSessionEndpoints = (UploadSessionEndpoints) other;
        return Intrinsics.areEqual(this.abortEndpoint, uploadSessionEndpoints.abortEndpoint) && Intrinsics.areEqual(this.commitEndpoint, uploadSessionEndpoints.commitEndpoint) && Intrinsics.areEqual(this.listPartsEndpoint, uploadSessionEndpoints.listPartsEndpoint) && Intrinsics.areEqual(this.logEventEndpoint, uploadSessionEndpoints.logEventEndpoint) && Intrinsics.areEqual(this.statusEndpoint, uploadSessionEndpoints.statusEndpoint) && Intrinsics.areEqual(this.uploadPartEndpoint, uploadSessionEndpoints.uploadPartEndpoint);
    }

    public int hashCode() {
        return (((((((((this.abortEndpoint.hashCode() * 31) + this.commitEndpoint.hashCode()) * 31) + this.listPartsEndpoint.hashCode()) * 31) + this.logEventEndpoint.hashCode()) * 31) + this.statusEndpoint.hashCode()) * 31) + this.uploadPartEndpoint.hashCode();
    }

    public String toString() {
        return "UploadSessionEndpoints(abortEndpoint=" + this.abortEndpoint + ", commitEndpoint=" + this.commitEndpoint + ", listPartsEndpoint=" + this.listPartsEndpoint + ", logEventEndpoint=" + this.logEventEndpoint + ", statusEndpoint=" + this.statusEndpoint + ", uploadPartEndpoint=" + this.uploadPartEndpoint + ")";
    }

    public UploadSessionEndpoints(@Json(name = BoxUploadSessionEndpoints.FIELD_ABORT) String abortEndpoint, @Json(name = BoxUploadSessionEndpoints.FIELD_COMMIT) String commitEndpoint, @Json(name = BoxUploadSessionEndpoints.FIELD_LIST_PARTS) String listPartsEndpoint, @Json(name = "log_event") String logEventEndpoint, @Json(name = "status") String statusEndpoint, @Json(name = BoxUploadSessionEndpoints.FIELD_UPLOAD_PART) String uploadPartEndpoint) {
        Intrinsics.checkNotNullParameter(abortEndpoint, "abortEndpoint");
        Intrinsics.checkNotNullParameter(commitEndpoint, "commitEndpoint");
        Intrinsics.checkNotNullParameter(listPartsEndpoint, "listPartsEndpoint");
        Intrinsics.checkNotNullParameter(logEventEndpoint, "logEventEndpoint");
        Intrinsics.checkNotNullParameter(statusEndpoint, "statusEndpoint");
        Intrinsics.checkNotNullParameter(uploadPartEndpoint, "uploadPartEndpoint");
        this.abortEndpoint = abortEndpoint;
        this.commitEndpoint = commitEndpoint;
        this.listPartsEndpoint = listPartsEndpoint;
        this.logEventEndpoint = logEventEndpoint;
        this.statusEndpoint = statusEndpoint;
        this.uploadPartEndpoint = uploadPartEndpoint;
    }

    public final String getAbortEndpoint() {
        return this.abortEndpoint;
    }

    public final String getCommitEndpoint() {
        return this.commitEndpoint;
    }

    public final String getListPartsEndpoint() {
        return this.listPartsEndpoint;
    }

    public final String getLogEventEndpoint() {
        return this.logEventEndpoint;
    }

    public final String getStatusEndpoint() {
        return this.statusEndpoint;
    }

    public final String getUploadPartEndpoint() {
        return this.uploadPartEndpoint;
    }
}
