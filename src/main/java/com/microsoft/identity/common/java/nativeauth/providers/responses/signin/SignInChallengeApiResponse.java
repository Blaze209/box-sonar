package com.microsoft.identity.common.java.nativeauth.providers.responses.signin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.nativeauth.providers.INativeAuthApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult;
import com.microsoft.identity.common.java.nativeauth.util.ApiErrorResponseUtilKt;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SignInChallengeApiResponse.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0014J\u0006\u0010*\u001a\u00020+J\b\u0010,\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\u0005H\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b#\u0010\u001bR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0016¨\u0006."}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInChallengeApiResponse;", "Lcom/microsoft/identity/common/java/nativeauth/providers/INativeAuthApiResponse;", "statusCode", "", "correlationId", "", "continuationToken", "bindingMethod", "challengeTargetLabel", "challengeChannel", "codeLength", MicrosoftAuthorizationResponse.INTERVAL, "error", "errorDescription", "subError", "errorUri", "errorCodes", "", "challengeType", "redirectReason", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getBindingMethod", "()Ljava/lang/String;", "getChallengeChannel", "getChallengeTargetLabel", "getChallengeType", "getCodeLength", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getContinuationToken", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "getErrorUri", "getInterval", "getRedirectReason", "getStatusCode", "()I", "setStatusCode", "(I)V", "getSubError", "toResult", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInChallengeApiResult;", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SignInChallengeApiResponse extends INativeAuthApiResponse {

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

    @SerializedName("error_codes")
    private final List<Integer> errorCodes;

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

    public final String getSubError() {
        return this.subError;
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
    public SignInChallengeApiResponse(int i, String correlationId, String str, String str2, String str3, String str4, Integer num, Integer num2, String str5, String str6, String str7, String str8, List<Integer> list, String str9, String str10) {
        super(i, correlationId, str, str9, str10, str5, str6);
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
        this.subError = str7;
        this.errorUri = str8;
        this.errorCodes = list;
        this.challengeType = str9;
        this.redirectReason = str10;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        StringBuilder sb = new StringBuilder("SignInChallengeApiResponse(statusCode=");
        sb.append(getStatusCode()).append(", correlationId=").append(getCorrelationId()).append(", challengeType=").append(getChallengeType()).append(", bindingMethod=").append(this.bindingMethod).append(", challengeTargetLabel=").append(this.challengeTargetLabel).append(", challengeChannel=").append(this.challengeChannel).append(", codeLength=").append(this.codeLength).append(", interval=").append(this.interval).append(", error=").append(getError()).append(", subError=").append(this.subError).append(", errorDescription=").append(getErrorDescription()).append(", errorCodes=");
        sb.append(this.errorCodes).append(", errorUri=").append(this.errorUri).append(", redirectReason=").append(getRedirectReason()).append(')');
        return sb.toString();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return "SignInChallengeApiResponse(statusCode=" + getStatusCode() + ", correlationId=" + getCorrelationId();
    }

    public final SignInChallengeApiResult toResult() {
        int statusCode = getStatusCode();
        if (statusCode != 200) {
            if (statusCode == 400) {
                if (ApiErrorResponseUtilKt.isAccessDenied(getError()) && ApiErrorResponseUtilKt.isProviderBlocked(this.subError)) {
                    String error = getError();
                    if (error == null) {
                        error = "";
                    }
                    String errorDescription = getErrorDescription();
                    String str = errorDescription != null ? errorDescription : "";
                    List<Integer> listEmptyList = this.errorCodes;
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    return new SignInChallengeApiResult.BlockedAuthMethod(getCorrelationId(), error, str, listEmptyList);
                }
                String error2 = getError();
                String str2 = error2 == null ? "" : error2;
                String str3 = this.subError;
                String str4 = str3 == null ? "" : str3;
                String errorDescription2 = getErrorDescription();
                String str5 = errorDescription2 == null ? "" : errorDescription2;
                List<Integer> listEmptyList2 = this.errorCodes;
                if (listEmptyList2 == null) {
                    listEmptyList2 = CollectionsKt.emptyList();
                }
                return new SignInChallengeApiResult.UnknownError(getCorrelationId(), str2, str4, str5, listEmptyList2);
            }
            String error3 = getError();
            String str6 = error3 == null ? "" : error3;
            String errorDescription3 = getErrorDescription();
            String str7 = errorDescription3 == null ? "" : errorDescription3;
            List<Integer> listEmptyList3 = this.errorCodes;
            if (listEmptyList3 == null) {
                listEmptyList3 = CollectionsKt.emptyList();
            }
            List<Integer> list = listEmptyList3;
            String str8 = this.subError;
            return new SignInChallengeApiResult.UnknownError(getCorrelationId(), str6, str8 == null ? "" : str8, str7, list);
        }
        if (ApiErrorResponseUtilKt.isRedirect(getChallengeType())) {
            String correlationId = getCorrelationId();
            String redirectReason = getRedirectReason();
            return new SignInChallengeApiResult.Redirect(correlationId, redirectReason != null ? redirectReason : "");
        }
        if (ApiErrorResponseUtilKt.isOOB(getChallengeType())) {
            String str9 = this.challengeTargetLabel;
            if (str9 == null || StringsKt.isBlank(str9)) {
                String invalid_state = ApiErrorResult.INSTANCE.getINVALID_STATE();
                String str10 = this.subError;
                String str11 = str10 == null ? "" : str10;
                List<Integer> listEmptyList4 = this.errorCodes;
                if (listEmptyList4 == null) {
                    listEmptyList4 = CollectionsKt.emptyList();
                }
                return new SignInChallengeApiResult.UnknownError(getCorrelationId(), invalid_state, str11, "oauth/v2.0/challenge did not return a challenge_target_label with oob challenge type", listEmptyList4);
            }
            String str12 = this.challengeChannel;
            if (str12 == null || StringsKt.isBlank(str12)) {
                String invalid_state2 = ApiErrorResult.INSTANCE.getINVALID_STATE();
                String str13 = this.subError;
                String str14 = str13 == null ? "" : str13;
                List<Integer> listEmptyList5 = this.errorCodes;
                if (listEmptyList5 == null) {
                    listEmptyList5 = CollectionsKt.emptyList();
                }
                return new SignInChallengeApiResult.UnknownError(getCorrelationId(), invalid_state2, str14, "oauth/v2.0/challenge did not return a challenge_channel with oob challenge type", listEmptyList5);
            }
            if (this.codeLength == null) {
                String invalid_state3 = ApiErrorResult.INSTANCE.getINVALID_STATE();
                String str15 = this.subError;
                String str16 = str15 == null ? "" : str15;
                List<Integer> listEmptyList6 = this.errorCodes;
                if (listEmptyList6 == null) {
                    listEmptyList6 = CollectionsKt.emptyList();
                }
                return new SignInChallengeApiResult.UnknownError(getCorrelationId(), invalid_state3, str16, "oauth/v2.0/challenge did not return a code_length with oob challenge type", listEmptyList6);
            }
            String continuationToken = getContinuationToken();
            if (continuationToken != null) {
                return new SignInChallengeApiResult.OOBRequired(getCorrelationId(), continuationToken, this.challengeTargetLabel, this.challengeChannel, this.codeLength.intValue());
            }
            String invalid_state4 = ApiErrorResult.INSTANCE.getINVALID_STATE();
            String str17 = this.subError;
            String str18 = str17 == null ? "" : str17;
            List<Integer> listEmptyList7 = this.errorCodes;
            if (listEmptyList7 == null) {
                listEmptyList7 = CollectionsKt.emptyList();
            }
            return new SignInChallengeApiResult.UnknownError(getCorrelationId(), invalid_state4, str18, "oauth/v2.0/challenge did not return a continuation token with oob challenge type", listEmptyList7);
        }
        if (ApiErrorResponseUtilKt.isPassword(getChallengeType())) {
            String continuationToken2 = getContinuationToken();
            if (continuationToken2 != null) {
                return new SignInChallengeApiResult.PasswordRequired(getCorrelationId(), continuationToken2);
            }
            String invalid_state5 = ApiErrorResult.INSTANCE.getINVALID_STATE();
            List<Integer> listEmptyList8 = this.errorCodes;
            if (listEmptyList8 == null) {
                listEmptyList8 = CollectionsKt.emptyList();
            }
            List<Integer> list2 = listEmptyList8;
            String str19 = this.subError;
            return new SignInChallengeApiResult.UnknownError(getCorrelationId(), invalid_state5, str19 == null ? "" : str19, "oauth/v2.0/challenge did not return a continuation token with password challenge type", list2);
        }
        String error4 = getError();
        String str20 = error4 == null ? "" : error4;
        String errorDescription4 = getErrorDescription();
        String str21 = errorDescription4 == null ? "" : errorDescription4;
        List<Integer> listEmptyList9 = this.errorCodes;
        if (listEmptyList9 == null) {
            listEmptyList9 = CollectionsKt.emptyList();
        }
        List<Integer> list3 = listEmptyList9;
        String str22 = this.subError;
        return new SignInChallengeApiResult.UnknownError(getCorrelationId(), str20, str22 == null ? "" : str22, str21, list3);
    }
}
