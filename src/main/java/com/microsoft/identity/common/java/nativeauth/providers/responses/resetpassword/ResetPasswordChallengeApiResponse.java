package com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.nativeauth.providers.INativeAuthApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.util.ApiErrorResponseUtilKt;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationResponse;
import com.microsoft.identity.nativeauth.statemachine.errors.ErrorTypes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ResetPasswordChallengeApiResponse.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 (2\u00020\u0001:\u0001(B\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0011J\u0006\u0010$\u001a\u00020%J\b\u0010&\u001a\u00020\u0005H\u0016J\b\u0010'\u001a\u00020\u0005H\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001e\u0010\u0018R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006)"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordChallengeApiResponse;", "Lcom/microsoft/identity/common/java/nativeauth/providers/INativeAuthApiResponse;", "statusCode", "", "correlationId", "", "continuationToken", "bindingMethod", "challengeTargetLabel", "challengeChannel", "codeLength", MicrosoftAuthorizationResponse.INTERVAL, "error", "errorDescription", "errorUri", "challengeType", "redirectReason", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBindingMethod", "()Ljava/lang/String;", "getChallengeChannel", "getChallengeTargetLabel", "getChallengeType", "getCodeLength", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getContinuationToken", "getError", "getErrorDescription", "getErrorUri", "getInterval", "getRedirectReason", "getStatusCode", "()I", "setStatusCode", "(I)V", "toResult", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordChallengeApiResult;", "toString", "toUnsanitizedString", "Companion", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ResetPasswordChallengeApiResponse extends INativeAuthApiResponse {
    private static final String TAG = "ResetPasswordChallengeApiResponse";

    @SerializedName("binding_method")
    @Expose
    private final String bindingMethod;

    @SerializedName("challenge_channel")
    @Expose
    private final String challengeChannel;

    @SerializedName("challenge_target_label")
    private final String challengeTargetLabel;

    @SerializedName("challenge_type")
    @Expose
    private final String challengeType;

    @SerializedName("code_length")
    @Expose
    private final Integer codeLength;

    @SerializedName(NativeAuthConstants.GrantType.CONTINUATION_TOKEN)
    private final String continuationToken;

    @SerializedName("error")
    private final String error;

    @SerializedName("error_description")
    private final String errorDescription;

    @SerializedName("error_uri")
    private final String errorUri;

    @SerializedName(MicrosoftAuthorizationResponse.INTERVAL)
    @Expose
    private final Integer interval;

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

    public final String getBindingMethod() {
        return this.bindingMethod;
    }

    public final String getChallengeTargetLabel() {
        return this.challengeTargetLabel;
    }

    public final String getChallengeChannel() {
        return this.challengeChannel;
    }

    public final Integer getCodeLength() {
        return this.codeLength;
    }

    public final Integer getInterval() {
        return this.interval;
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

    @Override // com.microsoft.identity.common.java.nativeauth.providers.INativeAuthApiResponse
    public String getChallengeType() {
        return this.challengeType;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.INativeAuthApiResponse
    public String getRedirectReason() {
        return this.redirectReason;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResetPasswordChallengeApiResponse(int i, String correlationId, String str, String str2, String str3, String str4, Integer num, Integer num2, String str5, String str6, String str7, String str8, String str9) {
        super(i, correlationId, str, str8, str9, str5, str6);
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        this.statusCode = i;
        this.continuationToken = str;
        this.bindingMethod = str2;
        this.challengeTargetLabel = str3;
        this.challengeChannel = str4;
        this.codeLength = num;
        this.interval = num2;
        this.error = str5;
        this.errorDescription = str6;
        this.errorUri = str7;
        this.challengeType = str8;
        this.redirectReason = str9;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        StringBuilder sb = new StringBuilder("ResetPasswordChallengeApiResponse(statusCode=");
        sb.append(getStatusCode()).append(", correlationId=").append(getCorrelationId()).append(", challengeType=").append(getChallengeType()).append(", bindingMethod=").append(this.bindingMethod).append(", challengeTargetLabel=").append(this.challengeTargetLabel).append(", challengeChannel=").append(this.challengeChannel).append(", codeLength=").append(this.codeLength).append(", interval=").append(this.interval).append(", error=").append(getError()).append(", errorDescription=").append(getErrorDescription()).append(", errorUri=").append(this.errorUri).append(", redirectReason=");
        sb.append(getRedirectReason()).append(')');
        return sb.toString();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return "ResetPasswordChallengeApiResponse(statusCode=" + getStatusCode() + ", correlationId=" + getCorrelationId();
    }

    public final ResetPasswordChallengeApiResult toResult() {
        int statusCode = getStatusCode();
        if (statusCode != 200) {
            if (statusCode == 400) {
                if (ApiErrorResponseUtilKt.isExpiredToken(getError())) {
                    String error = getError();
                    if (error == null) {
                        error = "";
                    }
                    String errorDescription = getErrorDescription();
                    return new ResetPasswordChallengeApiResult.ExpiredToken(error, errorDescription != null ? errorDescription : "", getCorrelationId());
                }
                if (ApiErrorResponseUtilKt.isUnsupportedChallengeType(getError())) {
                    String error2 = getError();
                    if (error2 == null) {
                        error2 = "";
                    }
                    String errorDescription2 = getErrorDescription();
                    return new ResetPasswordChallengeApiResult.UnsupportedChallengeType(getCorrelationId(), error2, errorDescription2 != null ? errorDescription2 : "");
                }
                String error3 = getError();
                if (error3 == null) {
                    error3 = "";
                }
                String errorDescription3 = getErrorDescription();
                return new ResetPasswordChallengeApiResult.UnknownError(error3, errorDescription3 != null ? errorDescription3 : "", getCorrelationId());
            }
            String error4 = getError();
            if (error4 == null) {
                error4 = "";
            }
            String errorDescription4 = getErrorDescription();
            return new ResetPasswordChallengeApiResult.UnknownError(error4, errorDescription4 != null ? errorDescription4 : "", getCorrelationId());
        }
        if (ApiErrorResponseUtilKt.isRedirect(getChallengeType())) {
            String correlationId = getCorrelationId();
            String redirectReason = getRedirectReason();
            return new ResetPasswordChallengeApiResult.Redirect(correlationId, redirectReason != null ? redirectReason : "");
        }
        if (ApiErrorResponseUtilKt.isOOB(getChallengeType())) {
            String str = this.challengeTargetLabel;
            if (str == null || StringsKt.isBlank(str)) {
                return new ResetPasswordChallengeApiResult.UnknownError(ErrorTypes.INVALID_STATE, "ResetPassword /challenge did not return a challenge_target_label with oob challenge type", getCorrelationId());
            }
            String str2 = this.challengeChannel;
            if (str2 == null || StringsKt.isBlank(str2)) {
                return new ResetPasswordChallengeApiResult.UnknownError(ErrorTypes.INVALID_STATE, "ResetPassword /challenge did not return a challenge_channel with oob challenge type", getCorrelationId());
            }
            if (this.codeLength == null) {
                return new ResetPasswordChallengeApiResult.UnknownError(ErrorTypes.INVALID_STATE, "ResetPassword /challenge did not return a code_length with oob challenge type", getCorrelationId());
            }
            String continuationToken = getContinuationToken();
            if (continuationToken != null) {
                return new ResetPasswordChallengeApiResult.CodeRequired(getCorrelationId(), continuationToken, this.challengeTargetLabel, this.challengeChannel, this.codeLength.intValue());
            }
            return new ResetPasswordChallengeApiResult.UnknownError(ErrorTypes.INVALID_STATE, "ResetPassword /challenge successful, but did not return a continuation token", getCorrelationId());
        }
        String error5 = getError();
        if (error5 == null) {
            error5 = "";
        }
        String errorDescription5 = getErrorDescription();
        return new ResetPasswordChallengeApiResult.UnknownError(error5, errorDescription5 != null ? errorDescription5 : "", getCorrelationId());
    }
}
