package com.microsoft.identity.common.java.nativeauth.providers.responses;

import com.microsoft.identity.nativeauth.statemachine.errors.ErrorTypes;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApiErrorResult.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u000b\b&\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nR\u0014\u0010\t\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiResult;", "error", "", "subError", "errorDescription", "errorCodes", "", "", "correlationId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "getSubError", "Companion", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ApiErrorResult implements ApiResult {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INVALID_STATE = ErrorTypes.INVALID_STATE;
    private final String correlationId;
    private final String error;
    private final List<Integer> errorCodes;
    private final String errorDescription;
    private final String subError;

    public ApiErrorResult(String str, String str2, String str3, List<Integer> list, String correlationId) {
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        this.error = str;
        this.subError = str2;
        this.errorDescription = str3;
        this.errorCodes = list;
        this.correlationId = correlationId;
    }

    public /* synthetic */ ApiErrorResult(String str, String str2, String str3, List list, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, str3, (i & 8) != 0 ? null : list, str4);
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public boolean containsPii() {
        return ApiResult.DefaultImpls.containsPii(this);
    }

    public String getError() {
        return this.error;
    }

    public String getSubError() {
        return this.subError;
    }

    public String getErrorDescription() {
        return this.errorDescription;
    }

    public List<Integer> getErrorCodes() {
        return this.errorCodes;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult
    public String getCorrelationId() {
        return this.correlationId;
    }

    /* JADX INFO: compiled from: ApiErrorResult.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult$Companion;", "", "()V", "INVALID_STATE", "", "getINVALID_STATE", "()Ljava/lang/String;", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getINVALID_STATE() {
            return ApiErrorResult.INVALID_STATE;
        }
    }
}
