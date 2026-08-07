package com.box.android.activities.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;
import com.box.android.R;
import com.box.android.activities.InfoDialogActivity;
import com.box.android.application.BoxBaseApplication;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.base.presentation.activities.BoxIntuneMAMAuthActivity;
import com.box.android.base.presentation.activities.BoxIntuneMAMAuthActivityKt;
import com.box.android.base.presentation.utilities.EdgeToEdgeUtils;
import com.box.android.clientadmin.integrity.DeviceIntegrityVerifier;
import com.box.android.common.utilities.BuildConfigProvider;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.modelcontroller.IMoCoAdminSettings;
import com.box.android.coreservices.models.CustomBoxSession;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.coreservices.utilities.CoreServiceUtils;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.configuration.BoxConfigConstants;
import com.box.android.domain.configuration.ConfigManager;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.DeviceId;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.observability.AuthEvent;
import com.box.android.domain.models.observability.Gen204ActionCompletionStatus;
import com.box.android.domain.services.IAppRestrictionsManager;
import com.box.android.domain.services.IAuthenticationService;
import com.box.android.domain.services.IBVEManager;
import com.box.android.domain.services.IForceUpdateCoordinator;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import com.box.android.observability.ObservabilitySettingsManager;
import com.box.android.utilities.AuthLoggerUtil;
import com.box.android.utilities.notificationmanager.BoxNotificationHelper;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.auth.BoxAuthentication;
import com.box.androidsdk.content.auth.ChooseAuthenticationFragment;
import com.box.androidsdk.content.auth.OAuthWebView;
import com.box.androidsdk.content.models.BoxError;
import com.box.androidsdk.content.models.BoxMDMData;
import com.box.androidsdk.content.models.BoxPKCE;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.OAuthUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.google.android.material.snackbar.Snackbar;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes9.dex */
public class CustomOAuthActivity extends Hilt_CustomOAuthActivity implements ChooseAuthenticationFragment.OnAuthenticationChosen, OAuthWebView.OAuthWebViewClient.WebEventListener, OAuthWebView.OnPageFinishedListener, DeviceTrustJavascriptBridge.NativeBrowserHandler {
    public static final String AUTH_INFO = "authinfo";
    private static final String CHOOSE_AUTH_TAG = "choose_auth";
    private static final String EXTRA_ANALYTICS_FLOW = "analyticsFlow";
    private static final String EXTRA_ANALYTICS_PAGE = "analyticsPage";
    public static final String EXTRA_EMM_PACKAGE = "emmPackageName";
    public static final String EXTRA_SESSION = "session";
    public static final String EXTRA_USER_ID_RESTRICTION = "restrictToUserId";
    private static final String FIELD_CODE = "code";
    private static final String FIELD_STATE = "state";

    @Inject
    protected IntentServices appIntentService;

    @Inject
    protected IAuthenticationService authRequestService;

    @Inject
    protected IBVEManager bveManager;

    @Inject
    protected DeviceIntegrityVerifier deviceIntegrityVerifier;

    @Inject
    protected FeatureFlips featureFlips;

    @Inject
    protected IForceUpdateCoordinator forceUpdateCoordinator;

    @Inject
    protected IMoCoAdminSettings mAdminSettings;

    @Inject
    protected BoxApiPrivate mApiPrivate;
    private AuthEvent.EventType mAuthEventType;
    private BoxPKCE mBoxPkce;

    @Inject
    protected ConfigManager mConfigManager;

    @Inject
    protected DeviceId mDeviceId;
    private String mEmmPackageName;
    private Bundle mLatestAfWRestrictions;

    @Inject
    protected MetricsUseCase mMetricsUseCase;

    @Inject
    protected ObservabilitySettingsManager mObservabilityManager;

    @Inject
    protected IAppRestrictionsManager mRestrictionsManager;
    private BoxSession mSession;
    private Snackbar mSnackBar;

    @Inject
    protected IUserContextManager mUserContextManager;
    protected OAuthWebView.OAuthWebViewClient oauthClient;
    protected OAuthWebView oauthView;

