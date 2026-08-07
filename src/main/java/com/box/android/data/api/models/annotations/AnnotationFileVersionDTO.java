package com.box.android.data.api.models.annotations;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxFile;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnnotationFileVersionDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/box/android/data/api/models/annotations/AnnotationFileVersionDTO;", "", "id", "", "type", "versionNumber", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getId", "()Ljava/lang/String;", "getType", "getVersionNumber", "()I", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AnnotationFileVersionDTO {
    private final String id;
    private final String type;
    private final int versionNumber;

    public static /* synthetic */ AnnotationFileVersionDTO copy$default(AnnotationFileVersionDTO annotationFileVersionDTO, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = annotationFileVersionDTO.id;
        }
        if ((i2 & 2) != 0) {
            str2 = annotationFileVersionDTO.type;
        }
        if ((i2 & 4) != 0) {
            i = annotationFileVersionDTO.versionNumber;
        }
        return annotationFileVersionDTO.copy(str, str2, i);
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
    public final int getVersionNumber() {
        return this.versionNumber;
    }

    public final AnnotationFileVersionDTO copy(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = BoxFile.FIELD_VERSION_NUMBER) int versionNumber) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        return new AnnotationFileVersionDTO(id, type, versionNumber);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnnotationFileVersionDTO)) {
            return false;
        }
        AnnotationFileVersionDTO annotationFileVersionDTO = (AnnotationFileVersionDTO) other;
        return Intrinsics.areEqual(this.id, annotationFileVersionDTO.id) && Intrinsics.areEqual(this.type, annotationFileVersionDTO.type) && this.versionNumber == annotationFileVersionDTO.versionNumber;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + Integer.hashCode(this.versionNumber);
    }

    public String toString() {
        return "AnnotationFileVersionDTO(id=" + this.id + ", type=" + this.type + ", versionNumber=" + this.versionNumber + ")";
    }

    public AnnotationFileVersionDTO(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = BoxFile.FIELD_VERSION_NUMBER) int i) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.type = type;
        this.versionNumber = i;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final int getVersionNumber() {
        return this.versionNumber;
    }
}
