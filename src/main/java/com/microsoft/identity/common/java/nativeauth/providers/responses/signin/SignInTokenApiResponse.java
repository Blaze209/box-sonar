package com.microsoft.identity.common.java.nativeauth.providers.responses.signin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.nativeauth.providers.INativeAuthApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult;
import com.microsoft.identity.common.java.nativeauth.util.ApiErrorResponseUtilKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignInTokenApiResponse.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eBW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResponse;", "Lcom/microsoft/identity/common/java/nativeauth/providers/INativeAuthApiResponse;", "statusCode", "", "correlationId", "", "continuationToken", "error", "errorDescription", "errorUri", "subError", "errorCodes", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getContinuationToken", "()Ljava/lang/String;", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "getErrorUri", "getStatusCode", "()I", "setStatusCode", "(I)V", "getSubError", "toErrorResult", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult;", "toString", "toUnsanitizedString", "Companion", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SignInTokenApiResponse extends INativeAuthApiResponse {
    private static final String TAG = "SignInTokenApiResponse";

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

    public final List<Integer> getErrorCodes() {
        return this.errorCodes;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignInTokenApiResponse(int i, String correlationId, String str, String str2, String str3, String str4, String str5, List<Integer> list) {
        super(i, correlationId, str, null, null, str2, str3, 24, null);
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        this.statusCode = i;
        this.continuationToken = str;
        this.error = str2;
        this.errorDescription = str3;
        this.errorUri = str4;
        this.subError = str5;
        this.errorCodes = list;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "SignInTokenApiResponse(statusCode=" + getStatusCode() + ", correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + ", errorCodes=" + this.errorCodes + ", errorUri=" + this.errorUri + ", subError=" + this.subError + ')';
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return "SignInTokenApiResponse(statusCode=" + getStatusCode() + ", correlationId=" + getCorrelationId();
    }

    public final SignInTokenApiResult toErrorResult() {
        String str;
        SignInTokenApiResult.UnknownError unknownError;
        if (ApiErrorResponseUtilKt.isInvalidRequest(getError())) {
            List<Integer> list = this.errorCodes;
            if (list == null || list.isEmpty()) {
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
                unknownError = new SignInTokenApiResult.UnknownError(getCorrelationId(), error, str, listEmptyList);
            } else if (ApiErrorResponseUtilKt.isPasswordChangeRequired(this.errorCodes.get(0))) {
                StringBuilder sb = new StringBuilder("User password change is required, which can't be fulfilled as part of this flow. Please reset the password and perform a new sign in operation. More information:");
                String errorDescription2 = getErrorDescription();
                if (errorDescription2 == null) {
                    errorDescription2 = "";
                }
                String string = sb.append(errorDescription2).toString();
                String error2 = getError();
                unknownError = new SignInTokenApiResult.UnknownError(getCorrelationId(), error2 != null ? error2 : "", string, this.errorCodes);
            } else {
                String error3 = getError();
                if (error3 == null) {
                    error3 = "";
                }
                String errorDescription3 = getErrorDescription();
                unknownError = new SignInTokenApiResult.UnknownError(getCorrelationId(), error3, errorDescription3 != null ? errorDescription3 : "", this.errorCodes);
            }
            return unknownError;
        }
        if (ApiErrorResponseUtilKt.isInvalidGrant(getError())) {
            List<Integer> list2 = this.errorCodes;
            if (list2 != null && !list2.isEmpty() && ApiErrorResponseUtilKt.isInvalidCredentials(this.errorCodes.get(0))) {
                String error4 = getError();
                if (error4 == null) {
                    error4 = "";
                }
                String errorDescription4 = getErrorDescription();
                return new SignInTokenApiResult.InvalidCredentials(getCorrelationId(), error4, errorDescription4 != null ? errorDescription4 : "", this.errorCodes);
            }
            if (ApiErrorResponseUtilKt.isMFARequired(this.subError)) {
                String error5 = getError();
                String str2 = error5 == null ? "" : error5;
                String errorDescription5 = getErrorDescription();
                String str3 = errorDescription5 == null ? "" : errorDescription5;
                String continuationToken = getContinuationToken();
                if (continuationToken == null) {
                    String invalid_state = ApiErrorResult.INSTANCE.getINVALID_STATE();
                    List<Integer> listEmptyList2 = this.errorCodes;
                    if (listEmptyList2 == null) {
                        listEmptyList2 = CollectionsKt.emptyList();
                    }
                    return new SignInTokenApiResult.UnknownError(getCorrelationId(), invalid_state, "oauth/v2.0/token did not return a continuation token", listEmptyList2);
                }
                String str4 = this.subError;
                String str5 = str4 == null ? "" : str4;
                List<Integer> listEmptyList3 = this.errorCodes;
                if (listEmptyList3 == null) {
                    listEmptyList3 = CollectionsKt.emptyList();
                }
                return new SignInTokenApiResult.MFARequired(getCorrelationId(), continuationToken, str2, str5, str3, listEmptyList3);
            }
            if (ApiErrorResponseUtilKt.isJITRequired(this.subError)) {
                String error6 = getError();
                String str6 = error6 == null ? "" : error6;
                String errorDescription6 = getErrorDescription();
                String str7 = errorDescription6 == null ? "" : errorDescription6;
                String continuationToken2 = getContinuationToken();
                if (continuationToken2 == null) {
                    String invalid_state2 = ApiErrorResult.INSTANCE.getINVALID_STATE();
                    List<Integer> listEmptyList4 = this.errorCodes;
                    if (listEmptyList4 == null) {
                        listEmptyList4 = CollectionsKt.emptyList();
                    }
                    return new SignInTokenApiResult.UnknownError(getCorrelationId(), invalid_state2, "oauth/v2.0/token did not return a continuation token", listEmptyList4);
                }
                String str8 = this.subError;
                String str9 = str8 == null ? "" : str8;
                List<Integer> listEmptyList5 = this.errorCodes;
                if (listEmptyList5 == null) {
                    listEmptyList5 = CollectionsKt.emptyList();
                }
                return new SignInTokenApiResult.JITRequired(getCorrelationId(), continuationToken2, str6, str9, str7, listEmptyList5);
            }
            if (ApiErrorResponseUtilKt.isInvalidOOBValue(this.subError)) {
                String error7 = getError();
                String str10 = error7 == null ? "" : error7;
                String errorDescription7 = getErrorDescription();
                String str11 = errorDescription7 == null ? "" : errorDescription7;
                List<Integer> listEmptyList6 = this.errorCodes;
                if (listEmptyList6 == null) {
                    listEmptyList6 = CollectionsKt.emptyList();
                }
                List<Integer> list3 = listEmptyList6;
                String str12 = this.subError;
                return new SignInTokenApiResult.CodeIncorrect(getCorrelationId(), str10, str11, list3, str12 == null ? "" : str12);
            }
            List<Integer> list4 = this.errorCodes;
            if (list4 != null && !list4.isEmpty() && ApiErrorResponseUtilKt.isInvalidAuthenticationType(this.errorCodes.get(0))) {
                String error8 = getError();
                if (error8 == null) {
                    error8 = "";
                }
                String errorDescription8 = getErrorDescription();
                return new SignInTokenApiResult.InvalidAuthenticationType(getCorrelationId(), error8, errorDescription8 != null ? errorDescription8 : "", this.errorCodes);
            }
            String error9 = getError();
            if (error9 == null) {
                error9 = "";
            }
            String errorDescription9 = getErrorDescription();
            str = errorDescription9 != null ? errorDescription9 : "";
            List<Integer> listEmptyList7 = this.errorCodes;
            if (listEmptyList7 == null) {
                listEmptyList7 = CollectionsKt.emptyList();
            }
            return new SignInTokenApiResult.UnknownError(getCorrelationId(), error9, str, listEmptyList7);
        }
        if (ApiErrorResponseUtilKt.isUserNotFound(getError())) {
            String error10 = getError();
            if (error10 == null) {
                error10 = "";
            }
            String errorDescription10 = getErrorDescription();
            str = errorDescription10 != null ? errorDescription10 : "";
            List<Integer> listEmptyList8 = this.errorCodes;
            if (listEmptyList8 == null) {
                listEmptyList8 = CollectionsKt.emptyList();
            }
            return new SignInTokenApiResult.UserNotFound(getCorrelationId(), error10, str, listEmptyList8);
        }
        String error11 = getError();
        if (error11 == null) {
            error11 = "";
        }
        String errorDescription11 = getErrorDescription();
        str = errorDescription11 != null ? errorDescription11 : "";
        List<Integer> listEmptyList9 = this.errorCodes;
        if (listEmptyList9 == null) {
            listEmptyList9 = CollectionsKt.emptyList();
        }
        return new SignInTokenApiResult.UnknownError(getCorrelationId(), error11, str, listEmptyList9);
    }
}
