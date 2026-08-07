package com.microsoft.identity.common.java.nativeauth.providers.responses.signup;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.nativeauth.providers.INativeAuthApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult;
import com.microsoft.identity.common.java.nativeauth.util.ApiErrorResponseUtilKt;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SignUpChallengeApiResponse.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 &2\u00020\u0001:\u0001&By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0010J\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u00020\u0005H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001c\u0010\u0017R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006'"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpChallengeApiResponse;", "Lcom/microsoft/identity/common/java/nativeauth/providers/INativeAuthApiResponse;", "statusCode", "", "correlationId", "", "continuationToken", "challengeTargetLabel", "codeLength", "bindingMethod", MicrosoftAuthorizationResponse.INTERVAL, "challengeChannel", "error", "errorDescription", "challengeType", "redirectReason", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBindingMethod", "()Ljava/lang/String;", "getChallengeChannel", "getChallengeTargetLabel", "getChallengeType", "getCodeLength", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getContinuationToken", "getError", "getErrorDescription", "getInterval", "getRedirectReason", "getStatusCode", "()I", "setStatusCode", "(I)V", "toResult", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpChallengeApiResult;", "toString", "toUnsanitizedString", "Companion", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SignUpChallengeApiResponse extends INativeAuthApiResponse {
    private static final String TAG = "SignUpChallengeApiResponse";

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

    public final String getChallengeTargetLabel() {
        return this.challengeTargetLabel;
    }

    public final Integer getCodeLength() {
        return this.codeLength;
    }

    public final String getBindingMethod() {
        return this.bindingMethod;
    }

    public final Integer getInterval() {
        return this.interval;
    }

    public final String getChallengeChannel() {
        return this.challengeChannel;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.INativeAuthApiResponse
    public String getError() {
        return this.error;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.INativeAuthApiResponse
    public String getErrorDescription() {
        return this.errorDescription;
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
    public SignUpChallengeApiResponse(int i, String correlationId, String str, String str2, Integer num, String str3, Integer num2, String str4, String str5, String str6, String str7, String str8) {
        super(i, correlationId, str, str7, str8, str5, str6);
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        this.statusCode = i;
        this.continuationToken = str;
        this.challengeTargetLabel = str2;
        this.codeLength = num;
        this.bindingMethod = str3;
        this.interval = num2;
        this.challengeChannel = str4;
        this.error = str5;
        this.errorDescription = str6;
        this.challengeType = str7;
        this.redirectReason = str8;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        StringBuilder sb = new StringBuilder("SignInChallengeApiResponse(statusCode=");
        sb.append(getStatusCode()).append(", correlationId=").append(getCorrelationId()).append(", challengeType=").append(getChallengeType()).append(", bindingMethod=").append(this.bindingMethod).append(", challengeTargetLabel=").append(this.challengeTargetLabel).append(", challengeChannel=").append(this.challengeChannel).append(", codeLength=").append(this.codeLength).append(", interval=").append(this.interval).append(", error=").append(getError()).append(", errorDescription=").append(getErrorDescription()).append(", redirectReason=").append(getRedirectReason()).append(')');
        return sb.toString();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return "SignInChallengeApiResponse(statusCode=" + getStatusCode() + ", correlationId=" + getCorrelationId();
    }

    public final SignUpChallengeApiResult toResult() {
        int statusCode = getStatusCode();
        if (statusCode != 200) {
            if (statusCode == 400) {
                if (ApiErrorResponseUtilKt.isUnsupportedChallengeType(getError())) {
                    String error = getError();
                    if (error == null) {
                        error = "";
                    }
                    String errorDescription = getErrorDescription();
                    return new SignUpChallengeApiResult.UnsupportedChallengeType(getCorrelationId(), error, errorDescription != null ? errorDescription : "");
                }
                if (ApiErrorResponseUtilKt.isExpiredToken(getError())) {
                    String error2 = getError();
                    if (error2 == null) {
                        error2 = "";
                    }
                    String errorDescription2 = getErrorDescription();
                    return new SignUpChallengeApiResult.ExpiredToken(getCorrelationId(), error2, errorDescription2 != null ? errorDescription2 : "");
                }
                String error3 = getError();
                if (error3 == null) {
                    error3 = "";
                }
                String errorDescription3 = getErrorDescription();
                return new SignUpChallengeApiResult.UnknownError(error3, errorDescription3 != null ? errorDescription3 : "", getCorrelationId());
            }
            String error4 = getError();
            if (error4 == null) {
                error4 = "";
            }
            String errorDescription4 = getErrorDescription();
            return new SignUpChallengeApiResult.UnknownError(error4, errorDescription4 != null ? errorDescription4 : "", getCorrelationId());
        }
        if (ApiErrorResponseUtilKt.isRedirect(getChallengeType())) {
            String correlationId = getCorrelationId();
            String redirectReason = getRedirectReason();
            return new SignUpChallengeApiResult.Redirect(correlationId, redirectReason != null ? redirectReason : "");
        }
        if (ApiErrorResponseUtilKt.isOOB(getChallengeType())) {
            String str = this.challengeTargetLabel;
            if (str == null || StringsKt.isBlank(str)) {
                return new SignUpChallengeApiResult.UnknownError(ApiErrorResult.INSTANCE.getINVALID_STATE(), "SignUp /challenge did not return a challenge_target_label with oob challenge type", getCorrelationId());
            }
            String str2 = this.challengeChannel;
            if (str2 == null || StringsKt.isBlank(str2)) {
                return new SignUpChallengeApiResult.UnknownError(ApiErrorResult.INSTANCE.getINVALID_STATE(), "SignUp /challenge did not return a challenge_channel with oob challenge type", getCorrelationId());
            }
            if (this.codeLength == null) {
                return new SignUpChallengeApiResult.UnknownError(ApiErrorResult.INSTANCE.getINVALID_STATE(), "SignUp /challenge did not return a code_length with oob challenge type", getCorrelationId());
            }
            String continuationToken = getContinuationToken();
            if (continuationToken != null) {
                return new SignUpChallengeApiResult.OOBRequired(getCorrelationId(), continuationToken, this.challengeTargetLabel, this.challengeChannel, this.codeLength.intValue());
            }
            return new SignUpChallengeApiResult.UnknownError(ApiErrorResult.INSTANCE.getINVALID_STATE(), "SignUp /challenge did not return a continuation token with oob challenge type", getCorrelationId());
        }
        if (ApiErrorResponseUtilKt.isPassword(getChallengeType())) {
            String continuationToken2 = getContinuationToken();
            if (continuationToken2 != null) {
                return new SignUpChallengeApiResult.PasswordRequired(getCorrelationId(), continuationToken2);
            }
            return new SignUpChallengeApiResult.UnknownError(ApiErrorResult.INSTANCE.getINVALID_STATE(), "SignUp /challenge did not return a continuation token with password challenge type", getCorrelationId());
        }
        String error5 = getError();
        if (error5 == null) {
            error5 = "";
        }
        String errorDescription5 = getErrorDescription();
        return new SignUpChallengeApiResult.UnknownError(error5, errorDescription5 != null ? errorDescription5 : "", getCorrelationId());
    }
}
