package com.microsoft.identity.client;

import com.microsoft.identity.common.java.result.ILocalAuthenticationResult;

/* JADX INFO: loaded from: classes14.dex */
public class TokenParametersAdapter {
    public static AcquireTokenSilentParameters silentParametersFromInteractive(AcquireTokenParameters acquireTokenParameters, ILocalAuthenticationResult iLocalAuthenticationResult) {
        return new AcquireTokenSilentParameters.Builder().withCallback(acquireTokenParameters.getCallback()).fromAuthority(acquireTokenParameters.getAuthority()).withClaims(acquireTokenParameters.getClaimsRequest()).withScopes(acquireTokenParameters.getScopes()).forAccount(AccountAdapter.adapt(iLocalAuthenticationResult.getCacheRecordWithTenantProfileData()).get(0)).build();
    }
}
