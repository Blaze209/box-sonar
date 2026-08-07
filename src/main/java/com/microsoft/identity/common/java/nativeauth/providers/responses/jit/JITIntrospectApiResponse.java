package com.microsoft.identity.common.java.nativeauth.providers.responses.jit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.nativeauth.providers.INativeAuthApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.AuthenticationMethodApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.AuthenticationMethodApiResponseKt;
import com.microsoft.identity.common.java.nativeauth.util.ApiErrorResponseUtilKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JITIntrospectApiResponse.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0010J\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\u0005H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/jit/JITIntrospectApiResponse;", "Lcom/microsoft/identity/common/java/nativeauth/providers/INativeAuthApiResponse;", "statusCode", "", "correlationId", "", "continuationToken", "methods", "", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/AuthenticationMethodApiResponse;", "error", "errorDescription", "errorUri", "errorCodes", "challengeType", "redirectReason", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getChallengeType", "()Ljava/lang/String;", "getContinuationToken", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "getErrorUri", "getMethods", "getRedirectReason", "getStatusCode", "()I", "setStatusCode", "(I)V", "toResult", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/jit/JITIntrospectApiResult;", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class JITIntrospectApiResponse extends INativeAuthApiResponse {

    @SerializedName("challenge_type")
    @Expose
    private final String challengeType;

    @SerializedName(NativeAuthConstants.GrantType.CONTINUATION_TOKEN)
    private final String continuationToken;

    @SerializedName("error")
    private final String error;

    @SerializedName("error_codes")
    private final List<Integer> errorCodes;

    @SerializedName("error_description")
    private final String errorDescription;

    @SerializedName("error_uri")
    private final String errorUri;

    @SerializedName("methods")
    @Expose
    private final List<AuthenticationMethodApiResponse> methods;

    @SerializedName("redirect_reason")
    private final String redirectReason;

    @Expose
    private int statusCode;

    @Override // com.microsoft.identity.common.java.nativeauth.providers.INativeAuthApiResponse
    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int i) {
        this.statusCode = i;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.INativeAuthApiResponse
    public String getContinuationToken() {
        return this.continuationToken;
    }

    public final List<AuthenticationMethodApiResponse> getMethods() {
        return this.methods;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.INativeAuthApiResponse
    public String getError() {
        return this.error;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.INativeAuthApiResponse
    public String getErrorDescription() {
        return this.errorDescription;
    }

    public final String getErrorUri() {
        return this.errorUri;
    }

    public final List<Integer> getErrorCodes() {
        return this.errorCodes;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.INativeAuthApiResponse
    public String getChallengeType() {
        return this.challengeType;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.INativeAuthApiResponse
    public String getRedirectReason() {
        return this.redirectReason;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JITIntrospectApiResponse(int i, String correlationId, String str, List<AuthenticationMethodApiResponse> list, String str2, String str3, String str4, List<Integer> list2, String str5, String str6) {
        super(i, correlationId, str, str5, str6, str2, str3);
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        this.statusCode = i;
        this.continuationToken = str;
        this.methods = list;
        this.error = str2;
        this.errorDescription = str3;
        this.errorUri = str4;
        this.errorCodes = list2;
        this.challengeType = str5;
        this.redirectReason = str6;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "JITIntrospectApiResponse(statusCode=" + getStatusCode() + ", correlationId=" + getCorrelationId() + " error=" + getError() + ", errorCodes=" + this.errorCodes + ", errorDescription=" + getErrorDescription() + ", methods=" + this.methods + ", challengeType=" + getChallengeType() + ", redirectReason=" + getRedirectReason() + ')';
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return "JITIntrospectApiResponse(statusCode=" + getStatusCode() + ", correlationId=" + getCorrelationId();
    }

    public final JITIntrospectApiResult toResult() {
        String str;
        int statusCode = getStatusCode();
        if (statusCode != 200) {
            if (statusCode == 400) {
                String error = getError();
                if (error == null) {
                    error = "";
                }
                String errorDescription = getErrorDescription();
                str = errorDescription != null ? errorDescription : "";
                List<Integer> listEmptyList = this.errorCodes;
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                return new JITIntrospectApiResult.UnknownError(getCorrelationId(), error, str, listEmptyList);
            }
            String error2 = getError();
            if (error2 == null) {
                error2 = "";
            }
            String errorDescription2 = getErrorDescription();
            str = errorDescription2 != null ? errorDescription2 : "";
            List<Integer> listEmptyList2 = this.errorCodes;
            if (listEmptyList2 == null) {
                listEmptyList2 = CollectionsKt.emptyList();
            }
            return new JITIntrospectApiResult.UnknownError(getCorrelationId(), error2, str, listEmptyList2);
        }
        if (ApiErrorResponseUtilKt.isRedirect(getChallengeType())) {
            String correlationId = getCorrelationId();
            String redirectReason = getRedirectReason();
            return new JITIntrospectApiResult.Redirect(correlationId, redirectReason != null ? redirectReason : "");
        }
        List<AuthenticationMethodApiResponse> list = this.methods;
        if (list == null || list.isEmpty()) {
            String invalid_state = ApiErrorResult.INSTANCE.getINVALID_STATE();
            List<Integer> listEmptyList3 = this.errorCodes;
            if (listEmptyList3 == null) {
                listEmptyList3 = CollectionsKt.emptyList();
            }
            return new JITIntrospectApiResult.UnknownError(getCorrelationId(), invalid_state, "register/introspect did not return methods", listEmptyList3);
        }
        try {
            String correlationId2 = getCorrelationId();
            String continuationToken = getContinuationToken();
            if (continuationToken != null) {
                return new JITIntrospectApiResult.Success(correlationId2, continuationToken, AuthenticationMethodApiResponseKt.toListOfAuthenticationMethodApiResult(this.methods));
            }
            String invalid_state2 = ApiErrorResult.INSTANCE.getINVALID_STATE();
            List<Integer> listEmptyList4 = this.errorCodes;
            if (listEmptyList4 == null) {
                listEmptyList4 = CollectionsKt.emptyList();
            }
            return new JITIntrospectApiResult.UnknownError(getCorrelationId(), invalid_state2, "register/introspect did not return a continuation token", listEmptyList4);
        } catch (IllegalStateException e) {
            String invalid_state3 = ApiErrorResult.INSTANCE.getINVALID_STATE();
            String str2 = "register/introspect did not return valid methods: " + e.getMessage();
            List<Integer> listEmptyList5 = this.errorCodes;
            if (listEmptyList5 == null) {
                listEmptyList5 = CollectionsKt.emptyList();
            }
            return new JITIntrospectApiResult.UnknownError(getCorrelationId(), invalid_state3, str2, listEmptyList5);
        }
    }
}
