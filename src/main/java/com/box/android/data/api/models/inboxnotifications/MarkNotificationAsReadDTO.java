package com.box.android.data.api.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.requests.BoxRequestsMetadata;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MarkNotificationAsReadDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/api/models/inboxnotifications/MarkNotificationAsReadDTO;", "", BoxRequestsMetadata.UpdateItemMetadata.BoxMetadataUpdateTask.OPERATION, "", "path", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getOp", "()Ljava/lang/String;", "getPath", "getValue", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MarkNotificationAsReadDTO {
    private final String op;
    private final String path;
    private final String value;

    public MarkNotificationAsReadDTO() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ MarkNotificationAsReadDTO copy$default(MarkNotificationAsReadDTO markNotificationAsReadDTO, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = markNotificationAsReadDTO.op;
        }
        if ((i & 2) != 0) {
            str2 = markNotificationAsReadDTO.path;
        }
        if ((i & 4) != 0) {
            str3 = markNotificationAsReadDTO.value;
        }
        return markNotificationAsReadDTO.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOp() {
        return this.op;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public final MarkNotificationAsReadDTO copy(@Json(name = BoxRequestsMetadata.UpdateItemMetadata.BoxMetadataUpdateTask.OPERATION) String op, @Json(name = "path") String path, @Json(name = "value") String value) {
        Intrinsics.checkNotNullParameter(op, "op");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(value, "value");
        return new MarkNotificationAsReadDTO(op, path, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MarkNotificationAsReadDTO)) {
            return false;
        }
        MarkNotificationAsReadDTO markNotificationAsReadDTO = (MarkNotificationAsReadDTO) other;
        return Intrinsics.areEqual(this.op, markNotificationAsReadDTO.op) && Intrinsics.areEqual(this.path, markNotificationAsReadDTO.path) && Intrinsics.areEqual(this.value, markNotificationAsReadDTO.value);
    }

    public int hashCode() {
        return (((this.op.hashCode() * 31) + this.path.hashCode()) * 31) + this.value.hashCode();
    }

    public String toString() {
        return "MarkNotificationAsReadDTO(op=" + this.op + ", path=" + this.path + ", value=" + this.value + ")";
    }

    public MarkNotificationAsReadDTO(@Json(name = BoxRequestsMetadata.UpdateItemMetadata.BoxMetadataUpdateTask.OPERATION) String op, @Json(name = "path") String path, @Json(name = "value") String value) {
        Intrinsics.checkNotNullParameter(op, "op");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(value, "value");
        this.op = op;
        this.path = path;
        this.value = value;
    }

    public /* synthetic */ MarkNotificationAsReadDTO(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "replace" : str, (i & 2) != 0 ? "/is_read" : str2, (i & 4) != 0 ? TelemetryEventStrings.Value.TRUE : str3);
    }

    public final String getOp() {
        return this.op;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getValue() {
        return this.value;
    }
}
