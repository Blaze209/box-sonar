package com.microsoft.identity.common.internal.ui.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.microsoft.identity.common.internal.providers.oauth2.AndroidAuthorizationStrategy;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationActivityFactory;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationActivityParameters;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.providers.RawAuthorizationResult;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationRequest;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.java.ui.AuthorizationAgent;
import com.microsoft.identity.common.java.util.ResultFuture;
import com.microsoft.identity.common.logging.Logger;
import java.net.URI;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes14.dex */
public class EmbeddedWebViewAuthorizationStrategy<GenericOAuth2Strategy extends OAuth2Strategy, GenericAuthorizationRequest extends AuthorizationRequest> extends AndroidAuthorizationStrategy<GenericOAuth2Strategy, GenericAuthorizationRequest> {
    private static final String TAG = "EmbeddedWebViewAuthorizationStrategy";
    private GenericAuthorizationRequest mAuthorizationRequest;
    private ResultFuture<AuthorizationResult> mAuthorizationResultFuture;
    private GenericOAuth2Strategy mOAuth2Strategy;

    public EmbeddedWebViewAuthorizationStrategy(Context context, Activity activity, Fragment fragment) {
        super(context, activity, fragment);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.IAuthorizationStrategy
    public Future<AuthorizationResult> requestAuthorization(GenericAuthorizationRequest genericauthorizationrequest, GenericOAuth2Strategy genericoauth2strategy) throws ClientException {
        String libraryName;
        String libraryVersion;
        String str = TAG + ":requestAuthorization";
        this.mAuthorizationResultFuture = new ResultFuture<>();
        this.mOAuth2Strategy = genericoauth2strategy;
        this.mAuthorizationRequest = genericauthorizationrequest;
        Logger.info(str, "Perform the authorization request with embedded webView.");
        URI authorizationRequestAsHttpRequest = genericauthorizationrequest.getAuthorizationRequestAsHttpRequest();
        GenericAuthorizationRequest genericauthorizationrequest2 = this.mAuthorizationRequest;
        if (genericauthorizationrequest2 instanceof MicrosoftAuthorizationRequest) {
            libraryName = ((MicrosoftAuthorizationRequest) genericauthorizationrequest2).getLibraryName();
            libraryVersion = ((MicrosoftAuthorizationRequest) this.mAuthorizationRequest).getLibraryVersion();
        } else {
            libraryName = null;
            libraryVersion = null;
        }
        GenericAuthorizationRequest genericauthorizationrequest3 = this.mAuthorizationRequest;
        launchIntent(buildAuthorizationActivityStartIntent(authorizationRequestAsHttpRequest, libraryName, libraryVersion, genericauthorizationrequest3 instanceof MicrosoftStsAuthorizationRequest ? ((MicrosoftStsAuthorizationRequest) genericauthorizationrequest3).getUtid() : null));
        return this.mAuthorizationResultFuture;
    }

    private Intent buildAuthorizationActivityStartIntent(URI uri, String str, String str2, String str3) {
        return AuthorizationActivityFactory.getAuthorizationActivityIntent(new AuthorizationActivityParameters(getApplicationContext(), null, uri.toString(), this.mAuthorizationRequest.getBrkRedirectUri() != null ? this.mAuthorizationRequest.getBrkRedirectUri() : this.mAuthorizationRequest.getRedirectUri(), this.mAuthorizationRequest.getRequestHeaders(), AuthorizationAgent.WEBVIEW, this.mAuthorizationRequest.isWebViewZoomEnabled(), this.mAuthorizationRequest.isWebViewZoomControlsEnabled(), str, str2, str3));
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.IAuthorizationStrategy
    public void completeAuthorization(int i, RawAuthorizationResult rawAuthorizationResult) {
        String str = TAG + ":completeAuthorization";
        if (i == 1001) {
            GenericOAuth2Strategy genericoauth2strategy = this.mOAuth2Strategy;
            if (genericoauth2strategy == null || this.mAuthorizationResultFuture == null) {
                Logger.warn(str, "SDK Cancel triggering before request is sent out. Potentially due to an stale activity state, oAuth2Strategy null ? [" + (this.mOAuth2Strategy == null) + "]mAuthorizationResultFuture ? [" + (this.mAuthorizationResultFuture == null) + "]");
                return;
            } else {
                this.mAuthorizationResultFuture.setResult(genericoauth2strategy.getAuthorizationResultFactory().createAuthorizationResult(rawAuthorizationResult, this.mAuthorizationRequest));
                return;
            }
        }
        Logger.warnPII(str, "Unknown request code " + i);
    }
}
