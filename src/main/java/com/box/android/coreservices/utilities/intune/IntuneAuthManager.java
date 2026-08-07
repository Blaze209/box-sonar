package com.box.android.coreservices.utilities.intune;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.box.android.base.presentation.activities.BoxIntuneMAMAuthActivityKt;
import com.box.android.coreservices.R;
import com.box.android.coreservices.models.BoxAccountManager;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.coreservices.services.NotificationServices;
import com.box.android.coreservices.utilities.intune.receivers.ComplianceNotificationReceiver;
import com.box.android.coreservices.utilities.intune.receivers.EnrollmentNotificationReceiver;
import com.box.android.coreservices.utilities.intune.receivers.PolicyChangeNotificationReceiver;
import com.box.android.coreservices.utilities.intune.receivers.WipeDataNotificationReceiver;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IExecutorPool;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.domain.metrics.msal.EnrollmentMethod;
import com.box.android.domain.metrics.msal.MsalObservability;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.microsoft.identity.client.AcquireTokenParameters;
import com.microsoft.identity.client.AcquireTokenSilentParameters;
import com.microsoft.identity.client.AuthenticationCallback;
import com.microsoft.identity.client.IAccount;
import com.microsoft.identity.client.IAuthenticationResult;
import com.microsoft.identity.client.ICurrentAccountResult;
import com.microsoft.identity.client.ISingleAccountPublicClientApplication;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.client.exception.MsalIntuneAppProtectionPolicyRequiredException;
import com.microsoft.identity.client.exception.MsalUiRequiredException;
import com.microsoft.intune.mam.client.identity.MAMPolicyManager;
import com.microsoft.intune.mam.client.notification.MAMNotificationReceiverRegistry;
import com.microsoft.intune.mam.policy.MAMCAComplianceStatus;
import com.microsoft.intune.mam.policy.MAMComplianceManager;
import com.microsoft.intune.mam.policy.MAMEnrollmentManager;
import com.microsoft.intune.mam.policy.MAMServiceAuthenticationCallback;
import com.microsoft.intune.mam.policy.notification.MAMNotificationType;
import defpackage.IntuneNonceCalculator;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: IntuneAuthManager.kt */
/* JADX INFO: loaded from: classes9.dex */
@Singleton
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 o2\u00020\u0001:\u0002opBA\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\b\u00101\u001a\u000202H\u0002J\u0006\u00103\u001a\u000202J\u0010\u00104\u001a\u0002022\u0006\u00105\u001a\u00020*H\u0002J\u000e\u00106\u001a\u0002022\u0006\u00107\u001a\u00020*J\u0006\u00108\u001a\u00020*J\"\u00109\u001a\u0002022\u0006\u0010:\u001a\u00020;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00182\u0006\u0010=\u001a\u00020>J,\u0010?\u001a\u0002022\u0006\u0010:\u001a\u00020;2\u0006\u0010=\u001a\u00020>2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00182\u0006\u0010@\u001a\u00020AH\u0002J*\u0010B\u001a\u00020C2\b\u0010<\u001a\u0004\u0018\u00010\u00182\u0006\u0010:\u001a\u00020;2\u0006\u0010=\u001a\u00020>2\u0006\u0010@\u001a\u00020AH\u0002J2\u0010D\u001a\u0002022\u0006\u0010E\u001a\u00020F2\u0006\u0010:\u001a\u00020;2\u0006\u0010=\u001a\u00020>2\b\u0010<\u001a\u0004\u0018\u00010\u00182\u0006\u0010@\u001a\u00020AH\u0002J*\u0010G\u001a\u0002022\u0006\u0010:\u001a\u00020;2\u0006\u0010=\u001a\u00020>2\b\u0010<\u001a\u0004\u0018\u00010\u00182\u0006\u0010@\u001a\u00020AH\u0002J\b\u0010H\u001a\u000202H\u0002J\u0006\u0010I\u001a\u000202J\r\u0010J\u001a\u000202H\u0000¢\u0006\u0002\bKJ\r\u0010L\u001a\u000202H\u0000¢\u0006\u0002\bMJ\r\u0010N\u001a\u000202H\u0000¢\u0006\u0002\bOJ\u000f\u0010P\u001a\u0004\u0018\u00010\u0018H\u0000¢\u0006\u0002\bQJ7\u0010R\u001a\u0002022\u0006\u0010E\u001a\u00020S2\u0006\u0010:\u001a\u00020;2\u0006\u0010=\u001a\u00020>2\b\u0010<\u001a\u0004\u0018\u00010\u00182\u0006\u0010@\u001a\u00020AH\u0000¢\u0006\u0002\bTJ)\u0010U\u001a\u0002022\u0006\u0010V\u001a\u00020W2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00182\u0006\u0010@\u001a\u00020AH\u0000¢\u0006\u0002\bXJ\u0010\u0010Y\u001a\u0002022\u0006\u0010Z\u001a\u00020[H\u0002J\u0010\u0010\\\u001a\u0002022\u0006\u0010Z\u001a\u00020[H\u0002J\u0006\u0010]\u001a\u000202J\u0006\u0010^\u001a\u000202J\u001f\u0010_\u001a\u00020*2\u0006\u0010`\u001a\u00020\u00182\b\u0010<\u001a\u0004\u0018\u00010\u0018H\u0000¢\u0006\u0002\baJ\r\u0010b\u001a\u00020AH\u0000¢\u0006\u0002\bcJ\u0006\u00105\u001a\u00020*J\u0006\u0010d\u001a\u00020*J\u0006\u0010e\u001a\u00020*J\u0006\u0010f\u001a\u00020*J\"\u0010g\u001a\u0004\u0018\u00010\u00182\u0006\u0010`\u001a\u00020\u00182\u0006\u0010h\u001a\u00020\u00182\u0006\u0010i\u001a\u00020\u0018H\u0016J\u0006\u0010j\u001a\u00020kJ\b\u0010l\u001a\u0004\u0018\u00010kJ\u0017\u0010m\u001a\u0004\u0018\u00010[2\u0006\u0010h\u001a\u00020\u0018H\u0000¢\u0006\u0002\bnR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020 X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020&8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020,X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006q"}, d2 = {"Lcom/box/android/coreservices/utilities/intune/IntuneAuthManager;", "Lcom/microsoft/intune/mam/policy/MAMServiceAuthenticationCallback;", "context", "Landroid/content/Context;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "intuneComponentCreator", "Lcom/box/android/coreservices/utilities/intune/IntuneComponentCreator;", "notificationServices", "Lcom/box/android/coreservices/services/NotificationServices;", "msalObservability", "Lcom/box/android/domain/metrics/msal/MsalObservability;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "<init>", "(Landroid/content/Context;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/coreservices/utilities/intune/IntuneComponentCreator;Lcom/box/android/coreservices/services/NotificationServices;Lcom/box/android/domain/metrics/msal/MsalObservability;Lcom/box/android/coreservices/services/IntentServices;Lcom/box/android/domain/configuration/FeatureFlips;)V", "getContext", "()Landroid/content/Context;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "mapBoxTestAccounts", "", "", "mamEnrollmentManager", "Lcom/microsoft/intune/mam/policy/MAMEnrollmentManager;", "mamComplianceManager", "Lcom/microsoft/intune/mam/policy/MAMComplianceManager;", "mamNotificationRegistry", "Lcom/microsoft/intune/mam/client/notification/MAMNotificationReceiverRegistry;", "singleAccountApp", "Lcom/microsoft/identity/client/ISingleAccountPublicClientApplication;", "getSingleAccountApp", "()Lcom/microsoft/identity/client/ISingleAccountPublicClientApplication;", "setSingleAccountApp", "(Lcom/microsoft/identity/client/ISingleAccountPublicClientApplication;)V", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "enrollmentInProgress", "", "singleAccountAppCreationException", "", "getSingleAccountAppCreationException$coreservices_generalProdRelease", "()Ljava/lang/Throwable;", "setSingleAccountAppCreationException$coreservices_generalProdRelease", "(Ljava/lang/Throwable;)V", "initMsal", "", "registerAuthCallBack", "updateLoginNeeded", "isLoginNeeded", "setLoginNeeded", "needed", "isEnrollmentInProgress", "login", "activity", "Landroid/app/Activity;", BoxIntuneMAMAuthActivityKt.USER_EMAIL_EXTRA, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/box/android/coreservices/utilities/intune/IntuneAuthManager$MAMListener;", "acquireTokenInteractively", "enrollmentMethod", "Lcom/box/android/domain/metrics/msal/EnrollmentMethod;", "getAuthInteractiveCallback", "Lcom/microsoft/identity/client/AuthenticationCallback;", "remediateCompliance", "exception", "Lcom/microsoft/identity/client/exception/MsalIntuneAppProtectionPolicyRequiredException;", "registerComplianceListener", "registerWipeDataListener", "registerPolicyChangeListener", "handleUnenrollment", "handleUnenrollment$coreservices_generalProdRelease", "onPolicyRefreshReceived", "onPolicyRefreshReceived$coreservices_generalProdRelease", "triggerBlockingScreen", "triggerBlockingScreen$coreservices_generalProdRelease", "getEnforcedUPN", "getEnforcedUPN$coreservices_generalProdRelease", "handleSignInError", "Lcom/microsoft/identity/client/exception/MsalException;", "handleSignInError$coreservices_generalProdRelease", "handleSignInSuccess", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "Lcom/microsoft/identity/client/IAuthenticationResult;", "handleSignInSuccess$coreservices_generalProdRelease", "registerAccountForMAM", "account", "Lcom/microsoft/identity/client/IAccount;", "updateTokenIfNeeded", "clearIntunePrefs", "signOutUser", "isValidUPN", "upn", "isValidUPN$coreservices_generalProdRelease", "resolveEnrollmentMethod", "resolveEnrollmentMethod$coreservices_generalProdRelease", "hasStoredAadId", "shouldBlockUser", "isIdentityManaged", "acquireToken", "aadId", "resourceId", "getIntuneSharedPrefs", "Landroid/content/SharedPreferences;", "getEncryptedIntuneSharedPrefs", "getAccount", "getAccount$coreservices_generalProdRelease", "Companion", "MAMListener", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class IntuneAuthManager implements MAMServiceAuthenticationCallback {
    public static final String MSAL_NONCE_PARAMETER = "nonce";
    public static final String SCOPE = "https://graph.microsoft.com/User.Read";
    public static final String SP_AAD_ID = "intune_shared_pref_aadId";
    public static final String SP_ENROLLED_AAD_ID = "intune_shared_pref_enrolled_aad_id";
    public static final String SP_LOG_IN_NEEDED = "intune_shared_pref_login_needed";
    public static final String SP_RESOURCE_ID = "intune_shared_pref_resourceId";
    private final Context context;
    private volatile boolean enrollmentInProgress;
    private final FeatureFlips featureFlips;
    private final IntentServices intentServices;
    private final IntuneComponentCreator intuneComponentCreator;
    private MAMComplianceManager mamComplianceManager;
    private MAMEnrollmentManager mamEnrollmentManager;
    private MAMNotificationReceiverRegistry mamNotificationRegistry;
    private final Map<String, String> mapBoxTestAccounts;
    private final MsalObservability msalObservability;
    private final NotificationServices notificationServices;
    public ISingleAccountPublicClientApplication singleAccountApp;
    public Throwable singleAccountAppCreationException;
    private final IUserContextManager userContextManager;

    @Inject
    public IntuneAuthManager(Context context, IUserContextManager userContextManager, IntuneComponentCreator intuneComponentCreator, NotificationServices notificationServices, MsalObservability msalObservability, IntentServices intentServices, FeatureFlips featureFlips) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(intuneComponentCreator, "intuneComponentCreator");
        Intrinsics.checkNotNullParameter(notificationServices, "notificationServices");
        Intrinsics.checkNotNullParameter(msalObservability, "msalObservability");
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        this.context = context;
        this.userContextManager = userContextManager;
        this.intuneComponentCreator = intuneComponentCreator;
        this.notificationServices = notificationServices;
        this.msalObservability = msalObservability;
        this.intentServices = intentServices;
        this.featureFlips = featureFlips;
        this.mapBoxTestAccounts = MapsKt.mapOf(TuplesKt.to("box-internal-qa+stagingbfd1@boxdemo.com", "boxer@iosbox.onmicrosoft.com"), TuplesKt.to("apps-test-team@box.com", "boxer@iosbox.onmicrosoft.com"), TuplesKt.to("ashankar+biz3@boxdemo.com", "mobile-dev@boxeng.onmicrosoft.com"), TuplesKt.to("mthiha+staging+emm+tier2@boxdemo.com", "boxer@iosbox.onmicrosoft.com"), TuplesKt.to("box-internal-qa+mobilelive2@boxdemo.com", "boxer@iosbox.onmicrosoft.com"));
        userContextManager.getBoxSession(context);
    }

    public final Context getContext() {
        return this.context;
    }

    public final IUserContextManager getUserContextManager() {
        return this.userContextManager;
    }

    public final ISingleAccountPublicClientApplication getSingleAccountApp() {
        ISingleAccountPublicClientApplication iSingleAccountPublicClientApplication = this.singleAccountApp;
        if (iSingleAccountPublicClientApplication != null) {
            return iSingleAccountPublicClientApplication;
        }
        Intrinsics.throwUninitializedPropertyAccessException("singleAccountApp");
        return null;
    }

    public final void setSingleAccountApp(ISingleAccountPublicClientApplication iSingleAccountPublicClientApplication) {
        Intrinsics.checkNotNullParameter(iSingleAccountPublicClientApplication, "<set-?>");
        this.singleAccountApp = iSingleAccountPublicClientApplication;
    }

    private final Handler getMainHandler() {
        return new Handler(Looper.getMainLooper());
    }

    public final Throwable getSingleAccountAppCreationException$coreservices_generalProdRelease() {
        Throwable th = this.singleAccountAppCreationException;
        if (th != null) {
            return th;
        }
        Intrinsics.throwUninitializedPropertyAccessException("singleAccountAppCreationException");
        return null;
    }

    public final void setSingleAccountAppCreationException$coreservices_generalProdRelease(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<set-?>");
        this.singleAccountAppCreationException = th;
    }

    /* JADX INFO: compiled from: IntuneAuthManager.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tH&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/box/android/coreservices/utilities/intune/IntuneAuthManager$MAMListener;", "", "onSuccess", "", "tokenId", "", "onError", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface MAMListener {
        void onError(Exception exception);

        void onSuccess(String tokenId);

        /* JADX INFO: compiled from: IntuneAuthManager.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class DefaultImpls {
        }

        static /* synthetic */ void onError$default(MAMListener mAMListener, Exception exc, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onError");
            }
            if ((i & 1) != 0) {
                exc = null;
            }
            mAMListener.onError(exc);
        }
    }

    private final synchronized void initMsal() {
        if (this.singleAccountApp != null) {
            return;
        }
        try {
            setSingleAccountApp(this.intuneComponentCreator.createSingleApp(this.context));
        } catch (Exception e) {
            setSingleAccountAppCreationException$coreservices_generalProdRelease(e);
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "If Intune testing is needed you may need to run mam_key_replacement.sh");
            BoxLogUtils.e(ExtensionsKt.getTAG(this), e);
        }
    }

    public final void registerAuthCallBack() {
        MAMEnrollmentManager mAMEnrollmentManagerCreateEnrollmentManager = this.intuneComponentCreator.createEnrollmentManager();
        this.mamEnrollmentManager = mAMEnrollmentManagerCreateEnrollmentManager;
        if (mAMEnrollmentManagerCreateEnrollmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mamEnrollmentManager");
            mAMEnrollmentManagerCreateEnrollmentManager = null;
        }
        mAMEnrollmentManagerCreateEnrollmentManager.registerAuthenticationCallback(this);
        registerPolicyChangeListener();
    }

    private final void updateLoginNeeded(boolean isLoginNeeded) {
        SharedPreferences.Editor editorEdit = getIntuneSharedPrefs().edit();
        editorEdit.putBoolean(SP_LOG_IN_NEEDED, isLoginNeeded);
        editorEdit.apply();
    }

    public final void setLoginNeeded(boolean needed) {
        updateLoginNeeded(needed);
    }

    /* JADX INFO: renamed from: isEnrollmentInProgress, reason: from getter */
    public final boolean getEnrollmentInProgress() {
        return this.enrollmentInProgress;
    }

    public static /* synthetic */ void login$default(IntuneAuthManager intuneAuthManager, Activity activity, String str, MAMListener mAMListener, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: login");
        }
        if ((i & 2) != 0) {
            str = null;
        }
        intuneAuthManager.login(activity, str, mAMListener);
    }

    public final void login(Activity activity, String userEmail, MAMListener listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.enrollmentInProgress) {
            BoxLogUtils.w(ExtensionsKt.getTAG(this), "Enrollment already in progress, ignoring duplicate request");
            return;
        }
        EnrollmentMethod enrollmentMethodResolveEnrollmentMethod$coreservices_generalProdRelease = resolveEnrollmentMethod$coreservices_generalProdRelease();
        initMsal();
        if (this.singleAccountApp == null && this.singleAccountAppCreationException != null) {
            this.notificationServices.displayToast(getSingleAccountAppCreationException$coreservices_generalProdRelease().getLocalizedMessage(), this.context);
            BoxLogUtils.e(ExtensionsKt.getTAG(this), getSingleAccountAppCreationException$coreservices_generalProdRelease());
            MsalObservability.logMsalLoginFailed$default(this.msalObservability, "not initialized", null, enrollmentMethodResolveEnrollmentMethod$coreservices_generalProdRelease, 2, null);
            MAMListener.onError$default(listener, null, 1, null);
            return;
        }
        this.enrollmentInProgress = true;
        acquireTokenInteractively(activity, listener, userEmail, enrollmentMethodResolveEnrollmentMethod$coreservices_generalProdRelease);
        this.msalObservability.logMsalLoginStarted(enrollmentMethodResolveEnrollmentMethod$coreservices_generalProdRelease);
    }

    static /* synthetic */ void acquireTokenInteractively$default(IntuneAuthManager intuneAuthManager, Activity activity, MAMListener mAMListener, String str, EnrollmentMethod enrollmentMethod, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: acquireTokenInteractively");
        }
        if ((i & 4) != 0) {
            str = null;
        }
        intuneAuthManager.acquireTokenInteractively(activity, mAMListener, str, enrollmentMethod);
    }

    private final void acquireTokenInteractively(Activity activity, MAMListener listener, String userEmail, EnrollmentMethod enrollmentMethod) {
        List<Map.Entry<String, String>> mutableList = CollectionsKt.toMutableList((Collection) MapsKt.mapOf(TuplesKt.to("nonce", IntuneNonceCalculator.INSTANCE.calculateNonceFromEmail(userEmail))).entrySet());
        if (userEmail == null) {
            userEmail = getEnforcedUPN$coreservices_generalProdRelease();
        }
        getSingleAccountApp().acquireToken(new AcquireTokenParameters.Builder().withAuthorizationQueryStringParameters(mutableList).withScopes(CollectionsKt.listOf(SCOPE)).startAuthorizationFromActivity(activity).withLoginHint(userEmail).withCallback(getAuthInteractiveCallback(userEmail, activity, listener, enrollmentMethod)).build());
    }

    private final AuthenticationCallback getAuthInteractiveCallback(final String userEmail, final Activity activity, final MAMListener listener, final EnrollmentMethod enrollmentMethod) {
        return new AuthenticationCallback() { // from class: com.box.android.coreservices.utilities.intune.IntuneAuthManager.getAuthInteractiveCallback.1
            @Override // com.microsoft.identity.client.SilentAuthenticationCallback
            public void onSuccess(IAuthenticationResult authenticationResult) {
                Intrinsics.checkNotNullParameter(authenticationResult, "authenticationResult");
                IntuneAuthManager.this.msalObservability.logMsalLoginSucceeded(enrollmentMethod);
                IntuneAuthManager.this.handleSignInSuccess$coreservices_generalProdRelease(authenticationResult, userEmail, enrollmentMethod);
                IntuneAuthManager.this.enrollmentInProgress = false;
                listener.onSuccess(authenticationResult.getAccount().getIdToken());
            }

            @Override // com.microsoft.identity.client.AuthenticationCallback
            public void onCancel() {
                IntuneAuthManager.this.msalObservability.logMsalLoginCanceled(Integer.valueOf(MsalExceptionMapper.INSTANCE.getCanceledErrorCode()), enrollmentMethod);
                IntuneAuthManager.this.enrollmentInProgress = false;
                MAMListener.onError$default(listener, null, 1, null);
            }

            @Override // com.microsoft.identity.client.SilentAuthenticationCallback
            public void onError(MsalException exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                BoxLogUtils.w(ExtensionsKt.getTAG(this), "MSAL login failure: " + exception.getErrorCode() + " " + exception.getMessage());
                IntuneAuthManager.this.msalObservability.logMsalLoginFailed(exception.getMessage(), MsalExceptionMapper.INSTANCE.getErrorCode(exception), enrollmentMethod);
                IntuneAuthManager.this.enrollmentInProgress = false;
                IntuneAuthManager.this.handleSignInError$coreservices_generalProdRelease(exception, activity, listener, userEmail, enrollmentMethod);
            }
        };
    }

    private final void remediateCompliance(MsalIntuneAppProtectionPolicyRequiredException exception, Activity activity, MAMListener listener, String userEmail, EnrollmentMethod enrollmentMethod) {
        this.mamComplianceManager = this.intuneComponentCreator.createComplianceManager();
        registerComplianceListener(activity, listener, userEmail, enrollmentMethod);
        MAMComplianceManager mAMComplianceManager = this.mamComplianceManager;
        if (mAMComplianceManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mamComplianceManager");
            mAMComplianceManager = null;
        }
        mAMComplianceManager.remediateCompliance(exception.getAccountUpn(), exception.getAccountUserId(), exception.getTenantId(), exception.getAuthorityUrl(), true);
        this.msalObservability.logMsalRemediateStarted();
    }

    private final void registerComplianceListener(final Activity activity, final MAMListener listener, final String userEmail, final EnrollmentMethod enrollmentMethod) {
        this.mamNotificationRegistry = this.intuneComponentCreator.createNotificationRegistry();
        MAMNotificationReceiverRegistry mAMNotificationReceiverRegistry = this.mamNotificationRegistry;
        MAMNotificationReceiverRegistry mAMNotificationReceiverRegistry2 = null;
        if (mAMNotificationReceiverRegistry == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mamNotificationRegistry");
            mAMNotificationReceiverRegistry = null;
        }
        ComplianceNotificationReceiver complianceNotificationReceiver = new ComplianceNotificationReceiver(mAMNotificationReceiverRegistry, this.notificationServices, new Function0() { // from class: com.box.android.coreservices.utilities.intune.IntuneAuthManager$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return IntuneAuthManager.registerComplianceListener$lambda$0(this.f$0, activity, listener, userEmail, enrollmentMethod);
            }
        }, new Function3() { // from class: com.box.android.coreservices.utilities.intune.IntuneAuthManager$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return IntuneAuthManager.registerComplianceListener$lambda$1(this.f$0, listener, (String) obj, (String) obj2, (MAMCAComplianceStatus) obj3);
            }
        });
        MAMNotificationReceiverRegistry mAMNotificationReceiverRegistry3 = this.mamNotificationRegistry;
        if (mAMNotificationReceiverRegistry3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mamNotificationRegistry");
        } else {
            mAMNotificationReceiverRegistry2 = mAMNotificationReceiverRegistry3;
        }
        mAMNotificationReceiverRegistry2.registerReceiver(complianceNotificationReceiver, MAMNotificationType.COMPLIANCE_STATUS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit registerComplianceListener$lambda$0(IntuneAuthManager intuneAuthManager, Activity activity, MAMListener mAMListener, String str, EnrollmentMethod enrollmentMethod) {
        BoxLogUtils.i(ExtensionsKt.getTAG(intuneAuthManager), "User is MAM compliant again, attempt to remediate by acquiring token.");
        intuneAuthManager.msalObservability.logMsalRemediateSucceeded();
        intuneAuthManager.acquireTokenInteractively(activity, mAMListener, str, enrollmentMethod);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit registerComplianceListener$lambda$1(IntuneAuthManager intuneAuthManager, MAMListener mAMListener, String title, String message, MAMCAComplianceStatus status) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(status, "status");
        BoxLogUtils.w(ExtensionsKt.getTAG(intuneAuthManager), "User is MAM non-compliant. " + title + " " + message);
        intuneAuthManager.msalObservability.logMsalRemediateFailed(message, Integer.valueOf(status.getCode()));
        MAMListener.onError$default(mAMListener, null, 1, null);
        return Unit.INSTANCE;
    }

    private final void registerWipeDataListener() {
        this.mamNotificationRegistry = this.intuneComponentCreator.createNotificationRegistry();
        MAMNotificationReceiverRegistry mAMNotificationReceiverRegistry = this.mamNotificationRegistry;
        MAMNotificationReceiverRegistry mAMNotificationReceiverRegistry2 = null;
        if (mAMNotificationReceiverRegistry == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mamNotificationRegistry");
            mAMNotificationReceiverRegistry = null;
        }
        WipeDataNotificationReceiver wipeDataNotificationReceiver = new WipeDataNotificationReceiver(mAMNotificationReceiverRegistry, this.notificationServices, this.context);
        MAMNotificationReceiverRegistry mAMNotificationReceiverRegistry3 = this.mamNotificationRegistry;
        if (mAMNotificationReceiverRegistry3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mamNotificationRegistry");
        } else {
            mAMNotificationReceiverRegistry2 = mAMNotificationReceiverRegistry3;
        }
        mAMNotificationReceiverRegistry2.registerReceiver(wipeDataNotificationReceiver, MAMNotificationType.WIPE_USER_DATA);
    }

    public final void registerPolicyChangeListener() {
        this.mamNotificationRegistry = this.intuneComponentCreator.createNotificationRegistry();
        this.mamEnrollmentManager = this.intuneComponentCreator.createEnrollmentManager();
        PolicyChangeNotificationReceiver policyChangeNotificationReceiver = new PolicyChangeNotificationReceiver(new Function0() { // from class: com.box.android.coreservices.utilities.intune.IntuneAuthManager$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return IntuneAuthManager.registerPolicyChangeListener$lambda$0(this.f$0);
            }
        });
        MAMNotificationReceiverRegistry mAMNotificationReceiverRegistry = this.mamNotificationRegistry;
        MAMNotificationReceiverRegistry mAMNotificationReceiverRegistry2 = null;
        if (mAMNotificationReceiverRegistry == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mamNotificationRegistry");
            mAMNotificationReceiverRegistry = null;
        }
        mAMNotificationReceiverRegistry.registerReceiver(policyChangeNotificationReceiver, MAMNotificationType.REFRESH_POLICY);
        EnrollmentNotificationReceiver enrollmentNotificationReceiver = new EnrollmentNotificationReceiver(new Function0() { // from class: com.box.android.coreservices.utilities.intune.IntuneAuthManager$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return IntuneAuthManager.registerPolicyChangeListener$lambda$1(this.f$0);
            }
        });
        MAMNotificationReceiverRegistry mAMNotificationReceiverRegistry3 = this.mamNotificationRegistry;
        if (mAMNotificationReceiverRegistry3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mamNotificationRegistry");
        } else {
            mAMNotificationReceiverRegistry2 = mAMNotificationReceiverRegistry3;
        }
        mAMNotificationReceiverRegistry2.registerReceiver(enrollmentNotificationReceiver, MAMNotificationType.MAM_ENROLLMENT_RESULT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit registerPolicyChangeListener$lambda$0(IntuneAuthManager intuneAuthManager) {
        intuneAuthManager.onPolicyRefreshReceived$coreservices_generalProdRelease();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit registerPolicyChangeListener$lambda$1(IntuneAuthManager intuneAuthManager) {
        intuneAuthManager.handleUnenrollment$coreservices_generalProdRelease();
        return Unit.INSTANCE;
    }

    public final void handleUnenrollment$coreservices_generalProdRelease() {
        boolean zIsIntuneMAMEnabled = BoxAccountManager.isIntuneMAMEnabled(this.userContextManager.getUserSharedPrefs());
        BoxLogUtils.w(ExtensionsKt.getTAG(this), "Handling unenrollment, isIntuneMAMEnabled=" + zIsIntuneMAMEnabled);
        SharedPreferences encryptedIntuneSharedPrefs = getEncryptedIntuneSharedPrefs();
        if (encryptedIntuneSharedPrefs != null) {
            SharedPreferences.Editor editorEdit = encryptedIntuneSharedPrefs.edit();
            editorEdit.remove(SP_ENROLLED_AAD_ID);
            editorEdit.apply();
        }
        if (zIsIntuneMAMEnabled) {
            updateLoginNeeded(true);
            triggerBlockingScreen$coreservices_generalProdRelease();
        }
    }

    public final void onPolicyRefreshReceived$coreservices_generalProdRelease() {
        BoxLogUtils.i(ExtensionsKt.getTAG(this), "Policy refresh received, shouldBlockUser=" + shouldBlockUser());
        if (shouldBlockUser()) {
            BoxLogUtils.w(ExtensionsKt.getTAG(this), "Policy refresh: user lost policies, triggering blocking screen");
            updateLoginNeeded(true);
            triggerBlockingScreen$coreservices_generalProdRelease();
            return;
        }
        BoxLogUtils.i(ExtensionsKt.getTAG(this), "Policy refresh: user still has policies or Intune not enabled, no action needed");
    }

    public final void triggerBlockingScreen$coreservices_generalProdRelease() {
        getMainHandler().post(new Runnable() { // from class: com.box.android.coreservices.utilities.intune.IntuneAuthManager$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                IntuneAuthManager.triggerBlockingScreen$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void triggerBlockingScreen$lambda$0(IntuneAuthManager intuneAuthManager) {
        try {
            Intent intentBoxIntuneMAMAuthActivityIntent$default = IntentServices.boxIntuneMAMAuthActivityIntent$default(intuneAuthManager.intentServices, intuneAuthManager.context, null, false, null, true, 14, null);
            intentBoxIntuneMAMAuthActivityIntent$default.addFlags(335544320);
            intuneAuthManager.context.startActivity(intentBoxIntuneMAMAuthActivityIntent$default);
            BoxLogUtils.i(ExtensionsKt.getTAG(intuneAuthManager), "Triggered blocking screen from policy refresh notification");
        } catch (Exception e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(intuneAuthManager), "Failed to trigger blocking screen: " + e.getMessage());
        }
    }

    public final String getEnforcedUPN$coreservices_generalProdRelease() {
        String login;
        String intuneUPN = IntuneKeysConfigUtils.getIntuneUPN();
        if (!Intrinsics.areEqual(intuneUPN, "")) {
            return intuneUPN;
        }
        BoxUser userInfo = this.userContextManager.getUserInfo();
        if (userInfo == null || (login = userInfo.getLogin()) == null) {
            return null;
        }
        String str = this.mapBoxTestAccounts.get(login);
        return str == null ? login : str;
    }

    public final void handleSignInError$coreservices_generalProdRelease(MsalException exception, Activity activity, MAMListener listener, String userEmail, EnrollmentMethod enrollmentMethod) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(enrollmentMethod, "enrollmentMethod");
        BoxLogUtils.e(ExtensionsKt.getTAG(this), exception);
        if (exception instanceof MsalIntuneAppProtectionPolicyRequiredException) {
            remediateCompliance((MsalIntuneAppProtectionPolicyRequiredException) exception, activity, listener, userEmail, enrollmentMethod);
            return;
        }
        String errorCode = exception.getErrorCode();
        if (errorCode.hashCode() == 1444422371 && errorCode.equals("device_network_not_available")) {
            this.notificationServices.displayToast(R.string.err_conn1, this.context);
        } else if (exception.getLocalizedMessage() != null) {
            this.notificationServices.displayToast(exception.getLocalizedMessage(), this.context);
        } else {
            this.notificationServices.displayToast(R.string.err_unknown, this.context);
        }
        listener.onError(exception);
    }

    public static /* synthetic */ void handleSignInSuccess$coreservices_generalProdRelease$default(IntuneAuthManager intuneAuthManager, IAuthenticationResult iAuthenticationResult, String str, EnrollmentMethod enrollmentMethod, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleSignInSuccess");
        }
        if ((i & 2) != 0) {
            str = null;
        }
        intuneAuthManager.handleSignInSuccess$coreservices_generalProdRelease(iAuthenticationResult, str, enrollmentMethod);
    }

    public final void handleSignInSuccess$coreservices_generalProdRelease(IAuthenticationResult result, String userEmail, EnrollmentMethod enrollmentMethod) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(enrollmentMethod, "enrollmentMethod");
        IAccount account = result.getAccount();
        Intrinsics.checkNotNullExpressionValue(account, "getAccount(...)");
        String username = account.getUsername();
        Intrinsics.checkNotNullExpressionValue(username, "getUsername(...)");
        if (this.featureFlips.getIntuneOidBasedEnrollment().getEnabled()) {
            BoxLogUtils.i(ExtensionsKt.getTAG(this), "OID-based enrollment: bypassing UPN validation");
        } else if (!isValidUPN$coreservices_generalProdRelease(username, userEmail)) {
            BoxLogUtils.w(ExtensionsKt.getTAG(this), "User signed in with an invalid account");
            this.msalObservability.logMsalUpnMismatch(enrollmentMethod);
            this.notificationServices.displayToast(R.string.intune_login_with_correct_account, this.context);
            signOutUser();
            return;
        }
        registerAccountForMAM(account);
        updateTokenIfNeeded(account);
    }

    private final void registerAccountForMAM(IAccount account) {
        String id = account.getId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        String tenantId = account.getTenantId();
        Intrinsics.checkNotNullExpressionValue(tenantId, "getTenantId(...)");
        String authority = account.getAuthority();
        Intrinsics.checkNotNullExpressionValue(authority, "getAuthority(...)");
        String username = account.getUsername();
        Intrinsics.checkNotNullExpressionValue(username, "getUsername(...)");
        MAMEnrollmentManager mAMEnrollmentManager = this.mamEnrollmentManager;
        if (mAMEnrollmentManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mamEnrollmentManager");
            mAMEnrollmentManager = null;
        }
        mAMEnrollmentManager.registerAccountForMAM(username, id, tenantId, authority);
        SharedPreferences encryptedIntuneSharedPrefs = getEncryptedIntuneSharedPrefs();
        if (encryptedIntuneSharedPrefs != null) {
            SharedPreferences.Editor editorEdit = encryptedIntuneSharedPrefs.edit();
            editorEdit.putString(SP_ENROLLED_AAD_ID, id);
            editorEdit.apply();
        }
    }

    private final void updateTokenIfNeeded(final IAccount account) {
        final String id = account.getId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        if (Intrinsics.areEqual(id, getIntuneSharedPrefs().getString(SP_AAD_ID, ""))) {
            IUserContextComponent userContextComponent = this.userContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.EXECUTOR_POOL);
            Intrinsics.checkNotNull(userContextComponent, "null cannot be cast to non-null type com.box.android.domain.identity.IExecutorPool");
            ((IExecutorPool) userContextComponent).getApiExecutor().execute(new Runnable() { // from class: com.box.android.coreservices.utilities.intune.IntuneAuthManager$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    IntuneAuthManager.updateTokenIfNeeded$lambda$0(this.f$0, account, id);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateTokenIfNeeded$lambda$0(IntuneAuthManager intuneAuthManager, IAccount iAccount, String str) {
        String string = intuneAuthManager.getIntuneSharedPrefs().getString(SP_RESOURCE_ID, "");
        Intrinsics.checkNotNull(string);
        SharedPreferences.Editor editorEdit = intuneAuthManager.getIntuneSharedPrefs().edit();
        editorEdit.remove(SP_AAD_ID);
        editorEdit.remove(SP_RESOURCE_ID);
        editorEdit.apply();
        String username = iAccount.getUsername();
        Intrinsics.checkNotNullExpressionValue(username, "getUsername(...)");
        String strAcquireToken = intuneAuthManager.acquireToken(username, str, string);
        if (strAcquireToken != null) {
            MAMEnrollmentManager mAMEnrollmentManager = intuneAuthManager.mamEnrollmentManager;
            if (mAMEnrollmentManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mamEnrollmentManager");
                mAMEnrollmentManager = null;
            }
            mAMEnrollmentManager.updateToken(iAccount.getUsername(), str, string, strAcquireToken);
        }
    }

    public final void clearIntunePrefs() {
        SharedPreferences.Editor editorEdit = getIntuneSharedPrefs().edit();
        editorEdit.clear();
        editorEdit.apply();
        SharedPreferences encryptedIntuneSharedPrefs = getEncryptedIntuneSharedPrefs();
        if (encryptedIntuneSharedPrefs != null) {
            SharedPreferences.Editor editorEdit2 = encryptedIntuneSharedPrefs.edit();
            editorEdit2.clear();
            editorEdit2.apply();
        }
    }

    public final void signOutUser() {
        initMsal();
        IUserContextComponent userContextComponent = this.userContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.EXECUTOR_POOL);
        Intrinsics.checkNotNull(userContextComponent, "null cannot be cast to non-null type com.box.android.domain.identity.IExecutorPool");
        ((IExecutorPool) userContextComponent).getApiExecutor().execute(new Runnable() { // from class: com.box.android.coreservices.utilities.intune.IntuneAuthManager$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() throws MsalException, InterruptedException {
                IntuneAuthManager.signOutUser$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void signOutUser$lambda$0(IntuneAuthManager intuneAuthManager) throws MsalException, InterruptedException {
        ICurrentAccountResult currentAccount = intuneAuthManager.getSingleAccountApp().getCurrentAccount();
        MAMEnrollmentManager mAMEnrollmentManager = null;
        IAccount currentAccount2 = currentAccount != null ? currentAccount.getCurrentAccount() : null;
        intuneAuthManager.registerWipeDataListener();
        try {
            intuneAuthManager.getSingleAccountApp().signOut();
        } catch (Exception e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(intuneAuthManager), "Failed to sign out Intune User: " + e);
        }
        intuneAuthManager.clearIntunePrefs();
        if (currentAccount2 != null) {
            MAMEnrollmentManager mAMEnrollmentManager2 = intuneAuthManager.mamEnrollmentManager;
            if (mAMEnrollmentManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mamEnrollmentManager");
            } else {
                mAMEnrollmentManager = mAMEnrollmentManager2;
            }
            mAMEnrollmentManager.unregisterAccountForMAM(currentAccount2.getUsername(), currentAccount2.getId());
        }
    }

    public final boolean isValidUPN$coreservices_generalProdRelease(String upn, String userEmail) {
        Intrinsics.checkNotNullParameter(upn, "upn");
        return userEmail != null ? StringsKt.equals(userEmail, upn, true) : StringsKt.equals(upn, getEnforcedUPN$coreservices_generalProdRelease(), true);
    }

    public final EnrollmentMethod resolveEnrollmentMethod$coreservices_generalProdRelease() {
        if (this.featureFlips.getIntuneOidBasedEnrollment().getEnabled()) {
            return EnrollmentMethod.OID;
        }
        if (!Intrinsics.areEqual(IntuneKeysConfigUtils.getIntuneUPN(), "")) {
            return EnrollmentMethod.UPN_MDM;
        }
        return EnrollmentMethod.UPN_BOX_LOGIN;
    }

    public final boolean isLoginNeeded() {
        return getIntuneSharedPrefs().getBoolean(SP_LOG_IN_NEEDED, true);
    }

    public final boolean hasStoredAadId() {
        SharedPreferences encryptedIntuneSharedPrefs = getEncryptedIntuneSharedPrefs();
        return (encryptedIntuneSharedPrefs != null ? encryptedIntuneSharedPrefs.getString(SP_ENROLLED_AAD_ID, null) : null) != null;
    }

    public final boolean shouldBlockUser() {
        return BoxAccountManager.isIntuneMAMEnabled(this.userContextManager.getUserSharedPrefs()) && (this.userContextManager.getUserInfo() != null) && !isIdentityManaged();
    }

    public final boolean isIdentityManaged() {
        SharedPreferences encryptedIntuneSharedPrefs = getEncryptedIntuneSharedPrefs();
        String string = encryptedIntuneSharedPrefs != null ? encryptedIntuneSharedPrefs.getString(SP_ENROLLED_AAD_ID, null) : null;
        if (string != null) {
            return MAMPolicyManager.getIsIdentityOIDManaged(string);
        }
        String enforcedUPN$coreservices_generalProdRelease = getEnforcedUPN$coreservices_generalProdRelease();
        if (enforcedUPN$coreservices_generalProdRelease != null) {
            return MAMPolicyManager.getIsIdentityManaged(enforcedUPN$coreservices_generalProdRelease);
        }
        return false;
    }

    @Override // com.microsoft.intune.mam.policy.MAMServiceAuthenticationCallback
    public String acquireToken(String upn, String aadId, String resourceId) {
        Intrinsics.checkNotNullParameter(upn, "upn");
        Intrinsics.checkNotNullParameter(aadId, "aadId");
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        initMsal();
        try {
            IAccount account$coreservices_generalProdRelease = getAccount$coreservices_generalProdRelease(aadId);
            if (account$coreservices_generalProdRelease != null) {
                IAuthenticationResult iAuthenticationResultAcquireTokenSilent = getSingleAccountApp().acquireTokenSilent(new AcquireTokenSilentParameters.Builder().forAccount(account$coreservices_generalProdRelease).fromAuthority(account$coreservices_generalProdRelease.getAuthority()).withScopes(CollectionsKt.listOf(resourceId + "/.default")).build());
                String accessToken = iAuthenticationResultAcquireTokenSilent != null ? iAuthenticationResultAcquireTokenSilent.getAccessToken() : null;
                if (accessToken != null) {
                    return accessToken;
                }
            }
            throw new MsalUiRequiredException("no_account_found", "no account found for " + aadId);
        } catch (Exception e) {
            SharedPreferences.Editor editorEdit = getIntuneSharedPrefs().edit();
            editorEdit.putString(SP_AAD_ID, aadId);
            editorEdit.putString(SP_RESOURCE_ID, resourceId);
            editorEdit.apply();
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Failed to acquire token due to exception: " + e);
            this.notificationServices.displayToast("Failed to acquire token due to exception: " + e, this.context);
            return null;
        }
    }

    public final SharedPreferences getIntuneSharedPrefs() {
        SharedPreferences userSharedPrefs = this.userContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.INTUNE_AUTH);
        Intrinsics.checkNotNullExpressionValue(userSharedPrefs, "getUserSharedPrefs(...)");
        return userSharedPrefs;
    }

    public final SharedPreferences getEncryptedIntuneSharedPrefs() {
        return this.userContextManager.getEncryptedSharedPrefs(ILocalSharedPreferences.PreferenceName.INTUNE_AUTH_ENCRYPTED);
    }

    public final IAccount getAccount$coreservices_generalProdRelease(String aadId) throws MsalException, InterruptedException {
        IAccount currentAccount;
        Intrinsics.checkNotNullParameter(aadId, "aadId");
        ICurrentAccountResult currentAccount2 = getSingleAccountApp().getCurrentAccount();
        if (currentAccount2 == null || (currentAccount = currentAccount2.getCurrentAccount()) == null) {
            return null;
        }
        if (Intrinsics.areEqual(currentAccount.getId(), aadId)) {
            return currentAccount;
        }
        BoxLogUtils.w(ExtensionsKt.getTAG(this), "Signed in account does not match requested account");
        return null;
    }
}
