package com.box.androidsdk.content.auth;

import android.app.Dialog;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.widget.Toast;
import com.box.android.dataaccess.content.R;
import com.box.androidsdk.content.BoxConfig;
import com.box.androidsdk.content.BoxConstants;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxError;
import com.box.androidsdk.content.models.BoxPKCE;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.microsoft.intune.mam.client.app.MAMActivity;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes13.dex */
public class OAuthActivity extends MAMActivity implements ChooseAuthenticationFragment.OnAuthenticationChosen, OAuthWebView.OAuthWebViewClient.WebEventListener, OAuthWebView.OnPageFinishedListener {
    public static final String AUTH_CODE = "authcode";
    public static final String AUTH_INFO = "authinfo";
    public static final int AUTH_TYPE_APP = 1;
    public static final int AUTH_TYPE_WEBVIEW = 0;
    private static final String CHOOSE_AUTH_TAG = "choose_auth";
    public static final String EXTRA_DISABLE_ACCOUNT_CHOOSING = "disableAccountChoosing";
    public static final String EXTRA_SESSION = "session";
    public static final String EXTRA_USER_ID_RESTRICTION = "restrictToUserId";
    protected static final String IS_APP_FEDRAMP_HIGH_COMPLIANT = "isAppFedrampHighCompliant";
    protected static final String IS_LOGGING_IN_VIA_BOX_APP = "loggingInViaBoxApp";
    protected static final String LOGIN_VIA_BOX_APP = "loginviaboxapp";
    public static final int REQUEST_BOX_APP_FOR_AUTH_CODE = 1;
    public static final String USER_ID = "userId";
    private static Dialog dialog;
    private BoxPKCE mBoxPkce;
    private String mClientId;
    private String mClientSecret;
    private String mDeviceId;
    private String mDeviceName;
    private boolean mIsAppFedrampHighCompliant;
    private boolean mIsLoggingInViaBoxApp;
    private String mRedirectUrl;
    private BoxSession mSession;
    protected OAuthWebView.OAuthWebViewClient oauthClient;
    protected OAuthWebView oauthView;
    private boolean mAuthWasSuccessful = false;
    private int authType = 0;
    private AtomicBoolean apiCallStarted = new AtomicBoolean(false);
    private BroadcastReceiver mConnectedReceiver = new MAMBroadcastReceiver() { // from class: com.box.androidsdk.content.auth.OAuthActivity.1
        @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
        public void onMAMReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") && SdkUtils.isInternetAvailable(context) && OAuthActivity.this.isAuthErrored()) {
                OAuthActivity.this.startOAuth();
            }
        }
    };

    @Override // com.box.androidsdk.content.auth.OAuthWebView.OAuthWebViewClient.WebEventListener
    public void onVerifiedEnterprise(String str) {
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        Intent intent = getIntent();
        if (BoxConfig.IS_FLAG_SECURE) {
            getWindow().addFlags(8192);
        }
        setContentView(getContentView());
        this.mIsAppFedrampHighCompliant = intent.getBooleanExtra(IS_APP_FEDRAMP_HIGH_COMPLIANT, false);
        registerReceiver(this.mConnectedReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.mClientId = intent.getStringExtra("client_id");
        this.mClientSecret = intent.getStringExtra("client_secret");
        this.mDeviceId = intent.getStringExtra(BoxConstants.KEY_BOX_DEVICE_ID);
        this.mDeviceName = intent.getStringExtra(BoxConstants.KEY_BOX_DEVICE_NAME);
        this.mRedirectUrl = intent.getStringExtra("redirect_uri");
        this.authType = intent.getBooleanExtra(LOGIN_VIA_BOX_APP, false) ? 1 : 0;
        this.apiCallStarted.getAndSet(false);
        this.mSession = (BoxSession) intent.getSerializableExtra("session");
        if (bundle != null) {
            this.mIsLoggingInViaBoxApp = bundle.getBoolean(IS_LOGGING_IN_VIA_BOX_APP);
        }
        BoxSession boxSession = this.mSession;
        if (boxSession != null) {
            boxSession.setApplicationContext(getApplicationContext());
            return;
        }
        BoxSession boxSession2 = new BoxSession(this, null, this.mClientId, this.mClientSecret, this.mRedirectUrl, this.mIsAppFedrampHighCompliant);
        this.mSession = boxSession2;
        boxSession2.setDeviceId(this.mDeviceId);
        this.mSession.setDeviceName(this.mDeviceName);
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMResume() {
        super.onMAMResume();
        if (isAuthErrored()) {
            startOAuth();
        }
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(IS_LOGGING_IN_VIA_BOX_APP, this.mIsLoggingInViaBoxApp);
        super.onMAMSaveInstanceState(bundle);
    }

    boolean isAuthErrored() {
        if (this.mIsLoggingInViaBoxApp) {
            return false;
        }
        OAuthWebView oAuthWebView = this.oauthView;
        return oAuthWebView == null || oAuthWebView.getUrl() == null || !this.oauthView.getUrl().startsWith("http");
    }

    @Override // com.box.androidsdk.content.auth.OAuthWebView.OAuthWebViewClient.WebEventListener
    public void onReceivedAuthCode(String str) {
        onReceivedAuthCode(str, null);
    }

    @Override // com.box.androidsdk.content.auth.OAuthWebView.OAuthWebViewClient.WebEventListener
    public void interceptCodeReceived(String str) {
        finish();
    }

    @Override // com.box.androidsdk.content.auth.OAuthWebView.OAuthWebViewClient.WebEventListener
    public void onReceivedAuthCode(String str, String str2) {
        if (this.authType == 0) {
            this.oauthView.setVisibility(4);
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

    @Override // com.box.androidsdk.content.auth.OAuthWebView.OnPageFinishedListener
    public void onPageFinished(WebView webView, String str) {
        dismissSpinner();
    }

    @Override // com.box.androidsdk.content.auth.OAuthWebView.OAuthWebViewClient.WebEventListener
    public boolean onAuthFailure(OAuthWebView.AuthFailure authFailure) {
        if (authFailure.type == 2) {
            if (authFailure.mWebException.getErrorCode() == -6 || authFailure.mWebException.getErrorCode() == -2 || authFailure.mWebException.getErrorCode() == -8) {
                return false;
            }
            Resources resources = getResources();
            Toast.makeText(this, String.format("%s\n%s: %s", resources.getString(R.string.boxsdk_Authentication_fail), resources.getString(R.string.boxsdk_details), authFailure.mWebException.getErrorCode() + " " + authFailure.mWebException.getDescription()), 1).show();
        } else if (SdkUtils.isEmptyString(authFailure.message)) {
            Toast.makeText(this, R.string.boxsdk_Authentication_fail, 1).show();
        } else {
            int i = authFailure.type;
            if (i == 1) {
                Resources resources2 = getResources();
                Toast.makeText(this, String.format("%s%n%s: %s", resources2.getString(R.string.boxsdk_Authentication_fail), resources2.getString(R.string.boxsdk_details), resources2.getString(R.string.boxsdk_Authentication_fail_url_mismatch)), 1).show();
            } else {
                if (i == 3) {
                    new MaterialAlertDialogBuilder(this).setTitle(R.string.boxsdk_Authentication_fail).setMessage(R.string.boxsdk_Authentication_fail_forbidden).setPositiveButton(R.string.boxsdk_button_ok, new DialogInterface.OnClickListener() { // from class: com.box.androidsdk.content.auth.OAuthActivity$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            this.f$0.lambda$onAuthFailure$0(dialogInterface, i2);
                        }
                    }).show();
                    return true;
                }
                Toast.makeText(this, R.string.boxsdk_Authentication_fail, 1).show();
            }
        }
        finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAuthFailure$0(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        finish();
    }

    protected int getContentView() {
        return R.layout.boxsdk_activity_oauth;
    }

    protected void startOAuth() {
        Intent boxAuthApp;
        if (this.authType != 1 && !getIntent().getBooleanExtra(EXTRA_DISABLE_ACCOUNT_CHOOSING, false) && getFragmentManager().findFragmentByTag(CHOOSE_AUTH_TAG) == null) {
            Map<String, BoxAuthentication.BoxAuthenticationInfo> storedAuthInfo = BoxAuthentication.getInstance().getStoredAuthInfo(this);
            if (SdkUtils.isEmptyString(getIntent().getStringExtra("restrictToUserId")) && storedAuthInfo != null && storedAuthInfo.size() > 0) {
                FragmentTransaction fragmentTransactionBeginTransaction = getFragmentManager().beginTransaction();
                fragmentTransactionBeginTransaction.replace(R.id.oauth_container, ChooseAuthenticationFragment.createAuthenticationActivity(this), CHOOSE_AUTH_TAG);
                fragmentTransactionBeginTransaction.addToBackStack(CHOOSE_AUTH_TAG);
                fragmentTransactionBeginTransaction.commit();
            }
        }
        int i = this.authType;
        if (i != 0) {
            if (i == 1 && (boxAuthApp = getBoxAuthApp()) != null) {
                boxAuthApp.putExtra("client_id", this.mClientId);
                boxAuthApp.putExtra("redirect_uri", this.mRedirectUrl);
                if (!SdkUtils.isEmptyString(getIntent().getStringExtra("restrictToUserId"))) {
                    boxAuthApp.putExtra("restrictToUserId", getIntent().getStringExtra("restrictToUserId"));
                }
                this.mIsLoggingInViaBoxApp = true;
                startActivityForResult(boxAuthApp, 1);
                return;
            }
            return;
        }
        showSpinner();
        this.oauthView = createOAuthView();
        OAuthWebView.OAuthWebViewClient oAuthWebViewClientCreateOAuthWebViewClient = createOAuthWebViewClient();
        this.oauthClient = oAuthWebViewClientCreateOAuthWebViewClient;
        oAuthWebViewClientCreateOAuthWebViewClient.setOnPageFinishedListener(this);
        this.oauthView.setWebViewClient(this.oauthClient);
        if (this.mSession.getBoxAccountEmail() != null) {
            this.oauthView.setBoxAccountEmail(this.mSession.getBoxAccountEmail());
        }
        BoxPKCE boxPKCEGenerate = BoxPKCE.generate();
        this.mBoxPkce = boxPKCEGenerate;
        this.oauthView.authenticate(this.mClientId, this.mRedirectUrl, boxPKCEGenerate.getCodeChallenge());
    }

    protected Intent getBoxAuthApp() {
        Intent intent = new Intent(BoxConstants.REQUEST_BOX_APP_FOR_AUTH_INTENT_ACTION);
        List<ResolveInfo> listQueryIntentActivities = MAMPackageManagement.queryIntentActivities(getPackageManager(), intent, 65600);
        if (listQueryIntentActivities != null && listQueryIntentActivities.size() >= 1) {
            String string = getResources().getString(R.string.boxsdk_box_app_signature);
            for (ResolveInfo resolveInfo : listQueryIntentActivities) {
                try {
                    if (string.equals(MAMPackageManagement.getPackageInfo(getPackageManager(), resolveInfo.activityInfo.packageName, 64).signatures[0].toCharsString())) {
                        intent.setPackage(resolveInfo.activityInfo.packageName);
                        Map<String, BoxAuthentication.BoxAuthenticationInfo> storedAuthInfo = BoxAuthentication.getInstance().getStoredAuthInfo(this);
                        if (storedAuthInfo != null && storedAuthInfo.size() > 0) {
                            ArrayList<String> arrayList = new ArrayList<>(storedAuthInfo.size());
                            for (Map.Entry<String, BoxAuthentication.BoxAuthenticationInfo> entry : storedAuthInfo.entrySet()) {
                                if (entry.getValue().getUser() != null) {
                                    arrayList.add(entry.getValue().getUser().toJson());
                                }
                            }
                            if (arrayList.size() > 0) {
                                intent.putStringArrayListExtra("boxusers", arrayList);
                            }
                        }
                        return intent;
                    }
                    continue;
                } catch (Exception unused) {
                }
            }
        }
        return null;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (getFragmentManager().findFragmentByTag(CHOOSE_AUTH_TAG) != null) {
            finish();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.box.androidsdk.content.auth.ChooseAuthenticationFragment.OnAuthenticationChosen
    public void onAuthenticationChosen(BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo) {
        if (boxAuthenticationInfo != null) {
            BoxAuthentication.getInstance().onAuthenticated(boxAuthenticationInfo, this, this.mIsAppFedrampHighCompliant);
            dismissSpinnerAndFinishAuthenticate(boxAuthenticationInfo);
        }
    }

    @Override // com.box.androidsdk.content.auth.ChooseAuthenticationFragment.OnAuthenticationChosen
    public void onDifferentAuthenticationChosen() {
        if (getFragmentManager().findFragmentByTag(CHOOSE_AUTH_TAG) != null) {
            getFragmentManager().popBackStack();
        }
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMActivityResult(int i, int i2, Intent intent) {
        if (-1 != i2 || 1 != i) {
            if (i2 == 0) {
                finish();
                return;
            }
            return;
        }
        String stringExtra = intent.getStringExtra(USER_ID);
        String stringExtra2 = intent.getStringExtra(AUTH_CODE);
        if (SdkUtils.isBlank(stringExtra2) && !SdkUtils.isBlank(stringExtra)) {
            BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo = BoxAuthentication.getInstance().getStoredAuthInfo(this).get(stringExtra);
            if (boxAuthenticationInfo != null) {
                onAuthenticationChosen(boxAuthenticationInfo);
                return;
            } else {
                onAuthFailure(new OAuthWebView.AuthFailure(0, ""));
                return;
            }
        }
        if (SdkUtils.isBlank(stringExtra2)) {
            return;
        }
        startMakingOAuthAPICall(stringExtra2, null);
    }

    protected void startMakingOAuthAPICall(final String str, String str2) {
        if (this.apiCallStarted.getAndSet(true)) {
            return;
        }
        showSpinner();
        if (str2 != null) {
            this.mSession.getAuthInfo().setBaseDomain(str2);
            BoxLogUtils.logException("setting Base Domain", str2, new RuntimeException("base domain being used"));
        }
        new Thread(new Runnable() { // from class: com.box.androidsdk.content.auth.OAuthActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startMakingOAuthAPICall$1(str);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startMakingOAuthAPICall$1(String str) {
        try {
            BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo = BoxAuthentication.getInstance().create(this.mSession, str, this.mBoxPkce.getCodeVerifier()).get();
            String stringExtra = getIntent().getStringExtra("restrictToUserId");
            if (!SdkUtils.isEmptyString(stringExtra) && !boxAuthenticationInfo.getUser().getUserId().equals(stringExtra)) {
                throw new RuntimeException("Unexpected user logged in. Expected " + stringExtra + " received " + boxAuthenticationInfo.getUser().getUserId());
            }
            dismissSpinnerAndFinishAuthenticate(boxAuthenticationInfo);
        } catch (Exception e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            dismissSpinnerAndFailAuthenticate(e);
        }
    }

    protected void dismissSpinnerAndFinishAuthenticate(final BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo) {
        runOnUiThread(new Runnable() { // from class: com.box.androidsdk.content.auth.OAuthActivity.2
            @Override // java.lang.Runnable
            public void run() {
                OAuthActivity.this.dismissSpinner();
                Intent intent = new Intent();
                intent.putExtra("authinfo", boxAuthenticationInfo);
                OAuthActivity.this.setResult(-1, intent);
                OAuthActivity.this.mAuthWasSuccessful = true;
                OAuthActivity.this.finish();
            }
        });
    }

    protected void dismissSpinnerAndFailAuthenticate(Exception exc) {
        final OAuthWebView.AuthFailure authFailure = getAuthFailure(exc);
        runOnUiThread(new Runnable() { // from class: com.box.androidsdk.content.auth.OAuthActivity.3
            @Override // java.lang.Runnable
            public void run() {
                OAuthActivity.this.dismissSpinner();
                OAuthActivity.this.onAuthFailure(authFailure);
                OAuthActivity.this.setResult(0);
            }
        });
    }

    protected OAuthWebView createOAuthView() {
        OAuthWebView oAuthWebView = (OAuthWebView) findViewById(getOAuthWebViewRId());
        oAuthWebView.setVisibility(0);
        oAuthWebView.getSettings().setJavaScriptEnabled(true);
        oAuthWebView.getSettings().setSaveFormData(false);
        oAuthWebView.getSettings().setSavePassword(false);
        return oAuthWebView;
    }

    protected OAuthWebView.OAuthWebViewClient createOAuthWebViewClient() {
        return new OAuthWebView.OAuthWebViewClient(this, this.mRedirectUrl);
    }

    protected int getOAuthWebViewRId() {
        return R.id.oauthview;
    }

    protected Dialog showDialogWhileWaitingForAuthenticationAPICall() {
        return ProgressDialog.show(this, getText(R.string.boxsdk_Authenticating), getText(R.string.boxsdk_Please_wait));
    }

    protected synchronized void showSpinner() {
        try {
            Dialog dialog2 = dialog;
            if (dialog2 != null) {
                if (dialog2.isShowing()) {
                }
            } else {
                dialog = showDialogWhileWaitingForAuthenticationAPICall();
            }
        } catch (Exception unused) {
            dialog = null;
        }
    }

    protected synchronized void dismissSpinner() {
        Dialog dialog2 = dialog;
        if (dialog2 != null && dialog2.isShowing()) {
            try {
                dialog.dismiss();
            } catch (IllegalArgumentException unused) {
            }
            dialog = null;
        } else if (dialog != null) {
            dialog = null;
        }
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMDestroy() {
        unregisterReceiver(this.mConnectedReceiver);
        this.apiCallStarted.set(false);
        dismissSpinner();
        super.onMAMDestroy();
    }

    public static Intent createOAuthActivityIntent(Context context, String str, String str2, String str3, boolean z, boolean z2) {
        Intent intent = new Intent(context, (Class<?>) OAuthActivity.class);
        intent.putExtra("client_id", str);
        intent.putExtra("client_secret", str2);
        intent.putExtra(IS_APP_FEDRAMP_HIGH_COMPLIANT, z2);
        if (!SdkUtils.isEmptyString(str3)) {
            intent.putExtra("redirect_uri", str3);
        }
        intent.putExtra(LOGIN_VIA_BOX_APP, z);
        return intent;
    }

    public static Intent createOAuthActivityIntent(Context context, BoxSession boxSession, boolean z) {
        Intent intentCreateOAuthActivityIntent = createOAuthActivityIntent(context, boxSession.getClientId(), boxSession.getClientSecret(), boxSession.getRedirectUrl(), z, boxSession.isAppFedrampHighCompliant());
        intentCreateOAuthActivityIntent.putExtra("session", boxSession);
        if (!SdkUtils.isEmptyString(boxSession.getUserId())) {
            intentCreateOAuthActivityIntent.putExtra("restrictToUserId", boxSession.getUserId());
        }
        return intentCreateOAuthActivityIntent;
    }

    private OAuthWebView.AuthFailure getAuthFailure(Exception exc) {
        Throwable cause;
        BoxException boxException;
        BoxError asBoxError;
        String str;
        String string = getString(R.string.boxsdk_Authentication_fail);
        if (exc != null) {
            if (exc instanceof ExecutionException) {
                cause = exc;
                cause = ((ExecutionException) exc).getCause();
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
        CookieManager.getInstance().removeAllCookie();
        deleteDatabase("webview.db");
        deleteDatabase("webviewCache.db");
        File cacheDir = getCacheDir();
        SdkUtils.deleteFolderRecursive(cacheDir);
        cacheDir.mkdir();
    }
}
