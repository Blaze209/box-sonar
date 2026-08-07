package com.microsoft.identity.nativeauth.statemachine.states;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.box.boxandroidlibv2private.model.BoxTaskCollaborator;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.microsoft.identity.client.AuthenticationResultAdapter;
import com.microsoft.identity.client.IAuthenticationResult;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.client.internal.CommandParametersAdapter;
import com.microsoft.identity.common.java.commands.ICommandResult;
import com.microsoft.identity.common.java.controllers.CommandDispatcher;
import com.microsoft.identity.common.java.controllers.CommandResult;
import com.microsoft.identity.common.java.eststelemetry.PublicApiId;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.JITContinueCommandParameters;
import com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.JITCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.JITSubmitChallengeCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInCommandResult;
import com.microsoft.identity.common.java.nativeauth.util.CommandResultUtilKt;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.nativeauth.internal.commands.JITSubmitChallengeCommand;
import com.microsoft.identity.common.nativeauth.internal.controllers.NativeAuthMsalController;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration;
import com.microsoft.identity.nativeauth.parameters.NativeAuthChallengeAuthMethodParameters;
import com.microsoft.identity.nativeauth.statemachine.errors.ErrorTypes;
import com.microsoft.identity.nativeauth.statemachine.errors.RegisterStrongAuthSubmitChallengeError;
import com.microsoft.identity.nativeauth.statemachine.results.RegisterStrongAuthChallengeResult;
import com.microsoft.identity.nativeauth.statemachine.results.RegisterStrongAuthSubmitChallengeResult;
import com.microsoft.identity.nativeauth.statemachine.results.SignInResult;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: JITStates.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0003 !\"B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0016\u0010\u000f\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u001dJ\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0018H\u0016R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0007\u001a\u00020\u0006X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/RegisterStrongAuthVerificationRequiredState;", "Lcom/microsoft/identity/nativeauth/statemachine/states/BaseJITSubmitChallengeState;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "continuationToken", "", "correlationId", "config", "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;", "(Ljava/lang/String;Ljava/lang/String;Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;)V", "TAG", "getContinuationToken$msal_distRelease", "()Ljava/lang/String;", "getCorrelationId$msal_distRelease", "challengeAuthMethod", "Lcom/microsoft/identity/nativeauth/statemachine/results/RegisterStrongAuthChallengeResult;", "parameters", "Lcom/microsoft/identity/nativeauth/parameters/NativeAuthChallengeAuthMethodParameters;", "(Lcom/microsoft/identity/nativeauth/parameters/NativeAuthChallengeAuthMethodParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callback", "Lcom/microsoft/identity/nativeauth/statemachine/states/RegisterStrongAuthVerificationRequiredState$ChallengeAuthMethodCallback;", "describeContents", "", "submitChallenge", "Lcom/microsoft/identity/nativeauth/statemachine/results/RegisterStrongAuthSubmitChallengeResult;", ClientData.KEY_CHALLENGE, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/microsoft/identity/nativeauth/statemachine/states/RegisterStrongAuthVerificationRequiredState$SubmitChallengeCallback;", "writeToParcel", "flags", BoxTaskCollaborator.ROLE_CREATOR, "ChallengeAuthMethodCallback", "SubmitChallengeCallback", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RegisterStrongAuthVerificationRequiredState extends BaseJITSubmitChallengeState {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String TAG;
    private final NativeAuthPublicClientApplicationConfiguration config;
    private final String continuationToken;
    private final String correlationId;

    /* JADX INFO: compiled from: JITStates.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/RegisterStrongAuthVerificationRequiredState$ChallengeAuthMethodCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/RegisterStrongAuthChallengeResult;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ChallengeAuthMethodCallback extends Callback<RegisterStrongAuthChallengeResult> {
    }

    /* JADX INFO: compiled from: JITStates.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/RegisterStrongAuthVerificationRequiredState$SubmitChallengeCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/RegisterStrongAuthSubmitChallengeResult;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SubmitChallengeCallback extends Callback<RegisterStrongAuthSubmitChallengeResult> {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.microsoft.identity.nativeauth.statemachine.states.BaseJITSubmitChallengeState, com.microsoft.identity.nativeauth.statemachine.states.BaseState
    /* JADX INFO: renamed from: getContinuationToken$msal_distRelease, reason: from getter */
    public String getContinuationToken() {
        return this.continuationToken;
    }

    @Override // com.microsoft.identity.nativeauth.statemachine.states.BaseJITSubmitChallengeState, com.microsoft.identity.nativeauth.statemachine.states.BaseState
    /* JADX INFO: renamed from: getCorrelationId$msal_distRelease, reason: from getter */
    public String getCorrelationId() {
        return this.correlationId;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RegisterStrongAuthVerificationRequiredState(String continuationToken, String correlationId, NativeAuthPublicClientApplicationConfiguration config) {
        super(continuationToken, correlationId, config);
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        Intrinsics.checkNotNullParameter(config, "config");
        this.continuationToken = continuationToken;
        this.correlationId = correlationId;
        this.config = config;
        Intrinsics.checkNotNullExpressionValue("RegisterStrongAuthVerificationRequiredState", "RegisterStrongAuthVerifi…te::class.java.simpleName");
        this.TAG = "RegisterStrongAuthVerificationRequiredState";
    }

    public final void submitChallenge(String challenge, SubmitChallengeCallback callback) {
        Intrinsics.checkNotNullParameter(challenge, "challenge");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), this.TAG + ".submitChallenge(callback: SubmitChallengeCallback)");
        BuildersKt__Builders_commonKt.launch$default(NativeAuthPublicClientApplication.INSTANCE.getPcaScope(), null, null, new C18321(challenge, callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.RegisterStrongAuthVerificationRequiredState$submitChallenge$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JITStates.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.RegisterStrongAuthVerificationRequiredState$submitChallenge$1", f = "JITStates.kt", i = {}, l = {259}, m = "invokeSuspend", n = {}, s = {})
    static final class C18321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SubmitChallengeCallback $callback;
        final /* synthetic */ String $challenge;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18321(String str, SubmitChallengeCallback submitChallengeCallback, Continuation<? super C18321> continuation) {
            super(2, continuation);
            this.$challenge = str;
            this.$callback = submitChallengeCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RegisterStrongAuthVerificationRequiredState.this.new C18321(this.$challenge, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18321) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws ClientException {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = RegisterStrongAuthVerificationRequiredState.this.submitChallenge(this.$challenge, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((RegisterStrongAuthSubmitChallengeResult) obj);
            } catch (MsalException e) {
                Logger.error(RegisterStrongAuthVerificationRequiredState.this.TAG, "Exception thrown in submitChallenge", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }
    }

    public final Object submitChallenge(String str, Continuation<? super RegisterStrongAuthSubmitChallengeResult> continuation) throws ClientException {
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), this.TAG + ".submitChallenge(challenge: String)");
        if (StringsKt.isBlank(str)) {
            return new RegisterStrongAuthSubmitChallengeError(null, ErrorTypes.INVALID_CHALLENGE, "Empty challenge provided.", getCorrelationId(), null, null, 49, null);
        }
        NativeAuthPublicClientApplicationConfiguration nativeAuthPublicClientApplicationConfiguration = this.config;
        JITContinueCommandParameters params = CommandParametersAdapter.createJITSubmitChallengeCommandParameters(nativeAuthPublicClientApplicationConfiguration, nativeAuthPublicClientApplicationConfiguration.getOAuth2TokenCache(), "oob", str, getCorrelationId(), getContinuationToken());
        Intrinsics.checkNotNullExpressionValue(params, "params");
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass3(CommandDispatcher.submitSilentReturningFuture(new JITSubmitChallengeCommand(params, new NativeAuthMsalController(), PublicApiId.NATIVE_AUTH_JIT_SUBMIT_CHALLENGE)).get(), this, null), continuation);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.RegisterStrongAuthVerificationRequiredState$submitChallenge$3, reason: invalid class name */
    /* JADX INFO: compiled from: JITStates.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/RegisterStrongAuthSubmitChallengeResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.RegisterStrongAuthVerificationRequiredState$submitChallenge$3", f = "JITStates.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RegisterStrongAuthSubmitChallengeResult>, Object> {
        final /* synthetic */ CommandResult $rawCommandResult;
        int label;
        final /* synthetic */ RegisterStrongAuthVerificationRequiredState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(CommandResult commandResult, RegisterStrongAuthVerificationRequiredState registerStrongAuthVerificationRequiredState, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$rawCommandResult = commandResult;
            this.this$0 = registerStrongAuthVerificationRequiredState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$rawCommandResult, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RegisterStrongAuthSubmitChallengeResult> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                            throw new NullPointerException("null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.JITSubmitChallengeCommandResult");
                        }
                        aPIError = (JITSubmitChallengeCommandResult) result2;
                        aPIError2 = aPIError;
                    } catch (ClassCastException unused) {
                        String str = "Type casting error: result of " + rawCommandResult + " is not of type " + Reflection.getOrCreateKotlinClass(JITSubmitChallengeCommandResult.class) + ", but of type " + Reflection.getOrCreateKotlinClass(result2.getClass()) + ", even though the command was marked as COMPLETED";
                        String correlationId3 = rawCommandResult.getCorrelationId();
                        Intrinsics.checkNotNullExpressionValue(correlationId3, "this.correlationId");
                        aPIError = new INativeAuthCommandResult.APIError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, str, null, correlationId3, null, null, 52, null);
                    }
                }
            }
            JITSubmitChallengeCommandResult jITSubmitChallengeCommandResult = (JITSubmitChallengeCommandResult) aPIError2;
            if (jITSubmitChallengeCommandResult instanceof SignInCommandResult.Complete) {
                IAuthenticationResult authenticationResult = AuthenticationResultAdapter.adapt(((SignInCommandResult.Complete) jITSubmitChallengeCommandResult).getAuthenticationResult());
                AccountState.Companion companion = AccountState.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(authenticationResult, "authenticationResult");
                return new SignInResult.Complete(companion.createFromAuthenticationResult(authenticationResult, jITSubmitChallengeCommandResult.getCorrelationId(), this.this$0.config));
            }
            if (jITSubmitChallengeCommandResult instanceof JITCommandResult.IncorrectChallenge) {
                JITCommandResult.IncorrectChallenge incorrectChallenge = (JITCommandResult.IncorrectChallenge) jITSubmitChallengeCommandResult;
                return new RegisterStrongAuthSubmitChallengeError(ErrorTypes.INVALID_CHALLENGE, incorrectChallenge.getError(), incorrectChallenge.getErrorDescription(), jITSubmitChallengeCommandResult.getCorrelationId(), incorrectChallenge.getErrorCodes(), null, 32, null);
            }
            if (jITSubmitChallengeCommandResult instanceof INativeAuthCommandResult.Redirect) {
                INativeAuthCommandResult.Redirect redirect = (INativeAuthCommandResult.Redirect) jITSubmitChallengeCommandResult;
                return new RegisterStrongAuthSubmitChallengeError(ErrorTypes.BROWSER_REQUIRED, redirect.getError(), redirect.getRedirectReason(), jITSubmitChallengeCommandResult.getCorrelationId(), redirect.getErrorCodes(), null, 32, null);
            }
            if (!(jITSubmitChallengeCommandResult instanceof INativeAuthCommandResult.APIError)) {
                throw new NoWhenBranchMatchedException();
            }
            Logger.warnWithObject(this.this$0.TAG, jITSubmitChallengeCommandResult.getCorrelationId(), "Submit challenge received unexpected result: ", jITSubmitChallengeCommandResult);
            INativeAuthCommandResult.Error error = (INativeAuthCommandResult.Error) jITSubmitChallengeCommandResult;
            return new RegisterStrongAuthSubmitChallengeError(null, error.getError(), error.getErrorDescription(), error.getCorrelationId(), error.getErrorCodes(), ((INativeAuthCommandResult.APIError) jITSubmitChallengeCommandResult).getException(), 1, null);
        }
    }

    public final void challengeAuthMethod(NativeAuthChallengeAuthMethodParameters parameters, ChallengeAuthMethodCallback callback) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), this.TAG + ".challengeAuthMethod(parameters: NativeAuthChallengeAuthMethodParameters, callback: ChallengeAuthMethodCallback)");
        BuildersKt__Builders_commonKt.launch$default(NativeAuthPublicClientApplication.INSTANCE.getPcaScope(), null, null, new AnonymousClass1(parameters, callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.RegisterStrongAuthVerificationRequiredState$challengeAuthMethod$1, reason: invalid class name */
    /* JADX INFO: compiled from: JITStates.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.RegisterStrongAuthVerificationRequiredState$challengeAuthMethod$1", f = "JITStates.kt", i = {}, l = {379}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ChallengeAuthMethodCallback $callback;
        final /* synthetic */ NativeAuthChallengeAuthMethodParameters $parameters;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(NativeAuthChallengeAuthMethodParameters nativeAuthChallengeAuthMethodParameters, ChallengeAuthMethodCallback challengeAuthMethodCallback, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$parameters = nativeAuthChallengeAuthMethodParameters;
            this.$callback = challengeAuthMethodCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RegisterStrongAuthVerificationRequiredState.this.new AnonymousClass1(this.$parameters, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = RegisterStrongAuthVerificationRequiredState.this.challengeAuthMethod(this.$parameters, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((RegisterStrongAuthChallengeResult) obj);
            } catch (MsalException e) {
                Logger.error(RegisterStrongAuthVerificationRequiredState.this.TAG, "Exception thrown in challengeAuthMethod", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }
    }

    public final Object challengeAuthMethod(NativeAuthChallengeAuthMethodParameters nativeAuthChallengeAuthMethodParameters, Continuation<? super RegisterStrongAuthChallengeResult> continuation) {
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), this.TAG + ".challengeAuthMethod(parameters: NativeAuthChallengeAuthMethodParameters)");
        return internalChallengeAuthMethod(nativeAuthChallengeAuthMethodParameters, this.TAG, continuation);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public RegisterStrongAuthVerificationRequiredState(Parcel parcel) {
        NativeAuthPublicClientApplicationConfiguration nativeAuthPublicClientApplicationConfiguration;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String string = parcel.readString();
        string = string == null ? "" : string;
        String string2 = parcel.readString();
        string2 = string2 == null ? TelemetryEventStrings.Value.UNSET : string2;
        if (Build.VERSION.SDK_INT >= 33) {
            nativeAuthPublicClientApplicationConfiguration = (Serializable) parcel.readSerializable(NativeAuthPublicClientApplicationConfiguration.class.getClassLoader(), NativeAuthPublicClientApplicationConfiguration.class);
        } else {
            Serializable serializable = parcel.readSerializable();
            nativeAuthPublicClientApplicationConfiguration = (NativeAuthPublicClientApplicationConfiguration) (serializable instanceof NativeAuthPublicClientApplicationConfiguration ? serializable : null);
        }
        Intrinsics.checkNotNull(nativeAuthPublicClientApplicationConfiguration, "null cannot be cast to non-null type com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration");
        this(string, string2, (NativeAuthPublicClientApplicationConfiguration) nativeAuthPublicClientApplicationConfiguration);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(getContinuationToken());
        parcel.writeString(getCorrelationId());
        parcel.writeSerializable(this.config);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.RegisterStrongAuthVerificationRequiredState$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: JITStates.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/RegisterStrongAuthVerificationRequiredState$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/microsoft/identity/nativeauth/statemachine/states/RegisterStrongAuthVerificationRequiredState;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/microsoft/identity/nativeauth/statemachine/states/RegisterStrongAuthVerificationRequiredState;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion implements Parcelable.Creator<RegisterStrongAuthVerificationRequiredState> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RegisterStrongAuthVerificationRequiredState createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RegisterStrongAuthVerificationRequiredState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RegisterStrongAuthVerificationRequiredState[] newArray(int size) {
            return new RegisterStrongAuthVerificationRequiredState[size];
        }
    }
}
