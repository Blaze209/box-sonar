package com.microsoft.identity.common.java.nativeauth.providers.interactors;

import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordStartCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordSubmitCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordSubmitNewPasswordCommandParameters;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthRequestProvider;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthResponseHandler;
import com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.resetpassword.ResetPasswordChallengeRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.resetpassword.ResetPasswordContinueRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.resetpassword.ResetPasswordPollCompletionRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.resetpassword.ResetPasswordStartRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.resetpassword.ResetPasswordSubmitRequest;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordChallengeApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordChallengeApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordContinueApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordContinueApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordPollCompletionApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordPollCompletionApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordStartApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordStartApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordSubmitApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordSubmitApiResult;
import com.microsoft.identity.common.java.net.HttpResponse;
import com.microsoft.identity.common.java.net.UrlConnectionHttpClient;
import com.microsoft.identity.common.java.util.ObjectMapper;
import com.microsoft.identity.common.java.util.StringUtil;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResetPasswordInteractor.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0019H\u0002J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u001cJ\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u001dH\u0002J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\"H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/interactors/ResetPasswordInteractor;", "", "httpClient", "Lcom/microsoft/identity/common/java/net/UrlConnectionHttpClient;", "nativeAuthRequestProvider", "Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthRequestProvider;", "nativeAuthResponseHandler", "Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthResponseHandler;", "(Lcom/microsoft/identity/common/java/net/UrlConnectionHttpClient;Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthRequestProvider;Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthResponseHandler;)V", "TAG", "", "performResetPasswordChallenge", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordChallengeApiResult;", "requestCorrelationId", "request", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordChallengeRequest;", "continuationToken", "correlationId", "performResetPasswordContinue", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordContinueApiResult;", "parameters", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/ResetPasswordSubmitCodeCommandParameters;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordContinueRequest;", "performResetPasswordPollCompletion", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordPollCompletionApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordPollCompletionRequest;", "performResetPasswordStart", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordStartApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/ResetPasswordStartCommandParameters;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordStartRequest;", "performResetPasswordSubmit", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordSubmitApiResult;", "commandParameters", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/ResetPasswordSubmitNewPasswordCommandParameters;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordSubmitRequest;", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ResetPasswordInteractor {
    private final String TAG;
    private final UrlConnectionHttpClient httpClient;
    private final NativeAuthRequestProvider nativeAuthRequestProvider;
    private final NativeAuthResponseHandler nativeAuthResponseHandler;

    public ResetPasswordInteractor(UrlConnectionHttpClient httpClient, NativeAuthRequestProvider nativeAuthRequestProvider, NativeAuthResponseHandler nativeAuthResponseHandler) {
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(nativeAuthRequestProvider, "nativeAuthRequestProvider");
        Intrinsics.checkNotNullParameter(nativeAuthResponseHandler, "nativeAuthResponseHandler");
        this.httpClient = httpClient;
        this.nativeAuthRequestProvider = nativeAuthRequestProvider;
        this.nativeAuthResponseHandler = nativeAuthResponseHandler;
        Intrinsics.checkNotNullExpressionValue("ResetPasswordInteractor", "ResetPasswordInteractor::class.java.simpleName");
        this.TAG = "ResetPasswordInteractor";
    }

    public final ResetPasswordStartApiResult performResetPasswordStart(ResetPasswordStartCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.INSTANCE.logMethodCall(this.TAG, parameters.getCorrelationId(), this.TAG + ".performResetPasswordStart(parameters: ResetPasswordStartCommandParameters)");
        ResetPasswordStartRequest resetPasswordStartRequestCreateResetPasswordStartRequest$common4j = this.nativeAuthRequestProvider.createResetPasswordStartRequest$common4j(parameters);
        Logger.infoWithObject(this.TAG + ".performResetPasswordStart", parameters.getCorrelationId(), "request = ", resetPasswordStartRequestCreateResetPasswordStartRequest$common4j);
        String correlationId = parameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "parameters.getCorrelationId()");
        return performResetPasswordStart(correlationId, resetPasswordStartRequestCreateResetPasswordStartRequest$common4j);
    }

    private final ResetPasswordStartApiResult performResetPasswordStart(String requestCorrelationId, ResetPasswordStartRequest request) throws UnsupportedEncodingException, ClientException {
        LogSession.INSTANCE.logMethodCall(this.TAG, requestCorrelationId, this.TAG + ".performResetPasswordStart");
        String strSerializeObjectToFormUrlEncoded = ObjectMapper.serializeObjectToFormUrlEncoded(request.getParameters());
        Intrinsics.checkNotNullExpressionValue(strSerializeObjectToFormUrlEncoded, "serializeObjectToFormUrl…coded(request.parameters)");
        Map<String, String> headers = request.getHeaders();
        URL requestUrl = request.getRequestUrl();
        UrlConnectionHttpClient urlConnectionHttpClient = this.httpClient;
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(charsetName)");
        byte[] bytes = strSerializeObjectToFormUrlEncoded.getBytes(charsetForName);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        HttpResponse httpResponse = urlConnectionHttpClient.post(requestUrl, headers, bytes);
        NativeAuthResponseHandler nativeAuthResponseHandler = this.nativeAuthResponseHandler;
        Intrinsics.checkNotNullExpressionValue(httpResponse, "httpResponse");
        ResetPasswordStartApiResponse resetPasswordStartApiResponseFromHttpResponse = nativeAuthResponseHandler.getResetPasswordStartApiResponseFromHttpResponse(requestCorrelationId, httpResponse);
        Logger.infoWithObject(this.TAG + ".rawResponseToResetPasswordStartApiResult", resetPasswordStartApiResponseFromHttpResponse.getCorrelationId(), "rawApiResponse = ", resetPasswordStartApiResponseFromHttpResponse);
        ResetPasswordStartApiResult result = resetPasswordStartApiResponseFromHttpResponse.toResult();
        Logger.infoWithObject(this.TAG + ".rawResponseToResetPasswordStartApiResult", result.getCorrelationId(), "result = ", result);
        return result;
    }

    public final ResetPasswordChallengeApiResult performResetPasswordChallenge(String continuationToken, String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        LogSession.INSTANCE.logMethodCall(this.TAG, correlationId, this.TAG + ".performResetPasswordChallenge(continuationToken: String)");
        ResetPasswordChallengeRequest resetPasswordChallengeRequestCreateResetPasswordChallengeRequest$common4j = this.nativeAuthRequestProvider.createResetPasswordChallengeRequest$common4j(continuationToken, correlationId);
        Logger.infoWithObject(this.TAG + ".performResetPasswordChallenge", correlationId, "request = ", resetPasswordChallengeRequestCreateResetPasswordChallengeRequest$common4j);
        return performResetPasswordChallenge(correlationId, resetPasswordChallengeRequestCreateResetPasswordChallengeRequest$common4j);
    }

    private final ResetPasswordChallengeApiResult performResetPasswordChallenge(String requestCorrelationId, ResetPasswordChallengeRequest request) throws UnsupportedEncodingException, ClientException {
        LogSession.INSTANCE.logMethodCall(this.TAG, requestCorrelationId, this.TAG + ".performResetPasswordChallenge");
        String strSerializeObjectToFormUrlEncoded = ObjectMapper.serializeObjectToFormUrlEncoded(request.getParameters());
        Intrinsics.checkNotNullExpressionValue(strSerializeObjectToFormUrlEncoded, "serializeObjectToFormUrl…coded(request.parameters)");
        Map<String, String> headers = request.getHeaders();
        URL requestUrl = request.getRequestUrl();
        UrlConnectionHttpClient urlConnectionHttpClient = this.httpClient;
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(charsetName)");
        byte[] bytes = strSerializeObjectToFormUrlEncoded.getBytes(charsetForName);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        HttpResponse httpResponse = urlConnectionHttpClient.post(requestUrl, headers, bytes);
        NativeAuthResponseHandler nativeAuthResponseHandler = this.nativeAuthResponseHandler;
        Intrinsics.checkNotNullExpressionValue(httpResponse, "httpResponse");
        ResetPasswordChallengeApiResponse resetPasswordChallengeApiResponseFromHttpResponse = nativeAuthResponseHandler.getResetPasswordChallengeApiResponseFromHttpResponse(requestCorrelationId, httpResponse);
        Logger.infoWithObject(this.TAG + ".rawResponseToResetPasswordChallengeApiResult", resetPasswordChallengeApiResponseFromHttpResponse.getCorrelationId(), "rawApiResponse = ", resetPasswordChallengeApiResponseFromHttpResponse);
        ResetPasswordChallengeApiResult result = resetPasswordChallengeApiResponseFromHttpResponse.toResult();
        Logger.infoWithObject(this.TAG + ".rawResponseToResetPasswordChallengeApiResult", result.getCorrelationId(), "result = ", result);
        return result;
    }

    public final ResetPasswordContinueApiResult performResetPasswordContinue(ResetPasswordSubmitCodeCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.INSTANCE.logMethodCall(this.TAG, parameters.getCorrelationId(), this.TAG + ".performResetPasswordContinue(parameters: ResetPasswordSubmitCodeCommandParameters)");
        ResetPasswordContinueRequest resetPasswordContinueRequestCreateResetPasswordContinueRequest$common4j = this.nativeAuthRequestProvider.createResetPasswordContinueRequest$common4j(parameters);
        Logger.infoWithObject(this.TAG + ".performResetPasswordContinue", parameters.getCorrelationId(), "request = ", resetPasswordContinueRequestCreateResetPasswordContinueRequest$common4j);
        String correlationId = parameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "parameters.getCorrelationId()");
        return performResetPasswordContinue(correlationId, resetPasswordContinueRequestCreateResetPasswordContinueRequest$common4j);
    }

    private final ResetPasswordContinueApiResult performResetPasswordContinue(String requestCorrelationId, ResetPasswordContinueRequest request) throws UnsupportedEncodingException, ClientException {
        LogSession.INSTANCE.logMethodCall(this.TAG, requestCorrelationId, this.TAG + ".performResetPasswordContinue");
        String strSerializeObjectToFormUrlEncoded = ObjectMapper.serializeObjectToFormUrlEncoded(request.getParameters());
        Intrinsics.checkNotNullExpressionValue(strSerializeObjectToFormUrlEncoded, "serializeObjectToFormUrl…coded(request.parameters)");
        Map<String, String> headers = request.getHeaders();
        URL requestUrl = request.getRequestUrl();
        UrlConnectionHttpClient urlConnectionHttpClient = this.httpClient;
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(charsetName)");
        byte[] bytes = strSerializeObjectToFormUrlEncoded.getBytes(charsetForName);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        HttpResponse httpResponse = urlConnectionHttpClient.post(requestUrl, headers, bytes);
        NativeAuthResponseHandler nativeAuthResponseHandler = this.nativeAuthResponseHandler;
        Intrinsics.checkNotNullExpressionValue(httpResponse, "httpResponse");
        ResetPasswordContinueApiResponse resetPasswordContinueApiResponseFromHttpResponse = nativeAuthResponseHandler.getResetPasswordContinueApiResponseFromHttpResponse(requestCorrelationId, httpResponse);
        Logger.infoWithObject(this.TAG + ".rawResponseToResetPasswordContinueApiResult", resetPasswordContinueApiResponseFromHttpResponse.getCorrelationId(), "rawApiResponse = ", resetPasswordContinueApiResponseFromHttpResponse);
        ResetPasswordContinueApiResult result = resetPasswordContinueApiResponseFromHttpResponse.toResult();
        Logger.infoWithObject(this.TAG + ".rawResponseToResetPasswordContinueApiResult", result.getCorrelationId(), "result = ", result);
        return result;
    }

    public final ResetPasswordSubmitApiResult performResetPasswordSubmit(ResetPasswordSubmitNewPasswordCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        LogSession.INSTANCE.logMethodCall(this.TAG, commandParameters.getCorrelationId(), this.TAG + ".performResetPasswordSubmit(commandParameters: ResetPasswordSubmitNewPasswordCommandParameters)");
        ResetPasswordSubmitRequest resetPasswordSubmitRequestCreateResetPasswordSubmitRequest$common4j = this.nativeAuthRequestProvider.createResetPasswordSubmitRequest$common4j(commandParameters);
        Logger.infoWithObject(this.TAG + ".performResetPasswordSubmit", commandParameters.getCorrelationId(), "request = ", resetPasswordSubmitRequestCreateResetPasswordSubmitRequest$common4j);
        try {
            String correlationId = commandParameters.getCorrelationId();
            Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
            return performResetPasswordSubmit(correlationId, resetPasswordSubmitRequestCreateResetPasswordSubmitRequest$common4j);
        } finally {
            NativeAuthRequest.NativeAuthRequestParameters parameters = resetPasswordSubmitRequestCreateResetPasswordSubmitRequest$common4j.getParameters();
            Intrinsics.checkNotNull(parameters, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.requests.resetpassword.ResetPasswordSubmitRequest.NativeAuthResetPasswordSubmitRequestParameters");
            StringUtil.overwriteWithNull(((ResetPasswordSubmitRequest.NativeAuthResetPasswordSubmitRequestParameters) parameters).getNewPassword());
        }
    }

    private final ResetPasswordSubmitApiResult performResetPasswordSubmit(String requestCorrelationId, ResetPasswordSubmitRequest request) throws UnsupportedEncodingException, ClientException {
        LogSession.INSTANCE.logMethodCall(this.TAG, requestCorrelationId, this.TAG + ".performResetPasswordSubmit");
        String strSerializeObjectToFormUrlEncoded = ObjectMapper.serializeObjectToFormUrlEncoded(request.getParameters());
        Intrinsics.checkNotNullExpressionValue(strSerializeObjectToFormUrlEncoded, "serializeObjectToFormUrl…coded(request.parameters)");
        Map<String, String> headers = request.getHeaders();
        URL requestUrl = request.getRequestUrl();
        UrlConnectionHttpClient urlConnectionHttpClient = this.httpClient;
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(charsetName)");
        byte[] bytes = strSerializeObjectToFormUrlEncoded.getBytes(charsetForName);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        HttpResponse httpResponse = urlConnectionHttpClient.post(requestUrl, headers, bytes);
        NativeAuthResponseHandler nativeAuthResponseHandler = this.nativeAuthResponseHandler;
        Intrinsics.checkNotNullExpressionValue(httpResponse, "httpResponse");
        ResetPasswordSubmitApiResponse resetPasswordSubmitApiResponseFromHttpResponse = nativeAuthResponseHandler.getResetPasswordSubmitApiResponseFromHttpResponse(requestCorrelationId, httpResponse);
        Logger.infoWithObject(this.TAG + ".rawResponseToResetPasswordContinueApiResult", resetPasswordSubmitApiResponseFromHttpResponse.getCorrelationId(), "rawApiResponse = ", resetPasswordSubmitApiResponseFromHttpResponse);
        ResetPasswordSubmitApiResult result = resetPasswordSubmitApiResponseFromHttpResponse.toResult();
        Logger.infoWithObject(this.TAG + ".rawResponseToResetPasswordSubmitApiResult", result.getCorrelationId(), "result = ", result);
        return result;
    }

    public final ResetPasswordPollCompletionApiResult performResetPasswordPollCompletion(String continuationToken, String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        LogSession.INSTANCE.logMethodCall(this.TAG, correlationId, this.TAG + ".performResetPasswordPollCompletion(continuationToken: String)");
        ResetPasswordPollCompletionRequest resetPasswordPollCompletionRequestCreateResetPasswordPollCompletionRequest$common4j = this.nativeAuthRequestProvider.createResetPasswordPollCompletionRequest$common4j(continuationToken, correlationId);
        Logger.infoWithObject(this.TAG + ".performResetPasswordPollCompletion", correlationId, "request = ", resetPasswordPollCompletionRequestCreateResetPasswordPollCompletionRequest$common4j);
        return performResetPasswordPollCompletion(correlationId, resetPasswordPollCompletionRequestCreateResetPasswordPollCompletionRequest$common4j);
    }

    private final ResetPasswordPollCompletionApiResult performResetPasswordPollCompletion(String requestCorrelationId, ResetPasswordPollCompletionRequest request) throws UnsupportedEncodingException, ClientException {
        LogSession.INSTANCE.logMethodCall(this.TAG, requestCorrelationId, this.TAG + ".performResetPasswordPollCompletion");
        String strSerializeObjectToFormUrlEncoded = ObjectMapper.serializeObjectToFormUrlEncoded(request.getParameters());
        Intrinsics.checkNotNullExpressionValue(strSerializeObjectToFormUrlEncoded, "serializeObjectToFormUrl…coded(request.parameters)");
        Map<String, String> headers = request.getHeaders();
        URL requestUrl = request.getRequestUrl();
        UrlConnectionHttpClient urlConnectionHttpClient = this.httpClient;
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(charsetName)");
        byte[] bytes = strSerializeObjectToFormUrlEncoded.getBytes(charsetForName);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        HttpResponse httpResponse = urlConnectionHttpClient.post(requestUrl, headers, bytes);
        NativeAuthResponseHandler nativeAuthResponseHandler = this.nativeAuthResponseHandler;
        Intrinsics.checkNotNullExpressionValue(httpResponse, "httpResponse");
        ResetPasswordPollCompletionApiResponse resetPasswordPollCompletionApiResponseFromHttpResponse = nativeAuthResponseHandler.getResetPasswordPollCompletionApiResponseFromHttpResponse(requestCorrelationId, httpResponse);
        Logger.infoWithObject(this.TAG + ".rawResponseToResetPasswordCompletionApiResult", resetPasswordPollCompletionApiResponseFromHttpResponse.getCorrelationId(), "rawApiResponse = ", resetPasswordPollCompletionApiResponseFromHttpResponse);
        ResetPasswordPollCompletionApiResult result = resetPasswordPollCompletionApiResponseFromHttpResponse.toResult();
        Logger.infoWithObject(this.TAG + ".rawResponseToResetPasswordCompletionApiResult", result.getCorrelationId(), "result = ", result);
        return result;
    }
}
