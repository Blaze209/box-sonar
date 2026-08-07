package com.microsoft.identity.common.java.nativeauth.providers.interactors;

import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInStartCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInSubmitCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInSubmitPasswordCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInWithContinuationTokenCommandParameters;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthRequestProvider;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthResponseHandler;
import com.microsoft.identity.common.java.nativeauth.providers.requests.signin.SignInChallengeRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.signin.SignInInitiateRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.signin.SignInIntrospectRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.signin.SignInTokenRequest;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInChallengeApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInChallengeApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInInitiateApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInInitiateApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInIntrospectApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInIntrospectApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInTokenApiResult;
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

/* JADX INFO: compiled from: SignInInteractor.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0015H\u0002J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nJ\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u001bJ\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u001eH\u0002J\u0016\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\r\u001a\u00020\"J\u0018\u0010 \u001a\u00020!2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020#H\u0002J\u001e\u0010$\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/interactors/SignInInteractor;", "", "httpClient", "Lcom/microsoft/identity/common/java/net/UrlConnectionHttpClient;", "nativeAuthRequestProvider", "Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthRequestProvider;", "nativeAuthResponseHandler", "Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthResponseHandler;", "(Lcom/microsoft/identity/common/java/net/UrlConnectionHttpClient;Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthRequestProvider;Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthResponseHandler;)V", "TAG", "", "performContinuationTokenTokenRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult;", "parameters", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInWithContinuationTokenCommandParameters;", "performGetToken", "requestCorrelationId", "request", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInTokenRequest;", "performIntrospect", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInIntrospectApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInIntrospectRequest;", "continuationToken", "correlationId", "performOOBTokenRequest", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInSubmitCodeCommandParameters;", "performPasswordTokenRequest", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInSubmitPasswordCommandParameters;", "performSignInChallenge", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInChallengeApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInChallengeRequest;", "performSignInDefaultChallenge", "performSignInInitiate", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInInitiateApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInStartCommandParameters;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInInitiateRequest;", "performSignInSelectedChallenge", "challengeId", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SignInInteractor {
    private final String TAG;
    private final UrlConnectionHttpClient httpClient;
    private final NativeAuthRequestProvider nativeAuthRequestProvider;
    private final NativeAuthResponseHandler nativeAuthResponseHandler;

    public SignInInteractor(UrlConnectionHttpClient httpClient, NativeAuthRequestProvider nativeAuthRequestProvider, NativeAuthResponseHandler nativeAuthResponseHandler) {
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(nativeAuthRequestProvider, "nativeAuthRequestProvider");
        Intrinsics.checkNotNullParameter(nativeAuthResponseHandler, "nativeAuthResponseHandler");
        this.httpClient = httpClient;
        this.nativeAuthRequestProvider = nativeAuthRequestProvider;
        this.nativeAuthResponseHandler = nativeAuthResponseHandler;
        Intrinsics.checkNotNullExpressionValue("SignInInteractor", "SignInInteractor::class.java.simpleName");
        this.TAG = "SignInInteractor";
    }

    public final SignInInitiateApiResult performSignInInitiate(SignInStartCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.INSTANCE.logMethodCall(this.TAG, parameters.getCorrelationId(), this.TAG + ".performSignInInitiate(parameters: SignInStartCommandParameters)");
        SignInInitiateRequest signInInitiateRequestCreateSignInInitiateRequest$common4j = this.nativeAuthRequestProvider.createSignInInitiateRequest$common4j(parameters);
        Logger.infoWithObject(this.TAG + ".performSignInInitiate", parameters.getCorrelationId(), "request = ", signInInitiateRequestCreateSignInInitiateRequest$common4j);
        String correlationId = parameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "parameters.getCorrelationId()");
        return performSignInInitiate(correlationId, signInInitiateRequestCreateSignInInitiateRequest$common4j);
    }

    private final SignInInitiateApiResult performSignInInitiate(String requestCorrelationId, SignInInitiateRequest request) throws UnsupportedEncodingException, ClientException {
        LogSession.INSTANCE.logMethodCall(this.TAG, null, this.TAG + ".performSignInInitiate");
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
        SignInInitiateApiResponse signInInitiateResultFromHttpResponse = nativeAuthResponseHandler.getSignInInitiateResultFromHttpResponse(requestCorrelationId, response);
        Logger.infoWithObject(this.TAG + ".rawResponseToSignInInitiateApiResponse", signInInitiateResultFromHttpResponse.getCorrelationId(), "rawApiResponse = ", signInInitiateResultFromHttpResponse);
        SignInInitiateApiResult result = signInInitiateResultFromHttpResponse.toResult();
        Logger.infoWithObject(this.TAG + ".rawResponseToSignInInitiateApiResult", result.getCorrelationId(), "result = ", result);
        return result;
    }

    public final SignInIntrospectApiResult performIntrospect(String continuationToken, String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        LogSession.INSTANCE.logMethodCall(this.TAG, correlationId, this.TAG + ".performIntrospect(continuationToken: String)");
        SignInIntrospectRequest signInIntrospectRequestCreateIntrospectRequest$common4j = this.nativeAuthRequestProvider.createIntrospectRequest$common4j(continuationToken, correlationId);
        Logger.infoWithObject(this.TAG + ".performIntrospect", correlationId, "request = ", signInIntrospectRequestCreateIntrospectRequest$common4j);
        return performIntrospect(correlationId, signInIntrospectRequestCreateIntrospectRequest$common4j);
    }

    private final SignInIntrospectApiResult performIntrospect(String requestCorrelationId, SignInIntrospectRequest request) throws UnsupportedEncodingException, ClientException {
        LogSession.INSTANCE.logMethodCall(this.TAG, null, this.TAG + ".performSignInIntrospect");
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
        SignInIntrospectApiResponse signInIntrospectResultFromHttpResponse = nativeAuthResponseHandler.getSignInIntrospectResultFromHttpResponse(requestCorrelationId, response);
        Logger.infoWithObject(this.TAG + ".rawResponseToSignInIntrospectApiResponse", signInIntrospectResultFromHttpResponse.getCorrelationId(), "rawApiResponse = ", signInIntrospectResultFromHttpResponse);
        SignInIntrospectApiResult result = signInIntrospectResultFromHttpResponse.toResult();
        Logger.infoWithObject(this.TAG + ".rawResponseToSignInIntrospectApiResult", result.getCorrelationId(), "result = ", result);
        return result;
    }

    public final SignInChallengeApiResult performSignInDefaultChallenge(String continuationToken, String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        LogSession.INSTANCE.logMethodCall(this.TAG, correlationId, this.TAG + ".performSignInDefaultChallenge(continuationToken: String)");
        SignInChallengeRequest signInChallengeRequestCreateSignInDefaultChallengeRequest$common4j = this.nativeAuthRequestProvider.createSignInDefaultChallengeRequest$common4j(continuationToken, correlationId);
        Logger.infoWithObject(this.TAG + ".performSignInDefaultChallenge", correlationId, "request = ", signInChallengeRequestCreateSignInDefaultChallengeRequest$common4j);
        return performSignInChallenge(correlationId, signInChallengeRequestCreateSignInDefaultChallengeRequest$common4j);
    }

    public final SignInChallengeApiResult performSignInSelectedChallenge(String continuationToken, String challengeId, String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(challengeId, "challengeId");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        LogSession.INSTANCE.logMethodCall(this.TAG, correlationId, this.TAG + ".performSignInSelectedChallenge(continuationToken: String, challengeId: String)");
        SignInChallengeRequest signInChallengeRequestCreateSignInSelectedChallengeRequest$common4j = this.nativeAuthRequestProvider.createSignInSelectedChallengeRequest$common4j(continuationToken, challengeId, correlationId);
        Logger.infoWithObject(this.TAG + ".performSignInSelectedChallenge", correlationId, "request = ", signInChallengeRequestCreateSignInSelectedChallengeRequest$common4j);
        return performSignInChallenge(correlationId, signInChallengeRequestCreateSignInSelectedChallengeRequest$common4j);
    }

    private final SignInChallengeApiResult performSignInChallenge(String requestCorrelationId, SignInChallengeRequest request) throws UnsupportedEncodingException, ClientException {
        LogSession.INSTANCE.logMethodCall(this.TAG, null, this.TAG + ".performSignInChallenge");
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
        SignInChallengeApiResponse signInChallengeResultFromHttpResponse = nativeAuthResponseHandler.getSignInChallengeResultFromHttpResponse(requestCorrelationId, response);
        Logger.infoWithObject(this.TAG + ".rawResponseToSignInChallengeApiResponse", signInChallengeResultFromHttpResponse.getCorrelationId(), "rawApiResponse = ", signInChallengeResultFromHttpResponse);
        SignInChallengeApiResult result = signInChallengeResultFromHttpResponse.toResult();
        Logger.infoWithObject(this.TAG + ".rawResponseToSignInChallengeApiResult", result.getCorrelationId(), "result = ", result);
        return result;
    }

    public final SignInTokenApiResult performOOBTokenRequest(SignInSubmitCodeCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.INSTANCE.logMethodCall(this.TAG, parameters.getCorrelationId(), this.TAG + ".performOOBTokenRequest(parameters: SignInSubmitCodeCommandParameters)");
        SignInTokenRequest signInTokenRequestCreateOOBTokenRequest$common4j = this.nativeAuthRequestProvider.createOOBTokenRequest$common4j(parameters);
        Logger.infoWithObject(this.TAG + ".performOOBTokenRequest", parameters.getCorrelationId(), "request = ", signInTokenRequestCreateOOBTokenRequest$common4j);
        String correlationId = parameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "parameters.getCorrelationId()");
        return performGetToken(correlationId, signInTokenRequestCreateOOBTokenRequest$common4j);
    }

    public final SignInTokenApiResult performContinuationTokenTokenRequest(SignInWithContinuationTokenCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.INSTANCE.logMethodCall(this.TAG, parameters.getCorrelationId(), this.TAG + ".performContinuationTokenTokenRequest(parameters: SignInWithContinuationTokenCommandParameters)");
        SignInTokenRequest signInTokenRequestCreateContinuationTokenTokenRequest$common4j = this.nativeAuthRequestProvider.createContinuationTokenTokenRequest$common4j(parameters);
        Logger.infoWithObject(this.TAG + ".performContinuationTokenTokenRequest", parameters.getCorrelationId(), "request = ", signInTokenRequestCreateContinuationTokenTokenRequest$common4j);
        String correlationId = parameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "parameters.getCorrelationId()");
        return performGetToken(correlationId, signInTokenRequestCreateContinuationTokenTokenRequest$common4j);
    }

    public final SignInTokenApiResult performPasswordTokenRequest(SignInSubmitPasswordCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.INSTANCE.logMethodCall(this.TAG, parameters.getCorrelationId(), this.TAG + ".performPasswordTokenRequest");
        SignInTokenRequest signInTokenRequestCreatePasswordTokenRequest$common4j = this.nativeAuthRequestProvider.createPasswordTokenRequest$common4j(parameters);
        Logger.infoWithObject(this.TAG + ".performPasswordTokenRequest", parameters.getCorrelationId(), "request = ", signInTokenRequestCreatePasswordTokenRequest$common4j);
        try {
            String correlationId = parameters.getCorrelationId();
            Intrinsics.checkNotNullExpressionValue(correlationId, "parameters.getCorrelationId()");
            return performGetToken(correlationId, signInTokenRequestCreatePasswordTokenRequest$common4j);
        } finally {
            StringUtil.overwriteWithNull(signInTokenRequestCreatePasswordTokenRequest$common4j.getParameters().getPassword());
        }
    }

    private final SignInTokenApiResult performGetToken(String requestCorrelationId, SignInTokenRequest request) throws UnsupportedEncodingException, ClientException {
        LogSession.INSTANCE.logMethodCall(this.TAG, requestCorrelationId, this.TAG + ".performGetToken");
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
        SignInTokenApiResult signInTokenApiResultFromHttpResponse = nativeAuthResponseHandler.getSignInTokenApiResultFromHttpResponse(requestCorrelationId, response);
        Logger.infoWithObject(this.TAG + ".rawResponseToSignInTokenApiResult", signInTokenApiResultFromHttpResponse.getCorrelationId(), "result = ", signInTokenApiResultFromHttpResponse);
        return signInTokenApiResultFromHttpResponse;
    }
}
