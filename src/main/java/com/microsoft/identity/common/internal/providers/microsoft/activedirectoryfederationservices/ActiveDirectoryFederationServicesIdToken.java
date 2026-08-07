package com.microsoft.identity.common.internal.providers.microsoft.activedirectoryfederationservices;

import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class ActiveDirectoryFederationServicesIdToken extends IDToken {
    public ActiveDirectoryFederationServicesIdToken(String str) throws ServiceException {
        super(str);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.IDToken
    public Map<String, ?> getTokenClaims() {
        return super.getTokenClaims();
    }
}
