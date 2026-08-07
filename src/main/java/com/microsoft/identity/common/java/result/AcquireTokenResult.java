package com.microsoft.identity.common.java.result;

import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.TokenResult;

/* JADX INFO: loaded from: classes14.dex */
public class AcquireTokenResult {
    private AuthorizationResult mAuthorizationResult;
    private ILocalAuthenticationResult mLocalAuthenticationResult;
    private Boolean mSucceeded = false;
    private TokenResult mTokenResult;

    public void setLocalAuthenticationResult(ILocalAuthenticationResult iLocalAuthenticationResult) {
        this.mLocalAuthenticationResult = iLocalAuthenticationResult;
        this.mSucceeded = true;
    }

    public ILocalAuthenticationResult getLocalAuthenticationResult() {
        return this.mLocalAuthenticationResult;
    }

    public TokenResult getTokenResult() {
        return this.mTokenResult;
    }

    public void setTokenResult(TokenResult tokenResult) {
        this.mTokenResult = tokenResult;
    }

    public AuthorizationResult getAuthorizationResult() {
        return this.mAuthorizationResult;
    }

    public void setAuthorizationResult(AuthorizationResult authorizationResult) {
        this.mAuthorizationResult = authorizationResult;
    }

    public Boolean getSucceeded() {
        return this.mSucceeded;
    }
}
