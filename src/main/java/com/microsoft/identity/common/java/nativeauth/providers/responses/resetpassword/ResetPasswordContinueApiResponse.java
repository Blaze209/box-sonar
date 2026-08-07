package com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.nativeauth.providers.INativeAuthApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.util.ApiErrorResponseUtilKt;
import com.microsoft.identity.nativeauth.statemachine.errors.ErrorTypes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResetPasswordContinueApiResponse.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\u0005H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0010¨\u0006#"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordContinueApiResponse;", "Lcom/microsoft/identity/common/java/nativeauth/providers/INativeAuthApiResponse;", "statusCode", "", "correlationId", "", "continuationToken", "expiresIn", "error", "errorDescription", "errorUri", "subError", "challengeType", "redirectReason", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChallengeType", "()Ljava/lang/String;", "getContinuationToken", "getError", "getErrorDescription", "getErrorUri", "getExpiresIn", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRedirectReason", "getStatusCode", "()I", "setStatusCode", "(I)V", "getSubError", "toResult", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordContinueApiResult;", "toString", "toUnsanitizedString", "Companion", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ResetPasswordContinueApiResponse extends INativeAuthApiResponse {
    private static final String TAG = "ResetPasswordContinueApiResponse";

    @SerializedName("challenge_type")
    @Expose
    private final String challengeType;

    @SerializedName(NativeAuthConstants.GrantType.CONTINUATION_TOKEN)
    private final String continuationToken;

    @SerializedName("error")
    private final String error;

    @SerializedName("error_description")
    private final String errorDescription;

    @SerializedName("error_uri")
    private final String errorUri;

    @SerializedName("expires_in")
    @Expose
    private final Integer expiresIn;

    @SerializedName("redirect_reason")
    private final String redirectReason;

    @Expose
    private int statusCode;

    @SerializedName("suberror")
    private final String subError;

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

    public final Integer getExpiresIn() {
        return this.expiresIn;
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

    public final String getSubError() {
        return this.subError;
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
    public ResetPasswordContinueApiResponse(int i, String correlationId, String str, Integer num, String str2, String str3, String str4, String str5, String str6, String str7) {
        super(i, correlationId, str, str6, str7, str2, str3);
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        this.statusCode = i;
        this.continuationToken = str;
        this.expiresIn = num;
        this.error = str2;
        this.errorDescription = str3;
        this.errorUri = str4;
        this.subError = str5;
        this.challengeType = str6;
        this.redirectReason = str7;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "ResetPasswordContinueApiResponse(statusCode=" + getStatusCode() + ", correlationId=" + getCorrelationId() + ", challengeType=" + getChallengeType() + ", expiresIn=" + this.expiresIn + " error=" + getError() + ", errorUri=" + this.errorUri + ", errorDescription=" + getErrorDescription() + ", subError=" + this.subError + ", redirectReason=" + getRedirectReason() + ')';
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return "ResetPasswordContinueApiResponse(statusCode=" + getStatusCode() + ", correlationId=" + getCorrelationId();
    }

    public final ResetPasswordContinueApiResult toResult() {
        int statusCode = getStatusCode();
        if (statusCode == 200) {
            if (ApiErrorResponseUtilKt.isRedirect(getChallengeType())) {
                String correlationId = getCorrelationId();
                String redirectReason = getRedirectReason();
                return new ResetPasswordContinueApiResult.Redirect(correlationId, redirectReason != null ? redirectReason : "");
            }
            String continuationToken = getContinuationToken();
            if (continuationToken != null) {
                return new ResetPasswordContinueApiResult.PasswordRequired(getCorrelationId(), continuationToken, this.expiresIn);
            }
            return new ResetPasswordContinueApiResult.UnknownError(getCorrelationId(), ErrorTypes.INVALID_STATE, "ResetPassword /continue successful, but did not return a continuation token");
        }
        if (statusCode == 400) {
            if (ApiErrorResponseUtilKt.isInvalidGrant(getError())) {
                if (ApiErrorResponseUtilKt.isInvalidOOBValue(this.subError)) {
                    String error = getError();
                    if (error == null) {
                        error = "";
                    }
                    String errorDescription = getErrorDescription();
                    if (errorDescription == null) {
                        errorDescription = "";
                    }
                    String str = this.subError;
                    return new ResetPasswordContinueApiResult.CodeIncorrect(getCorrelationId(), error, errorDescription, str != null ? str : "");
                }
                String error2 = getError();
                if (error2 == null) {
                    error2 = "";
                }
                String errorDescription2 = getErrorDescription();
                return new ResetPasswordContinueApiResult.UnknownError(getCorrelationId(), error2, errorDescription2 != null ? errorDescription2 : "");
            }
            if (ApiErrorResponseUtilKt.isExpiredToken(getError())) {
                String error3 = getError();
                if (error3 == null) {
                    error3 = "";
                }
                String errorDescription3 = getErrorDescription();
                return new ResetPasswordContinueApiResult.ExpiredToken(getCorrelationId(), error3, errorDescription3 != null ? errorDescription3 : "");
            }
            String error4 = getError();
            if (error4 == null) {
                error4 = "";
            }
            String errorDescription4 = getErrorDescription();
            return new ResetPasswordContinueApiResult.UnknownError(getCorrelationId(), error4, errorDescription4 != null ? errorDescription4 : "");
        }
        String error5 = getError();
        if (error5 == null) {
            error5 = "";
        }
        String errorDescription5 = getErrorDescription();
        return new ResetPasswordContinueApiResult.UnknownError(getCorrelationId(), error5, errorDescription5 != null ? errorDescription5 : "");
    }
}
