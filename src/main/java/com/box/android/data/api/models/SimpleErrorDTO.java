package com.box.android.data.api.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ErrorDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J<\u0010\u0017\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/box/android/data/api/models/SimpleErrorDTO;", "", "status", "", "code", "", "message", "contextInfo", "Lcom/box/android/data/api/models/ErrorDTO$ContextInfo;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/ErrorDTO$ContextInfo;)V", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCode", "()Ljava/lang/String;", "getMessage", "getContextInfo", "()Lcom/box/android/data/api/models/ErrorDTO$ContextInfo;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/ErrorDTO$ContextInfo;)Lcom/box/android/data/api/models/SimpleErrorDTO;", "equals", "", "other", "hashCode", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SimpleErrorDTO {
    private final String code;
    private final ErrorDTO.ContextInfo contextInfo;
    private final String message;
    private final Integer status;

    public static /* synthetic */ SimpleErrorDTO copy$default(SimpleErrorDTO simpleErrorDTO, Integer num, String str, String str2, ErrorDTO.ContextInfo contextInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            num = simpleErrorDTO.status;
        }
        if ((i & 2) != 0) {
            str = simpleErrorDTO.code;
        }
        if ((i & 4) != 0) {
            str2 = simpleErrorDTO.message;
        }
        if ((i & 8) != 0) {
            contextInfo = simpleErrorDTO.contextInfo;
        }
        return simpleErrorDTO.copy(num, str, str2, contextInfo);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ErrorDTO.ContextInfo getContextInfo() {
        return this.contextInfo;
    }

    public final SimpleErrorDTO copy(@Json(name = "status") Integer status, @Json(name = "code") String code, @Json(name = "message") String message, @Json(name = "context_info") ErrorDTO.ContextInfo contextInfo) {
        Intrinsics.checkNotNullParameter(code, "code");
        return new SimpleErrorDTO(status, code, message, contextInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SimpleErrorDTO)) {
            return false;
        }
        SimpleErrorDTO simpleErrorDTO = (SimpleErrorDTO) other;
        return Intrinsics.areEqual(this.status, simpleErrorDTO.status) && Intrinsics.areEqual(this.code, simpleErrorDTO.code) && Intrinsics.areEqual(this.message, simpleErrorDTO.message) && Intrinsics.areEqual(this.contextInfo, simpleErrorDTO.contextInfo);
    }

    public int hashCode() {
        Integer num = this.status;
        int iHashCode = (((num == null ? 0 : num.hashCode()) * 31) + this.code.hashCode()) * 31;
        String str = this.message;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        ErrorDTO.ContextInfo contextInfo = this.contextInfo;
        return iHashCode2 + (contextInfo != null ? contextInfo.hashCode() : 0);
    }

    public String toString() {
        return "SimpleErrorDTO(status=" + this.status + ", code=" + this.code + ", message=" + this.message + ", contextInfo=" + this.contextInfo + ")";
    }

    public SimpleErrorDTO(@Json(name = "status") Integer num, @Json(name = "code") String code, @Json(name = "message") String str, @Json(name = "context_info") ErrorDTO.ContextInfo contextInfo) {
        Intrinsics.checkNotNullParameter(code, "code");
        this.status = num;
        this.code = code;
        this.message = str;
        this.contextInfo = contextInfo;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final ErrorDTO.ContextInfo getContextInfo() {
        return this.contextInfo;
    }
}
