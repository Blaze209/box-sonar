package com.microsoft.identity.common.java.providers.microsoft.microsoftsts;

import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.providers.IdentityProvider;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;

/* JADX INFO: loaded from: classes14.dex */
public class MicrosoftSts extends IdentityProvider<MicrosoftStsOAuth2Strategy, MicrosoftStsOAuth2Configuration> {
    @Override // com.microsoft.identity.common.java.providers.IdentityProvider
    public MicrosoftStsOAuth2Strategy createOAuth2Strategy(MicrosoftStsOAuth2Configuration microsoftStsOAuth2Configuration, IPlatformComponents iPlatformComponents) throws ClientException {
        if (microsoftStsOAuth2Configuration == null) {
            throw new NullPointerException("config is marked non-null but is null");
        }
        if (iPlatformComponents == null) {
            throw new NullPointerException("commonComponents is marked non-null but is null");
        }
        return new MicrosoftStsOAuth2Strategy(microsoftStsOAuth2Configuration, OAuth2StrategyParameters.builder().platformComponents(iPlatformComponents).build());
    }
}
