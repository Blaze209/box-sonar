package com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.nativeauth.providers.INativeAuthApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.util.ApiErrorResponseUtilKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResetPasswordPollCompletionApiResponse.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0001$Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000fJ\u0006\u0010 \u001a\u00020!J\b\u0010\"\u001a\u00020\u0005H\u0016J\b\u0010#\u001a\u00020\u0005H\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0011¨\u0006%"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordPollCompletionApiResponse;", "Lcom/microsoft/identity/common/java/nativeauth/providers/INativeAuthApiResponse;", "statusCode", "", "correlationId", "", "continuationToken", "status", "expiresIn", "error", "errorDescription", "errorUri", "subError", "challengeType", "redirectReason", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChallengeType", "()Ljava/lang/String;", "getContinuationToken", "getError", "getErrorDescription", "getErrorUri", "getExpiresIn", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRedirectReason", "getStatus", "getStatusCode", "()I", "setStatusCode", "(I)V", "getSubError", "toResult", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordPollCompletionApiResult;", "toString", "toUnsanitizedString", "Companion", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ResetPasswordPollCompletionApiResponse extends INativeAuthApiResponse {
    private static final String TAG = "ResetPasswordPollCompletionApiResponse";

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
    private final Integer expiresIn;

    @SerializedName("redirect_reason")
    private final String redirectReason;

    @SerializedName("status")
    @Expose
    private final String status;

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

    public final String getStatus() {
        return this.status;
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
    public ResetPasswordPollCompletionApiResponse(int i, String correlationId, String str, String str2, Integer num, String str3, String str4, String str5, String str6, String str7, String str8) {
        super(i, correlationId, str, str7, str8, str3, str4);
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        this.statusCode = i;
        this.continuationToken = str;
        this.status = str2;
        this.expiresIn = num;
        this.error = str3;
        this.errorDescription = str4;
        this.errorUri = str5;
        this.subError = str6;
        this.challengeType = str7;
        this.redirectReason = str8;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "ResetPasswordPollCompletionApiResponse(statusCode=" + getStatusCode() + ", correlationId=" + getCorrelationId() + ", status=" + this.status + ", expiresIn=" + this.expiresIn + " error=" + getError() + ", errorUri=" + this.errorUri + ", errorDescription=" + getErrorDescription() + ", subError=" + this.subError + ", challengeType=" + getChallengeType() + ", redirectReason=" + getRedirectReason() + ')';
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return "ResetPasswordPollCompletionApiResponse(statusCode=" + getStatusCode() + ", correlationId=" + getCorrelationId();
    }

    public final ResetPasswordPollCompletionApiResult toResult() {
        int statusCode = getStatusCode();
        if (statusCode == 200) {
            if (ApiErrorResponseUtilKt.isRedirect(getChallengeType())) {
                String correlationId = getCorrelationId();
                String redirectReason = getRedirectReason();
                return new ResetPasswordPollCompletionApiResult.Redirect(correlationId, redirectReason != null ? redirectReason : "");
            }
            if (ApiErrorResponseUtilKt.isPollInProgress(this.status)) {
                String correlationId2 = getCorrelationId();
                String errorDescription = getErrorDescription();
                return new ResetPasswordPollCompletionApiResult.InProgress(correlationId2, errorDescription != null ? errorDescription : "");
            }
            if (ApiErrorResponseUtilKt.isPollSucceeded(this.status)) {
                return new ResetPasswordPollCompletionApiResult.PollingSucceeded(getContinuationToken(), this.expiresIn, getCorrelationId());
            }
            String error = getError();
            if (error == null) {
                error = "";
            }
            String errorDescription2 = getErrorDescription();
            return new ResetPasswordPollCompletionApiResult.PollingFailed(error, errorDescription2 != null ? errorDescription2 : "", getCorrelationId());
        }
        if (statusCode == 400) {
            if (ApiErrorResponseUtilKt.isInvalidGrant(getError())) {
                if (ApiErrorResponseUtilKt.isPasswordBanned(this.subError) || ApiErrorResponseUtilKt.isPasswordTooShort(this.subError) || ApiErrorResponseUtilKt.isPasswordTooLong(this.subError) || ApiErrorResponseUtilKt.isPasswordRecentlyUsed(this.subError) || ApiErrorResponseUtilKt.isPasswordTooWeak(this.subError) || ApiErrorResponseUtilKt.isPasswordInvalid(this.subError)) {
                    String error2 = getError();
                    if (error2 == null) {
                        error2 = "";
                    }
                    String errorDescription3 = getErrorDescription();
                    if (errorDescription3 == null) {
                        errorDescription3 = "";
                    }
                    String str = this.subError;
                    return new ResetPasswordPollCompletionApiResult.PasswordInvalid(getCorrelationId(), error2, errorDescription3, str != null ? str : "");
                }
                String error3 = getError();
                if (error3 == null) {
                    error3 = "";
                }
                String errorDescription4 = getErrorDescription();
                return new ResetPasswordPollCompletionApiResult.UnknownError(getCorrelationId(), error3, errorDescription4 != null ? errorDescription4 : "");
            }
            if (ApiErrorResponseUtilKt.isExpiredToken(getError())) {
                String error4 = getError();
                if (error4 == null) {
                    error4 = "";
                }
                String errorDescription5 = getErrorDescription();
                return new ResetPasswordPollCompletionApiResult.ExpiredToken(getCorrelationId(), error4, errorDescription5 != null ? errorDescription5 : "");
            }
            if (ApiErrorResponseUtilKt.isUserNotFound(getError())) {
                String error5 = getError();
                if (error5 == null) {
                    error5 = "";
                }
                String errorDescription6 = getErrorDescription();
                return new ResetPasswordPollCompletionApiResult.UserNotFound(getCorrelationId(), error5, errorDescription6 != null ? errorDescription6 : "");
            }
            String error6 = getError();
            if (error6 == null) {
                error6 = "";
            }
            String errorDescription7 = getErrorDescription();
            return new ResetPasswordPollCompletionApiResult.UnknownError(getCorrelationId(), error6, errorDescription7 != null ? errorDescription7 : "");
        }
        String error7 = getError();
        if (error7 == null) {
            error7 = "";
        }
        String errorDescription8 = getErrorDescription();
        return new ResetPasswordPollCompletionApiResult.UnknownError(getCorrelationId(), error7, errorDescription8 != null ? errorDescription8 : "");
    }
}
