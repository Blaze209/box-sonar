package com.microsoft.identity.common.java.nativeauth.providers;

import com.microsoft.identity.common.java.eststelemetry.EstsTelemetry;
import com.microsoft.identity.common.java.logging.LibraryInfoHelper;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordStartCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordSubmitCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordSubmitNewPasswordCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInStartCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInSubmitCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInSubmitPasswordCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInWithContinuationTokenCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpStartCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitPasswordCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitUserAttributesCommandParameters;
import com.microsoft.identity.common.java.nativeauth.providers.requests.jit.JITChallengeRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.jit.JITContinueRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.jit.JITIntrospectRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.resetpassword.ResetPasswordChallengeRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.resetpassword.ResetPasswordContinueRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.resetpassword.ResetPasswordPollCompletionRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.resetpassword.ResetPasswordStartRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.resetpassword.ResetPasswordSubmitRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.signin.SignInChallengeRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.signin.SignInInitiateRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.signin.SignInIntrospectRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.signin.SignInTokenRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.signup.SignUpChallengeRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.signup.SignUpContinueRequest;
import com.microsoft.identity.common.java.nativeauth.providers.requests.signup.SignUpStartRequest;
import com.microsoft.identity.common.java.platform.Device;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NativeAuthRequestProvider.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001bJ\u001d\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0000¢\u0006\u0002\b J5\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0000¢\u0006\u0002\b&J/\u0010'\u001a\u00020(2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0000¢\u0006\u0002\b+J\u001d\u0010,\u001a\u00020-2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0000¢\u0006\u0002\b.J\u0015\u0010/\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u000200H\u0000¢\u0006\u0002\b1J\u0015\u00102\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u000203H\u0000¢\u0006\u0002\b4J\u001d\u00105\u001a\u0002062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0000¢\u0006\u0002\b7J\u0015\u00108\u001a\u0002092\u0006\u0010\u0019\u001a\u00020:H\u0000¢\u0006\u0002\b;J\u001d\u0010<\u001a\u00020=2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0000¢\u0006\u0002\b>J\u0015\u0010?\u001a\u00020@2\u0006\u0010\u0019\u001a\u00020AH\u0000¢\u0006\u0002\bBJ\u0015\u0010C\u001a\u00020D2\u0006\u0010\u0019\u001a\u00020EH\u0000¢\u0006\u0002\bFJ\u001d\u0010G\u001a\u00020H2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0000¢\u0006\u0002\bIJ\u0015\u0010J\u001a\u00020K2\u0006\u0010\u0019\u001a\u00020LH\u0000¢\u0006\u0002\bMJ%\u0010N\u001a\u00020H2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0000¢\u0006\u0002\bPJ\u001d\u0010Q\u001a\u00020R2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0000¢\u0006\u0002\bSJ\u0015\u0010T\u001a\u00020U2\u0006\u0010\u0019\u001a\u00020VH\u0000¢\u0006\u0002\bWJ\u0015\u0010X\u001a\u00020Y2\u0006\u0010\u0019\u001a\u00020ZH\u0000¢\u0006\u0002\b[J\u0015\u0010\\\u001a\u00020Y2\u0006\u0010\u0019\u001a\u00020]H\u0000¢\u0006\u0002\b^J\u0015\u0010_\u001a\u00020Y2\u0006\u0010\u0019\u001a\u00020`H\u0000¢\u0006\u0002\baJ\u001e\u0010b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060c2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthRequestProvider;", "", "config", "Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthOAuth2Configuration;", "(Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthOAuth2Configuration;)V", "TAG", "", "kotlin.jvm.PlatformType", "jitChallengeEndpoint", "jitContinueEndpoint", "jitIntrospectEndpoint", "resetPasswordChallengeEndpoint", "resetPasswordContinueEndpoint", "resetPasswordPollCompletionEndpoint", "resetPasswordStartEndpoint", "resetPasswordSubmitEndpoint", "signInChallengeEndpoint", "signInInitiateEndpoint", "signInIntrospectEndpoint", "signInTokenEndpoint", "signUpChallengeEndpoint", "signUpContinueEndpoint", "signUpStartEndpoint", "createContinuationTokenTokenRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInTokenRequest;", "commandParameters", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInWithContinuationTokenCommandParameters;", "createContinuationTokenTokenRequest$common4j", "createIntrospectRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInIntrospectRequest;", "continuationToken", "correlationId", "createIntrospectRequest$common4j", "createJITChallengeRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/jit/JITChallengeRequest;", "challengeType", "challengeTarget", "challengeChannel", "createJITChallengeRequest$common4j", "createJITContinueRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/jit/JITContinueRequest;", "grantType", "code", "createJITContinueRequest$common4j", "createJITIntrospectRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/jit/JITIntrospectRequest;", "createJITIntrospectRequest$common4j", "createOOBTokenRequest", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInSubmitCodeCommandParameters;", "createOOBTokenRequest$common4j", "createPasswordTokenRequest", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInSubmitPasswordCommandParameters;", "createPasswordTokenRequest$common4j", "createResetPasswordChallengeRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordChallengeRequest;", "createResetPasswordChallengeRequest$common4j", "createResetPasswordContinueRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordContinueRequest;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/ResetPasswordSubmitCodeCommandParameters;", "createResetPasswordContinueRequest$common4j", "createResetPasswordPollCompletionRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordPollCompletionRequest;", "createResetPasswordPollCompletionRequest$common4j", "createResetPasswordStartRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordStartRequest;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/ResetPasswordStartCommandParameters;", "createResetPasswordStartRequest$common4j", "createResetPasswordSubmitRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordSubmitRequest;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/ResetPasswordSubmitNewPasswordCommandParameters;", "createResetPasswordSubmitRequest$common4j", "createSignInDefaultChallengeRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInChallengeRequest;", "createSignInDefaultChallengeRequest$common4j", "createSignInInitiateRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInInitiateRequest;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInStartCommandParameters;", "createSignInInitiateRequest$common4j", "createSignInSelectedChallengeRequest", "challengeId", "createSignInSelectedChallengeRequest$common4j", "createSignUpChallengeRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpChallengeRequest;", "createSignUpChallengeRequest$common4j", "createSignUpStartRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpStartRequest;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpStartCommandParameters;", "createSignUpStartRequest$common4j", "createSignUpSubmitCodeRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpContinueRequest;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpSubmitCodeCommandParameters;", "createSignUpSubmitCodeRequest$common4j", "createSignUpSubmitPasswordRequest", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpSubmitPasswordCommandParameters;", "createSignUpSubmitPasswordRequest$common4j", "createSignUpSubmitUserAttributesRequest", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpSubmitUserAttributesCommandParameters;", "createSignUpSubmitUserAttributesRequest$common4j", "getRequestHeaders", "", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NativeAuthRequestProvider {
    private final String TAG;
    private final NativeAuthOAuth2Configuration config;
    private final String jitChallengeEndpoint;
    private final String jitContinueEndpoint;
    private final String jitIntrospectEndpoint;
    private final String resetPasswordChallengeEndpoint;
    private final String resetPasswordContinueEndpoint;
    private final String resetPasswordPollCompletionEndpoint;
    private final String resetPasswordStartEndpoint;
    private final String resetPasswordSubmitEndpoint;
    private final String signInChallengeEndpoint;
    private final String signInInitiateEndpoint;
    private final String signInIntrospectEndpoint;
    private final String signInTokenEndpoint;
    private final String signUpChallengeEndpoint;
    private final String signUpContinueEndpoint;
    private final String signUpStartEndpoint;

    public NativeAuthRequestProvider(NativeAuthOAuth2Configuration config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        this.TAG = "NativeAuthRequestProvider";
        String string = config.getSignUpStartEndpoint().toString();
        Intrinsics.checkNotNullExpressionValue(string, "config.getSignUpStartEndpoint().toString()");
        this.signUpStartEndpoint = string;
        String string2 = config.getSignUpChallengeEndpoint().toString();
        Intrinsics.checkNotNullExpressionValue(string2, "config.getSignUpChallengeEndpoint().toString()");
        this.signUpChallengeEndpoint = string2;
        String string3 = config.getSignUpContinueEndpoint().toString();
        Intrinsics.checkNotNullExpressionValue(string3, "config.getSignUpContinueEndpoint().toString()");
        this.signUpContinueEndpoint = string3;
        String string4 = config.getSignInInitiateEndpoint().toString();
        Intrinsics.checkNotNullExpressionValue(string4, "config.getSignInInitiateEndpoint().toString()");
        this.signInInitiateEndpoint = string4;
        String string5 = config.getSignInIntrospectEndpoint().toString();
        Intrinsics.checkNotNullExpressionValue(string5, "config.getSignInIntrospectEndpoint().toString()");
        this.signInIntrospectEndpoint = string5;
        String string6 = config.getSignInChallengeEndpoint().toString();
        Intrinsics.checkNotNullExpressionValue(string6, "config.getSignInChallengeEndpoint().toString()");
        this.signInChallengeEndpoint = string6;
        String string7 = config.getSignInTokenEndpoint().toString();
        Intrinsics.checkNotNullExpressionValue(string7, "config.getSignInTokenEndpoint().toString()");
        this.signInTokenEndpoint = string7;
        String string8 = config.getResetPasswordStartEndpoint().toString();
        Intrinsics.checkNotNullExpressionValue(string8, "config.getResetPasswordStartEndpoint().toString()");
        this.resetPasswordStartEndpoint = string8;
        String string9 = config.getResetPasswordChallengeEndpoint().toString();
        Intrinsics.checkNotNullExpressionValue(string9, "config.getResetPasswordC…engeEndpoint().toString()");
        this.resetPasswordChallengeEndpoint = string9;
        String string10 = config.getResetPasswordContinueEndpoint().toString();
        Intrinsics.checkNotNullExpressionValue(string10, "config.getResetPasswordC…inueEndpoint().toString()");
        this.resetPasswordContinueEndpoint = string10;
        String string11 = config.getResetPasswordSubmitEndpoint().toString();
        Intrinsics.checkNotNullExpressionValue(string11, "config.getResetPasswordSubmitEndpoint().toString()");
        this.resetPasswordSubmitEndpoint = string11;
        String string12 = config.getResetPasswordPollCompletionEndpoint().toString();
        Intrinsics.checkNotNullExpressionValue(string12, "config.getResetPasswordP…tionEndpoint().toString()");
        this.resetPasswordPollCompletionEndpoint = string12;
        String string13 = config.getJITIntrospectEndpoint().toString();
        Intrinsics.checkNotNullExpressionValue(string13, "config.getJITIntrospectEndpoint().toString()");
        this.jitIntrospectEndpoint = string13;
        String string14 = config.getJITChallengeEndpoint().toString();
        Intrinsics.checkNotNullExpressionValue(string14, "config.getJITChallengeEndpoint().toString()");
        this.jitChallengeEndpoint = string14;
        String string15 = config.getJITContinueEndpoint().toString();
        Intrinsics.checkNotNullExpressionValue(string15, "config.getJITContinueEndpoint().toString()");
        this.jitContinueEndpoint = string15;
    }

    public final SignInInitiateRequest createSignInInitiateRequest$common4j(SignInStartCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        SignInInitiateRequest.Companion companion = SignInInitiateRequest.INSTANCE;
        String str = commandParameters.username;
        Intrinsics.checkNotNullExpressionValue(str, "commandParameters.username");
        String clientId = this.config.getClientId();
        String challengeType = this.config.getChallengeType();
        String str2 = this.signInInitiateEndpoint;
        String correlationId = commandParameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
        return companion.create(str, clientId, challengeType, str2, getRequestHeaders(correlationId), this.config.getCapabilities());
    }

    public final SignInChallengeRequest createSignInDefaultChallengeRequest$common4j(String continuationToken, String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        return SignInChallengeRequest.INSTANCE.createDefaultChallengeRequest(this.config.getClientId(), continuationToken, this.config.getChallengeType(), this.signInChallengeEndpoint, getRequestHeaders(correlationId));
    }

    public final SignInChallengeRequest createSignInSelectedChallengeRequest$common4j(String continuationToken, String challengeId, String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(challengeId, "challengeId");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        return SignInChallengeRequest.INSTANCE.createSelectedChallengeRequest(this.config.getClientId(), continuationToken, challengeId, this.signInChallengeEndpoint, getRequestHeaders(correlationId));
    }

    public final SignInIntrospectRequest createIntrospectRequest$common4j(String continuationToken, String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        return SignInIntrospectRequest.INSTANCE.create(continuationToken, this.config.getClientId(), this.signInIntrospectEndpoint, getRequestHeaders(correlationId));
    }

    public final SignInTokenRequest createOOBTokenRequest$common4j(SignInSubmitCodeCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        SignInTokenRequest.Companion companion = SignInTokenRequest.INSTANCE;
        String code = commandParameters.code;
        List<String> list = commandParameters.scopes;
        String continuationToken = commandParameters.continuationToken;
        String clientId = this.config.getClientId();
        String challengeType = this.config.getChallengeType();
        String str = this.signInTokenEndpoint;
        String correlationId = commandParameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
        Map<String, String> requestHeaders = getRequestHeaders(correlationId);
        String str2 = commandParameters.claimsRequestJson;
        Boolean isMFAGrantType = commandParameters.isMFAGrantType;
        Intrinsics.checkNotNullExpressionValue(code, "code");
        Intrinsics.checkNotNullExpressionValue(continuationToken, "continuationToken");
        Intrinsics.checkNotNullExpressionValue(isMFAGrantType, "isMFAGrantType");
        return companion.createOOBTokenRequest(code, continuationToken, clientId, list, challengeType, str, requestHeaders, str2, isMFAGrantType.booleanValue());
    }

    public final SignInTokenRequest createContinuationTokenTokenRequest$common4j(SignInWithContinuationTokenCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        SignInTokenRequest.Companion companion = SignInTokenRequest.INSTANCE;
        String continuationToken = commandParameters.continuationToken;
        List<String> list = commandParameters.scopes;
        String clientId = this.config.getClientId();
        String str = commandParameters.username;
        String challengeType = this.config.getChallengeType();
        String str2 = this.signInTokenEndpoint;
        String correlationId = commandParameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
        Map<String, String> requestHeaders = getRequestHeaders(correlationId);
        String str3 = commandParameters.claimsRequestJson;
        Intrinsics.checkNotNullExpressionValue(continuationToken, "continuationToken");
        return companion.createContinuationTokenRequest(continuationToken, clientId, str, list, challengeType, str2, requestHeaders, str3);
    }

    public final SignInTokenRequest createPasswordTokenRequest$common4j(SignInSubmitPasswordCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        SignInTokenRequest.Companion companion = SignInTokenRequest.INSTANCE;
        char[] password = commandParameters.password;
        List<String> list = commandParameters.scopes;
        String continuationToken = commandParameters.continuationToken;
        String clientId = this.config.getClientId();
        String challengeType = this.config.getChallengeType();
        String str = this.signInTokenEndpoint;
        String correlationId = commandParameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
        Map<String, String> requestHeaders = getRequestHeaders(correlationId);
        String str2 = commandParameters.claimsRequestJson;
        Intrinsics.checkNotNullExpressionValue(password, "password");
        Intrinsics.checkNotNullExpressionValue(continuationToken, "continuationToken");
        return companion.createPasswordTokenRequest(password, continuationToken, clientId, list, challengeType, str, requestHeaders, str2);
    }

    public final ResetPasswordStartRequest createResetPasswordStartRequest$common4j(ResetPasswordStartCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        ResetPasswordStartRequest.Companion companion = ResetPasswordStartRequest.INSTANCE;
        String clientId = this.config.getClientId();
        String str = commandParameters.username;
        Intrinsics.checkNotNullExpressionValue(str, "commandParameters.username");
        String challengeType = this.config.getChallengeType();
        String str2 = this.resetPasswordStartEndpoint;
        String correlationId = commandParameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
        return companion.create(clientId, str, challengeType, str2, getRequestHeaders(correlationId), this.config.getCapabilities());
    }

    public final ResetPasswordChallengeRequest createResetPasswordChallengeRequest$common4j(String continuationToken, String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        return ResetPasswordChallengeRequest.INSTANCE.create(this.config.getClientId(), continuationToken, this.config.getChallengeType(), this.resetPasswordChallengeEndpoint, getRequestHeaders(correlationId));
    }

    public final ResetPasswordContinueRequest createResetPasswordContinueRequest$common4j(ResetPasswordSubmitCodeCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        ResetPasswordContinueRequest.Companion companion = ResetPasswordContinueRequest.INSTANCE;
        String clientId = this.config.getClientId();
        String str = commandParameters.continuationToken;
        Intrinsics.checkNotNullExpressionValue(str, "commandParameters.continuationToken");
        String str2 = commandParameters.code;
        Intrinsics.checkNotNullExpressionValue(str2, "commandParameters.code");
        String str3 = this.resetPasswordContinueEndpoint;
        String correlationId = commandParameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
        return companion.create(clientId, str, str2, str3, getRequestHeaders(correlationId));
    }

    public final SignUpStartRequest createSignUpStartRequest$common4j(SignUpStartCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        SignUpStartRequest.Companion companion = SignUpStartRequest.INSTANCE;
        String str = commandParameters.username;
        Intrinsics.checkNotNullExpressionValue(str, "commandParameters.username");
        char[] cArr = commandParameters.password;
        Map<String, String> map = commandParameters.userAttributes;
        String clientId = this.config.getClientId();
        String challengeType = this.config.getChallengeType();
        String str2 = this.signUpStartEndpoint;
        String correlationId = commandParameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
        return companion.create(str, cArr, map, clientId, challengeType, str2, getRequestHeaders(correlationId), this.config.getCapabilities());
    }

    public final ResetPasswordSubmitRequest createResetPasswordSubmitRequest$common4j(ResetPasswordSubmitNewPasswordCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        ResetPasswordSubmitRequest.Companion companion = ResetPasswordSubmitRequest.INSTANCE;
        String clientId = this.config.getClientId();
        String str = commandParameters.continuationToken;
        Intrinsics.checkNotNullExpressionValue(str, "commandParameters.continuationToken");
        char[] cArr = commandParameters.newPassword;
        Intrinsics.checkNotNullExpressionValue(cArr, "commandParameters.newPassword");
        String str2 = this.resetPasswordSubmitEndpoint;
        String correlationId = commandParameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
        return companion.create(clientId, str, cArr, str2, getRequestHeaders(correlationId));
    }

    public final ResetPasswordPollCompletionRequest createResetPasswordPollCompletionRequest$common4j(String continuationToken, String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        return ResetPasswordPollCompletionRequest.INSTANCE.create(this.config.getClientId(), continuationToken, this.resetPasswordPollCompletionEndpoint, getRequestHeaders(correlationId));
    }

    public final SignUpContinueRequest createSignUpSubmitCodeRequest$common4j(SignUpSubmitCodeCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        SignUpContinueRequest.Companion companion = SignUpContinueRequest.INSTANCE;
        String str = commandParameters.code;
        String clientId = this.config.getClientId();
        String str2 = commandParameters.continuationToken;
        Intrinsics.checkNotNullExpressionValue(str2, "commandParameters.continuationToken");
        String str3 = this.signUpContinueEndpoint;
        String correlationId = commandParameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
        return SignUpContinueRequest.Companion.create$default(companion, null, null, str, clientId, str2, "oob", str3, getRequestHeaders(correlationId), 3, null);
    }

    public final SignUpContinueRequest createSignUpSubmitPasswordRequest$common4j(SignUpSubmitPasswordCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        SignUpContinueRequest.Companion companion = SignUpContinueRequest.INSTANCE;
        char[] cArr = commandParameters.password;
        String clientId = this.config.getClientId();
        String str = commandParameters.continuationToken;
        Intrinsics.checkNotNullExpressionValue(str, "commandParameters.continuationToken");
        String str2 = this.signUpContinueEndpoint;
        String correlationId = commandParameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
        return SignUpContinueRequest.Companion.create$default(companion, cArr, null, null, clientId, str, "password", str2, getRequestHeaders(correlationId), 6, null);
    }

    public final SignUpContinueRequest createSignUpSubmitUserAttributesRequest$common4j(SignUpSubmitUserAttributesCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        SignUpContinueRequest.Companion companion = SignUpContinueRequest.INSTANCE;
        Map<String, String> map = commandParameters.userAttributes;
        String clientId = this.config.getClientId();
        String str = commandParameters.continuationToken;
        Intrinsics.checkNotNullExpressionValue(str, "commandParameters.continuationToken");
        String str2 = this.signUpContinueEndpoint;
        String correlationId = commandParameters.getCorrelationId();
        Intrinsics.checkNotNullExpressionValue(correlationId, "commandParameters.getCorrelationId()");
        return SignUpContinueRequest.Companion.create$default(companion, null, map, null, clientId, str, NativeAuthConstants.GrantType.ATTRIBUTES, str2, getRequestHeaders(correlationId), 5, null);
    }

    public final SignUpChallengeRequest createSignUpChallengeRequest$common4j(String continuationToken, String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        return SignUpChallengeRequest.INSTANCE.create(continuationToken, this.config.getClientId(), this.config.getChallengeType(), this.signUpChallengeEndpoint, getRequestHeaders(correlationId));
    }

    public final JITIntrospectRequest createJITIntrospectRequest$common4j(String continuationToken, String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        return JITIntrospectRequest.INSTANCE.create(this.config.getClientId(), continuationToken, this.jitIntrospectEndpoint, getRequestHeaders(correlationId));
    }

    public final JITChallengeRequest createJITChallengeRequest$common4j(String continuationToken, String challengeType, String challengeTarget, String challengeChannel, String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(challengeType, "challengeType");
        Intrinsics.checkNotNullParameter(challengeTarget, "challengeTarget");
        Intrinsics.checkNotNullParameter(challengeChannel, "challengeChannel");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        return JITChallengeRequest.INSTANCE.create(this.config.getClientId(), continuationToken, challengeType, challengeTarget, challengeChannel, this.jitChallengeEndpoint, getRequestHeaders(correlationId));
    }

    public final JITContinueRequest createJITContinueRequest$common4j(String continuationToken, String grantType, String code, String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(grantType, "grantType");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        return JITContinueRequest.INSTANCE.create(this.config.getClientId(), continuationToken, grantType, code, this.jitContinueEndpoint, getRequestHeaders(correlationId));
    }

    private final Map<String, String> getRequestHeaders(String correlationId) {
        TreeMap treeMap = new TreeMap();
        if (!Intrinsics.areEqual(correlationId, TelemetryEventStrings.Value.UNSET)) {
            treeMap.put("client-request-id", correlationId);
        }
        treeMap.put("x-client-SKU", LibraryInfoHelper.getLibraryName());
        treeMap.put("x-client-Ver", LibraryInfoHelper.getLibraryVersion());
        Map<String, String> platformIdParameters = Device.getPlatformIdParameters();
        Intrinsics.checkNotNullExpressionValue(platformIdParameters, "getPlatformIdParameters()");
        treeMap.putAll(platformIdParameters);
        Map<String, String> telemetryHeaders = EstsTelemetry.getInstance().getTelemetryHeaders();
        Intrinsics.checkNotNullExpressionValue(telemetryHeaders, "getInstance().telemetryHeaders");
        treeMap.putAll(telemetryHeaders);
        treeMap.put("Content-Type", "application/x-www-form-urlencoded");
        return treeMap;
    }
}