    @Inject
    protected IUserContextManager userContextManager;
    private boolean mAuthWasSuccessful = false;
    protected AtomicBoolean apiCallStarted = new AtomicBoolean(false);
    IntentFilter restrictionsFilter = new IntentFilter("android.intent.action.APPLICATION_RESTRICTIONS_CHANGED");
    BroadcastReceiver restrictionsReceiver = new MAMBroadcastReceiver() { // from class: com.box.android.activities.login.CustomOAuthActivity.1
        @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
        public void onMAMReceive(Context context, Intent intent) {
            BoxLogUtils.d("AndroidForWork", "App restrictions changed broadcast received. Validating restrictions");
            CustomOAuthActivity.this.startOAuth();
        }
    };
    private BroadcastReceiver mConnectedReceiver = new MAMBroadcastReceiver() { // from class: com.box.android.activities.login.CustomOAuthActivity.2
        @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
        public void onMAMReceive(Context context, Intent intent) {
            if (!intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") || !SdkUtils.isInternetAvailable(context) || CustomOAuthActivity.this.oauthView == null || CustomOAuthActivity.this.oauthView.getUrl() == null || CustomOAuthActivity.this.oauthView.getUrl().startsWith("http")) {
                return;
            }
            CustomOAuthActivity.this.startOAuth();
        }
    };

    protected int getContentView() {
        return R.layout.boxsdk_activity_oauth;
    }

    protected int getOAuthWebViewRId() {
        return R.id.oauthview;
    }

