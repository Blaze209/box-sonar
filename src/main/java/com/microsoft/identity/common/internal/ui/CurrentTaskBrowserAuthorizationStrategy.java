package com.microsoft.identity.common.internal.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.microsoft.identity.common.internal.ui.browser.BrowserAuthorizationStrategy;
import com.microsoft.identity.common.java.browser.Browser;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;

/* JADX INFO: loaded from: classes14.dex */
public class CurrentTaskBrowserAuthorizationStrategy<GenericOAuth2Strategy extends OAuth2Strategy, GenericAuthorizationRequest extends AuthorizationRequest> extends BrowserAuthorizationStrategy<GenericOAuth2Strategy, GenericAuthorizationRequest> {
    @Override // com.microsoft.identity.common.internal.ui.browser.BrowserAuthorizationStrategy
    protected void setIntentFlag(Intent intent) {
    }

    public CurrentTaskBrowserAuthorizationStrategy(Context context, Activity activity, Fragment fragment, Browser browser) {
        super(context, activity, fragment, browser);
    }
}
