package com.microsoft.identity.nativeauth.statemachine.states;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.box.boxandroidlibv2private.model.BoxTaskCollaborator;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.client.internal.CommandParametersAdapter;
import com.microsoft.identity.common.java.commands.ICommandResult;
import com.microsoft.identity.common.java.controllers.CommandDispatcher;
import com.microsoft.identity.common.java.controllers.CommandResult;
import com.microsoft.identity.common.java.eststelemetry.PublicApiId;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpResendCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpResendCodeCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpSubmitCodeCommandResult;
import com.microsoft.identity.common.java.nativeauth.util.CommandResultUtilKt;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.nativeauth.internal.commands.SignUpResendCodeCommand;
import com.microsoft.identity.common.nativeauth.internal.commands.SignUpSubmitCodeCommand;
import com.microsoft.identity.common.nativeauth.internal.controllers.NativeAuthMsalController;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration;
import com.microsoft.identity.nativeauth.RequiredUserAttributeKt;
import com.microsoft.identity.nativeauth.statemachine.errors.ErrorTypes;
import com.microsoft.identity.nativeauth.statemachine.errors.ResendCodeError;
import com.microsoft.identity.nativeauth.statemachine.errors.SubmitCodeError;
import com.microsoft.identity.nativeauth.statemachine.results.SignUpResendCodeResult;
import com.microsoft.identity.nativeauth.statemachine.results.SignUpResult;
import com.microsoft.identity.nativeauth.statemachine.results.SignUpSubmitCodeResult;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: SignUpStates.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003!\"#B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B'\b\u0000\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0011\u0010\u0014\u001a\u00020\u0015H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0014\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u001eJ\u0018\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0013H\u0016R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\t\u001a\u00020\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/SignUpCodeRequiredState;", "Lcom/microsoft/identity/nativeauth/statemachine/states/BaseState;", "Lcom/microsoft/identity/nativeauth/statemachine/states/State;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "continuationToken", "", "correlationId", "username", "config", "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;)V", "TAG", "getContinuationToken$msal_distRelease", "()Ljava/lang/String;", "getCorrelationId$msal_distRelease", "describeContents", "", "resendCode", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpResendCodeResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callback", "Lcom/microsoft/identity/nativeauth/statemachine/states/SignUpCodeRequiredState$SignUpWithResendCodeCallback;", "submitCode", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpSubmitCodeResult;", "code", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/microsoft/identity/nativeauth/statemachine/states/SignUpCodeRequiredState$SubmitCodeCallback;", "writeToParcel", "flags", BoxTaskCollaborator.ROLE_CREATOR, "SignUpWithResendCodeCallback", "SubmitCodeCallback", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SignUpCodeRequiredState extends BaseState implements State, Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String TAG;
    private final NativeAuthPublicClientApplicationConfiguration config;
    private final String continuationToken;
    private final String correlationId;
    private final String username;

    /* JADX INFO: compiled from: SignUpStates.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/SignUpCodeRequiredState$SignUpWithResendCodeCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpResendCodeResult;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SignUpWithResendCodeCallback extends Callback<SignUpResendCodeResult> {
    }

    /* JADX INFO: compiled from: SignUpStates.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/SignUpCodeRequiredState$SubmitCodeCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpSubmitCodeResult;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SubmitCodeCallback extends Callback<SignUpSubmitCodeResult> {
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
    public SignUpCodeRequiredState(String continuationToken, String correlationId, String username, NativeAuthPublicClientApplicationConfiguration config) {
        super(continuationToken, correlationId);
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(config, "config");
        this.continuationToken = continuationToken;
        this.correlationId = correlationId;
        this.username = username;
        this.config = config;
        Intrinsics.checkNotNullExpressionValue("SignUpCodeRequiredState", "SignUpCodeRequiredState::class.java.simpleName");
        this.TAG = "SignUpCodeRequiredState";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SignUpCodeRequiredState(Parcel parcel) {
        NativeAuthPublicClientApplicationConfiguration nativeAuthPublicClientApplicationConfiguration;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String string = parcel.readString();
        string = string == null ? "" : string;
        String string2 = parcel.readString();
        string2 = string2 == null ? TelemetryEventStrings.Value.UNSET : string2;
        String string3 = parcel.readString();
        String str = string3 != null ? string3 : "";
        if (Build.VERSION.SDK_INT >= 33) {
            nativeAuthPublicClientApplicationConfiguration = (Serializable) parcel.readSerializable(NativeAuthPublicClientApplicationConfiguration.class.getClassLoader(), NativeAuthPublicClientApplicationConfiguration.class);
        } else {
            Serializable serializable = parcel.readSerializable();
            nativeAuthPublicClientApplicationConfiguration = (NativeAuthPublicClientApplicationConfiguration) (serializable instanceof NativeAuthPublicClientApplicationConfiguration ? serializable : null);
        }
        Intrinsics.checkNotNull(nativeAuthPublicClientApplicationConfiguration, "null cannot be cast to non-null type com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration");
        this(string, string2, str, (NativeAuthPublicClientApplicationConfiguration) nativeAuthPublicClientApplicationConfiguration);
    }

    public final void submitCode(String code, SubmitCodeCallback callback) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), this.TAG + ".submitCode(code: String, callback: SubmitCodeCallback)");
        BuildersKt__Builders_commonKt.launch$default(NativeAuthPublicClientApplication.INSTANCE.getPcaScope(), null, null, new C18381(code, callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignUpCodeRequiredState$submitCode$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SignUpStates.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.SignUpCodeRequiredState$submitCode$1", f = "SignUpStates.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
    static final class C18381 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SubmitCodeCallback $callback;
        final /* synthetic */ String $code;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18381(String str, SubmitCodeCallback submitCodeCallback, Continuation<? super C18381> continuation) {
            super(2, continuation);
            this.$code = str;
            this.$callback = submitCodeCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SignUpCodeRequiredState.this.new C18381(this.$code, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18381) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = SignUpCodeRequiredState.this.submitCode(this.$code, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((SignUpSubmitCodeResult) obj);
            } catch (MsalException e) {
                Logger.error(SignUpCodeRequiredState.this.TAG, "Exception thrown in submitCode", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }
    }

    public final Object submitCode(String str, Continuation<? super SignUpSubmitCodeResult> continuation) {
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), this.TAG + ".submitCode(code: String)");
        return BuildersKt.withContext(Dispatchers.getIO(), new C18393(str, null), continuation);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignUpCodeRequiredState$submitCode$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SignUpStates.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpSubmitCodeResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.SignUpCodeRequiredState$submitCode$3", f = "SignUpStates.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C18393 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SignUpSubmitCodeResult>, Object> {
        final /* synthetic */ String $code;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18393(String str, Continuation<? super C18393> continuation) {
            super(2, continuation);
            this.$code = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SignUpCodeRequiredState.this.new C18393(this.$code, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SignUpSubmitCodeResult> continuation) {
            return ((C18393) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                SignUpSubmitCodeCommandParameters commandParameters = CommandParametersAdapter.createSignUpSubmitCodeCommandParameters(SignUpCodeRequiredState.this.config, SignUpCodeRequiredState.this.config.getOAuth2TokenCache(), this.$code, SignUpCodeRequiredState.this.getContinuationToken(), SignUpCodeRequiredState.this.getCorrelationId());
                Intrinsics.checkNotNullExpressionValue(commandParameters, "commandParameters");
                CommandResult rawCommandResult = CommandDispatcher.submitSilentReturningFuture(new SignUpSubmitCodeCommand(commandParameters, new NativeAuthMsalController(), PublicApiId.NATIVE_AUTH_SIGN_UP_SUBMIT_CODE)).get();
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
                    String str = CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR;
                    Intrinsics.checkNotNullExpressionValue(correlationId, "correlationId");
                    aPIError2 = new INativeAuthCommandResult.APIError(str, message, null, correlationId, null, exc, 20, null);
                } else {
                    Object result2 = rawCommandResult.getResult();
                    if (result2 instanceof Exception) {
                        String str2 = CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR;
                        String str3 = "Type casting error: result of " + rawCommandResult + " is of type Exception, even though the command was marked as COMPLETED";
                        String correlationId2 = rawCommandResult.getCorrelationId();
                        Intrinsics.checkNotNullExpressionValue(correlationId2, "this.correlationId");
                        aPIError2 = new INativeAuthCommandResult.APIError(str2, str3, null, correlationId2, null, null, 52, null);
                    } else {
                        try {
                            if (result2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpSubmitCodeCommandResult");
                            }
                            aPIError = (SignUpSubmitCodeCommandResult) result2;
                            aPIError2 = aPIError;
                        } catch (ClassCastException unused) {
                            String str4 = CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR;
                            String str5 = "Type casting error: result of " + rawCommandResult + " is not of type " + Reflection.getOrCreateKotlinClass(SignUpSubmitCodeCommandResult.class) + ", but of type " + Reflection.getOrCreateKotlinClass(result2.getClass()) + ", even though the command was marked as COMPLETED";
                            String correlationId3 = rawCommandResult.getCorrelationId();
                            Intrinsics.checkNotNullExpressionValue(correlationId3, "this.correlationId");
                            aPIError = new INativeAuthCommandResult.APIError(str4, str5, null, correlationId3, null, null, 52, null);
                        }
                    }
                }
                SignUpSubmitCodeCommandResult signUpSubmitCodeCommandResult = (SignUpSubmitCodeCommandResult) aPIError2;
                if (signUpSubmitCodeCommandResult instanceof SignUpCommandResult.PasswordRequired) {
                    return new SignUpResult.PasswordRequired(new SignUpPasswordRequiredState(((SignUpCommandResult.PasswordRequired) signUpSubmitCodeCommandResult).getContinuationToken(), signUpSubmitCodeCommandResult.getCorrelationId(), SignUpCodeRequiredState.this.username, SignUpCodeRequiredState.this.config));
                }
                if (signUpSubmitCodeCommandResult instanceof SignUpCommandResult.AttributesRequired) {
                    return new SignUpResult.AttributesRequired(new SignUpAttributesRequiredState(((SignUpCommandResult.AttributesRequired) signUpSubmitCodeCommandResult).getContinuationToken(), signUpSubmitCodeCommandResult.getCorrelationId(), SignUpCodeRequiredState.this.username, SignUpCodeRequiredState.this.config), RequiredUserAttributeKt.toListOfRequiredUserAttribute(((SignUpCommandResult.AttributesRequired) signUpSubmitCodeCommandResult).getRequiredAttributes()));
                }
                if (signUpSubmitCodeCommandResult instanceof SignUpCommandResult.Complete) {
                    return new SignUpResult.Complete(new SignInContinuationState(((SignUpCommandResult.Complete) signUpSubmitCodeCommandResult).getContinuationToken(), signUpSubmitCodeCommandResult.getCorrelationId(), SignUpCodeRequiredState.this.username, SignUpCodeRequiredState.this.config));
                }
                if (signUpSubmitCodeCommandResult instanceof SignUpCommandResult.InvalidCode) {
                    return new SubmitCodeError(ErrorTypes.INVALID_CODE, ((SignUpCommandResult.InvalidCode) signUpSubmitCodeCommandResult).getError(), ((SignUpCommandResult.InvalidCode) signUpSubmitCodeCommandResult).getErrorDescription(), signUpSubmitCodeCommandResult.getCorrelationId(), null, ((SignUpCommandResult.InvalidCode) signUpSubmitCodeCommandResult).getSubError(), null, 80, null);
                }
                if (signUpSubmitCodeCommandResult instanceof INativeAuthCommandResult.Redirect) {
                    return new SubmitCodeError(ErrorTypes.BROWSER_REQUIRED, ((INativeAuthCommandResult.Redirect) signUpSubmitCodeCommandResult).getError(), ((INativeAuthCommandResult.Redirect) signUpSubmitCodeCommandResult).getRedirectReason(), signUpSubmitCodeCommandResult.getCorrelationId(), null, null, null, 112, null);
                }
                if (signUpSubmitCodeCommandResult instanceof SignUpCommandResult.UsernameAlreadyExists) {
                    Logger.warnWithObject(SignUpCodeRequiredState.this.TAG, signUpSubmitCodeCommandResult.getCorrelationId(), "Submit code received unexpected result: ", signUpSubmitCodeCommandResult);
                    return new SubmitCodeError(null, ((SignUpCommandResult.UsernameAlreadyExists) signUpSubmitCodeCommandResult).getError(), ((SignUpCommandResult.UsernameAlreadyExists) signUpSubmitCodeCommandResult).getErrorDescription(), signUpSubmitCodeCommandResult.getCorrelationId(), null, null, null, 113, null);
                }
                if (!(signUpSubmitCodeCommandResult instanceof INativeAuthCommandResult.APIError)) {
                    throw new NoWhenBranchMatchedException();
                }
                Logger.warnWithObject(SignUpCodeRequiredState.this.TAG, signUpSubmitCodeCommandResult.getCorrelationId(), "Submit code received unexpected result: ", signUpSubmitCodeCommandResult);
                return new SubmitCodeError(null, ((INativeAuthCommandResult.APIError) signUpSubmitCodeCommandResult).getError(), ((INativeAuthCommandResult.APIError) signUpSubmitCodeCommandResult).getErrorDescription(), signUpSubmitCodeCommandResult.getCorrelationId(), null, null, ((INativeAuthCommandResult.APIError) signUpSubmitCodeCommandResult).getException(), 49, null);
            } catch (Exception e) {
                return new SubmitCodeError("client_exception", null, "MSAL client exception occurred in submitCode.", SignUpCodeRequiredState.this.getCorrelationId(), null, null, e, 50, null);
            }
        }
    }

    public final void resendCode(SignUpWithResendCodeCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), this.TAG + ".resendCode(callback: SignUpWithResendCodeCallback)");
        BuildersKt__Builders_commonKt.launch$default(NativeAuthPublicClientApplication.INSTANCE.getPcaScope(), null, null, new AnonymousClass1(callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignUpCodeRequiredState$resendCode$1, reason: invalid class name */
    /* JADX INFO: compiled from: SignUpStates.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.SignUpCodeRequiredState$resendCode$1", f = "SignUpStates.kt", i = {}, l = {265}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SignUpWithResendCodeCallback $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SignUpWithResendCodeCallback signUpWithResendCodeCallback, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$callback = signUpWithResendCodeCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SignUpCodeRequiredState.this.new AnonymousClass1(this.$callback, continuation);
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
                    obj = SignUpCodeRequiredState.this.resendCode(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((SignUpResendCodeResult) obj);
            } catch (MsalException e) {
                Logger.error(SignUpCodeRequiredState.this.TAG, "Exception thrown in resendCode", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }
    }

    public final Object resendCode(Continuation<? super SignUpResendCodeResult> continuation) {
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), this.TAG + ".resendCode()");
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass3(null), continuation);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignUpCodeRequiredState$resendCode$3, reason: invalid class name */
    /* JADX INFO: compiled from: SignUpStates.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpResendCodeResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.SignUpCodeRequiredState$resendCode$3", f = "SignUpStates.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SignUpResendCodeResult>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SignUpCodeRequiredState.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SignUpResendCodeResult> continuation) {
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
                SignUpResendCodeCommandParameters commandParameters = CommandParametersAdapter.createSignUpResendCodeCommandParameters(SignUpCodeRequiredState.this.config, SignUpCodeRequiredState.this.config.getOAuth2TokenCache(), SignUpCodeRequiredState.this.getContinuationToken(), SignUpCodeRequiredState.this.getCorrelationId());
                Intrinsics.checkNotNullExpressionValue(commandParameters, "commandParameters");
                CommandResult rawCommandResult = CommandDispatcher.submitSilentReturningFuture(new SignUpResendCodeCommand(commandParameters, new NativeAuthMsalController(), PublicApiId.NATIVE_AUTH_SIGN_UP_RESEND_CODE)).get();
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
                    String str = CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR;
                    Intrinsics.checkNotNullExpressionValue(correlationId, "correlationId");
                    aPIError2 = new INativeAuthCommandResult.APIError(str, message, null, correlationId, null, exc, 20, null);
                } else {
                    Object result2 = rawCommandResult.getResult();
                    if (result2 instanceof Exception) {
                        String str2 = CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR;
                        String str3 = "Type casting error: result of " + rawCommandResult + " is of type Exception, even though the command was marked as COMPLETED";
                        String correlationId2 = rawCommandResult.getCorrelationId();
                        Intrinsics.checkNotNullExpressionValue(correlationId2, "this.correlationId");
                        aPIError2 = new INativeAuthCommandResult.APIError(str2, str3, null, correlationId2, null, null, 52, null);
                    } else {
                        try {
                            if (result2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpResendCodeCommandResult");
                            }
                            aPIError = (SignUpResendCodeCommandResult) result2;
                            aPIError2 = aPIError;
                        } catch (ClassCastException unused) {
                            String str4 = CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR;
                            String str5 = "Type casting error: result of " + rawCommandResult + " is not of type " + Reflection.getOrCreateKotlinClass(SignUpResendCodeCommandResult.class) + ", but of type " + Reflection.getOrCreateKotlinClass(result2.getClass()) + ", even though the command was marked as COMPLETED";
                            String correlationId3 = rawCommandResult.getCorrelationId();
                            Intrinsics.checkNotNullExpressionValue(correlationId3, "this.correlationId");
                            aPIError = new INativeAuthCommandResult.APIError(str4, str5, null, correlationId3, null, null, 52, null);
                        }
                    }
                }
                SignUpResendCodeCommandResult signUpResendCodeCommandResult = (SignUpResendCodeCommandResult) aPIError2;
                if (signUpResendCodeCommandResult instanceof SignUpCommandResult.CodeRequired) {
                    return new SignUpResendCodeResult.Success(new SignUpCodeRequiredState(((SignUpCommandResult.CodeRequired) signUpResendCodeCommandResult).getContinuationToken(), signUpResendCodeCommandResult.getCorrelationId(), SignUpCodeRequiredState.this.username, SignUpCodeRequiredState.this.config), ((SignUpCommandResult.CodeRequired) signUpResendCodeCommandResult).getCodeLength(), ((SignUpCommandResult.CodeRequired) signUpResendCodeCommandResult).getChallengeTargetLabel(), ((SignUpCommandResult.CodeRequired) signUpResendCodeCommandResult).getChallengeChannel());
                }
                if (signUpResendCodeCommandResult instanceof INativeAuthCommandResult.Redirect) {
                    return new ResendCodeError(ErrorTypes.BROWSER_REQUIRED, ((INativeAuthCommandResult.Redirect) signUpResendCodeCommandResult).getError(), ((INativeAuthCommandResult.Redirect) signUpResendCodeCommandResult).getRedirectReason(), signUpResendCodeCommandResult.getCorrelationId(), ((INativeAuthCommandResult.Redirect) signUpResendCodeCommandResult).getErrorCodes(), null, 32, null);
                }
                if (!(signUpResendCodeCommandResult instanceof INativeAuthCommandResult.APIError)) {
                    throw new NoWhenBranchMatchedException();
                }
                Logger.warnWithObject(SignUpCodeRequiredState.this.TAG, signUpResendCodeCommandResult.getCorrelationId(), "Resend code received unexpected result: ", signUpResendCodeCommandResult);
                return new ResendCodeError(null, ((INativeAuthCommandResult.Error) signUpResendCodeCommandResult).getError(), ((INativeAuthCommandResult.Error) signUpResendCodeCommandResult).getErrorDescription(), ((INativeAuthCommandResult.Error) signUpResendCodeCommandResult).getCorrelationId(), ((INativeAuthCommandResult.Error) signUpResendCodeCommandResult).getErrorCodes(), signUpResendCodeCommandResult instanceof INativeAuthCommandResult.APIError ? ((INativeAuthCommandResult.APIError) signUpResendCodeCommandResult).getException() : null, 1, null);
            } catch (Exception e) {
                return new ResendCodeError("client_exception", null, "MSAL client exception occurred in resendCode.", SignUpCodeRequiredState.this.getCorrelationId(), null, e, 18, null);
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(getContinuationToken());
        parcel.writeString(getCorrelationId());
        parcel.writeString(this.username);
        parcel.writeSerializable(this.config);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignUpCodeRequiredState$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: SignUpStates.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/SignUpCodeRequiredState$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/microsoft/identity/nativeauth/statemachine/states/SignUpCodeRequiredState;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/microsoft/identity/nativeauth/statemachine/states/SignUpCodeRequiredState;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion implements Parcelable.Creator<SignUpCodeRequiredState> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SignUpCodeRequiredState createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SignUpCodeRequiredState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SignUpCodeRequiredState[] newArray(int size) {
            return new SignUpCodeRequiredState[size];
        }
    }
}
