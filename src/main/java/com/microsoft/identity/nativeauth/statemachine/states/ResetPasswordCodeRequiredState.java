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
import com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordResendCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordSubmitCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordResendCodeCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordSubmitCodeCommandResult;
import com.microsoft.identity.common.java.nativeauth.util.CommandResultUtilKt;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordResendCodeCommand;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitCodeCommand;
import com.microsoft.identity.common.nativeauth.internal.controllers.NativeAuthMsalController;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration;
import com.microsoft.identity.nativeauth.statemachine.errors.ErrorTypes;
import com.microsoft.identity.nativeauth.statemachine.errors.ResendCodeError;
import com.microsoft.identity.nativeauth.statemachine.errors.SubmitCodeError;
import com.microsoft.identity.nativeauth.statemachine.results.ResetPasswordResendCodeResult;
import com.microsoft.identity.nativeauth.statemachine.results.ResetPasswordSubmitCodeResult;
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

/* JADX INFO: compiled from: ResetPasswordStates.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003!\"#B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B'\b\u0000\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0011\u0010\u0014\u001a\u00020\u0015H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0014\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u001eJ\u0018\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0013H\u0016R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\t\u001a\u00020\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordCodeRequiredState;", "Lcom/microsoft/identity/nativeauth/statemachine/states/BaseState;", "Lcom/microsoft/identity/nativeauth/statemachine/states/State;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "continuationToken", "", "correlationId", "username", "config", "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;)V", "TAG", "getContinuationToken$msal_distRelease", "()Ljava/lang/String;", "getCorrelationId$msal_distRelease", "describeContents", "", "resendCode", "Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordResendCodeResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callback", "Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordCodeRequiredState$ResendCodeCallback;", "submitCode", "Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordSubmitCodeResult;", "code", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordCodeRequiredState$SubmitCodeCallback;", "writeToParcel", "flags", BoxTaskCollaborator.ROLE_CREATOR, "ResendCodeCallback", "SubmitCodeCallback", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ResetPasswordCodeRequiredState extends BaseState implements State, Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String TAG;
    private final NativeAuthPublicClientApplicationConfiguration config;
    private final String continuationToken;
    private final String correlationId;
    private final String username;

    /* JADX INFO: compiled from: ResetPasswordStates.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordCodeRequiredState$ResendCodeCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordResendCodeResult;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ResendCodeCallback extends Callback<ResetPasswordResendCodeResult> {
    }

    /* JADX INFO: compiled from: ResetPasswordStates.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordCodeRequiredState$SubmitCodeCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordSubmitCodeResult;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SubmitCodeCallback extends Callback<ResetPasswordSubmitCodeResult> {
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
    public ResetPasswordCodeRequiredState(String continuationToken, String correlationId, String username, NativeAuthPublicClientApplicationConfiguration config) {
        super(continuationToken, correlationId);
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(config, "config");
        this.continuationToken = continuationToken;
        this.correlationId = correlationId;
        this.username = username;
        this.config = config;
        Intrinsics.checkNotNullExpressionValue("ResetPasswordCodeRequiredState", "ResetPasswordCodeRequire…te::class.java.simpleName");
        this.TAG = "ResetPasswordCodeRequiredState";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ResetPasswordCodeRequiredState(Parcel parcel) {
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
        BuildersKt__Builders_commonKt.launch$default(NativeAuthPublicClientApplication.INSTANCE.getPcaScope(), null, null, new C18331(code, callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.ResetPasswordCodeRequiredState$submitCode$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ResetPasswordStates.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.ResetPasswordCodeRequiredState$submitCode$1", f = "ResetPasswordStates.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
    static final class C18331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SubmitCodeCallback $callback;
        final /* synthetic */ String $code;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18331(String str, SubmitCodeCallback submitCodeCallback, Continuation<? super C18331> continuation) {
            super(2, continuation);
            this.$code = str;
            this.$callback = submitCodeCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ResetPasswordCodeRequiredState.this.new C18331(this.$code, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18331) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = ResetPasswordCodeRequiredState.this.submitCode(this.$code, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((ResetPasswordSubmitCodeResult) obj);
            } catch (MsalException e) {
                Logger.error(ResetPasswordCodeRequiredState.this.TAG, "Exception thrown in submitCode", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }
    }

    public final Object submitCode(String str, Continuation<? super ResetPasswordSubmitCodeResult> continuation) {
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), this.TAG + ".submitCode(code: String)");
        return BuildersKt.withContext(Dispatchers.getIO(), new C18343(str, null), continuation);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.ResetPasswordCodeRequiredState$submitCode$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ResetPasswordStates.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordSubmitCodeResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.ResetPasswordCodeRequiredState$submitCode$3", f = "ResetPasswordStates.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C18343 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ResetPasswordSubmitCodeResult>, Object> {
        final /* synthetic */ String $code;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18343(String str, Continuation<? super C18343> continuation) {
            super(2, continuation);
            this.$code = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ResetPasswordCodeRequiredState.this.new C18343(this.$code, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ResetPasswordSubmitCodeResult> continuation) {
            return ((C18343) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                ResetPasswordSubmitCodeCommandParameters parameters = CommandParametersAdapter.createResetPasswordSubmitCodeCommandParameters(ResetPasswordCodeRequiredState.this.config, ResetPasswordCodeRequiredState.this.config.getOAuth2TokenCache(), this.$code, ResetPasswordCodeRequiredState.this.getCorrelationId(), ResetPasswordCodeRequiredState.this.getContinuationToken());
                Intrinsics.checkNotNullExpressionValue(parameters, "parameters");
                CommandResult rawCommandResult = CommandDispatcher.submitSilentReturningFuture(new ResetPasswordSubmitCodeCommand(parameters, new NativeAuthMsalController(), PublicApiId.NATIVE_AUTH_RESET_PASSWORD_SUBMIT_CODE)).get();
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
                                throw new NullPointerException("null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordSubmitCodeCommandResult");
                            }
                            aPIError = (ResetPasswordSubmitCodeCommandResult) result2;
                            aPIError2 = aPIError;
                        } catch (ClassCastException unused) {
                            String str4 = CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR;
                            String str5 = "Type casting error: result of " + rawCommandResult + " is not of type " + Reflection.getOrCreateKotlinClass(ResetPasswordSubmitCodeCommandResult.class) + ", but of type " + Reflection.getOrCreateKotlinClass(result2.getClass()) + ", even though the command was marked as COMPLETED";
                            String correlationId3 = rawCommandResult.getCorrelationId();
                            Intrinsics.checkNotNullExpressionValue(correlationId3, "this.correlationId");
                            aPIError = new INativeAuthCommandResult.APIError(str4, str5, null, correlationId3, null, null, 52, null);
                        }
                    }
                }
                ResetPasswordSubmitCodeCommandResult resetPasswordSubmitCodeCommandResult = (ResetPasswordSubmitCodeCommandResult) aPIError2;
                if (resetPasswordSubmitCodeCommandResult instanceof ResetPasswordCommandResult.PasswordRequired) {
                    return new ResetPasswordSubmitCodeResult.PasswordRequired(new ResetPasswordPasswordRequiredState(((ResetPasswordCommandResult.PasswordRequired) resetPasswordSubmitCodeCommandResult).getContinuationToken(), resetPasswordSubmitCodeCommandResult.getCorrelationId(), ResetPasswordCodeRequiredState.this.username, ResetPasswordCodeRequiredState.this.config));
                }
                if (resetPasswordSubmitCodeCommandResult instanceof ResetPasswordCommandResult.IncorrectCode) {
                    return new SubmitCodeError(ErrorTypes.INVALID_CODE, ((ResetPasswordCommandResult.IncorrectCode) resetPasswordSubmitCodeCommandResult).getError(), ((ResetPasswordCommandResult.IncorrectCode) resetPasswordSubmitCodeCommandResult).getErrorDescription(), resetPasswordSubmitCodeCommandResult.getCorrelationId(), null, ((ResetPasswordCommandResult.IncorrectCode) resetPasswordSubmitCodeCommandResult).getSubError(), null, 80, null);
                }
                if (resetPasswordSubmitCodeCommandResult instanceof INativeAuthCommandResult.Redirect) {
                    return new SubmitCodeError(ErrorTypes.BROWSER_REQUIRED, ((INativeAuthCommandResult.Redirect) resetPasswordSubmitCodeCommandResult).getError(), ((INativeAuthCommandResult.Redirect) resetPasswordSubmitCodeCommandResult).getRedirectReason(), resetPasswordSubmitCodeCommandResult.getCorrelationId(), null, null, null, 112, null);
                }
                if (!(resetPasswordSubmitCodeCommandResult instanceof INativeAuthCommandResult.APIError)) {
                    throw new NoWhenBranchMatchedException();
                }
                Logger.warnWithObject(ResetPasswordCodeRequiredState.this.TAG, resetPasswordSubmitCodeCommandResult.getCorrelationId(), "Submit code received unexpected result: ", resetPasswordSubmitCodeCommandResult);
                return new SubmitCodeError(null, ((INativeAuthCommandResult.APIError) resetPasswordSubmitCodeCommandResult).getError(), ((INativeAuthCommandResult.APIError) resetPasswordSubmitCodeCommandResult).getErrorDescription(), resetPasswordSubmitCodeCommandResult.getCorrelationId(), null, null, ((INativeAuthCommandResult.APIError) resetPasswordSubmitCodeCommandResult).getException(), 49, null);
            } catch (Exception e) {
                return new SubmitCodeError("client_exception", null, "MSAL client exception occurred in submitCode.", ResetPasswordCodeRequiredState.this.getCorrelationId(), null, null, e, 50, null);
            }
        }
    }

    public final void resendCode(ResendCodeCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), this.TAG + ".resendCode(callback: ResendCodeCallback)");
        BuildersKt__Builders_commonKt.launch$default(NativeAuthPublicClientApplication.INSTANCE.getPcaScope(), null, null, new AnonymousClass1(callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.ResetPasswordCodeRequiredState$resendCode$1, reason: invalid class name */
    /* JADX INFO: compiled from: ResetPasswordStates.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.ResetPasswordCodeRequiredState$resendCode$1", f = "ResetPasswordStates.kt", i = {}, l = {220}, m = "invokeSuspend", n = {}, s = {})
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
            return ResetPasswordCodeRequiredState.this.new AnonymousClass1(this.$callback, continuation);
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
                    obj = ResetPasswordCodeRequiredState.this.resendCode(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((ResetPasswordResendCodeResult) obj);
            } catch (MsalException e) {
                Logger.error(ResetPasswordCodeRequiredState.this.TAG, "Exception thrown in resendCode", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }
    }

    public final Object resendCode(Continuation<? super ResetPasswordResendCodeResult> continuation) {
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), this.TAG + ".resendCode");
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass3(null), continuation);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.ResetPasswordCodeRequiredState$resendCode$3, reason: invalid class name */
    /* JADX INFO: compiled from: ResetPasswordStates.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordResendCodeResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.ResetPasswordCodeRequiredState$resendCode$3", f = "ResetPasswordStates.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ResetPasswordResendCodeResult>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ResetPasswordCodeRequiredState.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ResetPasswordResendCodeResult> continuation) {
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
                ResetPasswordResendCodeCommandParameters parameters = CommandParametersAdapter.createResetPasswordResendCodeCommandParameters(ResetPasswordCodeRequiredState.this.config, ResetPasswordCodeRequiredState.this.config.getOAuth2TokenCache(), ResetPasswordCodeRequiredState.this.getCorrelationId(), ResetPasswordCodeRequiredState.this.getContinuationToken());
                Intrinsics.checkNotNullExpressionValue(parameters, "parameters");
                CommandResult rawCommandResult = CommandDispatcher.submitSilentReturningFuture(new ResetPasswordResendCodeCommand(parameters, new NativeAuthMsalController(), PublicApiId.NATIVE_AUTH_RESET_PASSWORD_RESEND_CODE)).get();
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
                                throw new NullPointerException("null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordResendCodeCommandResult");
                            }
                            aPIError = (ResetPasswordResendCodeCommandResult) result2;
                            aPIError2 = aPIError;
                        } catch (ClassCastException unused) {
                            String str4 = CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR;
                            String str5 = "Type casting error: result of " + rawCommandResult + " is not of type " + Reflection.getOrCreateKotlinClass(ResetPasswordResendCodeCommandResult.class) + ", but of type " + Reflection.getOrCreateKotlinClass(result2.getClass()) + ", even though the command was marked as COMPLETED";
                            String correlationId3 = rawCommandResult.getCorrelationId();
                            Intrinsics.checkNotNullExpressionValue(correlationId3, "this.correlationId");
                            aPIError = new INativeAuthCommandResult.APIError(str4, str5, null, correlationId3, null, null, 52, null);
                        }
                    }
                }
                ResetPasswordResendCodeCommandResult resetPasswordResendCodeCommandResult = (ResetPasswordResendCodeCommandResult) aPIError2;
                if (resetPasswordResendCodeCommandResult instanceof ResetPasswordCommandResult.CodeRequired) {
                    return new ResetPasswordResendCodeResult.Success(new ResetPasswordCodeRequiredState(((ResetPasswordCommandResult.CodeRequired) resetPasswordResendCodeCommandResult).getContinuationToken(), resetPasswordResendCodeCommandResult.getCorrelationId(), ResetPasswordCodeRequiredState.this.username, ResetPasswordCodeRequiredState.this.config), ((ResetPasswordCommandResult.CodeRequired) resetPasswordResendCodeCommandResult).getCodeLength(), ((ResetPasswordCommandResult.CodeRequired) resetPasswordResendCodeCommandResult).getChallengeTargetLabel(), ((ResetPasswordCommandResult.CodeRequired) resetPasswordResendCodeCommandResult).getChallengeChannel());
                }
                if (resetPasswordResendCodeCommandResult instanceof INativeAuthCommandResult.Redirect) {
                    return new ResendCodeError(ErrorTypes.BROWSER_REQUIRED, ((INativeAuthCommandResult.Redirect) resetPasswordResendCodeCommandResult).getError(), ((INativeAuthCommandResult.Redirect) resetPasswordResendCodeCommandResult).getRedirectReason(), resetPasswordResendCodeCommandResult.getCorrelationId(), ((INativeAuthCommandResult.Redirect) resetPasswordResendCodeCommandResult).getErrorCodes(), null, 32, null);
                }
                if (!(resetPasswordResendCodeCommandResult instanceof INativeAuthCommandResult.APIError)) {
                    throw new NoWhenBranchMatchedException();
                }
                Logger.warnWithObject(ResetPasswordCodeRequiredState.this.TAG, resetPasswordResendCodeCommandResult.getCorrelationId(), "Resend code received unexpected result: ", resetPasswordResendCodeCommandResult);
                return new ResendCodeError(null, ((INativeAuthCommandResult.Error) resetPasswordResendCodeCommandResult).getError(), ((INativeAuthCommandResult.Error) resetPasswordResendCodeCommandResult).getErrorDescription(), ((INativeAuthCommandResult.Error) resetPasswordResendCodeCommandResult).getCorrelationId(), ((INativeAuthCommandResult.Error) resetPasswordResendCodeCommandResult).getErrorCodes(), resetPasswordResendCodeCommandResult instanceof INativeAuthCommandResult.APIError ? ((INativeAuthCommandResult.APIError) resetPasswordResendCodeCommandResult).getException() : null, 1, null);
            } catch (Exception e) {
                return new ResendCodeError("client_exception", null, "MSAL client exception occurred in resendCode.", ResetPasswordCodeRequiredState.this.getCorrelationId(), null, e, 18, null);
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

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.ResetPasswordCodeRequiredState$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: ResetPasswordStates.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordCodeRequiredState$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordCodeRequiredState;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordCodeRequiredState;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion implements Parcelable.Creator<ResetPasswordCodeRequiredState> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ResetPasswordCodeRequiredState createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ResetPasswordCodeRequiredState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ResetPasswordCodeRequiredState[] newArray(int size) {
            return new ResetPasswordCodeRequiredState[size];
        }
    }
}
