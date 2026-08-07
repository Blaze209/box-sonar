package com.microsoft.identity.nativeauth;

import android.content.Context;
import com.microsoft.identity.client.AccountAdapter;
import com.microsoft.identity.client.AuthenticationResultAdapter;
import com.microsoft.identity.client.IAccount;
import com.microsoft.identity.client.IAuthenticationResult;
import com.microsoft.identity.client.PublicClientApplication;
import com.microsoft.identity.client.claims.ClaimsRequest;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.client.internal.CommandParametersAdapter;
import com.microsoft.identity.common.crypto.AndroidAuthSdkStorageEncryptionManager;
import com.microsoft.identity.common.internal.cache.SharedPreferencesFileManager;
import com.microsoft.identity.common.internal.commands.GetCurrentAccountCommand;
import com.microsoft.identity.common.internal.controllers.LocalMSALController;
import com.microsoft.identity.common.internal.net.cache.HttpCache;
import com.microsoft.identity.common.java.authorities.Authority;
import com.microsoft.identity.common.java.cache.ICacheRecord;
import com.microsoft.identity.common.java.commands.CommandCallback;
import com.microsoft.identity.common.java.commands.ICommandResult;
import com.microsoft.identity.common.java.controllers.CommandDispatcher;
import com.microsoft.identity.common.java.controllers.CommandResult;
import com.microsoft.identity.common.java.eststelemetry.PublicApiId;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.logging.DiagnosticContext;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordStartCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInStartCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpStartCommandParameters;
import com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordStartCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInStartCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpStartCommandResult;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.util.CommandResultUtilKt;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectory;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.java.util.ResultFuture;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordStartCommand;
import com.microsoft.identity.common.nativeauth.internal.commands.SignInStartCommand;
import com.microsoft.identity.common.nativeauth.internal.commands.SignUpStartCommand;
import com.microsoft.identity.common.nativeauth.internal.controllers.NativeAuthMsalController;
import com.microsoft.identity.nativeauth.parameters.NativeAuthResetPasswordParameters;
import com.microsoft.identity.nativeauth.parameters.NativeAuthSignInParameters;
import com.microsoft.identity.nativeauth.parameters.NativeAuthSignUpParameters;
import com.microsoft.identity.nativeauth.statemachine.errors.ErrorTypes;
import com.microsoft.identity.nativeauth.statemachine.errors.GetAccountError;
import com.microsoft.identity.nativeauth.statemachine.errors.ResetPasswordError;
import com.microsoft.identity.nativeauth.statemachine.errors.SignInError;
import com.microsoft.identity.nativeauth.statemachine.errors.SignInErrorTypes;
import com.microsoft.identity.nativeauth.statemachine.errors.SignUpError;
import com.microsoft.identity.nativeauth.statemachine.errors.SignUpErrorTypes;
import com.microsoft.identity.nativeauth.statemachine.results.GetAccountResult;
import com.microsoft.identity.nativeauth.statemachine.results.ResetPasswordStartResult;
import com.microsoft.identity.nativeauth.statemachine.results.SignInResult;
import com.microsoft.identity.nativeauth.statemachine.results.SignUpResult;
import com.microsoft.identity.nativeauth.statemachine.states.AccountState;
import com.microsoft.identity.nativeauth.statemachine.states.AwaitingMFAState;
import com.microsoft.identity.nativeauth.statemachine.states.Callback;
import com.microsoft.identity.nativeauth.statemachine.states.RegisterStrongAuthState;
import com.microsoft.identity.nativeauth.statemachine.states.ResetPasswordCodeRequiredState;
import com.microsoft.identity.nativeauth.statemachine.states.SignInCodeRequiredState;
import com.microsoft.identity.nativeauth.statemachine.states.SignInContinuationState;
import com.microsoft.identity.nativeauth.statemachine.states.SignInPasswordRequiredState;
import com.microsoft.identity.nativeauth.statemachine.states.SignUpAttributesRequiredState;
import com.microsoft.identity.nativeauth.statemachine.states.SignUpCodeRequiredState;
import com.microsoft.identity.nativeauth.statemachine.states.SignUpPasswordRequiredState;
import java.util.List;
import java.util.concurrent.ExecutionException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: NativeAuthPublicClientApplication.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 82\u00020\u00012\u00020\u0002:\u000589:;<B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0011\u0010\u000b\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0010\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J=\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\"J-\u0010#\u001a\u00020$2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u00010&H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010'J\u0019\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010+J\u0018\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020*2\u0006\u0010\u000f\u001a\u00020,H\u0016J\u0019\u0010(\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0097@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0018\u0010(\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020,H\u0017J\u0019\u0010-\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020.H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010/J\u0018\u0010-\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020.2\u0006\u0010\u000f\u001a\u000200H\u0016J3\u0010-\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001fH\u0097@ø\u0001\u0000¢\u0006\u0002\u00101J2\u0010-\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001f2\u0006\u0010\u000f\u001a\u000200H\u0017J\u0019\u00102\u001a\u00020$2\u0006\u0010)\u001a\u000203H\u0096@ø\u0001\u0000¢\u0006\u0002\u00104J\u0018\u00102\u001a\u00020\u000e2\u0006\u0010)\u001a\u0002032\u0006\u0010\u000f\u001a\u000205H\u0016J-\u00102\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010%\u001a\u0004\u0018\u00010&H\u0097@ø\u0001\u0000¢\u0006\u0002\u00106J,\u00102\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u000f\u001a\u000205H\u0017J\b\u00107\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006="}, d2 = {"Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplication;", "Lcom/microsoft/identity/nativeauth/INativeAuthPublicClientApplication;", "Lcom/microsoft/identity/client/PublicClientApplication;", "nativeAuthConfig", "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;", "(Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;)V", "sharedPreferencesFileManager", "Lcom/microsoft/identity/common/internal/cache/SharedPreferencesFileManager;", "checkForPersistedAccount", "Lcom/microsoft/identity/common/java/util/ResultFuture;", "", "getCurrentAccount", "Lcom/microsoft/identity/nativeauth/statemachine/results/GetAccountResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callback", "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplication$GetCurrentAccountCallback;", "initializeApplication", "initializeSharedPreferenceFileManager", "context", "Landroid/content/Context;", "internalResetPassword", "Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordStartResult;", "username", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "internalSignIn", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResult;", "password", "", "scopes", "", "claimsRequest", "Lcom/microsoft/identity/client/claims/ClaimsRequest;", "(Ljava/lang/String;[CLjava/util/List;Lcom/microsoft/identity/client/claims/ClaimsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "internalSignUp", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpResult;", NativeAuthConstants.GrantType.ATTRIBUTES, "Lcom/microsoft/identity/nativeauth/UserAttributes;", "([CLjava/lang/String;Lcom/microsoft/identity/nativeauth/UserAttributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetPassword", "parameters", "Lcom/microsoft/identity/nativeauth/parameters/NativeAuthResetPasswordParameters;", "(Lcom/microsoft/identity/nativeauth/parameters/NativeAuthResetPasswordParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplication$ResetPasswordCallback;", "signIn", "Lcom/microsoft/identity/nativeauth/parameters/NativeAuthSignInParameters;", "(Lcom/microsoft/identity/nativeauth/parameters/NativeAuthSignInParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplication$SignInCallback;", "(Ljava/lang/String;[CLjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signUp", "Lcom/microsoft/identity/nativeauth/parameters/NativeAuthSignUpParameters;", "(Lcom/microsoft/identity/nativeauth/parameters/NativeAuthSignUpParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplication$SignUpCallback;", "(Ljava/lang/String;[CLcom/microsoft/identity/nativeauth/UserAttributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verifyNoUserIsSignedIn", "Companion", "GetCurrentAccountCallback", "ResetPasswordCallback", "SignInCallback", "SignUpCallback", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NativeAuthPublicClientApplication extends PublicClientApplication implements INativeAuthPublicClientApplication {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String NATIVE_AUTH_CREDENTIAL_SHARED_PREFERENCES = "com.microsoft.identity.client.native_auth_credential_cache";
    private static final String TAG;
    private static final CoroutineScope pcaScope;
    private final NativeAuthPublicClientApplicationConfiguration nativeAuthConfig;
    private SharedPreferencesFileManager sharedPreferencesFileManager;

    /* JADX INFO: compiled from: NativeAuthPublicClientApplication.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplication$GetCurrentAccountCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/GetAccountResult;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface GetCurrentAccountCallback extends Callback<GetAccountResult> {
    }

    /* JADX INFO: compiled from: NativeAuthPublicClientApplication.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplication$ResetPasswordCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordStartResult;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ResetPasswordCallback extends Callback<ResetPasswordStartResult> {
    }

    /* JADX INFO: compiled from: NativeAuthPublicClientApplication.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplication$SignInCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResult;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SignInCallback extends Callback<SignInResult> {
    }

    /* JADX INFO: compiled from: NativeAuthPublicClientApplication.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplication$SignUpCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpResult;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SignUpCallback extends Callback<SignUpResult> {
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$internalResetPassword$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NativeAuthPublicClientApplication.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication", f = "NativeAuthPublicClientApplication.kt", i = {}, l = {1021}, m = "internalResetPassword", n = {}, s = {})
    static final class C18201 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C18201(Continuation<? super C18201> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NativeAuthPublicClientApplication.this.internalResetPassword(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeAuthPublicClientApplication(NativeAuthPublicClientApplicationConfiguration nativeAuthConfig) throws MsalClientException {
        super(nativeAuthConfig);
        Intrinsics.checkNotNullParameter(nativeAuthConfig, "nativeAuthConfig");
        this.nativeAuthConfig = nativeAuthConfig;
        initializeApplication();
        Context appContext = nativeAuthConfig.getAppContext();
        Intrinsics.checkNotNullExpressionValue(appContext, "nativeAuthConfig.appContext");
        initializeSharedPreferenceFileManager(appContext);
    }

    /* JADX INFO: compiled from: NativeAuthPublicClientApplication.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\f\u001a\u0004\u0018\u00010\r2\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fH\u0002J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplication$Companion;", "", "()V", "NATIVE_AUTH_CREDENTIAL_SHARED_PREFERENCES", "", "TAG", "getTAG$msal_distRelease", "()Ljava/lang/String;", "pcaScope", "Lkotlinx/coroutines/CoroutineScope;", "getPcaScope", "()Lkotlinx/coroutines/CoroutineScope;", "getAccountFromICacheRecordsList", "Lcom/microsoft/identity/client/IAccount;", "cacheRecords", "", "Lcom/microsoft/identity/common/java/cache/ICacheRecord;", "getCurrentAccountInternal", "config", "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG$msal_distRelease() {
            return NativeAuthPublicClientApplication.TAG;
        }

        public final CoroutineScope getPcaScope() {
            return NativeAuthPublicClientApplication.pcaScope;
        }

        public final IAccount getCurrentAccountInternal(NativeAuthPublicClientApplicationConfiguration config) {
            Intrinsics.checkNotNullParameter(config, "config");
            LogSession.INSTANCE.logMethodCall(getTAG$msal_distRelease(), null, getTAG$msal_distRelease() + ".getCurrentAccountInternal(config: NativeAuthPublicClientApplicationConfiguration)");
            return getAccountFromICacheRecordsList((List) CommandDispatcher.submitSilentReturningFuture(new GetCurrentAccountCommand(CommandParametersAdapter.createCommandParameters(config, config.getOAuth2TokenCache()), new LocalMSALController().asControllerFactory(), new CommandCallback<List<? extends ICacheRecord>, BaseException>() { // from class: com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$Companion$getCurrentAccountInternal$command$1
                @Override // com.microsoft.identity.common.java.commands.CommandCallback
                public void onCancel() {
                }

                @Override // com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError
                public void onError(BaseException error) {
                }

                @Override // com.microsoft.identity.common.java.util.TaskCompletedCallback
                public void onTaskCompleted(List<? extends ICacheRecord> result) {
                }
            }, PublicApiId.NATIVE_AUTH_GET_ACCOUNT)).get().getResult());
        }

        private final IAccount getAccountFromICacheRecordsList(List<? extends ICacheRecord> cacheRecords) {
            LogSession.INSTANCE.logMethodCall(getTAG$msal_distRelease(), null, getTAG$msal_distRelease() + ".getAccountFromICacheRecordsList(cacheRecords: List<ICacheRecord?>?)");
            List<? extends ICacheRecord> list = cacheRecords;
            if (list == null || list.isEmpty()) {
                return null;
            }
            List<IAccount> listAdapt = AccountAdapter.adapt(cacheRecords);
            Intrinsics.checkNotNullExpressionValue(listAdapt, "adapt(cacheRecords)");
            if (listAdapt.isEmpty()) {
                Logger.error(getTAG$msal_distRelease(), "Returned cacheRecords were adapted into empty or null IAccount list. This is unexpected in native auth mode.Returning null.", null);
                return null;
            }
            if (listAdapt.size() != 1) {
                Logger.warn(getTAG$msal_distRelease(), "Returned cacheRecords were adapted into multiple IAccount. This is unexpected in native auth mode.Returning the first adapted account.");
            }
            return listAdapt.get(0);
        }
    }

    static {
        String string = NativeAuthPublicClientApplication.class.toString();
        Intrinsics.checkNotNullExpressionValue(string, "NativeAuthPublicClientAp…on::class.java.toString()");
        TAG = string;
        pcaScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
    }

    private final void initializeApplication() throws MsalClientException {
        Context appContext = this.nativeAuthConfig.getAppContext();
        AzureActiveDirectory.setEnvironment(this.nativeAuthConfig.getEnvironment());
        Authority.addKnownAuthorities(this.nativeAuthConfig.getAuthorities());
        PublicClientApplication.initializeLoggerSettings(this.nativeAuthConfig.getLoggerConfiguration());
        PublicClientApplication.checkInternetPermission(this.nativeAuthConfig);
        HttpCache.initialize(appContext.getCacheDir());
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        companion.logMethodCall(str, null, str + ".initializeApplication");
    }

    private final void initializeSharedPreferenceFileManager(Context context) {
        this.sharedPreferencesFileManager = new SharedPreferencesFileManager(context, NATIVE_AUTH_CREDENTIAL_SHARED_PREFERENCES, new AndroidAuthSdkStorageEncryptionManager(context));
    }

    @Override // com.microsoft.identity.nativeauth.INativeAuthPublicClientApplication
    public void getCurrentAccount(GetCurrentAccountCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        companion.logMethodCall(str, null, str + ".getCurrentAccount(callback: GetCurrentAccountCallback)");
        BuildersKt__Builders_commonKt.launch$default(pcaScope, null, null, new C18191(callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$getCurrentAccount$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NativeAuthPublicClientApplication.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$getCurrentAccount$1", f = "NativeAuthPublicClientApplication.kt", i = {}, l = {245}, m = "invokeSuspend", n = {}, s = {})
    static final class C18191 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GetCurrentAccountCallback $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18191(GetCurrentAccountCallback getCurrentAccountCallback, Continuation<? super C18191> continuation) {
            super(2, continuation);
            this.$callback = getCurrentAccountCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NativeAuthPublicClientApplication.this.new C18191(this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18191) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = NativeAuthPublicClientApplication.this.getCurrentAccount(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((GetAccountResult) obj);
            } catch (MsalException e) {
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.microsoft.identity.nativeauth.INativeAuthPublicClientApplication
    public Object getCurrentAccount(Continuation<? super GetAccountResult> continuation) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        companion.logMethodCall(str, null, str + ".getCurrentAccount");
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass3(null), continuation);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$getCurrentAccount$3, reason: invalid class name */
    /* JADX INFO: compiled from: NativeAuthPublicClientApplication.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/GetAccountResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$getCurrentAccount$3", f = "NativeAuthPublicClientApplication.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super GetAccountResult>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NativeAuthPublicClientApplication.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super GetAccountResult> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    IAccount currentAccountInternal = NativeAuthPublicClientApplication.INSTANCE.getCurrentAccountInternal(NativeAuthPublicClientApplication.this.nativeAuthConfig);
                    if (currentAccountInternal != null) {
                        AccountState.Companion companion = AccountState.INSTANCE;
                        String threadCorrelationId = DiagnosticContext.INSTANCE.getThreadCorrelationId();
                        Intrinsics.checkNotNullExpressionValue(threadCorrelationId, "INSTANCE.threadCorrelationId");
                        return new GetAccountResult.AccountFound(companion.createFromAccountResult(currentAccountInternal, threadCorrelationId, NativeAuthPublicClientApplication.this.nativeAuthConfig));
                    }
                    return GetAccountResult.NoAccountFound.INSTANCE;
                } catch (Exception e) {
                    String threadCorrelationId2 = DiagnosticContext.INSTANCE.getThreadCorrelationId();
                    Intrinsics.checkNotNullExpressionValue(threadCorrelationId2, "threadCorrelationId");
                    return new GetAccountError("client_exception", null, "MSAL client exception occurred in getCurrentAccount.", threadCorrelationId2, null, e, 18, null);
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.microsoft.identity.nativeauth.INativeAuthPublicClientApplication
    @Deprecated(message = "This method is now deprecated. Use the method 'signIn(parameters:, callback:)' instead.")
    public void signIn(String username, char[] password, List<String> scopes, SignInCallback callback) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        companion.logMethodCall(str, null, str + ".signIn(username: String, password: CharArray?, scopes: List<String>?, callback: SignInCallback)");
        BuildersKt__Builders_commonKt.launch$default(pcaScope, null, null, new C18251(username, password, scopes, callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$signIn$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NativeAuthPublicClientApplication.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$signIn$1", f = "NativeAuthPublicClientApplication.kt", i = {}, l = {314}, m = "invokeSuspend", n = {}, s = {})
    static final class C18251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SignInCallback $callback;
        final /* synthetic */ char[] $password;
        final /* synthetic */ List<String> $scopes;
        final /* synthetic */ String $username;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18251(String str, char[] cArr, List<String> list, SignInCallback signInCallback, Continuation<? super C18251> continuation) {
            super(2, continuation);
            this.$username = str;
            this.$password = cArr;
            this.$scopes = list;
            this.$callback = signInCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NativeAuthPublicClientApplication.this.new C18251(this.$username, this.$password, this.$scopes, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18251) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = NativeAuthPublicClientApplication.this.internalSignIn(this.$username, this.$password, this.$scopes, null, this);
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
                Logger.error(NativeAuthPublicClientApplication.INSTANCE.getTAG$msal_distRelease(), "Exception thrown in signIn", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.microsoft.identity.nativeauth.INativeAuthPublicClientApplication
    public void signIn(NativeAuthSignInParameters parameters, SignInCallback callback) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        companion.logMethodCall(str, null, str + ".signIn(parameters: NativeAuthSignInParameters, callback: SignInCallback)");
        BuildersKt__Builders_commonKt.launch$default(pcaScope, null, null, new C18262(parameters, callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$signIn$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NativeAuthPublicClientApplication.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$signIn$2", f = "NativeAuthPublicClientApplication.kt", i = {}, l = {338}, m = "invokeSuspend", n = {}, s = {})
    static final class C18262 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SignInCallback $callback;
        final /* synthetic */ NativeAuthSignInParameters $parameters;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18262(NativeAuthSignInParameters nativeAuthSignInParameters, SignInCallback signInCallback, Continuation<? super C18262> continuation) {
            super(2, continuation);
            this.$parameters = nativeAuthSignInParameters;
            this.$callback = signInCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NativeAuthPublicClientApplication.this.new C18262(this.$parameters, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18262) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = NativeAuthPublicClientApplication.this.internalSignIn(this.$parameters.getUsername(), this.$parameters.getPassword(), this.$parameters.getScopes(), this.$parameters.getClaimsRequest(), this);
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
                Logger.error(NativeAuthPublicClientApplication.INSTANCE.getTAG$msal_distRelease(), "Exception thrown in signIn", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.microsoft.identity.nativeauth.INativeAuthPublicClientApplication
    @Deprecated(message = "This method is now deprecated. Use the method 'signIn(parameters:)' instead.")
    public Object signIn(String str, char[] cArr, List<String> list, Continuation<? super SignInResult> continuation) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str2 = TAG;
        companion.logMethodCall(str2, null, str2 + ".signIn(username: String, password: CharArray?, scopes: List<String>?)");
        return internalSignIn(str, cArr, list, null, continuation);
    }

    @Override // com.microsoft.identity.nativeauth.INativeAuthPublicClientApplication
    public Object signIn(NativeAuthSignInParameters nativeAuthSignInParameters, Continuation<? super SignInResult> continuation) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        companion.logMethodCall(str, null, str + ".signIn(parameters: NativeAuthSignInParameters)");
        return internalSignIn(nativeAuthSignInParameters.getUsername(), nativeAuthSignInParameters.getPassword(), nativeAuthSignInParameters.getScopes(), nativeAuthSignInParameters.getClaimsRequest(), continuation);
    }

    @Override // com.microsoft.identity.nativeauth.INativeAuthPublicClientApplication
    @Deprecated(message = "This method is now deprecated. Use the method 'signUp(parameters:, callback:)' instead.")
    public void signUp(String username, char[] password, UserAttributes attributes, SignUpCallback callback) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        companion.logMethodCall(str, null, str + ".signUp(username: String, password: CharArray?, attributes: UserAttributes?, callback: SignUpCallback)");
        BuildersKt__Builders_commonKt.launch$default(pcaScope, null, null, new C18271(password, username, attributes, callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$signUp$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NativeAuthPublicClientApplication.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$signUp$1", f = "NativeAuthPublicClientApplication.kt", i = {}, l = {412}, m = "invokeSuspend", n = {}, s = {})
    static final class C18271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UserAttributes $attributes;
        final /* synthetic */ SignUpCallback $callback;
        final /* synthetic */ char[] $password;
        final /* synthetic */ String $username;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18271(char[] cArr, String str, UserAttributes userAttributes, SignUpCallback signUpCallback, Continuation<? super C18271> continuation) {
            super(2, continuation);
            this.$password = cArr;
            this.$username = str;
            this.$attributes = userAttributes;
            this.$callback = signUpCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NativeAuthPublicClientApplication.this.new C18271(this.$password, this.$username, this.$attributes, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18271) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = NativeAuthPublicClientApplication.this.internalSignUp(this.$password, this.$username, this.$attributes, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((SignUpResult) obj);
            } catch (MsalException e) {
                Logger.error(NativeAuthPublicClientApplication.INSTANCE.getTAG$msal_distRelease(), "Exception thrown in signUp", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.microsoft.identity.nativeauth.INativeAuthPublicClientApplication
    public void signUp(NativeAuthSignUpParameters parameters, SignUpCallback callback) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        companion.logMethodCall(str, null, str + ".signUp(parameters: NativeAuthSignUpParameters, callback: SignUpCallback)");
        BuildersKt__Builders_commonKt.launch$default(pcaScope, null, null, new C18282(parameters, callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$signUp$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NativeAuthPublicClientApplication.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$signUp$2", f = "NativeAuthPublicClientApplication.kt", i = {}, l = {436}, m = "invokeSuspend", n = {}, s = {})
    static final class C18282 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SignUpCallback $callback;
        final /* synthetic */ NativeAuthSignUpParameters $parameters;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18282(NativeAuthSignUpParameters nativeAuthSignUpParameters, SignUpCallback signUpCallback, Continuation<? super C18282> continuation) {
            super(2, continuation);
            this.$parameters = nativeAuthSignUpParameters;
            this.$callback = signUpCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NativeAuthPublicClientApplication.this.new C18282(this.$parameters, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18282) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = NativeAuthPublicClientApplication.this.internalSignUp(this.$parameters.getPassword(), this.$parameters.getUsername(), this.$parameters.getAttributes(), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((SignUpResult) obj);
            } catch (MsalException e) {
                Logger.error(NativeAuthPublicClientApplication.INSTANCE.getTAG$msal_distRelease(), "Exception thrown in signUp", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.microsoft.identity.nativeauth.INativeAuthPublicClientApplication
    @Deprecated(message = "This method is now deprecated. Use the method 'signUp(parameters:)' instead.")
    public Object signUp(String str, char[] cArr, UserAttributes userAttributes, Continuation<? super SignUpResult> continuation) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str2 = TAG;
        companion.logMethodCall(str2, null, str2 + ".signUp(username: String, password: CharArray?, attributes: UserAttributes?)");
        return internalSignUp(cArr, str, userAttributes, continuation);
    }

    @Override // com.microsoft.identity.nativeauth.INativeAuthPublicClientApplication
    public Object signUp(NativeAuthSignUpParameters nativeAuthSignUpParameters, Continuation<? super SignUpResult> continuation) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        companion.logMethodCall(str, null, str + ".signUp(parameters: NativeAuthSignUpParameters)");
        return internalSignUp(nativeAuthSignUpParameters.getPassword(), nativeAuthSignUpParameters.getUsername(), nativeAuthSignUpParameters.getAttributes(), continuation);
    }

    @Override // com.microsoft.identity.nativeauth.INativeAuthPublicClientApplication
    @Deprecated(message = "This method is now deprecated. Use the method 'resetPassword(parameters:, callback:)' instead.")
    public void resetPassword(String username, ResetPasswordCallback callback) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        companion.logMethodCall(str, null, str + ".resetPassword(username: String, callback: ResetPasswordCallback)");
        BuildersKt__Builders_commonKt.launch$default(pcaScope, null, null, new C18231(username, callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$resetPassword$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NativeAuthPublicClientApplication.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$resetPassword$1", f = "NativeAuthPublicClientApplication.kt", i = {}, l = {503}, m = "invokeSuspend", n = {}, s = {})
    static final class C18231 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ResetPasswordCallback $callback;
        final /* synthetic */ String $username;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18231(String str, ResetPasswordCallback resetPasswordCallback, Continuation<? super C18231> continuation) {
            super(2, continuation);
            this.$username = str;
            this.$callback = resetPasswordCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NativeAuthPublicClientApplication.this.new C18231(this.$username, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18231) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = NativeAuthPublicClientApplication.this.internalResetPassword(this.$username, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((ResetPasswordStartResult) obj);
            } catch (MsalException e) {
                Logger.error(NativeAuthPublicClientApplication.INSTANCE.getTAG$msal_distRelease(), "Exception thrown in resetPassword", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.microsoft.identity.nativeauth.INativeAuthPublicClientApplication
    public void resetPassword(NativeAuthResetPasswordParameters parameters, ResetPasswordCallback callback) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        companion.logMethodCall(str, null, str + ".resetPassword(parameters: NativeAuthResetPasswordParameters, callback: ResetPasswordCallback)");
        BuildersKt__Builders_commonKt.launch$default(pcaScope, null, null, new C18242(parameters, callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$resetPassword$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NativeAuthPublicClientApplication.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$resetPassword$2", f = "NativeAuthPublicClientApplication.kt", i = {}, l = {530}, m = "invokeSuspend", n = {}, s = {})
    static final class C18242 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ResetPasswordCallback $callback;
        final /* synthetic */ NativeAuthResetPasswordParameters $parameters;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18242(NativeAuthResetPasswordParameters nativeAuthResetPasswordParameters, ResetPasswordCallback resetPasswordCallback, Continuation<? super C18242> continuation) {
            super(2, continuation);
            this.$parameters = nativeAuthResetPasswordParameters;
            this.$callback = resetPasswordCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NativeAuthPublicClientApplication.this.new C18242(this.$parameters, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18242) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = NativeAuthPublicClientApplication.this.internalResetPassword(this.$parameters.getUsername(), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((ResetPasswordStartResult) obj);
            } catch (MsalException e) {
                Logger.error(NativeAuthPublicClientApplication.INSTANCE.getTAG$msal_distRelease(), "Exception thrown in resetPassword", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.microsoft.identity.nativeauth.INativeAuthPublicClientApplication
    @Deprecated(message = "This method is now deprecated. Use the method 'resetPassword(parameters:)' instead.")
    public Object resetPassword(String str, Continuation<? super ResetPasswordStartResult> continuation) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str2 = TAG;
        companion.logMethodCall(str2, null, str2 + ".resetPassword(username: String)");
        return internalResetPassword(str, continuation);
    }

    @Override // com.microsoft.identity.nativeauth.INativeAuthPublicClientApplication
    public Object resetPassword(NativeAuthResetPasswordParameters nativeAuthResetPasswordParameters, Continuation<? super ResetPasswordStartResult> continuation) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        companion.logMethodCall(str, null, str + ".resetPassword(parameters: NativeAuthResetPasswordParameters)");
        return internalResetPassword(nativeAuthResetPasswordParameters.getUsername(), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void verifyNoUserIsSignedIn() throws ExecutionException, InterruptedException, MsalClientException {
        Boolean doesAccountExist = checkForPersistedAccount().get();
        Intrinsics.checkNotNullExpressionValue(doesAccountExist, "doesAccountExist");
        if (doesAccountExist.booleanValue()) {
            Logger.error(TAG, "An account is already signed in.", null);
            throw new MsalClientException(MsalClientException.INVALID_PARAMETER, "An account is already signed in.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ResultFuture<Boolean> checkForPersistedAccount() {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        companion.logMethodCall(str, null, str + ".checkForPersistedAccount");
        final ResultFuture<Boolean> resultFuture = new ResultFuture<>();
        getCurrentAccount(new GetCurrentAccountCallback() { // from class: com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication.checkForPersistedAccount.1
            @Override // com.microsoft.identity.nativeauth.statemachine.states.Callback
            public void onResult(GetAccountResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                resultFuture.setResult(Boolean.valueOf(result instanceof GetAccountResult.AccountFound));
            }

            @Override // com.microsoft.identity.nativeauth.statemachine.states.Callback
            public void onError(BaseException exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                BaseException baseException = exception;
                Logger.error(NativeAuthPublicClientApplication.INSTANCE.getTAG$msal_distRelease(), "Exception thrown in checkForPersistedAccount", baseException);
                resultFuture.setException(baseException);
            }
        });
        return resultFuture;
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$internalSignIn$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NativeAuthPublicClientApplication.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$internalSignIn$2", f = "NativeAuthPublicClientApplication.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C18212 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SignInResult>, Object> {
        final /* synthetic */ ClaimsRequest $claimsRequest;
        final /* synthetic */ char[] $password;
        final /* synthetic */ List<String> $scopes;
        final /* synthetic */ String $username;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18212(String str, char[] cArr, List<String> list, ClaimsRequest claimsRequest, Continuation<? super C18212> continuation) {
            super(2, continuation);
            this.$username = str;
            this.$password = cArr;
            this.$scopes = list;
            this.$claimsRequest = claimsRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NativeAuthPublicClientApplication.this.new C18212(this.$username, this.$password, this.$scopes, this.$claimsRequest, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SignInResult> continuation) {
            return ((C18212) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            INativeAuthCommandResult.APIError aPIError;
            INativeAuthCommandResult.APIError aPIError2;
            SignInError signInError;
            SignInError signInError2;
            String message;
            Exception exc;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    NativeAuthPublicClientApplication.this.verifyNoUserIsSignedIn();
                    if (StringsKt.isBlank(this.$username)) {
                        return new SignInError(ErrorTypes.INVALID_USERNAME, null, "Empty or blank username", TelemetryEventStrings.Value.UNSET, null, null, 50, null);
                    }
                    char[] cArr = this.$password;
                    boolean z = false;
                    if (cArr != null) {
                        if (!(cArr.length == 0)) {
                            z = true;
                        }
                    }
                    SignInStartCommandParameters params = CommandParametersAdapter.createSignInStartCommandParameters(NativeAuthPublicClientApplication.this.nativeAuthConfig, NativeAuthPublicClientApplication.this.nativeAuthConfig.getOAuth2TokenCache(), this.$username, this.$password, this.$scopes, this.$claimsRequest);
                    Intrinsics.checkNotNullExpressionValue(params, "params");
                    CommandResult rawCommandResult = CommandDispatcher.submitSilentReturningFuture(new SignInStartCommand(params, new NativeAuthMsalController(), z ? PublicApiId.NATIVE_AUTH_SIGN_IN_WITH_EMAIL_PASSWORD : PublicApiId.NATIVE_AUTH_SIGN_IN_WITH_EMAIL)).get();
                    try {
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
                                        throw new NullPointerException("null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.SignInStartCommandResult");
                                    }
                                    aPIError = (SignInStartCommandResult) result2;
                                    aPIError2 = aPIError;
                                } catch (ClassCastException unused) {
                                    String str2 = "Type casting error: result of " + rawCommandResult + " is not of type " + Reflection.getOrCreateKotlinClass(SignInStartCommandResult.class) + ", but of type " + Reflection.getOrCreateKotlinClass(result2.getClass()) + ", even though the command was marked as COMPLETED";
                                    String correlationId3 = rawCommandResult.getCorrelationId();
                                    Intrinsics.checkNotNullExpressionValue(correlationId3, "this.correlationId");
                                    aPIError = new INativeAuthCommandResult.APIError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, str2, null, correlationId3, null, null, 52, null);
                                }
                            }
                        }
                        SignInStartCommandResult signInStartCommandResult = (SignInStartCommandResult) aPIError2;
                        if (signInStartCommandResult instanceof SignInCommandResult.Complete) {
                            if (z) {
                                IAuthenticationResult authenticationResult = AuthenticationResultAdapter.adapt(((SignInCommandResult.Complete) signInStartCommandResult).getAuthenticationResult());
                                AccountState.Companion companion = AccountState.INSTANCE;
                                Intrinsics.checkNotNullExpressionValue(authenticationResult, "authenticationResult");
                                signInError = new SignInResult.Complete(companion.createFromAuthenticationResult(authenticationResult, signInStartCommandResult.getCorrelationId(), NativeAuthPublicClientApplication.this.nativeAuthConfig));
                            } else {
                                Logger.warnWithObject(NativeAuthPublicClientApplication.INSTANCE.getTAG$msal_distRelease(), signInStartCommandResult.getCorrelationId(), "Sign in received unexpected result: ", signInStartCommandResult);
                                signInError = new SignInError(null, ErrorTypes.INVALID_STATE, "unexpected state", signInStartCommandResult.getCorrelationId(), null, null, 49, null);
                            }
                        } else if (signInStartCommandResult instanceof SignInCommandResult.CodeRequired) {
                            Logger.warn(NativeAuthPublicClientApplication.INSTANCE.getTAG$msal_distRelease(), signInStartCommandResult.getCorrelationId(), "Server requires a code");
                            signInError = new SignInResult.CodeRequired(new SignInCodeRequiredState(((SignInCommandResult.CodeRequired) signInStartCommandResult).getContinuationToken(), signInStartCommandResult.getCorrelationId(), this.$username, this.$scopes, params.claimsRequestJson, NativeAuthPublicClientApplication.this.nativeAuthConfig), ((SignInCommandResult.CodeRequired) signInStartCommandResult).getCodeLength(), ((SignInCommandResult.CodeRequired) signInStartCommandResult).getChallengeTargetLabel(), ((SignInCommandResult.CodeRequired) signInStartCommandResult).getChallengeChannel());
                        } else if (signInStartCommandResult instanceof INativeAuthCommandResult.InvalidUsername) {
                            signInError = new SignInError(ErrorTypes.INVALID_USERNAME, ((INativeAuthCommandResult.InvalidUsername) signInStartCommandResult).getError(), ((INativeAuthCommandResult.InvalidUsername) signInStartCommandResult).getErrorDescription(), signInStartCommandResult.getCorrelationId(), ((INativeAuthCommandResult.InvalidUsername) signInStartCommandResult).getErrorCodes(), null, 32, null);
                        } else if (signInStartCommandResult instanceof SignInCommandResult.PasswordRequired) {
                            if (z) {
                                Logger.warnWithObject(NativeAuthPublicClientApplication.INSTANCE.getTAG$msal_distRelease(), "Sign in using password received unexpected result: ", signInStartCommandResult);
                                signInError = new SignInError(null, ErrorTypes.INVALID_STATE, "unexpected state", signInStartCommandResult.getCorrelationId(), null, null, 49, null);
                            } else {
                                signInError = new SignInResult.PasswordRequired(new SignInPasswordRequiredState(((SignInCommandResult.PasswordRequired) signInStartCommandResult).getContinuationToken(), signInStartCommandResult.getCorrelationId(), this.$username, this.$scopes, params.claimsRequestJson, NativeAuthPublicClientApplication.this.nativeAuthConfig));
                            }
                        } else if (signInStartCommandResult instanceof SignInCommandResult.UserNotFound) {
                            signInError = new SignInError(ErrorTypes.USER_NOT_FOUND, ((SignInCommandResult.UserNotFound) signInStartCommandResult).getError(), ((SignInCommandResult.UserNotFound) signInStartCommandResult).getErrorDescription(), signInStartCommandResult.getCorrelationId(), ((SignInCommandResult.UserNotFound) signInStartCommandResult).getErrorCodes(), null, 32, null);
                        } else if (signInStartCommandResult instanceof SignInCommandResult.InvalidCredentials) {
                            if (z) {
                                signInError2 = new SignInError(SignInErrorTypes.INVALID_CREDENTIALS, ((SignInCommandResult.InvalidCredentials) signInStartCommandResult).getError(), ((SignInCommandResult.InvalidCredentials) signInStartCommandResult).getErrorDescription(), signInStartCommandResult.getCorrelationId(), ((SignInCommandResult.InvalidCredentials) signInStartCommandResult).getErrorCodes(), null, 32, null);
                            } else {
                                Logger.warnWithObject(NativeAuthPublicClientApplication.INSTANCE.getTAG$msal_distRelease(), "Sign in received Unexpected result: ", signInStartCommandResult);
                                signInError2 = new SignInError(null, ErrorTypes.INVALID_STATE, "unexpected state", signInStartCommandResult.getCorrelationId(), ((SignInCommandResult.InvalidCredentials) signInStartCommandResult).getErrorCodes(), null, 33, null);
                            }
                            signInError = signInError2;
                        } else if (signInStartCommandResult instanceof SignInCommandResult.MFARequired) {
                            signInError = new SignInResult.MFARequired(new AwaitingMFAState(((SignInCommandResult.MFARequired) signInStartCommandResult).getContinuationToken(), signInStartCommandResult.getCorrelationId(), this.$scopes, NativeAuthPublicClientApplication.this.nativeAuthConfig), AuthMethodKt.toListOfAuthMethods(((SignInCommandResult.MFARequired) signInStartCommandResult).getAuthMethods()));
                        } else if (signInStartCommandResult instanceof SignInCommandResult.StrongAuthMethodRegistrationRequired) {
                            signInError = new SignInResult.StrongAuthMethodRegistrationRequired(new RegisterStrongAuthState(((SignInCommandResult.StrongAuthMethodRegistrationRequired) signInStartCommandResult).getContinuationToken(), signInStartCommandResult.getCorrelationId(), NativeAuthPublicClientApplication.this.nativeAuthConfig), AuthMethodKt.toListOfAuthMethods(((SignInCommandResult.StrongAuthMethodRegistrationRequired) signInStartCommandResult).getAuthMethods()));
                        } else if (signInStartCommandResult instanceof INativeAuthCommandResult.Redirect) {
                            signInError = new SignInError(ErrorTypes.BROWSER_REQUIRED, ((INativeAuthCommandResult.Redirect) signInStartCommandResult).getError(), ((INativeAuthCommandResult.Redirect) signInStartCommandResult).getErrorDescription(), signInStartCommandResult.getCorrelationId(), null, null, 48, null);
                        } else if (signInStartCommandResult instanceof INativeAuthCommandResult.APIError) {
                            signInError = new SignInError(null, ((INativeAuthCommandResult.APIError) signInStartCommandResult).getError(), ((INativeAuthCommandResult.APIError) signInStartCommandResult).getErrorDescription(), signInStartCommandResult.getCorrelationId(), ((INativeAuthCommandResult.APIError) signInStartCommandResult).getErrorCodes(), ((INativeAuthCommandResult.APIError) signInStartCommandResult).getException(), 1, null);
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                        StringUtil.overwriteWithNull(params.password);
                        return signInError;
                    } catch (Throwable th) {
                        StringUtil.overwriteWithNull(params.password);
                        throw th;
                    }
                } catch (Exception e) {
                    return new SignInError("client_exception", null, "MSAL client exception occurred in signIn.", TelemetryEventStrings.Value.UNSET, null, e, 18, null);
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object internalSignIn(String str, char[] cArr, List<String> list, ClaimsRequest claimsRequest, Continuation<? super SignInResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C18212(str, cArr, list, claimsRequest, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:11:0x000f  */
    public final Object internalSignUp(char[] cArr, String str, UserAttributes userAttributes, Continuation<? super SignUpResult> continuation) {
        boolean z;
        if (cArr == null) {
            z = false;
        } else {
            if (!(cArr.length == 0)) {
                z = true;
            } else {
                z = false;
            }
        }
        return BuildersKt.withContext(Dispatchers.getIO(), new C18222(str, cArr, userAttributes, z, null), continuation);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$internalSignUp$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NativeAuthPublicClientApplication.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$internalSignUp$2", f = "NativeAuthPublicClientApplication.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C18222 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SignUpResult>, Object> {
        final /* synthetic */ UserAttributes $attributes;
        final /* synthetic */ boolean $hasPassword;
        final /* synthetic */ char[] $password;
        final /* synthetic */ String $username;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18222(String str, char[] cArr, UserAttributes userAttributes, boolean z, Continuation<? super C18222> continuation) {
            super(2, continuation);
            this.$username = str;
            this.$password = cArr;
            this.$attributes = userAttributes;
            this.$hasPassword = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NativeAuthPublicClientApplication.this.new C18222(this.$username, this.$password, this.$attributes, this.$hasPassword, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SignUpResult> continuation) {
            return ((C18222) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            INativeAuthCommandResult.APIError aPIError;
            INativeAuthCommandResult.APIError aPIError2;
            SignUpError signUpError;
            SignUpError signUpError2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    Boolean doesAccountExist = (Boolean) NativeAuthPublicClientApplication.this.checkForPersistedAccount().get();
                    Intrinsics.checkNotNullExpressionValue(doesAccountExist, "doesAccountExist");
                    if (doesAccountExist.booleanValue()) {
                        throw new MsalClientException(MsalClientException.INVALID_PARAMETER, "An account is already signed in.");
                    }
                    if (!StringsKt.isBlank(this.$username)) {
                        NativeAuthPublicClientApplicationConfiguration nativeAuthPublicClientApplicationConfiguration = NativeAuthPublicClientApplication.this.nativeAuthConfig;
                        OAuth2TokenCache oAuth2TokenCache = NativeAuthPublicClientApplication.this.nativeAuthConfig.getOAuth2TokenCache();
                        String str = this.$username;
                        char[] cArr = this.$password;
                        UserAttributes userAttributes = this.$attributes;
                        Exception exc = null;
                        SignUpStartCommandParameters parameters = CommandParametersAdapter.createSignUpStartCommandParameters(nativeAuthPublicClientApplicationConfiguration, oAuth2TokenCache, str, cArr, userAttributes != null ? UserAttributesKt.toMap(userAttributes) : null);
                        Intrinsics.checkNotNullExpressionValue(parameters, "parameters");
                        CommandResult rawCommandResult = CommandDispatcher.submitSilentReturningFuture(new SignUpStartCommand(parameters, new NativeAuthMsalController(), PublicApiId.NATIVE_AUTH_SIGN_UP_START)).get();
                        try {
                            Intrinsics.checkNotNullExpressionValue(rawCommandResult, "rawCommandResult");
                            if (rawCommandResult.getStatus() != ICommandResult.ResultStatus.COMPLETED) {
                                String message = "";
                                if (rawCommandResult.getResult() instanceof Exception) {
                                    Object result = rawCommandResult.getResult();
                                    Intrinsics.checkNotNull(result, "null cannot be cast to non-null type java.lang.Exception{ kotlin.TypeAliasesKt.Exception }");
                                    exc = (Exception) result;
                                    message = exc.getMessage();
                                }
                                Exception exc2 = exc;
                                String correlationId = rawCommandResult.getCorrelationId();
                                Intrinsics.checkNotNullExpressionValue(correlationId, "correlationId");
                                aPIError2 = new INativeAuthCommandResult.APIError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, message, null, correlationId, null, exc2, 20, null);
                            } else {
                                Object result2 = rawCommandResult.getResult();
                                if (result2 instanceof Exception) {
                                    String str2 = "Type casting error: result of " + rawCommandResult + " is of type Exception, even though the command was marked as COMPLETED";
                                    String correlationId2 = rawCommandResult.getCorrelationId();
                                    Intrinsics.checkNotNullExpressionValue(correlationId2, "this.correlationId");
                                    aPIError2 = new INativeAuthCommandResult.APIError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, str2, null, correlationId2, null, null, 52, null);
                                } else {
                                    try {
                                        if (result2 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpStartCommandResult");
                                        }
                                        aPIError = (SignUpStartCommandResult) result2;
                                        aPIError2 = aPIError;
                                    } catch (ClassCastException unused) {
                                        String str3 = "Type casting error: result of " + rawCommandResult + " is not of type " + Reflection.getOrCreateKotlinClass(SignUpStartCommandResult.class) + ", but of type " + Reflection.getOrCreateKotlinClass(result2.getClass()) + ", even though the command was marked as COMPLETED";
                                        String correlationId3 = rawCommandResult.getCorrelationId();
                                        Intrinsics.checkNotNullExpressionValue(correlationId3, "this.correlationId");
                                        aPIError = new INativeAuthCommandResult.APIError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, str3, null, correlationId3, null, null, 52, null);
                                    }
                                }
                            }
                            SignUpStartCommandResult signUpStartCommandResult = (SignUpStartCommandResult) aPIError2;
                            if (signUpStartCommandResult instanceof SignUpCommandResult.Complete) {
                                signUpError = new SignUpResult.Complete(new SignInContinuationState(((SignUpCommandResult.Complete) signUpStartCommandResult).getContinuationToken(), signUpStartCommandResult.getCorrelationId(), this.$username, NativeAuthPublicClientApplication.this.nativeAuthConfig));
                            } else if (signUpStartCommandResult instanceof SignUpCommandResult.AttributesRequired) {
                                signUpError = new SignUpResult.AttributesRequired(new SignUpAttributesRequiredState(((SignUpCommandResult.AttributesRequired) signUpStartCommandResult).getContinuationToken(), signUpStartCommandResult.getCorrelationId(), this.$username, NativeAuthPublicClientApplication.this.nativeAuthConfig), RequiredUserAttributeKt.toListOfRequiredUserAttribute(((SignUpCommandResult.AttributesRequired) signUpStartCommandResult).getRequiredAttributes()));
                            } else if (signUpStartCommandResult instanceof SignUpCommandResult.CodeRequired) {
                                signUpError = new SignUpResult.CodeRequired(new SignUpCodeRequiredState(((SignUpCommandResult.CodeRequired) signUpStartCommandResult).getContinuationToken(), signUpStartCommandResult.getCorrelationId(), this.$username, NativeAuthPublicClientApplication.this.nativeAuthConfig), ((SignUpCommandResult.CodeRequired) signUpStartCommandResult).getCodeLength(), ((SignUpCommandResult.CodeRequired) signUpStartCommandResult).getChallengeTargetLabel(), ((SignUpCommandResult.CodeRequired) signUpStartCommandResult).getChallengeChannel());
                            } else if (signUpStartCommandResult instanceof SignUpCommandResult.PasswordRequired) {
                                if (this.$hasPassword) {
                                    Logger.warnWithObject(NativeAuthPublicClientApplication.INSTANCE.getTAG$msal_distRelease(), signUpStartCommandResult.getCorrelationId(), "Sign up using password received unexpected result: ", signUpStartCommandResult);
                                    signUpError = new SignUpError(null, ErrorTypes.INVALID_STATE, "Unexpected state", signUpStartCommandResult.getCorrelationId(), null, null, 49, null);
                                } else {
                                    signUpError = new SignUpResult.PasswordRequired(new SignUpPasswordRequiredState(((SignUpCommandResult.PasswordRequired) signUpStartCommandResult).getContinuationToken(), signUpStartCommandResult.getCorrelationId(), this.$username, NativeAuthPublicClientApplication.this.nativeAuthConfig));
                                }
                            } else if (signUpStartCommandResult instanceof SignUpCommandResult.AuthNotSupported) {
                                signUpError = new SignUpError(SignUpErrorTypes.AUTH_NOT_SUPPORTED, ((SignUpCommandResult.AuthNotSupported) signUpStartCommandResult).getError(), ((SignUpCommandResult.AuthNotSupported) signUpStartCommandResult).getErrorDescription(), signUpStartCommandResult.getCorrelationId(), null, null, 48, null);
                            } else if (signUpStartCommandResult instanceof SignUpCommandResult.InvalidPassword) {
                                if (this.$hasPassword) {
                                    signUpError2 = new SignUpError(ErrorTypes.INVALID_PASSWORD, ((SignUpCommandResult.InvalidPassword) signUpStartCommandResult).getError(), ((SignUpCommandResult.InvalidPassword) signUpStartCommandResult).getErrorDescription(), signUpStartCommandResult.getCorrelationId(), null, null, 48, null);
                                } else {
                                    Logger.warnWithObject(NativeAuthPublicClientApplication.INSTANCE.getTAG$msal_distRelease(), signUpStartCommandResult.getCorrelationId(), "Sign up received unexpected result: ", signUpStartCommandResult);
                                    signUpError2 = new SignUpError(null, ErrorTypes.INVALID_STATE, "Unexpected state", signUpStartCommandResult.getCorrelationId(), null, null, 49, null);
                                }
                                signUpError = signUpError2;
                            } else if (signUpStartCommandResult instanceof SignUpCommandResult.UsernameAlreadyExists) {
                                signUpError = new SignUpError(SignUpErrorTypes.USER_ALREADY_EXISTS, ((SignUpCommandResult.UsernameAlreadyExists) signUpStartCommandResult).getError(), ((SignUpCommandResult.UsernameAlreadyExists) signUpStartCommandResult).getErrorDescription(), signUpStartCommandResult.getCorrelationId(), null, null, 48, null);
                            } else if (signUpStartCommandResult instanceof INativeAuthCommandResult.InvalidUsername) {
                                signUpError = new SignUpError(ErrorTypes.INVALID_USERNAME, ((INativeAuthCommandResult.InvalidUsername) signUpStartCommandResult).getError(), ((INativeAuthCommandResult.InvalidUsername) signUpStartCommandResult).getErrorDescription(), signUpStartCommandResult.getCorrelationId(), null, null, 48, null);
                            } else if (signUpStartCommandResult instanceof SignUpCommandResult.InvalidAttributes) {
                                signUpError = new SignUpError(SignUpErrorTypes.INVALID_ATTRIBUTES, ((SignUpCommandResult.InvalidAttributes) signUpStartCommandResult).getError(), ((SignUpCommandResult.InvalidAttributes) signUpStartCommandResult).getErrorDescription(), signUpStartCommandResult.getCorrelationId(), null, null, 48, null);
                            } else if (signUpStartCommandResult instanceof INativeAuthCommandResult.Redirect) {
                                signUpError = new SignUpError(ErrorTypes.BROWSER_REQUIRED, ((INativeAuthCommandResult.Redirect) signUpStartCommandResult).getError(), ((INativeAuthCommandResult.Redirect) signUpStartCommandResult).getErrorDescription(), signUpStartCommandResult.getCorrelationId(), null, null, 48, null);
                            } else if (signUpStartCommandResult instanceof INativeAuthCommandResult.APIError) {
                                signUpError = new SignUpError(null, ErrorTypes.INVALID_STATE, "Unexpected state", signUpStartCommandResult.getCorrelationId(), null, null, 49, null);
                            } else {
                                throw new NoWhenBranchMatchedException();
                            }
                            StringUtil.overwriteWithNull(parameters.password);
                            return signUpError;
                        } catch (Throwable th) {
                            StringUtil.overwriteWithNull(parameters.password);
                            throw th;
                        }
                    }
                    return new SignUpError(ErrorTypes.INVALID_USERNAME, null, "Empty or blank username", TelemetryEventStrings.Value.UNSET, null, null, 50, null);
                } catch (Exception e) {
                    return new SignUpError("client_exception", null, "MSAL client exception occurred in signIn.", TelemetryEventStrings.Value.UNSET, null, e, 18, null);
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object internalResetPassword(String str, Continuation<? super ResetPasswordStartResult> continuation) {
        C18201 c18201;
        if (continuation instanceof C18201) {
            c18201 = (C18201) continuation;
            if ((c18201.label & Integer.MIN_VALUE) != 0) {
                c18201.label -= Integer.MIN_VALUE;
            } else {
                c18201 = new C18201(continuation);
            }
        } else {
            c18201 = new C18201(continuation);
        }
        Object obj = c18201.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c18201.label;
        try {
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher io2 = Dispatchers.getIO();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(str, null);
            c18201.label = 1;
            Object objWithContext = BuildersKt.withContext(io2, anonymousClass2, c18201);
            return objWithContext == coroutine_suspended ? coroutine_suspended : objWithContext;
        } catch (Exception e) {
            return new ResetPasswordError("client_exception", null, "MSAL client exception occurred in resetPassword.", TelemetryEventStrings.Value.UNSET, null, e, 18, null);
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$internalResetPassword$2, reason: invalid class name */
    /* JADX INFO: compiled from: NativeAuthPublicClientApplication.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordStartResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$internalResetPassword$2", f = "NativeAuthPublicClientApplication.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ResetPasswordStartResult>, Object> {
        final /* synthetic */ String $username;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$username = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NativeAuthPublicClientApplication.this.new AnonymousClass2(this.$username, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ResetPasswordStartResult> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws MsalClientException {
            INativeAuthCommandResult.APIError aPIError;
            INativeAuthCommandResult.APIError aPIError2;
            Exception exc;
            String message;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Boolean doesAccountExist = (Boolean) NativeAuthPublicClientApplication.this.checkForPersistedAccount().get();
                Intrinsics.checkNotNullExpressionValue(doesAccountExist, "doesAccountExist");
                if (doesAccountExist.booleanValue()) {
                    throw new MsalClientException(MsalClientException.INVALID_PARAMETER, "An account is already signed in.");
                }
                if (StringsKt.isBlank(this.$username)) {
                    return new ResetPasswordError(ErrorTypes.INVALID_USERNAME, null, "Empty or blank username", TelemetryEventStrings.Value.UNSET, null, null, 50, null);
                }
                ResetPasswordStartCommandParameters parameters = CommandParametersAdapter.createResetPasswordStartCommandParameters(NativeAuthPublicClientApplication.this.nativeAuthConfig, NativeAuthPublicClientApplication.this.nativeAuthConfig.getOAuth2TokenCache(), this.$username);
                Intrinsics.checkNotNullExpressionValue(parameters, "parameters");
                CommandResult rawCommandResult = CommandDispatcher.submitSilentReturningFuture(new ResetPasswordStartCommand(parameters, new NativeAuthMsalController(), PublicApiId.NATIVE_AUTH_RESET_PASSWORD_START)).get();
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
                                throw new NullPointerException("null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordStartCommandResult");
                            }
                            aPIError = (ResetPasswordStartCommandResult) result2;
                            aPIError2 = aPIError;
                        } catch (ClassCastException unused) {
                            String str = "Type casting error: result of " + rawCommandResult + " is not of type " + Reflection.getOrCreateKotlinClass(ResetPasswordStartCommandResult.class) + ", but of type " + Reflection.getOrCreateKotlinClass(result2.getClass()) + ", even though the command was marked as COMPLETED";
                            String correlationId3 = rawCommandResult.getCorrelationId();
                            Intrinsics.checkNotNullExpressionValue(correlationId3, "this.correlationId");
                            aPIError = new INativeAuthCommandResult.APIError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, str, null, correlationId3, null, null, 52, null);
                        }
                    }
                }
                ResetPasswordStartCommandResult resetPasswordStartCommandResult = (ResetPasswordStartCommandResult) aPIError2;
                if (resetPasswordStartCommandResult instanceof ResetPasswordCommandResult.CodeRequired) {
                    ResetPasswordCommandResult.CodeRequired codeRequired = (ResetPasswordCommandResult.CodeRequired) resetPasswordStartCommandResult;
                    return new ResetPasswordStartResult.CodeRequired(new ResetPasswordCodeRequiredState(codeRequired.getContinuationToken(), resetPasswordStartCommandResult.getCorrelationId(), this.$username, NativeAuthPublicClientApplication.this.nativeAuthConfig), codeRequired.getCodeLength(), codeRequired.getChallengeTargetLabel(), codeRequired.getChallengeChannel());
                }
                if (resetPasswordStartCommandResult instanceof ResetPasswordCommandResult.UserNotFound) {
                    ResetPasswordCommandResult.UserNotFound userNotFound = (ResetPasswordCommandResult.UserNotFound) resetPasswordStartCommandResult;
                    return new ResetPasswordError(ErrorTypes.USER_NOT_FOUND, userNotFound.getError(), userNotFound.getErrorDescription(), resetPasswordStartCommandResult.getCorrelationId(), null, null, 48, null);
                }
                if (resetPasswordStartCommandResult instanceof INativeAuthCommandResult.InvalidUsername) {
                    INativeAuthCommandResult.InvalidUsername invalidUsername = (INativeAuthCommandResult.InvalidUsername) resetPasswordStartCommandResult;
                    return new ResetPasswordError(ErrorTypes.INVALID_USERNAME, invalidUsername.getError(), invalidUsername.getErrorDescription(), resetPasswordStartCommandResult.getCorrelationId(), invalidUsername.getErrorCodes(), null, 32, null);
                }
                if (resetPasswordStartCommandResult instanceof INativeAuthCommandResult.APIError) {
                    INativeAuthCommandResult.APIError aPIError3 = (INativeAuthCommandResult.APIError) resetPasswordStartCommandResult;
                    return new ResetPasswordError(null, aPIError3.getError(), aPIError3.getErrorDescription(), resetPasswordStartCommandResult.getCorrelationId(), null, aPIError3.getException(), 17, null);
                }
                if (resetPasswordStartCommandResult instanceof INativeAuthCommandResult.Redirect) {
                    INativeAuthCommandResult.Redirect redirect = (INativeAuthCommandResult.Redirect) resetPasswordStartCommandResult;
                    return new ResetPasswordError(ErrorTypes.BROWSER_REQUIRED, redirect.getError(), redirect.getErrorDescription(), resetPasswordStartCommandResult.getCorrelationId(), null, null, 48, null);
                }
                if (resetPasswordStartCommandResult instanceof ResetPasswordCommandResult.PasswordNotSet) {
                    Logger.warnWithObject(NativeAuthPublicClientApplication.INSTANCE.getTAG$msal_distRelease(), resetPasswordStartCommandResult.getCorrelationId(), "Reset password received unexpected result: ", resetPasswordStartCommandResult);
                    return new ResetPasswordError(null, ErrorTypes.INVALID_STATE, "Unexpected state", resetPasswordStartCommandResult.getCorrelationId(), null, null, 49, null);
                }
                if (!(resetPasswordStartCommandResult instanceof ResetPasswordCommandResult.EmailNotVerified)) {
                    throw new NoWhenBranchMatchedException();
                }
                Logger.warnWithObject(NativeAuthPublicClientApplication.INSTANCE.getTAG$msal_distRelease(), resetPasswordStartCommandResult.getCorrelationId(), "Reset password received unexpected result: ", resetPasswordStartCommandResult);
                return new ResetPasswordError(null, ErrorTypes.INVALID_STATE, "Unexpected state", resetPasswordStartCommandResult.getCorrelationId(), null, null, 49, null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
