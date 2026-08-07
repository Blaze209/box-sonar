package com.microsoft.identity.common.java.nativeauth.providers.interactors;

import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.JITChallengeAuthMethodCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.JITContinueCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.JITIntrospectCommandParameters;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthRequestProvider;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthResponseHandler;
import com.microsoft.identity.common.java.nativeauth.providers.requests.jit.JITChallengeRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.jit.JITContinueRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.jit.JITIntrospectRequest;
import com.microsoft.identity.common.java.nativeauth.providers.responses.jit.JITChallengeApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.jit.JITChallengeApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.jit.JITContinueApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.jit.JITContinueApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.jit.JITIntrospectApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.jit.JITIntrospectApiResult;
import com.microsoft.identity.common.java.net.HttpResponse;
import com.microsoft.identity.common.java.net.UrlConnectionHttpClient;
import com.microsoft.identity.common.java.util.ObjectMapper;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JITInteractor.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0014J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0015H\u0002J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u0018J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0019H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/interactors/JITInteractor;", "", "httpClient", "Lcom/microsoft/identity/common/java/net/UrlConnectionHttpClient;", "nativeAuthRequestProvider", "Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthRequestProvider;", "nativeAuthResponseHandler", "Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthResponseHandler;", "(Lcom/microsoft/identity/common/java/net/UrlConnectionHttpClient;Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthRequestProvider;Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthResponseHandler;)V", "TAG", "", "performChallenge", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/jit/JITChallengeApiResult;", "parameters", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/JITChallengeAuthMethodCommandParameters;", "requestCorrelationId", "request", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/jit/JITChallengeRequest;", "performContinue", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/jit/JITContinueApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/JITContinueCommandParameters;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/jit/JITContinueRequest;", "performIntrospect", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/jit/JITIntrospectApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/JITIntrospectCommandParameters;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/jit/JITIntrospectRequest;", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class JITInteractor {
    private final String TAG;
    private final UrlConnectionHttpClient httpClient;
    private final NativeAuthRequestProvider nativeAuthRequestProvider;
    private final NativeAuthResponseHandler nativeAuthResponseHandler;

    public JITInteractor(UrlConnectionHttpClient httpClient, NativeAuthRequestProvider nativeAuthRequestProvider, NativeAuthResponseHandler nativeAuthResponseHandler) {
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(nativeAuthRequestProvider, "nativeAuthRequestProvider");
        Intrinsics.checkNotNullParameter(nativeAuthResponseHandler, "nativeAuthResponseHandler");
        this.httpClient = httpClient;
        this.nativeAuthRequestProvider = nativeAuthRequestProvider;
        this.nativeAuthResponseHandler = nativeAuthResponseHandler;
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "this::class.java.simpleName");
        this.TAG = simpleName;
    }

    public final JITIntrospectApiResult performIntrospect(JITIntrospectCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.INSTANCE.logMethodCall(this.TAG, parameters.getCorrelationId(), this.TAG + ".performIntrospect(parameters: JITIntrospectCommandParameters)");
        NativeAuthRequestProvider nativeAuthRequestProvider = this.nativeAuthRequestProvider;
        String str = parameters.continuationToken;
        Intrinsics.checkNotNullExpressionValue(str, "parameters.continuationToken");
        String correlationId = parameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "parameters.correlationId");
        JITIntrospectRequest jITIntrospectRequestCreateJITIntrospectRequest$common4j = nativeAuthRequestProvider.createJITIntrospectRequest$common4j(str, correlationId);
        Logger.infoWithObject(this.TAG + ".performIntrospect", parameters.getCorrelationId(), "request = ", jITIntrospectRequestCreateJITIntrospectRequest$common4j);
        String correlationId2 = parameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId2, "parameters.correlationId");
        return performIntrospect(correlationId2, jITIntrospectRequestCreateJITIntrospectRequest$common4j);
    }

    private final JITIntrospectApiResult performIntrospect(String requestCorrelationId, JITIntrospectRequest request) throws UnsupportedEncodingException, ClientException {
        LogSession.INSTANCE.logMethodCall(this.TAG, null, this.TAG + ".performJITIntrospect");
        String strSerializeObjectToFormUrlEncoded = ObjectMapper.serializeObjectToFormUrlEncoded(request.getParameters());
        Intrinsics.checkNotNullExpressionValue(strSerializeObjectToFormUrlEncoded, "serializeObjectToFormUrl…coded(request.parameters)");
        Map<String, String> headers = request.getHeaders();
        URL requestUrl = request.getRequestUrl();
        UrlConnectionHttpClient urlConnectionHttpClient = this.httpClient;
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(charsetName)");
        byte[] bytes = strSerializeObjectToFormUrlEncoded.getBytes(charsetForName);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        HttpResponse response = urlConnectionHttpClient.post(requestUrl, headers, bytes);
        NativeAuthResponseHandler nativeAuthResponseHandler = this.nativeAuthResponseHandler;
        Intrinsics.checkNotNullExpressionValue(response, "response");
        JITIntrospectApiResponse jITIntrospectApiResponseFromHttpResponse = nativeAuthResponseHandler.getJITIntrospectApiResponseFromHttpResponse(requestCorrelationId, response);
        Logger.infoWithObject(this.TAG + ".rawResponseToJITIntrospectApiResponse", jITIntrospectApiResponseFromHttpResponse.getCorrelationId(), "rawApiResponse = ", jITIntrospectApiResponseFromHttpResponse);
        JITIntrospectApiResult result = jITIntrospectApiResponseFromHttpResponse.toResult();
        Logger.infoWithObject(this.TAG + ".rawResponseToJITIntrospectApiResult", result.getCorrelationId(), "result = ", result);
        return result;
    }

    public final JITChallengeApiResult performChallenge(JITChallengeAuthMethodCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.INSTANCE.logMethodCall(this.TAG, parameters.getCorrelationId(), this.TAG + ".performChallenge(parameters: JITChallengeAuthMethodCommandParameters)");
        NativeAuthRequestProvider nativeAuthRequestProvider = this.nativeAuthRequestProvider;
        String continuationToken = parameters.continuationToken;
        String correlationId = parameters.getCorrelationId();
        String authMethodChallengeType = parameters.authMethodChallengeType;
        String verificationContact = parameters.verificationContact;
        String challengeChannel = parameters.challengeChannel;
        Intrinsics.checkNotNullExpressionValue(continuationToken, "continuationToken");
        Intrinsics.checkNotNullExpressionValue(authMethodChallengeType, "authMethodChallengeType");
        Intrinsics.checkNotNullExpressionValue(verificationContact, "verificationContact");
        Intrinsics.checkNotNullExpressionValue(challengeChannel, "challengeChannel");
        Intrinsics.checkNotNullExpressionValue(correlationId, "correlationId");
        JITChallengeRequest jITChallengeRequestCreateJITChallengeRequest$common4j = nativeAuthRequestProvider.createJITChallengeRequest$common4j(continuationToken, authMethodChallengeType, verificationContact, challengeChannel, correlationId);
        Logger.infoWithObject(this.TAG + ".performChallenge", parameters.getCorrelationId(), "request = ", jITChallengeRequestCreateJITChallengeRequest$common4j);
        String correlationId2 = parameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId2, "parameters.correlationId");
        return performChallenge(correlationId2, jITChallengeRequestCreateJITChallengeRequest$common4j);
    }

    private final JITChallengeApiResult performChallenge(String requestCorrelationId, JITChallengeRequest request) throws UnsupportedEncodingException, ClientException {
        LogSession.INSTANCE.logMethodCall(this.TAG, null, this.TAG + ".performJITChallenge");
        String strSerializeObjectToFormUrlEncoded = ObjectMapper.serializeObjectToFormUrlEncoded(request.getParameters());
        Intrinsics.checkNotNullExpressionValue(strSerializeObjectToFormUrlEncoded, "serializeObjectToFormUrl…coded(request.parameters)");
        Map<String, String> headers = request.getHeaders();
        URL requestUrl = request.getRequestUrl();
        UrlConnectionHttpClient urlConnectionHttpClient = this.httpClient;
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(charsetName)");
        byte[] bytes = strSerializeObjectToFormUrlEncoded.getBytes(charsetForName);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        HttpResponse response = urlConnectionHttpClient.post(requestUrl, headers, bytes);
        NativeAuthResponseHandler nativeAuthResponseHandler = this.nativeAuthResponseHandler;
        Intrinsics.checkNotNullExpressionValue(response, "response");
        JITChallengeApiResponse jITChallengeApiResponseFromHttpResponse = nativeAuthResponseHandler.getJITChallengeApiResponseFromHttpResponse(requestCorrelationId, response);
        Logger.infoWithObject(this.TAG + ".rawResponseToJITChallengeApiResponse", jITChallengeApiResponseFromHttpResponse.getCorrelationId(), "rawApiResponse = ", jITChallengeApiResponseFromHttpResponse);
        JITChallengeApiResult result = jITChallengeApiResponseFromHttpResponse.toResult();
        Logger.infoWithObject(this.TAG + ".rawResponseToJITChallengeApiResult", result.getCorrelationId(), "result = ", result);
        return result;
    }

    public final JITContinueApiResult performContinue(JITContinueCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.INSTANCE.logMethodCall(this.TAG, parameters.getCorrelationId(), this.TAG + ".performContinue(parameters: JITSubmitChallengeCommandParameters)");
        NativeAuthRequestProvider nativeAuthRequestProvider = this.nativeAuthRequestProvider;
        String continuationToken = parameters.continuationToken;
        String correlationId = parameters.getCorrelationId();
        String grantType = parameters.grantType;
        String str = parameters.code;
        Intrinsics.checkNotNullExpressionValue(continuationToken, "continuationToken");
        Intrinsics.checkNotNullExpressionValue(grantType, "grantType");
        Intrinsics.checkNotNullExpressionValue(correlationId, "correlationId");
        JITContinueRequest jITContinueRequestCreateJITContinueRequest$common4j = nativeAuthRequestProvider.createJITContinueRequest$common4j(continuationToken, grantType, str, correlationId);
        Logger.infoWithObject(this.TAG + ".performContinue", parameters.getCorrelationId(), "request = ", jITContinueRequestCreateJITContinueRequest$common4j);
        String correlationId2 = parameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId2, "parameters.correlationId");
        return performContinue(correlationId2, jITContinueRequestCreateJITContinueRequest$common4j);
    }

    private final JITContinueApiResult performContinue(String requestCorrelationId, JITContinueRequest request) throws UnsupportedEncodingException, ClientException {
        LogSession.INSTANCE.logMethodCall(this.TAG, null, this.TAG + ".performJITContinue");
        String strSerializeObjectToFormUrlEncoded = ObjectMapper.serializeObjectToFormUrlEncoded(request.getParameters());
        Intrinsics.checkNotNullExpressionValue(strSerializeObjectToFormUrlEncoded, "serializeObjectToFormUrl…coded(request.parameters)");
        Map<String, String> headers = request.getHeaders();
        URL requestUrl = request.getRequestUrl();
        UrlConnectionHttpClient urlConnectionHttpClient = this.httpClient;
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(charsetName)");
        byte[] bytes = strSerializeObjectToFormUrlEncoded.getBytes(charsetForName);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        HttpResponse response = urlConnectionHttpClient.post(requestUrl, headers, bytes);
        NativeAuthResponseHandler nativeAuthResponseHandler = this.nativeAuthResponseHandler;
        Intrinsics.checkNotNullExpressionValue(response, "response");
        JITContinueApiResponse jITContinueApiResponseFromHttpResponse = nativeAuthResponseHandler.getJITContinueApiResponseFromHttpResponse(requestCorrelationId, response);
        Logger.infoWithObject(this.TAG + ".rawResponseToJITContinueApiResponse", jITContinueApiResponseFromHttpResponse.getCorrelationId(), "rawApiResponse = ", jITContinueApiResponseFromHttpResponse);
        JITContinueApiResult result = jITContinueApiResponseFromHttpResponse.toResult();
        Logger.infoWithObject(this.TAG + ".rawResponseToJITContinueApiResult", result.getCorrelationId(), "result = ", result);
        return result;
    }
}
