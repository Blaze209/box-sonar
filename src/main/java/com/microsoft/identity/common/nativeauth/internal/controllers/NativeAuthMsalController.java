package com.microsoft.identity.common.nativeauth.internal.controllers;

import android.text.TextUtils;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.microsoft.identity.common.internal.commands.RefreshOnCommand;
import com.microsoft.identity.common.internal.telemetry.Telemetry;
import com.microsoft.identity.common.internal.telemetry.events.ApiEndEvent;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.cache.ICacheRecord;
import com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters;
import com.microsoft.identity.common.java.configuration.LibraryConfiguration;
import com.microsoft.identity.common.java.controllers.CommandDispatcher;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.eststelemetry.PublicApiId;
import com.microsoft.identity.common.java.exception.ArgumentException;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.authorities.NativeAuthCIAMAuthority;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.JITChallengeAuthMethodCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.JITContinueCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.JITIntrospectCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.MFAChallengeAuthMethodCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.MFASubmitChallengeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordResendCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordStartCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordSubmitCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordSubmitNewPasswordCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInResendCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInStartCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInSubmitCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInSubmitPasswordCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInWithContinuationTokenCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpResendCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpStartCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitPasswordCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitUserAttributesCommandParameters;
import com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.JITChallengeAuthMethodCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.JITCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.JITSubmitChallengeCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.MFAChallengeCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.MFACommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.MFASubmitChallengeCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordResendCodeCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordStartCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordSubmitCodeCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordSubmitNewPasswordCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInResendCodeCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInStartCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInSubmitCodeCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInSubmitPasswordCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInWithContinuationTokenCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpResendCodeCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpStartCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpSubmitCodeCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpSubmitPasswordCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpSubmitUserAttributesCommandResult;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthOAuth2Strategy;
import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.jit.JITChallengeApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.jit.JITContinueApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.jit.JITIntrospectApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordChallengeApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordContinueApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordPollCompletionApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordStartApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordSubmitApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInChallengeApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInInitiateApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInIntrospectApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInTokenApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signup.SignUpChallengeApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signup.SignUpContinueApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signup.SignUpStartApiResult;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache;
import com.microsoft.identity.common.java.request.SdkType;
import com.microsoft.identity.common.java.result.AcquireTokenResult;
import com.microsoft.identity.common.java.result.LocalAuthenticationResult;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.ThreadUtils;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import com.microsoft.identity.common.nativeauth.internal.util.CommandUtil;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: NativeAuthMsalController.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u008c\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u008f\u00012\u00020\u0001:\u0002\u008f\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\rH\u0002J.\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0002J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0015H\u0002J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\rJ\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u001dH\u0007J \u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0002J\u0018\u0010\"\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0018H\u0002J\u0018\u0010$\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\rH\u0002J(\u0010&\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020(2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0002J\u0018\u0010)\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020*H\u0002J\u0018\u0010+\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020,H\u0007J \u0010-\u001a\u00020.2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0002J\u0018\u0010/\u001a\u0002002\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u000201H\u0002J \u00102\u001a\u0002032\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0002J\u0018\u00104\u001a\u0002052\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u000206H\u0002J\u0018\u00107\u001a\u0002082\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u000209H\u0002J \u0010:\u001a\u00020;2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0002J\u0018\u0010<\u001a\u00020=2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020>H\u0002J(\u0010?\u001a\u00020;2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\u0006\u0010@\u001a\u00020\tH\u0002J \u0010A\u001a\u00020B2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0002J\u0018\u0010C\u001a\u00020D2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020EH\u0007J\u0018\u0010F\u001a\u00020G2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020HH\u0002J\u0018\u0010I\u001a\u00020G2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020JH\u0002J\u0018\u0010K\u001a\u00020G2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020LH\u0007J\u0018\u0010M\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020NH\u0002J*\u0010O\u001a\u00020P2\u0006\u0010\u001c\u001a\u00020\u00112\b\u0010Q\u001a\u0004\u0018\u00010>2\u0006\u0010R\u001a\u00020;2\u0006\u0010S\u001a\u00020TH\u0002J.\u0010U\u001a\u00020P2\u0006\u0010V\u001a\u00020=2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010>2\u0006\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010S\u001a\u00020TH\u0007J(\u0010W\u001a\u00020X2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\u0006\u0010Y\u001a\u00020ZH\u0002J\u000e\u0010[\u001a\u00020\\2\u0006\u0010\u0005\u001a\u00020]J\u000e\u0010^\u001a\u00020_2\u0006\u0010\u0005\u001a\u000206J\u000e\u0010`\u001a\u00020a2\u0006\u0010\u0005\u001a\u000201J\u000e\u0010b\u001a\u00020X2\u0006\u0010\u0005\u001a\u000209J \u0010c\u001a\u00020d2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010Q\u001a\u00020(2\u0006\u0010e\u001a\u00020fH\u0002J&\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u00062\f\u0010j\u001a\b\u0012\u0004\u0012\u00020k0\bH\u0002J\u000e\u0010l\u001a\u00020m2\u0006\u0010\u0005\u001a\u00020nJ\u000e\u0010o\u001a\u00020p2\u0006\u0010\u0005\u001a\u00020qJ\u000e\u0010r\u001a\u00020P2\u0006\u0010\u0005\u001a\u00020>J\u000e\u0010s\u001a\u00020t2\u0006\u0010\u0005\u001a\u00020NJ\u000e\u0010u\u001a\u00020v2\u0006\u0010\u0005\u001a\u00020*J\u000e\u0010w\u001a\u00020x2\u0006\u0010\u0005\u001a\u00020,J\u000e\u0010y\u001a\u00020z2\u0006\u0010\u0005\u001a\u00020\u001dJ\u000e\u0010{\u001a\u00020|2\u0006\u0010\u0005\u001a\u00020}J\u000e\u0010~\u001a\u00020\u007f2\u0006\u0010\u0005\u001a\u00020EJ\u0010\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0006\u0010\u0005\u001a\u00020HJ\u0010\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0006\u0010\u0005\u001a\u00020JJ\u0010\u0010\u0084\u0001\u001a\u00030\u0085\u00012\u0006\u0010\u0005\u001a\u00020LJ\r\u0010\u0086\u0001\u001a\u00020\u0017*\u00020\fH\u0002J\r\u0010\u0087\u0001\u001a\u00020_*\u00020.H\u0002J\r\u0010\u0088\u0001\u001a\u00020P*\u00020'H\u0002J\r\u0010\u0088\u0001\u001a\u00020P*\u00020\u001fH\u0002J\u001d\u0010\u0088\u0001\u001a\u00020P*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010Q\u001a\u00020>H\u0002J\u001d\u0010\u0089\u0001\u001a\u00020x*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010Q\u001a\u00020,H\u0002J\r\u0010\u008a\u0001\u001a\u00020\u007f*\u00020BH\u0002J\u0016\u0010\u008b\u0001\u001a\u00030\u0081\u0001*\u00020G2\u0006\u0010\u001c\u001a\u00020\u0011H\u0002J\u0016\u0010\u008c\u0001\u001a\u00030\u0083\u0001*\u00020G2\u0006\u0010\u001c\u001a\u00020\u0011H\u0002J\u0016\u0010\u008d\u0001\u001a\u00030\u0085\u0001*\u00020G2\u0006\u0010\u001c\u001a\u00020\u0011H\u0002J\u000e\u0010\u008e\u0001\u001a\u00030\u0085\u0001*\u00020BH\u0002¨\u0006\u0090\u0001"}, d2 = {"Lcom/microsoft/identity/common/nativeauth/internal/controllers/NativeAuthMsalController;", "Lcom/microsoft/identity/common/nativeauth/internal/controllers/BaseNativeAuthController;", "()V", "acquireTokenSilent", "Lcom/microsoft/identity/common/java/result/AcquireTokenResult;", "parameters", "Lcom/microsoft/identity/common/java/commands/parameters/SilentTokenCommandParameters;", "addDefaultScopes", "", "", "scopes", "completeJITFlow", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/JITSubmitChallengeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/JITContinueCommandParameters;", "createAuthorizationRequest", "Lcom/microsoft/identity/common/java/providers/microsoft/microsoftsts/MicrosoftStsAuthorizationRequest;", "strategy", "Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthOAuth2Strategy;", "clientId", "applicationIdentifier", "createOAuth2Strategy", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/BaseNativeAuthCommandParameters;", "jitChallengeAuthMethod", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/JITChallengeAuthMethodCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/JITChallengeAuthMethodCommandParameters;", "jitSubmitChallenge", "performContinuationTokenTokenRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult;", "oAuth2Strategy", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInWithContinuationTokenCommandParameters;", "performIntrospectCall", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInIntrospectApiResult;", "continuationToken", "correlationId", "performJITChallengeCall", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/jit/JITChallengeApiResult;", "performJITContinueCall", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/jit/JITContinueApiResult;", "performJITIntrospect", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/jit/JITIntrospectApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/BaseSignInTokenCommandParameters;", "performOOBTokenRequest", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInSubmitCodeCommandParameters;", "performPasswordTokenCall", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInSubmitPasswordCommandParameters;", "performResetPasswordChallengeCall", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordChallengeApiResult;", "performResetPasswordContinueCall", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordContinueApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/ResetPasswordSubmitCodeCommandParameters;", "performResetPasswordPollCompletionCall", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordPollCompletionApiResult;", "performResetPasswordStartCall", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordStartApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/ResetPasswordStartCommandParameters;", "performResetPasswordSubmitCall", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordSubmitApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/ResetPasswordSubmitNewPasswordCommandParameters;", "performSignInChallengeCall", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInChallengeApiResult;", "performSignInInitiateCall", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInInitiateApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInStartCommandParameters;", "performSignInSelectedAuthMethodCall", "authMethodId", "performSignUpChallengeCall", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpChallengeApiResult;", "performSignUpStartUsingPasswordRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpStartCommandParameters;", "performSignUpSubmitCode", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpSubmitCodeCommandParameters;", "performSignUpSubmitPassword", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpSubmitPasswordCommandParameters;", "performSignUpSubmitUserAttributes", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpSubmitUserAttributesCommandParameters;", "performSubmitChallengeTokenRequest", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/MFASubmitChallengeCommandParameters;", "processSignInChallengeCall", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInStartCommandResult;", "parametersWithScopes", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "usePassword", "", "processSignInInitiateApiResult", "initiateApiResult", "resetPasswordPollCompletion", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordSubmitNewPasswordCommandResult;", "pollIntervalInSeconds", "", "resetPasswordResendCode", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordResendCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/ResetPasswordResendCodeCommandParameters;", "resetPasswordStart", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordStartCommandResult;", "resetPasswordSubmitCode", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordSubmitCodeCommandResult;", "resetPasswordSubmitNewPassword", "saveAndReturnTokens", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInCommandResult$Complete;", "tokenApiResult", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$Success;", "setAcquireTokenResult", "", "acquireTokenSilentResult", "cacheRecords", "Lcom/microsoft/identity/common/java/cache/ICacheRecord;", "signInChallenge", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/MFAChallengeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/MFAChallengeAuthMethodCommandParameters;", "signInResendCode", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInResendCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInResendCodeCommandParameters;", "signInStart", "signInSubmitChallenge", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/MFASubmitChallengeCommandResult;", "signInSubmitCode", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInSubmitCodeCommandResult;", "signInSubmitPassword", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInSubmitPasswordCommandResult;", "signInWithContinuationToken", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInWithContinuationTokenCommandResult;", "signUpResendCode", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpResendCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpResendCodeCommandParameters;", "signUpStart", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpStartCommandResult;", "signUpSubmitCode", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitCodeCommandResult;", "signUpSubmitPassword", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitPasswordCommandResult;", "signUpSubmitUserAttributes", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitUserAttributesCommandResult;", "toJITChallengeAuthMethodCommandResult", "toResetPasswordStartCommandResult", "toSignInStartCommandResult", "toSignInSubmitPasswordCommandResult", "toSignUpStartCommandResult", "toSignUpSubmitCodeCommandResult", "toSignUpSubmitPasswordCommandResult", "toSignUpSubmitUserAttributesCommandResult", "toSignUpSubmitUserAttrsCommandResult", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NativeAuthMsalController extends BaseNativeAuthController {
    private static final String TAG = "NativeAuthMsalController";

    public final SignInStartCommandResult signInStart(SignInStartCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".signInStart");
        try {
            NativeAuthOAuth2Strategy nativeAuthOAuth2StrategyCreateOAuth2Strategy = createOAuth2Strategy(parameters);
            SignInInitiateApiResult signInInitiateApiResultPerformSignInInitiateCall = performSignInInitiateCall(nativeAuthOAuth2StrategyCreateOAuth2Strategy, parameters);
            char[] cArr = parameters.password;
            if (cArr != null) {
                if (!(cArr.length == 0)) {
                    Logger.verbose(TAG2, parameters.getCorrelationId(), "Parameters has password");
                    SignInStartCommandParameters signInStartCommandParametersCreateSignInStartCommandParametersWithScopes = CommandUtil.createSignInStartCommandParametersWithScopes(parameters, addDefaultScopes(parameters.scopes));
                    try {
                        return processSignInInitiateApiResult(signInInitiateApiResultPerformSignInInitiateCall, signInStartCommandParametersCreateSignInStartCommandParametersWithScopes, nativeAuthOAuth2StrategyCreateOAuth2Strategy, true);
                    } finally {
                        StringUtil.overwriteWithNull(signInStartCommandParametersCreateSignInStartCommandParametersWithScopes.password);
                    }
                }
            }
            Logger.verbose(TAG2, parameters.getCorrelationId(), "Parameters doesn't have password");
            return processSignInInitiateApiResult$default(this, signInInitiateApiResultPerformSignInInitiateCall, null, nativeAuthOAuth2StrategyCreateOAuth2Strategy, false, 10, null);
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in signInStart", e);
            throw e;
        }
    }

    public final SignInWithContinuationTokenCommandResult signInWithContinuationToken(SignInWithContinuationTokenCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".signInWithContinuationToken");
        try {
            NativeAuthOAuth2Strategy nativeAuthOAuth2StrategyCreateOAuth2Strategy = createOAuth2Strategy(parameters);
            SignInWithContinuationTokenCommandParameters parametersWithScopes = CommandUtil.createSignInWithContinuationTokenCommandParametersWithScopes(parameters, addDefaultScopes(parameters.scopes));
            Intrinsics.checkNotNullExpressionValue(parametersWithScopes, "parametersWithScopes");
            ApiResult apiResultPerformContinuationTokenTokenRequest = performContinuationTokenTokenRequest(nativeAuthOAuth2StrategyCreateOAuth2Strategy, parametersWithScopes);
            if (apiResultPerformContinuationTokenTokenRequest instanceof SignInTokenApiResult.Success) {
                return saveAndReturnTokens(nativeAuthOAuth2StrategyCreateOAuth2Strategy, parametersWithScopes, (SignInTokenApiResult.Success) apiResultPerformContinuationTokenTokenRequest);
            }
            if (apiResultPerformContinuationTokenTokenRequest instanceof SignInTokenApiResult.MFARequired) {
                SignInStartCommandResult signInStartCommandResult = toSignInStartCommandResult(performIntrospectCall(nativeAuthOAuth2StrategyCreateOAuth2Strategy, ((SignInTokenApiResult.MFARequired) apiResultPerformContinuationTokenTokenRequest).getContinuationToken(), apiResultPerformContinuationTokenTokenRequest.getCorrelationId()));
                Intrinsics.checkNotNull(signInStartCommandResult, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.SignInWithContinuationTokenCommandResult");
                return (SignInWithContinuationTokenCommandResult) signInStartCommandResult;
            }
            if (apiResultPerformContinuationTokenTokenRequest instanceof SignInTokenApiResult.JITRequired) {
                SignInStartCommandResult signInStartCommandResult2 = toSignInStartCommandResult(performJITIntrospect(nativeAuthOAuth2StrategyCreateOAuth2Strategy, parametersWithScopes, ((SignInTokenApiResult.JITRequired) apiResultPerformContinuationTokenTokenRequest).getContinuationToken(), apiResultPerformContinuationTokenTokenRequest.getCorrelationId()));
                Intrinsics.checkNotNull(signInStartCommandResult2, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.SignInWithContinuationTokenCommandResult");
                return (SignInWithContinuationTokenCommandResult) signInStartCommandResult2;
            }
            if (apiResultPerformContinuationTokenTokenRequest instanceof SignInTokenApiResult.Redirect) {
                return new INativeAuthCommandResult.Redirect(apiResultPerformContinuationTokenTokenRequest.getCorrelationId(), ((SignInTokenApiResult.Redirect) apiResultPerformContinuationTokenTokenRequest).getRedirectReason());
            }
            boolean z = true;
            if (!(apiResultPerformContinuationTokenTokenRequest instanceof SignInTokenApiResult.InvalidAuthenticationType ? true : apiResultPerformContinuationTokenTokenRequest instanceof SignInTokenApiResult.CodeIncorrect ? true : apiResultPerformContinuationTokenTokenRequest instanceof SignInTokenApiResult.UserNotFound ? true : apiResultPerformContinuationTokenTokenRequest instanceof SignInTokenApiResult.InvalidCredentials)) {
                z = apiResultPerformContinuationTokenTokenRequest instanceof SignInTokenApiResult.UnknownError;
            }
            if (!z) {
                throw new NoWhenBranchMatchedException();
            }
            Logger.warnWithObject(TAG2, apiResultPerformContinuationTokenTokenRequest.getCorrelationId(), "Unexpected result: ", apiResultPerformContinuationTokenTokenRequest);
            Intrinsics.checkNotNull(apiResultPerformContinuationTokenTokenRequest, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
            return new INativeAuthCommandResult.APIError(((ApiErrorResult) apiResultPerformContinuationTokenTokenRequest).getError(), ((ApiErrorResult) apiResultPerformContinuationTokenTokenRequest).getErrorDescription(), null, apiResultPerformContinuationTokenTokenRequest.getCorrelationId(), ((ApiErrorResult) apiResultPerformContinuationTokenTokenRequest).getErrorCodes(), null, 36, null);
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in signInWithContinuationToken", e);
            throw e;
        }
    }

    public final SignInSubmitCodeCommandResult signInSubmitCode(SignInSubmitCodeCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".signInSubmitCode");
        try {
            SignInSubmitCodeCommandParameters parametersWithScopes = CommandUtil.createSignInSubmitCodeCommandParametersWithScopes(parameters, addDefaultScopes(parameters.scopes));
            NativeAuthOAuth2Strategy nativeAuthOAuth2StrategyCreateOAuth2Strategy = createOAuth2Strategy(parameters);
            Intrinsics.checkNotNullExpressionValue(parametersWithScopes, "parametersWithScopes");
            ApiResult apiResultPerformOOBTokenRequest = performOOBTokenRequest(nativeAuthOAuth2StrategyCreateOAuth2Strategy, parametersWithScopes);
            if (apiResultPerformOOBTokenRequest instanceof SignInTokenApiResult.Success) {
                return saveAndReturnTokens(nativeAuthOAuth2StrategyCreateOAuth2Strategy, parametersWithScopes, (SignInTokenApiResult.Success) apiResultPerformOOBTokenRequest);
            }
            if (apiResultPerformOOBTokenRequest instanceof SignInTokenApiResult.CodeIncorrect) {
                return new SignInCommandResult.IncorrectCode(apiResultPerformOOBTokenRequest.getCorrelationId(), ((SignInTokenApiResult.CodeIncorrect) apiResultPerformOOBTokenRequest).getError(), ((SignInTokenApiResult.CodeIncorrect) apiResultPerformOOBTokenRequest).getErrorDescription(), ((SignInTokenApiResult.CodeIncorrect) apiResultPerformOOBTokenRequest).getErrorCodes(), ((SignInTokenApiResult.CodeIncorrect) apiResultPerformOOBTokenRequest).getSubError());
            }
            if (apiResultPerformOOBTokenRequest instanceof SignInTokenApiResult.Redirect) {
                return new INativeAuthCommandResult.Redirect(apiResultPerformOOBTokenRequest.getCorrelationId(), ((SignInTokenApiResult.Redirect) apiResultPerformOOBTokenRequest).getRedirectReason());
            }
            if (apiResultPerformOOBTokenRequest instanceof SignInTokenApiResult.MFARequired) {
                SignInStartCommandResult signInStartCommandResult = toSignInStartCommandResult(performIntrospectCall(nativeAuthOAuth2StrategyCreateOAuth2Strategy, ((SignInTokenApiResult.MFARequired) apiResultPerformOOBTokenRequest).getContinuationToken(), apiResultPerformOOBTokenRequest.getCorrelationId()));
                Intrinsics.checkNotNull(signInStartCommandResult, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.SignInSubmitCodeCommandResult");
                return (SignInSubmitCodeCommandResult) signInStartCommandResult;
            }
            if (apiResultPerformOOBTokenRequest instanceof SignInTokenApiResult.JITRequired) {
                SignInStartCommandResult signInStartCommandResult2 = toSignInStartCommandResult(performJITIntrospect(nativeAuthOAuth2StrategyCreateOAuth2Strategy, parametersWithScopes, ((SignInTokenApiResult.JITRequired) apiResultPerformOOBTokenRequest).getContinuationToken(), apiResultPerformOOBTokenRequest.getCorrelationId()));
                Intrinsics.checkNotNull(signInStartCommandResult2, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.SignInSubmitCodeCommandResult");
                return (SignInSubmitCodeCommandResult) signInStartCommandResult2;
            }
            boolean z = true;
            if (!(apiResultPerformOOBTokenRequest instanceof SignInTokenApiResult.UnknownError ? true : apiResultPerformOOBTokenRequest instanceof SignInTokenApiResult.InvalidAuthenticationType ? true : apiResultPerformOOBTokenRequest instanceof SignInTokenApiResult.InvalidCredentials)) {
                z = apiResultPerformOOBTokenRequest instanceof SignInTokenApiResult.UserNotFound;
            }
            if (!z) {
                throw new NoWhenBranchMatchedException();
            }
            Logger.warnWithObject(TAG2, apiResultPerformOOBTokenRequest.getCorrelationId(), "Unexpected result: ", apiResultPerformOOBTokenRequest);
            Intrinsics.checkNotNull(apiResultPerformOOBTokenRequest, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
            return new INativeAuthCommandResult.APIError(((ApiErrorResult) apiResultPerformOOBTokenRequest).getError(), ((ApiErrorResult) apiResultPerformOOBTokenRequest).getErrorDescription(), null, apiResultPerformOOBTokenRequest.getCorrelationId(), ((ApiErrorResult) apiResultPerformOOBTokenRequest).getErrorCodes(), null, 36, null);
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in signInSubmitCode", e);
            throw e;
        }
    }

    public final MFASubmitChallengeCommandResult signInSubmitChallenge(MFASubmitChallengeCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".signInSubmitChallenge");
        try {
            MFASubmitChallengeCommandParameters parametersWithScopes = CommandUtil.createMFASubmitChallengeCommandParametersWithScopes(parameters, addDefaultScopes(parameters.scopes));
            NativeAuthOAuth2Strategy nativeAuthOAuth2StrategyCreateOAuth2Strategy = createOAuth2Strategy(parameters);
            Intrinsics.checkNotNullExpressionValue(parametersWithScopes, "parametersWithScopes");
            ApiResult apiResultPerformSubmitChallengeTokenRequest = performSubmitChallengeTokenRequest(nativeAuthOAuth2StrategyCreateOAuth2Strategy, parametersWithScopes);
            if (apiResultPerformSubmitChallengeTokenRequest instanceof SignInTokenApiResult.Success) {
                return saveAndReturnTokens(nativeAuthOAuth2StrategyCreateOAuth2Strategy, parametersWithScopes, (SignInTokenApiResult.Success) apiResultPerformSubmitChallengeTokenRequest);
            }
            if (apiResultPerformSubmitChallengeTokenRequest instanceof SignInTokenApiResult.CodeIncorrect) {
                return new SignInCommandResult.IncorrectCode(apiResultPerformSubmitChallengeTokenRequest.getCorrelationId(), ((SignInTokenApiResult.CodeIncorrect) apiResultPerformSubmitChallengeTokenRequest).getError(), ((SignInTokenApiResult.CodeIncorrect) apiResultPerformSubmitChallengeTokenRequest).getErrorDescription(), ((SignInTokenApiResult.CodeIncorrect) apiResultPerformSubmitChallengeTokenRequest).getErrorCodes(), ((SignInTokenApiResult.CodeIncorrect) apiResultPerformSubmitChallengeTokenRequest).getSubError());
            }
            if (apiResultPerformSubmitChallengeTokenRequest instanceof SignInTokenApiResult.Redirect) {
                return new INativeAuthCommandResult.Redirect(apiResultPerformSubmitChallengeTokenRequest.getCorrelationId(), ((SignInTokenApiResult.Redirect) apiResultPerformSubmitChallengeTokenRequest).getRedirectReason());
            }
            boolean z = true;
            if (!(apiResultPerformSubmitChallengeTokenRequest instanceof SignInTokenApiResult.UnknownError ? true : apiResultPerformSubmitChallengeTokenRequest instanceof SignInTokenApiResult.InvalidAuthenticationType ? true : apiResultPerformSubmitChallengeTokenRequest instanceof SignInTokenApiResult.InvalidCredentials ? true : apiResultPerformSubmitChallengeTokenRequest instanceof SignInTokenApiResult.UserNotFound ? true : apiResultPerformSubmitChallengeTokenRequest instanceof SignInTokenApiResult.MFARequired)) {
                z = apiResultPerformSubmitChallengeTokenRequest instanceof SignInTokenApiResult.JITRequired;
            }
            if (!z) {
                throw new NoWhenBranchMatchedException();
            }
            Logger.warnWithObject(TAG2, apiResultPerformSubmitChallengeTokenRequest.getCorrelationId(), "Unexpected result: ", apiResultPerformSubmitChallengeTokenRequest);
            Intrinsics.checkNotNull(apiResultPerformSubmitChallengeTokenRequest, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
            return new INativeAuthCommandResult.APIError(((ApiErrorResult) apiResultPerformSubmitChallengeTokenRequest).getError(), ((ApiErrorResult) apiResultPerformSubmitChallengeTokenRequest).getErrorDescription(), null, apiResultPerformSubmitChallengeTokenRequest.getCorrelationId(), ((ApiErrorResult) apiResultPerformSubmitChallengeTokenRequest).getErrorCodes(), null, 36, null);
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in signInSubmitChallenge()", e);
            throw e;
        }
    }

    public final SignInResendCodeCommandResult signInResendCode(SignInResendCodeCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".signInResendCode");
        try {
            NativeAuthOAuth2Strategy nativeAuthOAuth2StrategyCreateOAuth2Strategy = createOAuth2Strategy(parameters);
            String str = parameters.continuationToken;
            Intrinsics.checkNotNullExpressionValue(str, "parameters.continuationToken");
            String correlationId = parameters.getCorrelationId();
            Intrinsics.checkNotNullExpressionValue(correlationId, "parameters.correlationId");
            ApiResult apiResultPerformSignInChallengeCall = performSignInChallengeCall(nativeAuthOAuth2StrategyCreateOAuth2Strategy, str, correlationId);
            if (apiResultPerformSignInChallengeCall instanceof SignInChallengeApiResult.OOBRequired) {
                return new SignInCommandResult.CodeRequired(apiResultPerformSignInChallengeCall.getCorrelationId(), ((SignInChallengeApiResult.OOBRequired) apiResultPerformSignInChallengeCall).getContinuationToken(), ((SignInChallengeApiResult.OOBRequired) apiResultPerformSignInChallengeCall).getChallengeTargetLabel(), ((SignInChallengeApiResult.OOBRequired) apiResultPerformSignInChallengeCall).getChallengeChannel(), ((SignInChallengeApiResult.OOBRequired) apiResultPerformSignInChallengeCall).getCodeLength());
            }
            if (apiResultPerformSignInChallengeCall instanceof SignInChallengeApiResult.PasswordRequired ? true : apiResultPerformSignInChallengeCall instanceof SignInChallengeApiResult.BlockedAuthMethod) {
                Logger.warnWithObject(TAG2, apiResultPerformSignInChallengeCall.getCorrelationId(), "Unexpected result: ", apiResultPerformSignInChallengeCall);
                return new INativeAuthCommandResult.APIError("unexpected_api_result", "API returned unexpected result: " + apiResultPerformSignInChallengeCall, null, apiResultPerformSignInChallengeCall.getCorrelationId(), null, null, 52, null);
            }
            if (apiResultPerformSignInChallengeCall instanceof SignInChallengeApiResult.Redirect) {
                return new INativeAuthCommandResult.Redirect(apiResultPerformSignInChallengeCall.getCorrelationId(), ((SignInChallengeApiResult.Redirect) apiResultPerformSignInChallengeCall).getRedirectReason());
            }
            if (!(apiResultPerformSignInChallengeCall instanceof SignInChallengeApiResult.UnknownError)) {
                throw new NoWhenBranchMatchedException();
            }
            Logger.warnWithObject(TAG2, "Unexpected result: ", apiResultPerformSignInChallengeCall);
            Intrinsics.checkNotNull(apiResultPerformSignInChallengeCall, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
            return new INativeAuthCommandResult.APIError(((SignInChallengeApiResult.UnknownError) apiResultPerformSignInChallengeCall).getError(), ((SignInChallengeApiResult.UnknownError) apiResultPerformSignInChallengeCall).getErrorDescription(), null, apiResultPerformSignInChallengeCall.getCorrelationId(), ((SignInChallengeApiResult.UnknownError) apiResultPerformSignInChallengeCall).getErrorCodes(), null, 36, null);
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in signInResendCode", e);
            throw e;
        }
    }

    public final SignInSubmitPasswordCommandResult signInSubmitPassword(SignInSubmitPasswordCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".signInSubmitPassword");
        try {
            NativeAuthOAuth2Strategy nativeAuthOAuth2StrategyCreateOAuth2Strategy = createOAuth2Strategy(parameters);
            SignInSubmitPasswordCommandParameters parametersWithScopes = CommandUtil.createSignInSubmitPasswordCommandParametersWithScopes(parameters, parameters.getCorrelationId(), addDefaultScopes(parameters.scopes));
            try {
                Intrinsics.checkNotNullExpressionValue(parametersWithScopes, "parametersWithScopes");
                return toSignInSubmitPasswordCommandResult(performPasswordTokenCall(nativeAuthOAuth2StrategyCreateOAuth2Strategy, parametersWithScopes), nativeAuthOAuth2StrategyCreateOAuth2Strategy, parametersWithScopes);
            } finally {
                StringUtil.overwriteWithNull(parametersWithScopes.password);
            }
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in signInSubmitPassword", e);
            throw e;
        }
    }

    public final MFAChallengeCommandResult signInChallenge(MFAChallengeAuthMethodCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".signInChallenge()");
        try {
            NativeAuthOAuth2Strategy nativeAuthOAuth2StrategyCreateOAuth2Strategy = createOAuth2Strategy(parameters);
            String str = parameters.continuationToken;
            Intrinsics.checkNotNullExpressionValue(str, "parameters.continuationToken");
            String correlationId = parameters.getCorrelationId();
            Intrinsics.checkNotNullExpressionValue(correlationId, "parameters.correlationId");
            String str2 = parameters.authMethodId;
            Intrinsics.checkNotNullExpressionValue(str2, "parameters.authMethodId");
            SignInChallengeApiResult signInChallengeApiResultPerformSignInSelectedAuthMethodCall = performSignInSelectedAuthMethodCall(nativeAuthOAuth2StrategyCreateOAuth2Strategy, str, correlationId, str2);
            if (signInChallengeApiResultPerformSignInSelectedAuthMethodCall instanceof SignInChallengeApiResult.OOBRequired) {
                return new MFACommandResult.VerificationRequired(signInChallengeApiResultPerformSignInSelectedAuthMethodCall.getCorrelationId(), ((SignInChallengeApiResult.OOBRequired) signInChallengeApiResultPerformSignInSelectedAuthMethodCall).getContinuationToken(), ((SignInChallengeApiResult.OOBRequired) signInChallengeApiResultPerformSignInSelectedAuthMethodCall).getChallengeTargetLabel(), ((SignInChallengeApiResult.OOBRequired) signInChallengeApiResultPerformSignInSelectedAuthMethodCall).getChallengeChannel(), ((SignInChallengeApiResult.OOBRequired) signInChallengeApiResultPerformSignInSelectedAuthMethodCall).getCodeLength());
            }
            if (signInChallengeApiResultPerformSignInSelectedAuthMethodCall instanceof SignInChallengeApiResult.Redirect) {
                return new INativeAuthCommandResult.Redirect(signInChallengeApiResultPerformSignInSelectedAuthMethodCall.getCorrelationId(), ((SignInChallengeApiResult.Redirect) signInChallengeApiResultPerformSignInSelectedAuthMethodCall).getRedirectReason());
            }
            if (signInChallengeApiResultPerformSignInSelectedAuthMethodCall instanceof SignInChallengeApiResult.PasswordRequired) {
                Logger.warnWithObject(TAG2, signInChallengeApiResultPerformSignInSelectedAuthMethodCall.getCorrelationId(), "Unexpected result: ", signInChallengeApiResultPerformSignInSelectedAuthMethodCall);
                return new INativeAuthCommandResult.APIError("unexpected_api_result", "API returned unexpected result: " + signInChallengeApiResultPerformSignInSelectedAuthMethodCall, null, signInChallengeApiResultPerformSignInSelectedAuthMethodCall.getCorrelationId(), null, null, 52, null);
            }
            if (signInChallengeApiResultPerformSignInSelectedAuthMethodCall instanceof SignInChallengeApiResult.UnknownError) {
                Logger.warnWithObject(TAG2, "Unexpected result: ", signInChallengeApiResultPerformSignInSelectedAuthMethodCall);
                return new INativeAuthCommandResult.APIError(((SignInChallengeApiResult.UnknownError) signInChallengeApiResultPerformSignInSelectedAuthMethodCall).getError(), ((SignInChallengeApiResult.UnknownError) signInChallengeApiResultPerformSignInSelectedAuthMethodCall).getErrorDescription(), null, signInChallengeApiResultPerformSignInSelectedAuthMethodCall.getCorrelationId(), ((SignInChallengeApiResult.UnknownError) signInChallengeApiResultPerformSignInSelectedAuthMethodCall).getErrorCodes(), null, 36, null);
            }
            if (!(signInChallengeApiResultPerformSignInSelectedAuthMethodCall instanceof SignInChallengeApiResult.BlockedAuthMethod)) {
                throw new NoWhenBranchMatchedException();
            }
            return new MFACommandResult.BlockedAuthMethod(signInChallengeApiResultPerformSignInSelectedAuthMethodCall.getCorrelationId(), ((SignInChallengeApiResult.BlockedAuthMethod) signInChallengeApiResultPerformSignInSelectedAuthMethodCall).getError(), "Strong authentication method blocked. Reach out to customer support to seek assistance." + ((SignInChallengeApiResult.BlockedAuthMethod) signInChallengeApiResultPerformSignInSelectedAuthMethodCall).getErrorDescription(), ((SignInChallengeApiResult.BlockedAuthMethod) signInChallengeApiResultPerformSignInSelectedAuthMethodCall).getErrorCodes());
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in signInChallenge()", e);
            throw e;
        }
    }

    public final JITChallengeAuthMethodCommandResult jitChallengeAuthMethod(JITChallengeAuthMethodCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".jitChallengeAuthMethod");
        try {
            JITChallengeApiResult jITChallengeApiResultPerformJITChallengeCall = performJITChallengeCall(createOAuth2Strategy(parameters), parameters);
            if (jITChallengeApiResultPerformJITChallengeCall instanceof JITChallengeApiResult.InvalidVerificationContact) {
                return new JITCommandResult.IncorrectVerificationContact(jITChallengeApiResultPerformJITChallengeCall.getCorrelationId(), ((JITChallengeApiResult.InvalidVerificationContact) jITChallengeApiResultPerformJITChallengeCall).getError(), ((JITChallengeApiResult.InvalidVerificationContact) jITChallengeApiResultPerformJITChallengeCall).getErrorDescription(), ((JITChallengeApiResult.InvalidVerificationContact) jITChallengeApiResultPerformJITChallengeCall).getErrorCodes());
            }
            if (jITChallengeApiResultPerformJITChallengeCall instanceof JITChallengeApiResult.BlockedVerificationContact) {
                return new JITCommandResult.BlockedVerificationContact(jITChallengeApiResultPerformJITChallengeCall.getCorrelationId(), ((JITChallengeApiResult.BlockedVerificationContact) jITChallengeApiResultPerformJITChallengeCall).getError(), "Verification contact blocked. Please try using another email or phone number, or select an alternative authentication method." + ((JITChallengeApiResult.BlockedVerificationContact) jITChallengeApiResultPerformJITChallengeCall).getErrorDescription(), ((JITChallengeApiResult.BlockedVerificationContact) jITChallengeApiResultPerformJITChallengeCall).getErrorCodes());
            }
            if (jITChallengeApiResultPerformJITChallengeCall instanceof JITChallengeApiResult.OOBRequired) {
                return new JITCommandResult.VerificationRequired(jITChallengeApiResultPerformJITChallengeCall.getCorrelationId(), ((JITChallengeApiResult.OOBRequired) jITChallengeApiResultPerformJITChallengeCall).getContinuationToken(), ((JITChallengeApiResult.OOBRequired) jITChallengeApiResultPerformJITChallengeCall).getChallengeTargetLabel(), ((JITChallengeApiResult.OOBRequired) jITChallengeApiResultPerformJITChallengeCall).getChallengeChannel(), ((JITChallengeApiResult.OOBRequired) jITChallengeApiResultPerformJITChallengeCall).getCodeLength());
            }
            if (jITChallengeApiResultPerformJITChallengeCall instanceof JITChallengeApiResult.UnknownError) {
                Logger.warnWithObject(TAG2, "Unexpected result: ", jITChallengeApiResultPerformJITChallengeCall);
                return new INativeAuthCommandResult.APIError(((JITChallengeApiResult.UnknownError) jITChallengeApiResultPerformJITChallengeCall).getError(), ((JITChallengeApiResult.UnknownError) jITChallengeApiResultPerformJITChallengeCall).getErrorDescription(), null, jITChallengeApiResultPerformJITChallengeCall.getCorrelationId(), ((JITChallengeApiResult.UnknownError) jITChallengeApiResultPerformJITChallengeCall).getErrorCodes(), null, 36, null);
            }
            if (jITChallengeApiResultPerformJITChallengeCall instanceof JITChallengeApiResult.Preverified) {
                JITContinueCommandParameters jitContinueParams = CommandUtil.createJITContinueCommandParameters(parameters, jITChallengeApiResultPerformJITChallengeCall.getCorrelationId(), NativeAuthConstants.GrantType.CONTINUATION_TOKEN, ((JITChallengeApiResult.Preverified) jITChallengeApiResultPerformJITChallengeCall).getContinuationToken());
                Intrinsics.checkNotNullExpressionValue(jitContinueParams, "jitContinueParams");
                return toJITChallengeAuthMethodCommandResult(completeJITFlow(jitContinueParams));
            }
            if (jITChallengeApiResultPerformJITChallengeCall instanceof JITChallengeApiResult.Redirect) {
                return new INativeAuthCommandResult.Redirect(jITChallengeApiResultPerformJITChallengeCall.getCorrelationId(), ((JITChallengeApiResult.Redirect) jITChallengeApiResultPerformJITChallengeCall).getRedirectReason());
            }
            throw new NoWhenBranchMatchedException();
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in signInSubmitPassword", e);
            throw e;
        }
    }

    public final JITSubmitChallengeCommandResult jitSubmitChallenge(JITContinueCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".jitSubmitChallenge");
        return completeJITFlow(parameters);
    }

    public final SignUpStartCommandResult signUpStart(SignUpStartCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".signUpStart");
        try {
            NativeAuthOAuth2Strategy nativeAuthOAuth2StrategyCreateOAuth2Strategy = createOAuth2Strategy(parameters);
            ApiResult apiResultPerformSignUpStartUsingPasswordRequest = performSignUpStartUsingPasswordRequest(nativeAuthOAuth2StrategyCreateOAuth2Strategy, parameters);
            if (apiResultPerformSignUpStartUsingPasswordRequest instanceof SignUpStartApiResult.Success) {
                return toSignUpStartCommandResult(performSignUpChallengeCall(nativeAuthOAuth2StrategyCreateOAuth2Strategy, ((SignUpStartApiResult.Success) apiResultPerformSignUpStartUsingPasswordRequest).getContinuationToken(), apiResultPerformSignUpStartUsingPasswordRequest.getCorrelationId()));
            }
            if (apiResultPerformSignUpStartUsingPasswordRequest instanceof SignUpStartApiResult.InvalidPassword) {
                return new SignUpCommandResult.InvalidPassword(apiResultPerformSignUpStartUsingPasswordRequest.getCorrelationId(), ((SignUpStartApiResult.InvalidPassword) apiResultPerformSignUpStartUsingPasswordRequest).getError(), ((SignUpStartApiResult.InvalidPassword) apiResultPerformSignUpStartUsingPasswordRequest).getErrorDescription(), ((SignUpStartApiResult.InvalidPassword) apiResultPerformSignUpStartUsingPasswordRequest).getSubError());
            }
            if (apiResultPerformSignUpStartUsingPasswordRequest instanceof SignUpStartApiResult.InvalidAttributes) {
                return new SignUpCommandResult.InvalidAttributes(apiResultPerformSignUpStartUsingPasswordRequest.getCorrelationId(), ((SignUpStartApiResult.InvalidAttributes) apiResultPerformSignUpStartUsingPasswordRequest).getError(), ((SignUpStartApiResult.InvalidAttributes) apiResultPerformSignUpStartUsingPasswordRequest).getErrorDescription(), ((SignUpStartApiResult.InvalidAttributes) apiResultPerformSignUpStartUsingPasswordRequest).getInvalidAttributes());
            }
            if (apiResultPerformSignUpStartUsingPasswordRequest instanceof SignUpStartApiResult.UsernameAlreadyExists) {
                return new SignUpCommandResult.UsernameAlreadyExists(apiResultPerformSignUpStartUsingPasswordRequest.getCorrelationId(), ((SignUpStartApiResult.UsernameAlreadyExists) apiResultPerformSignUpStartUsingPasswordRequest).getError(), ((SignUpStartApiResult.UsernameAlreadyExists) apiResultPerformSignUpStartUsingPasswordRequest).getErrorDescription());
            }
            if (apiResultPerformSignUpStartUsingPasswordRequest instanceof SignUpStartApiResult.InvalidUsername) {
                return new INativeAuthCommandResult.InvalidUsername(((SignUpStartApiResult.InvalidUsername) apiResultPerformSignUpStartUsingPasswordRequest).getError(), ((SignUpStartApiResult.InvalidUsername) apiResultPerformSignUpStartUsingPasswordRequest).getErrorDescription(), null, apiResultPerformSignUpStartUsingPasswordRequest.getCorrelationId(), null, null, 52, null);
            }
            if (apiResultPerformSignUpStartUsingPasswordRequest instanceof SignUpStartApiResult.AuthNotSupported) {
                return new SignUpCommandResult.AuthNotSupported(apiResultPerformSignUpStartUsingPasswordRequest.getCorrelationId(), ((SignUpStartApiResult.AuthNotSupported) apiResultPerformSignUpStartUsingPasswordRequest).getError(), ((SignUpStartApiResult.AuthNotSupported) apiResultPerformSignUpStartUsingPasswordRequest).getErrorDescription());
            }
            if (apiResultPerformSignUpStartUsingPasswordRequest instanceof SignUpStartApiResult.Redirect) {
                return new INativeAuthCommandResult.Redirect(apiResultPerformSignUpStartUsingPasswordRequest.getCorrelationId(), ((SignUpStartApiResult.Redirect) apiResultPerformSignUpStartUsingPasswordRequest).getRedirectReason());
            }
            if (!(apiResultPerformSignUpStartUsingPasswordRequest instanceof SignUpStartApiResult.UnsupportedChallengeType ? true : apiResultPerformSignUpStartUsingPasswordRequest instanceof SignUpStartApiResult.UnknownError)) {
                throw new NoWhenBranchMatchedException();
            }
            Intrinsics.checkNotNull(apiResultPerformSignUpStartUsingPasswordRequest, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
            Logger.warnWithObject(TAG2, apiResultPerformSignUpStartUsingPasswordRequest.getCorrelationId(), "Unexpected result: ", apiResultPerformSignUpStartUsingPasswordRequest);
            return new INativeAuthCommandResult.APIError(((ApiErrorResult) apiResultPerformSignUpStartUsingPasswordRequest).getError(), ((ApiErrorResult) apiResultPerformSignUpStartUsingPasswordRequest).getErrorDescription(), null, apiResultPerformSignUpStartUsingPasswordRequest.getCorrelationId(), null, null, 52, null);
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in signUpStart", e);
            throw e;
        }
    }

    public final SignUpSubmitCodeCommandResult signUpSubmitCode(SignUpSubmitCodeCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".signUpSubmitCode");
        try {
            NativeAuthOAuth2Strategy nativeAuthOAuth2StrategyCreateOAuth2Strategy = createOAuth2Strategy(parameters);
            return toSignUpSubmitCodeCommandResult(performSignUpSubmitCode(nativeAuthOAuth2StrategyCreateOAuth2Strategy, parameters), nativeAuthOAuth2StrategyCreateOAuth2Strategy);
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in signUpSubmitCode", e);
            throw e;
        }
    }

    public final SignUpResendCodeCommandResult signUpResendCode(SignUpResendCodeCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".signUpResendCode");
        try {
            NativeAuthOAuth2Strategy nativeAuthOAuth2StrategyCreateOAuth2Strategy = createOAuth2Strategy(parameters);
            String str = parameters.continuationToken;
            Intrinsics.checkNotNullExpressionValue(str, "parameters.continuationToken");
            String correlationId = parameters.getCorrelationId();
            Intrinsics.checkNotNullExpressionValue(correlationId, "parameters.correlationId");
            SignUpStartCommandResult signUpStartCommandResult = toSignUpStartCommandResult(performSignUpChallengeCall(nativeAuthOAuth2StrategyCreateOAuth2Strategy, str, correlationId));
            Intrinsics.checkNotNull(signUpStartCommandResult, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpResendCodeCommandResult");
            return (SignUpResendCodeCommandResult) signUpStartCommandResult;
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in signUpResendCode", e);
            throw e;
        }
    }

    public final SignUpSubmitUserAttributesCommandResult signUpSubmitUserAttributes(SignUpSubmitUserAttributesCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".signUpSubmitUserAttributes");
        try {
            NativeAuthOAuth2Strategy nativeAuthOAuth2StrategyCreateOAuth2Strategy = createOAuth2Strategy(parameters);
            return toSignUpSubmitUserAttributesCommandResult(performSignUpSubmitUserAttributes(nativeAuthOAuth2StrategyCreateOAuth2Strategy, parameters), nativeAuthOAuth2StrategyCreateOAuth2Strategy);
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in signUpSubmitUserAttributes", e);
            throw e;
        }
    }

    public final SignUpSubmitPasswordCommandResult signUpSubmitPassword(SignUpSubmitPasswordCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".signUpSubmitPassword");
        try {
            NativeAuthOAuth2Strategy nativeAuthOAuth2StrategyCreateOAuth2Strategy = createOAuth2Strategy(parameters);
            return toSignUpSubmitPasswordCommandResult(performSignUpSubmitPassword(nativeAuthOAuth2StrategyCreateOAuth2Strategy, parameters), nativeAuthOAuth2StrategyCreateOAuth2Strategy);
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in signUpSubmitPassword", e);
            throw e;
        }
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public AcquireTokenResult acquireTokenSilent(SilentTokenCommandParameters parameters) throws ServiceException, ArgumentException, IOException, ClientException {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".acquireTokenSilent");
        AcquireTokenResult acquireTokenResult = new AcquireTokenResult();
        parameters.validate();
        SilentTokenCommandParameters parametersWithScopes = ((SilentTokenCommandParameters.SilentTokenCommandParametersBuilder) parameters.toBuilder().scopes(addDefaultScopes(parameters))).build();
        AccountRecord cachedAccountRecord = getCachedAccountRecord(parametersWithScopes);
        Intrinsics.checkNotNullExpressionValue(cachedAccountRecord, "getCachedAccountRecord(parametersWithScopes)");
        AbstractAuthenticationScheme authenticationScheme = parametersWithScopes.getAuthenticationScheme();
        OAuth2Strategy oAuth2StrategyCreateOAuth2Strategy = parametersWithScopes.getAuthority().createOAuth2Strategy(OAuth2StrategyParameters.builder().platformComponents(parametersWithScopes.getPlatformComponents()).authenticationScheme(authenticationScheme).build());
        OAuth2TokenCache oAuth2TokenCache = parametersWithScopes.getOAuth2TokenCache();
        List<ICacheRecord> listLoadWithAggregatedAccountData = oAuth2TokenCache.loadWithAggregatedAccountData(parametersWithScopes.getClientId(), parametersWithScopes.getApplicationIdentifier(), null, TextUtils.join(" ", parametersWithScopes.getScopes()), cachedAccountRecord, authenticationScheme);
        Intrinsics.checkNotNull(listLoadWithAggregatedAccountData, "null cannot be cast to non-null type kotlin.collections.List<com.microsoft.identity.common.java.cache.ICacheRecord>");
        ICacheRecord iCacheRecord = listLoadWithAggregatedAccountData.get(0);
        if (LibraryConfiguration.getInstance().isRefreshInEnabled() && iCacheRecord.getAccessToken() != null && iCacheRecord.getAccessToken().refreshOnIsActive()) {
            Logger.info(TAG2, parameters.getCorrelationId(), "RefreshOn is active. This will extend your token usage in the rare case servers are not available.");
        }
        if (LibraryConfiguration.getInstance().isRefreshInEnabled() && iCacheRecord.getAccessToken() != null && iCacheRecord.getAccessToken().shouldRefresh()) {
            if (!iCacheRecord.getAccessToken().isExpired()) {
                Intrinsics.checkNotNullExpressionValue(parametersWithScopes, "parametersWithScopes");
                setAcquireTokenResult(acquireTokenResult, parametersWithScopes, listLoadWithAggregatedAccountData);
                CommandDispatcher.submitAndForget(new RefreshOnCommand(parametersWithScopes, asControllerFactory(), PublicApiId.MSAL_REFRESH_ON));
            } else {
                Logger.warn(TAG2, parameters.getCorrelationId(), "Access token is expired. Removing from cache...");
                oAuth2TokenCache.removeCredential(iCacheRecord.getAccessToken());
                renewAccessToken(parametersWithScopes, acquireTokenResult, oAuth2TokenCache, oAuth2StrategyCreateOAuth2Strategy, iCacheRecord);
            }
        } else if (accessTokenIsNull(iCacheRecord) || refreshTokenIsNull(iCacheRecord) || parametersWithScopes.isForceRefresh() || !isRequestAuthorityRealmSameAsATRealm(parametersWithScopes.getAuthority(), iCacheRecord.getAccessToken()) || !oAuth2StrategyCreateOAuth2Strategy.validateCachedResult(authenticationScheme, iCacheRecord)) {
            if (!refreshTokenIsNull(iCacheRecord)) {
                renewAccessToken(parametersWithScopes, acquireTokenResult, oAuth2TokenCache, oAuth2StrategyCreateOAuth2Strategy, iCacheRecord);
            } else {
                ServiceException serviceException = new ServiceException("no_tokens_found", "No refresh token was found.", null);
                Telemetry.emit(new ApiEndEvent().putException(serviceException).putApiId(TelemetryEventStrings.Api.LOCAL_ACQUIRE_TOKEN_SILENT));
                throw serviceException;
            }
        } else if (iCacheRecord.getAccessToken().isExpired()) {
            Logger.warn(TAG2, parameters.getCorrelationId(), "Access token is expired. Removing from cache...");
            oAuth2TokenCache.removeCredential(iCacheRecord.getAccessToken());
            renewAccessToken(parametersWithScopes, acquireTokenResult, oAuth2TokenCache, oAuth2StrategyCreateOAuth2Strategy, iCacheRecord);
        } else {
            Logger.verbose(TAG2, parameters.getCorrelationId(), "Returning silent result");
            Intrinsics.checkNotNullExpressionValue(parametersWithScopes, "parametersWithScopes");
            setAcquireTokenResult(acquireTokenResult, parametersWithScopes, listLoadWithAggregatedAccountData);
        }
        Telemetry.emit(new ApiEndEvent().putResult(acquireTokenResult).putApiId(TelemetryEventStrings.Api.LOCAL_ACQUIRE_TOKEN_SILENT));
        return acquireTokenResult;
    }

    private final void setAcquireTokenResult(AcquireTokenResult acquireTokenSilentResult, SilentTokenCommandParameters parametersWithScopes, List<? extends ICacheRecord> cacheRecords) throws ClientException {
        acquireTokenSilentResult.setLocalAuthenticationResult(new LocalAuthenticationResult(finalizeCacheRecordForResult(cacheRecords.get(0), parametersWithScopes.getAuthenticationScheme()), cacheRecords, SdkType.MSAL, true));
    }

    public final ResetPasswordStartCommandResult resetPasswordStart(ResetPasswordStartCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".resetPasswordStart");
        try {
            NativeAuthOAuth2Strategy nativeAuthOAuth2StrategyCreateOAuth2Strategy = createOAuth2Strategy(parameters);
            ApiResult apiResultPerformResetPasswordStartCall = performResetPasswordStartCall(nativeAuthOAuth2StrategyCreateOAuth2Strategy, parameters);
            if (apiResultPerformResetPasswordStartCall instanceof ResetPasswordStartApiResult.Success) {
                return toResetPasswordStartCommandResult(performResetPasswordChallengeCall(nativeAuthOAuth2StrategyCreateOAuth2Strategy, ((ResetPasswordStartApiResult.Success) apiResultPerformResetPasswordStartCall).getContinuationToken(), apiResultPerformResetPasswordStartCall.getCorrelationId()));
            }
            if (apiResultPerformResetPasswordStartCall instanceof ResetPasswordStartApiResult.Redirect) {
                return new INativeAuthCommandResult.Redirect(apiResultPerformResetPasswordStartCall.getCorrelationId(), ((ResetPasswordStartApiResult.Redirect) apiResultPerformResetPasswordStartCall).getRedirectReason());
            }
            if (apiResultPerformResetPasswordStartCall instanceof ResetPasswordStartApiResult.UserNotFound) {
                return new ResetPasswordCommandResult.UserNotFound(apiResultPerformResetPasswordStartCall.getCorrelationId(), ((ResetPasswordStartApiResult.UserNotFound) apiResultPerformResetPasswordStartCall).getError(), ((ResetPasswordStartApiResult.UserNotFound) apiResultPerformResetPasswordStartCall).getErrorDescription());
            }
            if (!(apiResultPerformResetPasswordStartCall instanceof ResetPasswordStartApiResult.UnsupportedChallengeType ? true : apiResultPerformResetPasswordStartCall instanceof ResetPasswordStartApiResult.UnknownError)) {
                throw new NoWhenBranchMatchedException();
            }
            Logger.warnWithObject(TAG2, parameters.getCorrelationId(), "Unexpected result: ", apiResultPerformResetPasswordStartCall);
            Intrinsics.checkNotNull(apiResultPerformResetPasswordStartCall, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
            return new INativeAuthCommandResult.APIError(((ApiErrorResult) apiResultPerformResetPasswordStartCall).getError(), ((ApiErrorResult) apiResultPerformResetPasswordStartCall).getErrorDescription(), null, apiResultPerformResetPasswordStartCall.getCorrelationId(), null, null, 52, null);
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in resetPasswordStart", e);
            throw e;
        }
    }

    public final ResetPasswordSubmitCodeCommandResult resetPasswordSubmitCode(ResetPasswordSubmitCodeCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".resetPasswordSubmitCode");
        try {
            ApiResult apiResultPerformResetPasswordContinueCall = performResetPasswordContinueCall(createOAuth2Strategy(parameters), parameters);
            if (apiResultPerformResetPasswordContinueCall instanceof ResetPasswordContinueApiResult.PasswordRequired) {
                return new ResetPasswordCommandResult.PasswordRequired(apiResultPerformResetPasswordContinueCall.getCorrelationId(), ((ResetPasswordContinueApiResult.PasswordRequired) apiResultPerformResetPasswordContinueCall).getContinuationToken());
            }
            if (apiResultPerformResetPasswordContinueCall instanceof ResetPasswordContinueApiResult.CodeIncorrect) {
                return new ResetPasswordCommandResult.IncorrectCode(apiResultPerformResetPasswordContinueCall.getCorrelationId(), ((ResetPasswordContinueApiResult.CodeIncorrect) apiResultPerformResetPasswordContinueCall).getError(), ((ResetPasswordContinueApiResult.CodeIncorrect) apiResultPerformResetPasswordContinueCall).getErrorDescription(), ((ResetPasswordContinueApiResult.CodeIncorrect) apiResultPerformResetPasswordContinueCall).getSubError());
            }
            if (apiResultPerformResetPasswordContinueCall instanceof ResetPasswordContinueApiResult.Redirect) {
                return new INativeAuthCommandResult.Redirect(apiResultPerformResetPasswordContinueCall.getCorrelationId(), ((ResetPasswordContinueApiResult.Redirect) apiResultPerformResetPasswordContinueCall).getRedirectReason());
            }
            if (!(apiResultPerformResetPasswordContinueCall instanceof ResetPasswordContinueApiResult.ExpiredToken ? true : apiResultPerformResetPasswordContinueCall instanceof ResetPasswordContinueApiResult.UnknownError)) {
                throw new NoWhenBranchMatchedException();
            }
            Logger.warnWithObject(TAG2, "Unexpected result: ", apiResultPerformResetPasswordContinueCall);
            Intrinsics.checkNotNull(apiResultPerformResetPasswordContinueCall, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
            return new INativeAuthCommandResult.APIError(((ApiErrorResult) apiResultPerformResetPasswordContinueCall).getError(), ((ApiErrorResult) apiResultPerformResetPasswordContinueCall).getErrorDescription(), null, apiResultPerformResetPasswordContinueCall.getCorrelationId(), null, null, 52, null);
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in resetPasswordSubmitCode", e);
            throw e;
        }
    }

    public final ResetPasswordResendCodeCommandResult resetPasswordResendCode(ResetPasswordResendCodeCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".resetPasswordResendCode");
        try {
            NativeAuthOAuth2Strategy nativeAuthOAuth2StrategyCreateOAuth2Strategy = createOAuth2Strategy(parameters);
            String str = parameters.continuationToken;
            Intrinsics.checkNotNullExpressionValue(str, "parameters.continuationToken");
            String correlationId = parameters.getCorrelationId();
            Intrinsics.checkNotNullExpressionValue(correlationId, "parameters.correlationId");
            ApiResult apiResultPerformResetPasswordChallengeCall = performResetPasswordChallengeCall(nativeAuthOAuth2StrategyCreateOAuth2Strategy, str, correlationId);
            if (apiResultPerformResetPasswordChallengeCall instanceof ResetPasswordChallengeApiResult.CodeRequired) {
                return new ResetPasswordCommandResult.CodeRequired(apiResultPerformResetPasswordChallengeCall.getCorrelationId(), ((ResetPasswordChallengeApiResult.CodeRequired) apiResultPerformResetPasswordChallengeCall).getContinuationToken(), ((ResetPasswordChallengeApiResult.CodeRequired) apiResultPerformResetPasswordChallengeCall).getCodeLength(), ((ResetPasswordChallengeApiResult.CodeRequired) apiResultPerformResetPasswordChallengeCall).getChallengeTargetLabel(), ((ResetPasswordChallengeApiResult.CodeRequired) apiResultPerformResetPasswordChallengeCall).getChallengeChannel());
            }
            if (apiResultPerformResetPasswordChallengeCall instanceof ResetPasswordChallengeApiResult.Redirect) {
                return new INativeAuthCommandResult.Redirect(apiResultPerformResetPasswordChallengeCall.getCorrelationId(), ((ResetPasswordChallengeApiResult.Redirect) apiResultPerformResetPasswordChallengeCall).getRedirectReason());
            }
            boolean z = true;
            if (!(apiResultPerformResetPasswordChallengeCall instanceof ResetPasswordChallengeApiResult.ExpiredToken ? true : apiResultPerformResetPasswordChallengeCall instanceof ResetPasswordChallengeApiResult.UnsupportedChallengeType)) {
                z = apiResultPerformResetPasswordChallengeCall instanceof ResetPasswordChallengeApiResult.UnknownError;
            }
            if (!z) {
                throw new NoWhenBranchMatchedException();
            }
            Logger.warnWithObject(TAG2, apiResultPerformResetPasswordChallengeCall.getCorrelationId(), "Unexpected result: ", apiResultPerformResetPasswordChallengeCall);
            Intrinsics.checkNotNull(apiResultPerformResetPasswordChallengeCall, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
            return new INativeAuthCommandResult.APIError(((ApiErrorResult) apiResultPerformResetPasswordChallengeCall).getError(), ((ApiErrorResult) apiResultPerformResetPasswordChallengeCall).getErrorDescription(), null, apiResultPerformResetPasswordChallengeCall.getCorrelationId(), null, null, 52, null);
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in resetPasswordResendCode", e);
            throw e;
        }
    }

    public final ResetPasswordSubmitNewPasswordCommandResult resetPasswordSubmitNewPassword(ResetPasswordSubmitNewPasswordCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".resetPasswordSubmitNewPassword");
        try {
            NativeAuthOAuth2Strategy nativeAuthOAuth2StrategyCreateOAuth2Strategy = createOAuth2Strategy(parameters);
            ApiResult apiResultPerformResetPasswordSubmitCall = performResetPasswordSubmitCall(nativeAuthOAuth2StrategyCreateOAuth2Strategy, parameters);
            if (apiResultPerformResetPasswordSubmitCall instanceof ResetPasswordSubmitApiResult.SubmitSuccess) {
                return resetPasswordPollCompletion(nativeAuthOAuth2StrategyCreateOAuth2Strategy, ((ResetPasswordSubmitApiResult.SubmitSuccess) apiResultPerformResetPasswordSubmitCall).getContinuationToken(), apiResultPerformResetPasswordSubmitCall.getCorrelationId(), ((ResetPasswordSubmitApiResult.SubmitSuccess) apiResultPerformResetPasswordSubmitCall).getPollInterval());
            }
            if (apiResultPerformResetPasswordSubmitCall instanceof ResetPasswordSubmitApiResult.PasswordInvalid) {
                return new ResetPasswordCommandResult.PasswordNotAccepted(apiResultPerformResetPasswordSubmitCall.getCorrelationId(), ((ResetPasswordSubmitApiResult.PasswordInvalid) apiResultPerformResetPasswordSubmitCall).getError(), ((ResetPasswordSubmitApiResult.PasswordInvalid) apiResultPerformResetPasswordSubmitCall).getErrorDescription(), ((ResetPasswordSubmitApiResult.PasswordInvalid) apiResultPerformResetPasswordSubmitCall).getSubError());
            }
            if (apiResultPerformResetPasswordSubmitCall instanceof ResetPasswordSubmitApiResult.Redirect) {
                return new INativeAuthCommandResult.Redirect(apiResultPerformResetPasswordSubmitCall.getCorrelationId(), ((ResetPasswordSubmitApiResult.Redirect) apiResultPerformResetPasswordSubmitCall).getRedirectReason());
            }
            if (!(apiResultPerformResetPasswordSubmitCall instanceof ResetPasswordSubmitApiResult.ExpiredToken ? true : apiResultPerformResetPasswordSubmitCall instanceof ResetPasswordSubmitApiResult.UnknownError)) {
                throw new NoWhenBranchMatchedException();
            }
            Logger.warnWithObject(TAG2, apiResultPerformResetPasswordSubmitCall.getCorrelationId(), "Unexpected result: ", apiResultPerformResetPasswordSubmitCall);
            Intrinsics.checkNotNull(apiResultPerformResetPasswordSubmitCall, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
            return new INativeAuthCommandResult.APIError(((ApiErrorResult) apiResultPerformResetPasswordSubmitCall).getError(), ((ApiErrorResult) apiResultPerformResetPasswordSubmitCall).getErrorDescription(), null, apiResultPerformResetPasswordSubmitCall.getCorrelationId(), null, null, 52, null);
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in resetPasswordSubmitNewPassword", e);
            throw e;
        }
    }

    private static final boolean resetPasswordPollCompletion$pollCompletionTimedOut(long j) {
        return System.currentTimeMillis() - j > 300000;
    }

    private final ResetPasswordSubmitNewPasswordCommandResult resetPasswordPollCompletion(NativeAuthOAuth2Strategy oAuth2Strategy, String continuationToken, String correlationId, int pollIntervalInSeconds) throws Exception {
        StringBuilder sb = new StringBuilder();
        String TAG2 = TAG;
        String string = sb.append(TAG2).append(":resetPasswordPollCompletion").toString();
        LogSession.Companion companion = LogSession.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, correlationId, TAG2 + ".resetPasswordPollCompletion");
        int i = pollIntervalInSeconds * 1000;
        try {
            ResetPasswordPollCompletionApiResult resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall = performResetPasswordPollCompletionCall(oAuth2Strategy, continuationToken, correlationId);
            long jCurrentTimeMillis = System.currentTimeMillis();
            while (resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall instanceof ResetPasswordPollCompletionApiResult.InProgress) {
                ThreadUtils.sleepSafely(i, string, "Waiting between reset password polls");
                if (resetPasswordPollCompletion$pollCompletionTimedOut(jCurrentTimeMillis)) {
                    Logger.warn(TAG, resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall.getCorrelationId(), "Reset password completion timed out.");
                    return new ResetPasswordCommandResult.PasswordResetFailed(resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall.getCorrelationId(), ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE, ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_DESCRIPTION);
                }
                resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall = performResetPasswordPollCompletionCall(oAuth2Strategy, continuationToken, correlationId);
            }
            if (resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall instanceof ResetPasswordPollCompletionApiResult.PollingFailed) {
                return new ResetPasswordCommandResult.PasswordResetFailed(resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall.getCorrelationId(), ((ResetPasswordPollCompletionApiResult.PollingFailed) resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall).getError(), ((ResetPasswordPollCompletionApiResult.PollingFailed) resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall).getErrorDescription());
            }
            if (resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall instanceof ResetPasswordPollCompletionApiResult.PollingSucceeded) {
                return new ResetPasswordCommandResult.Complete(resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall.getCorrelationId(), ((ResetPasswordPollCompletionApiResult.PollingSucceeded) resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall).getContinuationToken(), ((ResetPasswordPollCompletionApiResult.PollingSucceeded) resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall).getExpiresIn());
            }
            if (resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall instanceof ResetPasswordPollCompletionApiResult.InProgress) {
                Logger.warn(TAG, resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall.getCorrelationId(), "in_progress received after polling, illegal state");
                return new INativeAuthCommandResult.APIError("illegal_state", "in_progress received after polling concluded, illegal state", null, resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall.getCorrelationId(), null, null, 52, null);
            }
            if (resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall instanceof ResetPasswordPollCompletionApiResult.Redirect) {
                return new INativeAuthCommandResult.Redirect(resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall.getCorrelationId(), ((ResetPasswordPollCompletionApiResult.Redirect) resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall).getRedirectReason());
            }
            boolean z = true;
            if (!(resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall instanceof ResetPasswordPollCompletionApiResult.ExpiredToken ? true : resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall instanceof ResetPasswordPollCompletionApiResult.UserNotFound ? true : resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall instanceof ResetPasswordPollCompletionApiResult.PasswordInvalid)) {
                z = resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall instanceof ResetPasswordPollCompletionApiResult.UnknownError;
            }
            if (!z) {
                throw new NoWhenBranchMatchedException();
            }
            Logger.warnWithObject(TAG, resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall.getCorrelationId(), "Unexpected result: ", resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall);
            Intrinsics.checkNotNull(resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
            return new INativeAuthCommandResult.APIError(((ApiErrorResult) resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall).getError(), ((ApiErrorResult) resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall).getErrorDescription(), null, resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall.getCorrelationId(), null, null, 52, null);
        } catch (Exception e) {
            Logger.error(TAG, correlationId, "Exception thrown in resetPasswordPollCompletion", e);
            throw e;
        }
    }

    public final SignInTokenApiResult performContinuationTokenTokenRequest(NativeAuthOAuth2Strategy oAuth2Strategy, SignInWithContinuationTokenCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(oAuth2Strategy, "oAuth2Strategy");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".performContinuationTokenTokenRequest");
        return oAuth2Strategy.performContinuationTokenTokenRequest(parameters);
    }

    private final JITIntrospectApiResult performJITIntrospect(NativeAuthOAuth2Strategy oAuth2Strategy, BaseSignInTokenCommandParameters parameters, String continuationToken, String correlationId) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, correlationId, TAG2 + ".performJITIntrospectCall");
        JITIntrospectCommandParameters introspectParams = CommandUtil.createJITIntrospectCommandParameters(parameters, correlationId, continuationToken);
        Intrinsics.checkNotNullExpressionValue(introspectParams, "introspectParams");
        return oAuth2Strategy.performJITIntrospectRequest(introspectParams);
    }

    private final SignInTokenApiResult performOOBTokenRequest(NativeAuthOAuth2Strategy oAuth2Strategy, SignInSubmitCodeCommandParameters parameters) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".performOOBTokenRequest");
        return oAuth2Strategy.performOOBTokenRequest(parameters);
    }

    private final SignInTokenApiResult performSubmitChallengeTokenRequest(NativeAuthOAuth2Strategy oAuth2Strategy, MFASubmitChallengeCommandParameters parameters) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".performOOBTokenRequest");
        SignInSubmitCodeCommandParameters signInSubmitCodeCommandParameters = CommandUtil.createSignInSubmitCodeCommandParameters(parameters);
        Intrinsics.checkNotNullExpressionValue(signInSubmitCodeCommandParameters, "signInSubmitCodeCommandParameters");
        return oAuth2Strategy.performOOBTokenRequest(signInSubmitCodeCommandParameters);
    }

    public final SignInTokenApiResult performPasswordTokenCall(NativeAuthOAuth2Strategy oAuth2Strategy, SignInSubmitPasswordCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(oAuth2Strategy, "oAuth2Strategy");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".performPasswordTokenCall");
        return oAuth2Strategy.performPasswordTokenRequest(parameters);
    }

    private final JITSubmitChallengeCommandResult completeJITFlow(JITContinueCommandParameters parameters) throws Exception {
        NativeAuthOAuth2Strategy nativeAuthOAuth2StrategyCreateOAuth2Strategy = createOAuth2Strategy(parameters);
        try {
            JITContinueApiResult jITContinueApiResultPerformJITContinueCall = performJITContinueCall(nativeAuthOAuth2StrategyCreateOAuth2Strategy, parameters);
            if (jITContinueApiResultPerformJITContinueCall instanceof JITContinueApiResult.CodeIncorrect) {
                return new JITCommandResult.IncorrectChallenge(jITContinueApiResultPerformJITContinueCall.getCorrelationId(), ((JITContinueApiResult.CodeIncorrect) jITContinueApiResultPerformJITContinueCall).getError(), ((JITContinueApiResult.CodeIncorrect) jITContinueApiResultPerformJITContinueCall).getErrorDescription(), ((JITContinueApiResult.CodeIncorrect) jITContinueApiResultPerformJITContinueCall).getErrorCodes(), ((JITContinueApiResult.CodeIncorrect) jITContinueApiResultPerformJITContinueCall).getSubError());
            }
            if (jITContinueApiResultPerformJITContinueCall instanceof JITContinueApiResult.Redirect) {
                return new INativeAuthCommandResult.Redirect(jITContinueApiResultPerformJITContinueCall.getCorrelationId(), ((JITContinueApiResult.Redirect) jITContinueApiResultPerformJITContinueCall).getRedirectReason());
            }
            if (jITContinueApiResultPerformJITContinueCall instanceof JITContinueApiResult.Success) {
                SignInWithContinuationTokenCommandParameters signInParams = CommandUtil.createSignInWithContinuationTokenCommandParameters(parameters, jITContinueApiResultPerformJITContinueCall.getCorrelationId(), ((JITContinueApiResult.Success) jITContinueApiResultPerformJITContinueCall).getContinuationToken());
                Intrinsics.checkNotNullExpressionValue(signInParams, "signInParams");
                ApiResult apiResultPerformContinuationTokenTokenRequest = performContinuationTokenTokenRequest(nativeAuthOAuth2StrategyCreateOAuth2Strategy, signInParams);
                if (apiResultPerformContinuationTokenTokenRequest instanceof SignInTokenApiResult.Success) {
                    return saveAndReturnTokens(nativeAuthOAuth2StrategyCreateOAuth2Strategy, signInParams, (SignInTokenApiResult.Success) apiResultPerformContinuationTokenTokenRequest);
                }
                Logger.warnWithObject(TAG, apiResultPerformContinuationTokenTokenRequest.getCorrelationId(), "An error occurred while trying to acquire token using the continuation token: ", apiResultPerformContinuationTokenTokenRequest);
                Intrinsics.checkNotNull(apiResultPerformContinuationTokenTokenRequest, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
                return new INativeAuthCommandResult.APIError(((ApiErrorResult) apiResultPerformContinuationTokenTokenRequest).getError(), ((ApiErrorResult) apiResultPerformContinuationTokenTokenRequest).getErrorDescription(), null, apiResultPerformContinuationTokenTokenRequest.getCorrelationId(), ((ApiErrorResult) apiResultPerformContinuationTokenTokenRequest).getErrorCodes(), null, 36, null);
            }
            if (!(jITContinueApiResultPerformJITContinueCall instanceof JITContinueApiResult.UnknownError)) {
                throw new NoWhenBranchMatchedException();
            }
            Logger.warnWithObject(TAG, "Unexpected result: ", jITContinueApiResultPerformJITContinueCall);
            return new INativeAuthCommandResult.APIError(((JITContinueApiResult.UnknownError) jITContinueApiResultPerformJITContinueCall).getError(), ((JITContinueApiResult.UnknownError) jITContinueApiResultPerformJITContinueCall).getErrorDescription(), null, jITContinueApiResultPerformJITContinueCall.getCorrelationId(), ((JITContinueApiResult.UnknownError) jITContinueApiResultPerformJITContinueCall).getErrorCodes(), null, 36, null);
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in signInSubmitPassword", e);
            throw e;
        }
    }

    private final SignInInitiateApiResult performSignInInitiateCall(NativeAuthOAuth2Strategy oAuth2Strategy, SignInStartCommandParameters parameters) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".performSignInInitiateCall");
        return oAuth2Strategy.performSignInInitiate(parameters);
    }

    private final SignInChallengeApiResult performSignInChallengeCall(NativeAuthOAuth2Strategy oAuth2Strategy, String continuationToken, String correlationId) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, correlationId, TAG2 + ".performSignInChallengeCall");
        return oAuth2Strategy.performSignInDefaultChallenge(continuationToken, correlationId);
    }

    private final SignInChallengeApiResult performSignInSelectedAuthMethodCall(NativeAuthOAuth2Strategy oAuth2Strategy, String continuationToken, String correlationId, String authMethodId) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, correlationId, TAG2 + ".performSignInSelectedAuthMethodCall");
        return oAuth2Strategy.performSignInSelectedChallenge(continuationToken, correlationId, authMethodId);
    }

    private final SignInIntrospectApiResult performIntrospectCall(NativeAuthOAuth2Strategy oAuth2Strategy, String continuationToken, String correlationId) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, correlationId, TAG2 + ".performIntrospectCall");
        return oAuth2Strategy.performIntrospect(continuationToken, correlationId);
    }

    private final JITChallengeApiResult performJITChallengeCall(NativeAuthOAuth2Strategy oAuth2Strategy, JITChallengeAuthMethodCommandParameters parameters) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".performJITChallengeCall");
        return oAuth2Strategy.performJITChallengeRequest(parameters);
    }

    private final JITContinueApiResult performJITContinueCall(NativeAuthOAuth2Strategy oAuth2Strategy, JITContinueCommandParameters parameters) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".performJITContinueCall");
        return oAuth2Strategy.performJITContinueRequest(parameters);
    }

    private final ResetPasswordStartApiResult performResetPasswordStartCall(NativeAuthOAuth2Strategy oAuth2Strategy, ResetPasswordStartCommandParameters parameters) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".performResetPasswordStartCall");
        return oAuth2Strategy.performResetPasswordStart(parameters);
    }

    private final ResetPasswordChallengeApiResult performResetPasswordChallengeCall(NativeAuthOAuth2Strategy oAuth2Strategy, String continuationToken, String correlationId) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, correlationId, TAG2 + ".performResetPasswordChallengeCall");
        return oAuth2Strategy.performResetPasswordChallenge(continuationToken, correlationId);
    }

    private final ResetPasswordContinueApiResult performResetPasswordContinueCall(NativeAuthOAuth2Strategy oAuth2Strategy, ResetPasswordSubmitCodeCommandParameters parameters) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".performResetPasswordContinueCall");
        return oAuth2Strategy.performResetPasswordContinue(parameters);
    }

    private final ResetPasswordSubmitApiResult performResetPasswordSubmitCall(NativeAuthOAuth2Strategy oAuth2Strategy, ResetPasswordSubmitNewPasswordCommandParameters parameters) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".performResetPasswordSubmitCall");
        return oAuth2Strategy.performResetPasswordSubmit(parameters);
    }

    private final ResetPasswordPollCompletionApiResult performResetPasswordPollCompletionCall(NativeAuthOAuth2Strategy oAuth2Strategy, String continuationToken, String correlationId) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, correlationId, TAG2 + ".performResetPasswordPollCompletionCall");
        return oAuth2Strategy.performResetPasswordPollCompletion(continuationToken, correlationId);
    }

    private final SignInCommandResult.Complete saveAndReturnTokens(NativeAuthOAuth2Strategy oAuth2Strategy, BaseSignInTokenCommandParameters parametersWithScopes, SignInTokenApiResult.Success tokenApiResult) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parametersWithScopes.getCorrelationId(), TAG2 + ".saveAndReturnTokens");
        Intrinsics.checkNotNull(oAuth2Strategy, "null cannot be cast to non-null type com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Strategy");
        NativeAuthOAuth2Strategy nativeAuthOAuth2Strategy = oAuth2Strategy;
        List<String> listEmptyList = parametersWithScopes.scopes;
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        String clientId = parametersWithScopes.getClientId();
        Intrinsics.checkNotNullExpressionValue(clientId, "parametersWithScopes.clientId");
        String applicationIdentifier = parametersWithScopes.getApplicationIdentifier();
        Intrinsics.checkNotNullExpressionValue(applicationIdentifier, "parametersWithScopes.applicationIdentifier");
        List<ICacheRecord> listSaveTokens = saveTokens(nativeAuthOAuth2Strategy, createAuthorizationRequest(oAuth2Strategy, listEmptyList, clientId, applicationIdentifier), tokenApiResult.getTokenResponse(), parametersWithScopes.getOAuth2TokenCache());
        Intrinsics.checkNotNullExpressionValue(listSaveTokens, "saveTokens(\n            …Auth2TokenCache\n        )");
        return new SignInCommandResult.Complete(tokenApiResult.getCorrelationId(), new LocalAuthenticationResult(finalizeCacheRecordForResult(listSaveTokens.get(0), parametersWithScopes.getAuthenticationScheme()), listSaveTokens, SdkType.MSAL, false));
    }

    private final MicrosoftStsAuthorizationRequest createAuthorizationRequest(NativeAuthOAuth2Strategy strategy, List<String> scopes, String clientId, String applicationIdentifier) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, null, TAG2 + ".createAuthorizationRequest");
        MicrosoftStsAuthorizationRequest.Builder builder = new MicrosoftStsAuthorizationRequest.Builder();
        builder.setAuthority(new URL(strategy.getAuthority()));
        builder.setClientId(clientId);
        builder.setScope(StringUtil.join(" ", scopes));
        builder.setApplicationIdentifier(applicationIdentifier);
        MicrosoftStsAuthorizationRequest microsoftStsAuthorizationRequestBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(microsoftStsAuthorizationRequestBuild, "builder.build()");
        return microsoftStsAuthorizationRequestBuild;
    }

    private final List<String> addDefaultScopes(List<String> scopes) {
        ArrayList arrayList;
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, null, TAG2 + ".createAuthorizationRequest");
        if (scopes == null || (arrayList = CollectionsKt.toMutableList((Collection) scopes)) == null) {
            arrayList = new ArrayList();
        }
        Set<String> DEFAULT_SCOPES = AuthenticationConstants.DEFAULT_SCOPES;
        Intrinsics.checkNotNullExpressionValue(DEFAULT_SCOPES, "DEFAULT_SCOPES");
        arrayList.addAll(DEFAULT_SCOPES);
        TypeIntrinsics.asMutableCollection(arrayList).removeAll(CollectionsKt.listOf((Object[]) new String[]{"", null}));
        return CollectionsKt.toList(arrayList);
    }

    private final ResetPasswordStartCommandResult toResetPasswordStartCommandResult(ResetPasswordChallengeApiResult resetPasswordChallengeApiResult) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, resetPasswordChallengeApiResult.getCorrelationId(), TAG2 + ".createAuthorizationRequest");
        if (resetPasswordChallengeApiResult instanceof ResetPasswordChallengeApiResult.CodeRequired) {
            ResetPasswordChallengeApiResult.CodeRequired codeRequired = (ResetPasswordChallengeApiResult.CodeRequired) resetPasswordChallengeApiResult;
            return new ResetPasswordCommandResult.CodeRequired(resetPasswordChallengeApiResult.getCorrelationId(), codeRequired.getContinuationToken(), codeRequired.getCodeLength(), codeRequired.getChallengeTargetLabel(), codeRequired.getChallengeChannel());
        }
        if (resetPasswordChallengeApiResult instanceof ResetPasswordChallengeApiResult.Redirect) {
            return new INativeAuthCommandResult.Redirect(resetPasswordChallengeApiResult.getCorrelationId(), ((ResetPasswordChallengeApiResult.Redirect) resetPasswordChallengeApiResult).getRedirectReason());
        }
        if (resetPasswordChallengeApiResult instanceof ResetPasswordChallengeApiResult.ExpiredToken) {
            Logger.warnWithObject(TAG2, resetPasswordChallengeApiResult.getCorrelationId(), "Expire token result: ", resetPasswordChallengeApiResult);
            ResetPasswordChallengeApiResult.ExpiredToken expiredToken = (ResetPasswordChallengeApiResult.ExpiredToken) resetPasswordChallengeApiResult;
            return new INativeAuthCommandResult.APIError(expiredToken.getError(), expiredToken.getErrorDescription(), null, resetPasswordChallengeApiResult.getCorrelationId(), null, null, 52, null);
        }
        if (resetPasswordChallengeApiResult instanceof ResetPasswordChallengeApiResult.UnsupportedChallengeType) {
            Logger.warnWithObject(TAG2, resetPasswordChallengeApiResult.getCorrelationId(), "Unsupported challenge type: ", resetPasswordChallengeApiResult);
            ResetPasswordChallengeApiResult.UnsupportedChallengeType unsupportedChallengeType = (ResetPasswordChallengeApiResult.UnsupportedChallengeType) resetPasswordChallengeApiResult;
            return new INativeAuthCommandResult.APIError(unsupportedChallengeType.getError(), unsupportedChallengeType.getErrorDescription(), null, resetPasswordChallengeApiResult.getCorrelationId(), null, null, 52, null);
        }
        if (!(resetPasswordChallengeApiResult instanceof ResetPasswordChallengeApiResult.UnknownError)) {
            throw new NoWhenBranchMatchedException();
        }
        Logger.warnWithObject(TAG2, resetPasswordChallengeApiResult.getCorrelationId(), "Unexpected result: ", resetPasswordChallengeApiResult);
        ResetPasswordChallengeApiResult.UnknownError unknownError = (ResetPasswordChallengeApiResult.UnknownError) resetPasswordChallengeApiResult;
        return new INativeAuthCommandResult.APIError(unknownError.getError(), unknownError.getErrorDescription(), null, resetPasswordChallengeApiResult.getCorrelationId(), null, null, 52, null);
    }

    public final SignUpStartApiResult performSignUpStartUsingPasswordRequest(NativeAuthOAuth2Strategy oAuth2Strategy, SignUpStartCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(oAuth2Strategy, "oAuth2Strategy");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".performSignUpStartUsingPasswordRequest");
        return oAuth2Strategy.performSignUpStart(parameters);
    }

    private final SignUpChallengeApiResult performSignUpChallengeCall(NativeAuthOAuth2Strategy oAuth2Strategy, String continuationToken, String correlationId) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, correlationId, TAG2 + ".performSignUpChallengeCall");
        return oAuth2Strategy.performSignUpChallenge(continuationToken, correlationId);
    }

    private final SignUpContinueApiResult performSignUpSubmitCode(NativeAuthOAuth2Strategy oAuth2Strategy, SignUpSubmitCodeCommandParameters parameters) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".performSignUpSubmitCode");
        return oAuth2Strategy.performSignUpSubmitCode(parameters);
    }

    private final SignUpContinueApiResult performSignUpSubmitPassword(NativeAuthOAuth2Strategy oAuth2Strategy, SignUpSubmitPasswordCommandParameters parameters) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".performSignUpSubmitPassword");
        return oAuth2Strategy.performSignUpSubmitPassword(parameters);
    }

    public final SignUpContinueApiResult performSignUpSubmitUserAttributes(NativeAuthOAuth2Strategy oAuth2Strategy, SignUpSubmitUserAttributesCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(oAuth2Strategy, "oAuth2Strategy");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".performSignUpSubmitUserAttributes");
        return oAuth2Strategy.performSignUpSubmitUserAttributes(parameters);
    }

    private final JITChallengeAuthMethodCommandResult toJITChallengeAuthMethodCommandResult(JITSubmitChallengeCommandResult jITSubmitChallengeCommandResult) {
        if (jITSubmitChallengeCommandResult instanceof JITCommandResult.IncorrectChallenge) {
            JITCommandResult.IncorrectChallenge incorrectChallenge = (JITCommandResult.IncorrectChallenge) jITSubmitChallengeCommandResult;
            return new INativeAuthCommandResult.APIError(incorrectChallenge.getError(), incorrectChallenge.getErrorDescription(), null, jITSubmitChallengeCommandResult.getCorrelationId(), incorrectChallenge.getErrorCodes(), null, 36, null);
        }
        if (jITSubmitChallengeCommandResult instanceof INativeAuthCommandResult.Redirect) {
            return (JITChallengeAuthMethodCommandResult) jITSubmitChallengeCommandResult;
        }
        if (jITSubmitChallengeCommandResult instanceof INativeAuthCommandResult.APIError) {
            return (JITChallengeAuthMethodCommandResult) jITSubmitChallengeCommandResult;
        }
        if (jITSubmitChallengeCommandResult instanceof SignInCommandResult.Complete) {
            return (JITChallengeAuthMethodCommandResult) jITSubmitChallengeCommandResult;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final SignUpSubmitUserAttributesCommandResult toSignUpSubmitUserAttrsCommandResult(SignUpChallengeApiResult signUpChallengeApiResult) {
        if (signUpChallengeApiResult instanceof SignUpChallengeApiResult.Redirect) {
            return new INativeAuthCommandResult.Redirect(signUpChallengeApiResult.getCorrelationId(), ((SignUpChallengeApiResult.Redirect) signUpChallengeApiResult).getRedirectReason());
        }
        if (!(signUpChallengeApiResult instanceof SignUpChallengeApiResult.ExpiredToken ? true : signUpChallengeApiResult instanceof SignUpChallengeApiResult.UnsupportedChallengeType ? true : signUpChallengeApiResult instanceof SignUpChallengeApiResult.OOBRequired ? true : signUpChallengeApiResult instanceof SignUpChallengeApiResult.PasswordRequired ? true : signUpChallengeApiResult instanceof SignUpChallengeApiResult.UnknownError)) {
            throw new NoWhenBranchMatchedException();
        }
        Logger.warnWithObject(TAG, signUpChallengeApiResult.getCorrelationId(), "Unexpected result: ", signUpChallengeApiResult);
        Intrinsics.checkNotNull(signUpChallengeApiResult, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
        ApiErrorResult apiErrorResult = (ApiErrorResult) signUpChallengeApiResult;
        return new INativeAuthCommandResult.APIError(apiErrorResult.getError(), apiErrorResult.getErrorDescription(), null, signUpChallengeApiResult.getCorrelationId(), null, null, 52, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final SignUpStartCommandResult toSignUpStartCommandResult(SignUpChallengeApiResult signUpChallengeApiResult) {
        if (signUpChallengeApiResult instanceof SignUpChallengeApiResult.OOBRequired) {
            SignUpChallengeApiResult.OOBRequired oOBRequired = (SignUpChallengeApiResult.OOBRequired) signUpChallengeApiResult;
            return new SignUpCommandResult.CodeRequired(signUpChallengeApiResult.getCorrelationId(), oOBRequired.getContinuationToken(), oOBRequired.getChallengeTargetLabel(), oOBRequired.getChallengeChannel(), oOBRequired.getCodeLength());
        }
        if (signUpChallengeApiResult instanceof SignUpChallengeApiResult.PasswordRequired) {
            return new SignUpCommandResult.PasswordRequired(signUpChallengeApiResult.getCorrelationId(), ((SignUpChallengeApiResult.PasswordRequired) signUpChallengeApiResult).getContinuationToken());
        }
        if (signUpChallengeApiResult instanceof SignUpChallengeApiResult.Redirect) {
            return new INativeAuthCommandResult.Redirect(signUpChallengeApiResult.getCorrelationId(), ((SignUpChallengeApiResult.Redirect) signUpChallengeApiResult).getRedirectReason());
        }
        if (!(signUpChallengeApiResult instanceof SignUpChallengeApiResult.ExpiredToken ? true : signUpChallengeApiResult instanceof SignUpChallengeApiResult.UnsupportedChallengeType ? true : signUpChallengeApiResult instanceof SignUpChallengeApiResult.UnknownError)) {
            throw new NoWhenBranchMatchedException();
        }
        Logger.warnWithObject(TAG, signUpChallengeApiResult.getCorrelationId(), "Unexpected result: ", signUpChallengeApiResult);
        Intrinsics.checkNotNull(signUpChallengeApiResult, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
        ApiErrorResult apiErrorResult = (ApiErrorResult) signUpChallengeApiResult;
        return new INativeAuthCommandResult.APIError(apiErrorResult.getError(), apiErrorResult.getErrorDescription(), null, signUpChallengeApiResult.getCorrelationId(), null, null, 52, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final SignUpSubmitCodeCommandResult toSignUpSubmitCodeCommandResult(SignUpContinueApiResult signUpContinueApiResult, NativeAuthOAuth2Strategy nativeAuthOAuth2Strategy) {
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.Success) {
            SignUpContinueApiResult.Success success = (SignUpContinueApiResult.Success) signUpContinueApiResult;
            return new SignUpCommandResult.Complete(signUpContinueApiResult.getCorrelationId(), success.getContinuationToken(), success.getExpiresIn());
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.ExpiredToken) {
            Logger.warnWithObject(TAG, signUpContinueApiResult.getCorrelationId(), "Expire token result: ", signUpContinueApiResult);
            SignUpContinueApiResult.ExpiredToken expiredToken = (SignUpContinueApiResult.ExpiredToken) signUpContinueApiResult;
            return new INativeAuthCommandResult.APIError(expiredToken.getError(), expiredToken.getErrorDescription(), null, signUpContinueApiResult.getCorrelationId(), null, null, 52, null);
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.UsernameAlreadyExists) {
            SignUpContinueApiResult.UsernameAlreadyExists usernameAlreadyExists = (SignUpContinueApiResult.UsernameAlreadyExists) signUpContinueApiResult;
            return new SignUpCommandResult.UsernameAlreadyExists(signUpContinueApiResult.getCorrelationId(), usernameAlreadyExists.getError(), usernameAlreadyExists.getErrorDescription());
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.AttributesRequired) {
            SignUpContinueApiResult.AttributesRequired attributesRequired = (SignUpContinueApiResult.AttributesRequired) signUpContinueApiResult;
            return new SignUpCommandResult.AttributesRequired(signUpContinueApiResult.getCorrelationId(), attributesRequired.getContinuationToken(), attributesRequired.getError(), attributesRequired.getErrorDescription(), attributesRequired.getRequiredAttributes());
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.CredentialRequired) {
            SignUpStartCommandResult signUpStartCommandResult = toSignUpStartCommandResult(performSignUpChallengeCall(nativeAuthOAuth2Strategy, ((SignUpContinueApiResult.CredentialRequired) signUpContinueApiResult).getContinuationToken(), signUpContinueApiResult.getCorrelationId()));
            Intrinsics.checkNotNull(signUpStartCommandResult, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpSubmitCodeCommandResult");
            return (SignUpSubmitCodeCommandResult) signUpStartCommandResult;
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.InvalidOOBValue) {
            SignUpContinueApiResult.InvalidOOBValue invalidOOBValue = (SignUpContinueApiResult.InvalidOOBValue) signUpContinueApiResult;
            return new SignUpCommandResult.InvalidCode(signUpContinueApiResult.getCorrelationId(), invalidOOBValue.getError(), invalidOOBValue.getErrorDescription(), invalidOOBValue.getSubError());
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.Redirect) {
            return new INativeAuthCommandResult.Redirect(signUpContinueApiResult.getCorrelationId(), ((SignUpContinueApiResult.Redirect) signUpContinueApiResult).getRedirectReason());
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.UnknownError) {
            Logger.warnWithObject(TAG, signUpContinueApiResult.getCorrelationId(), "Unexpected result: ", signUpContinueApiResult);
            SignUpContinueApiResult.UnknownError unknownError = (SignUpContinueApiResult.UnknownError) signUpContinueApiResult;
            return new INativeAuthCommandResult.APIError(unknownError.getError(), unknownError.getErrorDescription(), null, signUpContinueApiResult.getCorrelationId(), null, null, 52, null);
        }
        if (!(signUpContinueApiResult instanceof SignUpContinueApiResult.InvalidAttributes ? true : signUpContinueApiResult instanceof SignUpContinueApiResult.InvalidPassword)) {
            throw new NoWhenBranchMatchedException();
        }
        Logger.warnWithObject(TAG, signUpContinueApiResult.getCorrelationId(), "Unexpected result: ", signUpContinueApiResult);
        Intrinsics.checkNotNull(signUpContinueApiResult, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
        ApiErrorResult apiErrorResult = (ApiErrorResult) signUpContinueApiResult;
        return new INativeAuthCommandResult.APIError(apiErrorResult.getError(), apiErrorResult.getErrorDescription(), null, signUpContinueApiResult.getCorrelationId(), null, null, 52, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final SignUpSubmitUserAttributesCommandResult toSignUpSubmitUserAttributesCommandResult(SignUpContinueApiResult signUpContinueApiResult, NativeAuthOAuth2Strategy nativeAuthOAuth2Strategy) {
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.Success) {
            SignUpContinueApiResult.Success success = (SignUpContinueApiResult.Success) signUpContinueApiResult;
            return new SignUpCommandResult.Complete(signUpContinueApiResult.getCorrelationId(), success.getContinuationToken(), success.getExpiresIn());
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.UsernameAlreadyExists) {
            SignUpContinueApiResult.UsernameAlreadyExists usernameAlreadyExists = (SignUpContinueApiResult.UsernameAlreadyExists) signUpContinueApiResult;
            return new SignUpCommandResult.UsernameAlreadyExists(signUpContinueApiResult.getCorrelationId(), usernameAlreadyExists.getError(), usernameAlreadyExists.getErrorDescription());
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.AttributesRequired) {
            SignUpContinueApiResult.AttributesRequired attributesRequired = (SignUpContinueApiResult.AttributesRequired) signUpContinueApiResult;
            return new SignUpCommandResult.AttributesRequired(signUpContinueApiResult.getCorrelationId(), attributesRequired.getContinuationToken(), attributesRequired.getError(), attributesRequired.getErrorDescription(), attributesRequired.getRequiredAttributes());
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.CredentialRequired) {
            return toSignUpSubmitUserAttrsCommandResult(performSignUpChallengeCall(nativeAuthOAuth2Strategy, ((SignUpContinueApiResult.CredentialRequired) signUpContinueApiResult).getContinuationToken(), signUpContinueApiResult.getCorrelationId()));
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.Redirect) {
            return new INativeAuthCommandResult.Redirect(signUpContinueApiResult.getCorrelationId(), ((SignUpContinueApiResult.Redirect) signUpContinueApiResult).getRedirectReason());
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.InvalidAttributes) {
            SignUpContinueApiResult.InvalidAttributes invalidAttributes = (SignUpContinueApiResult.InvalidAttributes) signUpContinueApiResult;
            return new SignUpCommandResult.InvalidAttributes(signUpContinueApiResult.getCorrelationId(), invalidAttributes.getError(), invalidAttributes.getErrorDescription(), invalidAttributes.getInvalidAttributes());
        }
        if (!(signUpContinueApiResult instanceof SignUpContinueApiResult.InvalidOOBValue ? true : signUpContinueApiResult instanceof SignUpContinueApiResult.InvalidPassword ? true : signUpContinueApiResult instanceof SignUpContinueApiResult.ExpiredToken ? true : signUpContinueApiResult instanceof SignUpContinueApiResult.UnknownError)) {
            throw new NoWhenBranchMatchedException();
        }
        Logger.warnWithObject(TAG, signUpContinueApiResult.getCorrelationId(), "Expire token result: ", signUpContinueApiResult);
        Intrinsics.checkNotNull(signUpContinueApiResult, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
        ApiErrorResult apiErrorResult = (ApiErrorResult) signUpContinueApiResult;
        return new INativeAuthCommandResult.APIError(apiErrorResult.getError(), apiErrorResult.getErrorDescription(), null, signUpContinueApiResult.getCorrelationId(), null, null, 52, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final SignUpSubmitPasswordCommandResult toSignUpSubmitPasswordCommandResult(SignUpContinueApiResult signUpContinueApiResult, NativeAuthOAuth2Strategy nativeAuthOAuth2Strategy) {
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.Success) {
            SignUpContinueApiResult.Success success = (SignUpContinueApiResult.Success) signUpContinueApiResult;
            return new SignUpCommandResult.Complete(signUpContinueApiResult.getCorrelationId(), success.getContinuationToken(), success.getExpiresIn());
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.UsernameAlreadyExists) {
            SignUpContinueApiResult.UsernameAlreadyExists usernameAlreadyExists = (SignUpContinueApiResult.UsernameAlreadyExists) signUpContinueApiResult;
            return new SignUpCommandResult.UsernameAlreadyExists(signUpContinueApiResult.getCorrelationId(), usernameAlreadyExists.getError(), usernameAlreadyExists.getErrorDescription());
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.AttributesRequired) {
            SignUpContinueApiResult.AttributesRequired attributesRequired = (SignUpContinueApiResult.AttributesRequired) signUpContinueApiResult;
            return new SignUpCommandResult.AttributesRequired(signUpContinueApiResult.getCorrelationId(), attributesRequired.getContinuationToken(), attributesRequired.getError(), attributesRequired.getErrorDescription(), attributesRequired.getRequiredAttributes());
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.CredentialRequired) {
            SignUpStartCommandResult signUpStartCommandResult = toSignUpStartCommandResult(performSignUpChallengeCall(nativeAuthOAuth2Strategy, ((SignUpContinueApiResult.CredentialRequired) signUpContinueApiResult).getContinuationToken(), signUpContinueApiResult.getCorrelationId()));
            Intrinsics.checkNotNull(signUpStartCommandResult, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpSubmitPasswordCommandResult");
            return (SignUpSubmitPasswordCommandResult) signUpStartCommandResult;
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.InvalidPassword) {
            SignUpContinueApiResult.InvalidPassword invalidPassword = (SignUpContinueApiResult.InvalidPassword) signUpContinueApiResult;
            return new SignUpCommandResult.InvalidPassword(signUpContinueApiResult.getCorrelationId(), invalidPassword.getError(), invalidPassword.getErrorDescription(), invalidPassword.getSubError());
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.Redirect) {
            return new INativeAuthCommandResult.Redirect(signUpContinueApiResult.getCorrelationId(), ((SignUpContinueApiResult.Redirect) signUpContinueApiResult).getRedirectReason());
        }
        if (!(signUpContinueApiResult instanceof SignUpContinueApiResult.ExpiredToken ? true : signUpContinueApiResult instanceof SignUpContinueApiResult.InvalidOOBValue ? true : signUpContinueApiResult instanceof SignUpContinueApiResult.InvalidAttributes ? true : signUpContinueApiResult instanceof SignUpContinueApiResult.UnknownError)) {
            throw new NoWhenBranchMatchedException();
        }
        Logger.warnWithObject(TAG, signUpContinueApiResult.getCorrelationId(), "Error in signup continue result: ", signUpContinueApiResult);
        Intrinsics.checkNotNull(signUpContinueApiResult, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
        ApiErrorResult apiErrorResult = (ApiErrorResult) signUpContinueApiResult;
        return new INativeAuthCommandResult.APIError(apiErrorResult.getError(), apiErrorResult.getErrorDescription(), null, signUpContinueApiResult.getCorrelationId(), null, null, 52, null);
    }

    private final SignInStartCommandResult toSignInStartCommandResult(SignInIntrospectApiResult signInIntrospectApiResult) {
        if (signInIntrospectApiResult instanceof SignInIntrospectApiResult.Success) {
            String correlationId = signInIntrospectApiResult.getCorrelationId();
            SignInIntrospectApiResult.Success success = (SignInIntrospectApiResult.Success) signInIntrospectApiResult;
            return new SignInCommandResult.MFARequired(correlationId, success.getContinuationToken(), success.getMethods());
        }
        if (signInIntrospectApiResult instanceof SignInIntrospectApiResult.Redirect) {
            return new INativeAuthCommandResult.Redirect(signInIntrospectApiResult.getCorrelationId(), ((SignInIntrospectApiResult.Redirect) signInIntrospectApiResult).getRedirectReason());
        }
        if (!(signInIntrospectApiResult instanceof SignInIntrospectApiResult.UnknownError)) {
            throw new NoWhenBranchMatchedException();
        }
        Logger.warnWithObject(TAG, "Unexpected result: ", signInIntrospectApiResult);
        SignInIntrospectApiResult.UnknownError unknownError = (SignInIntrospectApiResult.UnknownError) signInIntrospectApiResult;
        return new INativeAuthCommandResult.APIError(unknownError.getError(), unknownError.getErrorDescription(), null, signInIntrospectApiResult.getCorrelationId(), unknownError.getErrorCodes(), null, 36, null);
    }

    private final SignInStartCommandResult toSignInStartCommandResult(JITIntrospectApiResult jITIntrospectApiResult) {
        if (jITIntrospectApiResult instanceof JITIntrospectApiResult.Success) {
            JITIntrospectApiResult.Success success = (JITIntrospectApiResult.Success) jITIntrospectApiResult;
            return new SignInCommandResult.StrongAuthMethodRegistrationRequired(jITIntrospectApiResult.getCorrelationId(), success.getContinuationToken(), success.getMethods());
        }
        if (jITIntrospectApiResult instanceof JITIntrospectApiResult.Redirect) {
            return new INativeAuthCommandResult.Redirect(jITIntrospectApiResult.getCorrelationId(), ((JITIntrospectApiResult.Redirect) jITIntrospectApiResult).getRedirectReason());
        }
        if (!(jITIntrospectApiResult instanceof JITIntrospectApiResult.UnknownError)) {
            throw new NoWhenBranchMatchedException();
        }
        Logger.warnWithObject(TAG, jITIntrospectApiResult.getCorrelationId(), "Unexpected result: ", jITIntrospectApiResult);
        JITIntrospectApiResult.UnknownError unknownError = (JITIntrospectApiResult.UnknownError) jITIntrospectApiResult;
        return new INativeAuthCommandResult.APIError(unknownError.getError(), unknownError.getErrorDescription(), null, jITIntrospectApiResult.getCorrelationId(), null, null, 52, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final SignInStartCommandResult toSignInStartCommandResult(SignInTokenApiResult signInTokenApiResult, NativeAuthOAuth2Strategy nativeAuthOAuth2Strategy, SignInStartCommandParameters signInStartCommandParameters) {
        if (signInTokenApiResult instanceof SignInTokenApiResult.InvalidCredentials) {
            SignInTokenApiResult.InvalidCredentials invalidCredentials = (SignInTokenApiResult.InvalidCredentials) signInTokenApiResult;
            return new SignInCommandResult.InvalidCredentials(signInTokenApiResult.getCorrelationId(), invalidCredentials.getError(), invalidCredentials.getErrorDescription(), invalidCredentials.getErrorCodes());
        }
        if (signInTokenApiResult instanceof SignInTokenApiResult.Success) {
            return saveAndReturnTokens(nativeAuthOAuth2Strategy, signInStartCommandParameters, (SignInTokenApiResult.Success) signInTokenApiResult);
        }
        if (signInTokenApiResult instanceof SignInTokenApiResult.MFARequired) {
            return toSignInStartCommandResult(performIntrospectCall(nativeAuthOAuth2Strategy, ((SignInTokenApiResult.MFARequired) signInTokenApiResult).getContinuationToken(), signInTokenApiResult.getCorrelationId()));
        }
        if (signInTokenApiResult instanceof SignInTokenApiResult.JITRequired) {
            return toSignInStartCommandResult(performJITIntrospect(nativeAuthOAuth2Strategy, signInStartCommandParameters, ((SignInTokenApiResult.JITRequired) signInTokenApiResult).getContinuationToken(), signInTokenApiResult.getCorrelationId()));
        }
        if (signInTokenApiResult instanceof SignInTokenApiResult.Redirect) {
            return new INativeAuthCommandResult.Redirect(signInTokenApiResult.getCorrelationId(), ((SignInTokenApiResult.Redirect) signInTokenApiResult).getRedirectReason());
        }
        if (!(signInTokenApiResult instanceof SignInTokenApiResult.CodeIncorrect ? true : signInTokenApiResult instanceof SignInTokenApiResult.InvalidAuthenticationType ? true : signInTokenApiResult instanceof SignInTokenApiResult.UserNotFound ? true : signInTokenApiResult instanceof SignInTokenApiResult.UnknownError)) {
            throw new NoWhenBranchMatchedException();
        }
        Logger.warnWithObject(TAG, signInTokenApiResult.getCorrelationId(), "Unexpected result: ", signInTokenApiResult);
        Intrinsics.checkNotNull(signInTokenApiResult, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
        ApiErrorResult apiErrorResult = (ApiErrorResult) signInTokenApiResult;
        return new INativeAuthCommandResult.APIError(apiErrorResult.getError(), apiErrorResult.getErrorDescription(), null, signInTokenApiResult.getCorrelationId(), apiErrorResult.getErrorCodes(), null, 36, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final SignInSubmitPasswordCommandResult toSignInSubmitPasswordCommandResult(SignInTokenApiResult signInTokenApiResult, NativeAuthOAuth2Strategy nativeAuthOAuth2Strategy, SignInSubmitPasswordCommandParameters signInSubmitPasswordCommandParameters) {
        if (signInTokenApiResult instanceof SignInTokenApiResult.InvalidCredentials) {
            SignInTokenApiResult.InvalidCredentials invalidCredentials = (SignInTokenApiResult.InvalidCredentials) signInTokenApiResult;
            return new SignInCommandResult.InvalidCredentials(signInTokenApiResult.getCorrelationId(), invalidCredentials.getError(), invalidCredentials.getErrorDescription(), invalidCredentials.getErrorCodes());
        }
        if (signInTokenApiResult instanceof SignInTokenApiResult.Success) {
            return saveAndReturnTokens(nativeAuthOAuth2Strategy, signInSubmitPasswordCommandParameters, (SignInTokenApiResult.Success) signInTokenApiResult);
        }
        if (signInTokenApiResult instanceof SignInTokenApiResult.MFARequired) {
            SignInStartCommandResult signInStartCommandResult = toSignInStartCommandResult(performIntrospectCall(nativeAuthOAuth2Strategy, ((SignInTokenApiResult.MFARequired) signInTokenApiResult).getContinuationToken(), signInTokenApiResult.getCorrelationId()));
            Intrinsics.checkNotNull(signInStartCommandResult, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.SignInSubmitPasswordCommandResult");
            return (SignInSubmitPasswordCommandResult) signInStartCommandResult;
        }
        if (signInTokenApiResult instanceof SignInTokenApiResult.JITRequired) {
            SignInStartCommandResult signInStartCommandResult2 = toSignInStartCommandResult(performJITIntrospect(nativeAuthOAuth2Strategy, signInSubmitPasswordCommandParameters, ((SignInTokenApiResult.JITRequired) signInTokenApiResult).getContinuationToken(), signInTokenApiResult.getCorrelationId()));
            Intrinsics.checkNotNull(signInStartCommandResult2, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.SignInSubmitPasswordCommandResult");
            return (SignInSubmitPasswordCommandResult) signInStartCommandResult2;
        }
        if (signInTokenApiResult instanceof SignInTokenApiResult.Redirect) {
            return new INativeAuthCommandResult.Redirect(signInTokenApiResult.getCorrelationId(), ((SignInTokenApiResult.Redirect) signInTokenApiResult).getRedirectReason());
        }
        if (!(signInTokenApiResult instanceof SignInTokenApiResult.UserNotFound ? true : signInTokenApiResult instanceof SignInTokenApiResult.CodeIncorrect ? true : signInTokenApiResult instanceof SignInTokenApiResult.InvalidAuthenticationType ? true : signInTokenApiResult instanceof SignInTokenApiResult.UnknownError)) {
            throw new NoWhenBranchMatchedException();
        }
        Logger.warnWithObject(TAG, signInTokenApiResult.getCorrelationId(), "Unexpected result: ", signInTokenApiResult);
        Intrinsics.checkNotNull(signInTokenApiResult, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
        ApiErrorResult apiErrorResult = (ApiErrorResult) signInTokenApiResult;
        return new INativeAuthCommandResult.APIError(apiErrorResult.getError(), apiErrorResult.getErrorDescription(), null, signInTokenApiResult.getCorrelationId(), apiErrorResult.getErrorCodes(), null, 36, null);
    }

    public static /* synthetic */ SignInStartCommandResult processSignInInitiateApiResult$default(NativeAuthMsalController nativeAuthMsalController, SignInInitiateApiResult signInInitiateApiResult, SignInStartCommandParameters signInStartCommandParameters, NativeAuthOAuth2Strategy nativeAuthOAuth2Strategy, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            signInStartCommandParameters = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return nativeAuthMsalController.processSignInInitiateApiResult(signInInitiateApiResult, signInStartCommandParameters, nativeAuthOAuth2Strategy, z);
    }

    public final SignInStartCommandResult processSignInInitiateApiResult(SignInInitiateApiResult initiateApiResult, SignInStartCommandParameters parametersWithScopes, NativeAuthOAuth2Strategy oAuth2Strategy, boolean usePassword) {
        Intrinsics.checkNotNullParameter(initiateApiResult, "initiateApiResult");
        Intrinsics.checkNotNullParameter(oAuth2Strategy, "oAuth2Strategy");
        if (initiateApiResult instanceof SignInInitiateApiResult.Redirect) {
            return new INativeAuthCommandResult.Redirect(initiateApiResult.getCorrelationId(), ((SignInInitiateApiResult.Redirect) initiateApiResult).getRedirectReason());
        }
        if (initiateApiResult instanceof SignInInitiateApiResult.Success) {
            return processSignInChallengeCall(oAuth2Strategy, parametersWithScopes, performSignInChallengeCall(oAuth2Strategy, ((SignInInitiateApiResult.Success) initiateApiResult).getContinuationToken(), initiateApiResult.getCorrelationId()), usePassword);
        }
        if (initiateApiResult instanceof SignInInitiateApiResult.UserNotFound) {
            SignInInitiateApiResult.UserNotFound userNotFound = (SignInInitiateApiResult.UserNotFound) initiateApiResult;
            return new SignInCommandResult.UserNotFound(initiateApiResult.getCorrelationId(), userNotFound.getError(), userNotFound.getErrorDescription(), userNotFound.getErrorCodes());
        }
        if (!(initiateApiResult instanceof SignInInitiateApiResult.UnknownError)) {
            throw new NoWhenBranchMatchedException();
        }
        Logger.warnWithObject(TAG, initiateApiResult.getCorrelationId(), "Unexpected result: ", initiateApiResult);
        SignInInitiateApiResult.UnknownError unknownError = (SignInInitiateApiResult.UnknownError) initiateApiResult;
        return new INativeAuthCommandResult.APIError(unknownError.getError(), unknownError.getErrorDescription(), null, initiateApiResult.getCorrelationId(), unknownError.getErrorCodes(), null, 36, null);
    }

    private final SignInStartCommandResult processSignInChallengeCall(NativeAuthOAuth2Strategy oAuth2Strategy, SignInStartCommandParameters parametersWithScopes, SignInChallengeApiResult result, boolean usePassword) {
        if (result instanceof SignInChallengeApiResult.OOBRequired) {
            SignInChallengeApiResult.OOBRequired oOBRequired = (SignInChallengeApiResult.OOBRequired) result;
            String continuationToken = oOBRequired.getContinuationToken();
            int codeLength = oOBRequired.getCodeLength();
            return new SignInCommandResult.CodeRequired(result.getCorrelationId(), continuationToken, oOBRequired.getChallengeTargetLabel(), oOBRequired.getChallengeChannel(), codeLength);
        }
        if (result instanceof SignInChallengeApiResult.PasswordRequired) {
            if (!usePassword) {
                return new SignInCommandResult.PasswordRequired(result.getCorrelationId(), ((SignInChallengeApiResult.PasswordRequired) result).getContinuationToken());
            }
            if (parametersWithScopes == null) {
                throw new IllegalArgumentException("Parameters must be provided in password flow");
            }
            SignInSubmitPasswordCommandParameters signInSubmitPasswordCommandParameters = CommandUtil.createSignInSubmitPasswordCommandParameters(parametersWithScopes, result.getCorrelationId(), ((SignInChallengeApiResult.PasswordRequired) result).getContinuationToken());
            try {
                Intrinsics.checkNotNullExpressionValue(signInSubmitPasswordCommandParameters, "signInSubmitPasswordCommandParameters");
                return toSignInStartCommandResult(performPasswordTokenCall(oAuth2Strategy, signInSubmitPasswordCommandParameters), oAuth2Strategy, parametersWithScopes);
            } finally {
                StringUtil.overwriteWithNull(signInSubmitPasswordCommandParameters.password);
            }
        }
        if (result instanceof SignInChallengeApiResult.Redirect) {
            return new INativeAuthCommandResult.Redirect(result.getCorrelationId(), ((SignInChallengeApiResult.Redirect) result).getRedirectReason());
        }
        if (result instanceof SignInChallengeApiResult.UnknownError) {
            Logger.warnWithObject(TAG, result.getCorrelationId(), "Unexpected result: ", result);
            SignInChallengeApiResult.UnknownError unknownError = (SignInChallengeApiResult.UnknownError) result;
            return new INativeAuthCommandResult.APIError(unknownError.getError(), unknownError.getErrorDescription(), null, result.getCorrelationId(), unknownError.getErrorCodes(), null, 36, null);
        }
        if (!(result instanceof SignInChallengeApiResult.BlockedAuthMethod)) {
            throw new NoWhenBranchMatchedException();
        }
        Logger.warnWithObject(TAG, result.getCorrelationId(), "Unexpected result: ", result);
        SignInChallengeApiResult.BlockedAuthMethod blockedAuthMethod = (SignInChallengeApiResult.BlockedAuthMethod) result;
        return new INativeAuthCommandResult.APIError(blockedAuthMethod.getError(), blockedAuthMethod.getErrorDescription(), null, result.getCorrelationId(), blockedAuthMethod.getErrorCodes(), null, 36, null);
    }

    private final NativeAuthOAuth2Strategy createOAuth2Strategy(BaseNativeAuthCommandParameters parameters) {
        OAuth2StrategyParameters strategyParameters = OAuth2StrategyParameters.builder().platformComponents(parameters.getPlatformComponents()).challengeTypes(parameters.challengeType).capabilities(parameters.capabilities).build();
        NativeAuthCIAMAuthority nativeAuthCIAMAuthority = parameters.authority;
        Intrinsics.checkNotNullExpressionValue(strategyParameters, "strategyParameters");
        return nativeAuthCIAMAuthority.createOAuth2Strategy(strategyParameters);
    }
}
