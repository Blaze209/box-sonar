package com.box.android.data.api.models.annotations;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxIterator;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnnotationsDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J6\u0010\u0015\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/box/android/data/api/models/annotations/AnnotationsDTO;", "", "entries", "", "Lcom/box/android/data/api/models/annotations/AnnotationDTO;", BoxIterator.FIELD_LIMIT, "", "nextMarker", "", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;)V", "getEntries", "()Ljava/util/List;", "getLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNextMarker", "()Ljava/lang/String;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;)Lcom/box/android/data/api/models/annotations/AnnotationsDTO;", "equals", "", "other", "hashCode", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AnnotationsDTO {
    private final List<AnnotationDTO> entries;
    private final Integer limit;
    private final String nextMarker;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnnotationsDTO copy$default(AnnotationsDTO annotationsDTO, List list, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = annotationsDTO.entries;
        }
        if ((i & 2) != 0) {
            num = annotationsDTO.limit;
        }
        if ((i & 4) != 0) {
            str = annotationsDTO.nextMarker;
        }
        return annotationsDTO.copy(list, num, str);
    }

    public final List<AnnotationDTO> component1() {
        return this.entries;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getLimit() {
        return this.limit;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getNextMarker() {
        return this.nextMarker;
    }

    public final AnnotationsDTO copy(@Json(name = "entries") List<AnnotationDTO> entries, @Json(name = BoxIterator.FIELD_LIMIT) Integer limit, @Json(name = BoxIterator.FIELD_NEXT_MARKER) String nextMarker) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        return new AnnotationsDTO(entries, limit, nextMarker);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnnotationsDTO)) {
            return false;
        }
        AnnotationsDTO annotationsDTO = (AnnotationsDTO) other;
        return Intrinsics.areEqual(this.entries, annotationsDTO.entries) && Intrinsics.areEqual(this.limit, annotationsDTO.limit) && Intrinsics.areEqual(this.nextMarker, annotationsDTO.nextMarker);
    }

    public int hashCode() {
        int iHashCode = this.entries.hashCode() * 31;
        Integer num = this.limit;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.nextMarker;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "AnnotationsDTO(entries=" + this.entries + ", limit=" + this.limit + ", nextMarker=" + this.nextMarker + ")";
    }

    public AnnotationsDTO(@Json(name = "entries") List<AnnotationDTO> entries, @Json(name = BoxIterator.FIELD_LIMIT) Integer num, @Json(name = BoxIterator.FIELD_NEXT_MARKER) String str) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.entries = entries;
        this.limit = num;
        this.nextMarker = str;
    }

    public final List<AnnotationDTO> getEntries() {
        return this.entries;
    }

    public final Integer getLimit() {
        return this.limit;
    }

    public final String getNextMarker() {
        return this.nextMarker;
    }
}
