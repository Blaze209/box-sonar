package com.box.android.activities.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import androidx.fragment.app.FragmentTransaction;
import com.box.android.R;
import com.box.android.activities.RefreshDialogActivity;
import com.box.android.activities.SwitchAccountActivity;
import com.box.android.activities.SwitchingAccountDialogActivity;
import com.box.android.application.BoxBaseApplication;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.base.presentation.views.BoxSDKOAuthWebView;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.Connectivity;
import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import com.box.android.domain.configuration.BoxConfigConstants;
import com.box.android.domain.configuration.ConfigManager;
import com.box.android.domain.services.IForceUpdateCoordinator;
import com.box.android.fragments.ChooseAuthenticationFragment;
import com.box.android.utilities.notificationmanager.BoxNotificationHelper;
import com.box.androidsdk.content.auth.BoxAuthentication;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes9.dex */
public class BoxThirdPartyAuthenticatorActivity extends Hilt_BoxThirdPartyAuthenticatorActivity implements ChooseAuthenticationFragment.OnAuthenticationChosen, BoxSDKOAuthWebView.AuthListener {
    private static final String AUTH_CHOOSE_TAG = "chooseAuth";
    private static final String EXTRA_AUTH_CODE = "authcode";
    private static final String EXTRA_STATE_TOKEN = "stateToken";
    private static final String EXTRA_USER_ID = "userId";
    private static final String URL_QUERY_LOGIN = "box_login";

    @Inject
    protected IForceUpdateCoordinator forceUpdateCoordinator;
    private BoxAuthentication.BoxAuthenticationInfo mAuthInfo;

    @Inject
    protected IMoCoBoxGlobalSettings mGlobalSettings;
    private String mStateToken;
    private BoxSDKOAuthWebView mWebView;

