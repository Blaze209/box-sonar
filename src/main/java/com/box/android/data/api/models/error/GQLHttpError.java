package com.box.android.data.api.models.error;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLHttpErrorModels.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/box/android/data/api/models/error/GQLHttpError;", "", "message", "", "extensions", "Lcom/box/android/data/api/models/error/GQLHttpErrorExtensions;", "code", "<init>", "(Ljava/lang/String;Lcom/box/android/data/api/models/error/GQLHttpErrorExtensions;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getExtensions", "()Lcom/box/android/data/api/models/error/GQLHttpErrorExtensions;", "getCode", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class GQLHttpError {
    private final String code;
    private final GQLHttpErrorExtensions extensions;
    private final String message;

    public static /* synthetic */ GQLHttpError copy$default(GQLHttpError gQLHttpError, String str, GQLHttpErrorExtensions gQLHttpErrorExtensions, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gQLHttpError.message;
        }
        if ((i & 2) != 0) {
            gQLHttpErrorExtensions = gQLHttpError.extensions;
        }
        if ((i & 4) != 0) {
            str2 = gQLHttpError.code;
        }
        return gQLHttpError.copy(str, gQLHttpErrorExtensions, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final GQLHttpErrorExtensions getExtensions() {
        return this.extensions;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    public final GQLHttpError copy(String message, GQLHttpErrorExtensions extensions, String code) {
        return new GQLHttpError(message, extensions, code);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GQLHttpError)) {
            return false;
        }
        GQLHttpError gQLHttpError = (GQLHttpError) other;
        return Intrinsics.areEqual(this.message, gQLHttpError.message) && Intrinsics.areEqual(this.extensions, gQLHttpError.extensions) && Intrinsics.areEqual(this.code, gQLHttpError.code);
    }

    public int hashCode() {
        String str = this.message;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        GQLHttpErrorExtensions gQLHttpErrorExtensions = this.extensions;
        int iHashCode2 = (iHashCode + (gQLHttpErrorExtensions == null ? 0 : gQLHttpErrorExtensions.hashCode())) * 31;
        String str2 = this.code;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "GQLHttpError(message=" + this.message + ", extensions=" + this.extensions + ", code=" + this.code + ")";
    }

    public GQLHttpError(String str, GQLHttpErrorExtensions gQLHttpErrorExtensions, String str2) {
        this.message = str;
        this.extensions = gQLHttpErrorExtensions;
        this.code = str2;
    }

    public final String getCode() {
        return this.code;
    }

    public final GQLHttpErrorExtensions getExtensions() {
        return this.extensions;
    }

    public final String getMessage() {
        return this.message;
    }
}
