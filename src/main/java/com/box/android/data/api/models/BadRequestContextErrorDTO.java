package com.box.android.data.api.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ErrorDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0001\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J?\u0010\u0014\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/box/android/data/api/models/BadRequestContextErrorDTO;", "", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, "", "name", "message", "validationErrors", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getReason", "()Ljava/lang/String;", "getName", "getMessage", "getValidationErrors", "()Ljava/util/List;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class BadRequestContextErrorDTO {
    private final String message;
    private final String name;
    private final String reason;
    private final List<String> validationErrors;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BadRequestContextErrorDTO copy$default(BadRequestContextErrorDTO badRequestContextErrorDTO, String str, String str2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = badRequestContextErrorDTO.reason;
        }
        if ((i & 2) != 0) {
            str2 = badRequestContextErrorDTO.name;
        }
        if ((i & 4) != 0) {
            str3 = badRequestContextErrorDTO.message;
        }
        if ((i & 8) != 0) {
            list = badRequestContextErrorDTO.validationErrors;
        }
        return badRequestContextErrorDTO.copy(str, str2, str3, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final List<String> component4() {
        return this.validationErrors;
    }

    public final BadRequestContextErrorDTO copy(@Json(name = BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON) String reason, @Json(name = "name") String name, @Json(name = "message") String message, @Json(name = "validation_errors") List<String> validationErrors) {
        return new BadRequestContextErrorDTO(reason, name, message, validationErrors);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BadRequestContextErrorDTO)) {
            return false;
        }
        BadRequestContextErrorDTO badRequestContextErrorDTO = (BadRequestContextErrorDTO) other;
        return Intrinsics.areEqual(this.reason, badRequestContextErrorDTO.reason) && Intrinsics.areEqual(this.name, badRequestContextErrorDTO.name) && Intrinsics.areEqual(this.message, badRequestContextErrorDTO.message) && Intrinsics.areEqual(this.validationErrors, badRequestContextErrorDTO.validationErrors);
    }

    public int hashCode() {
        String str = this.reason;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.message;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<String> list = this.validationErrors;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "BadRequestContextErrorDTO(reason=" + this.reason + ", name=" + this.name + ", message=" + this.message + ", validationErrors=" + this.validationErrors + ")";
    }

    public BadRequestContextErrorDTO(@Json(name = BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON) String str, @Json(name = "name") String str2, @Json(name = "message") String str3, @Json(name = "validation_errors") List<String> list) {
        this.reason = str;
        this.name = str2;
        this.message = str3;
        this.validationErrors = list;
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getName() {
        return this.name;
    }

    public final String getMessage() {
        return this.message;
    }

    public final List<String> getValidationErrors() {
        return this.validationErrors;
    }
}
