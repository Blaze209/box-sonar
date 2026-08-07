package com.microsoft.identity.common.java.nativeauth.providers;

import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.nativeauth.providers.responses.jit.JITChallengeApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.jit.JITContinueApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.jit.JITIntrospectApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordChallengeApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordContinueApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordPollCompletionApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordStartApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordSubmitApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.NativeAuthMicrosoftStsTokenResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInChallengeApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInInitiateApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInIntrospectApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInTokenApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInTokenApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signup.SignUpChallengeApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signup.SignUpContinueApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signup.SignUpStartApiResponse;
import com.microsoft.identity.common.java.nativeauth.util.ApiErrorResponseUtilKt;
import com.microsoft.identity.common.java.nativeauth.util.ApiResultUtil;
import com.microsoft.identity.common.java.net.HttpResponse;
import com.microsoft.identity.common.java.util.ObjectMapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: NativeAuthResponseHandler.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010!\u001a\u00020\"2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010#\u001a\u00020$2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010%\u001a\u00020&2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010'\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0004H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthResponseHandler;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getJITChallengeApiResponseFromHttpResponse", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/jit/JITChallengeApiResponse;", "requestCorrelationId", "response", "Lcom/microsoft/identity/common/java/net/HttpResponse;", "getJITContinueApiResponseFromHttpResponse", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/jit/JITContinueApiResponse;", "getJITIntrospectApiResponseFromHttpResponse", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/jit/JITIntrospectApiResponse;", "getResetPasswordChallengeApiResponseFromHttpResponse", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordChallengeApiResponse;", "getResetPasswordContinueApiResponseFromHttpResponse", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordContinueApiResponse;", "getResetPasswordPollCompletionApiResponseFromHttpResponse", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordPollCompletionApiResponse;", "getResetPasswordStartApiResponseFromHttpResponse", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordStartApiResponse;", "getResetPasswordSubmitApiResponseFromHttpResponse", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordSubmitApiResponse;", "getSignInChallengeResultFromHttpResponse", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInChallengeApiResponse;", "getSignInInitiateResultFromHttpResponse", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInInitiateApiResponse;", "getSignInIntrospectResultFromHttpResponse", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInIntrospectApiResponse;", "getSignInTokenApiResultFromHttpResponse", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult;", "getSignUpChallengeResultFromHttpResponse", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpChallengeApiResponse;", "getSignUpContinueResultFromHttpResponse", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResponse;", "getSignUpStartResultFromHttpResponse", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResponse;", "retrieveCorrelationId", "Companion", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NativeAuthResponseHandler {
    public static final String EMPTY_RESPONSE_ERROR = "empty_response_error";
    public static final String EMPTY_RESPONSE_ERROR_ERROR_DESCRIPTION = "API response body is empty";
    private final String TAG = "NativeAuthResponseHandler";

    public final SignUpStartApiResponse getSignUpStartResultFromHttpResponse(String requestCorrelationId, HttpResponse response) throws ClientException {
        SignUpStartApiResponse result;
        Intrinsics.checkNotNullParameter(requestCorrelationId, "requestCorrelationId");
        Intrinsics.checkNotNullParameter(response, "response");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, null, this.TAG + ".getSignUpStartResultFromHttpResponse");
        String strRetrieveCorrelationId = retrieveCorrelationId(response, requestCorrelationId);
        String body = response.getBody();
        if (body == null || StringsKt.isBlank(body)) {
            result = new SignUpStartApiResponse(response.getStatusCode(), strRetrieveCorrelationId, null, null, null, EMPTY_RESPONSE_ERROR, EMPTY_RESPONSE_ERROR_ERROR_DESCRIPTION, null, null, null, null);
        } else {
            result = (SignUpStartApiResponse) ObjectMapper.deserializeJsonStringToObject(response.getBody(), SignUpStartApiResponse.class);
        }
        result.setStatusCode(response.getStatusCode());
        result.setCorrelationId$common4j(strRetrieveCorrelationId);
        ApiResultUtil apiResultUtil = ApiResultUtil.INSTANCE;
        String TAG2 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        apiResultUtil.logResponse(TAG2, result);
        return result;
    }

    public final SignUpChallengeApiResponse getSignUpChallengeResultFromHttpResponse(String requestCorrelationId, HttpResponse response) throws ClientException {
        SignUpChallengeApiResponse result;
        Intrinsics.checkNotNullParameter(requestCorrelationId, "requestCorrelationId");
        Intrinsics.checkNotNullParameter(response, "response");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, null, this.TAG + ".getSignUpChallengeResultFromHttpResponse");
        String strRetrieveCorrelationId = retrieveCorrelationId(response, requestCorrelationId);
        String body = response.getBody();
        if (body == null || StringsKt.isBlank(body)) {
            result = new SignUpChallengeApiResponse(response.getStatusCode(), strRetrieveCorrelationId, null, null, null, null, null, null, EMPTY_RESPONSE_ERROR, EMPTY_RESPONSE_ERROR_ERROR_DESCRIPTION, null, null);
        } else {
            result = (SignUpChallengeApiResponse) ObjectMapper.deserializeJsonStringToObject(response.getBody(), SignUpChallengeApiResponse.class);
        }
        result.setStatusCode(response.getStatusCode());
        result.setCorrelationId$common4j(strRetrieveCorrelationId);
        ApiResultUtil apiResultUtil = ApiResultUtil.INSTANCE;
        String TAG2 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        apiResultUtil.logResponse(TAG2, result);
        return result;
    }

    public final SignUpContinueApiResponse getSignUpContinueResultFromHttpResponse(String requestCorrelationId, HttpResponse response) throws ClientException {
        SignUpContinueApiResponse result;
        Intrinsics.checkNotNullParameter(requestCorrelationId, "requestCorrelationId");
        Intrinsics.checkNotNullParameter(response, "response");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, null, this.TAG + ".getSignUpContinueResultFromHttpResponse");
        String strRetrieveCorrelationId = retrieveCorrelationId(response, requestCorrelationId);
        String body = response.getBody();
        if (body == null || StringsKt.isBlank(body)) {
            result = new SignUpContinueApiResponse(response.getStatusCode(), strRetrieveCorrelationId, null, null, null, null, null, EMPTY_RESPONSE_ERROR, EMPTY_RESPONSE_ERROR_ERROR_DESCRIPTION, null, null, null, null);
        } else {
            result = (SignUpContinueApiResponse) ObjectMapper.deserializeJsonStringToObject(response.getBody(), SignUpContinueApiResponse.class);
        }
        result.setStatusCode(response.getStatusCode());
        result.setCorrelationId$common4j(strRetrieveCorrelationId);
        ApiResultUtil apiResultUtil = ApiResultUtil.INSTANCE;
        String TAG2 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        apiResultUtil.logResponse(TAG2, result);
        return result;
    }

    public final SignInInitiateApiResponse getSignInInitiateResultFromHttpResponse(String requestCorrelationId, HttpResponse response) throws ClientException {
        SignInInitiateApiResponse result;
        Intrinsics.checkNotNullParameter(requestCorrelationId, "requestCorrelationId");
        Intrinsics.checkNotNullParameter(response, "response");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, null, this.TAG + ".getSignInInitiateResultFromHttpResponse");
        String strRetrieveCorrelationId = retrieveCorrelationId(response, requestCorrelationId);
        String body = response.getBody();
        if (body == null || StringsKt.isBlank(body)) {
            result = new SignInInitiateApiResponse(response.getStatusCode(), strRetrieveCorrelationId, null, EMPTY_RESPONSE_ERROR, EMPTY_RESPONSE_ERROR_ERROR_DESCRIPTION, null, null, null, null);
        } else {
            result = (SignInInitiateApiResponse) ObjectMapper.deserializeJsonStringToObject(response.getBody(), SignInInitiateApiResponse.class);
        }
        result.setStatusCode(response.getStatusCode());
        result.setCorrelationId$common4j(strRetrieveCorrelationId);
        ApiResultUtil apiResultUtil = ApiResultUtil.INSTANCE;
        String TAG2 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        apiResultUtil.logResponse(TAG2, result);
        return result;
    }

    public final SignInChallengeApiResponse getSignInChallengeResultFromHttpResponse(String requestCorrelationId, HttpResponse response) throws ClientException {
        SignInChallengeApiResponse result;
        Intrinsics.checkNotNullParameter(requestCorrelationId, "requestCorrelationId");
        Intrinsics.checkNotNullParameter(response, "response");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, null, this.TAG + ".getSignInChallengeResultFromHttpResponse");
        String strRetrieveCorrelationId = retrieveCorrelationId(response, requestCorrelationId);
        String body = response.getBody();
        if (body == null || StringsKt.isBlank(body)) {
            result = new SignInChallengeApiResponse(response.getStatusCode(), strRetrieveCorrelationId, null, null, null, null, null, null, EMPTY_RESPONSE_ERROR, EMPTY_RESPONSE_ERROR_ERROR_DESCRIPTION, null, null, null, null, null);
        } else {
            result = (SignInChallengeApiResponse) ObjectMapper.deserializeJsonStringToObject(response.getBody(), SignInChallengeApiResponse.class);
        }
        result.setStatusCode(response.getStatusCode());
        result.setCorrelationId$common4j(strRetrieveCorrelationId);
        ApiResultUtil apiResultUtil = ApiResultUtil.INSTANCE;
        String TAG2 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        apiResultUtil.logResponse(TAG2, result);
        return result;
    }

    public final SignInIntrospectApiResponse getSignInIntrospectResultFromHttpResponse(String requestCorrelationId, HttpResponse response) throws ClientException {
        SignInIntrospectApiResponse result;
        Intrinsics.checkNotNullParameter(requestCorrelationId, "requestCorrelationId");
        Intrinsics.checkNotNullParameter(response, "response");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, null, this.TAG + ".getSignInIntrospectResultFromHttpResponse");
        String strRetrieveCorrelationId = retrieveCorrelationId(response, requestCorrelationId);
        String body = response.getBody();
        if (body == null || StringsKt.isBlank(body)) {
            result = new SignInIntrospectApiResponse(response.getStatusCode(), strRetrieveCorrelationId, null, null, EMPTY_RESPONSE_ERROR, EMPTY_RESPONSE_ERROR_ERROR_DESCRIPTION, null, null, null);
        } else {
            result = (SignInIntrospectApiResponse) ObjectMapper.deserializeJsonStringToObject(response.getBody(), SignInIntrospectApiResponse.class);
        }
        result.setStatusCode(response.getStatusCode());
        result.setCorrelationId$common4j(strRetrieveCorrelationId);
        ApiResultUtil apiResultUtil = ApiResultUtil.INSTANCE;
        String TAG2 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        apiResultUtil.logResponse(TAG2, result);
        return result;
    }

    public final SignInTokenApiResult getSignInTokenApiResultFromHttpResponse(String requestCorrelationId, HttpResponse response) throws ClientException {
        SignInTokenApiResponse apiResponse;
        Intrinsics.checkNotNullParameter(requestCorrelationId, "requestCorrelationId");
        Intrinsics.checkNotNullParameter(response, "response");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, null, this.TAG + ".getSignInTokenApiResultFromHttpResponse");
        String strRetrieveCorrelationId = retrieveCorrelationId(response, requestCorrelationId);
        if (response.getStatusCode() >= 400) {
            String body = response.getBody();
            if (body == null || StringsKt.isBlank(body)) {
                apiResponse = new SignInTokenApiResponse(response.getStatusCode(), strRetrieveCorrelationId, null, null, null, null, null, null);
            } else {
                apiResponse = (SignInTokenApiResponse) ObjectMapper.deserializeJsonStringToObject(response.getBody(), SignInTokenApiResponse.class);
            }
            apiResponse.setStatusCode(response.getStatusCode());
            apiResponse.setCorrelationId$common4j(strRetrieveCorrelationId);
            ApiResultUtil apiResultUtil = ApiResultUtil.INSTANCE;
            String TAG2 = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Intrinsics.checkNotNullExpressionValue(apiResponse, "apiResponse");
            apiResultUtil.logResponse(TAG2, apiResponse);
            return apiResponse.toErrorResult();
        }
        NativeAuthMicrosoftStsTokenResponse apiResponse2 = (NativeAuthMicrosoftStsTokenResponse) ObjectMapper.deserializeJsonStringToObject(response.getBody(), NativeAuthMicrosoftStsTokenResponse.class);
        if (ApiErrorResponseUtilKt.isRedirect(apiResponse2.getChallengeType())) {
            String redirectReason = apiResponse2.getRedirectReason();
            if (redirectReason == null) {
                redirectReason = "";
            }
            return new SignInTokenApiResult.Redirect(strRetrieveCorrelationId, redirectReason);
        }
        Intrinsics.checkNotNullExpressionValue(apiResponse2, "apiResponse");
        return new SignInTokenApiResult.Success(strRetrieveCorrelationId, apiResponse2);
    }

    public final ResetPasswordStartApiResponse getResetPasswordStartApiResponseFromHttpResponse(String requestCorrelationId, HttpResponse response) throws ClientException {
        ResetPasswordStartApiResponse result;
        Intrinsics.checkNotNullParameter(requestCorrelationId, "requestCorrelationId");
        Intrinsics.checkNotNullParameter(response, "response");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, null, this.TAG + ".getResetPasswordStartApiResponseFromHttpResponse");
        String strRetrieveCorrelationId = retrieveCorrelationId(response, requestCorrelationId);
        String body = response.getBody();
        if (body == null || StringsKt.isBlank(body)) {
            result = new ResetPasswordStartApiResponse(response.getStatusCode(), strRetrieveCorrelationId, null, null, EMPTY_RESPONSE_ERROR, EMPTY_RESPONSE_ERROR_ERROR_DESCRIPTION, null, null);
        } else {
            result = (ResetPasswordStartApiResponse) ObjectMapper.deserializeJsonStringToObject(response.getBody(), ResetPasswordStartApiResponse.class);
        }
        result.setStatusCode(response.getStatusCode());
        result.setCorrelationId$common4j(strRetrieveCorrelationId);
        ApiResultUtil apiResultUtil = ApiResultUtil.INSTANCE;
        String TAG2 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        apiResultUtil.logResponse(TAG2, result);
        return result;
    }

    public final ResetPasswordChallengeApiResponse getResetPasswordChallengeApiResponseFromHttpResponse(String requestCorrelationId, HttpResponse response) throws ClientException {
        ResetPasswordChallengeApiResponse result;
        Intrinsics.checkNotNullParameter(requestCorrelationId, "requestCorrelationId");
        Intrinsics.checkNotNullParameter(response, "response");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, null, this.TAG + ".getResetPasswordChallengeApiResponseFromHttpResponse");
        String strRetrieveCorrelationId = retrieveCorrelationId(response, requestCorrelationId);
        String body = response.getBody();
        if (body == null || StringsKt.isBlank(body)) {
            result = new ResetPasswordChallengeApiResponse(response.getStatusCode(), strRetrieveCorrelationId, null, null, null, null, null, null, EMPTY_RESPONSE_ERROR, EMPTY_RESPONSE_ERROR_ERROR_DESCRIPTION, null, null, null);
        } else {
            result = (ResetPasswordChallengeApiResponse) ObjectMapper.deserializeJsonStringToObject(response.getBody(), ResetPasswordChallengeApiResponse.class);
        }
        result.setStatusCode(response.getStatusCode());
        result.setCorrelationId$common4j(strRetrieveCorrelationId);
        ApiResultUtil apiResultUtil = ApiResultUtil.INSTANCE;
        String TAG2 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        apiResultUtil.logResponse(TAG2, result);
        return result;
    }

    public final ResetPasswordContinueApiResponse getResetPasswordContinueApiResponseFromHttpResponse(String requestCorrelationId, HttpResponse response) throws ClientException {
        ResetPasswordContinueApiResponse result;
        Intrinsics.checkNotNullParameter(requestCorrelationId, "requestCorrelationId");
        Intrinsics.checkNotNullParameter(response, "response");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, null, this.TAG + ".getResetPasswordContinueApiResponseFromHttpResponse");
        String strRetrieveCorrelationId = retrieveCorrelationId(response, requestCorrelationId);
        String body = response.getBody();
        if (body == null || StringsKt.isBlank(body)) {
            result = new ResetPasswordContinueApiResponse(response.getStatusCode(), strRetrieveCorrelationId, null, null, EMPTY_RESPONSE_ERROR, EMPTY_RESPONSE_ERROR_ERROR_DESCRIPTION, null, null, null, null);
        } else {
            result = (ResetPasswordContinueApiResponse) ObjectMapper.deserializeJsonStringToObject(response.getBody(), ResetPasswordContinueApiResponse.class);
        }
        result.setStatusCode(response.getStatusCode());
        result.setCorrelationId$common4j(strRetrieveCorrelationId);
        ApiResultUtil apiResultUtil = ApiResultUtil.INSTANCE;
        String TAG2 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        apiResultUtil.logResponse(TAG2, result);
        return result;
    }

    public final ResetPasswordSubmitApiResponse getResetPasswordSubmitApiResponseFromHttpResponse(String requestCorrelationId, HttpResponse response) throws ClientException {
        ResetPasswordSubmitApiResponse result;
        Intrinsics.checkNotNullParameter(requestCorrelationId, "requestCorrelationId");
        Intrinsics.checkNotNullParameter(response, "response");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, null, this.TAG + ".getResetPasswordSubmitApiResponseFromHttpResponse");
        String strRetrieveCorrelationId = retrieveCorrelationId(response, requestCorrelationId);
        String body = response.getBody();
        if (body == null || StringsKt.isBlank(body)) {
            result = new ResetPasswordSubmitApiResponse(response.getStatusCode(), strRetrieveCorrelationId, null, null, EMPTY_RESPONSE_ERROR, EMPTY_RESPONSE_ERROR_ERROR_DESCRIPTION, null, null, null, null);
        } else {
            result = (ResetPasswordSubmitApiResponse) ObjectMapper.deserializeJsonStringToObject(response.getBody(), ResetPasswordSubmitApiResponse.class);
        }
        result.setStatusCode(response.getStatusCode());
        result.setCorrelationId$common4j(strRetrieveCorrelationId);
        ApiResultUtil apiResultUtil = ApiResultUtil.INSTANCE;
        String TAG2 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        apiResultUtil.logResponse(TAG2, result);
        return result;
    }

    public final ResetPasswordPollCompletionApiResponse getResetPasswordPollCompletionApiResponseFromHttpResponse(String requestCorrelationId, HttpResponse response) throws ClientException {
        ResetPasswordPollCompletionApiResponse result;
        Intrinsics.checkNotNullParameter(requestCorrelationId, "requestCorrelationId");
        Intrinsics.checkNotNullParameter(response, "response");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, null, this.TAG + ".getResetPasswordPollCompletionApiResponseFromHttpResponse");
        String strRetrieveCorrelationId = retrieveCorrelationId(response, requestCorrelationId);
        String body = response.getBody();
        if (body == null || StringsKt.isBlank(body)) {
            result = new ResetPasswordPollCompletionApiResponse(response.getStatusCode(), strRetrieveCorrelationId, null, null, null, EMPTY_RESPONSE_ERROR, EMPTY_RESPONSE_ERROR_ERROR_DESCRIPTION, null, null, null, null);
        } else {
            result = (ResetPasswordPollCompletionApiResponse) ObjectMapper.deserializeJsonStringToObject(response.getBody(), ResetPasswordPollCompletionApiResponse.class);
        }
        result.setStatusCode(response.getStatusCode());
        result.setCorrelationId$common4j(strRetrieveCorrelationId);
        ApiResultUtil apiResultUtil = ApiResultUtil.INSTANCE;
        String TAG2 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        apiResultUtil.logResponse(TAG2, result);
        return result;
    }

    public final JITIntrospectApiResponse getJITIntrospectApiResponseFromHttpResponse(String requestCorrelationId, HttpResponse response) throws ClientException {
        JITIntrospectApiResponse result;
        Intrinsics.checkNotNullParameter(requestCorrelationId, "requestCorrelationId");
        Intrinsics.checkNotNullParameter(response, "response");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, null, this.TAG + ".getJITIntrospectApiResponseFromHttpResponse");
        String strRetrieveCorrelationId = retrieveCorrelationId(response, requestCorrelationId);
        String body = response.getBody();
        if (body == null || StringsKt.isBlank(body)) {
            result = new JITIntrospectApiResponse(response.getStatusCode(), strRetrieveCorrelationId, null, null, EMPTY_RESPONSE_ERROR, EMPTY_RESPONSE_ERROR_ERROR_DESCRIPTION, null, null, null, null);
        } else {
            result = (JITIntrospectApiResponse) ObjectMapper.deserializeJsonStringToObject(response.getBody(), JITIntrospectApiResponse.class);
        }
        result.setStatusCode(response.getStatusCode());
        result.setCorrelationId$common4j(strRetrieveCorrelationId);
        ApiResultUtil apiResultUtil = ApiResultUtil.INSTANCE;
        String TAG2 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        apiResultUtil.logResponse(TAG2, result);
        return result;
    }

    public final JITChallengeApiResponse getJITChallengeApiResponseFromHttpResponse(String requestCorrelationId, HttpResponse response) throws ClientException {
        JITChallengeApiResponse result;
        Intrinsics.checkNotNullParameter(requestCorrelationId, "requestCorrelationId");
        Intrinsics.checkNotNullParameter(response, "response");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, null, this.TAG + ".getJITChallengeApiResponseFromHttpResponse");
        String strRetrieveCorrelationId = retrieveCorrelationId(response, requestCorrelationId);
        String body = response.getBody();
        if (body == null || StringsKt.isBlank(body)) {
            result = new JITChallengeApiResponse(response.getStatusCode(), strRetrieveCorrelationId, null, null, null, null, null, null, EMPTY_RESPONSE_ERROR, EMPTY_RESPONSE_ERROR_ERROR_DESCRIPTION, null, null, null, null, null);
        } else {
            result = (JITChallengeApiResponse) ObjectMapper.deserializeJsonStringToObject(response.getBody(), JITChallengeApiResponse.class);
        }
        result.setStatusCode(response.getStatusCode());
        result.setCorrelationId$common4j(strRetrieveCorrelationId);
        ApiResultUtil apiResultUtil = ApiResultUtil.INSTANCE;
        String TAG2 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        apiResultUtil.logResponse(TAG2, result);
        return result;
    }

    public final JITContinueApiResponse getJITContinueApiResponseFromHttpResponse(String requestCorrelationId, HttpResponse response) throws ClientException {
        JITContinueApiResponse result;
        Intrinsics.checkNotNullParameter(requestCorrelationId, "requestCorrelationId");
        Intrinsics.checkNotNullParameter(response, "response");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, null, this.TAG + ".getJITContinueApiResponseFromHttpResponse");
        String strRetrieveCorrelationId = retrieveCorrelationId(response, requestCorrelationId);
        String body = response.getBody();
        if (body == null || StringsKt.isBlank(body)) {
            result = new JITContinueApiResponse(response.getStatusCode(), strRetrieveCorrelationId, null, EMPTY_RESPONSE_ERROR, EMPTY_RESPONSE_ERROR_ERROR_DESCRIPTION, null, null, null, null);
        } else {
            result = (JITContinueApiResponse) ObjectMapper.deserializeJsonStringToObject(response.getBody(), JITContinueApiResponse.class);
        }
        result.setStatusCode(response.getStatusCode());
        result.setCorrelationId$common4j(strRetrieveCorrelationId);
        ApiResultUtil apiResultUtil = ApiResultUtil.INSTANCE;
        String TAG2 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        apiResultUtil.logResponse(TAG2, result);
        return result;
    }

    private final String retrieveCorrelationId(HttpResponse response, String requestCorrelationId) {
        String headerValue = response.getHeaderValue("client-request-id", 0);
        String str = headerValue;
        if (str == null || StringsKt.isBlank(str)) {
            return requestCorrelationId;
        }
        Intrinsics.checkNotNullExpressionValue(headerValue, "{\n                respon…rrelationId\n            }");
        return headerValue;
    }
}
