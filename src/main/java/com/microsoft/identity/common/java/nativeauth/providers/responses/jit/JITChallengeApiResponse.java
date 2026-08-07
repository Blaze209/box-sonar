package com.microsoft.identity.common.java.nativeauth.providers.responses.jit;

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

/* JADX INFO: compiled from: JITChallengeApiResponse.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0014J\u0006\u0010*\u001a\u00020+J\b\u0010,\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\u0005H\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b#\u0010\u001bR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0016¨\u0006."}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/jit/JITChallengeApiResponse;", "Lcom/microsoft/identity/common/java/nativeauth/providers/INativeAuthApiResponse;", "statusCode", "", "correlationId", "", "continuationToken", "bindingMethod", "challengeTarget", "challengeChannel", "codeLength", MicrosoftAuthorizationResponse.INTERVAL, "error", "errorDescription", "errorUri", "errorCodes", "", "subError", "challengeType", "redirectReason", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBindingMethod", "()Ljava/lang/String;", "getChallengeChannel", "getChallengeTarget", "getChallengeType", "getCodeLength", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getContinuationToken", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "getErrorUri", "getInterval", "getRedirectReason", "getStatusCode", "()I", "setStatusCode", "(I)V", "getSubError", "toResult", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/jit/JITChallengeApiResult;", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class JITChallengeApiResponse extends INativeAuthApiResponse {

    @SerializedName("binding_method")
    @Expose
    private final String bindingMethod;

    @SerializedName("challenge_channel")
    @Expose
    private final String challengeChannel;

    @SerializedName("challenge_target")
    @Expose
    private final String challengeTarget;

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

    public final String getChallengeTarget() {
        return this.challengeTarget;
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

    public final List<Integer> getErrorCodes() {
        return this.errorCodes;
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
    public JITChallengeApiResponse(int i, String correlationId, String str, String str2, String str3, String str4, Integer num, Integer num2, String str5, String str6, String str7, List<Integer> list, String str8, String str9, String str10) {
        super(i, correlationId, str, str9, str10, str5, str6);
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        this.statusCode = i;
        this.continuationToken = str;
        this.bindingMethod = str2;
        this.challengeTarget = str3;
        this.challengeChannel = str4;
        this.codeLength = num;
        this.interval = num2;
        this.error = str5;
        this.errorDescription = str6;
        this.errorUri = str7;
        this.errorCodes = list;
        this.subError = str8;
        this.challengeType = str9;
        this.redirectReason = str10;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        StringBuilder sb = new StringBuilder("JITChallengeApiResponse(statusCode=");
        sb.append(getStatusCode()).append(", correlationId=").append(getCorrelationId()).append(" error=").append(getError()).append(", errorCodes=").append(this.errorCodes).append(", errorDescription=").append(getErrorDescription()).append(", challengeType=").append(getChallengeType()).append(", challengeTarget=").append(this.challengeTarget).append(", bindingMethod=").append(this.bindingMethod).append(", challengeChannel=").append(this.challengeChannel).append(", codeLength=").append(this.codeLength).append(",redirectReason=").append(getRedirectReason()).append(')');
        return sb.toString();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return "JITChallengeApiResponse(statusCode=" + getStatusCode() + ", correlationId=" + getCorrelationId();
    }

    public final JITChallengeApiResult toResult() {
        String str;
        String str2;
        String str3;
        int statusCode = getStatusCode();
        if (statusCode == 200) {
            String invalid_state = ApiErrorResult.INSTANCE.getINVALID_STATE();
            List<Integer> listEmptyList = this.errorCodes;
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            JITChallengeApiResult.UnknownError unknownError = new JITChallengeApiResult.UnknownError(getCorrelationId(), invalid_state, "register/challenge.Register authentication method /challenge did not return all mandatory fields", listEmptyList);
            String challengeType = getChallengeType();
            if (challengeType == null || StringsKt.isBlank(challengeType)) {
                return unknownError;
            }
            if (ApiErrorResponseUtilKt.isOOB(getChallengeType())) {
                String continuationToken = getContinuationToken();
                if (continuationToken == null || StringsKt.isBlank(continuationToken) || (str = this.challengeTarget) == null || StringsKt.isBlank(str) || (str2 = this.challengeChannel) == null || StringsKt.isBlank(str2) || this.codeLength == null) {
                    return unknownError;
                }
                return new JITChallengeApiResult.OOBRequired(getCorrelationId(), getContinuationToken(), getChallengeType(), this.bindingMethod, this.challengeTarget, this.challengeChannel, this.codeLength.intValue());
            }
            if (ApiErrorResponseUtilKt.isPreverified(getChallengeType())) {
                String continuationToken2 = getContinuationToken();
                if (continuationToken2 == null || StringsKt.isBlank(continuationToken2)) {
                    return unknownError;
                }
                return new JITChallengeApiResult.Preverified(getCorrelationId(), getContinuationToken());
            }
            if (ApiErrorResponseUtilKt.isRedirect(getChallengeType())) {
                String correlationId = getCorrelationId();
                String redirectReason = getRedirectReason();
                return new JITChallengeApiResult.Redirect(correlationId, redirectReason != null ? redirectReason : "");
            }
            String invalid_state2 = ApiErrorResult.INSTANCE.getINVALID_STATE();
            List<Integer> listEmptyList2 = this.errorCodes;
            if (listEmptyList2 == null) {
                listEmptyList2 = CollectionsKt.emptyList();
            }
            return new JITChallengeApiResult.UnknownError(getCorrelationId(), invalid_state2, "register/challenge. Received unexpected challenge type value. Expected OOB or PREVERIFIED", listEmptyList2);
        }
        if (statusCode == 400) {
            if (ApiErrorResponseUtilKt.isInvalidRequest(getError())) {
                List<Integer> list = this.errorCodes;
                if (ApiErrorResponseUtilKt.isInvalidChallengeTarget(list != null ? (Integer) CollectionsKt.first((List) list) : null)) {
                    String error = getError();
                    if (error == null) {
                        error = "";
                    }
                    String errorDescription = getErrorDescription();
                    str3 = errorDescription != null ? errorDescription : "";
                    List<Integer> listEmptyList3 = this.errorCodes;
                    if (listEmptyList3 == null) {
                        listEmptyList3 = CollectionsKt.emptyList();
                    }
                    return new JITChallengeApiResult.InvalidVerificationContact(getCorrelationId(), error, str3, listEmptyList3);
                }
            }
            if (ApiErrorResponseUtilKt.isAccessDenied(getError()) && ApiErrorResponseUtilKt.isProviderBlocked(this.subError)) {
                String error2 = getError();
                if (error2 == null) {
                    error2 = "";
                }
                String errorDescription2 = getErrorDescription();
                str3 = errorDescription2 != null ? errorDescription2 : "";
                List<Integer> listEmptyList4 = this.errorCodes;
                if (listEmptyList4 == null) {
                    listEmptyList4 = CollectionsKt.emptyList();
                }
                return new JITChallengeApiResult.BlockedVerificationContact(getCorrelationId(), error2, str3, listEmptyList4);
            }
            String error3 = getError();
            if (error3 == null) {
                error3 = "";
            }
            String errorDescription3 = getErrorDescription();
            str3 = errorDescription3 != null ? errorDescription3 : "";
            List<Integer> listEmptyList5 = this.errorCodes;
            if (listEmptyList5 == null) {
                listEmptyList5 = CollectionsKt.emptyList();
            }
            return new JITChallengeApiResult.UnknownError(getCorrelationId(), error3, str3, listEmptyList5);
        }
        String error4 = getError();
        if (error4 == null) {
            error4 = "";
        }
        String errorDescription4 = getErrorDescription();
        str3 = errorDescription4 != null ? errorDescription4 : "";
        List<Integer> listEmptyList6 = this.errorCodes;
        if (listEmptyList6 == null) {
            listEmptyList6 = CollectionsKt.emptyList();
        }
        return new JITChallengeApiResult.UnknownError(getCorrelationId(), error4, str3, listEmptyList6);
    }
}
