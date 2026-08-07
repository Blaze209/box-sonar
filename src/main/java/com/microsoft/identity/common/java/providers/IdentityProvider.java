package com.microsoft.identity.common.java.providers;

import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Configuration;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;

/* JADX INFO: loaded from: classes14.dex */
public abstract class IdentityProvider<T extends OAuth2Strategy, U extends OAuth2Configuration> {
    public abstract T createOAuth2Strategy(U u, IPlatformComponents iPlatformComponents) throws ClientException;
}
