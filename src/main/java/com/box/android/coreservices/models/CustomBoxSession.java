package com.box.android.coreservices.models;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import com.box.android.coreservices.modelcontroller.MoCoBoxGlobalSettings;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.auth.BoxAuthentication;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxSharedLinkSession;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.io.File;

/* JADX INFO: loaded from: classes9.dex */
public class CustomBoxSession extends BoxSharedLinkSession {
    private Exception debuggingException;
    private boolean mExternalTriggered;
    private transient IntentServices mIntentServices;
    private boolean mShouldUseWelcomeTour;
    private boolean mUseRegisterWebview;

    public CustomBoxSession(BoxSession boxSession) {
        super(boxSession);
    }

    public CustomBoxSession(Context context, boolean z) {
        super(context, z);
    }

    public CustomBoxSession(Context context, String str, String str2, String str3, String str4, boolean z) {
        super(context, str, str2, str3, str4, z);
        if (SdkUtils.isBlank(str)) {
            this.debuggingException = new RuntimeException("userId constructed blank ");
        }
    }

    public void setIntentServices(IntentServices intentServices) {
        this.mIntentServices = intentServices;
    }

    @Override // com.box.androidsdk.content.models.BoxSession
    public void startAuthenticationUI() {
        String str;
        IntentServices intentServices = this.mIntentServices;
        if (intentServices == null) {
            throw new IllegalStateException("IntentServices instance was not set!");
        }
        if (this.mShouldUseWelcomeTour) {
            getApplicationContext().startActivity(this.mIntentServices.startScreenActivityIntent("CustomBoxSession"));
            return;
        }
        if (!this.mExternalTriggered) {
            str = BoxAnalyticsParams.FLOW_SWITCH_USER;
        } else {
            str = BoxAnalyticsParams.FLOW_EXTERNAL_LOGIN;
        }
        Intent intentCreateOAuthActivityIntent = intentServices.createOAuthActivityIntent(getApplicationContext(), this, null, str, null);
        intentCreateOAuthActivityIntent.setFlags(335544320);
        getApplicationContext().startActivity(intentCreateOAuthActivityIntent);
    }

    @Override // com.box.androidsdk.content.models.BoxSession, com.box.androidsdk.content.auth.BoxAuthentication.AuthListener
    public void onAuthFailure(BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo, Exception exc) {
        if (exc != null) {
            if (boxAuthenticationInfo == null) {
                BoxAmplitudeAnalytics.createBackgroundEventPropertyBuilder().setError(exc).logEvent(BoxAnalyticsParams.EVENT_ACCESS_TOKEN_CREATE_ERROR);
            } else {
                BoxAmplitudeAnalytics.createBackgroundEventPropertyBuilder().setError(exc).setPageExperience(getRefreshFailureAnalyticString(exc)).logEvent(BoxAnalyticsParams.EVENT_ACCESS_TOKEN_REFRESH_ERROR);
            }
        }
        super.onAuthFailure(boxAuthenticationInfo, exc);
    }

    private String getRefreshFailureAnalyticString(Exception exc) {
        if (!(exc instanceof BoxException)) {
            return "not handled refresh failure";
        }
        BoxException boxException = (BoxException) exc;
        if (suppressesAuthErrorUIAfterLogin()) {
            return "ui suppressed";
        }
        if ((boxException instanceof BoxException.RefreshFailure) && ((BoxException.RefreshFailure) boxException).isErrorFatal()) {
            return "fatal refresh failure";
        }
        if (boxException.getErrorType() == BoxException.ErrorType.TERMS_OF_SERVICE_REQUIRED) {
            return "terms of service required";
        }
        return "no ui other refresh failure";
    }

    public void startAuthenticationUI(String str, String str2) {
        IntentServices intentServices = this.mIntentServices;
        if (intentServices == null) {
            return;
        }
        Intent intentCreateOAuthActivityIntent = intentServices.createOAuthActivityIntent(getApplicationContext(), this, null, str, str2);
        intentCreateOAuthActivityIntent.setFlags(335544320);
        getApplicationContext().startActivity(intentCreateOAuthActivityIntent);
    }

    public void setUseWelcomeTour(boolean z) {
        this.mShouldUseWelcomeTour = z;
    }

    public void setUseRegisterWebview(boolean z) {
        this.mUseRegisterWebview = z;
    }

    public void setTriggeredByExternalLink() {
        this.mExternalTriggered = true;
    }

    public boolean getUseRegisterWebview() {
        return this.mUseRegisterWebview;
    }

    @Override // com.box.androidsdk.content.models.BoxSession
    public BoxFutureTask<BoxSession> authenticate() {
        if (SdkUtils.isBlank(getUserId()) && this.mAuthInfo != null && !SdkUtils.isBlank(this.mAuthInfo.accessToken())) {
            try {
                throw new RuntimeException("CustomBoxSession. no userId. has user? " + (this.mAuthInfo.getUser() != null));
            } catch (Exception e) {
                BoxLogUtils.e(MoCoBoxGlobalSettings.class.getName(), e);
            }
        }
        return super.authenticate();
    }

    public BoxFutureTask<BoxSession> authenticate(BoxFutureTask.OnCompletedListener<BoxSession> onCompletedListener) {
        if (SdkUtils.isBlank(getUserId()) && this.mAuthInfo != null && !SdkUtils.isBlank(this.mAuthInfo.accessToken())) {
            try {
                throw new RuntimeException("CustomBoxSession. no userId. has user? " + (this.mAuthInfo.getUser() != null));
            } catch (Exception e) {
                BoxLogUtils.e(MoCoBoxGlobalSettings.class.getName(), e);
            }
        }
        return super.authenticate(getApplicationContext(), onCompletedListener);
    }

    @Override // com.box.androidsdk.content.models.BoxSession
    public void setUserId(String str) {
        super.setUserId(str);
        if (SdkUtils.isBlank(str)) {
            this.debuggingException = new RuntimeException("userId set to null ");
        } else {
            this.debuggingException = null;
        }
    }

    public Exception getDebuggingException() {
        return this.debuggingException;
    }

    @Override // com.box.androidsdk.content.models.BoxSession
    public File getCacheDir() {
        if (SdkUtils.isBlank(getUserId())) {
            return new File(getApplicationContext().getFilesDir(), "unknown");
        }
        return super.getCacheDir();
    }

    @Override // com.box.androidsdk.content.models.BoxSession
    public void setAuthInfo(BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo) {
        super.setAuthInfo(boxAuthenticationInfo);
    }

    public void setClientId(String str) {
        this.mClientId = str;
    }

    public void setClientSecret(String str) {
        this.mClientSecret = str;
    }

    @Override // com.box.androidsdk.content.models.BoxSession
    public String getUserAgent() {
        StringBuilder sb = new StringBuilder();
        Context applicationContext = getApplicationContext();
        sb.append(applicationContext.getPackageName() + '/');
        try {
            sb.append(MAMPackageManagement.getPackageInfo(applicationContext.getPackageManager(), applicationContext.getPackageName(), 0).versionName + AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER);
        } catch (PackageManager.NameNotFoundException unused) {
            sb.append("0.0.0;");
        }
        sb.append("Android/" + Build.VERSION.RELEASE + AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER);
        sb.append(Build.MANUFACTURER + "/" + Build.MODEL);
        return sb.toString();
    }
}