    @Override // com.box.android.activities.login.Hilt_BoxThirdPartyAuthenticatorActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        IForceUpdateCoordinator iForceUpdateCoordinator = this.forceUpdateCoordinator;
        if (iForceUpdateCoordinator != null) {
            iForceUpdateCoordinator.enforceIfNeeded();
        }
        String str = this.mStateToken;
        if (str == null && bundle == null) {
            this.mStateToken = BoxSDKOAuthWebView.generateStateToken();
        } else if (str == null) {
            this.mStateToken = bundle.getString(EXTRA_STATE_TOKEN);
            this.mAuthInfo = (BoxAuthentication.BoxAuthenticationInfo) bundle.getSerializable(AUTH_CHOOSE_TAG);
        }
        String stringExtra = getIntent().getStringExtra("client_id");
        String stringExtra2 = getIntent().getStringExtra("redirect_uri");
        String stringExtra3 = getIntent().getStringExtra("restrictToUserId");
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("boxusers");
        List<BoxAuthentication.BoxAuthenticationInfo> combinedUsers = ChooseAuthenticationFragment.getCombinedUsers(this.mGlobalSettings, stringArrayListExtra, stringExtra);
        setContentView(R.layout.boxsdk_auth_lite);
        BoxSDKOAuthWebView boxSDKOAuthWebView = (BoxSDKOAuthWebView) findViewById(R.id.oauthview);
        this.mWebView = boxSDKOAuthWebView;
        boxSDKOAuthWebView.setWebViewClient(new BoxSDKOAuthWebView.OAuthWebViewClient(this, stringExtra2, this.mStateToken));
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        if (StringUtils.isNotBlank(stringExtra3)) {
            Iterator<BoxAuthentication.BoxAuthenticationInfo> it = combinedUsers.iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (it.next().getUser().getUserId().equals(stringExtra3)) {
                    z = true;
                }
            }
            if (z) {
                switchToUserId(stringExtra3);
                return;
            } else {
                authorizeWebView(null);
                return;
            }
        }
        if (combinedUsers == null || combinedUsers.size() < 1) {
            onDifferentAuthenticationChosen();
            return;
        }
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.oauth_container, ChooseAuthenticationFragment.createChooseAuthenticationFragment(this, stringArrayListExtra, stringExtra), AUTH_CHOOSE_TAG);
        fragmentTransactionBeginTransaction.addToBackStack(AUTH_CHOOSE_TAG);
        fragmentTransactionBeginTransaction.commit();
    }

    @Override // androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMResume() {
        super.onMAMResume();
        amplitudeSetCurrentPage();
    }

    @Override // com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMSaveInstanceState(Bundle bundle) {
        bundle.putString(EXTRA_STATE_TOKEN, this.mStateToken);
        bundle.putSerializable(AUTH_CHOOSE_TAG, this.mAuthInfo);
        super.onMAMSaveInstanceState(bundle);
    }

    private void switchToUserId(String str) {
        SwitchAccountActivity.softSwitchWithOptionalWarning(str, this, new SwitchAccountActivity.AccountSwitchable() { // from class: com.box.android.activities.login.BoxThirdPartyAuthenticatorActivity.1
            /* JADX WARN: Type inference failed for: r0v0, types: [com.box.android.activities.login.BoxThirdPartyAuthenticatorActivity$1$1] */
            @Override // com.box.android.activities.SwitchAccountActivity.AccountSwitchable
            public void softSwitchTo(final String str2) {
                new Thread() { // from class: com.box.android.activities.login.BoxThirdPartyAuthenticatorActivity.1.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        BoxThirdPartyAuthenticatorActivity.this.startActivityForResult(SwitchingAccountDialogActivity.newIntent(BoxThirdPartyAuthenticatorActivity.this, str2), 301);
                    }
                }.start();
            }
        });
    }

    @Override // com.box.android.fragments.ChooseAuthenticationFragment.OnAuthenticationChosen
    public void onAuthenticationChosen(BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo) {
        this.mAuthInfo = boxAuthenticationInfo;
        boolean z = boxAuthenticationInfo.getUser() != null;
        if (z && boxAuthenticationInfo.accessToken() != null) {
            switchToUserId(boxAuthenticationInfo.getUser().getUserId());
            return;
        }
        if (z && StringUtils.isNotBlank(boxAuthenticationInfo.getUser().getUserId())) {
            Intent intent = new Intent(getPackageName() + ".authenticated");
            intent.putExtra("userId", boxAuthenticationInfo.getUser().getUserId());
            setResult(-1, intent);
            finish();
            return;
        }
        authorizeWebView(null);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (getSupportFragmentManager().findFragmentByTag(AUTH_CHOOSE_TAG) != null) {
            setResult(0);
            finish();
        } else {
            super.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMActivityResult(int i, int i2, Intent intent) {
        super.onMAMActivityResult(i, i2, intent);
        if (i != 301) {
            if (i == 200) {
                if (i2 == -1 && intent != null) {
                    authorizeWebView(intent.getStringExtra(RefreshDialogActivity.EXTRA_ACCESS_TOKEN));
                    return;
                } else {
                    authorizeWebView(null);
                    return;
                }
            }
            return;
        }
        if (getSupportFragmentManager().findFragmentByTag(AUTH_CHOOSE_TAG) != null) {
            getSupportFragmentManager().popBackStack();
        }
        if (i2 == -1 && intent != null) {
            startActivityForResult(new Intent(this, (Class<?>) RefreshDialogActivity.class), 200);
        } else if (i2 == 100) {
            BoxNotificationHelper.displayDialog(R.string.Feature_disabled, R.string.intune_not_supported_multi_user);
        }
    }

    private void authorizeWebView(String str) {
        HashMap map = new HashMap();
        if (StringUtils.isNotBlank(str)) {
            map.put("Authorization", "Bearer " + str);
        }
        this.mWebView.loadUrl(buildUrl(getIntent().getStringExtra("client_id"), getIntent().getStringExtra("redirect_uri"), this.mStateToken), map);
    }

    private String buildUrl(String str, String str2, String str3) {
        Uri.Builder builder = new Uri.Builder();
        ConfigManager configManager = BoxBaseApplication.getInstance().getConfigManager();
        builder.scheme(configManager.getString(BoxConfigConstants.CONFIG_KEY_V2_API_URL_SCHEME));
        builder.authority(configManager.getString(BoxConfigConstants.CONFIG_KEY_OAUTH_URL_AUTHORITY));
        builder.path(configManager.getArray(BoxConfigConstants.CONFIG_KEY_FALLBACK_PATHS_ARRAY)[0]);
        builder.appendQueryParameter("client_id", str);
        builder.appendQueryParameter("redirect_uri", str2);
        builder.appendQueryParameter("state", str3);
        builder.appendQueryParameter("response_type", "code");
        BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo = this.mAuthInfo;
        if (boxAuthenticationInfo != null) {
            String name = boxAuthenticationInfo.getUser().getUserName();
            if (StringUtils.isNotBlank(name)) {
                builder.appendQueryParameter(URL_QUERY_LOGIN, name);
            }
        }
        return builder.build().toString();
    }

    @Override // com.box.android.fragments.ChooseAuthenticationFragment.OnAuthenticationChosen
    public void onDifferentAuthenticationChosen() {
        if (getSupportFragmentManager().findFragmentByTag(AUTH_CHOOSE_TAG) != null) {
            getSupportFragmentManager().popBackStack();
        }
        this.mWebView.loadUrl(buildUrl(getIntent().getStringExtra("client_id"), getIntent().getStringExtra("redirect_uri"), this.mStateToken));
    }

    @Override // com.box.android.base.presentation.views.BoxSDKOAuthWebView.AuthListener
    public void onAuthFailure(BoxSDKOAuthWebView.AuthFailure authFailure) {
        int i;
        BoxLogUtils.e(BoxThirdPartyAuthenticatorActivity.class.getName(), authFailure.type + " : " + authFailure.message);
        if (authFailure.type == 2 && (((i = Integer.parseInt(authFailure.message)) == -6 || i == -2) && !Connectivity.isConnected())) {
            BoxPresentationUtils.displayToast(R.string.check_connection_try_again, this, new String[0]);
        } else if (authFailure.message != null) {
            BoxPresentationUtils.displayToast(authFailure.message, this);
        } else {
            BoxPresentationUtils.displayToast(R.string.err_unknown, this, new String[0]);
        }
        setResult(0);
        finish();
    }

    @Override // com.box.android.base.presentation.views.BoxSDKOAuthWebView.AuthListener
    public void onReceivedAuthCode(String str) {
        Intent intent = new Intent(getPackageName() + ".authenticated");
        intent.putExtra("authcode", str);
        setResult(-1, intent);
        finish();
    }

    @Override // android.app.Activity
    public void finish() {
        clearCachedAuthenticationData();
        super.finish();
    }

    private void clearCachedAuthenticationData() {
        BoxSDKOAuthWebView boxSDKOAuthWebView = this.mWebView;
        if (boxSDKOAuthWebView != null) {
            boxSDKOAuthWebView.clearCache(true);
            boxSDKOAuthWebView.clearFormData();
            boxSDKOAuthWebView.clearHistory();
        }
        CookieSyncManager.createInstance(this);
        CookieManager.getInstance().removeAllCookie();
        deleteDatabase("webview.db");
        deleteDatabase("webviewCache.db");
        File cacheDir = getCacheDir();
        CommonBoxUtil.deleteFolderRecursive(cacheDir);
        cacheDir.mkdir();
    }
}
