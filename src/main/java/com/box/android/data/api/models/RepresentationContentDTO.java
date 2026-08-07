package com.box.android.data.api.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxRepresentation;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RepresentationDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/api/models/RepresentationContentDTO;", "", "urlTemplate", "", "<init>", "(Ljava/lang/String;)V", "getUrlTemplate", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class RepresentationContentDTO {
    private final String urlTemplate;

    public static /* synthetic */ RepresentationContentDTO copy$default(RepresentationContentDTO representationContentDTO, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = representationContentDTO.urlTemplate;
        }
        return representationContentDTO.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrlTemplate() {
        return this.urlTemplate;
    }

    public final RepresentationContentDTO copy(@Json(name = BoxRepresentation.BoxRepContent.FIELD_URL) String urlTemplate) {
        Intrinsics.checkNotNullParameter(urlTemplate, "urlTemplate");
        return new RepresentationContentDTO(urlTemplate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RepresentationContentDTO) && Intrinsics.areEqual(this.urlTemplate, ((RepresentationContentDTO) other).urlTemplate);
    }

    public int hashCode() {
        return this.urlTemplate.hashCode();
    }

    public String toString() {
        return "RepresentationContentDTO(urlTemplate=" + this.urlTemplate + ")";
    }

    public RepresentationContentDTO(@Json(name = BoxRepresentation.BoxRepContent.FIELD_URL) String urlTemplate) {
        Intrinsics.checkNotNullParameter(urlTemplate, "urlTemplate");
        this.urlTemplate = urlTemplate;
    }

    public final String getUrlTemplate() {
        return this.urlTemplate;
    }
}
