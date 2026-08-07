package com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.nativeauth.providers.INativeAuthApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.util.ApiErrorResponseUtilKt;
import com.microsoft.identity.nativeauth.statemachine.errors.ErrorTypes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResetPasswordSubmitApiResponse.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\u00020\u0001:\u0001%Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000eJ\u0017\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0002\u0010 J\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\u0005H\u0016J\b\u0010$\u001a\u00020\u0005H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0010¨\u0006&"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordSubmitApiResponse;", "Lcom/microsoft/identity/common/java/nativeauth/providers/INativeAuthApiResponse;", "statusCode", "", "correlationId", "", "continuationToken", "pollInterval", "error", "errorDescription", "errorUri", "subError", "challengeType", "redirectReason", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChallengeType", "()Ljava/lang/String;", "getContinuationToken", "getError", "getErrorDescription", "getErrorUri", "getPollInterval", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRedirectReason", "getStatusCode", "()I", "setStatusCode", "(I)V", "getSubError", "clampPollInterval", "pollIntervalInSeconds", "(Ljava/lang/Integer;)I", "toResult", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordSubmitApiResult;", "toString", "toUnsanitizedString", "Companion", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ResetPasswordSubmitApiResponse extends INativeAuthApiResponse {
    private static final int DEFAULT_POLL_COMPLETION_INTERVAL_IN_SECONDS = 2;
    private static final int MAXIMUM_POLL_COMPLETION_INTERVAL_IN_SECONDS = 15;
    private static final int MINIMUM_POLL_COMPLETION_INTERVAL_IN_SECONDS = 1;

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

    @SerializedName("poll_interval")
    @Expose
    private final Integer pollInterval;

    @SerializedName("redirect_reason")
    private final String redirectReason;

    @Expose
    private int statusCode;

    @SerializedName("suberror")
    private final String subError;
    private static final String TAG = "ResetPasswordSubmitApiResponse";

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

    public final Integer getPollInterval() {
        return this.pollInterval;
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
    public ResetPasswordSubmitApiResponse(int i, String correlationId, String str, Integer num, String str2, String str3, String str4, String str5, String str6, String str7) {
        super(i, correlationId, str, str6, str7, str2, str3);
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        this.statusCode = i;
        this.continuationToken = str;
        this.pollInterval = num;
        this.error = str2;
        this.errorDescription = str3;
        this.errorUri = str4;
        this.subError = str5;
        this.challengeType = str6;
        this.redirectReason = str7;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "ResetPasswordSubmitApiResponse(statusCode=" + getStatusCode() + ", correlationId=" + getCorrelationId() + ", pollInterval=" + this.pollInterval + ", error=" + getError() + ", errorUri=" + this.errorUri + ", errorDescription=" + getErrorDescription() + ", subError=" + this.subError + ", challengeType=" + getChallengeType() + ", redirectReason=" + getRedirectReason() + ')';
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return "ResetPasswordSubmitApiResponse(statusCode=" + getStatusCode() + ", correlationId=" + getCorrelationId();
    }

    public final ResetPasswordSubmitApiResult toResult() {
        int statusCode = getStatusCode();
        if (statusCode == 200) {
            if (ApiErrorResponseUtilKt.isRedirect(getChallengeType())) {
                String correlationId = getCorrelationId();
                String redirectReason = getRedirectReason();
                return new ResetPasswordSubmitApiResult.Redirect(correlationId, redirectReason != null ? redirectReason : "");
            }
            String continuationToken = getContinuationToken();
            if (continuationToken != null) {
                return new ResetPasswordSubmitApiResult.SubmitSuccess(continuationToken, clampPollInterval(this.pollInterval), getCorrelationId());
            }
            return new ResetPasswordSubmitApiResult.UnknownError(getCorrelationId(), ErrorTypes.INVALID_STATE, "ResetPassword /submit successful, but did not return a flow token");
        }
        if (statusCode == 400) {
            if (ApiErrorResponseUtilKt.isPasswordBanned(this.subError) || ApiErrorResponseUtilKt.isPasswordTooShort(this.subError) || ApiErrorResponseUtilKt.isPasswordTooLong(this.subError) || ApiErrorResponseUtilKt.isPasswordRecentlyUsed(this.subError) || ApiErrorResponseUtilKt.isPasswordTooWeak(this.subError) || ApiErrorResponseUtilKt.isPasswordInvalid(this.subError)) {
                String error = getError();
                if (error == null) {
                    error = "";
                }
                String errorDescription = getErrorDescription();
                if (errorDescription == null) {
                    errorDescription = "";
                }
                String str = this.subError;
                return new ResetPasswordSubmitApiResult.PasswordInvalid(getCorrelationId(), error, errorDescription, str != null ? str : "");
            }
            if (ApiErrorResponseUtilKt.isExpiredToken(getError())) {
                String error2 = getError();
                if (error2 == null) {
                    error2 = "";
                }
                String errorDescription2 = getErrorDescription();
                return new ResetPasswordSubmitApiResult.ExpiredToken(getCorrelationId(), error2, errorDescription2 != null ? errorDescription2 : "");
            }
            String error3 = getError();
            if (error3 == null) {
                error3 = "";
            }
            String errorDescription3 = getErrorDescription();
            return new ResetPasswordSubmitApiResult.UnknownError(getCorrelationId(), error3, errorDescription3 != null ? errorDescription3 : "");
        }
        String error4 = getError();
        if (error4 == null) {
            error4 = "";
        }
        String errorDescription4 = getErrorDescription();
        return new ResetPasswordSubmitApiResult.UnknownError(getCorrelationId(), error4, errorDescription4 != null ? errorDescription4 : "");
    }

    private final int clampPollInterval(Integer pollIntervalInSeconds) {
        if (pollIntervalInSeconds == null || pollIntervalInSeconds.intValue() < 1 || pollIntervalInSeconds.intValue() > 15) {
            return 2;
        }
        return pollIntervalInSeconds.intValue();
    }
}
