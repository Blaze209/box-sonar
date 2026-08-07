package com.microsoft.identity.common.java.nativeauth.providers.responses.signup;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.nativeauth.providers.INativeAuthApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult;
import com.microsoft.identity.common.java.nativeauth.util.ApiErrorResponseUtilKt;
import com.microsoft.identity.nativeauth.statemachine.errors.ErrorTypes;
import com.microsoft.identity.nativeauth.statemachine.errors.SignUpErrorTypes;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignUpStartApiResponse.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\u00020\u0001:\u0001%B\u0099\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u001a\u0010\u0007\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t\u0018\u00010\b\u0012\u001a\u0010\n\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0011J\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\u0005H\u0016J\b\u0010$\u001a\u00020\u0005H\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R*\u0010\n\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R*\u0010\u0007\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017¨\u0006&"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResponse;", "Lcom/microsoft/identity/common/java/nativeauth/providers/INativeAuthApiResponse;", "statusCode", "", "correlationId", "", "continuationToken", "unverifiedAttributes", "", "", "invalidAttributes", "error", "errorDescription", "subError", "errorCodes", "challengeType", "redirectReason", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getChallengeType", "()Ljava/lang/String;", "getContinuationToken", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "getInvalidAttributes", "getRedirectReason", "getStatusCode", "()I", "setStatusCode", "(I)V", "getSubError", "getUnverifiedAttributes", "toResult", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult;", "toString", "toUnsanitizedString", "Companion", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SignUpStartApiResponse extends INativeAuthApiResponse {
    private static final String TAG = "SignUpStartApiResponse";

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

    @SerializedName(SignUpErrorTypes.INVALID_ATTRIBUTES)
    @Expose
    private final List<Map<String, String>> invalidAttributes;

    @SerializedName("redirect_reason")
    private final String redirectReason;

    @Expose
    private int statusCode;

    @SerializedName("suberror")
    private final String subError;

    @SerializedName("unverified_attributes")
    @Expose
    private final List<Map<String, String>> unverifiedAttributes;

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

    public final List<Map<String, String>> getUnverifiedAttributes() {
        return this.unverifiedAttributes;
    }

    public final List<Map<String, String>> getInvalidAttributes() {
        return this.invalidAttributes;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.INativeAuthApiResponse
    public String getError() {
        return this.error;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.INativeAuthApiResponse
    public String getErrorDescription() {
        return this.errorDescription;
    }

    public final String getSubError() {
        return this.subError;
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
    /* JADX WARN: Multi-variable type inference failed */
    public SignUpStartApiResponse(int i, String correlationId, String str, List<? extends Map<String, String>> list, List<? extends Map<String, String>> list2, String str2, String str3, String str4, List<Integer> list3, String str5, String str6) {
        super(i, correlationId, str, str5, str6, str2, str3);
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        this.statusCode = i;
        this.continuationToken = str;
        this.unverifiedAttributes = list;
        this.invalidAttributes = list2;
        this.error = str2;
        this.errorDescription = str3;
        this.subError = str4;
        this.errorCodes = list3;
        this.challengeType = str5;
        this.redirectReason = str6;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "SignUpStartApiResponse(statusCode=" + getStatusCode() + ", correlationId=" + getCorrelationId() + ", challengeType=" + getChallengeType() + "error=" + getError() + ", errorCodes=" + this.errorCodes + ", errorDescription=" + getErrorDescription() + ", subError=" + this.subError + ", redirectReason=" + getRedirectReason() + ')';
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return "SignUpContinueApiResponse(statusCode=" + getStatusCode() + ", correlationId=" + getCorrelationId();
    }

    public final SignUpStartApiResult toResult() {
        SignUpStartApiResult invalidPassword;
        List<String> attributeList;
        int statusCode = getStatusCode();
        if (statusCode == 200) {
            if (ApiErrorResponseUtilKt.isRedirect(getChallengeType())) {
                String correlationId = getCorrelationId();
                String redirectReason = getRedirectReason();
                return new SignUpStartApiResult.Redirect(correlationId, redirectReason != null ? redirectReason : "");
            }
            String continuationToken = getContinuationToken();
            if (continuationToken != null) {
                return new SignUpStartApiResult.Success(continuationToken, getCorrelationId());
            }
            return new SignUpStartApiResult.UnknownError(ErrorTypes.INVALID_STATE, "Sign up /start did not return a continuation token", getCorrelationId());
        }
        if (statusCode == 400) {
            if (ApiErrorResponseUtilKt.isUserAlreadyExists(getError())) {
                String error = getError();
                if (error == null) {
                    error = "";
                }
                String errorDescription = getErrorDescription();
                invalidPassword = new SignUpStartApiResult.UsernameAlreadyExists(error, errorDescription != null ? errorDescription : "", getCorrelationId());
            } else {
                List<Integer> list = this.errorCodes;
                boolean z = false;
                boolean zIsInvalidParameter = ApiErrorResponseUtilKt.isInvalidParameter(list != null ? list.get(0) : null);
                String errorDescription2 = getErrorDescription();
                if (errorDescription2 != null && ApiErrorResponseUtilKt.isInvalidUsername(errorDescription2)) {
                    z = true;
                }
                if (zIsInvalidParameter & z) {
                    String error2 = getError();
                    if (error2 == null) {
                        error2 = "";
                    }
                    String errorDescription3 = getErrorDescription();
                    invalidPassword = new SignUpStartApiResult.InvalidUsername(error2, errorDescription3 != null ? errorDescription3 : "", getCorrelationId());
                } else if (ApiErrorResponseUtilKt.isAuthNotSupported(getError())) {
                    String error3 = getError();
                    if (error3 == null) {
                        error3 = "";
                    }
                    String errorDescription4 = getErrorDescription();
                    invalidPassword = new SignUpStartApiResult.AuthNotSupported(error3, errorDescription4 != null ? errorDescription4 : "", getCorrelationId());
                } else if (ApiErrorResponseUtilKt.isAttributeValidationFailed(this.subError)) {
                    String error4 = getError();
                    String str = error4 == null ? "" : error4;
                    String errorDescription5 = getErrorDescription();
                    String str2 = errorDescription5 == null ? "" : errorDescription5;
                    List<Map<String, String>> list2 = this.invalidAttributes;
                    if (list2 == null || (attributeList = ApiErrorResponseUtilKt.toAttributeList(list2)) == null) {
                        return new SignUpStartApiResult.UnknownError(ApiErrorResult.INSTANCE.getINVALID_STATE(), "SignUp /start did not return a invalid_attributes with validation_failed error", getCorrelationId());
                    }
                    String str3 = this.subError;
                    invalidPassword = new SignUpStartApiResult.InvalidAttributes(getCorrelationId(), str, str2, attributeList, str3 == null ? "" : str3);
                } else if (ApiErrorResponseUtilKt.isUnsupportedChallengeType(getError())) {
                    String error5 = getError();
                    if (error5 == null) {
                        error5 = "";
                    }
                    String errorDescription6 = getErrorDescription();
                    invalidPassword = new SignUpStartApiResult.UnsupportedChallengeType(error5, errorDescription6 != null ? errorDescription6 : "", getCorrelationId());
                } else if (ApiErrorResponseUtilKt.isPasswordTooWeak(this.subError) || ApiErrorResponseUtilKt.isPasswordTooLong(this.subError) || ApiErrorResponseUtilKt.isPasswordTooShort(this.subError) || ApiErrorResponseUtilKt.isPasswordBanned(this.subError) || ApiErrorResponseUtilKt.isPasswordRecentlyUsed(this.subError) || ApiErrorResponseUtilKt.isPasswordInvalid(this.subError)) {
                    String error6 = getError();
                    if (error6 == null) {
                        error6 = "";
                    }
                    String errorDescription7 = getErrorDescription();
                    if (errorDescription7 == null) {
                        errorDescription7 = "";
                    }
                    String str4 = this.subError;
                    invalidPassword = new SignUpStartApiResult.InvalidPassword(getCorrelationId(), error6, errorDescription7, str4 != null ? str4 : "");
                } else {
                    String error7 = getError();
                    if (error7 == null) {
                        error7 = "";
                    }
                    String errorDescription8 = getErrorDescription();
                    invalidPassword = new SignUpStartApiResult.UnknownError(error7, errorDescription8 != null ? errorDescription8 : "", getCorrelationId());
                }
            }
            return invalidPassword;
        }
        String error8 = getError();
        if (error8 == null) {
            error8 = "";
        }
        String errorDescription9 = getErrorDescription();
        return new SignUpStartApiResult.UnknownError(error8, errorDescription9 != null ? errorDescription9 : "", getCorrelationId());
    }
}
