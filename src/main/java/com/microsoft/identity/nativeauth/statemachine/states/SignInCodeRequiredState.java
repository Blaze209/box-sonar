package com.microsoft.identity.nativeauth.statemachine.states;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.box.boxandroidlibv2private.model.BoxTaskCollaborator;
import com.microsoft.identity.client.AuthenticationResultAdapter;
import com.microsoft.identity.client.IAuthenticationResult;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.client.internal.CommandParametersAdapter;
import com.microsoft.identity.common.java.commands.ICommandResult;
import com.microsoft.identity.common.java.controllers.CommandDispatcher;
import com.microsoft.identity.common.java.controllers.CommandResult;
import com.microsoft.identity.common.java.eststelemetry.PublicApiId;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInResendCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInSubmitCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInResendCodeCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInSubmitCodeCommandResult;
import com.microsoft.identity.common.java.nativeauth.util.CommandResultUtilKt;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.nativeauth.internal.commands.SignInResendCodeCommand;
import com.microsoft.identity.common.nativeauth.internal.commands.SignInSubmitCodeCommand;
import com.microsoft.identity.common.nativeauth.internal.controllers.NativeAuthMsalController;
import com.microsoft.identity.nativeauth.AuthMethodKt;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration;
import com.microsoft.identity.nativeauth.statemachine.errors.ErrorTypes;
import com.microsoft.identity.nativeauth.statemachine.errors.ResendCodeError;
import com.microsoft.identity.nativeauth.statemachine.errors.SubmitCodeError;
import com.microsoft.identity.nativeauth.statemachine.results.SignInResendCodeResult;
import com.microsoft.identity.nativeauth.statemachine.results.SignInResult;
import com.microsoft.identity.nativeauth.statemachine.results.SignInSubmitCodeResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: SignInStates.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003$%&B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006BA\b\u0000\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0011\u0010\u0017\u001a\u00020\u0018H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u000e\u0010\u0017\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0016\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020!J\u0018\u0010\"\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0016H\u0016R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\t\u001a\u00020\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/SignInCodeRequiredState;", "Lcom/microsoft/identity/nativeauth/statemachine/states/BaseState;", "Lcom/microsoft/identity/nativeauth/statemachine/states/State;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "continuationToken", "", "correlationId", "username", "scopes", "", "claimsRequestJson", "config", "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;)V", "TAG", "getContinuationToken$msal_distRelease", "()Ljava/lang/String;", "getCorrelationId$msal_distRelease", "describeContents", "", "resendCode", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResendCodeResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callback", "Lcom/microsoft/identity/nativeauth/statemachine/states/SignInCodeRequiredState$ResendCodeCallback;", "submitCode", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInSubmitCodeResult;", "code", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/microsoft/identity/nativeauth/statemachine/states/SignInCodeRequiredState$SubmitCodeCallback;", "writeToParcel", "flags", BoxTaskCollaborator.ROLE_CREATOR, "ResendCodeCallback", "SubmitCodeCallback", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SignInCodeRequiredState extends BaseState implements State, Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String TAG;
    private final String claimsRequestJson;
    private final NativeAuthPublicClientApplicationConfiguration config;
    private final String continuationToken;
    private final String correlationId;
    private final List<String> scopes;
    private final String username;

    /* JADX INFO: compiled from: SignInStates.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/SignInCodeRequiredState$ResendCodeCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResendCodeResult;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ResendCodeCallback extends Callback<SignInResendCodeResult> {
    }

    /* JADX INFO: compiled from: SignInStates.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/SignInCodeRequiredState$SubmitCodeCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInSubmitCodeResult;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SubmitCodeCallback extends Callback<SignInSubmitCodeResult> {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

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
    public SignInCodeRequiredState(String continuationToken, String correlationId, String username, List<String> list, String str, NativeAuthPublicClientApplicationConfiguration config) {
        super(continuationToken, correlationId);
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(config, "config");
        this.continuationToken = continuationToken;
        this.correlationId = correlationId;
        this.username = username;
        this.scopes = list;
        this.claimsRequestJson = str;
        this.config = config;
        Intrinsics.checkNotNullExpressionValue("SignInCodeRequiredState", "SignInCodeRequiredState::class.java.simpleName");
        this.TAG = "SignInCodeRequiredState";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SignInCodeRequiredState(Parcel parcel) {
        NativeAuthPublicClientApplicationConfiguration nativeAuthPublicClientApplicationConfiguration;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String string = parcel.readString();
        String str = string == null ? "" : string;
        String string2 = parcel.readString();
        String str2 = string2 == null ? TelemetryEventStrings.Value.UNSET : string2;
        String string3 = parcel.readString();
        String str3 = string3 == null ? "" : string3;
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        String string4 = parcel.readString();
        if (Build.VERSION.SDK_INT >= 33) {
            nativeAuthPublicClientApplicationConfiguration = (Serializable) parcel.readSerializable(NativeAuthPublicClientApplicationConfiguration.class.getClassLoader(), NativeAuthPublicClientApplicationConfiguration.class);
        } else {
            Serializable serializable = parcel.readSerializable();
            nativeAuthPublicClientApplicationConfiguration = (NativeAuthPublicClientApplicationConfiguration) (serializable instanceof NativeAuthPublicClientApplicationConfiguration ? serializable : null);
        }
        Intrinsics.checkNotNull(nativeAuthPublicClientApplicationConfiguration, "null cannot be cast to non-null type com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration");
        this(str, str2, str3, arrayListCreateStringArrayList, string4, (NativeAuthPublicClientApplicationConfiguration) nativeAuthPublicClientApplicationConfiguration);
    }

    public final void submitCode(String code, SubmitCodeCallback callback) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), this.TAG + ".submitCode(code: String, callback: SubmitCodeCallback)");
        BuildersKt__Builders_commonKt.launch$default(NativeAuthPublicClientApplication.INSTANCE.getPcaScope(), null, null, new C18351(code, callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignInCodeRequiredState$submitCode$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SignInStates.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.SignInCodeRequiredState$submitCode$1", f = "SignInStates.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
    static final class C18351 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SubmitCodeCallback $callback;
        final /* synthetic */ String $code;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18351(String str, SubmitCodeCallback submitCodeCallback, Continuation<? super C18351> continuation) {
            super(2, continuation);
            this.$code = str;
            this.$callback = submitCodeCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SignInCodeRequiredState.this.new C18351(this.$code, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18351) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = SignInCodeRequiredState.this.submitCode(this.$code, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((SignInSubmitCodeResult) obj);
            } catch (MsalException e) {
                Logger.error(SignInCodeRequiredState.this.TAG, "Exception thrown in submitCode", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }
    }

    public final Object submitCode(String str, Continuation<? super SignInSubmitCodeResult> continuation) {
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), this.TAG + ".submitCode(code: String)");
        return BuildersKt.withContext(Dispatchers.getIO(), new C18363(str, null), continuation);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignInCodeRequiredState$submitCode$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SignInStates.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInSubmitCodeResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.SignInCodeRequiredState$submitCode$3", f = "SignInStates.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C18363 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SignInSubmitCodeResult>, Object> {
        final /* synthetic */ String $code;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18363(String str, Continuation<? super C18363> continuation) {
            super(2, continuation);
            this.$code = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SignInCodeRequiredState.this.new C18363(this.$code, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SignInSubmitCodeResult> continuation) {
            return ((C18363) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            INativeAuthCommandResult.APIError aPIError;
            INativeAuthCommandResult.APIError aPIError2;
            String message;
            Exception exc;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                SignInSubmitCodeCommandParameters params = CommandParametersAdapter.createSignInSubmitCodeCommandParameters(SignInCodeRequiredState.this.config, SignInCodeRequiredState.this.config.getOAuth2TokenCache(), this.$code, SignInCodeRequiredState.this.getContinuationToken(), SignInCodeRequiredState.this.getCorrelationId(), SignInCodeRequiredState.this.scopes, SignInCodeRequiredState.this.claimsRequestJson);
                Intrinsics.checkNotNullExpressionValue(params, "params");
                CommandResult rawCommandResult = CommandDispatcher.submitSilentReturningFuture(new SignInSubmitCodeCommand(params, new NativeAuthMsalController(), PublicApiId.NATIVE_AUTH_SIGN_IN_SUBMIT_CODE)).get();
                Intrinsics.checkNotNullExpressionValue(rawCommandResult, "rawCommandResult");
                if (rawCommandResult.getStatus() != ICommandResult.ResultStatus.COMPLETED) {
                    if (!(rawCommandResult.getResult() instanceof Exception)) {
                        message = "";
                        exc = null;
                    } else {
                        Object result = rawCommandResult.getResult();
                        Intrinsics.checkNotNull(result, "null cannot be cast to non-null type java.lang.Exception{ kotlin.TypeAliasesKt.Exception }");
                        Exception exc2 = (Exception) result;
                        exc = exc2;
                        message = exc2.getMessage();
                    }
                    String correlationId = rawCommandResult.getCorrelationId();
                    Intrinsics.checkNotNullExpressionValue(correlationId, "correlationId");
                    aPIError2 = new INativeAuthCommandResult.APIError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, message, null, correlationId, null, exc, 20, null);
                } else {
                    Object result2 = rawCommandResult.getResult();
                    if (result2 instanceof Exception) {
                        String str = "Type casting error: result of " + rawCommandResult + " is of type Exception, even though the command was marked as COMPLETED";
                        String correlationId2 = rawCommandResult.getCorrelationId();
                        Intrinsics.checkNotNullExpressionValue(correlationId2, "this.correlationId");
                        aPIError2 = new INativeAuthCommandResult.APIError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, str, null, correlationId2, null, null, 52, null);
                    } else {
                        try {
                            if (result2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.SignInSubmitCodeCommandResult");
                            }
                            aPIError = (SignInSubmitCodeCommandResult) result2;
                            aPIError2 = aPIError;
                        } catch (ClassCastException unused) {
                            String str2 = "Type casting error: result of " + rawCommandResult + " is not of type " + Reflection.getOrCreateKotlinClass(SignInSubmitCodeCommandResult.class) + ", but of type " + Reflection.getOrCreateKotlinClass(result2.getClass()) + ", even though the command was marked as COMPLETED";
                            String correlationId3 = rawCommandResult.getCorrelationId();
                            Intrinsics.checkNotNullExpressionValue(correlationId3, "this.correlationId");
                            aPIError = new INativeAuthCommandResult.APIError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, str2, null, correlationId3, null, null, 52, null);
                        }
                    }
                }
                SignInSubmitCodeCommandResult signInSubmitCodeCommandResult = (SignInSubmitCodeCommandResult) aPIError2;
                if (signInSubmitCodeCommandResult instanceof SignInCommandResult.IncorrectCode) {
                    return new SubmitCodeError(ErrorTypes.INVALID_CODE, ((SignInCommandResult.IncorrectCode) signInSubmitCodeCommandResult).getError(), ((SignInCommandResult.IncorrectCode) signInSubmitCodeCommandResult).getErrorDescription(), signInSubmitCodeCommandResult.getCorrelationId(), ((SignInCommandResult.IncorrectCode) signInSubmitCodeCommandResult).getErrorCodes(), ((SignInCommandResult.IncorrectCode) signInSubmitCodeCommandResult).getSubError(), null, 64, null);
                }
                if (signInSubmitCodeCommandResult instanceof SignInCommandResult.Complete) {
                    IAuthenticationResult authenticationResult = AuthenticationResultAdapter.adapt(((SignInCommandResult.Complete) signInSubmitCodeCommandResult).getAuthenticationResult());
                    AccountState.Companion companion = AccountState.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(authenticationResult, "authenticationResult");
                    return new SignInResult.Complete(companion.createFromAuthenticationResult(authenticationResult, signInSubmitCodeCommandResult.getCorrelationId(), SignInCodeRequiredState.this.config));
                }
                if (signInSubmitCodeCommandResult instanceof INativeAuthCommandResult.Redirect) {
                    return new SubmitCodeError(ErrorTypes.BROWSER_REQUIRED, ((INativeAuthCommandResult.Redirect) signInSubmitCodeCommandResult).getError(), ((INativeAuthCommandResult.Redirect) signInSubmitCodeCommandResult).getRedirectReason(), signInSubmitCodeCommandResult.getCorrelationId(), null, null, null, 112, null);
                }
                if (signInSubmitCodeCommandResult instanceof INativeAuthCommandResult.APIError) {
                    Logger.warnWithObject(SignInCodeRequiredState.this.TAG, signInSubmitCodeCommandResult.getCorrelationId(), "Submit code received unexpected result: ", signInSubmitCodeCommandResult);
                    return new SubmitCodeError(null, ((INativeAuthCommandResult.APIError) signInSubmitCodeCommandResult).getError(), ((INativeAuthCommandResult.APIError) signInSubmitCodeCommandResult).getErrorDescription(), signInSubmitCodeCommandResult.getCorrelationId(), ((INativeAuthCommandResult.APIError) signInSubmitCodeCommandResult).getErrorCodes(), null, ((INativeAuthCommandResult.APIError) signInSubmitCodeCommandResult).getException(), 33, null);
                }
                if (signInSubmitCodeCommandResult instanceof SignInCommandResult.MFARequired) {
                    return new SignInResult.MFARequired(new AwaitingMFAState(((SignInCommandResult.MFARequired) signInSubmitCodeCommandResult).getContinuationToken(), signInSubmitCodeCommandResult.getCorrelationId(), SignInCodeRequiredState.this.scopes, SignInCodeRequiredState.this.config), AuthMethodKt.toListOfAuthMethods(((SignInCommandResult.MFARequired) signInSubmitCodeCommandResult).getAuthMethods()));
                }
                if (signInSubmitCodeCommandResult instanceof SignInCommandResult.StrongAuthMethodRegistrationRequired) {
                    return new SignInResult.StrongAuthMethodRegistrationRequired(new RegisterStrongAuthState(((SignInCommandResult.StrongAuthMethodRegistrationRequired) signInSubmitCodeCommandResult).getContinuationToken(), signInSubmitCodeCommandResult.getCorrelationId(), SignInCodeRequiredState.this.config), AuthMethodKt.toListOfAuthMethods(((SignInCommandResult.StrongAuthMethodRegistrationRequired) signInSubmitCodeCommandResult).getAuthMethods()));
                }
                throw new NoWhenBranchMatchedException();
            } catch (Exception e) {
                return new SubmitCodeError("client_exception", null, "MSAL client exception occurred in submitCode.", SignInCodeRequiredState.this.getCorrelationId(), null, null, e, 50, null);
            }
        }
    }

    public final void resendCode(ResendCodeCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), this.TAG + ".resendCode(callback: ResendCodeCallback)");
        BuildersKt__Builders_commonKt.launch$default(NativeAuthPublicClientApplication.INSTANCE.getPcaScope(), null, null, new AnonymousClass1(callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignInCodeRequiredState$resendCode$1, reason: invalid class name */
    /* JADX INFO: compiled from: SignInStates.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.SignInCodeRequiredState$resendCode$1", f = "SignInStates.kt", i = {}, l = {258}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ResendCodeCallback $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ResendCodeCallback resendCodeCallback, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$callback = resendCodeCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SignInCodeRequiredState.this.new AnonymousClass1(this.$callback, continuation);
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
                    obj = SignInCodeRequiredState.this.resendCode(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((SignInResendCodeResult) obj);
            } catch (MsalException e) {
                Logger.error(SignInCodeRequiredState.this.TAG, "Exception thrown in resendCode", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }
    }

    public final Object resendCode(Continuation<? super SignInResendCodeResult> continuation) {
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), this.TAG + ".resendCode()");
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass3(null), continuation);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignInCodeRequiredState$resendCode$3, reason: invalid class name */
    /* JADX INFO: compiled from: SignInStates.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResendCodeResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.SignInCodeRequiredState$resendCode$3", f = "SignInStates.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SignInResendCodeResult>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SignInCodeRequiredState.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SignInResendCodeResult> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            INativeAuthCommandResult.APIError aPIError;
            INativeAuthCommandResult.APIError aPIError2;
            String message;
            Exception exc;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                SignInResendCodeCommandParameters params = CommandParametersAdapter.createSignInResendCodeCommandParameters(SignInCodeRequiredState.this.config, SignInCodeRequiredState.this.config.getOAuth2TokenCache(), SignInCodeRequiredState.this.getCorrelationId(), SignInCodeRequiredState.this.getContinuationToken());
                Intrinsics.checkNotNullExpressionValue(params, "params");
                CommandResult rawCommandResult = CommandDispatcher.submitSilentReturningFuture(new SignInResendCodeCommand(params, new NativeAuthMsalController(), PublicApiId.NATIVE_AUTH_SIGN_IN_RESEND_CODE)).get();
                Intrinsics.checkNotNullExpressionValue(rawCommandResult, "rawCommandResult");
                if (rawCommandResult.getStatus() != ICommandResult.ResultStatus.COMPLETED) {
                    if (!(rawCommandResult.getResult() instanceof Exception)) {
                        message = "";
                        exc = null;
                    } else {
                        Object result = rawCommandResult.getResult();
                        Intrinsics.checkNotNull(result, "null cannot be cast to non-null type java.lang.Exception{ kotlin.TypeAliasesKt.Exception }");
                        Exception exc2 = (Exception) result;
                        exc = exc2;
                        message = exc2.getMessage();
                    }
                    String correlationId = rawCommandResult.getCorrelationId();
                    Intrinsics.checkNotNullExpressionValue(correlationId, "correlationId");
                    aPIError2 = new INativeAuthCommandResult.APIError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, message, null, correlationId, null, exc, 20, null);
                } else {
                    Object result2 = rawCommandResult.getResult();
                    if (result2 instanceof Exception) {
                        String str = "Type casting error: result of " + rawCommandResult + " is of type Exception, even though the command was marked as COMPLETED";
                        String correlationId2 = rawCommandResult.getCorrelationId();
                        Intrinsics.checkNotNullExpressionValue(correlationId2, "this.correlationId");
                        aPIError2 = new INativeAuthCommandResult.APIError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, str, null, correlationId2, null, null, 52, null);
                    } else {
                        try {
                            if (result2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.SignInResendCodeCommandResult");
                            }
                            aPIError = (SignInResendCodeCommandResult) result2;
                            aPIError2 = aPIError;
                        } catch (ClassCastException unused) {
                            String str2 = "Type casting error: result of " + rawCommandResult + " is not of type " + Reflection.getOrCreateKotlinClass(SignInResendCodeCommandResult.class) + ", but of type " + Reflection.getOrCreateKotlinClass(result2.getClass()) + ", even though the command was marked as COMPLETED";
                            String correlationId3 = rawCommandResult.getCorrelationId();
                            Intrinsics.checkNotNullExpressionValue(correlationId3, "this.correlationId");
                            aPIError = new INativeAuthCommandResult.APIError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, str2, null, correlationId3, null, null, 52, null);
                        }
                    }
                }
                SignInResendCodeCommandResult signInResendCodeCommandResult = (SignInResendCodeCommandResult) aPIError2;
                if (signInResendCodeCommandResult instanceof SignInCommandResult.CodeRequired) {
                    return new SignInResendCodeResult.Success(new SignInCodeRequiredState(((SignInCommandResult.CodeRequired) signInResendCodeCommandResult).getContinuationToken(), signInResendCodeCommandResult.getCorrelationId(), SignInCodeRequiredState.this.username, SignInCodeRequiredState.this.scopes, SignInCodeRequiredState.this.claimsRequestJson, SignInCodeRequiredState.this.config), ((SignInCommandResult.CodeRequired) signInResendCodeCommandResult).getCodeLength(), ((SignInCommandResult.CodeRequired) signInResendCodeCommandResult).getChallengeTargetLabel(), ((SignInCommandResult.CodeRequired) signInResendCodeCommandResult).getChallengeChannel());
                }
                if (signInResendCodeCommandResult instanceof INativeAuthCommandResult.Redirect) {
                    return new ResendCodeError(ErrorTypes.BROWSER_REQUIRED, ((INativeAuthCommandResult.Redirect) signInResendCodeCommandResult).getError(), ((INativeAuthCommandResult.Redirect) signInResendCodeCommandResult).getRedirectReason(), signInResendCodeCommandResult.getCorrelationId(), ((INativeAuthCommandResult.Redirect) signInResendCodeCommandResult).getErrorCodes(), null, 32, null);
                }
                if (!(signInResendCodeCommandResult instanceof INativeAuthCommandResult.APIError)) {
                    throw new NoWhenBranchMatchedException();
                }
                Logger.warnWithObject(SignInCodeRequiredState.this.TAG, signInResendCodeCommandResult.getCorrelationId(), "Resend code received unexpected result: ", signInResendCodeCommandResult);
                return new ResendCodeError(null, ((INativeAuthCommandResult.Error) signInResendCodeCommandResult).getError(), ((INativeAuthCommandResult.Error) signInResendCodeCommandResult).getErrorDescription(), ((INativeAuthCommandResult.Error) signInResendCodeCommandResult).getCorrelationId(), ((INativeAuthCommandResult.Error) signInResendCodeCommandResult).getErrorCodes(), signInResendCodeCommandResult instanceof INativeAuthCommandResult.APIError ? ((INativeAuthCommandResult.APIError) signInResendCodeCommandResult).getException() : null, 1, null);
            } catch (Exception e) {
                return new ResendCodeError("client_exception", null, "MSAL client exception occurred in resendCode.", SignInCodeRequiredState.this.getCorrelationId(), null, e, 18, null);
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(getContinuationToken());
        parcel.writeString(getCorrelationId());
        parcel.writeStringList(this.scopes);
        parcel.writeSerializable(this.config);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignInCodeRequiredState$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: SignInStates.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/SignInCodeRequiredState$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/microsoft/identity/nativeauth/statemachine/states/SignInCodeRequiredState;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/microsoft/identity/nativeauth/statemachine/states/SignInCodeRequiredState;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion implements Parcelable.Creator<SignInCodeRequiredState> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SignInCodeRequiredState createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SignInCodeRequiredState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SignInCodeRequiredState[] newArray(int size) {
            return new SignInCodeRequiredState[size];
        }
    }
}
