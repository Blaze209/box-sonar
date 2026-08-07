package com.microsoft.identity.nativeauth.statemachine.states;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.box.boxandroidlibv2private.model.BoxTaskCollaborator;
import com.microsoft.identity.client.Account;
import com.microsoft.identity.client.AcquireTokenSilentParameters;
import com.microsoft.identity.client.AuthenticationResultAdapter;
import com.microsoft.identity.client.IAccount;
import com.microsoft.identity.client.IAuthenticationResult;
import com.microsoft.identity.client.PublicClientApplication;
import com.microsoft.identity.client.claims.ClaimsRequest;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.client.internal.CommandParametersAdapter;
import com.microsoft.identity.common.internal.commands.RemoveCurrentAccountCommand;
import com.microsoft.identity.common.internal.controllers.LocalMSALController;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.commands.CommandCallback;
import com.microsoft.identity.common.java.commands.SilentTokenCommand;
import com.microsoft.identity.common.java.controllers.CommandDispatcher;
import com.microsoft.identity.common.java.controllers.ExceptionAdapter;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.eststelemetry.PublicApiId;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.result.ILocalAuthenticationResult;
import com.microsoft.identity.common.java.result.LocalAuthenticationResult;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.nativeauth.internal.controllers.NativeAuthMsalController;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration;
import com.microsoft.identity.nativeauth.parameters.NativeAuthGetAccessTokenParameters;
import com.microsoft.identity.nativeauth.statemachine.errors.GetAccessTokenError;
import com.microsoft.identity.nativeauth.statemachine.errors.SignOutError;
import com.microsoft.identity.nativeauth.statemachine.results.GetAccessTokenResult;
import com.microsoft.identity.nativeauth.statemachine.results.SignOutResult;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: AccountState.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0003,-.B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001f\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0010\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017J\u001b\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u001a\u0010\u0010\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J)\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u001cH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ(\u0010\u0010\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u001c2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J1\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020\u0006J\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0002\b\u0003\u0018\u00010$J\b\u0010%\u001a\u0004\u0018\u00010\nJ\u0011\u0010&\u001a\u00020'H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010(J\u000e\u0010&\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020)J\u0018\u0010*\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006/"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/AccountState;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "account", "Lcom/microsoft/identity/client/IAccount;", "config", "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;", "correlationId", "", "(Lcom/microsoft/identity/client/IAccount;Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "describeContents", "", "getAccessToken", "Lcom/microsoft/identity/nativeauth/statemachine/results/GetAccessTokenResult;", "parameters", "Lcom/microsoft/identity/nativeauth/parameters/NativeAuthGetAccessTokenParameters;", "(Lcom/microsoft/identity/nativeauth/parameters/NativeAuthGetAccessTokenParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callback", "Lcom/microsoft/identity/nativeauth/statemachine/states/AccountState$GetAccessTokenCallback;", "forceRefresh", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scopes", "", "(ZLjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAccessTokenInternal", "claimsRequest", "Lcom/microsoft/identity/client/claims/ClaimsRequest;", "(ZLjava/util/List;Lcom/microsoft/identity/client/claims/ClaimsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAccount", "getClaims", "", "getIdToken", "signOut", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignOutResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/microsoft/identity/nativeauth/statemachine/states/AccountState$SignOutCallback;", "writeToParcel", "flags", BoxTaskCollaborator.ROLE_CREATOR, "GetAccessTokenCallback", "SignOutCallback", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AccountState implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "NativeAuthPublicClientApplication";
    private IAccount account;
    private final NativeAuthPublicClientApplicationConfiguration config;
    private final String correlationId;

    /* JADX INFO: compiled from: AccountState.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/AccountState$GetAccessTokenCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/GetAccessTokenResult;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface GetAccessTokenCallback extends Callback<GetAccessTokenResult> {
    }

    /* JADX INFO: compiled from: AccountState.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/AccountState$SignOutCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignOutResult;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SignOutCallback extends Callback<SignOutResult> {
    }

    public /* synthetic */ AccountState(IAccount iAccount, NativeAuthPublicClientApplicationConfiguration nativeAuthPublicClientApplicationConfiguration, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(iAccount, nativeAuthPublicClientApplicationConfiguration, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private AccountState(IAccount iAccount, NativeAuthPublicClientApplicationConfiguration nativeAuthPublicClientApplicationConfiguration, String str) {
        this.account = iAccount;
        this.config = nativeAuthPublicClientApplicationConfiguration;
        this.correlationId = str;
    }

    public final String getCorrelationId() {
        return this.correlationId;
    }

    public final void signOut(SignOutCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, null, TAG2 + ".signOut(callback: SignOutCallback)");
        BuildersKt__Builders_commonKt.launch$default(NativeAuthPublicClientApplication.INSTANCE.getPcaScope(), null, null, new C18291(callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.AccountState$signOut$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AccountState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.AccountState$signOut$1", f = "AccountState.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
    static final class C18291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SignOutCallback $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18291(SignOutCallback signOutCallback, Continuation<? super C18291> continuation) {
            super(2, continuation);
            this.$callback = signOutCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AccountState.this.new C18291(this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18291) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = AccountState.this.signOut(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((SignOutResult) obj);
            } catch (MsalException e) {
                Logger.error(AccountState.TAG, "Exception thrown in signOut", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.AccountState$signOut$3, reason: invalid class name */
    /* JADX INFO: compiled from: AccountState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignOutResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.AccountState$signOut$3", f = "AccountState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SignOutResult>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AccountState.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SignOutResult> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                LogSession.Companion companion = LogSession.INSTANCE;
                String TAG = AccountState.TAG;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                companion.logMethodCall(TAG, null, AccountState.TAG + ".signOut()");
                IAccount currentAccountInternal = NativeAuthPublicClientApplication.INSTANCE.getCurrentAccountInternal(AccountState.this.config);
                if (currentAccountInternal == null) {
                    throw new MsalClientException(MsalClientException.NO_CURRENT_ACCOUNT, MsalClientException.NO_CURRENT_ACCOUNT_ERROR_MESSAGE);
                }
                AccountRecord accountRecord = new AccountRecord();
                accountRecord.setEnvironment(((Account) currentAccountInternal).getEnvironment());
                accountRecord.setHomeAccountId(((Account) currentAccountInternal).getHomeAccountId());
                Object result = CommandDispatcher.submitSilentReturningFuture(new RemoveCurrentAccountCommand(CommandParametersAdapter.createRemoveAccountCommandParameters(AccountState.this.config, AccountState.this.config.getOAuth2TokenCache(), accountRecord), new LocalMSALController().asControllerFactory(), new CommandCallback<Boolean, BaseException>() { // from class: com.microsoft.identity.nativeauth.statemachine.states.AccountState$signOut$3$removeCurrentAccountCommandParameters$1
                    @Override // com.microsoft.identity.common.java.commands.CommandCallback
                    public void onCancel() {
                    }

                    @Override // com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError
                    public void onError(BaseException error) {
                    }

                    @Override // com.microsoft.identity.common.java.util.TaskCompletedCallback
                    public void onTaskCompleted(Boolean result2) {
                    }
                }, PublicApiId.NATIVE_AUTH_ACCOUNT_SIGN_OUT)).get().getResult();
                Intrinsics.checkNotNull(result, "null cannot be cast to non-null type kotlin.Boolean");
                if (((Boolean) result).booleanValue()) {
                    return SignOutResult.Complete.INSTANCE;
                }
                Logger.error(AccountState.TAG, "Unexpected error during signOut.", null);
                throw new MsalClientException("unknown_error", "Unexpected error during signOut.");
            } catch (Exception e) {
                return new SignOutError("client_exception", null, "MSAL client exception occurred in signOut.", AccountState.this.getCorrelationId(), null, e, 18, null);
            }
        }
    }

    public final Object signOut(Continuation<? super SignOutResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass3(null), continuation);
    }

    public final IAccount getAccount() {
        return this.account;
    }

    public final String getIdToken() {
        return this.account.getIdToken();
    }

    public final Map<String, ?> getClaims() {
        return this.account.getClaims();
    }

    public static /* synthetic */ void getAccessToken$default(AccountState accountState, boolean z, GetAccessTokenCallback getAccessTokenCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        accountState.getAccessToken(z, getAccessTokenCallback);
    }

    @Deprecated(message = "This method is now deprecated. Use the method 'getAccessToken(parameters:, callback:)' instead.")
    public final void getAccessToken(boolean forceRefresh, GetAccessTokenCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, null, TAG2 + ".getAccessToken(forceRefresh: Boolean = " + forceRefresh + ", callback: GetAccessTokenCallback)");
        BuildersKt__Builders_commonKt.launch$default(NativeAuthPublicClientApplication.INSTANCE.getPcaScope(), null, null, new AnonymousClass1(forceRefresh, callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.AccountState$getAccessToken$1, reason: invalid class name */
    /* JADX INFO: compiled from: AccountState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.AccountState$getAccessToken$1", f = "AccountState.kt", i = {}, l = {230}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GetAccessTokenCallback $callback;
        final /* synthetic */ boolean $forceRefresh;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z, GetAccessTokenCallback getAccessTokenCallback, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$forceRefresh = z;
            this.$callback = getAccessTokenCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AccountState.this.new AnonymousClass1(this.$forceRefresh, this.$callback, continuation);
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
                    obj = AccountState.this.getAccessToken(this.$forceRefresh, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((GetAccessTokenResult) obj);
            } catch (MsalException e) {
                Logger.error(AccountState.TAG, "Exception thrown in getAccessToken", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ Object getAccessToken$default(AccountState accountState, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return accountState.getAccessToken(z, (Continuation<? super GetAccessTokenResult>) continuation);
    }

    @Deprecated(message = "This method is now deprecated. Use the method 'getAccessToken(parameters:)' instead.")
    public final Object getAccessToken(boolean z, Continuation<? super GetAccessTokenResult> continuation) {
        Set<String> DEFAULT_SCOPES = AuthenticationConstants.DEFAULT_SCOPES;
        Intrinsics.checkNotNullExpressionValue(DEFAULT_SCOPES, "DEFAULT_SCOPES");
        return getAccessTokenInternal(z, CollectionsKt.toList(DEFAULT_SCOPES), null, continuation);
    }

    public static /* synthetic */ Object getAccessToken$default(AccountState accountState, boolean z, List list, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return accountState.getAccessToken(z, (List<String>) list, (Continuation<? super GetAccessTokenResult>) continuation);
    }

    @Deprecated(message = "This method is now deprecated. Use the method 'getAccessToken(parameters:)' instead.")
    public final Object getAccessToken(boolean z, List<String> list, Continuation<? super GetAccessTokenResult> continuation) {
        if (list.isEmpty()) {
            return new GetAccessTokenError("invalid_scopes", null, "Empty or invalid scopes", this.correlationId, null, null, 50, null);
        }
        return getAccessTokenInternal(z, list, null, continuation);
    }

    public final Object getAccessToken(NativeAuthGetAccessTokenParameters nativeAuthGetAccessTokenParameters, Continuation<? super GetAccessTokenResult> continuation) {
        List<String> scopes = nativeAuthGetAccessTokenParameters.getScopes();
        if (scopes == null) {
            Set<String> DEFAULT_SCOPES = AuthenticationConstants.DEFAULT_SCOPES;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_SCOPES, "DEFAULT_SCOPES");
            scopes = CollectionsKt.toList(DEFAULT_SCOPES);
        }
        if (scopes.isEmpty()) {
            return new GetAccessTokenError("invalid_scopes", null, "Empty or invalid scopes", this.correlationId, null, null, 50, null);
        }
        return getAccessTokenInternal(nativeAuthGetAccessTokenParameters.getForceRefresh(), scopes, nativeAuthGetAccessTokenParameters.getClaimsRequest(), continuation);
    }

    public static /* synthetic */ void getAccessToken$default(AccountState accountState, boolean z, List list, GetAccessTokenCallback getAccessTokenCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        accountState.getAccessToken(z, (List<String>) list, getAccessTokenCallback);
    }

    @Deprecated(message = "This method is now deprecated. Use the method 'getAccessToken(parameters:, callback:)' instead.")
    public final void getAccessToken(boolean forceRefresh, List<String> scopes, GetAccessTokenCallback callback) {
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, null, TAG2 + ".getAccessToken(forceRefresh: Boolean = " + forceRefresh + ", scopes: List<String>, callback: GetAccessTokenCallback)");
        BuildersKt__Builders_commonKt.launch$default(NativeAuthPublicClientApplication.INSTANCE.getPcaScope(), null, null, new AnonymousClass5(forceRefresh, scopes, callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.AccountState$getAccessToken$5, reason: invalid class name */
    /* JADX INFO: compiled from: AccountState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.AccountState$getAccessToken$5", f = "AccountState.kt", i = {}, l = {313}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GetAccessTokenCallback $callback;
        final /* synthetic */ boolean $forceRefresh;
        final /* synthetic */ List<String> $scopes;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(boolean z, List<String> list, GetAccessTokenCallback getAccessTokenCallback, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.$forceRefresh = z;
            this.$scopes = list;
            this.$callback = getAccessTokenCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AccountState.this.new AnonymousClass5(this.$forceRefresh, this.$scopes, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = AccountState.this.getAccessToken(this.$forceRefresh, this.$scopes, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((GetAccessTokenResult) obj);
            } catch (MsalException e) {
                Logger.error(AccountState.TAG, "Exception thrown in getAccessToken", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }
    }

    public final void getAccessToken(NativeAuthGetAccessTokenParameters parameters, GetAccessTokenCallback callback) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, null, TAG2 + ".getAccessToken(parameters: NativeAuthGetAccessTokenParameters, callback: GetAccessTokenCallback)");
        BuildersKt__Builders_commonKt.launch$default(NativeAuthPublicClientApplication.INSTANCE.getPcaScope(), null, null, new AnonymousClass6(parameters, callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.AccountState$getAccessToken$6, reason: invalid class name */
    /* JADX INFO: compiled from: AccountState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.AccountState$getAccessToken$6", f = "AccountState.kt", i = {}, l = {339}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GetAccessTokenCallback $callback;
        final /* synthetic */ NativeAuthGetAccessTokenParameters $parameters;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(NativeAuthGetAccessTokenParameters nativeAuthGetAccessTokenParameters, GetAccessTokenCallback getAccessTokenCallback, Continuation<? super AnonymousClass6> continuation) {
            super(2, continuation);
            this.$parameters = nativeAuthGetAccessTokenParameters;
            this.$callback = getAccessTokenCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AccountState.this.new AnonymousClass6(this.$parameters, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = AccountState.this.getAccessToken(this.$parameters, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((GetAccessTokenResult) obj);
            } catch (MsalException e) {
                Logger.error(AccountState.TAG, "Exception thrown in getAccessToken", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getAccessTokenInternal(boolean z, List<String> list, ClaimsRequest claimsRequest, Continuation<? super GetAccessTokenResult> continuation) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, null, TAG2 + ".getAccessTokenInternal(forceRefresh: Boolean = " + z + ", scopes: List<String>)");
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(z, list, claimsRequest, null), continuation);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.AccountState$getAccessTokenInternal$2, reason: invalid class name */
    /* JADX INFO: compiled from: AccountState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/GetAccessTokenResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.statemachine.states.AccountState$getAccessTokenInternal$2", f = "AccountState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super GetAccessTokenResult>, Object> {
        final /* synthetic */ ClaimsRequest $claimsRequest;
        final /* synthetic */ boolean $forceRefresh;
        final /* synthetic */ List<String> $scopes;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(boolean z, List<String> list, ClaimsRequest claimsRequest, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$forceRefresh = z;
            this.$scopes = list;
            this.$claimsRequest = claimsRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AccountState.this.new AnonymousClass2(this.$forceRefresh, this.$scopes, this.$claimsRequest, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super GetAccessTokenResult> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    IAccount currentAccountInternal = NativeAuthPublicClientApplication.INSTANCE.getCurrentAccountInternal(AccountState.this.config);
                    Account account = currentAccountInternal instanceof Account ? (Account) currentAccountInternal : null;
                    if (account == null) {
                        return new GetAccessTokenError("invalid_scopes", MsalClientException.NO_CURRENT_ACCOUNT, MsalClientException.NO_CURRENT_ACCOUNT_ERROR_MESSAGE, AccountState.this.getCorrelationId(), null, null, 48, null);
                    }
                    String string = Intrinsics.areEqual(AccountState.this.getCorrelationId(), TelemetryEventStrings.Value.UNSET) ? UUID.randomUUID().toString() : AccountState.this.getCorrelationId();
                    Intrinsics.checkNotNullExpressionValue(string, "if (correlationId == \"UN… } else { correlationId }");
                    AcquireTokenSilentParameters acquireTokenSilentParametersBuild = new AcquireTokenSilentParameters.Builder().forAccount(account).fromAuthority(account.getAuthority()).withCorrelationId(UUID.fromString(string)).forceRefresh(this.$forceRefresh).withScopes(this.$scopes).withClaims(this.$claimsRequest).build();
                    acquireTokenSilentParametersBuild.setAccountRecord(PublicClientApplication.selectAccountRecordForTokenRequest(AccountState.this.config, acquireTokenSilentParametersBuild));
                    Object result = CommandDispatcher.submitSilentReturningFuture(new SilentTokenCommand(CommandParametersAdapter.createSilentTokenCommandParameters(AccountState.this.config, AccountState.this.config.getOAuth2TokenCache(), acquireTokenSilentParametersBuild), new NativeAuthMsalController().asControllerFactory(), new CommandCallback<LocalAuthenticationResult, BaseException>() { // from class: com.microsoft.identity.nativeauth.statemachine.states.AccountState$getAccessTokenInternal$2$command$1
                        @Override // com.microsoft.identity.common.java.commands.CommandCallback
                        public void onCancel() {
                        }

                        @Override // com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError
                        public void onError(BaseException error) {
                        }

                        @Override // com.microsoft.identity.common.java.util.TaskCompletedCallback
                        public void onTaskCompleted(LocalAuthenticationResult result2) {
                        }
                    }, PublicApiId.NATIVE_AUTH_ACCOUNT_GET_ACCESS_TOKEN)).get().getResult();
                    if (result instanceof ServiceException) {
                        ServiceException serviceExceptionConvertToNativeAuthException = ExceptionAdapter.convertToNativeAuthException((ServiceException) result);
                        String correlationId = ((ServiceException) result).getCorrelationId();
                        if (correlationId == null) {
                            correlationId = AccountState.this.getCorrelationId();
                        }
                        String str = correlationId;
                        Intrinsics.checkNotNullExpressionValue(str, "commandResult.correlationId ?: correlationId");
                        return new GetAccessTokenError(null, null, null, str, null, serviceExceptionConvertToNativeAuthException, 23, null);
                    }
                    if (result instanceof Exception) {
                        return new GetAccessTokenError(null, null, null, AccountState.this.getCorrelationId(), null, (Exception) result, 23, null);
                    }
                    AccountState accountState = AccountState.this;
                    Intrinsics.checkNotNull(result, "null cannot be cast to non-null type com.microsoft.identity.common.java.result.ILocalAuthenticationResult");
                    IAccount account2 = AuthenticationResultAdapter.adapt((ILocalAuthenticationResult) result).getAccount();
                    Intrinsics.checkNotNullExpressionValue(account2, "adapt(commandResult as I…enticationResult).account");
                    accountState.account = account2;
                    IAuthenticationResult iAuthenticationResultAdapt = AuthenticationResultAdapter.adapt((ILocalAuthenticationResult) result);
                    Intrinsics.checkNotNullExpressionValue(iAuthenticationResultAdapt, "adapt(commandResult)");
                    return new GetAccessTokenResult.Complete(iAuthenticationResultAdapt);
                } catch (Exception e) {
                    return new GetAccessTokenError("client_exception", null, "MSAL client exception occurred in getAccessToken.", AccountState.this.getCorrelationId(), null, e, 18, null);
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeSerializable(this.account);
        parcel.writeSerializable(this.correlationId);
        parcel.writeSerializable(this.config);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.AccountState$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: AccountState.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u001e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001d\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0002\u0010\u0017R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/AccountState$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/microsoft/identity/nativeauth/statemachine/states/AccountState;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "createFromAccountResult", "account", "Lcom/microsoft/identity/client/IAccount;", "correlationId", "config", "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;", "createFromAuthenticationResult", "authenticationResult", "Lcom/microsoft/identity/client/IAuthenticationResult;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/microsoft/identity/nativeauth/statemachine/states/AccountState;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion implements Parcelable.Creator<AccountState> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AccountState createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AccountState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AccountState[] newArray(int size) {
            return new AccountState[size];
        }

        public final AccountState createFromAuthenticationResult(IAuthenticationResult authenticationResult, String correlationId, NativeAuthPublicClientApplicationConfiguration config) {
            Intrinsics.checkNotNullParameter(authenticationResult, "authenticationResult");
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(config, "config");
            IAccount account = authenticationResult.getAccount();
            Intrinsics.checkNotNullExpressionValue(account, "account");
            return new AccountState(account, config, correlationId, null);
        }

        public final AccountState createFromAccountResult(IAccount account, String correlationId, NativeAuthPublicClientApplicationConfiguration config) {
            Intrinsics.checkNotNullParameter(account, "account");
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(config, "config");
            return new AccountState(account, config, correlationId, null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AccountState(Parcel parcel) {
        IAccount iAccount;
        NativeAuthPublicClientApplicationConfiguration nativeAuthPublicClientApplicationConfiguration;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        if (Build.VERSION.SDK_INT >= 33) {
            iAccount = (Serializable) parcel.readSerializable(IAccount.class.getClassLoader(), IAccount.class);
        } else {
            Serializable serializable = parcel.readSerializable();
            iAccount = (IAccount) (serializable instanceof IAccount ? serializable : null);
        }
        Intrinsics.checkNotNull(iAccount, "null cannot be cast to non-null type com.microsoft.identity.client.IAccount");
        IAccount iAccount2 = (IAccount) iAccount;
        String string = parcel.readString();
        string = string == null ? TelemetryEventStrings.Value.UNSET : string;
        if (Build.VERSION.SDK_INT >= 33) {
            nativeAuthPublicClientApplicationConfiguration = (Serializable) parcel.readSerializable(NativeAuthPublicClientApplicationConfiguration.class.getClassLoader(), NativeAuthPublicClientApplicationConfiguration.class);
        } else {
            Serializable serializable2 = parcel.readSerializable();
            nativeAuthPublicClientApplicationConfiguration = (NativeAuthPublicClientApplicationConfiguration) (serializable2 instanceof NativeAuthPublicClientApplicationConfiguration ? serializable2 : null);
        }
        Intrinsics.checkNotNull(nativeAuthPublicClientApplicationConfiguration, "null cannot be cast to non-null type com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration");
        this(iAccount2, (NativeAuthPublicClientApplicationConfiguration) nativeAuthPublicClientApplicationConfiguration, string);
    }
}
