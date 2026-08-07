package com.box.android.data.api.models.boxai;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;

/* JADX INFO: compiled from: AiCreateSessionDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/box/android/data/api/models/boxai/AiCreateSessionMetadataDTO;", "", "isLargeFile", "", "<init>", "(Z)V", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AiCreateSessionMetadataDTO {
    private final boolean isLargeFile;

    public static /* synthetic */ AiCreateSessionMetadataDTO copy$default(AiCreateSessionMetadataDTO aiCreateSessionMetadataDTO, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = aiCreateSessionMetadataDTO.isLargeFile;
        }
        return aiCreateSessionMetadataDTO.copy(z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsLargeFile() {
        return this.isLargeFile;
    }

    public final AiCreateSessionMetadataDTO copy(@Json(name = "is_large_file") boolean isLargeFile) {
        return new AiCreateSessionMetadataDTO(isLargeFile);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AiCreateSessionMetadataDTO) && this.isLargeFile == ((AiCreateSessionMetadataDTO) other).isLargeFile;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isLargeFile);
    }

    public String toString() {
        return "AiCreateSessionMetadataDTO(isLargeFile=" + this.isLargeFile + ")";
    }

    public AiCreateSessionMetadataDTO(@Json(name = "is_large_file") boolean z) {
        this.isLargeFile = z;
    }

    public final boolean isLargeFile() {
        return this.isLargeFile;
    }
}
