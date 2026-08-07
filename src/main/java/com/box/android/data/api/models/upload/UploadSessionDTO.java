package com.box.android.data.api.models.upload;

import com.box.android.data.jobs.ChunkUploadJob;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxUploadSession;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UploadSessionDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\b\u0012\b\b\u0001\u0010\n\u001a\u00020\b\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\fHÆ\u0003JO\u0010!\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\b2\b\b\u0003\u0010\n\u001a\u00020\b2\b\b\u0003\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\bHÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lcom/box/android/data/api/models/upload/UploadSessionDTO;", "", "id", "", "type", "expiresAt", "Ljava/util/Date;", ChunkUploadJob.PART_SIZE_PARAM, "", "totalParts", "numPartsProcessed", "sessionEndpoints", "Lcom/box/android/data/api/models/upload/UploadSessionEndpoints;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;IIILcom/box/android/data/api/models/upload/UploadSessionEndpoints;)V", "getId", "()Ljava/lang/String;", "getType", "getExpiresAt", "()Ljava/util/Date;", "getPartSize", "()I", "getTotalParts", "getNumPartsProcessed", "getSessionEndpoints", "()Lcom/box/android/data/api/models/upload/UploadSessionEndpoints;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class UploadSessionDTO {
    private final Date expiresAt;
    private final String id;
    private final int numPartsProcessed;
    private final int partSize;
    private final UploadSessionEndpoints sessionEndpoints;
    private final int totalParts;
    private final String type;

    public static /* synthetic */ UploadSessionDTO copy$default(UploadSessionDTO uploadSessionDTO, String str, String str2, Date date, int i, int i2, int i3, UploadSessionEndpoints uploadSessionEndpoints, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = uploadSessionDTO.id;
        }
        if ((i4 & 2) != 0) {
            str2 = uploadSessionDTO.type;
        }
        if ((i4 & 4) != 0) {
            date = uploadSessionDTO.expiresAt;
        }
        if ((i4 & 8) != 0) {
            i = uploadSessionDTO.partSize;
        }
        if ((i4 & 16) != 0) {
            i2 = uploadSessionDTO.totalParts;
        }
        if ((i4 & 32) != 0) {
            i3 = uploadSessionDTO.numPartsProcessed;
        }
        if ((i4 & 64) != 0) {
            uploadSessionEndpoints = uploadSessionDTO.sessionEndpoints;
        }
        int i5 = i3;
        UploadSessionEndpoints uploadSessionEndpoints2 = uploadSessionEndpoints;
        int i6 = i2;
        Date date2 = date;
        return uploadSessionDTO.copy(str, str2, date2, i, i6, i5, uploadSessionEndpoints2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Date getExpiresAt() {
        return this.expiresAt;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getPartSize() {
        return this.partSize;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getTotalParts() {
        return this.totalParts;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getNumPartsProcessed() {
        return this.numPartsProcessed;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final UploadSessionEndpoints getSessionEndpoints() {
        return this.sessionEndpoints;
    }

    public final UploadSessionDTO copy(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = BoxUploadSession.FIELD_SESSION_EXPIRES_AT) Date expiresAt, @Json(name = BoxUploadSession.FIELD_PART_SIZE) int partSize, @Json(name = BoxUploadSession.FIELD_TOTAL_PARTS) int totalParts, @Json(name = BoxUploadSession.FIELD_NUM_PARTS_PROCESSED) int numPartsProcessed, @Json(name = BoxUploadSession.FIELD_SESSION_ENDPOINTS) UploadSessionEndpoints sessionEndpoints) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(expiresAt, "expiresAt");
        Intrinsics.checkNotNullParameter(sessionEndpoints, "sessionEndpoints");
        return new UploadSessionDTO(id, type, expiresAt, partSize, totalParts, numPartsProcessed, sessionEndpoints);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadSessionDTO)) {
            return false;
        }
        UploadSessionDTO uploadSessionDTO = (UploadSessionDTO) other;
        return Intrinsics.areEqual(this.id, uploadSessionDTO.id) && Intrinsics.areEqual(this.type, uploadSessionDTO.type) && Intrinsics.areEqual(this.expiresAt, uploadSessionDTO.expiresAt) && this.partSize == uploadSessionDTO.partSize && this.totalParts == uploadSessionDTO.totalParts && this.numPartsProcessed == uploadSessionDTO.numPartsProcessed && Intrinsics.areEqual(this.sessionEndpoints, uploadSessionDTO.sessionEndpoints);
    }

    public int hashCode() {
        return (((((((((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.expiresAt.hashCode()) * 31) + Integer.hashCode(this.partSize)) * 31) + Integer.hashCode(this.totalParts)) * 31) + Integer.hashCode(this.numPartsProcessed)) * 31) + this.sessionEndpoints.hashCode();
    }

    public String toString() {
        return "UploadSessionDTO(id=" + this.id + ", type=" + this.type + ", expiresAt=" + this.expiresAt + ", partSize=" + this.partSize + ", totalParts=" + this.totalParts + ", numPartsProcessed=" + this.numPartsProcessed + ", sessionEndpoints=" + this.sessionEndpoints + ")";
    }

    public UploadSessionDTO(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = BoxUploadSession.FIELD_SESSION_EXPIRES_AT) Date expiresAt, @Json(name = BoxUploadSession.FIELD_PART_SIZE) int i, @Json(name = BoxUploadSession.FIELD_TOTAL_PARTS) int i2, @Json(name = BoxUploadSession.FIELD_NUM_PARTS_PROCESSED) int i3, @Json(name = BoxUploadSession.FIELD_SESSION_ENDPOINTS) UploadSessionEndpoints sessionEndpoints) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(expiresAt, "expiresAt");
        Intrinsics.checkNotNullParameter(sessionEndpoints, "sessionEndpoints");
        this.id = id;
        this.type = type;
        this.expiresAt = expiresAt;
        this.partSize = i;
        this.totalParts = i2;
        this.numPartsProcessed = i3;
        this.sessionEndpoints = sessionEndpoints;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final Date getExpiresAt() {
        return this.expiresAt;
    }

    public final int getPartSize() {
        return this.partSize;
    }

    public final int getTotalParts() {
        return this.totalParts;
    }

    public final int getNumPartsProcessed() {
        return this.numPartsProcessed;
    }

    public final UploadSessionEndpoints getSessionEndpoints() {
        return this.sessionEndpoints;
    }
}
