package com.box.android.data.api.models.upload;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChunkedFileUploadDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/api/models/upload/PartListDTO;", "", "parts", "", "Lcom/box/android/data/api/models/upload/UploadFileChunkDTO;", "<init>", "(Ljava/util/List;)V", "getParts", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PartListDTO {
    private final List<UploadFileChunkDTO> parts;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PartListDTO copy$default(PartListDTO partListDTO, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = partListDTO.parts;
        }
        return partListDTO.copy(list);
    }

    public final List<UploadFileChunkDTO> component1() {
        return this.parts;
    }

    public final PartListDTO copy(@Json(name = "parts") List<UploadFileChunkDTO> parts) {
        Intrinsics.checkNotNullParameter(parts, "parts");
        return new PartListDTO(parts);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PartListDTO) && Intrinsics.areEqual(this.parts, ((PartListDTO) other).parts);
    }

    public int hashCode() {
        return this.parts.hashCode();
    }

    public String toString() {
        return "PartListDTO(parts=" + this.parts + ")";
    }

    public PartListDTO(@Json(name = "parts") List<UploadFileChunkDTO> parts) {
        Intrinsics.checkNotNullParameter(parts, "parts");
        this.parts = parts;
    }

    public final List<UploadFileChunkDTO> getParts() {
        return this.parts;
    }
}
