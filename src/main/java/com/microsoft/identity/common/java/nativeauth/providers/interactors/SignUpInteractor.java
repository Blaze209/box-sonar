package com.microsoft.identity.common.java.nativeauth.providers.interactors;

import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpStartCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitPasswordCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitUserAttributesCommandParameters;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthRequestProvider;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthResponseHandler;
import com.microsoft.identity.common.java.nativeauth.providers.requests.signup.SignUpChallengeRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.signup.SignUpContinueRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.signup.SignUpStartRequest;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signup.SignUpChallengeApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signup.SignUpChallengeApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signup.SignUpContinueApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signup.SignUpContinueApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signup.SignUpStartApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signup.SignUpStartApiResult;
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

/* JADX INFO: compiled from: SignUpInteractor.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0019H\u0002J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u001fR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/interactors/SignUpInteractor;", "", "httpClient", "Lcom/microsoft/identity/common/java/net/UrlConnectionHttpClient;", "nativeAuthRequestProvider", "Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthRequestProvider;", "nativeAuthResponseHandler", "Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthResponseHandler;", "(Lcom/microsoft/identity/common/java/net/UrlConnectionHttpClient;Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthRequestProvider;Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthResponseHandler;)V", "TAG", "", "performSignUpChallenge", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpChallengeApiResult;", "requestCorrelationId", "request", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpChallengeRequest;", "continuationToken", "correlationId", "performSignUpContinue", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpContinueRequest;", "performSignUpStart", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult;", "commandParameters", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpStartCommandParameters;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpStartRequest;", "performSignUpSubmitCode", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpSubmitCodeCommandParameters;", "performSignUpSubmitPassword", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpSubmitPasswordCommandParameters;", "performSignUpSubmitUserAttributes", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpSubmitUserAttributesCommandParameters;", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SignUpInteractor {
    private final String TAG;
    private final UrlConnectionHttpClient httpClient;
    private final NativeAuthRequestProvider nativeAuthRequestProvider;
    private final NativeAuthResponseHandler nativeAuthResponseHandler;

    public SignUpInteractor(UrlConnectionHttpClient httpClient, NativeAuthRequestProvider nativeAuthRequestProvider, NativeAuthResponseHandler nativeAuthResponseHandler) {
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(nativeAuthRequestProvider, "nativeAuthRequestProvider");
        Intrinsics.checkNotNullParameter(nativeAuthResponseHandler, "nativeAuthResponseHandler");
        this.httpClient = httpClient;
        this.nativeAuthRequestProvider = nativeAuthRequestProvider;
        this.nativeAuthResponseHandler = nativeAuthResponseHandler;
        Intrinsics.checkNotNullExpressionValue("SignUpInteractor", "SignUpInteractor::class.java.simpleName");
        this.TAG = "SignUpInteractor";
    }

    public final SignUpStartApiResult performSignUpStart(SignUpStartCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        LogSession.INSTANCE.logMethodCall(this.TAG, commandParameters.getCorrelationId(), this.TAG + ".performSignUpStart(commandParameters: SignUpStartCommandParameters)");
        SignUpStartRequest signUpStartRequestCreateSignUpStartRequest$common4j = this.nativeAuthRequestProvider.createSignUpStartRequest$common4j(commandParameters);
        Logger.infoWithObject(this.TAG + ".performSignInInitiate", commandParameters.getCorrelationId(), "request = ", signUpStartRequestCreateSignUpStartRequest$common4j);
        try {
            String correlationId = commandParameters.getCorrelationId();
            Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
            return performSignUpStart(correlationId, signUpStartRequestCreateSignUpStartRequest$common4j);
        } finally {
            StringUtil.overwriteWithNull(signUpStartRequestCreateSignUpStartRequest$common4j.getParameters().getPassword());
        }
    }

    private final SignUpStartApiResult performSignUpStart(String requestCorrelationId, SignUpStartRequest request) throws UnsupportedEncodingException, ClientException {
        LogSession.INSTANCE.logMethodCall(this.TAG, requestCorrelationId, this.TAG + ".performSignUpStart");
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
        SignUpStartApiResponse signUpStartResultFromHttpResponse = nativeAuthResponseHandler.getSignUpStartResultFromHttpResponse(requestCorrelationId, response);
        Logger.infoWithObject(this.TAG + ".rawResponseToSignUpStartApiResult", signUpStartResultFromHttpResponse.getCorrelationId(), "rawApiResponse = ", signUpStartResultFromHttpResponse);
        SignUpStartApiResult result = signUpStartResultFromHttpResponse.toResult();
        Logger.infoWithObject(this.TAG + ".rawResponseToSignUpStartApiResult", result.getCorrelationId(), "result = ", result);
        return result;
    }

    public final SignUpChallengeApiResult performSignUpChallenge(String continuationToken, String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        LogSession.INSTANCE.logMethodCall(this.TAG, correlationId, this.TAG + ".performSignUpChallenge");
        SignUpChallengeRequest signUpChallengeRequestCreateSignUpChallengeRequest$common4j = this.nativeAuthRequestProvider.createSignUpChallengeRequest$common4j(continuationToken, correlationId);
        Logger.infoWithObject(this.TAG + ".performSignUpChallenge", correlationId, "request = ", signUpChallengeRequestCreateSignUpChallengeRequest$common4j);
        return performSignUpChallenge(correlationId, signUpChallengeRequestCreateSignUpChallengeRequest$common4j);
    }

    private final SignUpChallengeApiResult performSignUpChallenge(String requestCorrelationId, SignUpChallengeRequest request) throws UnsupportedEncodingException, ClientException {
        LogSession.INSTANCE.logMethodCall(this.TAG, null, this.TAG + ".performSignUpChallenge");
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
        SignUpChallengeApiResponse signUpChallengeResultFromHttpResponse = nativeAuthResponseHandler.getSignUpChallengeResultFromHttpResponse(requestCorrelationId, response);
        Logger.infoWithObject(this.TAG + ".rawResponseToSignUpChallengeApiResult", signUpChallengeResultFromHttpResponse.getCorrelationId(), "rawApiResponse = ", signUpChallengeResultFromHttpResponse);
        SignUpChallengeApiResult result = signUpChallengeResultFromHttpResponse.toResult();
        Logger.infoWithObject(this.TAG + ".rawResponseToSignUpChallengeApiResult", result.getCorrelationId(), "result = ", result);
        return result;
    }

    public final SignUpContinueApiResult performSignUpSubmitCode(SignUpSubmitCodeCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        LogSession.INSTANCE.logMethodCall(this.TAG, commandParameters.getCorrelationId(), this.TAG + ".performSignUpSubmitCode(commandParameters: SignUpSubmitCodeCommandParameters)");
        SignUpContinueRequest signUpContinueRequestCreateSignUpSubmitCodeRequest$common4j = this.nativeAuthRequestProvider.createSignUpSubmitCodeRequest$common4j(commandParameters);
        Logger.infoWithObject(this.TAG + ".performSignUpSubmitCode", commandParameters.getCorrelationId(), "request = ", signUpContinueRequestCreateSignUpSubmitCodeRequest$common4j);
        String correlationId = commandParameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
        return performSignUpContinue(correlationId, signUpContinueRequestCreateSignUpSubmitCodeRequest$common4j);
    }

    public final SignUpContinueApiResult performSignUpSubmitPassword(SignUpSubmitPasswordCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        LogSession.INSTANCE.logMethodCall(this.TAG, commandParameters.getCorrelationId(), this.TAG + ".performSignUpSubmitPassword(commandParameters: SignUpSubmitPasswordCommandParameters1)");
        SignUpContinueRequest signUpContinueRequestCreateSignUpSubmitPasswordRequest$common4j = this.nativeAuthRequestProvider.createSignUpSubmitPasswordRequest$common4j(commandParameters);
        Logger.infoWithObject(this.TAG + ".performSignUpSubmitPassword", commandParameters.getCorrelationId(), "request = ", signUpContinueRequestCreateSignUpSubmitPasswordRequest$common4j);
        try {
            String correlationId = commandParameters.getCorrelationId();
            Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
            return performSignUpContinue(correlationId, signUpContinueRequestCreateSignUpSubmitPasswordRequest$common4j);
        } finally {
            StringUtil.overwriteWithNull(signUpContinueRequestCreateSignUpSubmitPasswordRequest$common4j.getParameters().getPassword());
        }
    }

    public final SignUpContinueApiResult performSignUpSubmitUserAttributes(SignUpSubmitUserAttributesCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        LogSession.INSTANCE.logMethodCall(this.TAG, commandParameters.getCorrelationId(), this.TAG + ".performSignUpSubmitUserAttributes(commandParameters: SignUpSubmitUserAttributesCommandParameters)");
        SignUpContinueRequest signUpContinueRequestCreateSignUpSubmitUserAttributesRequest$common4j = this.nativeAuthRequestProvider.createSignUpSubmitUserAttributesRequest$common4j(commandParameters);
        Logger.infoWithObject(this.TAG + ".performSignUpSubmitUserAttributes", commandParameters.getCorrelationId(), "request = ", signUpContinueRequestCreateSignUpSubmitUserAttributesRequest$common4j);
        String correlationId = commandParameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
        return performSignUpContinue(correlationId, signUpContinueRequestCreateSignUpSubmitUserAttributesRequest$common4j);
    }

    private final SignUpContinueApiResult performSignUpContinue(String requestCorrelationId, SignUpContinueRequest request) throws UnsupportedEncodingException, ClientException {
        LogSession.INSTANCE.logMethodCall(this.TAG, requestCorrelationId, this.TAG + ".performSignUpContinue");
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
        SignUpContinueApiResponse signUpContinueResultFromHttpResponse = nativeAuthResponseHandler.getSignUpContinueResultFromHttpResponse(requestCorrelationId, response);
        Logger.infoWithObject(this.TAG + ".rawResponseToSignUpStartApiResult", signUpContinueResultFromHttpResponse.getCorrelationId(), "rawApiResponse = ", signUpContinueResultFromHttpResponse);
        SignUpContinueApiResult result = signUpContinueResultFromHttpResponse.toResult();
        Logger.infoWithObject(this.TAG + ".rawResponseToSignUpStartApiResult", result.getCorrelationId(), "result = ", result);
        return result;
    }
}
