package com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectoryb2c;

import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.providers.IdentityProvider;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Configuration;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;

/* JADX INFO: loaded from: classes14.dex */
public class AzureActiveDirectoryB2C extends IdentityProvider<AzureActiveDirectoryB2COAuth2Strategy, OAuth2Configuration> {
    @Override // com.microsoft.identity.common.java.providers.IdentityProvider
    public AzureActiveDirectoryB2COAuth2Strategy createOAuth2Strategy(OAuth2Configuration oAuth2Configuration, IPlatformComponents iPlatformComponents) {
        return new AzureActiveDirectoryB2COAuth2Strategy(oAuth2Configuration, OAuth2StrategyParameters.builder().platformComponents(iPlatformComponents).build());
    }
}
