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
import com.microsoft.identity.common.java.nativeauth.commands.parameters.MFAChallengeAuthMethodCommandParameters;
import com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.MFAChallengeCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.MFACommandResult;
import com.microsoft.identity.common.java.nativeauth.util.CommandResultUtilKt;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.nativeauth.internal.commands.MFAChallengeCommand;
import com.microsoft.identity.common.nativeauth.internal.controllers.NativeAuthMsalController;
import com.microsoft.identity.nativeauth.AuthMethod;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration;
import com.microsoft.identity.nativeauth.statemachine.errors.ErrorTypes;
import com.microsoft.identity.nativeauth.statemachine.errors.MFARequestChallengeError;
import com.microsoft.identity.nativeauth.statemachine.results.MFARequiredResult;
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

/* JADX INFO: compiled from: MFAStates.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u001f B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B-\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0016\u0010\u0015\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cJ\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0014H\u0016R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\t\u001a\u00020\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/AwaitingMFAState;", "Lcom/microsoft/identity/nativeauth/statemachine/states/BaseState;", "Lcom/microsoft/identity/nativeauth/statemachine/states/State;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "continuationToken", "", "correlationId", "scopes", "", "config", "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;)V", "TAG", "getContinuationToken$msal_distRelease", "()Ljava/lang/String;", "getCorrelationId$msal_distRelease", "describeContents", "", "requestChallenge", "Lcom/microsoft/identity/nativeauth/statemachine/results/MFARequiredResult;", "authMethod", "Lcom/microsoft/identity/nativeauth/AuthMethod;", "(Lcom/microsoft/identity/nativeauth/AuthMethod;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callback", "Lcom/microsoft/identity/nativeauth/statemachine/states/AwaitingMFAState$RequestChallengeCallback;", "writeToParcel", "flags", BoxTaskCollaborator.ROLE_CREATOR, "RequestChallengeCallback", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AwaitingMFAState extends BaseState implements State, Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String TAG;
    private final NativeAuthPublicClientApplicationConfiguration config;
    private final String continuationToken;
    private final String correlationId;
    private final List<String> scopes;

    /* JADX INFO: compiled from: MFAStates.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/AwaitingMFAState$RequestChallengeCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/MFARequiredResult;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface RequestChallengeCallback extends Callback<MFARequiredResult> {
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
    public AwaitingMFAState(String continuationToken, String correlationId, List<String> list, NativeAuthPublicClientApplicationConfiguration config) {
        super(continuationToken, correlationId);
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        Intrinsics.checkNotNullParameter(config, "config");
        this.continuationToken = continuationToken;
        this.correlationId = correlationId;
        this.scopes = list;
        this.config = config;
        Intrinsics.checkNotNullExpressionValue("AwaitingMFAState", "AwaitingMFAState::class.java.simpleName");
        this.TAG = "AwaitingMFAState";
    }

    public final void requestChallenge(AuthMethod authMethod, RequestChallengeCallback callback) {
        Intrinsics.checkNotNullParameter(authMethod, "authMethod");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), this.TAG + ".requestChallenge(authMethod: AuthMethod, callback: RequestChallengeCallback)");
        BuildersKt__Builders_commonKt.launch$default(NativeAuthPublicClientApplication.INSTANCE.getPcaScope(), null, null, new AnonymousClass1(authMethod, callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.AwaitingMFAState$requestChallenge$1, reason: invalid class name */
    /* JADX INFO: compiled from: MFAStates.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.AwaitingMFAState$requestChallenge$1", f = "MFAStates.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AuthMethod $authMethod;
        final /* synthetic */ RequestChallengeCallback $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AuthMethod authMethod, RequestChallengeCallback requestChallengeCallback, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$authMethod = authMethod;
            this.$callback = requestChallengeCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AwaitingMFAState.this.new AnonymousClass1(this.$authMethod, this.$callback, continuation);
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
                    obj = AwaitingMFAState.this.requestChallenge(this.$authMethod, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((MFARequiredResult) obj);
            } catch (MsalException e) {
                Logger.error(AwaitingMFAState.this.TAG, "Exception thrown in requestChallenge", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }
    }

    public final Object requestChallenge(AuthMethod authMethod, Continuation<? super MFARequiredResult> continuation) {
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), this.TAG + ".requestChallenge(authMethod: AuthMethod)");
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass3(authMethod, null), continuation);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.AwaitingMFAState$requestChallenge$3, reason: invalid class name */
    /* JADX INFO: compiled from: MFAStates.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/MFARequiredResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.AwaitingMFAState$requestChallenge$3", f = "MFAStates.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MFARequiredResult>, Object> {
        final /* synthetic */ AuthMethod $authMethod;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(AuthMethod authMethod, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$authMethod = authMethod;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AwaitingMFAState.this.new AnonymousClass3(this.$authMethod, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super MFARequiredResult> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                MFAChallengeAuthMethodCommandParameters params = CommandParametersAdapter.createMFAChallengeAuthMethodCommandParameters(AwaitingMFAState.this.config, AwaitingMFAState.this.config.getOAuth2TokenCache(), AwaitingMFAState.this.getContinuationToken(), AwaitingMFAState.this.getCorrelationId(), this.$authMethod);
                Intrinsics.checkNotNullExpressionValue(params, "params");
                CommandResult rawCommandResult = CommandDispatcher.submitSilentReturningFuture(new MFAChallengeCommand(params, new NativeAuthMsalController(), PublicApiId.NATIVE_AUTH_MFA_SELECTED_CHALLENGE)).get();
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
                                throw new NullPointerException("null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.MFAChallengeCommandResult");
                            }
                            aPIError = (MFAChallengeCommandResult) result2;
                            aPIError2 = aPIError;
                        } catch (ClassCastException unused) {
                            String str2 = "Type casting error: result of " + rawCommandResult + " is not of type " + Reflection.getOrCreateKotlinClass(MFAChallengeCommandResult.class) + ", but of type " + Reflection.getOrCreateKotlinClass(result2.getClass()) + ", even though the command was marked as COMPLETED";
                            String correlationId3 = rawCommandResult.getCorrelationId();
                            Intrinsics.checkNotNullExpressionValue(correlationId3, "this.correlationId");
                            aPIError = new INativeAuthCommandResult.APIError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, str2, null, correlationId3, null, null, 52, null);
                        }
                    }
                }
                MFAChallengeCommandResult mFAChallengeCommandResult = (MFAChallengeCommandResult) aPIError2;
                if (mFAChallengeCommandResult instanceof MFACommandResult.VerificationRequired) {
                    return new MFARequiredResult.VerificationRequired(new MFARequiredState(((MFACommandResult.VerificationRequired) mFAChallengeCommandResult).getContinuationToken(), mFAChallengeCommandResult.getCorrelationId(), AwaitingMFAState.this.scopes, AwaitingMFAState.this.config), ((MFACommandResult.VerificationRequired) mFAChallengeCommandResult).getCodeLength(), ((MFACommandResult.VerificationRequired) mFAChallengeCommandResult).getChallengeTargetLabel(), ((MFACommandResult.VerificationRequired) mFAChallengeCommandResult).getChallengeChannel());
                }
                if (mFAChallengeCommandResult instanceof INativeAuthCommandResult.APIError) {
                    Logger.warnWithObject(AwaitingMFAState.this.TAG, mFAChallengeCommandResult.getCorrelationId(), "requestChallenge(authMethod: AuthMethod) received unexpected result: ", mFAChallengeCommandResult);
                    return new MFARequestChallengeError(null, ((INativeAuthCommandResult.APIError) mFAChallengeCommandResult).getError(), ((INativeAuthCommandResult.APIError) mFAChallengeCommandResult).getErrorDescription(), mFAChallengeCommandResult.getCorrelationId(), ((INativeAuthCommandResult.APIError) mFAChallengeCommandResult).getErrorCodes(), null, ((INativeAuthCommandResult.APIError) mFAChallengeCommandResult).getException(), 33, null);
                }
                if (mFAChallengeCommandResult instanceof INativeAuthCommandResult.Redirect) {
                    return new MFARequestChallengeError(ErrorTypes.BROWSER_REQUIRED, ((INativeAuthCommandResult.Redirect) mFAChallengeCommandResult).getError(), ((INativeAuthCommandResult.Redirect) mFAChallengeCommandResult).getRedirectReason(), mFAChallengeCommandResult.getCorrelationId(), null, null, null, 112, null);
                }
                if (mFAChallengeCommandResult instanceof MFACommandResult.BlockedAuthMethod) {
                    return new MFARequestChallengeError(ErrorTypes.AUTH_METHOD_BLOCKED, ((MFACommandResult.BlockedAuthMethod) mFAChallengeCommandResult).getError(), ((MFACommandResult.BlockedAuthMethod) mFAChallengeCommandResult).getErrorDescription(), mFAChallengeCommandResult.getCorrelationId(), null, null, null, 112, null);
                }
                throw new NoWhenBranchMatchedException();
            } catch (Exception e) {
                return new MFARequestChallengeError("client_exception", null, "MSAL client exception occurred in requestChallenge().", AwaitingMFAState.this.getCorrelationId(), null, null, e, 50, null);
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AwaitingMFAState(Parcel parcel) {
        NativeAuthPublicClientApplicationConfiguration nativeAuthPublicClientApplicationConfiguration;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String string = parcel.readString();
        string = string == null ? "" : string;
        String string2 = parcel.readString();
        string2 = string2 == null ? TelemetryEventStrings.Value.UNSET : string2;
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        if (Build.VERSION.SDK_INT >= 33) {
            nativeAuthPublicClientApplicationConfiguration = (Serializable) parcel.readSerializable(NativeAuthPublicClientApplicationConfiguration.class.getClassLoader(), NativeAuthPublicClientApplicationConfiguration.class);
        } else {
            Serializable serializable = parcel.readSerializable();
            nativeAuthPublicClientApplicationConfiguration = (NativeAuthPublicClientApplicationConfiguration) (serializable instanceof NativeAuthPublicClientApplicationConfiguration ? serializable : null);
        }
        Intrinsics.checkNotNull(nativeAuthPublicClientApplicationConfiguration, "null cannot be cast to non-null type com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration");
        this(string, string2, arrayListCreateStringArrayList, (NativeAuthPublicClientApplicationConfiguration) nativeAuthPublicClientApplicationConfiguration);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(getContinuationToken());
        parcel.writeString(getCorrelationId());
        parcel.writeStringList(this.scopes);
        parcel.writeSerializable(this.config);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.AwaitingMFAState$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: MFAStates.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/AwaitingMFAState$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/microsoft/identity/nativeauth/statemachine/states/AwaitingMFAState;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/microsoft/identity/nativeauth/statemachine/states/AwaitingMFAState;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion implements Parcelable.Creator<AwaitingMFAState> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AwaitingMFAState createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AwaitingMFAState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AwaitingMFAState[] newArray(int size) {
            return new AwaitingMFAState[size];
        }
    }
}
