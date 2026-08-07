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
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitUserAttributesCommandParameters;
import com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpSubmitUserAttributesCommandResult;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.util.CommandResultUtilKt;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.nativeauth.internal.commands.SignUpSubmitUserAttributesCommand;
import com.microsoft.identity.common.nativeauth.internal.controllers.NativeAuthMsalController;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration;
import com.microsoft.identity.nativeauth.RequiredUserAttributeKt;
import com.microsoft.identity.nativeauth.UserAttributes;
import com.microsoft.identity.nativeauth.UserAttributesKt;
import com.microsoft.identity.nativeauth.statemachine.errors.ErrorTypes;
import com.microsoft.identity.nativeauth.statemachine.errors.SignUpErrorTypes;
import com.microsoft.identity.nativeauth.statemachine.errors.SignUpSubmitAttributesError;
import com.microsoft.identity.nativeauth.statemachine.results.SignUpResult;
import com.microsoft.identity.nativeauth.statemachine.results.SignUpSubmitAttributesResult;
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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u001e\u001fB\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B'\b\u0000\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0016\u0010\u0014\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0013H\u0016R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\t\u001a\u00020\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/SignUpAttributesRequiredState;", "Lcom/microsoft/identity/nativeauth/statemachine/states/BaseState;", "Lcom/microsoft/identity/nativeauth/statemachine/states/State;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "continuationToken", "", "correlationId", "username", "config", "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;)V", "TAG", "getContinuationToken$msal_distRelease", "()Ljava/lang/String;", "getCorrelationId$msal_distRelease", "describeContents", "", "submitAttributes", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpSubmitAttributesResult;", NativeAuthConstants.GrantType.ATTRIBUTES, "Lcom/microsoft/identity/nativeauth/UserAttributes;", "(Lcom/microsoft/identity/nativeauth/UserAttributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callback", "Lcom/microsoft/identity/nativeauth/statemachine/states/SignUpAttributesRequiredState$SignUpSubmitUserAttributesCallback;", "writeToParcel", "flags", BoxTaskCollaborator.ROLE_CREATOR, "SignUpSubmitUserAttributesCallback", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SignUpAttributesRequiredState extends BaseState implements State, Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String TAG;
    private final NativeAuthPublicClientApplicationConfiguration config;
    private final String continuationToken;
    private final String correlationId;
    private final String username;

    /* JADX INFO: compiled from: SignUpStates.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/SignUpAttributesRequiredState$SignUpSubmitUserAttributesCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpSubmitAttributesResult;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SignUpSubmitUserAttributesCallback extends Callback<SignUpSubmitAttributesResult> {
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
    public SignUpAttributesRequiredState(String continuationToken, String correlationId, String username, NativeAuthPublicClientApplicationConfiguration config) {
        super(continuationToken, correlationId);
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(config, "config");
        this.continuationToken = continuationToken;
        this.correlationId = correlationId;
        this.username = username;
        this.config = config;
        Intrinsics.checkNotNullExpressionValue("SignUpAttributesRequiredState", "SignUpAttributesRequired…te::class.java.simpleName");
        this.TAG = "SignUpAttributesRequiredState";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SignUpAttributesRequiredState(Parcel parcel) {
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

    public final void submitAttributes(UserAttributes attributes, SignUpSubmitUserAttributesCallback callback) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), this.TAG + ".submitAttributes(attributes: UserAttributes, callback: SignUpSubmitUserAttributesCallback)");
        BuildersKt__Builders_commonKt.launch$default(NativeAuthPublicClientApplication.INSTANCE.getPcaScope(), null, null, new AnonymousClass1(attributes, callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignUpAttributesRequiredState$submitAttributes$1, reason: invalid class name */
    /* JADX INFO: compiled from: SignUpStates.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.SignUpAttributesRequiredState$submitAttributes$1", f = "SignUpStates.kt", i = {}, l = {628}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UserAttributes $attributes;
        final /* synthetic */ SignUpSubmitUserAttributesCallback $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(UserAttributes userAttributes, SignUpSubmitUserAttributesCallback signUpSubmitUserAttributesCallback, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$attributes = userAttributes;
            this.$callback = signUpSubmitUserAttributesCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SignUpAttributesRequiredState.this.new AnonymousClass1(this.$attributes, this.$callback, continuation);
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
                    obj = SignUpAttributesRequiredState.this.submitAttributes(this.$attributes, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((SignUpSubmitAttributesResult) obj);
            } catch (MsalException e) {
                Logger.error(SignUpAttributesRequiredState.this.TAG, "Exception thrown in submitAttributes", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }
    }

    public final Object submitAttributes(UserAttributes userAttributes, Continuation<? super SignUpSubmitAttributesResult> continuation) {
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), this.TAG + ".submitAttributes(attributes: UserAttributes)");
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass3(userAttributes, null), continuation);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignUpAttributesRequiredState$submitAttributes$3, reason: invalid class name */
    /* JADX INFO: compiled from: SignUpStates.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpSubmitAttributesResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.SignUpAttributesRequiredState$submitAttributes$3", f = "SignUpStates.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SignUpSubmitAttributesResult>, Object> {
        final /* synthetic */ UserAttributes $attributes;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(UserAttributes userAttributes, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$attributes = userAttributes;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SignUpAttributesRequiredState.this.new AnonymousClass3(this.$attributes, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SignUpSubmitAttributesResult> continuation) {
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
                SignUpSubmitUserAttributesCommandParameters commandParameters = CommandParametersAdapter.createSignUpStarSubmitUserAttributesCommandParameters(SignUpAttributesRequiredState.this.config, SignUpAttributesRequiredState.this.config.getOAuth2TokenCache(), SignUpAttributesRequiredState.this.getContinuationToken(), SignUpAttributesRequiredState.this.getCorrelationId(), UserAttributesKt.toMap(this.$attributes));
                Intrinsics.checkNotNullExpressionValue(commandParameters, "commandParameters");
                CommandResult rawCommandResult = CommandDispatcher.submitSilentReturningFuture(new SignUpSubmitUserAttributesCommand(commandParameters, new NativeAuthMsalController(), "234")).get();
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
                                throw new NullPointerException("null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpSubmitUserAttributesCommandResult");
                            }
                            aPIError = (SignUpSubmitUserAttributesCommandResult) result2;
                            aPIError2 = aPIError;
                        } catch (ClassCastException unused) {
                            String str4 = CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR;
                            String str5 = "Type casting error: result of " + rawCommandResult + " is not of type " + Reflection.getOrCreateKotlinClass(SignUpSubmitUserAttributesCommandResult.class) + ", but of type " + Reflection.getOrCreateKotlinClass(result2.getClass()) + ", even though the command was marked as COMPLETED";
                            String correlationId3 = rawCommandResult.getCorrelationId();
                            Intrinsics.checkNotNullExpressionValue(correlationId3, "this.correlationId");
                            aPIError = new INativeAuthCommandResult.APIError(str4, str5, null, correlationId3, null, null, 52, null);
                        }
                    }
                }
                SignUpSubmitUserAttributesCommandResult signUpSubmitUserAttributesCommandResult = (SignUpSubmitUserAttributesCommandResult) aPIError2;
                if (signUpSubmitUserAttributesCommandResult instanceof SignUpCommandResult.AttributesRequired) {
                    return new SignUpResult.AttributesRequired(new SignUpAttributesRequiredState(((SignUpCommandResult.AttributesRequired) signUpSubmitUserAttributesCommandResult).getContinuationToken(), signUpSubmitUserAttributesCommandResult.getCorrelationId(), SignUpAttributesRequiredState.this.username, SignUpAttributesRequiredState.this.config), RequiredUserAttributeKt.toListOfRequiredUserAttribute(((SignUpCommandResult.AttributesRequired) signUpSubmitUserAttributesCommandResult).getRequiredAttributes()));
                }
                if (signUpSubmitUserAttributesCommandResult instanceof SignUpCommandResult.Complete) {
                    return new SignUpResult.Complete(new SignInContinuationState(((SignUpCommandResult.Complete) signUpSubmitUserAttributesCommandResult).getContinuationToken(), signUpSubmitUserAttributesCommandResult.getCorrelationId(), SignUpAttributesRequiredState.this.username, SignUpAttributesRequiredState.this.config));
                }
                if (signUpSubmitUserAttributesCommandResult instanceof SignUpCommandResult.InvalidAttributes) {
                    return new SignUpSubmitAttributesError(SignUpErrorTypes.INVALID_ATTRIBUTES, ((SignUpCommandResult.InvalidAttributes) signUpSubmitUserAttributesCommandResult).getError(), ((SignUpCommandResult.InvalidAttributes) signUpSubmitUserAttributesCommandResult).getErrorDescription(), signUpSubmitUserAttributesCommandResult.getCorrelationId(), null, null, 48, null);
                }
                if (signUpSubmitUserAttributesCommandResult instanceof INativeAuthCommandResult.Redirect) {
                    return new SignUpSubmitAttributesError(ErrorTypes.BROWSER_REQUIRED, ((INativeAuthCommandResult.Redirect) signUpSubmitUserAttributesCommandResult).getError(), ((INativeAuthCommandResult.Redirect) signUpSubmitUserAttributesCommandResult).getRedirectReason(), signUpSubmitUserAttributesCommandResult.getCorrelationId(), null, null, 48, null);
                }
                if (signUpSubmitUserAttributesCommandResult instanceof SignUpCommandResult.UsernameAlreadyExists) {
                    Logger.warnWithObject(SignUpAttributesRequiredState.this.TAG, signUpSubmitUserAttributesCommandResult.getCorrelationId(), "Submit attributes received unexpected result: ", signUpSubmitUserAttributesCommandResult);
                    return new SignUpSubmitAttributesError(null, ((SignUpCommandResult.UsernameAlreadyExists) signUpSubmitUserAttributesCommandResult).getError(), ((SignUpCommandResult.UsernameAlreadyExists) signUpSubmitUserAttributesCommandResult).getErrorDescription(), signUpSubmitUserAttributesCommandResult.getCorrelationId(), null, null, 49, null);
                }
                if (!(signUpSubmitUserAttributesCommandResult instanceof INativeAuthCommandResult.APIError)) {
                    throw new NoWhenBranchMatchedException();
                }
                Logger.warnWithObject(SignUpAttributesRequiredState.this.TAG, signUpSubmitUserAttributesCommandResult.getCorrelationId(), "Submit attributes received unexpected result: ", signUpSubmitUserAttributesCommandResult);
                return new SignUpSubmitAttributesError(null, ((INativeAuthCommandResult.APIError) signUpSubmitUserAttributesCommandResult).getError(), ((INativeAuthCommandResult.APIError) signUpSubmitUserAttributesCommandResult).getErrorDescription(), signUpSubmitUserAttributesCommandResult.getCorrelationId(), null, ((INativeAuthCommandResult.APIError) signUpSubmitUserAttributesCommandResult).getException(), 17, null);
            } catch (Exception e) {
                return new SignUpSubmitAttributesError("client_exception", null, "MSAL client exception occurred in submitAttributes.", SignUpAttributesRequiredState.this.getCorrelationId(), null, e, 18, null);
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

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignUpAttributesRequiredState$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: SignUpStates.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/SignUpAttributesRequiredState$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/microsoft/identity/nativeauth/statemachine/states/SignUpAttributesRequiredState;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/microsoft/identity/nativeauth/statemachine/states/SignUpAttributesRequiredState;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion implements Parcelable.Creator<SignUpAttributesRequiredState> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SignUpAttributesRequiredState createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SignUpAttributesRequiredState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SignUpAttributesRequiredState[] newArray(int size) {
            return new SignUpAttributesRequiredState[size];
        }
    }
}
