package com.microsoft.identity.common.internal.ui.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import com.microsoft.identity.common.internal.providers.oauth2.AndroidAuthorizationStrategy;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationActivityFactory;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationActivityParameters;
import com.microsoft.identity.common.java.browser.Browser;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.providers.RawAuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.java.ui.AuthorizationAgent;
import com.microsoft.identity.common.java.util.ResultFuture;
import com.microsoft.identity.common.logging.Logger;
import java.net.URI;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes14.dex */
public abstract class BrowserAuthorizationStrategy<GenericOAuth2Strategy extends OAuth2Strategy, GenericAuthorizationRequest extends AuthorizationRequest> extends AndroidAuthorizationStrategy<GenericOAuth2Strategy, GenericAuthorizationRequest> {
    private static final String TAG = "BrowserAuthorizationStrategy";
    private GenericAuthorizationRequest mAuthorizationRequest;
    private ResultFuture<AuthorizationResult> mAuthorizationResultFuture;
    private final Browser mBrowser;
    private CustomTabsManager mCustomTabManager;
    private boolean mDisposed;
    private GenericOAuth2Strategy mOAuth2Strategy;

    protected abstract void setIntentFlag(Intent intent);

    public BrowserAuthorizationStrategy(Context context, Activity activity, Fragment fragment, Browser browser) {
        super(context, activity, fragment);
        this.mBrowser = browser;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.IAuthorizationStrategy
    public Future<AuthorizationResult> requestAuthorization(GenericAuthorizationRequest genericauthorizationrequest, GenericOAuth2Strategy genericoauth2strategy) throws ClientException {
        Intent intent;
        String str = TAG + ":requestAuthorization";
        checkNotDisposed();
        Context applicationContext = getApplicationContext();
        this.mOAuth2Strategy = genericoauth2strategy;
        this.mAuthorizationRequest = genericauthorizationrequest;
        this.mAuthorizationResultFuture = new ResultFuture<>();
        if (this.mBrowser.isCustomTabsServiceSupported()) {
            Logger.info(str, "CustomTabsService is supported.");
            CustomTabsManager customTabsManager = new CustomTabsManager(applicationContext);
            this.mCustomTabManager = customTabsManager;
            if (!customTabsManager.bind(applicationContext, this.mBrowser.getPackageName())) {
                intent = new Intent("android.intent.action.VIEW");
                intent.setPackage(this.mBrowser.getPackageName());
            } else {
                intent = this.mCustomTabManager.getCustomTabsIntent().intent;
            }
        } else {
            Logger.warn(str, "CustomTabsService is NOT supported");
            intent = new Intent("android.intent.action.VIEW");
            intent.setPackage(this.mBrowser.getPackageName());
        }
        URI authorizationRequestAsHttpRequest = genericauthorizationrequest.getAuthorizationRequestAsHttpRequest();
        intent.setData(Uri.parse(authorizationRequestAsHttpRequest.toString()));
        launchIntent(buildAuthorizationActivityStartIntent(intent, authorizationRequestAsHttpRequest));
        return this.mAuthorizationResultFuture;
    }

    private Intent buildAuthorizationActivityStartIntent(Intent intent, URI uri) {
        Intent authorizationActivityIntent = AuthorizationActivityFactory.getAuthorizationActivityIntent(new AuthorizationActivityParameters(getApplicationContext(), intent, uri.toString(), this.mAuthorizationRequest.getBrkRedirectUri() != null ? this.mAuthorizationRequest.getBrkRedirectUri() : this.mAuthorizationRequest.getRedirectUri(), this.mAuthorizationRequest.getRequestHeaders(), AuthorizationAgent.BROWSER));
        setIntentFlag(authorizationActivityIntent);
        return authorizationActivityIntent;
    }

    private void checkNotDisposed() {
        if (this.mDisposed) {
            throw new IllegalStateException("Service has been disposed and rendered inoperable");
        }
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.IAuthorizationStrategy
    public void completeAuthorization(int i, RawAuthorizationResult rawAuthorizationResult) {
        String str = TAG + ":completeAuthorization";
        if (i == 1001) {
            dispose();
            this.mAuthorizationResultFuture.setResult(this.mOAuth2Strategy.getAuthorizationResultFactory().createAuthorizationResult(rawAuthorizationResult, this.mAuthorizationRequest));
            return;
        }
        Logger.warnPII(str, "Unknown request code " + i);
    }

    public void dispose() {
        if (this.mDisposed) {
            return;
        }
        CustomTabsManager customTabsManager = this.mCustomTabManager;
        if (customTabsManager != null) {
            customTabsManager.unbind();
        }
        this.mDisposed = true;
    }
}
