package com.microsoft.identity.common.java.authorities;

import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;

/* JADX INFO: loaded from: classes14.dex */
public class ActiveDirectoryFederationServicesAuthority extends Authority {
    ActiveDirectoryFederationServicesAuthority(String str) {
        this.mAuthorityUrlString = str;
    }

    @Override // com.microsoft.identity.common.java.authorities.Authority
    public OAuth2Strategy createOAuth2Strategy(OAuth2StrategyParameters oAuth2StrategyParameters) {
        if (oAuth2StrategyParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        throw new UnsupportedOperationException();
    }
}
