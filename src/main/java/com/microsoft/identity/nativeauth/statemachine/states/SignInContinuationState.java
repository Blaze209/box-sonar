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
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInWithContinuationTokenCommandParameters;
import com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInWithContinuationTokenCommandResult;
import com.microsoft.identity.common.java.nativeauth.util.CommandResultUtilKt;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.nativeauth.internal.commands.SignInWithContinuationTokenCommand;
import com.microsoft.identity.common.nativeauth.internal.controllers.NativeAuthMsalController;
import com.microsoft.identity.nativeauth.AuthMethodKt;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration;
import com.microsoft.identity.nativeauth.parameters.NativeAuthSignInContinuationParameters;
import com.microsoft.identity.nativeauth.statemachine.errors.ErrorTypes;
import com.microsoft.identity.nativeauth.statemachine.errors.SignInContinuationError;
import com.microsoft.identity.nativeauth.statemachine.results.SignInResult;
import java.io.Serializable;
import java.util.List;
import kotlin.Deprecated;
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
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 $2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002$%B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B'\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u001b\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0019J\u001d\u0010\u001a\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0007¢\u0006\u0002\b\u001bJ#\u0010\u001a\u001a\u00020\u00162\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010 H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010!J\"\u0010\u001a\u001a\u00020\u001c2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010 2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0018\u0010\"\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0014H\u0016R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\t\u001a\u00020\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0014\u0010\n\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/SignInContinuationState;", "Lcom/microsoft/identity/nativeauth/statemachine/states/BaseState;", "Lcom/microsoft/identity/nativeauth/statemachine/states/State;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "continuationToken", "", "correlationId", "username", "config", "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;)V", "TAG", "getContinuationToken$msal_distRelease", "()Ljava/lang/String;", "getCorrelationId$msal_distRelease", "getUsername$msal_distRelease", "describeContents", "", "internalSignIn", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResult;", "parameters", "Lcom/microsoft/identity/nativeauth/parameters/NativeAuthSignInContinuationParameters;", "(Lcom/microsoft/identity/nativeauth/parameters/NativeAuthSignInContinuationParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signIn", "signInWithParameters", "", "callback", "Lcom/microsoft/identity/nativeauth/statemachine/states/SignInContinuationState$SignInContinuationCallback;", "scopes", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeToParcel", "flags", BoxTaskCollaborator.ROLE_CREATOR, "SignInContinuationCallback", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SignInContinuationState extends BaseState implements State, Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String TAG;
    private final NativeAuthPublicClientApplicationConfiguration config;
    private final String continuationToken;
    private final String correlationId;
    private final String username;

    /* JADX INFO: compiled from: SignInStates.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/SignInContinuationState$SignInContinuationCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResult;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SignInContinuationCallback extends Callback<SignInResult> {
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

    /* JADX INFO: renamed from: getUsername$msal_distRelease, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignInContinuationState(String str, String correlationId, String username, NativeAuthPublicClientApplicationConfiguration config) {
        super(str, correlationId);
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(config, "config");
        this.continuationToken = str;
        this.correlationId = correlationId;
        this.username = username;
        this.config = config;
        Intrinsics.checkNotNullExpressionValue("SignInContinuationState", "SignInContinuationState::class.java.simpleName");
        this.TAG = "SignInContinuationState";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SignInContinuationState(Parcel parcel) {
        NativeAuthPublicClientApplicationConfiguration nativeAuthPublicClientApplicationConfiguration;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String string = parcel.readString();
        String string2 = parcel.readString();
        string2 = string2 == null ? TelemetryEventStrings.Value.UNSET : string2;
        String string3 = parcel.readString();
        string3 = string3 == null ? "" : string3;
        if (Build.VERSION.SDK_INT >= 33) {
            nativeAuthPublicClientApplicationConfiguration = (Serializable) parcel.readSerializable(NativeAuthPublicClientApplicationConfiguration.class.getClassLoader(), NativeAuthPublicClientApplicationConfiguration.class);
        } else {
            Serializable serializable = parcel.readSerializable();
            nativeAuthPublicClientApplicationConfiguration = (NativeAuthPublicClientApplicationConfiguration) (serializable instanceof NativeAuthPublicClientApplicationConfiguration ? serializable : null);
        }
        Intrinsics.checkNotNull(nativeAuthPublicClientApplicationConfiguration, "null cannot be cast to non-null type com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration");
        this(string, string2, string3, (NativeAuthPublicClientApplicationConfiguration) nativeAuthPublicClientApplicationConfiguration);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void signIn$default(SignInContinuationState signInContinuationState, List list, SignInContinuationCallback signInContinuationCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        signInContinuationState.signIn((List<String>) list, signInContinuationCallback);
    }

    @Deprecated(message = "This method is now deprecated. Use the method 'signIn(parameters:, callback:)' instead.")
    public final void signIn(List<String> scopes, SignInContinuationCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), this.TAG + ".signIn(scopes: List<String>, callback: SignInContinuationCallback)");
        NativeAuthSignInContinuationParameters nativeAuthSignInContinuationParameters = new NativeAuthSignInContinuationParameters();
        nativeAuthSignInContinuationParameters.setScopes(scopes);
        BuildersKt__Builders_commonKt.launch$default(NativeAuthPublicClientApplication.INSTANCE.getPcaScope(), null, null, new AnonymousClass1(nativeAuthSignInContinuationParameters, callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignInContinuationState$signIn$1, reason: invalid class name */
    /* JADX INFO: compiled from: SignInStates.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.SignInContinuationState$signIn$1", f = "SignInStates.kt", i = {}, l = {617}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SignInContinuationCallback $callback;
        final /* synthetic */ NativeAuthSignInContinuationParameters $params;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(NativeAuthSignInContinuationParameters nativeAuthSignInContinuationParameters, SignInContinuationCallback signInContinuationCallback, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$params = nativeAuthSignInContinuationParameters;
            this.$callback = signInContinuationCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SignInContinuationState.this.new AnonymousClass1(this.$params, this.$callback, continuation);
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
                    obj = SignInContinuationState.this.internalSignIn(this.$params, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((SignInResult) obj);
            } catch (MsalException e) {
                Logger.error(SignInContinuationState.this.TAG, "Exception thrown in signIn", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }
    }

    public final void signInWithParameters(NativeAuthSignInContinuationParameters parameters, SignInContinuationCallback callback) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), this.TAG + ".signIn(parameters: NativeAuthSignInContinuationParameters, callback: SignInContinuationCallback)");
        BuildersKt__Builders_commonKt.launch$default(NativeAuthPublicClientApplication.INSTANCE.getPcaScope(), null, null, new C18372(parameters, callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignInContinuationState$signIn$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SignInStates.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.SignInContinuationState$signIn$2", f = "SignInStates.kt", i = {}, l = {642}, m = "invokeSuspend", n = {}, s = {})
    static final class C18372 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SignInContinuationCallback $callback;
        final /* synthetic */ NativeAuthSignInContinuationParameters $parameters;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18372(NativeAuthSignInContinuationParameters nativeAuthSignInContinuationParameters, SignInContinuationCallback signInContinuationCallback, Continuation<? super C18372> continuation) {
            super(2, continuation);
            this.$parameters = nativeAuthSignInContinuationParameters;
            this.$callback = signInContinuationCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SignInContinuationState.this.new C18372(this.$parameters, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18372) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = SignInContinuationState.this.internalSignIn(this.$parameters, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((SignInResult) obj);
            } catch (MsalException e) {
                Logger.error(SignInContinuationState.this.TAG, "Exception thrown in signIn", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object signIn$default(SignInContinuationState signInContinuationState, List list, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        return signInContinuationState.signIn((List<String>) list, (Continuation<? super SignInResult>) continuation);
    }

    @Deprecated(message = "This method is now deprecated. Use the method 'signIn(parameters:)' instead.")
    public final Object signIn(List<String> list, Continuation<? super SignInResult> continuation) {
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), this.TAG + ".signIn(scopes: List<String>)");
        NativeAuthSignInContinuationParameters nativeAuthSignInContinuationParameters = new NativeAuthSignInContinuationParameters();
        nativeAuthSignInContinuationParameters.setScopes(list);
        return internalSignIn(nativeAuthSignInContinuationParameters, continuation);
    }

    public final Object signInWithParameters(NativeAuthSignInContinuationParameters nativeAuthSignInContinuationParameters, Continuation<? super SignInResult> continuation) {
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), this.TAG + ".signIn(parameters: NativeAuthSignInContinuationParameters)");
        return internalSignIn(nativeAuthSignInContinuationParameters, continuation);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignInContinuationState$internalSignIn$2, reason: invalid class name */
    /* JADX INFO: compiled from: SignInStates.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.SignInContinuationState$internalSignIn$2", f = "SignInStates.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SignInResult>, Object> {
        final /* synthetic */ NativeAuthSignInContinuationParameters $parameters;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(NativeAuthSignInContinuationParameters nativeAuthSignInContinuationParameters, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$parameters = nativeAuthSignInContinuationParameters;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SignInContinuationState.this.new AnonymousClass2(this.$parameters, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SignInResult> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                LogSession.INSTANCE.logMethodCall(SignInContinuationState.this.TAG, SignInContinuationState.this.getCorrelationId(), SignInContinuationState.this.TAG + ".signIn(scopes: List<String>)");
                String continuationToken = SignInContinuationState.this.getContinuationToken();
                if (continuationToken != null && continuationToken.length() != 0) {
                    SignInWithContinuationTokenCommandParameters commandParameters = CommandParametersAdapter.createSignInWithContinuationTokenCommandParameters(SignInContinuationState.this.config, SignInContinuationState.this.config.getOAuth2TokenCache(), SignInContinuationState.this.getContinuationToken(), SignInContinuationState.this.getUsername(), SignInContinuationState.this.getCorrelationId(), this.$parameters.getScopes(), this.$parameters.getClaimsRequest());
                    Intrinsics.checkNotNullExpressionValue(commandParameters, "commandParameters");
                    CommandResult rawCommandResult = CommandDispatcher.submitSilentReturningFuture(new SignInWithContinuationTokenCommand(commandParameters, new NativeAuthMsalController(), PublicApiId.NATIVE_AUTH_SIGN_IN_WITH_SLT)).get();
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
                                    throw new NullPointerException("null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.SignInWithContinuationTokenCommandResult");
                                }
                                aPIError = (SignInWithContinuationTokenCommandResult) result2;
                                aPIError2 = aPIError;
                            } catch (ClassCastException unused) {
                                String str4 = CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR;
                                String str5 = "Type casting error: result of " + rawCommandResult + " is not of type " + Reflection.getOrCreateKotlinClass(SignInWithContinuationTokenCommandResult.class) + ", but of type " + Reflection.getOrCreateKotlinClass(result2.getClass()) + ", even though the command was marked as COMPLETED";
                                String correlationId3 = rawCommandResult.getCorrelationId();
                                Intrinsics.checkNotNullExpressionValue(correlationId3, "this.correlationId");
                                aPIError = new INativeAuthCommandResult.APIError(str4, str5, null, correlationId3, null, null, 52, null);
                            }
                        }
                    }
                    SignInWithContinuationTokenCommandResult signInWithContinuationTokenCommandResult = (SignInWithContinuationTokenCommandResult) aPIError2;
                    if (signInWithContinuationTokenCommandResult instanceof SignInCommandResult.Complete) {
                        IAuthenticationResult authenticationResult = AuthenticationResultAdapter.adapt(((SignInCommandResult.Complete) signInWithContinuationTokenCommandResult).getAuthenticationResult());
                        AccountState.Companion creator = AccountState.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(authenticationResult, "authenticationResult");
                        return new SignInResult.Complete(creator.createFromAuthenticationResult(authenticationResult, signInWithContinuationTokenCommandResult.getCorrelationId(), SignInContinuationState.this.config));
                    }
                    if (signInWithContinuationTokenCommandResult instanceof SignInCommandResult.StrongAuthMethodRegistrationRequired) {
                        return new SignInResult.StrongAuthMethodRegistrationRequired(new RegisterStrongAuthState(((SignInCommandResult.StrongAuthMethodRegistrationRequired) signInWithContinuationTokenCommandResult).getContinuationToken(), signInWithContinuationTokenCommandResult.getCorrelationId(), SignInContinuationState.this.config), AuthMethodKt.toListOfAuthMethods(((SignInCommandResult.StrongAuthMethodRegistrationRequired) signInWithContinuationTokenCommandResult).getAuthMethods()));
                    }
                    if (signInWithContinuationTokenCommandResult instanceof SignInCommandResult.MFARequired) {
                        return new SignInResult.MFARequired(new AwaitingMFAState(((SignInCommandResult.MFARequired) signInWithContinuationTokenCommandResult).getContinuationToken(), signInWithContinuationTokenCommandResult.getCorrelationId(), this.$parameters.getScopes(), SignInContinuationState.this.config), AuthMethodKt.toListOfAuthMethods(((SignInCommandResult.MFARequired) signInWithContinuationTokenCommandResult).getAuthMethods()));
                    }
                    if (signInWithContinuationTokenCommandResult instanceof INativeAuthCommandResult.Redirect) {
                        return new SignInContinuationError(ErrorTypes.BROWSER_REQUIRED, ((INativeAuthCommandResult.Redirect) signInWithContinuationTokenCommandResult).getError(), ((INativeAuthCommandResult.Redirect) signInWithContinuationTokenCommandResult).getRedirectReason(), signInWithContinuationTokenCommandResult.getCorrelationId(), ((INativeAuthCommandResult.Redirect) signInWithContinuationTokenCommandResult).getErrorCodes(), null, 32, null);
                    }
                    if (!(signInWithContinuationTokenCommandResult instanceof INativeAuthCommandResult.APIError)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Logger.warnWithObject(SignInContinuationState.this.TAG, signInWithContinuationTokenCommandResult.getCorrelationId(), "Sign in after sign up received unexpected result: ", signInWithContinuationTokenCommandResult);
                    return new SignInContinuationError(null, ((INativeAuthCommandResult.Error) signInWithContinuationTokenCommandResult).getError(), ((INativeAuthCommandResult.Error) signInWithContinuationTokenCommandResult).getErrorDescription(), ((INativeAuthCommandResult.Error) signInWithContinuationTokenCommandResult).getCorrelationId(), ((INativeAuthCommandResult.Error) signInWithContinuationTokenCommandResult).getErrorCodes(), ((INativeAuthCommandResult.APIError) signInWithContinuationTokenCommandResult).getException(), 1, null);
                }
                Logger.warn(SignInContinuationState.this.TAG, "Sign in after sign up received unexpected result: continuationToken was null");
                return new SignInContinuationError(null, ErrorTypes.INVALID_STATE, "Sign In is not available through this state, please use the standalone sign in method.", TelemetryEventStrings.Value.UNSET, null, null, 49, null);
            } catch (Exception e) {
                return new SignInContinuationError(null, null, "MSAL client exception occurred in signIn.", SignInContinuationState.this.getCorrelationId(), null, e, 19, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object internalSignIn(NativeAuthSignInContinuationParameters nativeAuthSignInContinuationParameters, Continuation<? super SignInResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(nativeAuthSignInContinuationParameters, null), continuation);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(getContinuationToken());
        parcel.writeString(getCorrelationId());
        parcel.writeString(this.username);
        parcel.writeSerializable(this.config);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignInContinuationState$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: SignInStates.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/SignInContinuationState$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/microsoft/identity/nativeauth/statemachine/states/SignInContinuationState;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/microsoft/identity/nativeauth/statemachine/states/SignInContinuationState;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion implements Parcelable.Creator<SignInContinuationState> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SignInContinuationState createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SignInContinuationState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SignInContinuationState[] newArray(int size) {
            return new SignInContinuationState[size];
        }
    }
}
