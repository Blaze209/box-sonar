package com.microsoft.identity.common.java.nativeauth.providers;

import com.microsoft.identity.common.java.nativeauth.commands.parameters.JITChallengeAuthMethodCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.JITContinueCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.JITIntrospectCommandParameters;
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
import com.microsoft.identity.common.java.nativeauth.providers.interactors.JITInteractor;
import com.microsoft.identity.common.java.nativeauth.providers.interactors.ResetPasswordInteractor;
import com.microsoft.identity.common.java.nativeauth.providers.interactors.SignInInteractor;
import com.microsoft.identity.common.java.nativeauth.providers.interactors.SignUpInteractor;
import com.microsoft.identity.common.java.nativeauth.providers.responses.jit.JITChallengeApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.jit.JITContinueApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.jit.JITIntrospectApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordChallengeApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordContinueApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordPollCompletionApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordStartApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordSubmitApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInChallengeApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInInitiateApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInIntrospectApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInTokenApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signup.SignUpChallengeApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signup.SignUpContinueApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signup.SignUpStartApiResult;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NativeAuthOAuth2Strategy.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u0015\u001a\u00020\u0010J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0010J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020!J\u000e\u0010\"\u001a\u00020#2\u0006\u0010\u0019\u001a\u00020$J\u000e\u0010%\u001a\u00020&2\u0006\u0010\u0019\u001a\u00020'J\u000e\u0010(\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020)J\u000e\u0010*\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020+J\u0016\u0010,\u001a\u00020-2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0010J\u000e\u0010.\u001a\u00020/2\u0006\u0010\u0019\u001a\u000200J\u0016\u00101\u001a\u0002022\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0010J\u000e\u00103\u001a\u0002042\u0006\u0010\u0019\u001a\u000205J\u000e\u00106\u001a\u0002072\u0006\u0010\u0019\u001a\u000208J\u0016\u00109\u001a\u00020:2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0010J\u000e\u0010;\u001a\u00020<2\u0006\u0010\u0019\u001a\u00020=J\u001e\u0010>\u001a\u00020:2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010?\u001a\u00020\u0010J\u0016\u0010@\u001a\u00020A2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0010J\u000e\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EJ\u000e\u0010F\u001a\u00020G2\u0006\u0010D\u001a\u00020HJ\u000e\u0010I\u001a\u00020G2\u0006\u0010D\u001a\u00020JJ\u000e\u0010K\u001a\u00020G2\u0006\u0010D\u001a\u00020LR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0012*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthOAuth2Strategy;", "Lcom/microsoft/identity/common/java/providers/microsoft/microsoftsts/MicrosoftStsOAuth2Strategy;", "strategyParameters", "Lcom/microsoft/identity/common/java/providers/oauth2/OAuth2StrategyParameters;", "config", "Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthOAuth2Configuration;", "signInInteractor", "Lcom/microsoft/identity/common/java/nativeauth/providers/interactors/SignInInteractor;", "signUpInteractor", "Lcom/microsoft/identity/common/java/nativeauth/providers/interactors/SignUpInteractor;", "resetPasswordInteractor", "Lcom/microsoft/identity/common/java/nativeauth/providers/interactors/ResetPasswordInteractor;", "jitInteractor", "Lcom/microsoft/identity/common/java/nativeauth/providers/interactors/JITInteractor;", "(Lcom/microsoft/identity/common/java/providers/oauth2/OAuth2StrategyParameters;Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthOAuth2Configuration;Lcom/microsoft/identity/common/java/nativeauth/providers/interactors/SignInInteractor;Lcom/microsoft/identity/common/java/nativeauth/providers/interactors/SignUpInteractor;Lcom/microsoft/identity/common/java/nativeauth/providers/interactors/ResetPasswordInteractor;Lcom/microsoft/identity/common/java/nativeauth/providers/interactors/JITInteractor;)V", "CACHE_IDENTIFIER_MOCK", "", "TAG", "kotlin.jvm.PlatformType", "getConfig", "()Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthOAuth2Configuration;", "getAuthority", "getIssuerCacheIdentifierFromTokenEndpoint", "performContinuationTokenTokenRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult;", "parameters", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInWithContinuationTokenCommandParameters;", "performIntrospect", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInIntrospectApiResult;", "continuationToken", "correlationId", "performJITChallengeRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/jit/JITChallengeApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/JITChallengeAuthMethodCommandParameters;", "performJITContinueRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/jit/JITContinueApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/JITContinueCommandParameters;", "performJITIntrospectRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/jit/JITIntrospectApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/JITIntrospectCommandParameters;", "performOOBTokenRequest", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInSubmitCodeCommandParameters;", "performPasswordTokenRequest", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInSubmitPasswordCommandParameters;", "performResetPasswordChallenge", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordChallengeApiResult;", "performResetPasswordContinue", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordContinueApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/ResetPasswordSubmitCodeCommandParameters;", "performResetPasswordPollCompletion", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordPollCompletionApiResult;", "performResetPasswordStart", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordStartApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/ResetPasswordStartCommandParameters;", "performResetPasswordSubmit", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordSubmitApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/ResetPasswordSubmitNewPasswordCommandParameters;", "performSignInDefaultChallenge", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInChallengeApiResult;", "performSignInInitiate", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInInitiateApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInStartCommandParameters;", "performSignInSelectedChallenge", "challengeId", "performSignUpChallenge", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpChallengeApiResult;", "performSignUpStart", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult;", "commandParameters", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpStartCommandParameters;", "performSignUpSubmitCode", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpSubmitCodeCommandParameters;", "performSignUpSubmitPassword", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpSubmitPasswordCommandParameters;", "performSignUpSubmitUserAttributes", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpSubmitUserAttributesCommandParameters;", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NativeAuthOAuth2Strategy extends MicrosoftStsOAuth2Strategy {
    private final String CACHE_IDENTIFIER_MOCK;
    private final String TAG;
    private final NativeAuthOAuth2Configuration config;
    private final JITInteractor jitInteractor;
    private final ResetPasswordInteractor resetPasswordInteractor;
    private final SignInInteractor signInInteractor;
    private final SignUpInteractor signUpInteractor;
    private final OAuth2StrategyParameters strategyParameters;

    public final NativeAuthOAuth2Configuration getConfig() {
        return this.config;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeAuthOAuth2Strategy(OAuth2StrategyParameters strategyParameters, NativeAuthOAuth2Configuration config, SignInInteractor signInInteractor, SignUpInteractor signUpInteractor, ResetPasswordInteractor resetPasswordInteractor, JITInteractor jitInteractor) {
        super(config, strategyParameters);
        Intrinsics.checkNotNullParameter(strategyParameters, "strategyParameters");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(signInInteractor, "signInInteractor");
        Intrinsics.checkNotNullParameter(signUpInteractor, "signUpInteractor");
        Intrinsics.checkNotNullParameter(resetPasswordInteractor, "resetPasswordInteractor");
        Intrinsics.checkNotNullParameter(jitInteractor, "jitInteractor");
        this.strategyParameters = strategyParameters;
        this.config = config;
        this.signInInteractor = signInInteractor;
        this.signUpInteractor = signUpInteractor;
        this.resetPasswordInteractor = resetPasswordInteractor;
        this.jitInteractor = jitInteractor;
        this.TAG = "NativeAuthOAuth2Strategy";
        this.CACHE_IDENTIFIER_MOCK = "login.windows.net";
    }

    @Override // com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Strategy
    public String getIssuerCacheIdentifierFromTokenEndpoint() {
        if (this.config.getUseMockApiForNativeAuth()) {
            return this.CACHE_IDENTIFIER_MOCK;
        }
        String issuerCacheIdentifierFromTokenEndpoint = super.getIssuerCacheIdentifierFromTokenEndpoint();
        Intrinsics.checkNotNullExpressionValue(issuerCacheIdentifierFromTokenEndpoint, "super.getIssuerCacheIdentifierFromTokenEndpoint()");
        return issuerCacheIdentifierFromTokenEndpoint;
    }

    public final String getAuthority() {
        String string = this.config.getAuthorityUrl().toString();
        Intrinsics.checkNotNullExpressionValue(string, "config.authorityUrl.toString()");
        return string;
    }

    public final SignUpStartApiResult performSignUpStart(SignUpStartCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        return this.signUpInteractor.performSignUpStart(commandParameters);
    }

    public final SignUpChallengeApiResult performSignUpChallenge(String continuationToken, String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        return this.signUpInteractor.performSignUpChallenge(continuationToken, correlationId);
    }

    public final SignUpContinueApiResult performSignUpSubmitCode(SignUpSubmitCodeCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        return this.signUpInteractor.performSignUpSubmitCode(commandParameters);
    }

    public final SignUpContinueApiResult performSignUpSubmitPassword(SignUpSubmitPasswordCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        return this.signUpInteractor.performSignUpSubmitPassword(commandParameters);
    }

    public final SignUpContinueApiResult performSignUpSubmitUserAttributes(SignUpSubmitUserAttributesCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        return this.signUpInteractor.performSignUpSubmitUserAttributes(commandParameters);
    }

    public final SignInInitiateApiResult performSignInInitiate(SignInStartCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return this.signInInteractor.performSignInInitiate(parameters);
    }

    public final SignInChallengeApiResult performSignInDefaultChallenge(String continuationToken, String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        return this.signInInteractor.performSignInDefaultChallenge(continuationToken, correlationId);
    }

    public final SignInChallengeApiResult performSignInSelectedChallenge(String continuationToken, String correlationId, String challengeId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        Intrinsics.checkNotNullParameter(challengeId, "challengeId");
        return this.signInInteractor.performSignInSelectedChallenge(continuationToken, challengeId, correlationId);
    }

    public final SignInIntrospectApiResult performIntrospect(String continuationToken, String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        return this.signInInteractor.performIntrospect(continuationToken, correlationId);
    }

    public final SignInTokenApiResult performContinuationTokenTokenRequest(SignInWithContinuationTokenCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return this.signInInteractor.performContinuationTokenTokenRequest(parameters);
    }

    public final SignInTokenApiResult performOOBTokenRequest(SignInSubmitCodeCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return this.signInInteractor.performOOBTokenRequest(parameters);
    }

    public final SignInTokenApiResult performPasswordTokenRequest(SignInSubmitPasswordCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return this.signInInteractor.performPasswordTokenRequest(parameters);
    }

    public final JITIntrospectApiResult performJITIntrospectRequest(JITIntrospectCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return this.jitInteractor.performIntrospect(parameters);
    }

    public final JITChallengeApiResult performJITChallengeRequest(JITChallengeAuthMethodCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return this.jitInteractor.performChallenge(parameters);
    }

    public final JITContinueApiResult performJITContinueRequest(JITContinueCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return this.jitInteractor.performContinue(parameters);
    }

    public final ResetPasswordStartApiResult performResetPasswordStart(ResetPasswordStartCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return this.resetPasswordInteractor.performResetPasswordStart(parameters);
    }

    public final ResetPasswordChallengeApiResult performResetPasswordChallenge(String continuationToken, String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        return this.resetPasswordInteractor.performResetPasswordChallenge(continuationToken, correlationId);
    }

    public final ResetPasswordContinueApiResult performResetPasswordContinue(ResetPasswordSubmitCodeCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return this.resetPasswordInteractor.performResetPasswordContinue(parameters);
    }

    public final ResetPasswordSubmitApiResult performResetPasswordSubmit(ResetPasswordSubmitNewPasswordCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return this.resetPasswordInteractor.performResetPasswordSubmit(parameters);
    }

    public final ResetPasswordPollCompletionApiResult performResetPasswordPollCompletion(String continuationToken, String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        return this.resetPasswordInteractor.performResetPasswordPollCompletion(continuationToken, correlationId);
    }
}
