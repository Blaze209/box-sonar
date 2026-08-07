package com.microsoft.identity.common.internal.providers.microsoft.activedirectoryfederationservices;

import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.providers.IdentityProvider;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Configuration;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;

/* JADX INFO: loaded from: classes14.dex */
public class ActiveDirectoryFederationServices2012R2 extends IdentityProvider<ActiveDirectoryFederationServices2012R2OAuth2Strategy, OAuth2Configuration> {
    @Override // com.microsoft.identity.common.java.providers.IdentityProvider
    public ActiveDirectoryFederationServices2012R2OAuth2Strategy createOAuth2Strategy(OAuth2Configuration oAuth2Configuration, IPlatformComponents iPlatformComponents) {
        return new ActiveDirectoryFederationServices2012R2OAuth2Strategy(oAuth2Configuration, OAuth2StrategyParameters.builder().platformComponents(iPlatformComponents).build());
    }
}
