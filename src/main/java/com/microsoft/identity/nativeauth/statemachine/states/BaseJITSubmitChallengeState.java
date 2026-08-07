package com.microsoft.identity.nativeauth.statemachine.states;

import android.os.Parcelable;
import com.microsoft.identity.client.AuthenticationResultAdapter;
import com.microsoft.identity.client.IAuthenticationResult;
import com.microsoft.identity.client.internal.CommandParametersAdapter;
import com.microsoft.identity.common.java.commands.ICommandResult;
import com.microsoft.identity.common.java.controllers.CommandDispatcher;
import com.microsoft.identity.common.java.controllers.CommandResult;
import com.microsoft.identity.common.java.eststelemetry.PublicApiId;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.JITChallengeAuthMethodCommandParameters;
import com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.JITChallengeAuthMethodCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.JITCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInCommandResult;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.util.CommandResultUtilKt;
import com.microsoft.identity.common.nativeauth.internal.commands.JITChallengeAuthMethodCommand;
import com.microsoft.identity.common.nativeauth.internal.controllers.NativeAuthMsalController;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration;
import com.microsoft.identity.nativeauth.parameters.NativeAuthChallengeAuthMethodParameters;
import com.microsoft.identity.nativeauth.parameters.NativeAuthRegisterStrongAuthVerificationRequiredResultParameter;
import com.microsoft.identity.nativeauth.statemachine.errors.ErrorTypes;
import com.microsoft.identity.nativeauth.statemachine.errors.RegisterStrongAuthChallengeError;
import com.microsoft.identity.nativeauth.statemachine.results.RegisterStrongAuthChallengeResult;
import com.microsoft.identity.nativeauth.statemachine.results.SignInResult;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: JITStates.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ!\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0005X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/BaseJITSubmitChallengeState;", "Lcom/microsoft/identity/nativeauth/statemachine/states/BaseState;", "Lcom/microsoft/identity/nativeauth/statemachine/states/State;", "Landroid/os/Parcelable;", "continuationToken", "", "correlationId", "config", "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;", "(Ljava/lang/String;Ljava/lang/String;Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;)V", "getContinuationToken$msal_distRelease", "()Ljava/lang/String;", "getCorrelationId$msal_distRelease", "internalChallengeAuthMethod", "Lcom/microsoft/identity/nativeauth/statemachine/results/RegisterStrongAuthChallengeResult;", "parameters", "Lcom/microsoft/identity/nativeauth/parameters/NativeAuthChallengeAuthMethodParameters;", "tag", "(Lcom/microsoft/identity/nativeauth/parameters/NativeAuthChallengeAuthMethodParameters;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isChallengeChannelSMS", "", "challengeChannel", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class BaseJITSubmitChallengeState extends BaseState implements State, Parcelable {
    private final NativeAuthPublicClientApplicationConfiguration config;
    private final String continuationToken;
    private final String correlationId;

    @Override // com.microsoft.identity.nativeauth.statemachine.states.BaseState
    /* JADX INFO: renamed from: getContinuationToken$msal_distRelease, reason: from getter */
    public String getContinuationToken() {
        return this.continuationToken;
    }

    @Override // com.microsoft.identity.nativeauth.statemachine.states.BaseState
    /* JADX INFO: renamed from: getCorrelationId$msal_distRelease, reason: from getter */
    public String getCorrelationId() {
        return this.correlationId;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseJITSubmitChallengeState(String continuationToken, String correlationId, NativeAuthPublicClientApplicationConfiguration config) {
        super(continuationToken, correlationId);
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        Intrinsics.checkNotNullParameter(config, "config");
        this.continuationToken = continuationToken;
        this.correlationId = correlationId;
        this.config = config;
    }

    public final Object internalChallengeAuthMethod(NativeAuthChallengeAuthMethodParameters nativeAuthChallengeAuthMethodParameters, String str, Continuation<? super RegisterStrongAuthChallengeResult> continuation) throws ClientException {
        if (StringsKt.isBlank(nativeAuthChallengeAuthMethodParameters.getVerificationContact())) {
            return new RegisterStrongAuthChallengeError(ErrorTypes.INVALID_INPUT, null, "Invalid verification contact", getCorrelationId(), null, null, 50, null);
        }
        NativeAuthPublicClientApplicationConfiguration nativeAuthPublicClientApplicationConfiguration = this.config;
        JITChallengeAuthMethodCommandParameters params = CommandParametersAdapter.createJITChallengeAuthMethodCommandParameters(nativeAuthPublicClientApplicationConfiguration, nativeAuthPublicClientApplicationConfiguration.getOAuth2TokenCache(), nativeAuthChallengeAuthMethodParameters.getVerificationContact(), nativeAuthChallengeAuthMethodParameters.getAuthMethod().getChallengeChannel(), nativeAuthChallengeAuthMethodParameters.getAuthMethod().getChallengeType(), getCorrelationId(), getContinuationToken());
        Intrinsics.checkNotNullExpressionValue(params, "params");
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(CommandDispatcher.submitSilentReturningFuture(new JITChallengeAuthMethodCommand(params, new NativeAuthMsalController(), PublicApiId.NATIVE_AUTH_JIT_CHALLENGE_AUTH_METHOD)).get(), str, this, null), continuation);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.BaseJITSubmitChallengeState$internalChallengeAuthMethod$2, reason: invalid class name */
    /* JADX INFO: compiled from: JITStates.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/RegisterStrongAuthChallengeResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.BaseJITSubmitChallengeState$internalChallengeAuthMethod$2", f = "JITStates.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RegisterStrongAuthChallengeResult>, Object> {
        final /* synthetic */ CommandResult $rawCommandResult;
        final /* synthetic */ String $tag;
        int label;
        final /* synthetic */ BaseJITSubmitChallengeState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(CommandResult commandResult, String str, BaseJITSubmitChallengeState baseJITSubmitChallengeState, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$rawCommandResult = commandResult;
            this.$tag = str;
            this.this$0 = baseJITSubmitChallengeState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$rawCommandResult, this.$tag, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RegisterStrongAuthChallengeResult> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            INativeAuthCommandResult.APIError aPIError;
            INativeAuthCommandResult.APIError aPIError2;
            Exception exc;
            String message;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CommandResult rawCommandResult = this.$rawCommandResult;
            Intrinsics.checkNotNullExpressionValue(rawCommandResult, "rawCommandResult");
            if (rawCommandResult.getStatus() != ICommandResult.ResultStatus.COMPLETED) {
                if (!(rawCommandResult.getResult() instanceof Exception)) {
                    exc = null;
                    message = "";
                } else {
                    Object result = rawCommandResult.getResult();
                    Intrinsics.checkNotNull(result, "null cannot be cast to non-null type java.lang.Exception{ kotlin.TypeAliasesKt.Exception }");
                    exc = (Exception) result;
                    message = exc.getMessage();
                }
                String correlationId = rawCommandResult.getCorrelationId();
                Intrinsics.checkNotNullExpressionValue(correlationId, "correlationId");
                aPIError2 = new INativeAuthCommandResult.APIError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, message, null, correlationId, null, exc, 20, null);
            } else {
                Object result2 = rawCommandResult.getResult();
                if (result2 instanceof Exception) {
                    String correlationId2 = rawCommandResult.getCorrelationId();
                    Intrinsics.checkNotNullExpressionValue(correlationId2, "this.correlationId");
                    aPIError2 = new INativeAuthCommandResult.APIError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, "Type casting error: result of " + rawCommandResult + " is of type Exception, even though the command was marked as COMPLETED", null, correlationId2, null, null, 52, null);
                } else {
                    try {
                        if (result2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.JITChallengeAuthMethodCommandResult");
                        }
                        aPIError = (JITChallengeAuthMethodCommandResult) result2;
                        aPIError2 = aPIError;
                    } catch (ClassCastException unused) {
                        String str = "Type casting error: result of " + rawCommandResult + " is not of type " + Reflection.getOrCreateKotlinClass(JITChallengeAuthMethodCommandResult.class) + ", but of type " + Reflection.getOrCreateKotlinClass(result2.getClass()) + ", even though the command was marked as COMPLETED";
                        String correlationId3 = rawCommandResult.getCorrelationId();
                        Intrinsics.checkNotNullExpressionValue(correlationId3, "this.correlationId");
                        aPIError = new INativeAuthCommandResult.APIError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, str, null, correlationId3, null, null, 52, null);
                    }
                }
            }
            JITChallengeAuthMethodCommandResult jITChallengeAuthMethodCommandResult = (JITChallengeAuthMethodCommandResult) aPIError2;
            if (jITChallengeAuthMethodCommandResult instanceof INativeAuthCommandResult.APIError) {
                Logger.warnWithObject(this.$tag, jITChallengeAuthMethodCommandResult.getCorrelationId(), "Challenge auth method received unexpected result: ", jITChallengeAuthMethodCommandResult);
                INativeAuthCommandResult.Error error = (INativeAuthCommandResult.Error) jITChallengeAuthMethodCommandResult;
                return new RegisterStrongAuthChallengeError(null, error.getError(), error.getErrorDescription(), error.getCorrelationId(), error.getErrorCodes(), ((INativeAuthCommandResult.APIError) jITChallengeAuthMethodCommandResult).getException(), 1, null);
            }
            if (jITChallengeAuthMethodCommandResult instanceof SignInCommandResult.Complete) {
                IAuthenticationResult authenticationResult = AuthenticationResultAdapter.adapt(((SignInCommandResult.Complete) jITChallengeAuthMethodCommandResult).getAuthenticationResult());
                AccountState.Companion companion = AccountState.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(authenticationResult, "authenticationResult");
                return new SignInResult.Complete(companion.createFromAuthenticationResult(authenticationResult, jITChallengeAuthMethodCommandResult.getCorrelationId(), this.this$0.config));
            }
            if (jITChallengeAuthMethodCommandResult instanceof JITCommandResult.IncorrectVerificationContact) {
                JITCommandResult.IncorrectVerificationContact incorrectVerificationContact = (JITCommandResult.IncorrectVerificationContact) jITChallengeAuthMethodCommandResult;
                return new RegisterStrongAuthChallengeError(ErrorTypes.INVALID_INPUT, incorrectVerificationContact.getError(), incorrectVerificationContact.getErrorDescription(), jITChallengeAuthMethodCommandResult.getCorrelationId(), incorrectVerificationContact.getErrorCodes(), null, 32, null);
            }
            if (jITChallengeAuthMethodCommandResult instanceof JITCommandResult.BlockedVerificationContact) {
                JITCommandResult.BlockedVerificationContact blockedVerificationContact = (JITCommandResult.BlockedVerificationContact) jITChallengeAuthMethodCommandResult;
                return new RegisterStrongAuthChallengeError(ErrorTypes.VERIFICATION_CONTACT_BLOCKED, blockedVerificationContact.getError(), blockedVerificationContact.getErrorDescription(), jITChallengeAuthMethodCommandResult.getCorrelationId(), blockedVerificationContact.getErrorCodes(), null, 32, null);
            }
            if (jITChallengeAuthMethodCommandResult instanceof JITCommandResult.VerificationRequired) {
                JITCommandResult.VerificationRequired verificationRequired = (JITCommandResult.VerificationRequired) jITChallengeAuthMethodCommandResult;
                return new RegisterStrongAuthChallengeResult.VerificationRequired(new NativeAuthRegisterStrongAuthVerificationRequiredResultParameter(new RegisterStrongAuthVerificationRequiredState(verificationRequired.getContinuationToken(), jITChallengeAuthMethodCommandResult.getCorrelationId(), this.this$0.config), verificationRequired.getCodeLength(), verificationRequired.getChallengeTargetLabel(), verificationRequired.getChallengeChannel()));
            }
            if (!(jITChallengeAuthMethodCommandResult instanceof INativeAuthCommandResult.Redirect)) {
                throw new NoWhenBranchMatchedException();
            }
            INativeAuthCommandResult.Redirect redirect = (INativeAuthCommandResult.Redirect) jITChallengeAuthMethodCommandResult;
            return new RegisterStrongAuthChallengeError(ErrorTypes.BROWSER_REQUIRED, redirect.getError(), redirect.getRedirectReason(), jITChallengeAuthMethodCommandResult.getCorrelationId(), redirect.getErrorCodes(), null, 32, null);
        }
    }

    private final boolean isChallengeChannelSMS(String challengeChannel) {
        return StringsKt.equals(challengeChannel, NativeAuthConstants.ChallengeChannel.SMS, true);
    }
}
