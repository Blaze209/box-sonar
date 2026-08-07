package com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory;

import com.microsoft.identity.common.java.providers.microsoft.MicrosoftRefreshToken;

/* JADX INFO: loaded from: classes14.dex */
public class AzureActiveDirectoryRefreshToken extends MicrosoftRefreshToken {
    public AzureActiveDirectoryRefreshToken(AzureActiveDirectoryTokenResponse azureActiveDirectoryTokenResponse) {
        super(azureActiveDirectoryTokenResponse);
        if (azureActiveDirectoryTokenResponse == null) {
            throw new NullPointerException("response is marked non-null but is null");
        }
    }
}
