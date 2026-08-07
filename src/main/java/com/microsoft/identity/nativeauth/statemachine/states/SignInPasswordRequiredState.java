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
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInSubmitPasswordCommandParameters;
import com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInSubmitPasswordCommandResult;
import com.microsoft.identity.common.java.nativeauth.util.CommandResultUtilKt;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.nativeauth.internal.commands.SignInSubmitPasswordCommand;
import com.microsoft.identity.common.nativeauth.internal.controllers.NativeAuthMsalController;
import com.microsoft.identity.nativeauth.AuthMethodKt;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration;
import com.microsoft.identity.nativeauth.statemachine.errors.ErrorTypes;
import com.microsoft.identity.nativeauth.statemachine.errors.SignInErrorTypes;
import com.microsoft.identity.nativeauth.statemachine.errors.SignInSubmitPasswordError;
import com.microsoft.identity.nativeauth.statemachine.results.SignInResult;
import com.microsoft.identity.nativeauth.statemachine.results.SignInSubmitPasswordResult;
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
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002!\"B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B?\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u0017\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0018\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0016H\u0016R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\t\u001a\u00020\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/SignInPasswordRequiredState;", "Lcom/microsoft/identity/nativeauth/statemachine/states/BaseState;", "Lcom/microsoft/identity/nativeauth/statemachine/states/State;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "continuationToken", "", "correlationId", "username", "scopes", "", "claimsRequestJson", "config", "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;)V", "TAG", "getContinuationToken$msal_distRelease", "()Ljava/lang/String;", "getCorrelationId$msal_distRelease", "describeContents", "", "submitPassword", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInSubmitPasswordResult;", "password", "", "([CLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callback", "Lcom/microsoft/identity/nativeauth/statemachine/states/SignInPasswordRequiredState$SubmitPasswordCallback;", "writeToParcel", "flags", BoxTaskCollaborator.ROLE_CREATOR, "SubmitPasswordCallback", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SignInPasswordRequiredState extends BaseState implements State, Parcelable {

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
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/SignInPasswordRequiredState$SubmitPasswordCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInSubmitPasswordResult;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SubmitPasswordCallback extends Callback<SignInSubmitPasswordResult> {
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
    public SignInPasswordRequiredState(String continuationToken, String correlationId, String username, List<String> list, String str, NativeAuthPublicClientApplicationConfiguration config) {
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
        Intrinsics.checkNotNullExpressionValue("SignInPasswordRequiredState", "SignInPasswordRequiredState::class.java.simpleName");
        this.TAG = "SignInPasswordRequiredState";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SignInPasswordRequiredState(Parcel parcel) {
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

    public final void submitPassword(char[] password, SubmitPasswordCallback callback) {
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), this.TAG + ".submitPassword(password: CharArray, callback: SubmitPasswordCallback)");
        BuildersKt__Builders_commonKt.launch$default(NativeAuthPublicClientApplication.INSTANCE.getPcaScope(), null, null, new AnonymousClass1(password, callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignInPasswordRequiredState$submitPassword$1, reason: invalid class name */
    /* JADX INFO: compiled from: SignInStates.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.SignInPasswordRequiredState$submitPassword$1", f = "SignInStates.kt", i = {}, l = {420}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SubmitPasswordCallback $callback;
        final /* synthetic */ char[] $password;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(char[] cArr, SubmitPasswordCallback submitPasswordCallback, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$password = cArr;
            this.$callback = submitPasswordCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SignInPasswordRequiredState.this.new AnonymousClass1(this.$password, this.$callback, continuation);
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
                    obj = SignInPasswordRequiredState.this.submitPassword(this.$password, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((SignInSubmitPasswordResult) obj);
            } catch (MsalException e) {
                Logger.error(SignInPasswordRequiredState.this.TAG, "Exception thrown in submitPassword", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }
    }

    public final Object submitPassword(char[] cArr, Continuation<? super SignInSubmitPasswordResult> continuation) {
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), this.TAG + ".submitPassword(password: CharArray)");
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass3(cArr, null), continuation);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignInPasswordRequiredState$submitPassword$3, reason: invalid class name */
    /* JADX INFO: compiled from: SignInStates.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInSubmitPasswordResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.SignInPasswordRequiredState$submitPassword$3", f = "SignInStates.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SignInSubmitPasswordResult>, Object> {
        final /* synthetic */ char[] $password;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(char[] cArr, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$password = cArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SignInPasswordRequiredState.this.new AnonymousClass3(this.$password, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SignInSubmitPasswordResult> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            INativeAuthCommandResult.APIError aPIError;
            INativeAuthCommandResult.APIError aPIError2;
            SignInSubmitPasswordError signInSubmitPasswordError;
            String message;
            Exception exc;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                SignInSubmitPasswordCommandParameters params = CommandParametersAdapter.createSignInSubmitPasswordCommandParameters(SignInPasswordRequiredState.this.config, SignInPasswordRequiredState.this.config.getOAuth2TokenCache(), SignInPasswordRequiredState.this.getContinuationToken(), this.$password, SignInPasswordRequiredState.this.getCorrelationId(), SignInPasswordRequiredState.this.scopes, SignInPasswordRequiredState.this.claimsRequestJson);
                try {
                    Intrinsics.checkNotNullExpressionValue(params, "params");
                    CommandResult rawCommandResult = CommandDispatcher.submitSilentReturningFuture(new SignInSubmitPasswordCommand(params, new NativeAuthMsalController(), PublicApiId.NATIVE_AUTH_SIGN_IN_SUBMIT_PASSWORD)).get();
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
                                    throw new NullPointerException("null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.SignInSubmitPasswordCommandResult");
                                }
                                aPIError = (SignInSubmitPasswordCommandResult) result2;
                                aPIError2 = aPIError;
                            } catch (ClassCastException unused) {
                                String str2 = "Type casting error: result of " + rawCommandResult + " is not of type " + Reflection.getOrCreateKotlinClass(SignInSubmitPasswordCommandResult.class) + ", but of type " + Reflection.getOrCreateKotlinClass(result2.getClass()) + ", even though the command was marked as COMPLETED";
                                String correlationId3 = rawCommandResult.getCorrelationId();
                                Intrinsics.checkNotNullExpressionValue(correlationId3, "this.correlationId");
                                aPIError = new INativeAuthCommandResult.APIError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, str2, null, correlationId3, null, null, 52, null);
                            }
                        }
                    }
                    SignInSubmitPasswordCommandResult signInSubmitPasswordCommandResult = (SignInSubmitPasswordCommandResult) aPIError2;
                    if (signInSubmitPasswordCommandResult instanceof SignInCommandResult.InvalidCredentials) {
                        signInSubmitPasswordError = new SignInSubmitPasswordError(SignInErrorTypes.INVALID_CREDENTIALS, ((SignInCommandResult.InvalidCredentials) signInSubmitPasswordCommandResult).getError(), ((SignInCommandResult.InvalidCredentials) signInSubmitPasswordCommandResult).getErrorDescription(), signInSubmitPasswordCommandResult.getCorrelationId(), null, null, 48, null);
                    } else if (signInSubmitPasswordCommandResult instanceof SignInCommandResult.MFARequired) {
                        signInSubmitPasswordError = new SignInResult.MFARequired(new AwaitingMFAState(((SignInCommandResult.MFARequired) signInSubmitPasswordCommandResult).getContinuationToken(), signInSubmitPasswordCommandResult.getCorrelationId(), SignInPasswordRequiredState.this.scopes, SignInPasswordRequiredState.this.config), AuthMethodKt.toListOfAuthMethods(((SignInCommandResult.MFARequired) signInSubmitPasswordCommandResult).getAuthMethods()));
                    } else if (signInSubmitPasswordCommandResult instanceof SignInCommandResult.StrongAuthMethodRegistrationRequired) {
                        signInSubmitPasswordError = new SignInResult.StrongAuthMethodRegistrationRequired(new RegisterStrongAuthState(((SignInCommandResult.StrongAuthMethodRegistrationRequired) signInSubmitPasswordCommandResult).getContinuationToken(), signInSubmitPasswordCommandResult.getCorrelationId(), SignInPasswordRequiredState.this.config), AuthMethodKt.toListOfAuthMethods(((SignInCommandResult.StrongAuthMethodRegistrationRequired) signInSubmitPasswordCommandResult).getAuthMethods()));
                    } else if (signInSubmitPasswordCommandResult instanceof SignInCommandResult.Complete) {
                        IAuthenticationResult authenticationResult = AuthenticationResultAdapter.adapt(((SignInCommandResult.Complete) signInSubmitPasswordCommandResult).getAuthenticationResult());
                        AccountState.Companion companion = AccountState.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(authenticationResult, "authenticationResult");
                        signInSubmitPasswordError = new SignInResult.Complete(companion.createFromAuthenticationResult(authenticationResult, signInSubmitPasswordCommandResult.getCorrelationId(), SignInPasswordRequiredState.this.config));
                    } else if (signInSubmitPasswordCommandResult instanceof INativeAuthCommandResult.Redirect) {
                        signInSubmitPasswordError = new SignInSubmitPasswordError(ErrorTypes.BROWSER_REQUIRED, ((INativeAuthCommandResult.Redirect) signInSubmitPasswordCommandResult).getError(), ((INativeAuthCommandResult.Redirect) signInSubmitPasswordCommandResult).getRedirectReason(), signInSubmitPasswordCommandResult.getCorrelationId(), ((INativeAuthCommandResult.Redirect) signInSubmitPasswordCommandResult).getErrorCodes(), null, 32, null);
                    } else if (signInSubmitPasswordCommandResult instanceof INativeAuthCommandResult.APIError) {
                        Logger.warnWithObject(SignInPasswordRequiredState.this.TAG, signInSubmitPasswordCommandResult.getCorrelationId(), "Submit password received unexpected result: ", signInSubmitPasswordCommandResult);
                        signInSubmitPasswordError = new SignInSubmitPasswordError(null, ((INativeAuthCommandResult.Error) signInSubmitPasswordCommandResult).getError(), ((INativeAuthCommandResult.Error) signInSubmitPasswordCommandResult).getErrorDescription(), ((INativeAuthCommandResult.Error) signInSubmitPasswordCommandResult).getCorrelationId(), ((INativeAuthCommandResult.Error) signInSubmitPasswordCommandResult).getErrorCodes(), ((INativeAuthCommandResult.APIError) signInSubmitPasswordCommandResult).getException(), 1, null);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    StringUtil.overwriteWithNull(params.password);
                    return signInSubmitPasswordError;
                } catch (Throwable th) {
                    StringUtil.overwriteWithNull(params.password);
                    throw th;
                }
            } catch (Exception e) {
                return new SignInSubmitPasswordError("client_exception", null, "MSAL client exception occurred in submitPassword.", SignInPasswordRequiredState.this.getCorrelationId(), null, e, 18, null);
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
        parcel.writeString(this.claimsRequestJson);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignInPasswordRequiredState$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: SignInStates.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/SignInPasswordRequiredState$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/microsoft/identity/nativeauth/statemachine/states/SignInPasswordRequiredState;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/microsoft/identity/nativeauth/statemachine/states/SignInPasswordRequiredState;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion implements Parcelable.Creator<SignInPasswordRequiredState> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SignInPasswordRequiredState createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SignInPasswordRequiredState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SignInPasswordRequiredState[] newArray(int size) {
            return new SignInPasswordRequiredState[size];
        }
    }
}