    @Override // com.box.android.activities.login.Hilt_CustomOAuthActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        registerReceiver(this.mConnectedReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        registerReceiver(this.restrictionsReceiver, this.restrictionsFilter);
        IForceUpdateCoordinator iForceUpdateCoordinator = this.forceUpdateCoordinator;
        if (iForceUpdateCoordinator != null) {
            iForceUpdateCoordinator.enforceIfNeeded();
        }
        setContentView(getContentView());
        if (bundle != null) {
            this.mEmmPackageName = bundle.getString(EXTRA_EMM_PACKAGE);
        }
        Intent intent = getIntent();
        this.apiCallStarted.set(false);
        BoxSession boxSession = (BoxSession) intent.getSerializableExtra("session");
        this.mSession = boxSession;
        if (boxSession != null) {
            boxSession.setApplicationContext(getApplicationContext());
        } else {
            this.mSession = new BoxSession(this, null, this.mRestrictionsManager.isAppFedrampHighCompliant());
        }
        try {
            this.mSession.setDeviceId(this.mDeviceId.getDeviceId());
        } catch (Exception e) {
            BoxLogUtils.e("setDeviceId ", e);
        }
        this.mSession.setDeviceName(CommonBoxUtil.getDeviceName());
        setupEdgeToEdge();
    }

    @Override // com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity
    public boolean amplitudeSetCurrentPage() {
        BoxAmplitudeAnalytics.EventPropertyBuilder eventPropertyBuilderCreateEventBuilder = BoxAmplitudeAnalytics.createEventBuilder();
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(EXTRA_ANALYTICS_FLOW)) {
            eventPropertyBuilderCreateEventBuilder.setFlow(intent.getStringExtra(EXTRA_ANALYTICS_FLOW));
        }
        amplitudeSetCurrentPageAndLog(eventPropertyBuilderCreateEventBuilder, BoxAnalyticsParams.PAGE_NAME_OAUTH_SIGN_IN_PAGE);
        return true;
    }

    @Override // androidx.activity.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMNewIntent(Intent intent) {
        super.onMAMNewIntent(intent);
        if (intent != null) {
            CoreServiceUtils.logcatIntent(intent);
            handleAuthenticationIntent(intent);
        }
    }

    protected void handleAuthenticationIntent(Intent intent) {
        Uri data = intent.getData();
        if (data != null) {
            String queryParameter = data.getQueryParameter("code");
            String queryParameter2 = data.getQueryParameter("state");
            if (SdkUtils.isBlank(queryParameter)) {
                BoxPresentationUtils.displayToast(CommonBoxUtil.LS(R.string.error_login_title) + " No Code", this);
                return;
            }
            if (SdkUtils.isBlank(queryParameter2)) {
                BoxPresentationUtils.displayToast(CommonBoxUtil.LS(R.string.error_login_title) + " No State", this);
            } else if (!OAuthUtils.isValidStateString(queryParameter2)) {
                BoxPresentationUtils.displayToast(CommonBoxUtil.LS(R.string.error_login_title) + " State Mismatch", this);
            } else {
                onReceivedAuthCode(queryParameter);
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        bundle.putString(EXTRA_EMM_PACKAGE, this.mEmmPackageName);
        super.onSaveInstanceState(bundle, persistableBundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        super.onMAMActivityResult(i, i2, intent);
        if (i != 1000 || intent == null || (stringExtra = intent.getStringExtra(BoxIntuneMAMAuthActivityKt.MSAL_ACCESS_CODE_EXTRA)) == null) {
            return;
        }
        onReceivedAuthCode(stringExtra);
    }

    @Override // androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMResume() {
        OAuthWebView oAuthWebView;
        super.onMAMResume();
        if (!isFinishing() && ((oAuthWebView = this.oauthView) == null || oAuthWebView.getUrl() == null || !this.oauthView.getUrl().startsWith("http"))) {
            startOAuth();
        }
        amplitudeSetCurrentPage();
        if (ObservabilitySettingsManager.INSTANCE.isDiagnosisModeEnabled()) {
            this.mObservabilityManager.showNotification();
        }
    }

    @Override // com.box.androidsdk.content.auth.OAuthWebView.OAuthWebViewClient.WebEventListener
    public void onReceivedAuthCode(String str) {
        onReceivedAuthCode(str, null);
    }

    @Override // com.box.androidsdk.content.auth.OAuthWebView.OAuthWebViewClient.WebEventListener
    public void interceptCodeReceived(String str) {
        BoxIntuneMAMAuthActivity.startActivity(this, str, true, this.mBoxPkce.getCodeChallenge(), false);
    }

    @Override // com.box.androidsdk.content.auth.OAuthWebView.OAuthWebViewClient.WebEventListener
    public void onVerifiedEnterprise(String str) {
        this.bveManager.setVerifiedEnterprise(true);
        this.bveManager.setVerifiedEnterpriseDomain(str);
    }

    @Override // com.box.androidsdk.content.auth.OAuthWebView.OAuthWebViewClient.WebEventListener
    public void onReceivedAuthCode(String str, String str2) {
        OAuthWebView oAuthWebView = this.oauthView;
        if (oAuthWebView != null) {
            oAuthWebView.setVisibility(4);
        }
        startMakingOAuthAPICall(str, str2);
    }

    @Override // android.app.Activity
    public void finish() {
        clearCachedAuthenticationData();
        if (!this.mAuthWasSuccessful) {
            BoxAuthentication.getInstance().onAuthenticationFailure(null, null);
        }
        super.finish();
    }

    @Override // com.box.androidsdk.content.auth.OAuthWebView.OAuthWebViewClient.WebEventListener
    public boolean onAuthFailure(OAuthWebView.AuthFailure authFailure) {
        String str;
        if (authFailure.mWebException != null) {
            if (authFailure.mWebException.getFailingUrl() == null) {
                str = "";
            } else {
                try {
                    URI uriCreate = URI.create(authFailure.mWebException.getFailingUrl());
                    str = uriCreate.getScheme() + "://" + uriCreate.getHost() + uriCreate.getPath();
                } catch (Exception unused) {
                    str = "[malformed URL]";
                }
            }
            BoxLogUtils.v("AndroidForWork", "AuthFailure: errorCode=" + authFailure.mWebException.getErrorCode() + ", description=" + authFailure.mWebException.getDescription() + ", failingUrl=" + str);
        }
        if (authFailure.mWebException != null && authFailure.mWebException.getErrorCode() == -10) {
            Uri uri = Uri.parse(authFailure.mWebException.getFailingUrl());
            if (uri.toString().contains(this.mSession.getRedirectUrl())) {
                String queryParameter = uri.getQueryParameter("code");
                if (OAuthUtils.isValidStateString(uri.getQueryParameter("state"))) {
                    onReceivedAuthCode(queryParameter);
                    return true;
                }
            }
        }
        reportAuthError(authFailure);
        broadcastDismissSpinner();
        if (authFailure.type == 2) {
            if (authFailure.mWebException.getErrorCode() == -6 || authFailure.mWebException.getErrorCode() == -2 || authFailure.mWebException.getErrorCode() == -8) {
                return false;
            }
            Resources resources = getResources();
            BoxNotificationHelper.displayDialog(String.format("%s\n%s: %s", resources.getString(R.string.boxsdk_Authentication_fail), resources.getString(R.string.boxsdk_details), authFailure.mWebException.getErrorCode() + " " + authFailure.mWebException.getDescription()));
        } else if (SdkUtils.isEmptyString(authFailure.message)) {
            Toast.makeText(this, R.string.boxsdk_Authentication_fail, 1).show();
        } else {
            Resources resources2 = getResources();
            int i = authFailure.type;
            if (i == 1) {
                Toast.makeText(this, String.format("%s\n%s: %s", resources2.getString(R.string.boxsdk_Authentication_fail), resources2.getString(R.string.boxsdk_details), resources2.getString(R.string.boxsdk_Authentication_fail_url_mismatch)), 1).show();
            } else if (i == 3) {
                startActivity(InfoDialogActivity.newInfoDialog(this, resources2.getString(R.string.error_login_title), resources2.getString(R.string.err_login_too_many_apps), resources2.getString(R.string.boxsdk_button_ok)));
            } else {
                Toast.makeText(this, R.string.boxsdk_Authentication_fail, 1).show();
            }
        }
        startOAuth();
        return true;
    }

    @Override // com.box.androidsdk.content.auth.OAuthWebView.OnPageFinishedListener
    public void onPageFinished(WebView webView, String str) {
        if (str != null && str.contains("code") && str.contains("state") && str.startsWith(this.mSession.getRedirectUrl())) {
            return;
        }
        if (this.apiCallStarted.get()) {
            showSpinner();
            this.oauthView.setVisibility(4);
        } else {
            broadcastDismissSpinner();
        }
    }

    @Override // com.box.android.activities.login.DeviceTrustJavascriptBridge.NativeBrowserHandler
    public boolean onNativeBrowserRequired(WebView webView, String str) {
        String packageNameToUse = CustomTabsHelper.getPackageNameToUse(this);
        if (!CustomTabsHelper.isAcceptedBrowser(packageNameToUse)) {
            if (packageNameToUse != null) {
                BoxLogUtils.v(packageNameToUse + " was found but not accepted");
            }
            this.mSnackBar = BoxPresentationUtils.displaySnackBar(this, webView, R.string.no_supported_browser_warning, R.string.button_ok, new View.OnClickListener() { // from class: com.box.android.activities.login.CustomOAuthActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CustomOAuthActivity.this.mSnackBar.dismiss();
                }
            });
            return false;
        }
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(CommonBoxUtil.getColorFromAttribute(this, R.attr.topBarBackground));
        builder.setShowTitle(false);
        CustomTabsIntent customTabsIntentBuild = builder.build();
        customTabsIntentBuild.intent.setPackage(packageNameToUse);
        customTabsIntentBuild.launchUrl(this, Uri.parse(str));
        return true;
    }

    protected void startOAuth() {
        showSpinner();
        this.oauthView = createOAuthView();
        clearCachedAuthenticationData();
        OAuthWebView.OAuthWebViewClient oAuthWebViewClientCreateOAuthWebViewClient = createOAuthWebViewClient();
        this.oauthClient = oAuthWebViewClientCreateOAuthWebViewClient;
        oAuthWebViewClientCreateOAuthWebViewClient.setOnPageFinishedListener(this);
        this.oauthView.setWebViewClient(this.oauthClient);
        if (this.mSession.getBoxAccountEmail() != null) {
            this.oauthView.setBoxAccountEmail(this.mSession.getBoxAccountEmail());
        }
        this.mUserContextManager.softSwitch(null);
        this.mBoxPkce = BoxPKCE.generate();
        this.mRestrictionsManager.getLatestAppRestrictions();
        if (!this.mRestrictionsManager.getLatestAppRestrictions().isEmpty()) {
            initConfigBasedOnAppRestrictions();
            try {
                ArrayList<String> mandatoryFieldsNotSet = this.mRestrictionsManager.getMandatoryFieldsNotSet(this.mLatestAfWRestrictions);
                if (!mandatoryFieldsNotSet.isEmpty()) {
                    notifyInvalidRestrictions(mandatoryFieldsNotSet);
                    return;
                }
            } catch (RuntimeException e) {
                BoxLogUtils.e("mandatory fields not set ", e);
                runOnUiThread(new Runnable() { // from class: com.box.android.activities.login.CustomOAuthActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.getLocalizedMessage() != null) {
                            BoxNotificationHelper.displayDialog(CommonBoxUtil.LS(R.string.error_login_title), e.getLocalizedMessage());
                        } else {
                            BoxNotificationHelper.displayDialog(CommonBoxUtil.LS(R.string.error_login_title), CommonBoxUtil.LS(R.string.login_error_try_again));
                        }
                        CustomOAuthActivity.this.finish();
                    }
                });
                return;
            }
        }
        loadAuthUrl();
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0080 A[PHI: r5
      0x0080: PHI (r5v8 java.lang.String) = (r5v1 java.lang.String), (r5v3 java.lang.String), (r5v5 java.lang.String), (r5v9 java.lang.String) binds: [B:27:0x00ae, B:22:0x00a7, B:15:0x0093, B:7:0x007d] A[DONT_GENERATE, DONT_INLINE]] */
    private void initConfigBasedOnAppRestrictions() {
        String str;
        Bundle latestAppRestrictions = this.mRestrictionsManager.getLatestAppRestrictions();
        this.mLatestAfWRestrictions = latestAppRestrictions;
        String string = latestAppRestrictions.getString(getString(R.string.restriction_key_PublicId));
        String string2 = this.mLatestAfWRestrictions.getString(getString(R.string.restriction_key_ManagementId));
        String string3 = this.mLatestAfWRestrictions.getString(getString(R.string.restriction_key_UserEmail));
        this.mSession.setManagementData(BoxMDMData.createMdmData(this, string, string2, string3, this.mLatestAfWRestrictions.getString(getString(R.string.restriction_key_BillingId))));
        this.mSession.setBoxAccountEmail(string3);
        String string4 = this.mLatestAfWRestrictions.getString(getString(R.string.restriction_key_EmmName), "");
        boolean zIsDeviceTypeTablet = BoxBaseApplication.getInstance().getConfigManager().isDeviceTypeTablet();
        String str2 = "AubFhmTFn2azpHcsMThzlU9MbtogyRr0";
        if (string4.equals(getString(R.string.emm_provider_airwatch))) {
            str = zIsDeviceTypeTablet ? "a3q8sad7xelv4b4hpvmeqj1ufmm1qzzm" : "w2ndash5bh5zgeq3unw0km4bwakdmx8f";
            if (!zIsDeviceTypeTablet) {
                str2 = "0SjDcsqugEjE3LZbQpnbxw2tBYeQG7s0";
            }
        } else if (string4.equals(getString(R.string.emm_provider_maas360))) {
            str = zIsDeviceTypeTablet ? "a3q8sad7xelv4b4hpvmeqj1ufmm1qzzm" : "w2ndash5bh5zgeq3unw0km4bwakdmx8f";
            if (!zIsDeviceTypeTablet) {
                str2 = "0SjDcsqugEjE3LZbQpnbxw2tBYeQG7s0";
            }
        } else if (string4.equals(getString(R.string.emm_provider_mobileiron))) {
            str = zIsDeviceTypeTablet ? "a3q8sad7xelv4b4hpvmeqj1ufmm1qzzm" : "w2ndash5bh5zgeq3unw0km4bwakdmx8f";
            if (!zIsDeviceTypeTablet) {
                str2 = "0SjDcsqugEjE3LZbQpnbxw2tBYeQG7s0";
            }
        } else {
            str = zIsDeviceTypeTablet ? "a3q8sad7xelv4b4hpvmeqj1ufmm1qzzm" : "w2ndash5bh5zgeq3unw0km4bwakdmx8f";
            if (!zIsDeviceTypeTablet) {
                str2 = "0SjDcsqugEjE3LZbQpnbxw2tBYeQG7s0";
            }
        }
        ((CustomBoxSession) this.mSession).setClientId(str);
        ((CustomBoxSession) this.mSession).setClientSecret(str2);
    }

    public void loadAuthUrl() {
        this.oauthView.authenticate(createAuthBuilder(this.mSession), this.mBoxPkce.getCodeChallenge());
    }

    Uri.Builder createAuthBuilder(BoxSession boxSession) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https");
        builder.authority(BoxBaseApplication.getInstance().getConfigManager().getString(BoxConfigConstants.CONFIG_KEY_OAUTH_URL_AUTHORITY));
        for (String str : BoxBaseApplication.getInstance().getConfigManager().getArray(BoxConfigConstants.CONFIG_KEY_FALLBACK_PATHS_ARRAY)[0].split("/")) {
            builder.appendPath(str);
        }
        builder.appendQueryParameter("response_type", "code");
        builder.appendQueryParameter("client_id", boxSession.getClientId());
        builder.appendQueryParameter("redirect_uri", boxSession.getRedirectUrl());
        if (boxSession.getBoxAccountEmail() != null) {
            builder.appendQueryParameter("box_login", boxSession.getBoxAccountEmail());
        }
        if ((boxSession instanceof CustomBoxSession) && ((CustomBoxSession) boxSession).getUseRegisterWebview()) {
            builder.appendQueryParameter("box_show_signup", TelemetryEventStrings.Value.TRUE);
        }
        return builder;
    }

    protected void goToHomeScreen() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(268435456);
        startActivity(intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        goToHomeScreen();
        finish();
    }

    @Override // com.box.androidsdk.content.auth.ChooseAuthenticationFragment.OnAuthenticationChosen
    public void onAuthenticationChosen(BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo) {
        if (boxAuthenticationInfo != null) {
            BoxAuthentication.getInstance().onAuthenticated(boxAuthenticationInfo, this, this.mRestrictionsManager.isAppFedrampHighCompliant());
            dismissSpinnerAndFinishAuthenticate(boxAuthenticationInfo);
        }
    }

    @Override // com.box.androidsdk.content.auth.ChooseAuthenticationFragment.OnAuthenticationChosen
    public void onDifferentAuthenticationChosen() {
        if (getFragmentManager().findFragmentByTag(CHOOSE_AUTH_TAG) != null) {
            getFragmentManager().popBackStack();
        }
    }

    protected void startMakingOAuthAPICall(final String str, String str2) {
        if (this.apiCallStarted.getAndSet(true)) {
            return;
        }
        showSpinner();
        if (BuildConfigProvider.INSTANCE.isDebugBuild()) {
            String string = BoxBaseApplication.getInstance().getConfigManager().getString(BoxConfigConstants.CONFIG_KEY_OAUTH_URL_AUTHORITY);
            if (string.contains(BoxConfigConstants.DEVPOD_HOST_NAME_SUBSTRING)) {
                this.mSession.getAuthInfo().setBaseDomain(string);
            } else {
                this.mSession.getAuthInfo().setBaseDomain(str2);
            }
        } else {
            this.mSession.getAuthInfo().setBaseDomain(str2);
        }
        new Thread(new Runnable() { // from class: com.box.android.activities.login.CustomOAuthActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startMakingOAuthAPICall$0(str);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startMakingOAuthAPICall$0(String str) {
        try {
            try {
                BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo = BoxAuthentication.getInstance().create(this.mSession, str, this.mBoxPkce.getCodeVerifier()).get();
                String stringExtra = getIntent().getStringExtra("restrictToUserId");
                if (!SdkUtils.isEmptyString(stringExtra) && !boxAuthenticationInfo.getUser().getUserId().equals(stringExtra)) {
                    throw new RuntimeException("Unexpected user logged in. Expected " + stringExtra + " received " + boxAuthenticationInfo.getUser().getUserId());
                }
                Bundle bundle = this.mLatestAfWRestrictions;
                if (bundle != null && !bundle.isEmpty()) {
                    this.mRestrictionsManager.commitAppRestrictions(this.mLatestAfWRestrictions);
                    this.mRestrictionsManager.setAppRestrictions();
                }
                dismissSpinnerAndFinishAuthenticate(boxAuthenticationInfo);
            } catch (Exception e) {
                if (e instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                dismissSpinnerAndFailAuthenticate(e);
            }
            this.apiCallStarted.set(false);
        } catch (Throwable th) {
            this.apiCallStarted.set(false);
            throw th;
        }
    }

    protected void dismissSpinnerAndFinishAuthenticate(final BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo) {
        if (boxAuthenticationInfo != null) {
            try {
                if (!SdkUtils.isBlank(boxAuthenticationInfo.accessToken())) {
                    this.mUserContextManager.createUser(boxAuthenticationInfo.getUser().getUserId(), this.mApiPrivate);
                }
            } catch (IUserContextComponent.UserContextComponentCreationException e) {
                BoxLogUtils.e("failure creating user", e);
            }
        }
        runOnUiThread(new Runnable() { // from class: com.box.android.activities.login.CustomOAuthActivity.5
            @Override // java.lang.Runnable
            public void run() {
                Intent intent = new Intent();
                intent.putExtra("authinfo", boxAuthenticationInfo);
                CustomOAuthActivity.this.setResult(-1, intent);
                CustomOAuthActivity.this.mAuthWasSuccessful = true;
                CustomOAuthActivity customOAuthActivity = CustomOAuthActivity.this;
                customOAuthActivity.mAuthEventType = ((CustomBoxSession) customOAuthActivity.mSession).getUseRegisterWebview() ? AuthEvent.EventType.Register : AuthEvent.EventType.Login;
                AuthLoggerUtil.logAuthEvent(CustomOAuthActivity.this.mMetricsUseCase, CustomOAuthActivity.this.mAuthEventType, Gen204ActionCompletionStatus.SUCCEEDED, null, null);
                Intent intent2 = CustomOAuthActivity.this.getIntent();
                if (intent2 != null && intent2.hasExtra(CustomOAuthActivity.EXTRA_ANALYTICS_FLOW)) {
                    BoxAmplitudeAnalytics.createEventBuilder().setFlow(intent2.getStringExtra(CustomOAuthActivity.EXTRA_ANALYTICS_FLOW)).logEvent(BoxAnalyticsParams.EVENT_LOG_IN_SUCCESS);
                }
                CustomOAuthActivity.this.finish();
            }
        });
    }

    protected void dismissSpinnerAndFailAuthenticate(Exception exc) {
        final OAuthWebView.AuthFailure authFailure = getAuthFailure(exc);
        runOnUiThread(new Runnable() { // from class: com.box.android.activities.login.CustomOAuthActivity.6
            @Override // java.lang.Runnable
            public void run() {
                CustomOAuthActivity.this.broadcastDismissSpinner();
                CustomOAuthActivity.this.onAuthFailure(authFailure);
                CustomOAuthActivity.this.setResult(0);
            }
        });
    }

    private void reportAuthError(OAuthWebView.AuthFailure authFailure) {
        reportAuthError(authFailure.type, authFailure.message, authFailure.mWebException == null ? -1 : authFailure.mWebException.getErrorCode());
    }

    private void reportAuthError(int i, String str, int i2) {
        AuthEvent.EventType eventType = ((CustomBoxSession) this.mSession).getUseRegisterWebview() ? AuthEvent.EventType.Register : AuthEvent.EventType.Login;
        this.mAuthEventType = eventType;
        AuthLoggerUtil.logAuthEvent(this.mMetricsUseCase, eventType, Gen204ActionCompletionStatus.FAILED, str, Integer.valueOf(i2));
        Intent intent = getIntent();
        if (intent == null || !intent.hasExtra(EXTRA_ANALYTICS_FLOW)) {
            return;
        }
        BoxAmplitudeAnalytics.createEventBuilder().setFlow(intent.getStringExtra(EXTRA_ANALYTICS_FLOW)).setError(i, str, i2).logEvent(BoxAnalyticsParams.EVENT_LOG_IN_ERROR);
    }

    protected OAuthWebView createOAuthView() {
        String str;
        OAuthWebView oAuthWebView = (OAuthWebView) findViewById(getOAuthWebViewRId());
        oAuthWebView.setVisibility(0);
        oAuthWebView.getSettings().setJavaScriptEnabled(true);
        oAuthWebView.getSettings().setSaveFormData(false);
        oAuthWebView.getSettings().setDomStorageEnabled(true);
        oAuthWebView.getSettings().setSavePassword(false);
        String userAgentString = oAuthWebView.getSettings().getUserAgentString();
        String userAgent = this.mSession.getUserAgent();
        if (userAgentString == null || userAgentString.contains(userAgent)) {
            str = "";
        } else {
            str = AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER + userAgentString;
        }
        oAuthWebView.getSettings().setUserAgentString(userAgent + str);
        if (WebViewFeature.isFeatureSupported("WEB_AUTHENTICATION") && this.featureFlips.getWebAuthnInLoginWebView().getEnabled()) {
            WebSettingsCompat.setWebAuthenticationSupport(oAuthWebView.getSettings(), 1);
        }
        oAuthWebView.setIsAppFedrampCompliant(this.mRestrictionsManager.isAppFedrampHighCompliant());
        return oAuthWebView;
    }

    protected OAuthWebView.OAuthWebViewClient createOAuthWebViewClient() {
        return new DeviceTrustJavascriptBridge.DeviceTrustClient(this, this.oauthView, this.mSession.getRedirectUrl(), this.deviceIntegrityVerifier);
    }

    @Override // com.box.android.activities.login.Hilt_CustomOAuthActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMDestroy() {
        this.apiCallStarted.set(false);
        broadcastDismissSpinner();
        unregisterReceiver(this.mConnectedReceiver);
        unregisterReceiver(this.restrictionsReceiver);
        super.onMAMDestroy();
    }

    public static Intent createOAuthActivityIntent(Context context, BoxSession boxSession, String str, String str2, String str3) {
        Intent intent = new Intent(context, (Class<?>) CustomOAuthActivity.class);
        intent.putExtra("session", boxSession);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("restrictToUserId", boxSession.getUserId());
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra(EXTRA_ANALYTICS_FLOW, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            intent.putExtra(EXTRA_ANALYTICS_PAGE, str3);
        }
        return intent;
    }

    private OAuthWebView.AuthFailure getAuthFailure(Exception exc) {
        Exception cause;
        BoxException boxException;
        BoxError asBoxError;
        String str;
        String string = getString(R.string.boxsdk_Authentication_fail);
        if (exc != null) {
            if (exc instanceof ExecutionException) {
                cause = exc;
                cause = exc.getCause();
            }
            cause = exc;
            if ((cause instanceof BoxException) && (asBoxError = (boxException = (BoxException) cause).getAsBoxError()) != null) {
                if (boxException.getResponseCode() == 403 || boxException.getResponseCode() == 401 || asBoxError.getError().equals("unauthorized_device")) {
                    str = string + ":" + ((Object) getResources().getText(R.string.boxsdk_Authentication_fail_forbidden)) + "\n";
                } else {
                    str = string + ":";
                }
                return new OAuthWebView.AuthFailure(3, str + asBoxError.getErrorDescription());
            }
            string = string + ":" + cause;
        }
        return new OAuthWebView.AuthFailure(-1, string);
    }

    private void clearCachedAuthenticationData() {
        OAuthWebView oAuthWebView = this.oauthView;
        if (oAuthWebView != null) {
            oAuthWebView.clearCache(true);
            this.oauthView.clearFormData();
            this.oauthView.clearHistory();
        }
        CookieSyncManager.createInstance(this);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookies(null);
        cookieManager.flush();
        deleteDatabase("webview.db");
        deleteDatabase("webviewCache.db");
        File cacheDir = getCacheDir();
        SdkUtils.deleteFolderRecursive(cacheDir);
        cacheDir.mkdir();
    }

    private void notifyInvalidRestrictions(ArrayList<String> arrayList) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(arrayList.get(i));
        }
        runOnUiThread(new Runnable() { // from class: com.box.android.activities.login.CustomOAuthActivity.7
            @Override // java.lang.Runnable
            public void run() {
                BoxLogUtils.e("notifying invalid restrictions", "missing required application restrictions " + sb.toString());
                BoxNotificationHelper.displayDialog(CommonBoxUtil.LS(R.string.error_login_title), String.format(CommonBoxUtil.LS(R.string.restriction_app_restrictions_require_restrictions_not_set), sb.toString()));
                CustomOAuthActivity.this.finish();
            }
        });
    }

    private void setupEdgeToEdge() {
        EdgeToEdgeUtils.INSTANCE.enableDarkEdgeToEdge(this);
        EdgeToEdgeUtils.INSTANCE.setInsets(findViewById(R.id.oauth_container), null);
    }
}
