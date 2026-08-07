package com.microsoft.identity.common.java.nativeauth.providers.responses.signup;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.nativeauth.providers.INativeAuthApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.UserAttributeApiResult;
import com.microsoft.identity.common.java.nativeauth.util.ApiErrorResponseUtilKt;
import com.microsoft.identity.nativeauth.statemachine.errors.ErrorTypes;
import com.microsoft.identity.nativeauth.statemachine.errors.SignUpErrorTypes;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignUpContinueApiResponse.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ,2\u00020\u0001:\u0001,B³\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u001a\u0010\b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n\u0018\u00010\t\u0012\u001a\u0010\u000b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n\u0018\u00010\t\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0014J\u0006\u0010(\u001a\u00020)J\b\u0010*\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR*\u0010\u000b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016R*\u0010\b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001a¨\u0006-"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResponse;", "Lcom/microsoft/identity/common/java/nativeauth/providers/INativeAuthApiResponse;", "statusCode", "", "correlationId", "", "continuationToken", "expiresIn", "unverifiedAttributes", "", "", "invalidAttributes", "requiredAttributes", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/UserAttributeApiResult;", "error", "errorDescription", "subError", "errorCodes", "challengeType", "redirectReason", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getChallengeType", "()Ljava/lang/String;", "getContinuationToken", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "getExpiresIn", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getInvalidAttributes", "getRedirectReason", "getRequiredAttributes", "getStatusCode", "()I", "setStatusCode", "(I)V", "getSubError", "getUnverifiedAttributes", "toResult", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult;", "toString", "toUnsanitizedString", "Companion", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SignUpContinueApiResponse extends INativeAuthApiResponse {
    private static final String TAG = "SignUpContinueApiResponse";

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

    @SerializedName("expires_in")
    @Expose
    private final Integer expiresIn;

    @SerializedName(SignUpErrorTypes.INVALID_ATTRIBUTES)
    @Expose
    private final List<Map<String, String>> invalidAttributes;

    @SerializedName("redirect_reason")
    private final String redirectReason;

    @SerializedName("required_attributes")
    @Expose
    private final List<UserAttributeApiResult> requiredAttributes;

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

    public final Integer getExpiresIn() {
        return this.expiresIn;
    }

    public final List<Map<String, String>> getUnverifiedAttributes() {
        return this.unverifiedAttributes;
    }

    public final List<Map<String, String>> getInvalidAttributes() {
        return this.invalidAttributes;
    }

    public final List<UserAttributeApiResult> getRequiredAttributes() {
        return this.requiredAttributes;
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
    public SignUpContinueApiResponse(int i, String correlationId, String str, Integer num, List<? extends Map<String, String>> list, List<? extends Map<String, String>> list2, List<UserAttributeApiResult> list3, String str2, String str3, String str4, List<Integer> list4, String str5, String str6) {
        super(i, correlationId, str, str5, str6, str2, str3);
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        this.statusCode = i;
        this.continuationToken = str;
        this.expiresIn = num;
        this.unverifiedAttributes = list;
        this.invalidAttributes = list2;
        this.requiredAttributes = list3;
        this.error = str2;
        this.errorDescription = str3;
        this.subError = str4;
        this.errorCodes = list4;
        this.challengeType = str5;
        this.redirectReason = str6;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "SignUpContinueApiResponse(statusCode=" + getStatusCode() + ", correlationId=" + getCorrelationId() + ", expiresIn=" + this.expiresIn + ", requiredAttributes=" + this.requiredAttributes + ", error=" + getError() + ", errorCodes=" + this.errorCodes + ", errorDescription=" + getErrorDescription() + ", subError=" + this.subError + ", challengeType=" + getChallengeType() + ", redirectReason=" + getRedirectReason() + ')';
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return "SignUpContinueApiResponse(statusCode=" + getStatusCode() + ", correlationId=" + getCorrelationId();
    }

    public final SignUpContinueApiResult toResult() {
        List<String> attributeList;
        int statusCode = getStatusCode();
        if (statusCode == 200) {
            if (ApiErrorResponseUtilKt.isRedirect(getChallengeType())) {
                String correlationId = getCorrelationId();
                String redirectReason = getRedirectReason();
                return new SignUpContinueApiResult.Redirect(correlationId, redirectReason != null ? redirectReason : "");
            }
            return new SignUpContinueApiResult.Success(getCorrelationId(), getContinuationToken(), this.expiresIn);
        }
        if (statusCode == 400) {
            if (ApiErrorResponseUtilKt.isInvalidGrant(getError())) {
                if (ApiErrorResponseUtilKt.isPasswordTooWeak(this.subError) || ApiErrorResponseUtilKt.isPasswordTooLong(this.subError) || ApiErrorResponseUtilKt.isPasswordTooShort(this.subError) || ApiErrorResponseUtilKt.isPasswordBanned(this.subError) || ApiErrorResponseUtilKt.isPasswordRecentlyUsed(this.subError) || ApiErrorResponseUtilKt.isPasswordInvalid(this.subError)) {
                    String error = getError();
                    if (error == null) {
                        error = "";
                    }
                    String errorDescription = getErrorDescription();
                    if (errorDescription == null) {
                        errorDescription = "";
                    }
                    String str = this.subError;
                    return new SignUpContinueApiResult.InvalidPassword(getCorrelationId(), error, errorDescription, str != null ? str : "");
                }
                if (ApiErrorResponseUtilKt.isAttributeValidationFailed(this.subError)) {
                    String error2 = getError();
                    String str2 = error2 == null ? "" : error2;
                    String errorDescription2 = getErrorDescription();
                    String str3 = errorDescription2 == null ? "" : errorDescription2;
                    List<Map<String, String>> list = this.invalidAttributes;
                    if (list == null || (attributeList = ApiErrorResponseUtilKt.toAttributeList(list)) == null) {
                        return new SignUpContinueApiResult.UnknownError(getCorrelationId(), ErrorTypes.INVALID_STATE, "SignUp /continue did not return a invalid_attributes with validation_failed error");
                    }
                    String str4 = this.subError;
                    return new SignUpContinueApiResult.InvalidAttributes(getCorrelationId(), attributeList, str2, str3, str4 == null ? "" : str4);
                }
                if (ApiErrorResponseUtilKt.isInvalidOOBValue(this.subError)) {
                    String error3 = getError();
                    if (error3 == null) {
                        error3 = "";
                    }
                    String errorDescription3 = getErrorDescription();
                    if (errorDescription3 == null) {
                        errorDescription3 = "";
                    }
                    String str5 = this.subError;
                    return new SignUpContinueApiResult.InvalidOOBValue(getCorrelationId(), error3, errorDescription3, str5 != null ? str5 : "");
                }
                String error4 = getError();
                if (error4 == null) {
                    error4 = "";
                }
                String errorDescription4 = getErrorDescription();
                return new SignUpContinueApiResult.UnknownError(getCorrelationId(), error4, errorDescription4 != null ? errorDescription4 : "");
            }
            if (ApiErrorResponseUtilKt.isUserAlreadyExists(getError())) {
                String error5 = getError();
                if (error5 == null) {
                    error5 = "";
                }
                String errorDescription5 = getErrorDescription();
                return new SignUpContinueApiResult.UsernameAlreadyExists(getCorrelationId(), error5, errorDescription5 != null ? errorDescription5 : "");
            }
            if (ApiErrorResponseUtilKt.isExpiredToken(getError())) {
                String error6 = getError();
                if (error6 == null) {
                    error6 = "";
                }
                String errorDescription6 = getErrorDescription();
                return new SignUpContinueApiResult.ExpiredToken(getCorrelationId(), error6, errorDescription6 != null ? errorDescription6 : "");
            }
            if (ApiErrorResponseUtilKt.isAttributesRequired(getError())) {
                String continuationToken = getContinuationToken();
                if (continuationToken == null) {
                    return new SignUpContinueApiResult.UnknownError(getCorrelationId(), ApiErrorResult.INSTANCE.getINVALID_STATE(), "SignUp /continue did not return a continuation token with attributes_required error");
                }
                String error7 = getError();
                String str6 = error7 == null ? "" : error7;
                String errorDescription7 = getErrorDescription();
                String str7 = errorDescription7 == null ? "" : errorDescription7;
                List<UserAttributeApiResult> list2 = this.requiredAttributes;
                if (list2 != null) {
                    return new SignUpContinueApiResult.AttributesRequired(getCorrelationId(), continuationToken, str6, str7, list2);
                }
                return new SignUpContinueApiResult.UnknownError(getCorrelationId(), ApiErrorResult.INSTANCE.getINVALID_STATE(), "SignUp /continue did not return required_attributes with attributes_required error");
            }
            if (ApiErrorResponseUtilKt.isCredentialRequired(getError())) {
                String continuationToken2 = getContinuationToken();
                if (continuationToken2 == null) {
                    return new SignUpContinueApiResult.UnknownError(getCorrelationId(), ApiErrorResult.INSTANCE.getINVALID_STATE(), "SignUp /continue did not return a continuation token with credential_required");
                }
                String error8 = getError();
                if (error8 == null) {
                    error8 = "";
                }
                String errorDescription8 = getErrorDescription();
                return new SignUpContinueApiResult.CredentialRequired(getCorrelationId(), continuationToken2, error8, errorDescription8 != null ? errorDescription8 : "");
            }
            if (ApiErrorResponseUtilKt.isVerificationRequired(getError())) {
                String error9 = getError();
                if (error9 == null) {
                    error9 = "";
                }
                String errorDescription9 = getErrorDescription();
                return new SignUpContinueApiResult.UnknownError(getCorrelationId(), error9, errorDescription9 != null ? errorDescription9 : "");
            }
            String error10 = getError();
            if (error10 == null) {
                error10 = "";
            }
            String errorDescription10 = getErrorDescription();
            return new SignUpContinueApiResult.UnknownError(getCorrelationId(), error10, errorDescription10 != null ? errorDescription10 : "");
        }
        String error11 = getError();
        if (error11 == null) {
            error11 = "";
        }
        String errorDescription11 = getErrorDescription();
        return new SignUpContinueApiResult.UnknownError(getCorrelationId(), error11, errorDescription11 != null ? errorDescription11 : "");
    }
}
