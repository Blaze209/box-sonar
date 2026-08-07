package com.box.android.data.api.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxError;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ErrorDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001:\u0001&BU\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003JW\u0010\u001f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0016\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006'"}, d2 = {"Lcom/box/android/data/api/models/ErrorDTO;", "Lcom/box/android/data/api/models/IErrorDTO;", "type", "", "status", "", "code", "requestId", "message", "helpUrl", "contextInfo", "Lcom/box/android/data/api/models/ErrorDTO$ContextInfo;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/ErrorDTO$ContextInfo;)V", "getType", "()Ljava/lang/String;", "getStatus", "()I", "getCode", "getRequestId", "getMessage", "getHelpUrl", "getContextInfo", "()Lcom/box/android/data/api/models/ErrorDTO$ContextInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "ContextInfo", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ErrorDTO implements IErrorDTO {
    private final String code;
    private final ContextInfo contextInfo;
    private final String helpUrl;
    private final String message;
    private final String requestId;
    private final int status;
    private final String type;

    public static /* synthetic */ ErrorDTO copy$default(ErrorDTO errorDTO, String str, int i, String str2, String str3, String str4, String str5, ContextInfo contextInfo, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = errorDTO.type;
        }
        if ((i2 & 2) != 0) {
            i = errorDTO.status;
        }
        if ((i2 & 4) != 0) {
            str2 = errorDTO.code;
        }
        if ((i2 & 8) != 0) {
            str3 = errorDTO.requestId;
        }
        if ((i2 & 16) != 0) {
            str4 = errorDTO.message;
        }
        if ((i2 & 32) != 0) {
            str5 = errorDTO.helpUrl;
        }
        if ((i2 & 64) != 0) {
            contextInfo = errorDTO.contextInfo;
        }
        String str6 = str5;
        ContextInfo contextInfo2 = contextInfo;
        String str7 = str4;
        String str8 = str2;
        return errorDTO.copy(str, i, str8, str3, str7, str6, contextInfo2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getHelpUrl() {
        return this.helpUrl;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final ContextInfo getContextInfo() {
        return this.contextInfo;
    }

    public final ErrorDTO copy(@Json(name = "type") String type, @Json(name = "status") int status, @Json(name = "code") String code, @Json(name = BoxError.FIELD_REQUEST_ID) String requestId, @Json(name = "message") String message, @Json(name = BoxError.FIELD_HELP_URL) String helpUrl, @Json(name = "context_info") ContextInfo contextInfo) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(code, "code");
        return new ErrorDTO(type, status, code, requestId, message, helpUrl, contextInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ErrorDTO)) {
            return false;
        }
        ErrorDTO errorDTO = (ErrorDTO) other;
        return Intrinsics.areEqual(this.type, errorDTO.type) && this.status == errorDTO.status && Intrinsics.areEqual(this.code, errorDTO.code) && Intrinsics.areEqual(this.requestId, errorDTO.requestId) && Intrinsics.areEqual(this.message, errorDTO.message) && Intrinsics.areEqual(this.helpUrl, errorDTO.helpUrl) && Intrinsics.areEqual(this.contextInfo, errorDTO.contextInfo);
    }

    public int hashCode() {
        int iHashCode = ((((this.type.hashCode() * 31) + Integer.hashCode(this.status)) * 31) + this.code.hashCode()) * 31;
        String str = this.requestId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.message;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.helpUrl;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        ContextInfo contextInfo = this.contextInfo;
        return iHashCode4 + (contextInfo != null ? contextInfo.hashCode() : 0);
    }

    public String toString() {
        return "ErrorDTO(type=" + this.type + ", status=" + this.status + ", code=" + this.code + ", requestId=" + this.requestId + ", message=" + this.message + ", helpUrl=" + this.helpUrl + ", contextInfo=" + this.contextInfo + ")";
    }

    public ErrorDTO(@Json(name = "type") String type, @Json(name = "status") int i, @Json(name = "code") String code, @Json(name = BoxError.FIELD_REQUEST_ID) String str, @Json(name = "message") String str2, @Json(name = BoxError.FIELD_HELP_URL) String str3, @Json(name = "context_info") ContextInfo contextInfo) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(code, "code");
        this.type = type;
        this.status = i;
        this.code = code;
        this.requestId = str;
        this.message = str2;
        this.helpUrl = str3;
        this.contextInfo = contextInfo;
    }

    @Override // com.box.android.data.api.models.IErrorDTO
    public String getType() {
        return this.type;
    }

    @Override // com.box.android.data.api.models.IErrorDTO
    public int getStatus() {
        return this.status;
    }

    @Override // com.box.android.data.api.models.IErrorDTO
    public String getCode() {
        return this.code;
    }

    @Override // com.box.android.data.api.models.IErrorDTO
    public String getRequestId() {
        return this.requestId;
    }

    @Override // com.box.android.data.api.models.IErrorDTO
    public String getMessage() {
        return this.message;
    }

    @Override // com.box.android.data.api.models.IErrorDTO
    public String getHelpUrl() {
        return this.helpUrl;
    }

    public final ContextInfo getContextInfo() {
        return this.contextInfo;
    }

    /* JADX INFO: compiled from: ErrorDTO.kt */
    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u001c\b\u0001\u0010\u0002\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u0003HÆ\u0003J'\u0010\u000b\u001a\u00020\u00002\u001c\b\u0003\u0010\u0002\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R%\u0010\u0002\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/api/models/ErrorDTO$ContextInfo;", "Lcom/box/android/data/api/models/IContextInfo;", "conflicts", "", "", "", "<init>", "(Ljava/util/List;)V", "getConflicts", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ContextInfo implements IContextInfo {
        private final List<Map<String, String>> conflicts;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ContextInfo copy$default(ContextInfo contextInfo, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = contextInfo.conflicts;
            }
            return contextInfo.copy(list);
        }

        public final List<Map<String, String>> component1() {
            return this.conflicts;
        }

        public final ContextInfo copy(@Json(name = "conflicts") List<? extends Map<String, String>> conflicts) {
            return new ContextInfo(conflicts);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ContextInfo) && Intrinsics.areEqual(this.conflicts, ((ContextInfo) other).conflicts);
        }

        public int hashCode() {
            List<Map<String, String>> list = this.conflicts;
            if (list == null) {
                return 0;
            }
            return list.hashCode();
        }

        public String toString() {
            return "ContextInfo(conflicts=" + this.conflicts + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ContextInfo(@Json(name = "conflicts") List<? extends Map<String, String>> list) {
            this.conflicts = list;
        }

        public final List<Map<String, String>> getConflicts() {
            return this.conflicts;
        }
    }
}
